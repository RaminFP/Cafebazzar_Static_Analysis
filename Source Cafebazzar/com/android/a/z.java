package com.android.a;

import android.util.Log;
import java.util.Locale;

public class z {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable("Volley", 2);

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.v(a, d(str, objArr));
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(a, d(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(z.class)) {
                String className = stackTrace[i].getClassName();
                className = className.substring(className.lastIndexOf(46) + 1);
                str2 = className.substring(className.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
