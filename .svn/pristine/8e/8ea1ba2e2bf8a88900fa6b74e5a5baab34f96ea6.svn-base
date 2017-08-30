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
package org.plazmaforge.framework.report;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;


/**
 * Abstract Report
 * 
 * Report file name = {protocol}{storagePath}/{path}/{localePrefix}/{fileName}
 * 
 * @author Oleh Hapon Date: 08.07.2004 Time: 9:16:20 $Id: AbstractReport.java,v 1.10 2010/12/05 07:51:25 ohapon Exp $
 */
public abstract class AbstractReport implements IReport {

    private String id;
    
    /** 
     * Report name
     */
    private String name;
    
    /**
     * Report caption (National language)
     */
    private String caption;

    /** 
     * Report description (National language) 
     */
    private String description;

    /**
     * Storage path. 
     * For example: "c:\ReportStorage"
     */
    private String storagePath = "";

    /**
     * Protocol 
     * For example: "file://", "http://"
     */
    private String protocol = "";

    
    /** File name **/
    private String fileName;


    /**
     * File Path
     * Example: sales, document, myfolder1/myfolder2
     */
    private String path = "";


    /** Region name * */
    private String region;

    /** Country name * */
    private String country;

    /** Language name * */
    private String language;

    private Map<String, Object> parameters;

    private IAcceptor acceptor;

    private boolean changeParameters;

    /** Real report name **/
    private String reportFileName;

    /** Real report path **/
    private String reportPath;

    private boolean asolutePath;
    
    public AbstractReport() {
    }
    
    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }
      
    public void setParameter(String name, Object value) {
	getParameters().put(name, value);
	this.changeParameters = true;
    }

    public Object getParameter(String name) {
	return parameters.get(name);
    }

    public Map<String, Object> getParameters() {
	if (parameters == null) {
	    parameters = new HashMap<String, Object>();
	}
	return parameters;
    }

    public void addParameters(Map<String, Object> map) {
	if (map == null) {
	    return;
	}
	Set<Map.Entry<String, Object>> set = map.entrySet();
	Iterator<Map.Entry<String, Object>> it = set.iterator();
	Map.Entry<String, Object> entry = null;
	while (it.hasNext()) {
	    entry = it.next();
	    setParameter(entry.getKey(), entry.getValue());
	}
    }

    public void readParameters() throws ApplicationException {
	IAcceptor acceptor = getAcceptor();
	if (acceptor == null)
	    return;
	addParameters(acceptor.readParameters());
    }

    public String toString() {
	return getName();
    }

    public IAcceptor getAcceptor() {
	return acceptor;
    }

    public void setAcceptor(IAcceptor acceptor) {
	this.acceptor = acceptor;
    }

    public boolean isChangeParameters() {
	return changeParameters;
    }

  

    public String getStoragePath() {
	return storagePath;
    }

    public void setStoragePath(String storagePath) {
	this.storagePath = storagePath;
    }

    public void verifyParameters() throws InvalidReportParameterException {
	/*
	if (parameters == null) {
	    throw new InvalidReportParameterException("Report Parameters is NULL");
	}
	*/
    }

    protected void verifyID() throws InvalidReportParameterException {
	Object value = getParameter(ID);
	if (value == null) {
	    throw new InvalidReportParameterException("Parameter [" + ID + "] not found");
	}
	if (!(value instanceof Integer)) {
	    throw new InvalidReportParameterException("Parameter [" + ID + "] must be Integer type");
	}
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }


    public String getCountry() {
	if (isEmpty(country)) {
	    country = ReportProcessor.getCountry();
	}
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getLanguage() {
	if (isEmpty(language)) {
	    language = ReportProcessor.getLanguage();
	}
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public String getRegion() {
	if (isEmpty(region)) {
	    region = ReportProcessor.getRegion();
	}
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }

  

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(String protocol) {
	this.protocol = protocol;
    }

    public String getFileName() {
	if (isEmpty(fileName)) {
	    fileName = getName();
	}
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

  
    public String getLocalePrefix() {
	StringBuffer buf = new StringBuffer();
	if (ReportProcessor.isSupportedRegionInTemplatePath()) {
	    appendPathElement(buf, getRegion());
	}
	appendPathElement(buf, getCountry());
	appendPathElement(buf, getLanguage());
	return buf.toString();
    }

    public String getLocalePrefix(Locale locale) {
	return getLocalePrefix("", locale);
    }

    public String getLocalePrefix(String region, Locale locale) {
	StringBuffer buf = new StringBuffer();
	appendPathElement(buf, region);
	if (locale != null) {
	    appendPathElement(buf, locale.getCountry());
	    appendPathElement(buf, locale.getLanguage());
	}
	return buf.toString();
    }

    /**
     * General method
     */
    public String getAbsoluteFileName() {
	if (isAsolutePath()) {
	    return getAbsoluteFileName("", getPath(), "", getFileName());
	}
	return getAbsoluteFileName(getStoragePath(), getPath(), getLocalePrefix(), getFileName());
    }
    
    
    

    public String getAbsoluteFileName(Locale locale) {
	return getAbsoluteFileName(getStoragePath(), getPath(), getLocalePrefix(locale), getFileName());
    }

    public String getAbsoluteFileName(String storagePath, String path, String localePrefix, String file) {
	StringBuffer buf = new StringBuffer();
	append(buf, getProtocol());

	appendPathElement(buf, storagePath);
	appendPathElement(buf, path);

	append(buf, localePrefix);
	append(buf, file);
	return buf.toString();
    }

    public String[] getAvailableLocaleFileNames() {
	Locale[] locales = ReportProcessor.getOtherFamilyLocales();
	String[] names;
	if (locales.length == 0) {
	    names = new String[1];
	    names[0] = getAbsoluteFileName(null);
	    return names;
	}
	names = new String[locales.length + 1];
	for (int i = 0; i < locales.length; i++) {
	    names[i] = getAbsoluteFileName(locales[i]);
	}
	names[locales.length] = getAbsoluteFileName(null);
	return names;
    }

    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }

    /**
     * Append path element
     * 
     * @param buf
     * @param str
     */
    protected void appendPathElement(StringBuffer buf, String str) {
	appendPathElement(buf, str, PATH_SEPARATOR);
    }

    /**
     * If string is not empty then append string with separator
     * 
     * @param buf
     * @param str
     * @param separator
     */
    protected void appendPathElement(StringBuffer buf, String str, String separator) {
	if (!isEmpty(str)) {
	    buf.append(str + separator);
	}
    }

    /**
     * If string is not empty then append string
     * 
     * @param buf
     * @param str
     */
    protected void append(StringBuffer buf, String str) {
	if (!isEmpty(str)) {
	    buf.append(str);
	}
    }


    public String getReportPath() {
	return reportPath;
    }

    public void setReportPath(String reportPath) {
	this.reportPath = reportPath;
    }

    public String getReportFileName() {
	return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
	this.reportFileName = reportFileName;
    }

    public boolean isAsolutePath() {
        return asolutePath;
    }

    public void setAsolutePath(boolean asolutePath) {
        this.asolutePath = asolutePath;
    }

    
}
