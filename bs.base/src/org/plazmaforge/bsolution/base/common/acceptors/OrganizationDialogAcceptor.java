package org.plazmaforge.bsolution.base.common.acceptors;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.framework.core.data.Variable;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.AbstractReportDialogAcceptor;
import org.plazmaforge.framework.report.IReportDialog;


public class OrganizationDialogAcceptor extends AbstractReportDialogAcceptor implements OrganizationAcceptorConstants {

	
    public Map<String, Object> readParameters() throws ApplicationException {
	Map<String, Object> prms = super.readParameters();
	OrganizationAcceptorUtilities.initOrganizationParameters(prms, SessionEnvironment.getContext());
	return prms;
    }
	
    protected IReportDialog createReportDialog() {
	return null;
    }
    
    ////
    
    public static List<Variable> getSystemVariables() {
	return OrganizationAcceptorUtilities.getSystemVariables();
    }
    
    public static List<Variable> getSystemVariablesByPrefix(List<Variable> variables, String prefix) {
	return OrganizationAcceptorUtilities.getSystemVariablesByPrefix(variables, prefix);
    }
    
    public static Variable getSystemVariable(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariable(variables, code);
    }
    
    public static Object getSystemVariableValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableValue(variables, code);
    }

    public static String getSystemVariableStringValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableStringValue(variables, code);
    }

    public static Boolean getSystemVariableBooleanValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableBooleanValue(variables, code);
    }

    public static Integer getSystemVariableIntegerValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableIntegerValue(variables, code);
    }

    public static Float getSystemVariableFloatValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableFloatValue(variables, code);
    }

    public static Date getSystemVariableDateValue(List<Variable> variables, String code) {
	return OrganizationAcceptorUtilities.getSystemVariableDateValue(variables, code);
    }
    
    /**
     * Add marked document rows to result list
     * @param rows - all rows
     * @param docRows - document rows
     * @param marker
     * @param columnIndex - marked column
     */
    protected void addDocumentsWithMarker(List<Object[]> rows, List<Object[]> docRows, String marker, int columnIndex) {
	if (marker == null) {
	    return;
	}
	int rowCount = docRows.size();
	Object[] row = null;
	for (int i = 0; i < rowCount; i++) {
	    row = docRows.get(i);
	    String missing = (String) row[columnIndex];
	    if (missing == null || !missing.startsWith(marker)) {
		continue;
	    }
	    rows.add(row);
	}   
    }
    
    public static String getSystemVariableStringValue(List<Variable> variables, List<String> codes, boolean nonEmpty) {
	return OrganizationAcceptorUtilities.getSystemVariableStringValue(variables, codes, nonEmpty);
    }
    
    public static String getSystemVariableStringValue(List<Variable> variables, List<String> codes) {
	return OrganizationAcceptorUtilities.getSystemVariableStringValue(variables, codes);
    }

}
