package com.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bk extends Handler {
    bk(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000);
    }
}
