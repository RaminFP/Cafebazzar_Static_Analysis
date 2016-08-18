package ir.cafebazaar.pardakht;

import android.util.Log;

public final class ab {
    public static boolean a = false;
    private static String b = null;
    private static long c = 0;
    private static boolean d = false;

    static void a(String str) {
        if (a) {
            Log.i("PasswordManager", "password validated now");
        }
        if (d) {
            b = str;
        }
        c = System.currentTimeMillis();
    }

    static void a(boolean z) {
        d = z;
    }

    static boolean a() {
        return (b() && d) ? false : true;
    }

    static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (a) {
            Log.i("PasswordManager", String.format("password alive? now = %d, last = %d, diff = %d, life = %d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(c), Long.valueOf(currentTimeMillis - c), Long.valueOf(1800000)}));
        }
        if (currentTimeMillis - c >= 1800000) {
            b = null;
            d = false;
        }
        return currentTimeMillis - c < 1800000;
    }

    static String c() {
        return b;
    }

    public static void d() {
        b = null;
        c = 0;
    }
}
