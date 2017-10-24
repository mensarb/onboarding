package com.mensarb.onboarder.animation;

/**
 * @author dkoller
 * @since 19.10.2017
 */

public class FlowingFrame {

    private int startColor;
    private int endColor;
    private int duration;

    public FlowingFrame(int startColor, int endColor, int duration) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.duration = duration;
    }

    public int getStartColor() {
        return startColor;
    }

    public int getEndColor() {
        return endColor;
    }

    public int getDuration() {
        return duration;
    }
}
