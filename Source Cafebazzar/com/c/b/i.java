package com.c.b;

final class i implements Runnable {
    final /* synthetic */ bg a;

    i(bg bgVar) {
        this.a = bgVar;
    }

    public final void run() {
        throw new IllegalStateException("Transformation " + this.a.a() + " returned input Bitmap but recycled it.");
    }
}
