package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class bx extends bw {
    bx() {
    }

    public final void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public final int h(View view) {
        return view.getLayoutDirection();
    }

    public final int l(View view) {
        return view.getPaddingStart();
    }

    public final int m(View view) {
        return view.getPaddingEnd();
    }

    public final int t(View view) {
        return view.getWindowSystemUiVisibility();
    }
}
