package hu.gaborbalazs.practice.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
public class SchedulerEjb {

    @Inject
    private Logger logger;

    @Schedule(second = "*/20", minute = "*", hour = "*", persistent = false)
    public void logScheduler() {
        logger.info("I am alive");
    }
}
