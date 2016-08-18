package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.internal.ap;
import com.google.android.gms.measurement.internal.g;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.z;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    static final Object a = new Object();
    static WakeLock b;
    static Boolean c;

    public static boolean a(Context context) {
        av.a((Object) context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a = g.a(context, AppMeasurementReceiver.class, false);
        c = Boolean.valueOf(a);
        return a;
    }

    public final void onReceive(Context context, Intent intent) {
        z e = ap.a(context).e();
        String action = intent.getAction();
        if (i.B()) {
            e.g.a("Device AppMeasurementReceiver got", action);
        } else {
            e.g.a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a = AppMeasurementService.a(context);
            Intent intent2 = new Intent(context, AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (a) {
                context.startService(intent2);
                if (a) {
                    try {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (b == null) {
                            WakeLock newWakeLock = powerManager.newWakeLock(1, "AppMeasurement WakeLock");
                            b = newWakeLock;
                            newWakeLock.setReferenceCounted(false);
                        }
                        b.acquire(1000);
                    } catch (SecurityException e2) {
                        e.b.a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
