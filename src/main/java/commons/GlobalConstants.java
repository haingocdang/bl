package commons;

import org.apache.commons.logging.Log;

public class GlobalConstants {
	public static String ROOT_FOLDER= System.getProperty("user.dir");
	public static String LIVE_GURU_URL="http://live.demoguru99.com/";
	public static long LONG_TIMEOUT=30;
	public static long SHORT_TIMEOUT=10;
	public static String BROWSER_LOG_FOLDER=ROOT_FOLDER+"\\browserLog";
	public static String DOWNLOAD_FOLDER=ROOT_FOLDER+"\\bdownloadFiles";
	public static String UPLOAD_FOLDER=ROOT_FOLDER+"\\uploadFiles\\";
	public static String LOGIN_BANKGURU_URL="http://demo.guru99.com/v4/";
	
	//protected static Log log;
	
	//Constants: dữ liệu ko dc phép thay đổi trong quá trình run
	//Dùng chung cho toàn bộ Framework (system)
	//Bất kì class/package nào cũng có thể use class này dc
	//URL hay server/DB/User, Pass
	//Folder path/ Setting/.....
}
