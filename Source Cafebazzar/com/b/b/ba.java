package com.b.b;

import android.text.TextUtils;
import android.util.Log;

public final class ba {
    private static int a = 4000;
    private static boolean b = false;
    private static int c = 5;
    private static boolean d = false;

    public static void a() {
        b = true;
    }

    private static void a(int i, String str) {
        int length = TextUtils.isEmpty(str) ? 0 : str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = a > length - i2 ? length : a + i2;
            if (Log.println(i, "FlurryAgent", str.substring(i2, i3)) > 0) {
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public static void a(int i, String str, String str2) {
        c(i, str, str2);
    }

    public static void a(int i, String str, String str2, Throwable th) {
        c(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void a(String str, String str2) {
        b(3, str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    public static int b() {
        return c;
    }

    private static void b(int i, String str, String str2) {
        if (!b && c <= i) {
            a(i, str2);
        }
    }

    private static void b(int i, String str, String str2, Throwable th) {
        b(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void b(String str, String str2) {
        b(6, str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    private static void c(int i, String str, String str2) {
        if (d) {
            a(i, str2);
        }
    }

    public static void c(String str, String str2) {
        b(5, str, str2);
    }

    public static boolean c() {
        return d;
    }
}
