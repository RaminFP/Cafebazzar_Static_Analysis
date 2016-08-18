package com.google.android.gms.a;

import android.support.v4.app.NotificationCompat;

public final class dc {
    final byte[] a;
    int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h;
    private int i = 64;
    private int j = 67108864;

    public dc(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
        this.e = i;
    }

    private void e(int i) {
        if (this.f != i) {
            throw dk.e();
        }
    }

    private byte[] f(int i) {
        if (i < 0) {
            throw dk.b();
        } else if (this.e + i > this.g) {
            g(this.g - this.e);
            throw dk.a();
        } else if (i <= this.c - this.e) {
            Object obj = new byte[i];
            System.arraycopy(this.a, this.e, obj, 0, i);
            this.e += i;
            return obj;
        } else {
            throw dk.a();
        }
    }

    private void g(int i) {
        if (i < 0) {
            throw dk.b();
        } else if (this.e + i > this.g) {
            g(this.g - this.e);
            throw dk.a();
        } else if (i <= this.c - this.e) {
            this.e += i;
        } else {
            throw dk.a();
        }
    }

    private void j() {
        this.c += this.d;
        int i = this.c;
        if (i > this.g) {
            this.d = i - this.g;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    private byte k() {
        if (this.e == this.c) {
            throw dk.a();
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public final int a() {
        if ((this.e == this.c ? 1 : 0) != 0) {
            this.f = 0;
            return 0;
        }
        this.f = e();
        if (this.f != 0) {
            return this.f;
        }
        throw dk.d();
    }

    public final void a(dl dlVar) {
        int e = e();
        if (this.h >= this.i) {
            throw dk.g();
        }
        e = b(e);
        this.h++;
        dlVar.a(this);
        e(0);
        this.h--;
        c(e);
    }

    public final boolean a(int i) {
        switch (do.a(i)) {
            case 0:
                e();
                return true;
            case 1:
                byte k = k();
                byte k2 = k();
                byte k3 = k();
                byte k4 = k();
                byte k5 = k();
                byte k6 = k();
                long j = (long) k;
                j = (long) k2;
                long j2 = (long) k3;
                j2 = (long) k4;
                j2 = (long) k5;
                j2 = (long) k6;
                j2 = (long) k();
                j2 = (long) k();
                return true;
            case 2:
                g(e());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                g();
                return true;
            default:
                throw dk.f();
        }
        int a;
        do {
            a = a();
            if (a != 0) {
            }
            e(do.a(do.b(i), 4));
            return true;
        } while (a(a));
        e(do.a(do.b(i), 4));
        return true;
    }

    public final int b(int i) {
        if (i < 0) {
            throw dk.b();
        }
        int i2 = this.e + i;
        int i3 = this.g;
        if (i2 > i3) {
            throw dk.a();
        }
        this.g = i2;
        j();
        return i3;
    }

    public final boolean b() {
        return e() != 0;
    }

    public final String c() {
        int e = e();
        if (e > this.c - this.e || e <= 0) {
            return new String(f(e), "UTF-8");
        }
        String str = new String(this.a, this.e, e, "UTF-8");
        this.e = e + this.e;
        return str;
    }

    public final void c(int i) {
        this.g = i;
        j();
    }

    public final void d(int i) {
        if (i > this.e - this.b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.e - this.b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.e = this.b + i;
        }
    }

    public final byte[] d() {
        int e = e();
        if (e > this.c - this.e || e <= 0) {
            return e == 0 ? do.h : f(e);
        } else {
            Object obj = new byte[e];
            System.arraycopy(this.a, this.e, obj, 0, e);
            this.e = e + this.e;
            return obj;
        }
    }

    public final int e() {
        byte k = k();
        if (k >= (byte) 0) {
            return k;
        }
        int i = k & 127;
        byte k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 7);
        }
        i |= (k2 & 127) << 7;
        k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 14);
        }
        i |= (k2 & 127) << 14;
        k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 21);
        }
        byte k3 = k();
        i = (i | ((k2 & 127) << 21)) | (k3 << 28);
        if (k3 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (k() >= (byte) 0) {
                return i;
            }
        }
        throw dk.c();
    }

    public final long f() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte k = k();
            j |= ((long) (k & 127)) << i;
            if ((k & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return j;
            }
        }
        throw dk.c();
    }

    public final int g() {
        return (((k() & 255) | ((k() & 255) << 8)) | ((k() & 255) << 16)) | ((k() & 255) << 24);
    }

    public final int h() {
        if (this.g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.g - this.e;
    }

    public final int i() {
        return this.e - this.b;
    }
}
