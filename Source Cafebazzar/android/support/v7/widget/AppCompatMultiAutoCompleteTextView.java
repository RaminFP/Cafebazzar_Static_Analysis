package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.a.b;
import android.support.v7.internal.widget.bf;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView {
    private static final int[] TINT_ATTRS = new int[]{16842964, 16843126};
    private bh mBackgroundTint;
    private bh mInternalBackgroundTint;
    private bi mTintManager;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(bf.a(context), attributeSet, i);
        if (bi.a) {
            bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            this.mTintManager = a.a();
            if (a.d(0)) {
                ColorStateList a2 = a.a().a(a.e(0, -1));
                if (a2 != null) {
                    setInternalBackgroundTint(a2);
                }
            }
            if (a.d(1)) {
                setDropDownBackgroundDrawable(a.a(1));
            }
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

    public void setDropDownBackgroundResource(int i) {
        if (this.mTintManager != null) {
            setDropDownBackgroundDrawable(this.mTintManager.a(i, false));
        } else {
            super.setDropDownBackgroundResource(i);
        }
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
