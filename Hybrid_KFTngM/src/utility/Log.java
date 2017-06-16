package utility;

import org.apache.log4j.Logger;

/**
 * Created by india on 5/18/2017.
 */
public class Log {

    private static Logger log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){

        log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("$$$$$$$$$$$$$$"+ sTestCaseName+ "started" +"$$$$$$$$$$$$$$$$$$$");


    }

    public static void endTestCase(String sTestCaseName){

        log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("$$$$$$$$$$$$$$"+ sTestCaseName+ "finished" +"$$$$$$$$$$$$$$$$$$$");


    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
       log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}



