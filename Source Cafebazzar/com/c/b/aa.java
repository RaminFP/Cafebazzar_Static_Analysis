package com.c.b;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public final class aa implements k {
    final LinkedHashMap b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    private aa(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.c = i;
        this.b = new LinkedHashMap(0, 0.75f, true);
    }

    public aa(Context context) {
        this(bj.c(context));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 <= r4) goto L_0x0041;
    L_0x0039:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0032 }
        r2 = r3.b;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r1 = r3.d;	 Catch:{ all -> 0x0032 }
        r0 = com.c.b.bj.a(r0);	 Catch:{ all -> 0x0032 }
        r0 = r1 - r0;
        r3.d = r0;	 Catch:{ all -> 0x0032 }
        r0 = r3.f;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r3.f = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.aa.a(int):void");
    }

    public final int a() {
        int i;
        synchronized (this) {
            i = this.d;
        }
        return i;
    }

    public final Bitmap a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.b.get(str);
            if (bitmap != null) {
                this.g++;
                return bitmap;
            }
            this.h++;
            return null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.e++;
            this.d += bj.a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.b.put(str, bitmap);
            if (bitmap2 != null) {
                this.d -= bj.a(bitmap2);
            }
        }
        a(this.c);
    }

    public final int b() {
        int i;
        synchronized (this) {
            i = this.c;
        }
        return i;
    }
}
