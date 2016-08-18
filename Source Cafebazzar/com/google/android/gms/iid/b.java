package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.b.n;
import android.util.Log;
import java.io.IOException;

public final class b extends Service {
    static String a = "action";
    private static String f = "google.com/iid";
    private static String g = "CMD";
    private static String h = "gcm.googleapis.com/refresh";
    MessengerCompat b;
    BroadcastReceiver c;
    int d;
    int e;

    private void a() {
        synchronized (this) {
            this.d--;
            if (this.d == 0) {
                stopSelf(this.e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.d + " " + this.e);
            }
        }
    }

    static void a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(g, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, j jVar) {
        jVar.b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.b.a();
    }

    public final void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public final void onDestroy() {
        unregisterReceiver(this.c);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            this.d++;
            if (i2 > this.e) {
                this.e = i2;
            }
        }
        if (intent == null) {
            a();
            return 2;
        }
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            if (VERSION.SDK_INT <= 18) {
                Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                if (intent2 != null) {
                    startService(intent2);
                    a();
                    return 1;
                }
            }
            try {
                a b;
                String stringExtra = intent.getStringExtra("subtype");
                if (stringExtra == null) {
                    b = a.b(this);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("subtype", stringExtra);
                    b = a.a(this, bundle);
                }
                String stringExtra2 = intent.getStringExtra(g);
                if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
                    if (Log.isLoggable("InstanceID", 3)) {
                        Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
                    }
                    if (intent.getStringExtra("unregistered") != null) {
                        j a = a.a();
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        a.c(stringExtra);
                        a.b().b(intent);
                    } else if (h.equals(intent.getStringExtra("from"))) {
                        a.a().c(stringExtra);
                    } else if ("RST".equals(stringExtra2)) {
                        b.f = 0;
                        a.c.b(b.e + "|");
                        b.d = null;
                    } else if ("RST_FULL".equals(stringExtra2)) {
                        if (!a.a().a()) {
                            a.a().b();
                        }
                    } else if ("SYNC".equals(stringExtra2)) {
                        a.a().c(stringExtra);
                    } else if ("PING".equals(stringExtra2)) {
                        com.google.android.gms.gcm.b.a((Context) this).a(f, h.a(), 0, intent.getExtras());
                    }
                } else {
                    if (Log.isLoggable("InstanceID", 3)) {
                        Log.d("InstanceID", "Register result in service " + stringExtra);
                    }
                    a.b().b(intent);
                }
            } catch (IOException e) {
                Log.w("InstanceID", "Failed to send ping response");
            } catch (Throwable th) {
                a();
            }
        }
        a();
        if (intent.getStringExtra("from") != null) {
            n.a(intent);
        }
        return 2;
    }
}
