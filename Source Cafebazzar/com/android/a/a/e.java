package com.android.a.a;

import java.io.FilterInputStream;
import java.io.InputStream;

final class e extends FilterInputStream {
    private int a;

    private e(InputStream inputStream) {
        super(inputStream);
        this.a = 0;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.a++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.a += read;
        }
        return read;
    }
}
