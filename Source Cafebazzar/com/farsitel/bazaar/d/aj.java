package com.farsitel.bazaar.d;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.farsitel.bazaar.activity.am;
import com.farsitel.bazaar.activity.br;
import com.farsitel.bazaar.activity.dp;
import com.farsitel.bazaar.activity.u;

public final class aj extends FragmentPagerAdapter {
    public final int a = 5;
    public ai[] b = new ai[5];

    public aj(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.b[0] = ai.a(0);
        this.b[1] = ai.a(1);
        this.b[2] = ai.a(2);
        this.b[3] = ai.a(3);
        this.b[4] = ai.a(4);
    }

    public static y a(int i) {
        switch (i) {
            case 0:
                return u.a("home", null, null);
            case 1:
                return dp.d();
            case 2:
                return am.d();
            case 3:
                return aw.b(null);
            case 4:
                return br.a();
            default:
                return null;
        }
    }

    public final int getCount() {
        return 5;
    }

    public final /* bridge */ /* synthetic */ Fragment getItem(int i) {
        return this.b[i];
    }

    public final CharSequence getPageTitle(int i) {
        return "Child Fragment " + i;
    }
}
