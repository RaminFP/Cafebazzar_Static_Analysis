package com.farsitel.bazaar.h;

import com.android.a.a.j;
import com.android.a.m;
import com.android.a.o;
import com.android.a.s;
import com.android.a.y;
import java.io.UnsupportedEncodingException;

public final class w extends o {
    u m;
    private ac n;
    private String o;
    private int p;
    private j q;

    public w(u uVar, int i) {
        super(1, uVar.a.a(), new x(i, uVar.a));
        this.m = uVar;
        this.n = new ac();
        this.p = i;
        this.o = this.n.a(this.m);
        this.j = new g();
    }

    public w(u uVar, j jVar) {
        super(1, uVar.a.a(), jVar);
        this.m = uVar;
        this.n = new ac();
        this.o = this.n.a(this.m);
        this.q = jVar;
        this.j = new g();
    }

    protected final s a(m mVar) {
        try {
            Object a = this.n.a(this.m, mVar.b);
            return a != null ? new s(a, null) : s.a(new y());
        } catch (Exception e) {
            e.printStackTrace();
            return s.a(new y());
        }
    }

    protected final void a(Object obj) {
        if (this.q != null) {
            this.q.a(obj);
        } else {
            v.a(obj, this.p);
        }
    }

    public final byte[] e() {
        try {
            return this.o.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
