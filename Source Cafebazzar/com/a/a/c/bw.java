package com.a.a.c;

import b.a.a.a.a.b.af;
import java.io.InputStream;

final class bw implements af {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int[] b;
    final /* synthetic */ bv c;

    bw(bv bvVar, byte[] bArr, int[] iArr) {
        this.c = bvVar;
        this.a = bArr;
        this.b = iArr;
    }

    public final void a(InputStream inputStream, int i) {
        try {
            inputStream.read(this.a, this.b[0], i);
            int[] iArr = this.b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
