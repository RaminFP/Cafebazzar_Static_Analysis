package com.farsitel.bazaar.activity;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class dz implements OnGlobalLayoutListener {
    final /* synthetic */ VideoPlayerActivity a;

    dz(VideoPlayerActivity videoPlayerActivity) {
        this.a = videoPlayerActivity;
    }

    public final void onGlobalLayout() {
        this.a.a(this.a.b.getWidth(), this.a.b.getHeight());
    }
}
