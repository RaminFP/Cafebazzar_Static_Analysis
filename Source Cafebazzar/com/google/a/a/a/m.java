package com.google.a.a.a;

import android.util.Log;

final class m implements at {
    private au a = au.INFO;

    m() {
    }

    private static String e(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public final au a() {
        return this.a;
    }

    public final void a(au auVar) {
        this.a = auVar;
    }

    public final void a(String str) {
        if (this.a.ordinal() <= au.VERBOSE.ordinal()) {
            Log.v("GAV3", e(str));
        }
    }

    public final void b(String str) {
        if (this.a.ordinal() <= au.INFO.ordinal()) {
            Log.i("GAV3", e(str));
        }
    }

    public final void c(String str) {
        if (this.a.ordinal() <= au.WARNING.ordinal()) {
            Log.w("GAV3", e(str));
        }
    }

    public final void d(String str) {
        if (this.a.ordinal() <= au.ERROR.ordinal()) {
            Log.e("GAV3", e(str));
        }
    }
}
