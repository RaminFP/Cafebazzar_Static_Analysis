package com.farsitel.bazaar.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.util.an;

final class cs implements OnCheckedChangeListener {
    final /* synthetic */ co a;

    cs(co coVar) {
        this.a = coVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "settings_frag";
        cVar.e = "item_click";
        a.a(cVar.b("item", "schedule_update").b("checked", Boolean.valueOf(z)));
        Editor edit = this.a.I.edit();
        edit.putBoolean("schedule_update", z);
        edit.commit();
        if (z) {
            an.a();
            this.a.b();
            return;
        }
        AlarmManager alarmManager = (AlarmManager) BazaarApplication.c().getApplicationContext().getSystemService("alarm");
        alarmManager.cancel(PendingIntent.getBroadcast(BazaarApplication.c().getApplicationContext(), 0, new Intent("com.farsitel.bazaar.START_SCHEDULE_UPDATE"), 0));
        alarmManager.cancel(PendingIntent.getBroadcast(BazaarApplication.c().getApplicationContext(), 0, new Intent("com.farsitel.bazaar.STOP_SCHEDULE_UPDATE"), 0));
        this.a.b();
    }
}
