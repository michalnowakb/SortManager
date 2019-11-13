package com.sparta.mjn.manager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingManager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(LoggingManager.class.getName());

    public void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.trace("Logging initialised");
    }


}
