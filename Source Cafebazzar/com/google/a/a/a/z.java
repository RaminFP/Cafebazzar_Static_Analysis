package com.google.a.a.a;

import android.os.Handler.Callback;
import android.os.Message;

final class z implements Callback {
    final /* synthetic */ x a;

    z(x xVar) {
        this.a = xVar;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && x.a.equals(message.obj)) {
            an.a().a(true);
            this.a.c();
            an.a().a(false);
            if (this.a.e > 0 && !this.a.n) {
                this.a.l.sendMessageDelayed(this.a.l.obtainMessage(1, x.a), (long) (this.a.e * 1000));
            }
        }
        return true;
    }
}
