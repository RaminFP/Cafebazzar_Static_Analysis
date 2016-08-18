package com.c.b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class ak extends Handler {
    ak(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = 0;
        List list;
        switch (message.what) {
            case 3:
                a aVar = (a) message.obj;
                if (aVar.a.n) {
                    bj.a("Main", "canceled", aVar.b.a(), "target got garbage collected");
                }
                aVar.a.a(aVar.c());
                return;
            case 8:
                list = (List) message.obj;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = (d) list.get(i2);
                    aj ajVar = dVar.b;
                    a aVar2 = dVar.k;
                    List list2 = dVar.l;
                    int i3 = (list2 == null || list2.isEmpty()) ? 0 : 1;
                    int i4 = (aVar2 == null && i3 == 0) ? 0 : 1;
                    if (i4 != 0) {
                        Uri uri = dVar.g.d;
                        Exception exception = dVar.p;
                        Bitmap bitmap = dVar.m;
                        ap apVar = dVar.o;
                        if (aVar2 != null) {
                            ajVar.a(bitmap, apVar, aVar2);
                        }
                        if (i3 != 0) {
                            i3 = list2.size();
                            for (i4 = 0; i4 < i3; i4++) {
                                ajVar.a(bitmap, apVar, (a) list2.get(i4));
                            }
                        }
                    }
                }
                return;
            case 13:
                list = (List) message.obj;
                int size2 = list.size();
                while (i < size2) {
                    a aVar3 = (a) list.get(i);
                    aj ajVar2 = aVar3.a;
                    Bitmap bitmap2 = null;
                    if (ae.a(aVar3.e)) {
                        bitmap2 = ajVar2.a(aVar3.i);
                    }
                    if (bitmap2 != null) {
                        ajVar2.a(bitmap2, ap.MEMORY, aVar3);
                        if (ajVar2.n) {
                            bj.a("Main", "completed", aVar3.b.a(), "from " + ap.MEMORY);
                        }
                    } else {
                        ajVar2.a(aVar3);
                        if (ajVar2.n) {
                            bj.a("Main", "resumed", aVar3.b.a());
                        }
                    }
                    i++;
                }
                return;
            default:
                throw new AssertionError("Unknown handler message received: " + message.what);
        }
    }
}
