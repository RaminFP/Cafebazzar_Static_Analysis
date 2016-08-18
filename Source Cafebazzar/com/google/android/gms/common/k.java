package com.google.android.gms.common;

import com.google.android.gms.common.internal.av;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class k {
    private int a;

    protected k(byte[] bArr) {
        av.b(bArr.length == 25, "cert hash data has incorrect length");
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    abstract byte[] a();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        return Arrays.equals(a(), ((k) obj).a());
    }

    public int hashCode() {
        return this.a;
    }
}
