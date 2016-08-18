package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class fl extends k {
    private static final WeakReference b = new WeakReference(null);
    private WeakReference a = b;

    fl(byte[] bArr) {
        super(bArr);
    }

    final byte[] a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.a.get();
            if (bArr == null) {
                bArr = b();
                this.a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] b();
}
