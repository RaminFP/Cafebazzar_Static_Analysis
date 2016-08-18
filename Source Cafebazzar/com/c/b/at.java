package com.c.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;

final class at extends BitmapDrawable {
    private static final Paint e = new Paint();
    Drawable a;
    long b;
    boolean c;
    int d = 255;
    private final boolean f;
    private final float g;
    private final ap h;

    private at(Context context, Bitmap bitmap, Drawable drawable, ap apVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f = z2;
        this.g = context.getResources().getDisplayMetrics().density;
        this.h = apVar;
        boolean z3 = (apVar == ap.MEMORY || z) ? false : true;
        if (z3) {
            this.a = drawable;
            this.c = true;
            this.b = SystemClock.uptimeMillis();
        }
    }

    private static Path a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    static void a(ImageView imageView, Context context, Bitmap bitmap, ap apVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new at(context, bitmap, drawable, apVar, z, z2));
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    public final void draw(Canvas canvas) {
        if (this.c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.c = false;
                this.a = null;
                super.draw(canvas);
            } else {
                if (this.a != null) {
                    this.a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.d)));
                super.draw(canvas);
                super.setAlpha(this.d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f) {
            e.setColor(-1);
            canvas.drawPath(a(new Point(0, 0), (int) (16.0f * this.g)), e);
            e.setColor(this.h.d);
            canvas.drawPath(a(new Point(0, 0), (int) (15.0f * this.g)), e);
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public final void setAlpha(int i) {
        this.d = i;
        if (this.a != null) {
            this.a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
