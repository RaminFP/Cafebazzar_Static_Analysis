package com.farsitel.bazaar.database;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.k;
import com.farsitel.bazaar.receiver.i;

public class UpgradablesWidgetProvider extends AppWidgetProvider {
    private static i b;
    RemoteViews a;
    private com.farsitel.bazaar.i c;

    private com.farsitel.bazaar.i a() {
        if (this.c == null) {
            this.c = new com.farsitel.bazaar.i(k.b);
        }
        return this.c;
    }

    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
    }

    public void onDisabled(Context context) {
        if (b != null) {
            b.b();
        }
        super.onDisabled(context);
        a();
        com.farsitel.bazaar.i.a("/UpWidget/disabled");
    }

    public void onEnabled(Context context) {
        i iVar = new i(context);
        b = iVar;
        iVar.a();
        super.onEnabled(context);
        a();
        com.farsitel.bazaar.i.a("/UpWidget/enabled");
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if ("com.faristel.bazaar.appwidget.upgradableswidget.OPEN_BAZAAR".equals(intent.getAction())) {
            Intent intent2 = new Intent(context, HomeActivity.class);
            intent2.setFlags(268435456);
            BazaarApplication.c().startActivity(intent2);
            a();
            com.farsitel.bazaar.i.a("/UpWidget/open/bazaar");
        }
        if ("com.faristel.bazaar.appwidget.upgradableswidget.UPDATE_ACTION".equals(intent.getAction())) {
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, UpgradablesWidgetProvider.class));
            if (appWidgetIds.length > 0) {
                onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);
            }
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        if (b == null) {
            i iVar = new i(context);
            b = iVar;
            iVar.a();
        }
        int i = 2130903184;
        if (BazaarApplication.c().b()) {
            i = 2130903183;
        }
        this.a = new RemoteViews(context.getPackageName(), i);
        int size = g.a().a.size();
        for (int i2 : iArr) {
            if (size > 0) {
                this.a.setViewVisibility(2131624430, 0);
                this.a.setTextViewText(2131624430, e.a(size));
            } else {
                this.a.setViewVisibility(2131624430, 8);
            }
            Intent intent = new Intent(context, UpgradablesWidgetProvider.class);
            intent.setAction("com.faristel.bazaar.appwidget.upgradableswidget.OPEN_BAZAAR");
            intent.putExtra("com.faristel.bazaar.appwidget.upgradableswidget.EXTRA_SLUG", "home");
            this.a.setOnClickPendingIntent(2131624429, PendingIntent.getBroadcast(context, 0, intent, 134217728));
            appWidgetManager.updateAppWidget(i2, this.a);
        }
    }
}
