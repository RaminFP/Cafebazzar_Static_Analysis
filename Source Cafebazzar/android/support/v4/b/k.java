package android.support.v4.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class k extends Handler {
    final /* synthetic */ j a;

    k(j jVar, Looper looper) {
        this.a = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                j.a(this.a);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
