package com.ms.square.android.expandabletextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableTextView extends LinearLayout implements OnClickListener {
    private static final String c = ExpandableTextView.class.getSimpleName();
    public TextView a;
    public ImageButton b;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private int l;
    private float m;
    private boolean n;
    private d o;
    private SparseBooleanArray p;
    private int q;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        a(attributeSet);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        a(attributeSet);
    }

    @TargetApi(21)
    private static Drawable a(Context context, int i) {
        Resources resources = context.getResources();
        return (VERSION.SDK_INT >= 21 ? 1 : null) != null ? resources.getDrawable(i, context.getTheme()) : resources.getDrawable(i);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ExpandableTextView);
        this.h = obtainStyledAttributes.getInt(h.ExpandableTextView_maxCollapsedLines, 8);
        this.l = obtainStyledAttributes.getInt(h.ExpandableTextView_animDuration, 300);
        this.m = obtainStyledAttributes.getFloat(h.ExpandableTextView_animAlphaStart, 0.7f);
        this.j = obtainStyledAttributes.getDrawable(h.ExpandableTextView_expandDrawable);
        this.k = obtainStyledAttributes.getDrawable(h.ExpandableTextView_collapseDrawable);
        if (this.j == null) {
            this.j = a(getContext(), f.ic_expand_small_holo_light);
        }
        if (this.k == null) {
            this.k = a(getContext(), f.ic_collapse_small_holo_light);
        }
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    static /* synthetic */ void a(View view, float f) {
        if (VERSION.SDK_INT >= 11) {
            view.setAlpha(f);
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public CharSequence getText() {
        return this.a == null ? "" : this.a.getText();
    }

    public void onClick(View view) {
        if (this.b.getVisibility() == 0) {
            this.e = !this.e;
            this.b.setImageDrawable(this.e ? this.j : this.k);
            if (this.p != null) {
                this.p.put(this.q, this.e);
            }
            this.n = true;
            Animation cVar = this.e ? new c(this, this, getHeight(), this.f) : new c(this, this, getHeight(), (getHeight() + this.g) - this.a.getHeight());
            cVar.setFillAfter(true);
            cVar.setAnimationListener(new a(this));
            clearAnimation();
            startAnimation(cVar);
        }
    }

    protected void onFinishInflate() {
        this.a = (TextView) findViewById(g.expandable_text);
        this.a.setOnClickListener(this);
        this.b = (ImageButton) findViewById(g.expand_collapse);
        this.b.setImageDrawable(this.e ? this.j : this.k);
        this.b.setOnClickListener(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.n;
    }

    protected void onMeasure(int i, int i2) {
        if (!this.d || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.d = false;
        this.b.setVisibility(8);
        this.a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        if (this.a.getLineCount() > this.h) {
            TextView textView = this.a;
            this.g = (textView.getCompoundPaddingBottom() + textView.getCompoundPaddingTop()) + textView.getLayout().getLineTop(textView.getLineCount());
            if (this.e) {
                this.a.setMaxLines(this.h);
            }
            this.b.setVisibility(0);
            super.onMeasure(i, i2);
            if (this.e) {
                this.a.post(new b(this));
                this.f = getMeasuredHeight();
            }
        }
    }

    public void setOnExpandStateChangeListener(d dVar) {
        this.o = dVar;
    }

    public void setOrientation(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
        super.setOrientation(i);
    }

    public void setText(CharSequence charSequence) {
        this.d = true;
        this.a.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }
}
