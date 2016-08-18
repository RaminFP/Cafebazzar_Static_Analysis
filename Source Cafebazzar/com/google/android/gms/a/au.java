package com.google.android.gms.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class au extends Handler {
    final /* synthetic */ ar a;

    au(ar arVar, Looper looper) {
        this.a = arVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ar.b(this.a);
                return;
            case 2:
                ar.a(this.a);
                return;
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
