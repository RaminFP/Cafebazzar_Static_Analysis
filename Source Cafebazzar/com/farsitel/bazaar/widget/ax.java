package com.farsitel.bazaar.widget;

import android.database.DataSetObserver;

final class ax extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private ax(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void onChanged() {
        this.a.a();
    }

    public final void onInvalidated() {
        this.a.a();
    }
}
