package com.farsitel.bazaar.activity;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

final class cj implements OnTouchListener {
    final /* synthetic */ ScreenshotActivity a;
    private float b;
    private float c;
    private final int d = 50;
    private boolean e;

    cj(ScreenshotActivity screenshotActivity) {
        this.a = screenshotActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        boolean z2;
        switch (motionEvent.getAction()) {
            case 0:
                this.b = motionEvent.getX();
                this.c = motionEvent.getY();
                this.e = false;
                break;
            case 1:
                if (!this.e) {
                    z2 = this.b + 50.0f > motionEvent.getX() && this.b - 50.0f < motionEvent.getX();
                    if (this.c + 50.0f <= motionEvent.getY() || this.c - 50.0f >= motionEvent.getY()) {
                        z = false;
                    }
                    if (z2 && r1) {
                        View focusedChild = this.a.b.getFocusedChild();
                        if (focusedChild != null) {
                            Drawable drawable = ((ImageView) focusedChild.findViewById(2131624416)).getDrawable();
                            if (drawable != null) {
                                if (ScreenshotActivity.a(this.a, this.b, this.c, (double) (((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight())))) {
                                    this.a.finish();
                                }
                            } else {
                                drawable = ((ImageView) focusedChild.findViewById(2131624417)).getDrawable();
                                if (drawable != null) {
                                    if (ScreenshotActivity.a(this.a, this.b, this.c, (double) (((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight())))) {
                                        this.a.finish();
                                    }
                                }
                            }
                        }
                        if (!this.a.a) {
                            ScreenshotActivity.l(this.a);
                            break;
                        }
                        this.a.a();
                        break;
                    }
                }
                break;
            case 2:
                z2 = this.b + 50.0f > motionEvent.getX() && this.b - 50.0f < motionEvent.getX();
                boolean z3 = this.c + 50.0f > motionEvent.getY() && this.c - 50.0f < motionEvent.getY();
                if (!(z2 && z3)) {
                    this.e = true;
                    break;
                }
                break;
        }
        return false;
    }
}
