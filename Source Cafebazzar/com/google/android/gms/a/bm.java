package com.google.android.gms.a;

import android.os.Binder;

public abstract class bm {
    static br a = null;
    private static final Object d = new Object();
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String b;
    protected final Object c;
    private Object g = null;

    protected bm(String str, Object obj) {
        this.b = str;
        this.c = obj;
    }

    public static int a() {
        return e;
    }

    public static bm a(String str, Integer num) {
        return new bp(str, num);
    }

    public static bm a(String str, Long l) {
        return new bo(str, l);
    }

    public static bm a(String str, String str2) {
        return new bq(str, str2);
    }

    public static bm a(String str, boolean z) {
        return new bn(str, Boolean.valueOf(z));
    }

    public static boolean b() {
        return a != null;
    }

    protected abstract Object a(String str);

    public final Object c() {
        return this.g != null ? this.g : a(this.b);
    }

    public final Object d() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Object c = c();
            return c;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
