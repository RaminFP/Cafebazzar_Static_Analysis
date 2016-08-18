package com.android.a;

public final class f implements v {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public f() {
        this(2500, 1, 1.0f);
    }

    private f(int i, int i2, float f) {
        this.a = 2500;
        this.c = 1;
        this.d = 1.0f;
    }

    public final int a() {
        return this.a;
    }

    public final void a(y yVar) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if ((this.b <= this.c ? 1 : null) == null) {
            throw yVar;
        }
    }

    public final int b() {
        return this.b;
    }
}
