package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.internal.ap;
import com.google.android.gms.measurement.internal.as;
import com.google.android.gms.measurement.internal.g;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.z;

public final class AppMeasurementService extends Service {
    private static Boolean b;
    private final Handler a = new Handler();

    public static boolean a(Context context) {
        av.a((Object) context);
        if (b != null) {
            return b.booleanValue();
        }
        boolean a = g.a(context, AppMeasurementService.class);
        b = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            ap.a((Context) this).e().a.a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new as(ap.a((Context) this));
        }
        ap.a((Context) this).e().b.a("onBind received unknown action", action);
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        z e = ap.a((Context) this).e();
        if (i.B()) {
            e.g.a("Device AppMeasurementService is starting up");
        } else {
            e.g.a("Local AppMeasurementService is starting up");
        }
    }

    public final void onDestroy() {
        z e = ap.a((Context) this).e();
        if (i.B()) {
            e.g.a("Device AppMeasurementService is shutting down");
        } else {
            e.g.a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            ap.a((Context) this).e().a.a("onRebind called with null intent");
            return;
        }
        ap.a((Context) this).e().g.a("onRebind called. action", intent.getAction());
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (AppMeasurementReceiver.a) {
                WakeLock wakeLock = AppMeasurementReceiver.b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
        ap a = ap.a((Context) this);
        z e2 = a.e();
        String action = intent.getAction();
        if (i.B()) {
            e2.g.a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        } else {
            e2.g.a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a.f().a(new b(this, a, i2, e2));
        }
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            ap.a((Context) this).e().a.a("onUnbind called with null intent");
        } else {
            ap.a((Context) this).e().g.a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
