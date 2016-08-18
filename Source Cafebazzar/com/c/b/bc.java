package com.c.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

final class bc {
    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final k b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    bc(k kVar) {
        this.b = kVar;
        this.a.start();
        bj.a(this.a.getLooper());
        this.c = new bd(this.a.getLooper(), this);
    }

    final void a() {
        this.c.sendEmptyMessage(0);
    }

    void a(Bitmap bitmap, int i) {
        this.c.sendMessage(this.c.obtainMessage(i, bj.a(bitmap), 0));
    }
}
