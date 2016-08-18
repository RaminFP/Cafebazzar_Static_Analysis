package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.c.a.k;
import android.support.v4.view.bp;
import android.support.v7.a.b;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
    private static final int[] TINT_ATTRS = new int[]{16843067, 16843068};
    private Bitmap mSampleTile;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.a) {
            bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            Drawable b = a.b(0);
            if (b != null) {
                setIndeterminateDrawable(tileifyIndeterminate(b));
            }
            b = a.b(1);
            if (b != null) {
                setProgressDrawable(tileify(b, false));
            }
            a.a.recycle();
        }
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable tileify(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof k) {
            a = ((k) drawable).a();
            if (a == null) {
                return drawable;
            }
            ((k) drawable).a(tileify(a, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                boolean z2 = id == 16908301 || id == 16908303;
                drawableArr[i2] = tileify(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            a = new ShapeDrawable(getDrawableShape());
            a.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            return z ? new ClipDrawable(a, 3, 1) : a;
        }
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable tileify = tileify(animationDrawable.getFrame(i), true);
            tileify.setLevel(10000);
            animationDrawable2.addFrame(tileify, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    protected void onMeasure(int i, int i2) {
        synchronized (this) {
            super.onMeasure(i, i2);
            if (this.mSampleTile != null) {
                setMeasuredDimension(bp.a(this.mSampleTile.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
            }
        }
    }
}
