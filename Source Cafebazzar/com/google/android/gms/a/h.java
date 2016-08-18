package com.google.android.gms.a;

import android.util.Log;

final class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        synchronized (this.a.f) {
            if (this.a.g <= this.a.d.b() && this.a.j != null) {
                Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                this.a.j.b();
                this.a.j = null;
            }
        }
    }
}
