package com.farsitel.bazaar.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class g {
    public static float a(float f, float f2) {
        return f <= f2 ? f - ((f * f) / (2.0f * f2)) : f2 / 2.0f;
    }

    public static void a(Context context, View view, float f) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968594);
        loadAnimation.setStartOffset((long) (100.0f * f));
        view.setAnimation(loadAnimation);
    }

    public static void b(Context context, View view, float f) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968598);
        loadAnimation.setStartOffset(0);
        view.setAnimation(loadAnimation);
    }

    public static void c(Context context, View view, float f) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968601);
        loadAnimation.setStartOffset(0);
        view.setAnimation(loadAnimation);
    }

    public static void d(Context context, View view, float f) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968615);
        loadAnimation.setStartOffset((long) (100.0f * f));
        view.setAnimation(loadAnimation);
    }
}
