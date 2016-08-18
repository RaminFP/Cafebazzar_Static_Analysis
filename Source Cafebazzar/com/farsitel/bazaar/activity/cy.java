package com.farsitel.bazaar.activity;

import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import c.a.a.b;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class cy implements OnCheckedChangeListener {
    final /* synthetic */ co a;

    cy(co coVar) {
        this.a = coVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "settings_frag";
        cVar.e = "item_click";
        a.a(cVar.b("item", "update_launcher_badge").b("checked", Boolean.valueOf(z)));
        Editor edit = this.a.J.edit();
        edit.putBoolean("update_launcher_badge", z);
        edit.commit();
        if (z) {
            b.a(BazaarApplication.c()).b(g.a().a.size());
        } else {
            b.a(BazaarApplication.c()).d();
        }
    }
}
