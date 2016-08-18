package com.android.a;

public final class s {
    public final Object a;
    public final c b;
    public final y c;
    public boolean d;

    private s(y yVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = yVar;
    }

    public s(Object obj, c cVar) {
        this.d = false;
        this.a = obj;
        this.b = cVar;
        this.c = null;
    }

    public static s a(y yVar) {
        return new s(yVar);
    }
}
