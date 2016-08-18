package com.farsitel.bazaar.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import com.farsitel.bazaar.BazaarApplication;
import ir.cafebazaar.pardakht.g;

public final class f extends AsyncTask {
    private Context a;
    private String b;
    private g c;

    private Void a() {
        Exception e;
        do {
            new StringBuilder("Calling getPurchases with continuation token: ").append(this.b);
            try {
                this.b = this.c.a(3, this.a.getPackageName(), "inapp", this.b).getString("INAPP_CONTINUATION_TOKEN");
                new StringBuilder("Continuation token: ").append(this.b);
            } catch (NullPointerException e2) {
                e = e2;
                e.printStackTrace();
                if (TextUtils.isEmpty(this.b)) {
                    return null;
                }
            } catch (RemoteException e3) {
                e = e3;
                e.printStackTrace();
                if (TextUtils.isEmpty(this.b)) {
                    return null;
                }
            }
        } while (TextUtils.isEmpty(this.b));
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    protected final void onPreExecute() {
        this.b = null;
        this.a = BazaarApplication.c();
        new StringBuilder("Package name: ").append(this.a.getPackageName());
        this.c = new g(this.a);
    }
}
