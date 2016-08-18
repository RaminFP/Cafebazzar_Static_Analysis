package com.farsitel.bazaar.h;

import com.android.a.v;
import com.android.a.y;

public final class g implements v {
    private int a = 30000;
    private int b;
    private final int c = 3;
    private final float d = 1.5f;

    public final int a() {
        return this.a;
    }

    public final void a(y yVar) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * 1.5f));
        if ((this.b <= 3 ? 1 : null) == null) {
            throw yVar;
        }
    }

    public final int b() {
        return this.b;
    }
}
