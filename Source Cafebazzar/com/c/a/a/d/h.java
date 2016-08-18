package com.c.a.a.d;

import android.support.v4.app.NotificationCompat;
import d.ac;
import d.j;
import d.k;
import d.r;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class h {
    final List a = new ArrayList();
    final j b;
    int c;
    int d;
    e[] e = new e[8];
    int f = (this.e.length - 1);
    int g = 0;
    int h = 0;

    h(int i, ac acVar) {
        this.c = i;
        this.d = i;
        this.b = r.a(acVar);
    }

    private void c() {
        this.a.clear();
        Arrays.fill(this.e, null);
        this.f = this.e.length - 1;
        this.g = 0;
        this.h = 0;
    }

    static boolean c(int i) {
        return i >= 0 && i <= g.a.length - 1;
    }

    private int d() {
        return this.b.g() & 255;
    }

    private int d(int i) {
        int i2 = 0;
        if (i > 0) {
            for (int length = this.e.length - 1; length >= this.f && i > 0; length--) {
                i -= this.e[length].j;
                this.h -= this.e[length].j;
                this.g--;
                i2++;
            }
            System.arraycopy(this.e, this.f + 1, this.e, (this.f + 1) + i2, this.g);
            this.f += i2;
        }
        return i2;
    }

    int a(int i) {
        return (this.f + 1) + i;
    }

    final int a(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        i3 = 0;
        while (true) {
            int d = d();
            if ((d & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return (d << i3) + i2;
            }
            i2 += (d & 127) << i3;
            i3 += 7;
        }
    }

    void a() {
        if (this.d >= this.h) {
            return;
        }
        if (this.d == 0) {
            c();
        } else {
            d(this.h - this.d);
        }
    }

    void a(int i, e eVar) {
        this.a.add(eVar);
        int i2 = eVar.j;
        if (i2 > this.d) {
            c();
            return;
        }
        d((this.h + i2) - this.d);
        if (this.g + 1 > this.e.length) {
            Object obj = new e[(this.e.length << 1)];
            System.arraycopy(this.e, 0, obj, this.e.length, this.e.length);
            this.f = this.e.length - 1;
            this.e = obj;
        }
        int i3 = this.f;
        this.f = i3 - 1;
        this.e[i3] = eVar;
        this.g++;
        this.h = i2 + this.h;
    }

    final k b() {
        int i = 0;
        int d = d();
        int i2 = (d & NotificationCompat.FLAG_HIGH_PRIORITY) == NotificationCompat.FLAG_HIGH_PRIORITY ? 1 : 0;
        d = a(d, 127);
        if (i2 == 0) {
            return this.b.c((long) d);
        }
        o a = o.a();
        byte[] e = this.b.e((long) d);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        p pVar = a.a;
        int i3 = 0;
        for (byte b : e) {
            i = (i << 8) | (b & 255);
            i3 += 8;
            while (i3 >= 8) {
                pVar = pVar.a[(i >>> (i3 - 8)) & 255];
                if (pVar.a == null) {
                    byteArrayOutputStream.write(pVar.b);
                    i3 -= pVar.c;
                    pVar = a.a;
                } else {
                    i3 -= 8;
                }
            }
        }
        while (i3 > 0) {
            pVar = pVar.a[(i << (8 - i3)) & 255];
            if (pVar.a != null || pVar.c > i3) {
                break;
            }
            byteArrayOutputStream.write(pVar.b);
            i3 -= pVar.c;
            pVar = a.a;
        }
        return k.a(byteArrayOutputStream.toByteArray());
    }

    k b(int i) {
        return c(i) ? g.a[i].h : this.e[a(i - g.a.length)].h;
    }
}
