package com.farsitel.bazaar.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.farsitel.bazaar.g.i;

final class dy extends FragmentPagerAdapter {
    final /* synthetic */ dp a;
    private i[] b;

    public dy(dp dpVar, FragmentManager fragmentManager, i[] iVarArr) {
        this.a = dpVar;
        super(fragmentManager);
        this.b = iVarArr;
    }

    public final u a(int i) {
        return u.a(this.b[i].a.replace("page?slug=", ""), this.b[i].b, this.b[i].c == null ? "top-charts" : this.b[i].c, false);
    }

    public final int getCount() {
        return this.b.length;
    }

    public final /* synthetic */ Fragment getItem(int i) {
        return a(i);
    }

    public final CharSequence getPageTitle(int i) {
        return this.b[i].b;
    }
}
