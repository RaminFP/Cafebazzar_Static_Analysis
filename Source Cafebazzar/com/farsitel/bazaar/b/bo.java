package com.farsitel.bazaar.b;

import android.app.Activity;
import android.content.Intent;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

public final class bo extends o {
    public bo(Activity activity, int i) {
        super(activity, activity.getString(2131165709, new Object[]{e.a(i)}), 2131165801, 0, 2131165463, true);
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "upgradable_apps_frag";
        cVar.e = "update_all";
        a.a(cVar.b("action", "ok"));
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.UPDATE_ALL");
        this.f.sendBroadcast(intent);
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "upgradable_apps_frag";
        cVar.e = "update_all";
        a.a(cVar.b("action", "cancel"));
        this.e.dismiss();
    }
}
