package com.farsitel.bazaar.activity;

import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class cv implements OnCheckedChangeListener {
    final /* synthetic */ co a;

    cv(co coVar) {
        this.a = coVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "settings_frag";
        cVar.e = "item_click";
        a.a(cVar.b("item", "shortcut").b("checked", Boolean.valueOf(z)));
        Editor edit = this.a.J.edit();
        edit.putBoolean("add_shortcut_to_app", z);
        edit.commit();
    }
}
