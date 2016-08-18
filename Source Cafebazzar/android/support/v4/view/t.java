package android.support.v4.view;

import android.os.Handler;
import android.os.Message;

final class t extends Handler {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    t(s sVar, Handler handler) {
        this.a = sVar;
        super(handler.getLooper());
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.i.onShowPress(this.a.p);
                return;
            case 2:
                s.c(this.a);
                return;
            case 3:
                if (this.a.j == null) {
                    return;
                }
                if (this.a.k) {
                    this.a.l = true;
                    return;
                } else {
                    this.a.j.onSingleTapConfirmed(this.a.p);
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}
