package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.farsitel.bazaar.a.aa;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g;

final class db extends m {
    private final String a;

    public db(Activity activity, String str) {
        super(activity, 2131165711);
        this.a = str;
        String string = this.f.getString(2131165454);
        String string2 = this.f.getString(2131165453);
        int i = this.a.equals("network_type_wifi_3g") ? 0 : 1;
        View inflate = LayoutInflater.from(this.f).inflate(2130903099, null);
        ListView listView = (ListView) inflate.findViewById(16908298);
        listView.setSelector(g.selector);
        listView.setAdapter(new aa(this.f, new String[]{string, string2}, i));
        listView.setOnItemClickListener(new dc(this));
        a(inflate);
    }
}
