package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton {
    private static final int[] TINT_ATTRS = new int[]{16843015};
    private Drawable mButtonDrawable;
    private bi mTintManager;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.a) {
            bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            setButtonDrawable(a.a(0));
            a.a.recycle();
            this.mTintManager = a.a();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return (VERSION.SDK_INT >= 17 || this.mButtonDrawable == null) ? compoundPaddingLeft : compoundPaddingLeft + this.mButtonDrawable.getIntrinsicWidth();
    }

    public void setButtonDrawable(int i) {
        if (this.mTintManager != null) {
            setButtonDrawable(this.mTintManager.a(i, false));
        } else {
            super.setButtonDrawable(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        this.mButtonDrawable = drawable;
    }
}
