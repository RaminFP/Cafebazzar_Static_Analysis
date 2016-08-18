package com.farsitel.bazaar.widget.listener;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class BazaarExpandableTextView extends ExpandableTextView {
    public BazaarExpandableTextView(Context context) {
        super(context);
    }

    public BazaarExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BazaarExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAction(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
        this.b.setVisibility(8);
    }

    public void setTextColor(String str) {
        this.a.setTextColor(Color.parseColor(str));
        this.b.setColorFilter(Color.parseColor(str));
    }
}
