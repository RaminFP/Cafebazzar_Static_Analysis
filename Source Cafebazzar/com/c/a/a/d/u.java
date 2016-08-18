package com.c.a.a.d;

import java.util.zip.Inflater;

final class u extends Inflater {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final int inflate(byte[] bArr, int i, int i2) {
        int inflate = super.inflate(bArr, i, i2);
        if (inflate != 0 || !needsDictionary()) {
            return inflate;
        }
        setDictionary(z.a);
        return super.inflate(bArr, i, i2);
    }
}
