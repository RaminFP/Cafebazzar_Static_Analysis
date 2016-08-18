package com.c.a.a;

import d.ac;
import d.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

final class h {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    f f;
    long g;
    final /* synthetic */ b h;

    private h(b bVar, String str) {
        this.h = bVar;
        this.a = str;
        this.b = new long[bVar.j];
        this.c = new File[bVar.j];
        this.d = new File[bVar.j];
        StringBuilder append = new StringBuilder(str).append('.');
        int length = append.length();
        for (int i = 0; i < bVar.j; i++) {
            append.append(i);
            this.c[i] = new File(bVar.d, append.toString());
            append.append(".tmp");
            this.d[i] = new File(bVar.d, append.toString());
            append.setLength(length);
        }
    }

    private static IOException b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    final i a() {
        int i = 0;
        if (Thread.holdsLock(this.h)) {
            ac[] acVarArr = new ac[this.h.j];
            long[] jArr = (long[]) this.b.clone();
            int i2 = 0;
            while (i2 < this.h.j) {
                try {
                    acVarArr[i2] = this.h.c.a(this.c[i2]);
                    i2++;
                } catch (FileNotFoundException e) {
                    while (i < this.h.j && acVarArr[i] != null) {
                        v.a(acVarArr[i]);
                        i++;
                    }
                    return null;
                }
            }
            return new i(this.h, this.a, this.g, acVarArr, jArr);
        }
        throw new AssertionError();
    }

    final void a(i iVar) {
        for (long j : this.b) {
            iVar.h(32).j(j);
        }
    }

    void a(String[] strArr) {
        if (strArr.length != this.h.j) {
            throw b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.b[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strArr);
            }
        }
    }
}
