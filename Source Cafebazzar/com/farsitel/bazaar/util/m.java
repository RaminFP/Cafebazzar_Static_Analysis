package com.farsitel.bazaar.util;

import android.graphics.Color;

public final class m {
    public static int a(int i, int i2, float f) {
        return Color.rgb((int) ((((float) Color.red(i)) * f) + ((1.0f - f) * ((float) Color.red(i2)))), (int) ((((float) Color.green(i)) * f) + ((1.0f - f) * ((float) Color.green(i2)))), (int) ((((float) Color.blue(i)) * f) + ((1.0f - f) * ((float) Color.blue(i2)))));
    }
}
