package com.c.b;

final class j implements Runnable {
    final /* synthetic */ bg a;

    j(bg bgVar) {
        this.a = bgVar;
    }

    public final void run() {
        throw new IllegalStateException("Transformation " + this.a.a() + " mutated input Bitmap but failed to recycle the original.");
    }
}
