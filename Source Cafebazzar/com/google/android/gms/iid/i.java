package com.google.android.gms.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;

final class i extends Handler {
    final /* synthetic */ h a;

    i(h hVar, Looper looper) {
        this.a = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        h hVar = this.a;
        if (message == null) {
            return;
        }
        if (message.obj instanceof Intent) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    hVar.i = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    hVar.h = (Messenger) parcelableExtra;
                }
            }
            hVar.b((Intent) message.obj);
            return;
        }
        Log.w("InstanceID/Rpc", "Dropping invalid message");
    }
}
