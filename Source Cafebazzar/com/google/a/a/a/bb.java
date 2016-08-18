package com.google.a.a.a;

import android.content.Context;
import android.util.DisplayMetrics;

final class bb implements n {
    private static bb a;
    private static Object b = new Object();
    private final Context c;

    private bb(Context context) {
        this.c = context;
    }

    public static bb a() {
        bb bbVar;
        synchronized (b) {
            bbVar = a;
        }
        return bbVar;
    }

    public static void a(Context context) {
        synchronized (b) {
            if (a == null) {
                a = new bb(context);
            }
        }
    }

    public final String a(String str) {
        if (!str.equals("&sr")) {
            return null;
        }
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
}
