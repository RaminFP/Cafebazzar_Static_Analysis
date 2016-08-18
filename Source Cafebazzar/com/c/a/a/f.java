package com.c.a.a;

import d.ab;
import java.io.FileNotFoundException;

public final class f {
    final h a;
    final boolean[] b;
    boolean c;
    final /* synthetic */ b d;
    private boolean e;

    private f(b bVar, h hVar) {
        this.d = bVar;
        this.a = hVar;
        this.b = hVar.e ? null : new boolean[bVar.j];
    }

    public final ab a(int i) {
        ab gVar;
        synchronized (this.d) {
            if (this.a.f != this) {
                throw new IllegalStateException();
            }
            if (!this.a.e) {
                this.b[i] = true;
            }
            try {
                gVar = new g(this, this.d.c.b(this.a.d[i]));
            } catch (FileNotFoundException e) {
                gVar = b.u;
            }
        }
        return gVar;
    }

    public final void a() {
        synchronized (this.d) {
            if (this.c) {
                this.d.a(this, false);
                this.d.a(this.a);
            } else {
                this.d.a(this, true);
            }
            this.e = true;
        }
    }

    public final void b() {
        synchronized (this.d) {
            this.d.a(this, false);
        }
    }
}
