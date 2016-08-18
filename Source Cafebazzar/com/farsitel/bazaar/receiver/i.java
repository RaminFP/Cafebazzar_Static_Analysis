package com.farsitel.bazaar.receiver;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.database.UpgradablesWidgetProvider;

public final class i extends h {
    private Context a;

    public i(Context context) {
        this.a = context;
    }

    public final void a() {
        super.a();
    }

    public final void a(int i) {
        Intent intent = new Intent(this.a, UpgradablesWidgetProvider.class);
        intent.setAction("com.faristel.bazaar.appwidget.upgradableswidget.UPDATE_ACTION");
        try {
            PendingIntent.getBroadcast(this.a, 0, intent, 268435456).send();
        } catch (CanceledException e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        super.b();
    }
}
