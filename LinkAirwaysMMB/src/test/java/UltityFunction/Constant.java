package UltityFunction;

import java.util.Properties;

public class Constant extends Commonfunction {

	
	
	public static String BookingPNR= properties.getProperty("BookingPNR") ;
	public static String Firstname= properties.getProperty("Firstname");
	public static String Lastname= properties.getProperty("Lastname");
	public static String MMBMethod= properties.getProperty("MMBMethod");
	public static String OBSegmentMonth=properties.getProperty("OBSegmentMonth");
	public static String OBSegmentDate=properties.getProperty("OBSegmentDate");
	public static String OBSegmentYear=properties.getProperty("OBSegmentYear");
	public static String IBSegmentDate=properties.getProperty("IBSegmentDate");
	public static String IBSegmentYear=properties.getProperty("IBSegmentYear");
	public static String IBSegmentMonth=properties.getProperty("IBSegmentMonth");
	public static String Trip=properties.getProperty("Trip");
	public static String OBfare=properties.getProperty("OBfare");
	public static String IBfare=properties.getProperty("IBfare");	
	public static boolean isAlertAddon=  Boolean.parseBoolean(properties.getProperty("Addonalert"));

}
