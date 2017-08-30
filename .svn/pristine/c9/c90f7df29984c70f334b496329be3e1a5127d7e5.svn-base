package org.plazmaforge.framework.datawarehouse.convert.dataimport.xml;


import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.DBTableImporter;

public class DatabaseXMLImporter extends XMLImporter {

    public DatabaseXMLImporter() {
	super();
	setDataSetImporter(new DBTableImporter());
    }

    public void execute() throws ApplicationException {
	super.execute();
	importDataSet();
    }
    
    protected void importDataSet() throws ApplicationException {
	getDataSetImporter().importDataSet(this);
    }
    
}
