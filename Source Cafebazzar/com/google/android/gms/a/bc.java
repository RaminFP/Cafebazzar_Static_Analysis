package com.google.android.gms.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class bc extends Handler {
    final /* synthetic */ ba a;

    bc(ba baVar, Looper looper) {
        this.a = baVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((bb) message.obj).a(this.a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", "Unknown message id: " + message.what);
                return;
        }
    }
}
