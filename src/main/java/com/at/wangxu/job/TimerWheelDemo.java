package com.at.wangxu.job;

import org.agrona.DeadlineTimerWheel;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 时间轮算法 demo
 */
public class TimerWheelDemo {

    static Clock clock = Clock.systemDefaultZone();

    static final int DEFAULT_TICKS_PER_WHEEL = 512;
    static final long DEFAULT_TICK_RESOLUTION = 256L;
    static final int initialTickAllocation = 32;
    static final int TICK_MAX_CHECK_NUM = 65536;
    static DeadlineTimerWheel.TimerHandler timerHandler = (timeUnit, now, timerId) -> false;

    static final DeadlineTimerWheel TIMER_WHEEL = new DeadlineTimerWheel(
            TimeUnit.MILLISECONDS, clock.millis(), DEFAULT_TICK_RESOLUTION, DEFAULT_TICKS_PER_WHEEL, initialTickAllocation
    );


    public static void main(String[] args) {
        long deadline = clock.millis() + Duration.ofSeconds(10).toMillis();
        TIMER_WHEEL.scheduleTimer(deadline);
        long now = clock.instant().toEpochMilli();
        TIMER_WHEEL.poll(now,timerHandler,TICK_MAX_CHECK_NUM);

        while (TIMER_WHEEL.currentTickTime() < now) {
            System.out.println(" -- not arrive deadline");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("arrive deadline");
    }
}
