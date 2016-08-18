package com.c.b;

import android.support.v4.app.NotificationCompat;

enum ad {
    MICRO(3, 96, 96),
    MINI(1, NotificationCompat.FLAG_GROUP_SUMMARY, 384),
    FULL(2, -1, -1);
    
    final int d;
    final int e;
    final int f;

    private ad(int i, int i2, int i3) {
        this.d = i;
        this.e = i2;
        this.f = i3;
    }
}
