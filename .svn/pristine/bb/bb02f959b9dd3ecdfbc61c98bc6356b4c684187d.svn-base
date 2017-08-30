package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.framework.erm.procedure.AbstractProcedure;

public class ERMUtils extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = null;
	    Object data = null;
	    if ("toDigits".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		String result = toDigits((String) data);
		parameters.put("result", result);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

    
    private String toDigits(String str) {
	if (str == null) {
	    return null;
	}
	str = str.trim();
	if (str.isEmpty()) {
	    return null;
	}
	StringBuffer buf = new StringBuffer();
	char[] array = str.toCharArray();
	for (char ch : array) {
	    if (Character.isDigit(ch)) {
		buf.append(ch);
	    }
	}
	if (buf.length() == 0){
	    return null;
	}
	return buf.toString();
    }

}
