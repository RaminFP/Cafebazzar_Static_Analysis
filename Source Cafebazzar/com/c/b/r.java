package com.c.b;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class r extends Handler {
    private final q a;

    public r(Looper looper, q qVar) {
        super(looper);
        this.a = qVar;
    }

    public final void handleMessage(Message message) {
        d dVar;
        switch (message.what) {
            case 1:
                this.a.a((a) message.obj, true);
                return;
            case 2:
                a aVar = (a) message.obj;
                q qVar = this.a;
                String str = aVar.i;
                d dVar2 = (d) qVar.e.get(str);
                if (dVar2 != null) {
                    dVar2.a(aVar);
                    if (dVar2.a()) {
                        qVar.e.remove(str);
                        if (aVar.a.n) {
                            bj.a("Dispatcher", "canceled", aVar.b.a());
                        }
                    }
                }
                if (qVar.h.contains(aVar.j)) {
                    qVar.g.remove(aVar.c());
                    if (aVar.a.n) {
                        bj.a("Dispatcher", "canceled", aVar.b.a(), "because paused request got canceled");
                    }
                }
                aVar = (a) qVar.f.remove(aVar.c());
                if (aVar != null && aVar.a.n) {
                    bj.a("Dispatcher", "canceled", aVar.b.a(), "from replaying");
                    return;
                }
                return;
            case 4:
                dVar = (d) message.obj;
                q qVar2 = this.a;
                if (ae.b(dVar.h)) {
                    qVar2.k.a(dVar.f, dVar.m);
                }
                qVar2.e.remove(dVar.f);
                qVar2.d(dVar);
                if (dVar.b.n) {
                    bj.a("Dispatcher", "batched", bj.a(dVar), "for completion");
                    return;
                }
                return;
            case 5:
                this.a.c((d) message.obj);
                return;
            case 6:
                this.a.a((d) message.obj, false);
                return;
            case 7:
                q qVar3 = this.a;
                List arrayList = new ArrayList(qVar3.m);
                qVar3.m.clear();
                qVar3.j.sendMessage(qVar3.j.obtainMessage(8, arrayList));
                q.a(arrayList);
                return;
            case 9:
                this.a.a((NetworkInfo) message.obj);
                return;
            case 10:
                this.a.p = message.arg1 == 1;
                return;
            case 11:
                Object obj = message.obj;
                q qVar4 = this.a;
                if (qVar4.h.add(obj)) {
                    Iterator it = qVar4.e.values().iterator();
                    while (it.hasNext()) {
                        dVar = (d) it.next();
                        boolean z = dVar.b.n;
                        a aVar2 = dVar.k;
                        List list = dVar.l;
                        boolean z2 = (list == null || list.isEmpty()) ? false : true;
                        if (aVar2 != null || z2) {
                            if (aVar2 != null && aVar2.j.equals(obj)) {
                                dVar.a(aVar2);
                                qVar4.g.put(aVar2.c(), aVar2);
                                if (z) {
                                    bj.a("Dispatcher", "paused", aVar2.b.a(), "because tag '" + obj + "' was paused");
                                }
                            }
                            if (z2) {
                                for (int size = list.size() - 1; size >= 0; size--) {
                                    a aVar3 = (a) list.get(size);
                                    if (aVar3.j.equals(obj)) {
                                        dVar.a(aVar3);
                                        qVar4.g.put(aVar3.c(), aVar3);
                                        if (z) {
                                            bj.a("Dispatcher", "paused", aVar3.b.a(), "because tag '" + obj + "' was paused");
                                        }
                                    }
                                }
                            }
                            if (dVar.a()) {
                                it.remove();
                                if (z) {
                                    bj.a("Dispatcher", "canceled", bj.a(dVar), "all actions paused");
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            case 12:
                this.a.a(message.obj);
                return;
            default:
                aj.a.post(new s(this, message));
                return;
        }
    }
}
