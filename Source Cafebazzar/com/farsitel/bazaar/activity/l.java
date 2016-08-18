package com.farsitel.bazaar.activity;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class l implements OnScrollListener {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.a.d();
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
