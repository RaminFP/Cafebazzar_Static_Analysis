package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.b.a;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class j {
    SharedPreferences a;
    Context b;

    public j(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private j(Context context, String str) {
        this.b = context;
        this.a = context.getSharedPreferences(str, 4);
        File file = new File(new a().getNoBackupFilesDir(this.b), str + "-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !a()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    b.a(this.b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }

    private String a(String str, String str2) {
        String string;
        synchronized (this) {
            string = this.a.getString(str + "|S|" + str2, null);
        }
        return string;
    }

    private void a(Editor editor, String str, String str2, String str3) {
        synchronized (this) {
            editor.putString(str + "|S|" + str2, str3);
        }
    }

    private static String b(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    final String a(String str) {
        String string;
        synchronized (this) {
            string = this.a.getString(str, null);
        }
        return string;
    }

    public final String a(String str, String str2, String str3) {
        String string;
        synchronized (this) {
            string = this.a.getString(b(str, str2, str3), null);
        }
        return string;
    }

    final KeyPair a(String str, long j) {
        KeyPair a;
        synchronized (this) {
            a = d.a();
            Editor edit = this.a.edit();
            a(edit, str, "|P|", a.a(a.getPublic().getEncoded()));
            a(edit, str, "|K|", a.a(a.getPrivate().getEncoded()));
            a(edit, str, "cre", Long.toString(j));
            edit.commit();
        }
        return a;
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        synchronized (this) {
            String b = b(str, str2, str3);
            Editor edit = this.a.edit();
            edit.putString(b, str4);
            edit.putString("appVersion", str5);
            edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
            edit.commit();
        }
    }

    final boolean a() {
        return this.a.getAll().isEmpty();
    }

    public final void b() {
        synchronized (this) {
            this.a.edit().clear().commit();
        }
    }

    public final void b(String str) {
        synchronized (this) {
            Editor edit = this.a.edit();
            for (String str2 : this.a.getAll().keySet()) {
                if (str2.startsWith(str)) {
                    edit.remove(str2);
                }
            }
            edit.commit();
        }
    }

    public final void c(String str) {
        b(str + "|T|");
    }

    final KeyPair d(String str) {
        Object e;
        String a = a(str, "|P|");
        String a2 = a(str, "|K|");
        if (a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            b.a(this.b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            b.a(this.b, this);
            return null;
        }
    }
}
