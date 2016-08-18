package android.support.v7.app;

import android.support.v4.app.NotificationCompat;

final class v implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    v(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void run() {
        if ((this.a.u & 1) != 0) {
            AppCompatDelegateImplV7.a(this.a, 0);
        }
        if ((this.a.u & NotificationCompat.FLAG_LOCAL_ONLY) != 0) {
            AppCompatDelegateImplV7.a(this.a, 8);
        }
        this.a.t = false;
        this.a.u = 0;
    }
}
