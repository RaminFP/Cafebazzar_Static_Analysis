package com.farsitel.bazaar.widget;

import android.os.Handler;
import android.os.Message;

final class j extends Handler {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    h.a(this.a);
                    if (!this.a.f && this.a.a.isPlaying()) {
                        sendMessageDelayed(obtainMessage(0), (long) this.a.e);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            default:
                return;
        }
    }
}
