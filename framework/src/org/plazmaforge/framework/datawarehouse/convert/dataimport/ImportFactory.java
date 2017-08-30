package org.plazmaforge.framework.datawarehouse.convert.dataimport;

import org.plazmaforge.framework.core.FileFormat;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.csv.CSVImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.csv.DatabaseCSVImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.xml.DatabaseXMLImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.xml.XMLImporter;

public class ImportFactory {

    private ImportFactory() {
	
    }

    /**
     * Return <code>IImporter</code> by format
     * @param format
     * @return
     */
    public static IImporter getImporter(String format) {
	if (FileFormat.XML.equals(format)) {
	    return new XMLImporter();
	} else if (FileFormat.CSV.equals(format)) {
	    return new CSVImporter();
	} else if (FileFormat.DATABASE_XML.equals(format)) {
	    return new DatabaseXMLImporter();
	} else if (FileFormat.DATABASE_CSV.equals(format)) {
	    return new DatabaseCSVImporter();
	}    
	return null;
    }
    
    
}
