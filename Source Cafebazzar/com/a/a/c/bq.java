package com.a.a.c;

abstract class bq {
    private final int a;
    private final bq[] b;

    public bq(int i, bq... bqVarArr) {
        this.a = i;
        if (bqVarArr == null) {
            bqVarArr = bg.b;
        }
        this.b = bqVarArr;
    }

    private int c() {
        int a = a();
        for (bq b : this.b) {
            a += b.b();
        }
        return a;
    }

    public int a() {
        return 0;
    }

    public void a(f fVar) {
    }

    public int b() {
        int c = c();
        return (c + f.c(c)) + f.a(this.a);
    }

    public void b(f fVar) {
        fVar.g(this.a, 2);
        fVar.b(c());
        a(fVar);
        for (bq b : this.b) {
            b.b(fVar);
        }
    }
}
