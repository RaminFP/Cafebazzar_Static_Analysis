package com.google.android.gms.a;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;

public final class v extends Handler {
    public final void a(s sVar, r rVar) {
        sendMessage(obtainMessage(1, new Pair(sVar, rVar)));
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Pair pair = (Pair) message.obj;
                s sVar = (s) pair.first;
                r rVar = (r) pair.second;
                try {
                    sVar.a(rVar);
                    return;
                } catch (RuntimeException e) {
                    u.b(rVar);
                    throw e;
                }
            case 2:
                ((u) message.obj).b(Status.d);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
