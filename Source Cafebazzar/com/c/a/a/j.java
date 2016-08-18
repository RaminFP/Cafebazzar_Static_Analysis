package com.c.a.a;

import d.ab;
import d.f;
import d.m;
import java.io.IOException;

class j extends m {
    private boolean a;

    public j(ab abVar) {
        super(abVar);
    }

    protected void a() {
    }

    public final void a_(f fVar, long j) {
        if (this.a) {
            fVar.f(j);
            return;
        }
        try {
            super.a_(fVar, j);
        } catch (IOException e) {
            this.a = true;
            a();
        }
    }

    public void close() {
        if (!this.a) {
            try {
                super.close();
            } catch (IOException e) {
                this.a = true;
                a();
            }
        }
    }

    public void flush() {
        if (!this.a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.a = true;
                a();
            }
        }
    }
}
