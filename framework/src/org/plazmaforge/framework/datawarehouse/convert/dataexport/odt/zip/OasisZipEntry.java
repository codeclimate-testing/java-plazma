package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;


public interface OasisZipEntry {
    
	public String getName();
	
	public Writer getWriter() throws IOException;
	
	public OutputStream getOutputStream();

	public void writeData(OutputStream out) throws IOException;
	
	public void dispose();
}
