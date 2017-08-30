package org.plazmaforge.framework.util;

import java.security.SecureRandom;

public class IdentifierGenerator {

    private static SecureRandom seeder;
    
    private IdentifierGenerator() {
    }

    static {
	seeder = new SecureRandom();
    }

    
    private static String hexFormat(int inpInt, int nChars) {

	String tmpStr = Integer.toHexString(inpInt);

	// return string prepended with 0s if the length is less than 8 chars
	return ((tmpStr.length() == 8) ? tmpStr : ((new String("00000000")).substring(tmpStr.length()) + tmpStr));
    }
    
    /**
     * generate 8 digits ID
     * @return
     */
    public static String generateID() {

	// get next random value
	int node = seeder.nextInt();

	return hexFormat(node, 8);
    }
}
