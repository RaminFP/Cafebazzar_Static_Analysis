package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class UpdateAllReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && "com.farsitel.bazaar.UPDATE_ALL".equals(action)) {
            TreeSet a = g.a().a(false);
            boolean n = j.a().n();
            ArrayList arrayList = new ArrayList();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (n || dVar.f) {
                    AppDownloadService.a(dVar.a, dVar.b, dVar.f, "update_all");
                } else {
                    arrayList.add(dVar.b);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    action = context.getString(2131165438, new Object[]{arrayList.get(0)});
                } else {
                    action = context.getString(2131165439, new Object[]{arrayList.get(0), Integer.valueOf(arrayList.size() - 1)});
                }
                Intent intent2 = new Intent(context, JoinActivity.class);
                intent2.putExtra("extra_referer", "update-all");
                intent2.putExtra("android.intent.extra.TITLE", action);
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
            aw.b();
        }
    }
}
