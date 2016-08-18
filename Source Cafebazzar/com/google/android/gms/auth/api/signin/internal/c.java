package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.av;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class c {
    private static final Lock a = new ReentrantLock();
    private static c b;
    private final Lock c = new ReentrantLock();
    private final SharedPreferences d;

    private c(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    private GoogleSignInAccount a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String b = b("googleSignInAccount" + ":" + str);
            if (b != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.a(b);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    public static c a(Context context) {
        av.a((Object) context);
        a.lock();
        try {
            if (b == null) {
                b = new c(context.getApplicationContext());
            }
            c cVar = b;
            return cVar;
        } finally {
            a.unlock();
        }
    }

    private String b(String str) {
        this.c.lock();
        try {
            String string = this.d.getString(str, null);
            return string;
        } finally {
            this.c.unlock();
        }
    }

    public final GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }
}
