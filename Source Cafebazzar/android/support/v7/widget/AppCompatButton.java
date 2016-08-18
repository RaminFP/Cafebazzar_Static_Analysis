package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import android.support.v7.a.l;
import android.support.v7.internal.b.a;
import android.support.v7.internal.widget.be;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton extends Button {
    private static final int[] TINT_ATTRS = new int[]{16842964};
    private bh mBackgroundTint;
    private bh mInternalBackgroundTint;
    private bi mTintManager;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        ColorStateList a;
        super(context, attributeSet, i);
        if (bi.a) {
            bk a2 = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            if (a2.d(0)) {
                a = a2.a().a(a2.e(0, -1));
                if (a != null) {
                    setInternalBackgroundTint(a);
                }
            }
            this.mTintManager = a2.a();
            a2.a.recycle();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(l.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, l.TextAppearance);
            if (obtainStyledAttributes.hasValue(l.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(l.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(l.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
        a = getTextColors();
        if (a != null && !a.isStateful()) {
            setTextColor(be.a(a.getDefaultColor(), VERSION.SDK_INT < 21 ? be.c(context, 16842808) : be.a(context, 16842808)));
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

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new a(getContext()) : null);
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, l.TextAppearance);
        if (obtainStyledAttributes.hasValue(l.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
