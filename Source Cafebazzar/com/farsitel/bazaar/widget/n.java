package com.farsitel.bazaar.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.congenialmobile.util.h;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.util.j;
import java.util.ArrayList;

public enum n {
    INSTANCE;
    
    private static final BazaarApplication b = null;
    private Notification c;
    private Builder d;
    private RemoteViews e;

    static {
        b = BazaarApplication.c();
    }

    public final Notification a(ArrayList arrayList, long j, long j2, boolean z, boolean z2) {
        CharSequence charSequence;
        int i;
        CharSequence string = z ? b.getString(2131165358, new Object[]{arrayList.get(0)}) : null;
        if (arrayList.isEmpty()) {
            charSequence = "";
        } else {
            String str = (String) arrayList.get(0);
            i = 2131165858;
            try {
                i = h.a(str.substring(0, 1)) ? 2131165859 : 2131165858;
            } catch (Exception e) {
            }
            String string2 = BazaarApplication.c().getString(i);
            charSequence = "" + str;
            for (i = 1; i < arrayList.size(); i++) {
                charSequence = charSequence + string2 + " " + ((String) arrayList.get(i));
            }
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.d == null) {
                this.d = new Builder(b.getApplicationContext()).setTicker(string).setSmallIcon(g.ic_stat_download).setLargeIcon(BitmapFactory.decodeResource(b.getResources(), g.ic_stat_download_4)).setOngoing(true);
            } else {
                this.d.setTicker(string);
            }
            this.d.setOngoing(true);
            Intent intent = new Intent(b, HomeActivity.class);
            intent.setData(Uri.parse("bazaar://downloads"));
            this.d.setContentIntent(PendingIntent.getActivity(b, 0, intent, 0));
            if (j2 > 0) {
                this.d.setProgress(100, j.a((int) ((100 * j) / j2)), !z2);
                this.d.setContentText(b.getString(2131165535, new Object[]{Integer.valueOf(i)}));
            }
            this.d.setContentTitle(charSequence);
            this.c = this.d.build();
        } else {
            this.e = new RemoteViews(b.getPackageName(), 2130903140);
            if (this.c == null) {
                this.c = new Notification(17301633, string, System.currentTimeMillis());
            } else {
                this.c.tickerText = string;
            }
            this.c.contentView = this.e;
            Notification notification = this.c;
            notification.flags |= 2;
            this.c.contentIntent = PendingIntent.getActivity(b, 0, new Intent("android.intent.action.VIEW", Uri.parse("bazaar://downloads")), 0);
            this.e.setProgressBar(2131624353, 100, (int) ((100 * j) / j2), false);
            this.e.setTextViewText(2131624351, b.getString(2131165535, new Object[]{Integer.valueOf(r1)}));
            this.e.setTextViewText(2131624352, charSequence);
        }
        return this.c;
    }
}
