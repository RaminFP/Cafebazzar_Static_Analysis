package com.c.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

final class z extends a {
    m m;

    z(aj ajVar, ImageView imageView, aw awVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, m mVar, boolean z) {
        super(ajVar, imageView, awVar, i, i2, i3, drawable, str, obj, z);
        this.m = mVar;
    }

    public final void a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.m != null) {
                this.m.b();
            }
        }
    }

    public final void a(Bitmap bitmap, ap apVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            ap apVar2 = apVar;
            at.a(imageView, this.a.e, bitmap2, apVar2, this.d, this.a.m);
            if (this.m != null) {
                this.m.a();
            }
        }
    }

    final void b() {
        super.b();
        if (this.m != null) {
            this.m = null;
        }
    }
}
