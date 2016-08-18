package com.farsitel.bazaar.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.b.n;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.d.a;
import com.farsitel.bazaar.g.d.b;
import com.farsitel.bazaar.util.c;

public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("");
    }

    protected void onHandleIntent(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (!(extras == null || extras.isEmpty())) {
                a aVar = new a(extras);
                if (!aVar.a()) {
                    Intent c;
                    switch (b.a[aVar.a - 1]) {
                        case 1:
                            c = aVar.c();
                            c.addFlags(268435456);
                            c.a(BazaarApplication.c(), c);
                            break;
                        case 2:
                            c = aVar.c();
                            c.a(c);
                            BazaarApplication.c().startService(c);
                            break;
                        case 3:
                            c = aVar.c();
                            c.a(c);
                            BazaarApplication.c().sendBroadcast(c);
                            break;
                        default:
                            break;
                    }
                }
                ((NotificationManager) BazaarApplication.c().getSystemService("notification")).notify(10000, aVar.b());
            }
        } catch (Throwable th) {
        }
        n.a(intent);
    }
}
