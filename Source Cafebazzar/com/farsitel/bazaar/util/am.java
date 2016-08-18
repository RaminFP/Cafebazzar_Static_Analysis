package com.farsitel.bazaar.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.c.b.bg;

public final class am implements bg {
    private final int a;
    private final int b = 0;

    public am(int i, int i2) {
        this.a = i;
    }

    public final Bitmap a(Bitmap bitmap) {
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            new Canvas(createBitmap).drawRoundRect(new RectF((float) this.b, (float) this.b, (float) (bitmap.getWidth() - this.b), (float) (bitmap.getHeight() - this.b)), (float) this.a, (float) this.a, paint);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    public final String a() {
        return "rounded";
    }
}
