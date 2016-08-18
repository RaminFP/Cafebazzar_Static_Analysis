package com.google.a.a.a;

import java.util.SortedSet;
import java.util.TreeSet;

final class an {
    private static final an d = new an();
    private SortedSet a = new TreeSet();
    private StringBuilder b = new StringBuilder();
    private boolean c = false;

    private an() {
    }

    public static an a() {
        return d;
    }

    public final void a(ao aoVar) {
        synchronized (this) {
            if (!this.c) {
                this.a.add(aoVar);
                this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(aoVar.ordinal()));
            }
        }
    }

    public final void a(boolean z) {
        synchronized (this) {
            this.c = z;
        }
    }

    public final String b() {
        String stringBuilder;
        synchronized (this) {
            StringBuilder stringBuilder2 = new StringBuilder();
            int i = 6;
            int i2 = 0;
            while (this.a.size() > 0) {
                ao aoVar = (ao) this.a.first();
                this.a.remove(aoVar);
                int ordinal = aoVar.ordinal();
                while (ordinal >= i) {
                    stringBuilder2.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                    i += 6;
                    i2 = 0;
                }
                i2 += 1 << (aoVar.ordinal() % 6);
            }
            if (i2 > 0 || stringBuilder2.length() == 0) {
                stringBuilder2.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
            }
            this.a.clear();
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    public final String c() {
        String stringBuilder;
        synchronized (this) {
            if (this.b.length() > 0) {
                this.b.insert(0, ".");
            }
            stringBuilder = this.b.toString();
            this.b = new StringBuilder();
        }
        return stringBuilder;
    }
}
