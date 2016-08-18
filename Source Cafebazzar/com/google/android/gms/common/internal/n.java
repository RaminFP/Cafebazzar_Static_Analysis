package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class n extends Handler {
    final /* synthetic */ l a;

    public n(l lVar, Looper looper) {
        this.a = lVar;
        super(looper);
    }

    private static void a(Message message) {
        ((o) message.obj).c();
    }

    private static boolean b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
    }

    public final void handleMessage(Message message) {
        if (this.a.d.get() != message.arg1) {
            if (b(message)) {
                a(message);
            }
        } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.a.k()) {
            a(message);
        } else if (message.what == 3) {
            this.a.k.a(new ConnectionResult(message.arg2, null));
            l.i_();
        } else if (message.what == 4) {
            this.a.a(4, null);
            if (this.a.r != null) {
                this.a.r.a(message.arg2);
            }
            int i = message.arg2;
            l.h();
            this.a.a(4, 1, null);
        } else if (message.what == 2 && !this.a.b()) {
            a(message);
        } else if (b(message)) {
            ((o) message.obj).b();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
