package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class EmptyOasisZipEntry implements OasisZipEntry {

	private String name = null;
	
	public EmptyOasisZipEntry(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Writer getWriter() throws IOException {
		throw new RuntimeException("This method should not be called on this type");
	}
	
	public OutputStream getOutputStream(){
		throw new RuntimeException("This method should not be called on this type");
	}
	
	public void writeData(OutputStream os) throws IOException {
	}
	
	public void dispose() {
	}
	
}
