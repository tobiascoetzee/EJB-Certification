package com.tobiascode.server;

import javax.ejb.*;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class DeclarativeTimer {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @Schedule(second = "*/10", minute = "*", hour = "*", info = "Every10Seconds")
    private void timeoutTenSeconds(Timer timer){
        log.info("Timer method fired: " + (String)timer.getInfo());
    }

    @Schedule(second = "*/5", minute = "*", hour = "*", info = "Every5Seconds")
    private void timeoutFiveSeconds(Timer timer){
        log.info("Timer method fired: " + (String)timer.getInfo());
    }
}
