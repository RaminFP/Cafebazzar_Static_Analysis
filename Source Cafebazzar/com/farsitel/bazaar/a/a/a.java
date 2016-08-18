package com.farsitel.bazaar.a.a;

import android.os.Handler;

public final class a {
    private static Handler a = new Handler();
    private static String b;
    private static int c;
    private static Thread d;

    public static void a(String str, int i) {
        if (str != null && i > 0 && i <= 5) {
            if (d != null) {
                d.interrupt();
            }
            b = str;
            c = i;
            Thread bVar = new b();
            d = bVar;
            bVar.start();
        }
    }
}
