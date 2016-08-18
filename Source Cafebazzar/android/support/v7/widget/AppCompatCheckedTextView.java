package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS = new int[]{16843016};
    private bi mTintManager;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.a) {
            bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
            setCheckMarkDrawable(a.a(0));
            a.a.recycle();
            this.mTintManager = a.a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.mTintManager != null) {
            setCheckMarkDrawable(this.mTintManager.a(i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }
}
