package org.plazmaforge.framework.datawarehouse.convert.dataimport;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.AbstractConverter;


public abstract class AbstractImporter extends AbstractConverter implements IImporter  {

    
    protected Reader reader;
    
    /**
     * DataSet importer (only for transfer data to DB or other source)
     */
    private IDataSetImporter dataSetImporter;
 
    
    
    public void execute() throws ApplicationException {
	if (!isValid()) {
	    return;
	}
	init();
	
	openInput();
	
	importMetaData();
	importBody();
	
	closeInput();
    }

    protected void openInput() throws ApplicationException{
	reader = createReader();
    }

    protected void closeInput() throws ApplicationException{
	if (reader == null) {
	    return;
	}
	try {
	    reader.close();
	} catch (IOException e) {
	    // nothing to do
	}
    }
    
    protected void importMetaData() throws ApplicationException {
	
    }
    
    protected void importBody() throws ApplicationException {
	
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // Reader
    //
    ///////////////////////////////////////////////////////////////////////////////////
    
    protected FileInputStream createFileInputStream() throws ApplicationException {
	try {
	    return new FileInputStream(getNormalizeFileName());
	} catch (FileNotFoundException ex) {
	    throw new ApplicationException(ex);
	}
    }
 
    protected InputStream createInputStream() throws ApplicationException {
	return createFileInputStream();
    }
    
    protected Reader createReader() throws ApplicationException {
	InputStream is = createInputStream();
	return createReader(is, getFileEncoding());
    }
    
    protected Reader createReader(InputStream is, String fileEncoding) throws ApplicationException {
	if (fileEncoding == null) {
	    return createBufferedReader(new InputStreamReader(is));
	}
	try {
	    return createBufferedReader(new InputStreamReader(is, fileEncoding));
	} catch (UnsupportedEncodingException ex) {
	    throw new ApplicationException(ex);
	}	
    }
    
    protected BufferedReader createBufferedReader(Reader reader) throws ApplicationException {
	return new BufferedReader(reader);
    }
    

    protected String getCannotModifyMessage() {
	return "Cannot modify '" + getSimpleName() + "' properties after data reading has started";
    }

    
    /////

    public IDataSetImporter getDataSetImporter() {
        return dataSetImporter;
    }

    public void setDataSetImporter(IDataSetImporter dataSetImporter) {
        this.dataSetImporter = dataSetImporter;
    }

    

}
