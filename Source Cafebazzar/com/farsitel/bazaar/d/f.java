package com.farsitel.bazaar.d;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

final class f implements AnimationListener {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    f(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    public final void onAnimationEnd(Animation animation) {
        Animation animationSet = new AnimationSet(false);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(1000);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.25f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        TextView textView = (TextView) this.b.getView().findViewById(2131624305);
        textView.setText(this.b.getString(2131165340, Long.valueOf(this.a / 10)));
        textView.setAnimation(animationSet);
        animationSet.setAnimationListener(new g(this, textView));
        textView.setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
