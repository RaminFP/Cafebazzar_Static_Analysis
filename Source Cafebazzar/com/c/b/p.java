package com.c.b;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

final class p implements OnPreDrawListener {
    final ay a;
    final WeakReference b;
    m c;

    p(ay ayVar, ImageView imageView, m mVar) {
        this.a = ayVar;
        this.b = new WeakReference(imageView);
        this.c = mVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final boolean onPreDraw() {
        ImageView imageView = (ImageView) this.b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    ay ayVar = this.a;
                    ayVar.c = false;
                    ayVar.a(width, height).a(imageView, this.c);
                }
            }
        }
        return true;
    }
}
