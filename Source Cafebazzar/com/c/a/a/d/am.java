package com.c.a.a.d;

import com.c.a.a.k;
import com.c.a.a.m;
import java.io.IOException;
import java.util.logging.Level;

final class am extends m {
    final /* synthetic */ ao b;
    final /* synthetic */ al c;

    am(al alVar, String str, Object[] objArr, ao aoVar) {
        this.c = alVar;
        this.b = aoVar;
        super(str, objArr);
    }

    public final void a() {
        try {
            this.c.c.m.a(this.b);
        } catch (Throwable e) {
            k.a.log(Level.INFO, "StreamHandler failure for " + this.c.c.o, e);
            try {
                this.b.a(a.PROTOCOL_ERROR);
            } catch (IOException e2) {
            }
        }
    }
}
