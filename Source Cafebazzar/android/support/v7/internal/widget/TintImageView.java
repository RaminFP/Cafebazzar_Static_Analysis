package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView extends ImageView {
    private static final int[] TINT_ATTRS = new int[]{16842964, 16843033};
    private final bi mTintManager;

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
        if (a.a.length() > 0) {
            if (a.d(0)) {
                setBackgroundDrawable(a.a(0));
            }
            if (a.d(1)) {
                setImageDrawable(a.a(1));
            }
        }
        a.a.recycle();
        this.mTintManager = a.a();
    }

    public void setImageResource(int i) {
        setImageDrawable(this.mTintManager.a(i, false));
    }
}
