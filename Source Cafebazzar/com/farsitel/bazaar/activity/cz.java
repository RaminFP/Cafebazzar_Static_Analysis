package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.x;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g;

final class cz extends m {
    private final String a;

    public cz(Activity activity, String str) {
        super(activity, 2131165628);
        this.a = str;
        String string = BazaarApplication.c().getString(2131165827);
        String string2 = BazaarApplication.c().getString(2131165826);
        String string3 = BazaarApplication.c().getString(2131165294);
        int i = this.a.equals("fa") ? 0 : !this.a.equals("en") ? this.a.equals("DEFAULT") ? 2 : 0 : 1;
        View inflate = LayoutInflater.from(this.f).inflate(2130903099, null);
        ListView listView = (ListView) inflate.findViewById(16908298);
        listView.setSelector(g.selector);
        listView.setAdapter(new x(this.f, new String[]{string, string2, string3}, i));
        listView.setOnItemClickListener(new da(this));
        a(inflate);
    }
}
