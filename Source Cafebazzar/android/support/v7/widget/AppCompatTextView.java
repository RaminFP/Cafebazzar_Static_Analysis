package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.l;
import android.support.v7.internal.b.a;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new a(getContext()) : null);
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
