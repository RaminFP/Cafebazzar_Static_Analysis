package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.c;
import com.google.android.gms.common.g;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.x;
import java.io.IOException;

public final class b {
    public static final String a = "callerUid";
    public static final String b = "androidPackageName";
    private static final ComponentName c = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.auth.GetToken");
    private static final ComponentName d = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.recovery.RecoveryService");

    static {
        int i = VERSION.SDK_INT;
        i = VERSION.SDK_INT;
    }

    private static Object a(Context context, ComponentName componentName, d dVar) {
        Throwable e;
        ServiceConnection hVar = new h();
        x a = x.a(context);
        if (a.a(componentName, hVar, "GoogleAuthUtil")) {
            try {
                Object a2 = dVar.a(hVar.a());
                a.b(componentName, hVar, "GoogleAuthUtil");
                return a2;
            } catch (RemoteException e2) {
                e = e2;
                try {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                } catch (Throwable th) {
                    a.b(componentName, hVar, "GoogleAuthUtil");
                }
            } catch (InterruptedException e3) {
                e = e3;
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        }
        throw new IOException("Could not bind to service.");
    }

    static /* synthetic */ Object a(Object obj) {
        if (obj != null) {
            return obj;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    public static String a(Context context, Account account, String str) {
        Bundle bundle = new Bundle();
        av.c("Calling this from your main thread can lead to deadlock");
        a(context);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(b))) {
            bundle2.putString(b, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return ((TokenData) a(context, c, new c(account, str, bundle2))).b;
    }

    private static void a(Context context) {
        try {
            GooglePlayServicesUtil.zzac(context.getApplicationContext());
        } catch (g e) {
            throw new e(e.a, e.getMessage(), new Intent(e.b));
        } catch (c e2) {
            throw new a(e2.getMessage());
        }
    }
}
