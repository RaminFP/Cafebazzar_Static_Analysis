package com.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final class d implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal u = new e();
    private static final AtomicInteger v = new AtomicInteger();
    private static final az w = new f();
    final int a = v.incrementAndGet();
    final aj b;
    final q c;
    final k d;
    final bc e;
    final String f;
    final aw g;
    final int h;
    int i;
    final az j;
    a k;
    List l;
    Bitmap m;
    Future n;
    ap o;
    Exception p;
    int q;
    int r;
    int s;

    private d(aj ajVar, q qVar, k kVar, bc bcVar, a aVar, az azVar) {
        this.b = ajVar;
        this.c = qVar;
        this.d = kVar;
        this.e = bcVar;
        this.k = aVar;
        this.f = aVar.i;
        this.g = aVar.b;
        this.s = aVar.b.r;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = azVar;
        this.r = azVar.a();
    }

    private static Bitmap a(List list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            bg bgVar = (bg) list.get(i);
            try {
                bitmap = bgVar.a(bitmap2);
                if (bitmap == null) {
                    StringBuilder append = new StringBuilder("Transformation ").append(bgVar.a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (bg bgVar2 : list) {
                        append.append(bgVar2.a()).append('\n');
                    }
                    aj.a.post(new h(append));
                    return null;
                } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                    aj.a.post(new i(bgVar2));
                    return null;
                } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmap;
                } else {
                    aj.a.post(new j(bgVar2));
                    return null;
                }
            } catch (RuntimeException e) {
                aj.a.post(new g(bgVar2, e));
                return null;
            }
        }
        return bitmap2;
    }

    static d a(aj ajVar, q qVar, k kVar, bc bcVar, a aVar) {
        aw awVar = aVar.b;
        List list = ajVar.d;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            az azVar = (az) list.get(i);
            if (azVar.a(awVar)) {
                return new d(ajVar, qVar, kVar, bcVar, aVar, azVar);
            }
        }
        return new d(ajVar, qVar, kVar, bcVar, aVar, w);
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    private Bitmap c() {
        Bitmap bitmap = null;
        if (ae.a(this.h)) {
            bitmap = this.d.a(this.f);
            if (bitmap != null) {
                this.e.a();
                this.o = ap.MEMORY;
                if (this.b.n) {
                    bj.a("Hunter", "decoded", this.g.a(), "from cache");
                }
                return bitmap;
            }
        }
        this.g.c = this.r == 0 ? af.OFFLINE.d : this.i;
        ba b = this.j.b(this.g);
        if (b != null) {
            this.o = b.a;
            this.q = b.d;
            bitmap = b.b;
            if (bitmap == null) {
                InputStream inputStream = b.c;
                try {
                    aw awVar = this.g;
                    InputStream abVar = new ab(inputStream);
                    long a = abVar.a(65536);
                    Options d = az.d(awVar);
                    boolean a2 = az.a(d);
                    boolean c = bj.c(abVar);
                    abVar.a(a);
                    if (c) {
                        byte[] b2 = bj.b(abVar);
                        if (a2) {
                            BitmapFactory.decodeByteArray(b2, 0, b2.length, d);
                            az.a(awVar.h, awVar.i, d, awVar);
                        }
                        bitmap = BitmapFactory.decodeByteArray(b2, 0, b2.length, d);
                    } else {
                        if (a2) {
                            BitmapFactory.decodeStream(abVar, null, d);
                            az.a(awVar.h, awVar.i, d, awVar);
                            abVar.a(a);
                        }
                        bitmap = BitmapFactory.decodeStream(abVar, null, d);
                        if (bitmap == null) {
                            throw new IOException("Failed to decode stream.");
                        }
                    }
                    bj.a(inputStream);
                } catch (Throwable th) {
                    bj.a(inputStream);
                }
            }
        }
        if (bitmap != null) {
            if (this.b.n) {
                bj.a("Hunter", "decoded", this.g.a());
            }
            this.e.a(bitmap, 2);
            aw awVar2 = this.g;
            Object obj = (awVar2.d() || awVar2.e()) ? 1 : null;
            if (!(obj == null && this.q == 0)) {
                synchronized (t) {
                    if (this.g.d() || this.q != 0) {
                        int ceil;
                        int i;
                        int i2;
                        Bitmap createBitmap;
                        awVar2 = this.g;
                        int i3 = this.q;
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        boolean z = awVar2.l;
                        Matrix matrix = new Matrix();
                        if (awVar2.d()) {
                            int i4 = awVar2.h;
                            int i5 = awVar2.i;
                            float f = awVar2.m;
                            if (f != 0.0f) {
                                if (awVar2.p) {
                                    matrix.setRotate(f, awVar2.n, awVar2.o);
                                } else {
                                    matrix.setRotate(f);
                                }
                            }
                            float f2;
                            if (awVar2.j) {
                                int i6;
                                float f3;
                                float f4 = ((float) i4) / ((float) width);
                                f2 = ((float) i5) / ((float) height);
                                if (f4 > f2) {
                                    ceil = (int) Math.ceil((double) ((f2 / f4) * ((float) height)));
                                    i = (height - ceil) / 2;
                                    i6 = 0;
                                    f3 = f4;
                                    f4 = ((float) i5) / ((float) ceil);
                                    i2 = width;
                                } else {
                                    i2 = (int) Math.ceil((double) (((float) width) * (f4 / f2)));
                                    i6 = (width - i2) / 2;
                                    i = 0;
                                    f3 = ((float) i4) / ((float) i2);
                                    f4 = f2;
                                    ceil = height;
                                }
                                if (a(z, width, height, i4, i5)) {
                                    matrix.preScale(f3, f4);
                                }
                                width = ceil;
                                ceil = i6;
                            } else if (awVar2.k) {
                                f = ((float) i4) / ((float) width);
                                f2 = ((float) i5) / ((float) height);
                                if (f < f2) {
                                    f2 = f;
                                }
                                if (a(z, width, height, i4, i5)) {
                                    matrix.preScale(f2, f2);
                                }
                                ceil = 0;
                                i = 0;
                                i2 = width;
                                width = height;
                            } else if (!((i4 == 0 && i5 == 0) || (i4 == width && i5 == height))) {
                                f = i4 != 0 ? ((float) i4) / ((float) width) : ((float) i5) / ((float) height);
                                f2 = i5 != 0 ? ((float) i5) / ((float) height) : ((float) i4) / ((float) width);
                                if (a(z, width, height, i4, i5)) {
                                    matrix.preScale(f, f2);
                                }
                            }
                            if (i3 != 0) {
                                matrix.preRotate((float) i3);
                            }
                            createBitmap = Bitmap.createBitmap(bitmap, ceil, i, i2, width, matrix, true);
                            if (createBitmap != bitmap) {
                                bitmap.recycle();
                                bitmap = createBitmap;
                            }
                            if (this.b.n) {
                                bj.a("Hunter", "transformed", this.g.a());
                            }
                        }
                        ceil = 0;
                        i = 0;
                        i2 = width;
                        width = height;
                        if (i3 != 0) {
                            matrix.preRotate((float) i3);
                        }
                        createBitmap = Bitmap.createBitmap(bitmap, ceil, i, i2, width, matrix, true);
                        if (createBitmap != bitmap) {
                            bitmap.recycle();
                            bitmap = createBitmap;
                        }
                        if (this.b.n) {
                            bj.a("Hunter", "transformed", this.g.a());
                        }
                    }
                    if (this.g.e()) {
                        bitmap = a(this.g.g, bitmap);
                        if (this.b.n) {
                            bj.a("Hunter", "transformed", this.g.a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.e.a(bitmap, 3);
                }
            }
        }
        return bitmap;
    }

    final void a(a aVar) {
        boolean z;
        int i = 1;
        int i2 = 0;
        if (this.k == aVar) {
            this.k = null;
            z = true;
        } else {
            z = this.l != null ? this.l.remove(aVar) : false;
        }
        if (z && aVar.b.r == this.s) {
            int i3 = aq.a;
            int i4 = (this.l == null || this.l.isEmpty()) ? 0 : 1;
            if (this.k == null && i4 == 0) {
                i = 0;
            }
            if (i != 0) {
                i = this.k != null ? this.k.b.r : i3;
                if (i4 != 0) {
                    i3 = this.l.size();
                    while (i2 < i3) {
                        i4 = ((a) this.l.get(i2)).b.r;
                        if (i4 - 1 <= i - 1) {
                            i4 = i;
                        }
                        i2++;
                        i = i4;
                    }
                }
            } else {
                i = i3;
            }
            this.s = i;
        }
        if (this.b.n) {
            bj.a("Hunter", "removed", aVar.b.a(), bj.a(this, "from "));
        }
    }

    final boolean a() {
        return this.k == null ? (this.l == null || this.l.isEmpty()) && this.n != null && this.n.cancel(false) : false;
    }

    final boolean b() {
        return this.n != null && this.n.isCancelled();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r28 = this;
        r0 = r28;
        r2 = r0.g;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3 = r2.d;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        if (r3 == 0) goto L_0x006c;
    L_0x0008:
        r2 = r2.d;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = r2.getPath();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3 = r2;
    L_0x0013:
        r2 = u;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = r2.get();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = (java.lang.StringBuilder) r2;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r4 = r3.length();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r4 = r4 + 8;
        r2.ensureCapacity(r4);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r4 = 8;
        r5 = r2.length();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2.replace(r4, r5, r3);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3 = java.lang.Thread.currentThread();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = r2.toString();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3.setName(r2);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r0 = r28;
        r2 = r0.b;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = r2.n;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        if (r2 == 0) goto L_0x004b;
    L_0x0040:
        r2 = "Hunter";
        r3 = "executing";
        r4 = com.c.b.bj.a(r28);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        com.c.b.bj.a(r2, r3, r4);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
    L_0x004b:
        r2 = r28.c();	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r0 = r28;
        r0.m = r2;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r0 = r28;
        r2 = r0.m;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        if (r2 != 0) goto L_0x0074;
    L_0x0059:
        r0 = r28;
        r2 = r0.c;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r0 = r28;
        r2.b(r0);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
    L_0x0062:
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
    L_0x006b:
        return;
    L_0x006c:
        r2 = r2.e;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3 = r2;
        goto L_0x0013;
    L_0x0074:
        r0 = r28;
        r2 = r0.c;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3 = r2.i;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r2 = r2.i;	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r4 = 4;
        r0 = r28;
        r2 = r2.obtainMessage(r4, r0);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        r3.sendMessage(r2);	 Catch:{ x -> 0x0087, ah -> 0x00a9, IOException -> 0x00c1, OutOfMemoryError -> 0x00d9, Exception -> 0x0214 }
        goto L_0x0062;
    L_0x0087:
        r2 = move-exception;
        r3 = r2.a;	 Catch:{ all -> 0x022d }
        if (r3 == 0) goto L_0x0092;
    L_0x008c:
        r3 = r2.b;	 Catch:{ all -> 0x022d }
        r4 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r3 == r4) goto L_0x0096;
    L_0x0092:
        r0 = r28;
        r0.p = r2;	 Catch:{ all -> 0x022d }
    L_0x0096:
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2.b(r0);	 Catch:{ all -> 0x022d }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x006b;
    L_0x00a9:
        r2 = move-exception;
        r0 = r28;
        r0.p = r2;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2.a(r0);	 Catch:{ all -> 0x022d }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x006b;
    L_0x00c1:
        r2 = move-exception;
        r0 = r28;
        r0.p = r2;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2.a(r0);	 Catch:{ all -> 0x022d }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x006b;
    L_0x00d9:
        r2 = move-exception;
        r27 = new java.io.StringWriter;	 Catch:{ all -> 0x022d }
        r27.<init>();	 Catch:{ all -> 0x022d }
        r0 = r28;
        r0 = r0.e;	 Catch:{ all -> 0x022d }
        r24 = r0;
        r3 = new com.c.b.bf;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r4 = r0.b;	 Catch:{ all -> 0x022d }
        r4 = r4.b();	 Catch:{ all -> 0x022d }
        r0 = r24;
        r5 = r0.b;	 Catch:{ all -> 0x022d }
        r5 = r5.a();	 Catch:{ all -> 0x022d }
        r0 = r24;
        r6 = r0.d;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r8 = r0.e;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r10 = r0.f;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r12 = r0.g;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r14 = r0.h;	 Catch:{ all -> 0x022d }
        r0 = r24;
        r0 = r0.i;	 Catch:{ all -> 0x022d }
        r16 = r0;
        r0 = r24;
        r0 = r0.j;	 Catch:{ all -> 0x022d }
        r18 = r0;
        r0 = r24;
        r0 = r0.k;	 Catch:{ all -> 0x022d }
        r20 = r0;
        r0 = r24;
        r0 = r0.l;	 Catch:{ all -> 0x022d }
        r22 = r0;
        r0 = r24;
        r0 = r0.m;	 Catch:{ all -> 0x022d }
        r23 = r0;
        r0 = r24;
        r0 = r0.n;	 Catch:{ all -> 0x022d }
        r24 = r0;
        r25 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x022d }
        r3.<init>(r4, r5, r6, r8, r10, r12, r14, r16, r18, r20, r22, r23, r24, r25);	 Catch:{ all -> 0x022d }
        r4 = new java.io.PrintWriter;	 Catch:{ all -> 0x022d }
        r0 = r27;
        r4.<init>(r0);	 Catch:{ all -> 0x022d }
        r5 = "===============BEGIN PICASSO STATS ===============";
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "Memory Cache Stats";
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Max Cache Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.a;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Cache Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.b;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Cache % Full: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.b;	 Catch:{ all -> 0x022d }
        r5 = (float) r5;	 Catch:{ all -> 0x022d }
        r6 = r3.a;	 Catch:{ all -> 0x022d }
        r6 = (float) r6;	 Catch:{ all -> 0x022d }
        r5 = r5 / r6;
        r6 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r5 = r5 * r6;
        r6 = (double) r5;	 Catch:{ all -> 0x022d }
        r6 = java.lang.Math.ceil(r6);	 Catch:{ all -> 0x022d }
        r5 = (int) r6;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Cache Hits: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.c;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "  Cache Misses: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.d;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "Network Stats";
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Download Count: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.k;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Total Download Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.e;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "  Average Download Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.h;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "Bitmap Stats";
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Total Bitmaps Decoded: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.l;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Total Bitmap Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.f;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "  Total Transformed Bitmaps: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r5 = r3.m;	 Catch:{ all -> 0x022d }
        r4.println(r5);	 Catch:{ all -> 0x022d }
        r5 = "  Total Transformed Bitmap Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.g;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "  Average Bitmap Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.i;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r5 = "  Average Transformed Bitmap Size: ";
        r4.print(r5);	 Catch:{ all -> 0x022d }
        r6 = r3.j;	 Catch:{ all -> 0x022d }
        r4.println(r6);	 Catch:{ all -> 0x022d }
        r3 = "===============END PICASSO STATS ===============";
        r4.println(r3);	 Catch:{ all -> 0x022d }
        r4.flush();	 Catch:{ all -> 0x022d }
        r3 = new java.lang.RuntimeException;	 Catch:{ all -> 0x022d }
        r4 = r27.toString();	 Catch:{ all -> 0x022d }
        r3.<init>(r4, r2);	 Catch:{ all -> 0x022d }
        r0 = r28;
        r0.p = r3;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2.b(r0);	 Catch:{ all -> 0x022d }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x006b;
    L_0x0214:
        r2 = move-exception;
        r0 = r28;
        r0.p = r2;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x022d }
        r0 = r28;
        r2.b(r0);	 Catch:{ all -> 0x022d }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x006b;
    L_0x022d:
        r2 = move-exception;
        r3 = java.lang.Thread.currentThread();
        r4 = "Picasso-Idle";
        r3.setName(r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.d.run():void");
    }
}
