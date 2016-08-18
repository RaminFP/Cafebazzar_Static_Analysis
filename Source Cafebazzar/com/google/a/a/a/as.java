package com.google.a.a.a;

public final class as {
    private static ap a;

    public static void a(String str) {
        at b = b();
        if (b != null) {
            b.d(str);
        }
    }

    public static boolean a() {
        return b() != null ? au.VERBOSE.equals(b().a()) : false;
    }

    private static at b() {
        if (a == null) {
            a = ap.a();
        }
        return a != null ? a.c : null;
    }

    public static void b(String str) {
        at b = b();
        if (b != null) {
            b.b(str);
        }
    }

    public static void c(String str) {
        at b = b();
        if (b != null) {
            b.a(str);
        }
    }

    public static void d(String str) {
        at b = b();
        if (b != null) {
            b.c(str);
        }
    }
}
