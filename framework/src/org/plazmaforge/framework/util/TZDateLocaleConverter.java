package org.plazmaforge.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * The DateLocaleConverter with TimeZone
 * 
 * @author ohapon
 *
 */

public class TZDateLocaleConverter extends DateLocaleConverter {

    private static Log log = LogFactory.getLog(DateLocaleConverter.class);

    private TimeZone timeZone;

    public TZDateLocaleConverter(TimeZone timeZone) {
	super();

	this.timeZone = timeZone;
    }

    // OHA: Duplicate super method. Why?
    protected Object parse(Object value, String pattern) throws ParseException {
	SimpleDateFormat formatter = getFormatter(pattern, locale);
	if (pattern != null) {
	    if (locPattern) {
		formatter.applyLocalizedPattern(pattern);
	    } else {
		formatter.applyPattern(pattern);
	    }
	}
	return formatter.parse((String) value);
    }

    private SimpleDateFormat getFormatter(String pattern, Locale locale) {
	if (pattern == null) {
	    pattern = locPattern ? new SimpleDateFormat().toLocalizedPattern() : new SimpleDateFormat().toPattern();
	    log.warn("Null pattern was provided, defaulting to: " + pattern);
	}
	SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
	if (timeZone != null) {
	    format.setTimeZone(timeZone);
	}
	format.setLenient(isLenient());
	return format;
    }

}
