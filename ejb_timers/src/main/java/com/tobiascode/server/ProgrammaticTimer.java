package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class ProgrammaticTimer {
    @Resource
    private TimerService timerService;

    private Logger log = Logger.getLogger(this.getClass().getName());
    private TimerConfig timerConfig;
    private final String timerInfo = "5SecondProgrammaticTimer";

    @PostConstruct
    private void initialise(){
        timerConfig = new TimerConfig();
        timerConfig.setInfo(timerInfo);
        timerConfig.setPersistent(false);
    }

    public void startTimer(){
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.second("*/5");
        scheduleExpression.minute("*");
        scheduleExpression.hour("*");

        log.info("Starting timer");

        timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }

    public void stopTimer(){
        for (Timer timer: timerService.getTimers()){
            if((String)timer.getInfo() == timerInfo){
                log.info("Stopping timer");

                timer.cancel();
            }
        }
    }

    @Timeout
    private void fireTimer(Timer timer){
        log.info("Timer method fired: " + (String)timer.getInfo());
    }
}
