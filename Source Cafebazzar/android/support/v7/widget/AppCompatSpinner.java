package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

public class AppCompatSpinner extends Spinner {
    private static final int[] TINT_ATTRS = new int[]{16842964, 16843126};
    private bh mBackgroundTint;
    private bh mInternalBackgroundTint;
    private bi mTintManager;

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.a) {
            bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            if (a.d(0)) {
                ColorStateList a2 = a.a().a(a.e(0, -1));
                if (a2 != null) {
                    setInternalBackgroundTint(a2);
                }
            }
            if (a.d(1)) {
                Drawable a3 = a.a(1);
                if (VERSION.SDK_INT >= 16) {
                    setPopupBackgroundDrawable(a3);
                } else if (VERSION.SDK_INT >= 11) {
                    setPopupBackgroundDrawableV11(this, a3);
                }
            }
            this.mTintManager = a.a();
            a.a.recycle();
        }
    }

    private void applySupportBackgroundTint() {
        if (getBackground() == null) {
            return;
        }
        if (this.mBackgroundTint != null) {
            bi.a((View) this, this.mBackgroundTint);
        } else if (this.mInternalBackgroundTint != null) {
            bi.a((View) this, this.mInternalBackgroundTint);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new bh();
            }
            this.mInternalBackgroundTint.a = colorStateList;
            this.mInternalBackgroundTint.d = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    @TargetApi(11)
    private static void setPopupBackgroundDrawableV11(Spinner spinner, Drawable drawable) {
        try {
            Field declaredField = Spinner.class.getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(spinner);
            if (obj instanceof ListPopupWindow) {
                ((ListPopupWindow) obj).setBackgroundDrawable(drawable);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        applySupportBackgroundTint();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTint != null ? this.mBackgroundTint.a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTint != null ? this.mBackgroundTint.b : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.mTintManager != null ? this.mTintManager.a(i) : null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new bh();
        }
        this.mBackgroundTint.a = colorStateList;
        this.mBackgroundTint.d = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new bh();
        }
        this.mBackgroundTint.b = mode;
        this.mBackgroundTint.c = true;
        applySupportBackgroundTint();
    }
}
