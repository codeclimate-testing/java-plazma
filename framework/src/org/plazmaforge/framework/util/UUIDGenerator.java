package org.plazmaforge.framework.util;

import java.net.InetAddress;
import java.security.SecureRandom;

public class UUIDGenerator {

    /**
     * This is a cached value for the mid part of the guid string
     */
    private static String midPart;

    private static SecureRandom seeder;

    static {
	try {
	    // get the internet address
	    InetAddress inet = InetAddress.getLocalHost();
	    byte[] bytes = inet.getAddress();
	    String hexInetAddress = hexFormat(getInt(bytes), 8);

	    // get the hashcode for this object
	    String thisHashCode = hexFormat(System.identityHashCode(new Object()), 8);

	    // set up mid value string
	    midPart = hexInetAddress + thisHashCode;

	    // load up the randomizer first
	    seeder = new SecureRandom();
	} catch (Exception e) {
	    System.err.println("Unable to initialize inet address information due to: " + e.getMessage());
	}
    }

    /**
     * Returns a string that is a guid.
     * 
     * @return a String that is a guid.
     */
    public static String getUUID() {

	long timeNow = System.currentTimeMillis();

	// get int value as unsigned
	int timeLow = (int) timeNow & 0xFFFFFFFF;

	// get next random value
	int node = seeder.nextInt();

	return (hexFormat(timeLow, 8) + midPart + hexFormat(node, 8));

    }

    
    private static int getInt(byte[] bytes) {

	return (((bytes[0]) << 24) + ((bytes[1] & 0xFF) << 16)
		+ ((bytes[2] & 0xFF) << 8) + ((bytes[3] & 0xFF)));
    }

    private static String hexFormat(int inpInt, int nChars) {

	String tmpStr = Integer.toHexString(inpInt);

	// return string prepended with 0s if the length is less than 8 chars
	return ((tmpStr.length() == 8) ? tmpStr : ((new String("00000000"))
		.substring(tmpStr.length()) + tmpStr));
    }

    public static void main(String[] arg) {
	for (int i = 0; i < 20; i++) System.out.println(UUIDGenerator.getUUID());
    }
}
