package com.c.a.a.d;

import android.support.v4.app.NotificationCompat;
import d.f;
import d.k;
import java.util.List;

final class i {
    private final f a;

    i(f fVar) {
        this.a = fVar;
    }

    private void a(int i, int i2, int i3) {
        if (i < i2) {
            this.a.b(i | 0);
            return;
        }
        this.a.b(i2 | 0);
        int i4 = i - i2;
        while (i4 >= NotificationCompat.FLAG_HIGH_PRIORITY) {
            this.a.b((i4 & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i4 >>>= 7;
        }
        this.a.b(i4);
    }

    private void a(k kVar) {
        a(kVar.c.length, 127, 0);
        this.a.a(kVar);
    }

    final void a(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k c = ((e) list.get(i)).h.c();
            Integer num = (Integer) g.b.get(c);
            if (num != null) {
                a(num.intValue() + 1, 15, 0);
                a(((e) list.get(i)).i);
            } else {
                this.a.b(0);
                a(c);
                a(((e) list.get(i)).i);
            }
        }
    }
}
