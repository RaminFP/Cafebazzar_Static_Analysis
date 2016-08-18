package com.farsitel.bazaar.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

public final class o extends Animation {
    public boolean a = false;
    private Camera b;
    private View c;
    private View d;
    private float e;
    private float f;
    private boolean g = true;

    public o(View view, View view2) {
        this.c = view;
        this.d = view2;
        setDuration(500);
        setInterpolator(new DecelerateInterpolator());
        setFillAfter(false);
        if (view2.getVisibility() == 0) {
            this.g = false;
            View view3 = this.d;
            this.d = this.c;
            this.c = view3;
        }
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = (float) (((((double) f) * 3.141592653589793d) * 180.0d) / 3.141592653589793d);
        if (f >= 0.5f) {
            f2 -= 180.0f;
            this.c.setVisibility(4);
            this.d.setVisibility(0);
        }
        if (this.g) {
            f2 = -f2;
        }
        Matrix matrix = transformation.getMatrix();
        this.b.save();
        if (this.a) {
            this.b.rotateY(f2);
        } else {
            this.b.rotateX(f2);
        }
        this.b.getMatrix(matrix);
        this.b.restore();
        matrix.preTranslate(-this.e, -this.f);
        matrix.postTranslate(this.e, this.f);
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.e = (float) (i / 2);
        this.f = (float) (i2 / 2);
        this.b = new Camera();
    }
}
