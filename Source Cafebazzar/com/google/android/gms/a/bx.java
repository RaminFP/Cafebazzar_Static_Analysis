package com.google.android.gms.a;

import android.content.Context;
import java.util.regex.Pattern;

public final class bx {
    private static Pattern a = null;

    public static int a(int i) {
        return i / 1000;
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
