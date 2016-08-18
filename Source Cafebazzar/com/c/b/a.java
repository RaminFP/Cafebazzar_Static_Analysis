package com.c.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

abstract class a {
    final aj a;
    final aw b;
    final WeakReference c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    a(aj ajVar, Object obj, aw awVar, int i, int i2, int i3, Drawable drawable, String str, Object obj2, boolean z) {
        this.a = ajVar;
        this.b = awVar;
        this.c = obj == null ? null : new b(this, obj, ajVar.k);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        if (obj2 == null) {
            a aVar = this;
        }
        this.j = obj2;
    }

    abstract void a();

    abstract void a(Bitmap bitmap, ap apVar);

    void b() {
        this.l = true;
    }

    final Object c() {
        return this.c == null ? null : this.c.get();
    }
}
