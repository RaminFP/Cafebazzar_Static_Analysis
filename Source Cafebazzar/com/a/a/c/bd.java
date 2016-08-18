package com.a.a.c;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

final class bd implements cd {
    private final Context a;
    private final String b;

    public bd(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final String a() {
        String str = null;
        try {
            Bundle bundle = this.a.getPackageManager().getApplicationInfo(this.b, NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception e) {
        }
        return str;
    }
}
