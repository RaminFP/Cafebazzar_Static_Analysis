package com.c.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

public final class ay {
    private static final AtomicInteger g = new AtomicInteger();
    public final ax a;
    public boolean b;
    boolean c;
    public boolean d;
    public int e;
    public Drawable f;
    private final aj h;
    private int i;
    private int j;
    private int k;
    private Drawable l;
    private Object m;

    ay() {
        this.d = true;
        this.h = null;
        this.a = new ax(null, 0, null);
    }

    public ay(aj ajVar, Uri uri, int i) {
        this.d = true;
        if (ajVar.o) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.h = ajVar;
        this.a = new ax(uri, 0, ajVar.l);
    }

    private Drawable a() {
        return this.e != 0 ? this.h.e.getResources().getDrawable(this.e) : this.f;
    }

    public final ay a(int i, int i2) {
        this.a.a(i, i2);
        return this;
    }

    public final void a(ImageView imageView, m mVar) {
        long nanoTime = System.nanoTime();
        bj.a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        ax axVar = this.a;
        Object obj = (axVar.a == null && axVar.b == 0) ? null : 1;
        if (obj == null) {
            this.h.a((Object) imageView);
            if (this.d) {
                at.a(imageView, a());
                return;
            }
            return;
        }
        if (this.c) {
            axVar = this.a;
            obj = (axVar.d == 0 && axVar.e == 0) ? null : 1;
            if (obj != null) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.d) {
                    at.a(imageView, a());
                }
                this.h.j.put(imageView, new p(this, imageView, mVar));
                return;
            }
            this.a.a(width, height);
        }
        int andIncrement = g.getAndIncrement();
        ax axVar2 = this.a;
        if (axVar2.g && axVar2.f) {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        } else if (axVar2.f && axVar2.d == 0 && axVar2.e == 0) {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        } else if (axVar2.g && axVar2.d == 0 && axVar2.e == 0) {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        } else {
            if (axVar2.o == 0) {
                axVar2.o = aq.b;
            }
            aw awVar = new aw(axVar2.a, axVar2.b, axVar2.c, axVar2.m, axVar2.d, axVar2.e, axVar2.f, axVar2.g, axVar2.h, axVar2.i, axVar2.j, axVar2.k, axVar2.l, axVar2.n, axVar2.o);
            awVar.a = andIncrement;
            awVar.b = nanoTime;
            boolean z = this.h.n;
            if (z) {
                bj.a("Main", "created", awVar.b(), awVar.toString());
            }
            aj ajVar = this.h;
            aw a = ajVar.c.a(awVar);
            if (a == null) {
                throw new IllegalStateException("Request transformer " + ajVar.c.getClass().getCanonicalName() + " returned null for " + awVar);
            }
            if (a != awVar) {
                a.a = andIncrement;
                a.b = nanoTime;
                if (z) {
                    bj.a("Main", "changed", a.a(), "into " + a);
                }
            }
            String a2 = bj.a(a);
            if (ae.a(this.j)) {
                Bitmap a3 = this.h.a(a2);
                if (a3 != null) {
                    this.h.a((Object) imageView);
                    at.a(imageView, this.h.e, a3, ap.MEMORY, this.b, this.h.m);
                    if (this.h.n) {
                        bj.a("Main", "completed", a.b(), "from " + ap.MEMORY);
                    }
                    if (mVar != null) {
                        mVar.a();
                        return;
                    }
                    return;
                }
            }
            if (this.d) {
                at.a(imageView, a());
            }
            this.h.a(new z(this.h, imageView, a, this.j, this.k, this.i, this.l, a2, this.m, mVar, this.b));
        }
    }
}
