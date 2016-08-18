package com.ms.square.android.expandabletextview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class a implements AnimationListener {
    final /* synthetic */ ExpandableTextView a;

    a(ExpandableTextView expandableTextView) {
        this.a = expandableTextView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.clearAnimation();
        this.a.n = false;
        if (this.a.o != null) {
            this.a.o;
            TextView textView = this.a.a;
            this.a.e;
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
        ExpandableTextView.a(this.a.a, this.a.m);
    }
}
