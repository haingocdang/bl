package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logger {
	static Log log;
	
	public static Log initLog() {
		log=LogFactory.getLog(Logger.class);
		return log;
	}

}
