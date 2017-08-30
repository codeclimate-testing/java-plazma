package org.plazmaforge.framework.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileFormatFactory {


    private static List<FileFormat> formats = new ArrayList<FileFormat>();
    private static Map<String, FileFormat> formatMap = new HashMap<String, FileFormat>();

    private FileFormatFactory() {
	
    }
    
    static {
	registerFormat(FileFormat.CSV_FORMAT);
	registerFormat(FileFormat.XML_FORMAT);
	registerFormat(FileFormat.HTML_FORMAT);
	registerFormat(FileFormat.XLS_FORMAT);
	registerFormat(FileFormat.RTF_FORMAT);
	registerFormat(FileFormat.ODT_FORMAT);
	registerFormat(FileFormat.SQL_FORMAT);
    }
    
    public static void registerFormat(FileFormat format) {
	formats.add(format);
	formatMap.put(format.getId(), format);
    }
    
    public static FileFormat getFormat(String type) {
	return  formatMap.get(type);
    }

    public static FileFormat[] getFormats(String[] types) {
	if (types == null || types.length == 0) {
	    return new FileFormat[0];
	}
	List<FileFormat> fs = new ArrayList<FileFormat>();
	FileFormat f = null;
	for (String type: types) {
	    f = getFormat(type);
	    if (f == null) {
		continue;
	    }
	    fs.add(f);
	}
	return (FileFormat[]) fs.toArray(new FileFormat[0]);
    }    

}
