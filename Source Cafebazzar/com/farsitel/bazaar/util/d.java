package com.farsitel.bazaar.util;

import android.os.Build.VERSION;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;

public final class d {
    public static boolean a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 9) {
            z = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("pref_key_ptching", true);
            if (!z) {
                BazaarApplication.c().d();
                i.a("/Landa/Disabled");
            }
        }
        return z;
    }
}
