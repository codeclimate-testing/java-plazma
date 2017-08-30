package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;
import java.util.StringTokenizer;


public class Utils {

    
	public static final int COLOR_MASK = Integer.parseInt("FFFFFF", 16);

	public static String getColorHexa(Color color) 	{
		String hexa = Integer.toHexString(color.getRGB() & COLOR_MASK).toUpperCase();
		return ("000000" + hexa).substring(hexa.length());
	}

	public static String getIndent(int i) {
		String indent = "";
		for (int j=0; j<i; j++) {
			indent += " ";
		}
		return indent;
	}
	
	public static double translatePixelsToInches(double pixels){
		double inches = 0.0;
		inches = pixels/72.0;
		inches = (Math.floor(inches * 100.0))/100.0;
		return inches;
	}
	public static double translatePixelsToInchesRound(double pixels){
		double inches = 0.0;
		inches = pixels/72.0;
		inches = (Math.round(inches * 100.0))/100.0;
		return inches;
	}

	public static double translatePixelsToInchesWithNoRoundOff(double pixels){
		double inches = 0.0;
		inches = pixels/72.0;
		return inches;
	}
	
	protected static String replaceNewLineWithLineBreak(String source) {
	    if (source == null) {
		return null;
	    }
	    String str = null;
	    StringBuffer sbuffer = new StringBuffer();
	    StringTokenizer tkzer = new StringTokenizer(source, "\n", true);
	    String token = null;
	    while(tkzer.hasMoreTokens()) {
		token = tkzer.nextToken();
		if ("\n".equals(token))	{
		    sbuffer.append("<text:line-break/>");
		} else {
		    sbuffer.append(token);
		}
	    }
	    str = sbuffer.toString();
	    return str;
	}
	
}
