package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.a;
import com.google.android.gms.iid.h;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    public static int a = 5000000;
    public static int b = 6500000;
    public static int c = 7000000;
    static b d;
    private static final AtomicInteger i = new AtomicInteger(1);
    final Messenger e = new Messenger(new c(this, Looper.getMainLooper()));
    private Context f;
    private PendingIntent g;
    private Map h = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue j = new LinkedBlockingQueue();

    @Deprecated
    private Intent a(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (b(this.f) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(h.a(this.f));
            a(intent);
            intent.putExtra("google.message_id", "google.rpc" + String.valueOf(i.getAndIncrement()));
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.e);
            this.f.startService(intent);
            try {
                return (Intent) this.j.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static b a(Context context) {
        synchronized (b.class) {
            Class applicationContext;
            try {
                b bVar;
                if (d == null) {
                    bVar = new b();
                    d = bVar;
                    applicationContext = context.getApplicationContext();
                    bVar.f = applicationContext;
                }
                bVar = d;
                return bVar;
            } finally {
                applicationContext = b.class;
            }
        }
    }

    private void a(Intent intent) {
        synchronized (this) {
            if (this.g == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                this.g = PendingIntent.getBroadcast(this.f, 0, intent2, 0);
            }
            intent.putExtra("app", this.g);
        }
    }

    static /* synthetic */ boolean a(b bVar, Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) bVar.h.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(h.a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    @Deprecated
    public final String a(String... strArr) {
        String a;
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            if (strArr != null) {
                if (strArr.length != 0) {
                    StringBuilder stringBuilder = new StringBuilder(strArr[0]);
                    for (int i = 1; i < strArr.length; i++) {
                        stringBuilder.append(',').append(strArr[i]);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    Bundle bundle = new Bundle();
                    if (h.a(this.f).contains(".gsf")) {
                        bundle.putString("legacy.sender", stringBuilder2);
                        a b = a.b(this.f);
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            throw new IOException("MAIN_THREAD");
                        }
                        a = a.c() ? null : a.c.a(b.e, stringBuilder2, "GCM");
                        if (a == null) {
                            if (bundle.getString("ttl") != null) {
                                obj = null;
                            }
                            if (!"jwt".equals(bundle.getString("type"))) {
                                obj2 = obj;
                            }
                            a = b.a(stringBuilder2, "GCM", bundle);
                            Log.w("InstanceID", "token: " + a);
                            if (!(a == null || r0 == null)) {
                                a.c.a(b.e, stringBuilder2, "GCM", a, a.g);
                            }
                        }
                    } else {
                        bundle.putString("sender", stringBuilder2);
                        Intent a2 = a(bundle);
                        if (a2 == null) {
                            throw new IOException("SERVICE_NOT_AVAILABLE");
                        }
                        a = a2.getStringExtra("registration_id");
                        if (a == null) {
                            String stringExtra = a2.getStringExtra("error");
                            if (stringExtra != null) {
                                throw new IOException(stringExtra);
                            }
                            throw new IOException("SERVICE_NOT_AVAILABLE");
                        }
                    }
                }
            }
            throw new IllegalArgumentException("No senderIds");
        }
        return a;
    }

    public final void a(String str, String str2, long j, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        a(intent);
        intent.setPackage(h.a(this.f));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(0));
        intent.putExtra("google.delay", Integer.toString(-1));
        if (h.a(this.f).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            a.b(this.f).a("GCM", "upstream", bundle2);
            return;
        }
        this.f.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }
}
