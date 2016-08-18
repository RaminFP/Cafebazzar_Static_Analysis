package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.b;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class h {
    static String a = null;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    Context e;
    Map f = new HashMap();
    Messenger g;
    Messenger h;
    MessengerCompat i;
    PendingIntent j;
    long k;
    long l;
    int m;
    int n;
    long o;

    public h(Context context) {
        this.e = context;
    }

    public static String a() {
        synchronized (h.class) {
            int i;
            try {
                int i2 = d;
                i = i2 + 1;
                d = i;
                String num = Integer.toString(i2);
                return num;
            } finally {
                i = h.class;
            }
        }
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo;
        if (a != null) {
            return a;
        }
        b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo2.uid);
                    c = applicationInfo2.uid;
                    String str = resolveInfo.serviceInfo.packageName;
                    a = str;
                    return str;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            applicationInfo = packageManager.getApplicationInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0);
            a = applicationInfo.packageName;
            c = applicationInfo.uid;
            return a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                a = applicationInfo.packageName;
                c = applicationInfo.uid;
                return a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String a(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private static String a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = a.a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f.keySet()) {
                Object obj2 = this.f.get(str);
                this.f.put(str, obj);
                a(obj2, obj);
            }
        }
    }

    private static void a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f.get(str);
            this.f.put(str, obj);
            a(obj2, obj);
        }
    }

    private void c(Intent intent) {
        synchronized (this) {
            if (this.j == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                this.j = PendingIntent.getBroadcast(this.e, 0, intent2, 0);
            }
            intent.putExtra("app", this.j);
        }
    }

    Intent a(Bundle bundle, KeyPair keyPair) {
        ConditionVariable conditionVariable = new ConditionVariable();
        String a = a();
        synchronized (getClass()) {
            this.f.put(a, conditionVariable);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.o == 0 || elapsedRealtime > this.o) {
            if (this.g == null) {
                a(this.e);
                this.g = new Messenger(new i(this, Looper.getMainLooper()));
            }
            if (a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            Object remove;
            Intent intent;
            this.k = SystemClock.elapsedRealtime();
            Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent2.setPackage(a);
            bundle.putString("gmsv", Integer.toString(b.b(this.e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(a.a(this.e)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", a.a(keyPair));
            bundle.putString("pub2", a.a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", a(keyPair, this.e.getPackageName(), r0));
            intent2.putExtras(bundle);
            c(intent2);
            this.k = SystemClock.elapsedRealtime();
            intent2.putExtra("kid", "|ID|" + a + "|");
            intent2.putExtra("X-kid", "|ID|" + a + "|");
            boolean equals = "com.google.android.gsf".equals(a);
            String stringExtra = intent2.getStringExtra("useGsf");
            if (stringExtra != null) {
                equals = "1".equals(stringExtra);
            }
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Sending " + intent2.getExtras());
            }
            if (this.h != null) {
                intent2.putExtra("google.messenger", this.g);
                Message obtain = Message.obtain();
                obtain.obj = intent2;
                try {
                    this.h.send(obtain);
                } catch (RemoteException e) {
                    if (Log.isLoggable("InstanceID/Rpc", 3)) {
                        Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                    }
                }
                conditionVariable.block(30000);
                synchronized (getClass()) {
                    remove = this.f.remove(a);
                    if (remove instanceof Intent) {
                        intent = (Intent) remove;
                    } else if (remove instanceof String) {
                        Log.w("InstanceID/Rpc", "No response " + remove);
                        throw new IOException("TIMEOUT");
                    } else {
                        throw new IOException((String) remove);
                    }
                }
                return intent;
            }
            if (equals) {
                intent = new Intent("com.google.android.gms.iid.InstanceID");
                intent.setPackage(this.e.getPackageName());
                intent.putExtra("GSF", intent2);
                this.e.startService(intent);
            } else {
                intent2.putExtra("google.messenger", this.g);
                intent2.putExtra("messenger2", "1");
                if (this.i != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = intent2;
                    try {
                        MessengerCompat messengerCompat = this.i;
                        if (messengerCompat.a != null) {
                            messengerCompat.a.send(obtain2);
                        } else {
                            messengerCompat.b.a(obtain2);
                        }
                    } catch (RemoteException e2) {
                        if (Log.isLoggable("InstanceID/Rpc", 3)) {
                            Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                        }
                    }
                }
                this.e.startService(intent2);
            }
            conditionVariable.block(30000);
            synchronized (getClass()) {
                remove = this.f.remove(a);
                if (remove instanceof Intent) {
                    intent = (Intent) remove;
                } else if (remove instanceof String) {
                    Log.w("InstanceID/Rpc", "No response " + remove);
                    throw new IOException("TIMEOUT");
                } else {
                    throw new IOException((String) remove);
                }
            }
            return intent;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.o - elapsedRealtime) + " interval: " + this.n);
        throw new IOException("RETRY_LATER");
    }

    final void b(Intent intent) {
        String str = null;
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                if (action == null) {
                    action = intent.getStringExtra("unregistered");
                }
                if (action == null) {
                    Object stringExtra = intent.getStringExtra("error");
                    if (stringExtra == null) {
                        Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
                        return;
                    }
                    if (Log.isLoggable("InstanceID/Rpc", 3)) {
                        Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
                    }
                    if (stringExtra.startsWith("|")) {
                        String[] split = stringExtra.split("\\|");
                        if (!"ID".equals(split[1])) {
                            Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
                        }
                        if (split.length > 2) {
                            str = split[2];
                            stringExtra = split[3];
                            if (stringExtra.startsWith(":")) {
                                stringExtra = stringExtra.substring(1);
                            }
                        } else {
                            stringExtra = "UNKNOWN";
                        }
                        intent.putExtra("error", stringExtra);
                    }
                    if (str == null) {
                        a(stringExtra);
                    } else {
                        a(str, stringExtra);
                    }
                    long longExtra = intent.getLongExtra("Retry-After", 0);
                    if (longExtra > 0) {
                        this.l = SystemClock.elapsedRealtime();
                        this.n = ((int) longExtra) * 1000;
                        this.o = SystemClock.elapsedRealtime() + ((long) this.n);
                        Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.n);
                        return;
                    } else if (("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) && "com.google.android.gsf".equals(a)) {
                        this.m++;
                        if (this.m >= 3) {
                            if (this.m == 3) {
                                this.n = new Random().nextInt(1000) + 1000;
                            }
                            this.n <<= 1;
                            this.o = SystemClock.elapsedRealtime() + ((long) this.n);
                            Log.w("InstanceID/Rpc", "Backoff due to " + stringExtra + " for " + this.n);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                this.k = SystemClock.elapsedRealtime();
                this.o = 0;
                this.m = 0;
                this.n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "AppIDResponse: " + action + " " + intent.getExtras());
                }
                if (action.startsWith("|")) {
                    String[] split2 = action.split("\\|");
                    if (!"ID".equals(split2[1])) {
                        Log.w("InstanceID/Rpc", "Unexpected structured response " + action);
                    }
                    action = split2[2];
                    if (split2.length > 4) {
                        if ("SYNC".equals(split2[3])) {
                            b.a(this.e);
                        } else if ("RST".equals(split2[3])) {
                            Context context = this.e;
                            a.b(this.e);
                            b.a(context, a.a());
                            intent.removeExtra("registration_id");
                            a(action, (Object) intent);
                            return;
                        }
                    }
                    str = split2[split2.length - 1];
                    if (str.startsWith(":")) {
                        str = str.substring(1);
                    }
                    intent.putExtra("registration_id", str);
                    str = action;
                }
                if (str == null) {
                    a((Object) intent);
                } else {
                    a(str, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
