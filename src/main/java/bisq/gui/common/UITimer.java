package bisq.gui.common;

import bisq.common.Timer;

import org.reactfx.util.FxTimer;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UITimer implements Timer {
    private final Logger log = LoggerFactory.getLogger(UITimer.class);
    private org.reactfx.util.Timer timer;

    public UITimer() {
    }

    @Override
    public Timer runLater(Duration delay, Runnable runnable) {
        if (timer == null) {
            timer = FxTimer.create(delay, runnable);
            timer.restart();
        } else {
            log.warn("runLater called on an already running timer.");
        }
        return this;
    }

    @Override
    public Timer runPeriodically(Duration interval, Runnable runnable) {
        if (timer == null) {
            timer = FxTimer.createPeriodic(interval, runnable);
            timer.restart();
        } else {
            log.warn("runPeriodically called on an already running timer.");
        }
        return this;
    }

    @Override
    public void stop() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }
}