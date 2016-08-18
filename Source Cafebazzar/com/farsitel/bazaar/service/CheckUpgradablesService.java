package com.farsitel.bazaar.service;

import android.app.IntentService;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.k;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.y;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.q;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckUpgradablesService extends IntentService {
    private static String c;
    private boolean a = true;
    private Handler b = new Handler();
    private ArrayList d;
    private boolean e = false;
    private int f = 0;

    public CheckUpgradablesService() {
        super("CheckUpgradablesService");
    }

    protected void onHandleIntent(Intent intent) {
        if (q.e()) {
            boolean z;
            d dVar;
            v dVar2;
            k yVar;
            String language;
            int m;
            int i;
            af afVar;
            if (intent != null) {
                this.a = intent.getBooleanExtra("force_check_upgradables", true);
            }
            if (BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("update_network_type", "network_type_wifi_3g").equals("network_type_wifi")) {
                try {
                    z = !((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(0).isConnectedOrConnecting();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.e = false;
                this.f = 0;
                if (!this.a || r0) {
                    this.d = new ArrayList(Arrays.asList(j.a().a.getString("stats_urls", "").split(" ")));
                    c = (String) this.d.get(0);
                    this.f++;
                    dVar = d.INSTANCE;
                    dVar2 = new d(this);
                    yVar = new y(com.farsitel.bazaar.h.j.UPGRADABLE_APPS);
                    language = BazaarApplication.c().a.getLanguage();
                    m = j.a().m();
                    i = VERSION.SDK_INT;
                    afVar = af.INSTANCE;
                    dVar.a(dVar2, yVar, language, Integer.valueOf(m), Integer.valueOf(i), af.a());
                }
                return;
            }
            z = true;
            this.e = false;
            this.f = 0;
            if (this.a) {
            }
            this.d = new ArrayList(Arrays.asList(j.a().a.getString("stats_urls", "").split(" ")));
            c = (String) this.d.get(0);
            this.f++;
            dVar = d.INSTANCE;
            dVar2 = new d(this);
            yVar = new y(com.farsitel.bazaar.h.j.UPGRADABLE_APPS);
            language = BazaarApplication.c().a.getLanguage();
            m = j.a().m();
            i = VERSION.SDK_INT;
            afVar = af.INSTANCE;
            dVar.a(dVar2, yVar, language, Integer.valueOf(m), Integer.valueOf(i), af.a());
        }
    }
}
