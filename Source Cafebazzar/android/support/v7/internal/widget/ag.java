package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.a.l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public final class ag extends PopupWindow {
    private final boolean a;

    public ag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.a(context, attributeSet, l.PopupWindow, i, 0);
        this.a = a.a(l.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(a.a(l.PopupWindow_android_popupBackground));
        a.a.recycle();
        if (VERSION.SDK_INT < 14) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                declaredField2.set(this, new ah(declaredField, this, (OnScrollChangedListener) declaredField2.get(this)));
            } catch (Throwable e) {
                Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
            }
        }
    }

    public final void showAsDropDown(View view, int i, int i2) {
        if (VERSION.SDK_INT < 21 && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public final void showAsDropDown(View view, int i, int i2, int i3) {
        if (VERSION.SDK_INT < 21 && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public final void update(View view, int i, int i2, int i3, int i4) {
        int height = (VERSION.SDK_INT >= 21 || !this.a) ? i2 : i2 - view.getHeight();
        super.update(view, i, height, i3, i4);
    }
}
