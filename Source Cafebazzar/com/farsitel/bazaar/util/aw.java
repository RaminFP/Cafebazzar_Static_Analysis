package com.farsitel.bazaar.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.app.TaskStackBuilder;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.g.j;

public final class aw {
    private static BazaarApplication a = BazaarApplication.c();

    public static void a() {
        if (g.a().c() >= 3) {
            int size = g.a().a(false).size();
            Builder autoCancel = new Builder(a).setContentTitle(a.getString(2131165717)).setContentText(a.getString(2131165714)).setSmallIcon(com.farsitel.bazaar.g.ic_stat_upgradables).setLargeIcon(BitmapFactory.decodeResource(a.getResources(), com.farsitel.bazaar.g.ic_stat_upgradables)).setTicker(e.a(size) + " " + (size > 1 ? a.getString(2131165716) : a.getString(2131165715))).setAutoCancel(true);
            Intent intent = new Intent(a, HomeActivity.class);
            intent.setData(Uri.parse("bazaar://apps?slug=upgradable&user=1"));
            TaskStackBuilder create = TaskStackBuilder.create(a);
            create.addParentStack(HomeActivity.class);
            create.addNextIntent(intent);
            autoCancel.setContentIntent(create.getPendingIntent(0, 134217728));
            Style bigTextStyle = new BigTextStyle();
            bigTextStyle.setBigContentTitle(a.getString(2131165717));
            CharSequence string = size > 1 ? a.getString(2131165712, new Object[]{((d) r1.iterator().next()).b, e.a(r1.size() - 1)}) : a.getString(2131165713, new Object[]{((d) r1.iterator().next()).b});
            autoCancel.setContentText(string);
            bigTextStyle.bigText(string);
            bigTextStyle.setBuilder(autoCancel);
            autoCancel.setStyle(bigTextStyle);
            if (j.a().o()) {
                intent = new Intent();
                intent.setAction("com.farsitel.bazaar.UPDATE_ALL");
                autoCancel.addAction(com.farsitel.bazaar.g.update_all, a.getString(2131165708), PendingIntent.getBroadcast(a, 0, intent, 0));
            }
            ((NotificationManager) a.getSystemService("notification")).notify(3, autoCancel.build());
            g.a().b();
        }
    }

    public static void b() {
        ((NotificationManager) a.getSystemService("notification")).cancel(3);
    }
}
