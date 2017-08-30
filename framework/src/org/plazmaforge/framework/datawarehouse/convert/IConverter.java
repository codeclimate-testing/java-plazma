package org.plazmaforge.framework.datawarehouse.convert;

import java.text.DateFormat;
import java.text.NumberFormat;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferResult;

public interface IConverter {

    void execute() throws ApplicationException;
    
    
    void setDataSet(DSDataSet dataSet);

    DSDataSet getDataSet();
    
    
    String getDataSetName();

    void setDataSetName(String dataSetName);

    
    
    String getEncoding();

    void setEncoding(String encoding);
    
    
    void setFileName(String fileName);
    
    String getFileName();
    
    
    String getFieldDelimiter();

    void setFieldDelimiter(String fieldDelimiter);
    
    String getRecordDelimiter();

    void setRecordDelimiter(String recordDelimiter);
    

    boolean isIncludeHeaders();

    void setIncludeHeaders(boolean includeHeaders);

    String getNullValue();

    void setNullValue(String nullValue);

    boolean isQuoteText();

    void setQuoteText(boolean quoteText);

    boolean isTrim();

    void setTrim(boolean trim);

    ////
    
    String getDatePattern();

    void setDatePattern(String datePattern);
    

    String getNumberPattern();

    void setNumberPattern(String numberPattern);

    
    String getTimePattern();

    void setTimePattern(String timePattern);
    
    
    String getTimestampPattern();
    

    ////
    
    DateFormat getDateFormat();

    NumberFormat getNumberFormat();

    DateFormat getTimeFormat();

    DateFormat getTimestampFormat();
    
    ////
    
    IConfigurer getConfigurer();

    void setConfigurer(IConfigurer configurer);
    
    Object getConfigProperty(String key);
    
    String getStringConfigProperty(String key);

    String[] getStringArrayConfigProperty(String key);

    ////
    
    ITransferService getTransferService();
    
    void setTransferService(ITransferService service);
    
    void setSourceService(ISourceService sourceService);
    
    ////
    
    
    TransferResult getTransferResult();

    void setTransferResult(TransferResult transferResult);
    
}
