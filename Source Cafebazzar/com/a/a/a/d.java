package com.a.a.a;

import b.a.a.a.f;
import java.util.Locale;

final class d {
    final int a = 20;
    final int b = 100;
    boolean c;

    public d(int i, int i2, boolean z) {
        this.c = z;
    }

    public final String a(String str) {
        if (str.length() <= this.b) {
            return str;
        }
        a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(this.b)})));
        return str.substring(0, this.b);
    }

    void a(RuntimeException runtimeException) {
        if (this.c) {
            throw runtimeException;
        }
        f.a().c("Answers", "Invalid user input detected", runtimeException);
    }

    public final boolean a(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        a(new NullPointerException(str + " must not be null"));
        return true;
    }
}
