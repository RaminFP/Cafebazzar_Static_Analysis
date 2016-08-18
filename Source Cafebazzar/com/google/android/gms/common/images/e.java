package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.a.bs;
import com.google.android.gms.a.bt;
import com.google.android.gms.a.bu;

public abstract class e {
    final f a;
    protected int b;
    protected int c;

    final void a(Context context, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            throw new IllegalArgumentException("null reference");
        }
        if ((this.c & 1) != 0) {
            bitmap = bs.a(bitmap);
        }
        a(new BitmapDrawable(context.getResources(), bitmap), false, true);
    }

    final void a(Context context, bt btVar, boolean z) {
        Drawable drawable;
        Bitmap bitmap = null;
        if (this.b != 0) {
            int i = this.b;
            Resources resources = context.getResources();
            if (this.c > 0) {
                bu buVar = new bu(i, this.c);
                drawable = (Drawable) btVar.a((Object) buVar);
                if (drawable == null) {
                    drawable = resources.getDrawable(i);
                    if ((this.c & 1) != 0) {
                        if (drawable != null) {
                            if (drawable instanceof BitmapDrawable) {
                                bitmap = ((BitmapDrawable) drawable).getBitmap();
                            } else {
                                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                                Canvas canvas = new Canvas(bitmap);
                                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                                drawable.draw(canvas);
                            }
                        }
                        drawable = new BitmapDrawable(resources, bs.a(bitmap));
                    }
                    btVar.a(buVar, drawable);
                }
            } else {
                drawable = resources.getDrawable(i);
            }
        } else {
            drawable = null;
        }
        a(drawable, false, false);
    }

    protected abstract void a(Drawable drawable, boolean z, boolean z2);
}
