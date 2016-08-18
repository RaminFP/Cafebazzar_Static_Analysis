package com.farsitel.bazaar.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.farsitel.bazaar.BazaarApplication;

public class HorizontalListView extends HorizontalScrollView {
    private static int a = 0;
    private int b = Integer.MAX_VALUE;
    private LinearLayout c;
    private int d = 0;
    private BaseAdapter e;
    private int[] f;
    private int g;
    private View[] h;
    private OnItemSelectedListener i;
    private z j;
    private OnGlobalLayoutListener k;

    public HorizontalListView(Context context) {
        super(context);
        a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @TargetApi(9)
    private void a() {
        this.c = new LinearLayout(getContext());
        this.c.setOrientation(0);
        if (VERSION.SDK_INT < 14) {
            setHorizontalScrollBarEnabled(false);
        }
        addView(this.c, -2, -1);
    }

    protected void onDetachedFromWindow() {
        if (this.k != null) {
            if (VERSION.SDK_INT < 16) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.k);
            } else {
                getViewTreeObserver().removeOnGlobalLayoutListener(this.k);
            }
        }
        super.onDetachedFromWindow();
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.i != null && Math.abs(i - this.b) >= a) {
            this.b = i;
            int width = (int) ((((double) i) / ((double) this.d)) * ((double) this.c.getWidth()));
            for (int i5 = 0; i5 < this.f.length; i5++) {
                if (width <= this.f[i5]) {
                    this.i.onItemSelected(null, this.h[i5], i5, (long) this.h[i5].getId());
                    return;
                }
            }
        }
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        int i = 0;
        this.e = baseAdapter;
        this.f = new int[baseAdapter.getCount()];
        this.h = new View[baseAdapter.getCount()];
        this.c.removeAllViews();
        for (int i2 = 0; i2 < this.e.getCount(); i2++) {
            View view = this.e.getView(i2, null, null);
            if (BazaarApplication.c().b()) {
                this.c.addView(view, 0);
            } else {
                this.c.addView(view);
            }
            this.h[i2] = view;
        }
        while (i < this.f.length) {
            this.g += this.h[i].getLayoutParams().width;
            this.f[i] = this.g;
            i++;
        }
        this.d = this.g - getWidth();
        if (this.d > 0) {
            a = this.d / 25;
        } else if (this.i != null) {
            this.i.onItemSelected(null, null, -1, -1);
        }
        if (BazaarApplication.c().b()) {
            this.k = new y(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        }
    }

    public void setOnScrollListener(z zVar) {
        this.j = zVar;
    }
}
