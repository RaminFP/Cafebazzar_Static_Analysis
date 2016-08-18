package com.farsitel.bazaar.d;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.farsitel.bazaar.BazaarApplication;

final class at extends FragmentPagerAdapter {
    final /* synthetic */ am a;
    private final int b = 3;

    public at(am amVar, FragmentManager fragmentManager) {
        this.a = amVar;
        super(fragmentManager);
    }

    public final int getCount() {
        return 3;
    }

    public final Fragment getItem(int i) {
        Fragment l;
        if (BazaarApplication.c().b()) {
            i = 2 - i;
        }
        switch (i) {
            case 0:
                l = af.l();
                break;
            case 1:
                Intent intent = new Intent();
                intent.setData(Uri.parse("bazaar://webview?title=" + this.a.getString(2131165688) + "&url" + "=" + Uri.encode("https://cafebazaar.ir/login/bysession?key=%s&next=/account/cli-transactions?l=" + (BazaarApplication.c().b() ? "fa" : "en")) + "&is_internal" + "=true" + "&login" + "=true"));
                l = cb.a(intent);
                break;
            case 2:
                l = br.c();
                break;
            default:
                l = af.l();
                break;
        }
        ((y) l).i();
        return l;
    }

    public final CharSequence getPageTitle(int i) {
        if (BazaarApplication.c().b()) {
            i = 2 - i;
        }
        switch (i) {
            case 0:
                return "/Purchases/Apps";
            case 1:
                return "/Purchases/Transactions";
            case 2:
                return "/Purchases/Subscriptions";
            default:
                return "";
        }
    }
}
