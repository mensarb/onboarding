package com.mensarb.onboarder.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * @author dkoller
 * @since 19.10.2017
 */

public class FlowingHelper {

    public static Drawable getFrame(int startColor, int endColor){
        return new GradientDrawable(GradientDrawable.Orientation.TL_BR,  new int[]{startColor, endColor});
    }
}
