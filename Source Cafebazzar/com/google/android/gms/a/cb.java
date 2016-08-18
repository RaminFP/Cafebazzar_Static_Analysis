package com.google.android.gms.a;

import android.content.res.Configuration;
import android.content.res.Resources;

public final class cb {
    public static boolean a(Resources resources) {
        if (resources != null) {
            boolean z = (resources.getConfiguration().screenLayout & 15) > 3;
            if (ce.a(11) && z) {
                return true;
            }
            Configuration configuration = resources.getConfiguration();
            z = ce.a(13) ? (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600 : false;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
