package com.farsitel.bazaar.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.farsitel.bazaar.BazaarApplication;

public final class b extends AsyncTask {
    final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    private static Void a() {
        try {
            String a = com.google.android.gms.gcm.b.a(BazaarApplication.c()).a("683351534335");
            SharedPreferences c = a.c();
            int b = a.b();
            Editor edit = c.edit();
            edit.putString("registration_id", a);
            edit.putInt("appVersion", b);
            edit.commit();
        } catch (Throwable th) {
        }
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.a.a();
    }
}
