package com.c.b;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class aw {
    private static final long s = TimeUnit.SECONDS.toNanos(5);
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final Config q;
    public final int r;

    private aw(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, int i4) {
        this.d = uri;
        this.e = i;
        this.f = str;
        if (list == null) {
            this.g = null;
        } else {
            this.g = Collections.unmodifiableList(list);
        }
        this.h = i2;
        this.i = i3;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = z4;
        this.q = config;
        this.r = i4;
    }

    final String a() {
        long nanoTime = System.nanoTime() - this.b;
        return nanoTime > s ? b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's' : b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    final String b() {
        return "[R" + this.a + ']';
    }

    public final boolean c() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    final boolean d() {
        return c() || this.m != 0.0f;
    }

    final boolean e() {
        return this.g != null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.e > 0) {
            stringBuilder.append(this.e);
        } else {
            stringBuilder.append(this.d);
        }
        if (!(this.g == null || this.g.isEmpty())) {
            for (bg a : this.g) {
                stringBuilder.append(' ').append(a.a());
            }
        }
        if (this.f != null) {
            stringBuilder.append(" stableKey(").append(this.f).append(')');
        }
        if (this.h > 0) {
            stringBuilder.append(" resize(").append(this.h).append(',').append(this.i).append(')');
        }
        if (this.j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.k) {
            stringBuilder.append(" centerInside");
        }
        if (this.m != 0.0f) {
            stringBuilder.append(" rotation(").append(this.m);
            if (this.p) {
                stringBuilder.append(" @ ").append(this.n).append(',').append(this.o);
            }
            stringBuilder.append(')');
        }
        if (this.q != null) {
            stringBuilder.append(' ').append(this.q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
