package com.farsitel.bazaar.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.farsitel.bazaar.BazaarApplication;

public final class o {
    private static int a = -1;
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static float e;
    private static boolean f;
    private static int g = -1;

    public static String a() {
        return b;
    }

    public static void a(Context context) {
        if (a < 0) {
            int integer = context.getResources().getInteger(2131296272);
            a = integer;
            switch (integer) {
                case 0:
                    b = "s";
                    break;
                case 1:
                    b = "m";
                    break;
                case 2:
                    b = "l";
                    break;
                case 3:
                    b = "x";
                    break;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            integer = displayMetrics.densityDpi;
            g = integer;
            if (integer >= 320) {
                c = "128x128";
                d = "128x128";
            } else if (g >= 213) {
                c = "72x72";
                d = "128x128";
            } else {
                c = "48x48";
                d = "72x72";
            }
            e = context.getResources().getDisplayMetrics().density;
            f = context.getResources().getBoolean(2131492867);
        }
    }

    public static String b() {
        return c;
    }

    public static String c() {
        return d;
    }

    public static float d() {
        return e;
    }

    public static boolean e() {
        return f;
    }

    public static int f() {
        return BazaarApplication.c().getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int g() {
        return g;
    }
}
