package com.mensarb.onboarder.animation;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;

public class FlowingGradient {

    private int transitionDuration = 4000;
    private View layout;
    private AnimationDrawable animation;

    public FlowingGradient setTransitionDuration(int time) {
        this.transitionDuration = time;
        return this;
    }

    public FlowingGradient setAnimation(AnimationDrawable animation){
        this.animation = animation;
        return this;
    }

    public FlowingGradient layout(View layout) {
        this.layout = layout;
        return this;
    }

    public FlowingGradient start() {
        layout.setBackground(animation);

        animation.setEnterFadeDuration(transitionDuration);
        animation.setExitFadeDuration(transitionDuration);
        animation.start();

        return this;
    }
}