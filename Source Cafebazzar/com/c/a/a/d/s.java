package com.c.a.a.d;

import d.j;
import d.k;
import d.q;
import d.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class s {
    int a;
    final j b = r.a(this.c);
    private final q c;

    public s(j jVar) {
        this.c = new q(new t(this, jVar), new u(this));
    }

    private k a() {
        return this.b.c((long) this.b.i());
    }

    public final List a(int i) {
        this.a += i;
        int i2 = this.b.i();
        if (i2 < 0) {
            throw new IOException("numberOfPairs < 0: " + i2);
        } else if (i2 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + i2);
        } else {
            List arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                k c = a().c();
                k a = a();
                if (c.c.length == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new e(c, a));
            }
            if (this.a > 0) {
                this.c.b();
                if (this.a != 0) {
                    throw new IOException("compressedLimit > 0: " + this.a);
                }
            }
            return arrayList;
        }
    }
}
