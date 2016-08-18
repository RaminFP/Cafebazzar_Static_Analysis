package com.a.a.c;

final class br extends bq {
    private final bq[] a;

    public br(bq... bqVarArr) {
        super(0, new bq[0]);
        this.a = bqVarArr;
    }

    public final int b() {
        int i = 0;
        for (bq b : this.a) {
            i += b.b();
        }
        return i;
    }

    public final void b(f fVar) {
        for (bq b : this.a) {
            b.b(fVar);
        }
    }
}
