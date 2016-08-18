package com.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bd extends Handler {
    private final bc a;

    public bd(Looper looper, bc bcVar) {
        super(looper);
        this.a = bcVar;
    }

    public final void handleMessage(Message message) {
        bc bcVar;
        long j;
        switch (message.what) {
            case 0:
                bcVar = this.a;
                bcVar.d++;
                return;
            case 1:
                bcVar = this.a;
                bcVar.e++;
                return;
            case 2:
                bcVar = this.a;
                j = (long) message.arg1;
                bcVar.m++;
                bcVar.g = j + bcVar.g;
                bcVar.j = bcVar.g / ((long) bcVar.m);
                return;
            case 3:
                bcVar = this.a;
                j = (long) message.arg1;
                bcVar.n++;
                bcVar.h = j + bcVar.h;
                bcVar.k = bcVar.h / ((long) bcVar.m);
                return;
            case 4:
                bc bcVar2 = this.a;
                Long l = (Long) message.obj;
                bcVar2.l++;
                bcVar2.f += l.longValue();
                bcVar2.i = bcVar2.f / ((long) bcVar2.l);
                return;
            default:
                aj.a.post(new be(this, message));
                return;
        }
    }
}
