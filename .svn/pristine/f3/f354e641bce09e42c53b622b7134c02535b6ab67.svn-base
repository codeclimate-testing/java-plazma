package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt.zip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;



public class FileBufferedOasisZipEntry implements OasisZipEntry {
    
	private String name = null;
	private FileBufferedOutputStream fbos = null;
	private Writer writer = null;
	
	public FileBufferedOasisZipEntry(String name) {
		this(name, null);
	}
	
	public FileBufferedOasisZipEntry(String name, byte[] bytes) {
	    this.name = name;

	    if (bytes == null) {
		fbos = new FileBufferedOutputStream();
	    } else {
		fbos = new FileBufferedOutputStream(bytes.length);
		try {
		    fbos.write(bytes);
		} catch (IOException e)	{
		    throw new RuntimeException(e);
		}
	    }
	}
	
	
	public String getName() {
	    return name;
	}
	
	public Writer getWriter() throws IOException {
	    if (writer == null) {
		writer = new BufferedWriter(new OutputStreamWriter(fbos, "UTF-8"));
	    }
	    return writer;
	}

	public OutputStream getOutputStream() {
	    return fbos;
	}

	public void writeData(OutputStream os) throws IOException {
	    fbos.writeData(os);
	}

	public void dispose() {
	    fbos.dispose();
	}
	
}
