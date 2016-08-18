package com.a.a.c;

import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;

final class f implements Flushable {
    final byte[] a;
    final int b;
    int c = 0;
    final OutputStream d;

    private f(OutputStream outputStream, byte[] bArr) {
        this.d = outputStream;
        this.a = bArr;
        this.b = bArr.length;
    }

    public static int a(int i) {
        return c(cg.a(i, 0));
    }

    public static f a(OutputStream outputStream) {
        return new f(outputStream, new byte[4096]);
    }

    private void a(long j) {
        while ((-128 & j) != 0) {
            d((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        d((int) j);
    }

    public static int b(int i, float f) {
        return a(1) + 4;
    }

    public static int b(int i, long j) {
        int a = a(i);
        int i2 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
        return i2 + a;
    }

    public static int b(int i, b bVar) {
        return a(i) + (c(bVar.a.length) + bVar.a.length);
    }

    public static int b(int i, boolean z) {
        return a(i) + 1;
    }

    public static int c(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int d(int i, int i2) {
        return a(i) + c(i2);
    }

    private void d(int i) {
        byte b = (byte) i;
        if (this.c == this.b) {
            a();
        }
        byte[] bArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i2] = b;
    }

    private static int e(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int e(int i, int i2) {
        return (i2 >= 0 ? c(i2) : 10) + a(i);
    }

    public static int f(int i, int i2) {
        return a(2) + c(e(i2));
    }

    void a() {
        if (this.d == null) {
            throw new g();
        }
        this.d.write(this.a, 0, this.c);
        this.c = 0;
    }

    public final void a(int i, float f) {
        g(1, 5);
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        d(floatToRawIntBits & 255);
        d((floatToRawIntBits >> 8) & 255);
        d((floatToRawIntBits >> 16) & 255);
        d(floatToRawIntBits >>> 24);
    }

    public final void a(int i, int i2) {
        g(i, 0);
        b(i2);
    }

    public final void a(int i, long j) {
        g(i, 0);
        a(j);
    }

    public final void a(int i, b bVar) {
        g(i, 2);
        b(bVar.a.length);
        int length = bVar.a.length;
        if (this.b - this.c >= length) {
            bVar.a(this.a, 0, this.c, length);
            this.c = length + this.c;
            return;
        }
        int i2 = this.b - this.c;
        bVar.a(this.a, 0, this.c, i2);
        int i3 = i2 + 0;
        length -= i2;
        this.c = this.b;
        a();
        if (length <= this.b) {
            bVar.a(this.a, i3, 0, length);
            this.c = length;
            return;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bVar.a);
        if (((long) i3) != byteArrayInputStream.skip((long) i3)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (length > 0) {
            i3 = Math.min(length, this.b);
            int read = byteArrayInputStream.read(this.a, 0, i3);
            if (read != i3) {
                throw new IllegalStateException("Read failed.");
            }
            this.d.write(this.a, 0, read);
            length -= read;
        }
    }

    public final void a(int i, boolean z) {
        int i2 = 0;
        g(i, 0);
        if (z) {
            i2 = 1;
        }
        d(i2);
    }

    public final void b(int i) {
        while ((i & -128) != 0) {
            d((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        d(i);
    }

    public final void b(int i, int i2) {
        g(i, 0);
        if (i2 >= 0) {
            b(i2);
        } else {
            a((long) i2);
        }
    }

    public final void c(int i, int i2) {
        g(2, 0);
        b(e(i2));
    }

    public final void flush() {
        if (this.d != null) {
            a();
        }
    }

    public final void g(int i, int i2) {
        b(cg.a(i, i2));
    }
}
