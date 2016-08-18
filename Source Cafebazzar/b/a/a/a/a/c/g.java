package b.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class g extends Handler {
    public g() {
        super(Looper.getMainLooper());
    }

    public final void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case 1:
                a.c(fVar.a, fVar.b[0]);
                return;
            case 2:
                a.p_();
                return;
            default:
                return;
        }
    }
}
