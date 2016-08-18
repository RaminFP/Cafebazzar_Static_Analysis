package com.farsitel.bazaar.activity;

import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class ct implements OnCheckedChangeListener {
    final /* synthetic */ co a;

    ct(co coVar) {
        this.a = coVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "settings_frag";
        cVar.e = "item_click";
        a.a(cVar.b("item", "update_notification").b("checked", Boolean.valueOf(z)));
        Editor edit = this.a.J.edit();
        edit.putBoolean("notify_on_new_updates", z);
        edit.commit();
    }
}
