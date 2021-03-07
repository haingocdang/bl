package commons;

import org.apache.commons.logging.Log;

public class GlobalConstants {
	public static String ROOT_FOLDER= System.getProperty("user.dir");
	public static String MERCURY_LOGIN_TEST_ENV_URL="http://test-mercury.alpaca.vn/login";
	//public static String MERCURY_LOGIN_TEST_ENV_URL="http://61.14.237.83:8903/oauth/login";
	public static String JUPITER_LOGIN_TEST_ENV_URL="http://test-jupiter.alpaca.vn";
	//public static String JUPITER_LOGIN_TEST_ENV_URL="http://103.70.30.134:3201";
	//public static String JUPITER_LOGIN_TEST_ENV_URL="http://test-jupiter.alpaca.vn/test-schema/new-schema";
//	public static String JUPITER_LOGIN_DEV_ENV_URL="http://61.14.237.89:3201/login";
	public static long LONG_TIMEOUT=30;
	public static long SHORT_TIMEOUT=10;
	public static String BROWSER_LOG_FOLDER=ROOT_FOLDER+"\\browserLog";
	public static String DOWNLOAD_FOLDER=ROOT_FOLDER+"\\bdownloadFiles";
	public static String UPLOAD_FOLDER=ROOT_FOLDER+"\\uploadFiles\\";
	//public static String TEST_DATA_EXCEL_FILE_NAME=System.getProperty("user.dir")+"/src/test/resources/datatest/DataTable.xlsx";
	public static String TEST_DATA_EXCEL_FILE_NAME=System.getProperty("user.dir")+"/src/test/resources/datatest/PBDataTable.xlsx";
	public static String FILE_NAME="file.xlsx";
	public static String TEST_DATA_CSV_FILE_NAME=System.getProperty("user.dir")+"/src/test/resources/datatest/TNDSTNDataTable.csv";
	//public static String TEST_DATA_EXCEL_FILE_NAME1=System.getProperty("user.dir")+"/src/test/resources/datatest/TNDSTNDataTableOut.xlsx";

	
	//protected static Log log;
	
	//Constants: dữ liệu ko dc phép thay đổi trong quá trình run
	//Dùng chung cho toàn bộ Framework (system)
	//Bất kì class/package nào cũng có thể use class này dc
	//URL hay server/DB/User, Pass
	//Folder path/ Setting/.....
}
