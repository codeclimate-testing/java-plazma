import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class TestTimeZone {

    public static void main(String[] args) {
	main1(args);
    }
    /**
     * @param args
     */
    public static void main1(String[] args) {
	
	Calendar calendar = Calendar.getInstance();
	
	TimeZone currentTimeZone = calendar.getTimeZone();
	TimeZone gmt13TimeZone = TimeZone.getTimeZone("GMT+13");
	TimeZone gmt3TimeZone = TimeZone.getTimeZone("GMT+5");
	TimeZone gmt2mTimeZone = TimeZone.getTimeZone("GMT-2");
	
	printlnTZ("Current", currentTimeZone);
	printlnTZ("GMT+13", gmt13TimeZone);
	printlnTZ("GMT+3", gmt3TimeZone);
	printlnTZ("GMT-2", gmt2mTimeZone);
	
	Date currDate = new Date();
	Date date1 = new Date(2013, 10, 18, 12, 13, 13);
	Date date13 = getDateTZ(date1, gmt13TimeZone);
	Date date13_2 = getDateTZ2(date1, gmt13TimeZone);
	Date date3 = getDateTZ(date1, currentTimeZone, gmt3TimeZone);
	
	System.out.println("GMT+2 " + date1);
	System.out.println("GMT+3 " + date3);
	System.out.println("GMT+13 " + date13);
	System.out.println("GMT+13 (2)" + date13_2);
	
	//System.out.println(currDate.getTimezoneOffset());
	//System.out.println(calendar.get(Calendar.ZONE_OFFSET));
	//System.out.println(calendar.get(Calendar.DST_OFFSET));
    }
    
    
    private static void printlnTZ(String name, TimeZone timeZone) {
	System.out.println();
	System.out.println("TimeZone: " + name);
	System.out.println("===================================================================");
	System.out.println("TimeZone DisplayName: " + timeZone.getDisplayName());
	System.out.println("TimeZone ID: " + timeZone.getID());
	System.out.println("TimeZone RawOffset: " + timeZone.getRawOffset());
	System.out.println("TimeZone TimeOffset: " + timeZone.getRawOffset() / (60 * 60 * 1000));
	
    }
    
    private static Date getDateTZ(Date date, TimeZone timeZone) {
	if (date == null) {
	    return null;
	}
	int timeZoneOffset = timeZone.getOffset(date.getTime());
	return getDateTZ(date, timeZoneOffset);
    }
    
    private static Date getDateTZ(Date date, int timeZoneOffset) {
	if (date == null) {
	    return null;
	}
	return new Date(date.getTime() - timeZoneOffset);
    }

    private static Date getDateTZ(Date date, TimeZone timeZone1, TimeZone timeZone2) {
	if (date == null) {
	    return null;
	}
	int timeZoneOffset1 = timeZone1.getOffset(date.getTime());
	int timeZoneOffset2 = timeZone2.getOffset(date.getTime());
	return getDateTZ(date, timeZoneOffset1, timeZoneOffset2);
    }
    
    private static Date getDateTZ(Date date, int timeZoneOffset1, int timeZoneOffset2) {
	if (date == null) {
	    return null;
	}
	return new Date(date.getTime() - timeZoneOffset1 + timeZoneOffset2);
    }

    private static Date getDateTZ2(Date date, TimeZone timeZone) {
	if (date == null) {
	    return null;
	}
	Calendar calendar = Calendar.getInstance(timeZone);
	calendar.setTime(date);
	//calendar.setTimeInMillis(date.getTime());
	
	int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
	return calendar.getTime();
    }

    
    public static void main2(String[] args) {
	 
        Calendar localTime = Calendar.getInstance();
 
        int hour = localTime.get(Calendar.HOUR);
        int minute = localTime.get(Calendar.MINUTE);
        int second = localTime.get(Calendar.SECOND);
 
        //
        // Print the local time
        //
        System.out.printf("Local time  : %02d:%02d:%02d\n", hour, minute,
                second);
 
        //
        // Create a calendar object for representing a Singapore time zone.
        //
        Calendar indiaTime = new GregorianCalendar(
                TimeZone.getTimeZone("Asia/Singapore"));
        indiaTime.setTimeInMillis(localTime.getTimeInMillis());
        hour = indiaTime.get(Calendar.HOUR);
        minute = indiaTime.get(Calendar.MINUTE);
        second = indiaTime.get(Calendar.SECOND);
 
        //
        // Print the local time in Germany time zone
        //
        System.out.printf("India time  : %02d:%02d:%02d\n", hour, minute,
                second);
    }
}
