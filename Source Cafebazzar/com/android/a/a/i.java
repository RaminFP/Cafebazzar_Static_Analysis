package com.android.a.a;

import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayOutputStream;

public final class i extends ByteArrayOutputStream {
    private final a a;

    public i(a aVar, int i) {
        this.a = aVar;
        this.buf = this.a.a(Math.max(i, NotificationCompat.FLAG_LOCAL_ONLY));
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.a.a((this.count + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.a.a(this.buf);
            this.buf = a;
        }
    }

    public final void close() {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    public final void write(int i) {
        synchronized (this) {
            a(1);
            super.write(i);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        synchronized (this) {
            a(i2);
            super.write(bArr, i, i2);
        }
    }
}
