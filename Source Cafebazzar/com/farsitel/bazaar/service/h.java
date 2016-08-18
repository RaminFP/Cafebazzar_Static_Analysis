package com.farsitel.bazaar.service;

import android.os.Binder;
import android.support.v4.app.NotificationCompat;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.e;
import com.farsitel.bazaar.g.d;

final class h extends e {
    final /* synthetic */ UpdateCheckService a;

    h(UpdateCheckService updateCheckService) {
        this.a = updateCheckService;
    }

    private boolean b(String str) {
        try {
            return Binder.getCallingUid() == this.a.getPackageManager().getApplicationInfo(str, NotificationCompat.FLAG_HIGH_PRIORITY).uid;
        } catch (Exception e) {
            return false;
        }
    }

    public final long a(String str) {
        d b = g.a().b(str);
        return (b == null || !b(str)) ? -1 : b.d;
    }
}
