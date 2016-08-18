package com.c.a.a.d;

import android.support.v4.app.NotificationCompat;

final class p {
    final p[] a;
    final int b;
    final int c;

    p() {
        this.a = new p[NotificationCompat.FLAG_LOCAL_ONLY];
        this.b = 0;
        this.c = 0;
    }

    p(int i, int i2) {
        this.a = null;
        this.b = i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            i3 = 8;
        }
        this.c = i3;
    }
}
