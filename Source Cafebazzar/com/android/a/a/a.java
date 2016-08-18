package com.android.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    protected static final Comparator a = new b();
    private List b = new LinkedList();
    private List c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public a(int i) {
        this.e = i;
    }

    private void a() {
        synchronized (this) {
            while (this.d > this.e) {
                byte[] bArr = (byte[]) this.b.remove(0);
                this.c.remove(bArr);
                this.d -= bArr.length;
            }
        }
    }

    public final void a(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.e) {
                    this.b.add(bArr);
                    int binarySearch = Collections.binarySearch(this.c, bArr, a);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 1;
                    }
                    this.c.add(binarySearch, bArr);
                    this.d += bArr.length;
                    a();
                }
            }
        }
    }

    public final byte[] a(int i) {
        byte[] bArr;
        synchronized (this) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                bArr = (byte[]) this.c.get(i2);
                if (bArr.length >= i) {
                    this.d -= bArr.length;
                    this.c.remove(i2);
                    this.b.remove(bArr);
                    break;
                }
            }
            bArr = new byte[i];
        }
        return bArr;
    }
}
