package com.google.android.gms.a;

public abstract class dl {
    protected volatile int A = -1;

    public dl a() {
        return (dl) super.clone();
    }

    public abstract dl a(dc dcVar);

    public void a(dd ddVar) {
    }

    protected int b() {
        return 0;
    }

    public final int c() {
        if (this.A < 0) {
            d();
        }
        return this.A;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public final int d() {
        int b = b();
        this.A = b;
        return b;
    }

    public String toString() {
        return dm.a(this);
    }
}
