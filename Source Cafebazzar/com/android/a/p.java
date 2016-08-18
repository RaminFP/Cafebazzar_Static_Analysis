package com.android.a;

final class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ o c;

    p(o oVar, String str, long j) {
        this.c = oVar;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        this.c.m.a(this.a, this.b);
        this.c.m.a(toString());
    }
}
