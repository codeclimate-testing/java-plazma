/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.framework.datawarehouse.convert;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.datawarehouse.TransferEnvironment;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.SystemInfo;
import org.plazmaforge.framework.util.ValueConverter;
import org.plazmaforge.framework.util.StringUtils;

public abstract class AbstractConverter implements IConverter {


    protected final Logger logger = Logger.getLogger(getClass());
    
    /**
     * Null value
     */
    public static final String NULL_VALUE = "NULL";
    
    /**
     * Empty value
     */
    public static final String EMPTY_VALUE = "";

    /**
     * Default line delimiter
     */
    public static final String DEFAULT_LINE_DELIMITER = SystemInfo.isWindows ? "\r\n" : "\n";

    
    /**
     * Default field delimiter
     */
    public static final String DEFAULT_FIELD_DELIMITER = ";";

    /**
     * Default record delimiter
     */
    public static final String DEFAULT_RECORD_DELIMITER = DEFAULT_LINE_DELIMITER;
    
    
    // DEFAULT CONVERT PATTERN
    
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    
    public static final String DEFAULT_NUMBER_PATTERN = "###0.###";
    
    
    
    
    private DSDataSet dataSet;
        
    private String dataSetName;

    ////
    
    private String fileName;
    
    private String encoding;
    
    ////

    private String fieldDelimiter;
    
    private String recordDelimiter;

    private String nullValue;

    private boolean includeHeaders;
    
    private boolean quoteText;

    private boolean trim;
    

    ////
    
    private String datePattern;
    
    private String timePattern;
    
    private String timestampPattern;
    
    private String numberPattern; 


    ////

    private DateFormat dateFormat;
    
    private DateFormat timeFormat;
    
    private DateFormat timestampFormat;
    
    private NumberFormat numberFormat; 
    
    private NumberFormat integerFormat;

    private Map<Integer, NumberFormat> decimalFormatMap = new HashMap<Integer, NumberFormat>(); 
    
    
    //// Flag
    
    private boolean processingStarted;
    
    ////
    
    private ITransferService transferService;
    
    private ISourceService sourceService;
    
    ////
    
    private ValueConverter valueConverter;
    
    private IConfigurer configurer;
    
    ////
    
    private Locale locale;
    
    private TimeZone timeZone;
    
    ////
    


    ////
    
    private Map<String, Class> classMap = new HashMap<String, Class>();
    
    private TransferResult transferResult = new TransferResult();
    
    
    /**
     * Initialize 
     */
    public void init() {
	
    }

    protected boolean isValid() {
	return true;
    }

    public DSDataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DSDataSet dataSet) {
        this.dataSet = dataSet;
    }

    
    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    protected String getDataSetDisplayName() {
	if (getDataSet() == null) {
	    return getDataSetName() == null ? EMPTY_VALUE : getDataSetName();
	}
	String name = getDataSet().getName();
	if (name == null) {
	    return getDataSetName() == null ? EMPTY_VALUE : getDataSetName();
	}
	return name;
    }

    
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    public String getEncoding() {
	if (isEmpty(encoding)) {
	    //encoding = System.getProperty("file.encoding");
	    return null;
	}
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    protected String getFileEncoding() {
	return getEncoding();
    }
    
    
    public String getFieldDelimiter() {
	if (fieldDelimiter == null) {
	    return DEFAULT_FIELD_DELIMITER;
	}
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String filedDelimiter) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.fieldDelimiter = filedDelimiter;
    }
    
    public char getFieldDelimiterChar() {
	String filedDelimiter = getFieldDelimiter();
	if (isEmpty(filedDelimiter)) {
	    return 0;
	}
	return filedDelimiter.charAt(0);
    }

    public String getRecordDelimiter() {
	if (recordDelimiter == null) {
	    return DEFAULT_RECORD_DELIMITER;
	}
        return recordDelimiter;
    }

    public void setRecordDelimiter(String recordDelimiter) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.recordDelimiter = recordDelimiter;
    }

    public boolean isIncludeHeaders() {
        return includeHeaders;
    }

    public void setIncludeHeaders(boolean includeHeaders) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.includeHeaders = includeHeaders;
    }


    // Duplicate includeHeaders (for import)
    
    public boolean isUseFirstRowAsHeader() {
        return includeHeaders;
    }

    public void setUseFirstRowAsHeader(boolean useFirstRowAsHeader) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.includeHeaders = useFirstRowAsHeader;
    }

    
    public String getNullValue() {
	if (nullValue == null) {
	    return NULL_VALUE;
	}
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    public boolean isQuoteText() {
        return quoteText;
    }

    public void setQuoteText(boolean quoteText) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.quoteText = quoteText;
    }

    public boolean isTrim() {
        return trim;
    }

    public void setTrim(boolean trim) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.trim = trim;
    }

    
    protected abstract String getFileExt();

    protected String getNormalizeFileName() {
	String fileName = getFileName();
	if (fileName == null) {
	    return null;
	}
	if (fileName.endsWith(getFileExt())) {
	    return getFileName();
	}
	return getFileName() + getFileExt();
    }

    protected File createFile() {
	String fileName = getNormalizeFileName();
	File file = new File(fileName);
	return file;
    }

    
    ////

    ////
    
    public String getDatePattern() {
	if (isEmpty(datePattern)) {
	    datePattern = DEFAULT_DATE_PATTERN;
	}
	return datePattern;
    }
    
    public void setDatePattern(String datePattern) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.datePattern = datePattern;
        resetTimestampFormat();
        resetValueConverter();
    }
    
    ////

    public String getTimePattern() {
	if (isEmpty(timePattern)) {
	    timePattern = DEFAULT_TIME_PATTERN;
	}
	return timePattern;
    }

    
    public void setTimePattern(String timePattern) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.timePattern = timePattern;
        resetTimestampFormat();
    }
    
    ////

    public String getTimestampPattern() {
	if (isEmpty(timestampPattern)) {
	    timestampPattern = "" + getDatePattern() + " " + getTimePattern();
	}
	return timestampPattern;
    }

    

    public String getNumberPattern() {
	if (isEmpty(numberPattern)) {
	    numberPattern = DEFAULT_NUMBER_PATTERN;
	}
	return numberPattern;
    }
    
    public void setNumberPattern(String numberPattern) {
	if (processingStarted) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
        this.numberPattern = numberPattern;
        resetAllNumberFormats();
        resetValueConverter();
    }

    
    protected void resetAllNumberFormats() {
	integerFormat = null;
	decimalFormatMap.clear();
    }
    
    // Date Format

    public DateFormat getDateFormat() {
	if (dateFormat == null) {
	    dateFormat = createDateFormat(getDatePattern());
	}
        return dateFormat;
    }

       

    // Number format
    
    public NumberFormat getNumberFormat() {
	if (numberFormat == null) {
	    numberFormat = createNumberFormat(getNumberPattern());
	}
	return numberFormat;
    }

    public NumberFormat getIntegerFormat() {
	if (integerFormat == null) {
	    integerFormat = createNumberFormat(getNumberPattern());
	}
	return integerFormat;
	
    }
    
    public NumberFormat getDecimalFormat(int decimal) {
	if (decimal < 1) {
	    decimal = 0;
	}
	NumberFormat decimalFormat =  decimalFormatMap.get(decimal);
	if (decimalFormat != null) {
	    return decimalFormat;
	}
	decimalFormat = createDecimalFormat(decimal);
	decimalFormatMap.put(decimal, decimalFormat);
	return decimalFormat;
    }
    
    

    // Time Format
    
    public DateFormat getTimeFormat() {
	if (timeFormat == null) {
	    timeFormat = createTimeFormat(getTimePattern());
	}
        return timeFormat;
    }



    // Timestamp Format
    
    public DateFormat getTimestampFormat() {
	if (timestampFormat == null) {
	    timestampFormat = createTimestampFormat(getTimestampPattern());
	}
        return timestampFormat;
    }

    
     protected void resetTimestampFormat() {
	this.timestampPattern = null;
    }
    
    protected String getCannotModifyMessage() {
	return "Cannot modify '" + getSimpleName() + "' properties after data processing has started";
    }
    
    public String getSimpleName() {
	return getClass().getSimpleName();
    }

    public boolean isProcessingStarted() {
        return processingStarted;
    }

    public void setProcessingStarted(boolean processingStarted) {
        this.processingStarted = processingStarted;
    }

    public void setProcessingStarted() {
	setProcessingStarted(true);
    }
    
    public void resetProcessingStarted() {
	setProcessingStarted(false);
    }
    

    ////
    
    protected boolean isEmpty(String str ) {
	return StringUtils.isEmpty(str);
    }

    public ITransferService getTransferService() {
	if (transferService == null) {
	    transferService = createTransferService();
	}
        return transferService;
    }

    public void setTransferService(ITransferService service) {
        this.transferService = service;
    }

    protected ITransferService createTransferService() {
	try {
	    return TransferEnvironment.getTransferService();
	} catch (Throwable ex) {
	    logger.error("Creation DatabaseService Error", ex);
	}
	return null;
    }
    
    public ISourceService getSourceService() throws ApplicationException {
	if (sourceService == null) {
	    sourceService = createSourceService();
	}
        return sourceService;
    }

    public void setSourceService(ISourceService sourceService) {
        this.sourceService = sourceService;
    }

    protected ISourceService createSourceService() {
	return null;
    }
    
    public void setProperties(AbstractConverter converter) {
	
	setEncoding(converter.getEncoding());
        setFieldDelimiter(converter.getFieldDelimiter());
        setRecordDelimiter(converter.getRecordDelimiter());
        setIncludeHeaders(converter.isIncludeHeaders());
        setTrim(converter.isTrim());
        setQuoteText(converter.isQuoteText());
        setNullValue(converter.getNullValue());
        
        setDatePattern(converter.getDatePattern());
        setTimePattern(converter.getTimePattern());
        setNumberPattern(converter.getNumberPattern());
        
        setFileName(converter.getFileName());
    }

    public ValueConverter getValueConverter() {
	if (valueConverter == null) {
	    valueConverter = new ValueConverter();
	    
	    // Initialize formats 
	    valueConverter.setDatePattern(getDatePattern());
	    valueConverter.setNumberPattern(getNumberPattern());
	    
	    valueConverter.setLocale(getLocale());
	    valueConverter.setTimeZone(getTimeZone());
	    
	}
        return valueConverter;
    }

    public void setValueConverter(ValueConverter valueConverter) {
        this.valueConverter = valueConverter;
    }
    
    protected void resetValueConverter() {
	valueConverter = null;
    }
    
    
    
    public IConfigurer getConfigurer() {
	if (configurer == null) {
	    configurer = new Configurer();
	}
        return configurer;
    }

    public void setConfigurer(IConfigurer configurer) {
        this.configurer = configurer;
    }
    
    public Object getConfigProperty(String key) {
	return getConfigurer().getProperty(key);
    }

    
    public String getStringConfigProperty(String key) {
	Object obj = getConfigProperty(key);
	if (obj == null) {
	    return null;
	}
	if (obj instanceof String) {
	    return (String) obj;
	}
	return null;
    }

    public String[] getStringArrayConfigProperty(String key) {
	Object obj = getConfigProperty(key);
	if (obj == null) {
	    return null;
	}
	if (obj instanceof String[]) {
	    return (String[]) obj;
	}
	return null;
    }

    public Locale getLocale() {
	if (locale == null) {
	    locale = Locale.getDefault();
	}
        return locale;
	
    }

    public TimeZone getTimeZone() {
	if (timeZone == null) {
	    timeZone = TimeZone.getDefault();
	}
        return timeZone;
	
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resetValueConverter();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
        resetValueConverter();
    }

    
    /**
     * Convert string value to object
     * @param value
     * @param type
     * @return
     * @throws ApplicationException
     */
    protected Object convert(String value, String type) throws ApplicationException {
	return getValueConverter().convert(value, type);
    }

    
    //// XML Import
//    protected Object convertByLocale(String value, String type) {
//	return getValueConverter().convertByLocale(value, type);
//    }
//

    //// XML Import
    protected Object convertNumber(Number value, String type) throws ApplicationException {
	return getValueConverter().convertNumber(value, type);
    }    


    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CREATE FORMATS BY PATTERN
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    protected DateFormat createDateFormat(String pattern) {
	return new SimpleDateFormat(pattern);
    }
    
    protected NumberFormat createNumberFormat(String pattern) {
	DecimalFormat decimalFormat = new DecimalFormat(pattern);
	
	if (!isNormalizeNumberFormat()) {
	    return decimalFormat;
	}
	normalizeNumberFormat(decimalFormat);
	return decimalFormat;
    }
    
    protected NumberFormat createIntegerFormat() {
	DecimalFormat decimalFormat = (DecimalFormat) getNumberFormat();
	String pattern = decimalFormat.toPattern();
	String separator =  String.valueOf((decimalFormat.getDecimalFormatSymbols().getDecimalSeparator()));
	int index = pattern.lastIndexOf(separator);
	if (index > -1) {
	    pattern = index == 0 ? "" : pattern.substring(0, index);
	}
	return createNumberFormat(pattern);
    }
    
    protected NumberFormat createDecimalFormat(int decimal) {
	DecimalFormat decimalFormat = (DecimalFormat) createIntegerFormat();
	String pattern = decimalFormat.toPattern();
	if (decimal > 0) {
	    pattern = pattern + "." + StringUtils.replicate("0", decimal);
	}
	return createNumberFormat(pattern);
    }
    
    
    protected void normalizeNumberFormat(DecimalFormat decimalFormat) {
	DecimalFormatSymbols dfs = (DecimalFormatSymbols) decimalFormat.getDecimalFormatSymbols().clone();
	dfs.setDecimalSeparator('.');
	decimalFormat.setDecimalFormatSymbols(dfs);
	decimalFormat.setGroupingUsed(false);
    }
    
    
    protected DateFormat createTimeFormat(String pattern) {
	return new SimpleDateFormat(pattern);
    }

    protected DateFormat createTimestampFormat(String pattern) {
	return new SimpleDateFormat(pattern);
    }

    /**
     * Create Timestamp format by date and number patterns
     * @param datePattern
     * @param timePattern
     * @return
     */
    protected DateFormat createTimestampFormat(String datePattern, String timePattern) {
	return new SimpleDateFormat("" + datePattern + " " + timePattern);
    }


    protected boolean isNormalizeNumberFormat() {
	return true;
    }
    
    ////
    protected boolean isColumnType(DSField column, String type) {
	if (column == null || type == null || column.getDataType() == null) {
	    return false;
	}
	return column.getDataType().equals(type);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    public boolean isBoolean(Class klass) {
	return ClassUtilsExt.isBoolean(klass);
    }

    public boolean isIntegerNumber(Class klass) {
	return ClassUtilsExt.isIntegerNumber(klass);
    }

    public boolean isDecimalNumber(Class klass) {
	return ClassUtilsExt.isDecimalNumber(klass);
    }

    public boolean isNumber(Class klass) {
	return ClassUtilsExt.isNumber(klass);
    }
    
    public boolean isPrimitiveNumber(Class klass) {
	return ClassUtilsExt.isPrimitiveNumber(klass);
    }
    
    public boolean isString(Class klass) {
	return ClassUtilsExt.isString(klass);
    }
    
    public  boolean isDate(Class klass) {
	return ClassUtilsExt.isDate(klass);
    }

    public boolean isTime(Class klass) {
	return ClassUtilsExt.isTime(klass);
    }

    public boolean isTimestamp(Class klass) {
	return ClassUtilsExt.isTimestamp(klass);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////

    public boolean isString(String type) {
	return TypeUtils.isStringType(type);
    }

    public boolean isBoolean(String type) {
	return TypeUtils.isBooleanType(type);
    }

    public boolean isInteger(String type) {
	return TypeUtils.isIntegerType(type);
    }

    public boolean isLikeNumber(String type) {
	return TypeUtils.isLikeNumberType(type);
    }
      
    public boolean isLikeDecimal(String type) {
	return TypeUtils.isLikeDecimalType(type);
    }
    
    public boolean isDate(String type) {
	return TypeUtils.isDateType(type);
    }

    public boolean isTime(String type) {
	return TypeUtils.isTimeType(type);
    }

    public boolean isTimestamp(String type) {
	return TypeUtils.isTimestampType(type);
    }           


    //////////////////////////////////////////////////////////////////////////////////////    
    
    /**
     * Return true if class is like string presentation in SQL
     * For example: Date - '2010-01-01'
     * @param klass
     * @return
     */
    public boolean isLikeString(Class klass) {
	return isString(klass) || isDate(klass) || isTime(klass) || isTimestamp(klass);
    }

    public boolean isLikeString(String type) {
	return TypeUtils.isStringType(type) || TypeUtils.isDateType(type) || TypeUtils.isTimeType(type) || TypeUtils.isTimestampType(type);
    }

    //////////////////////////////////////////////////////////////////////////////////////


    /**
     * Return class by name
     */
    protected Class getClassByName(String className) {
	
	if (isEmpty(className)) {
	    return null;
	}
	className = className.trim();
	Class klass = ClassUtilsExt.getSimpleClass(className);
	if (klass != null) {
	    return klass;
	}
	klass = classMap.get(className);
	if (klass != null) {
	    return klass;
	}
	try {
	    klass = ClassUtilsExt.forName(className);
	    if (klass != null) {
		classMap.put(className, klass);
	    }
	    return klass;
	} catch (Throwable ex) {
	    logger.error("Loading Class Error", ex);
	}
	return null;
    }

    /**
     * Return real class of column
     * @param column
     * @return
     */
//    protected Class getRealColumnClass(Field column) {
//	if (column == null) {
//	    return null;
//	}
//	Class columnClass = column.getFieldClass();
//	if (columnClass != null) {
//	    return columnClass;
//	}
//	
//	String className = column.getFieldClassName();
//	if (className == null) {
//	    return null;
//	}
//	return getClassByName(className);
//    }

    public TransferResult getTransferResult() {
	if (transferResult == null) {
	    transferResult = new TransferResult();
	}
	return transferResult;
    }

    public void setTransferResult(TransferResult transferResult) {
        this.transferResult = transferResult;
    }

    public void countDataRow() {
	countDataRow(1);
    }
    
    public void countDataRow(int count) {
	getTransferResult().setDataRowCount(getTransferResult().getDataRowCount() + count);
    }

    public void countDataSet() {
	countDataSet(1);
    }
    
    public void countDataSet(int count) {
	getTransferResult().setDataSetCount(getTransferResult().getDataSetCount() + count);
    }

}
