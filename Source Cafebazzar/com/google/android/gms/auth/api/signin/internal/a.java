package com.google.android.gms.auth.api.signin.internal;

public final class a {
    static int a = 31;
    public int b = 1;

    public final a a(Object obj) {
        this.b = (obj == null ? 0 : obj.hashCode()) + (a * this.b);
        return this;
    }

    public final a a(boolean z) {
        this.b = (z ? 1 : 0) + (a * this.b);
        return this;
    }
}
