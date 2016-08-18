package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.widget.BazaarTitleBar;
import com.farsitel.bazaar.widget.SlidingTabBar;
import com.farsitel.bazaar.widget.ViewPager;

public final class am extends y {
    private BazaarTitleBar a;
    private ViewPager b;
    private SlidingTabBar c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903118, viewGroup, false);
        this.a = (BazaarTitleBar) inflate.findViewById(2131624037);
        this.b = (ViewPager) inflate.findViewById(2131624311);
        this.c = (SlidingTabBar) inflate.findViewById(2131624115);
        this.c.a();
        this.a.setTitle(getString(2131165551));
        this.a.c();
        this.a.b();
        this.b.setAdapter(new at(this, getChildFragmentManager()));
        this.c.setAdapter(new an(this));
        this.c.setListPager(this.b);
        this.c.setOnTabChangeListener(new ar(this));
        this.c.setOnPageChangeListener(new as(this));
        if (BazaarApplication.c().b()) {
            this.b.setCurrentItem(2);
        }
        return inflate;
    }
}
