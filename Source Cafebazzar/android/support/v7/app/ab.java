package android.support.v7.app;

import android.content.Context;
import android.support.v7.internal.widget.bi;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

final class ab extends FrameLayout {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    public ab(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
        this.a = appCompatDelegateImplV7;
        super(context);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            x = (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) ? true : 0;
            if (x != 0) {
                AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.a;
                appCompatDelegateImplV7.a(appCompatDelegateImplV7.e(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(bi.a(getContext(), i));
    }
}
