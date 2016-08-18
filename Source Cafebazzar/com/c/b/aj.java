package com.c.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class aj {
    static final Handler a = new ak(Looper.getMainLooper());
    static volatile aj b = null;
    final ar c;
    final List d;
    final Context e;
    final q f;
    final k g;
    final bc h;
    final Map i;
    final Map j;
    final ReferenceQueue k;
    final Config l;
    boolean m;
    volatile boolean n;
    boolean o;
    private final ao p;
    private final am q;

    aj(Context context, q qVar, k kVar, ao aoVar, ar arVar, List list, bc bcVar, Config config, boolean z, boolean z2) {
        this.e = context;
        this.f = qVar;
        this.g = kVar;
        this.p = aoVar;
        this.c = arVar;
        this.l = config;
        List arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new bb(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new n(context));
        arrayList.add(new ac(context));
        arrayList.add(new o(context));
        arrayList.add(new c(context));
        arrayList.add(new y(context));
        arrayList.add(new ag(qVar.d, bcVar));
        this.d = Collections.unmodifiableList(arrayList);
        this.h = bcVar;
        this.i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        this.k = new ReferenceQueue();
        this.q = new am(this.k, a);
        this.q.start();
    }

    public static aj a(Context context) {
        if (b == null) {
            synchronized (aj.class) {
                try {
                    if (b == null) {
                        al alVar = new al(context);
                        Context context2 = alVar.a;
                        if (alVar.b == null) {
                            alVar.b = bj.a(context2);
                        }
                        if (alVar.d == null) {
                            alVar.d = new aa(context2);
                        }
                        if (alVar.c == null) {
                            alVar.c = new au();
                        }
                        if (alVar.f == null) {
                            alVar.f = ar.a;
                        }
                        bc bcVar = new bc(alVar.d);
                        q qVar = new q(context2, alVar.c, a, alVar.b, alVar.d, bcVar);
                        b = new aj(context2, qVar, alVar.d, alVar.e, alVar.f, alVar.g, bcVar, alVar.h, alVar.i, alVar.j);
                    }
                } catch (Throwable th) {
                    while (true) {
                        Class cls = aj.class;
                    }
                }
            }
        }
        return b;
    }

    final Bitmap a(String str) {
        Bitmap a = this.g.a(str);
        if (a != null) {
            this.h.a();
        } else {
            this.h.c.sendEmptyMessage(1);
        }
        return a;
    }

    void a(Bitmap bitmap, ap apVar, a aVar) {
        if (!aVar.l) {
            if (!aVar.k) {
                this.i.remove(aVar.c());
            }
            if (bitmap == null) {
                aVar.a();
                if (this.n) {
                    bj.a("Main", "errored", aVar.b.a());
                }
            } else if (apVar == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                aVar.a(bitmap, apVar);
                if (this.n) {
                    bj.a("Main", "completed", aVar.b.a(), "from " + apVar);
                }
            }
        }
    }

    final void a(a aVar) {
        Object c = aVar.c();
        if (!(c == null || this.i.get(c) == aVar)) {
            a(c);
            this.i.put(c, aVar);
        }
        q qVar = this.f;
        qVar.i.sendMessage(qVar.i.obtainMessage(1, aVar));
    }

    void a(Object obj) {
        bj.a();
        a aVar = (a) this.i.remove(obj);
        if (aVar != null) {
            aVar.b();
            q qVar = this.f;
            qVar.i.sendMessage(qVar.i.obtainMessage(2, aVar));
        }
        if (obj instanceof ImageView) {
            p pVar = (p) this.j.remove((ImageView) obj);
            if (pVar != null) {
                pVar.c = null;
                ImageView imageView = (ImageView) pVar.b.get();
                if (imageView != null) {
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(pVar);
                    }
                }
            }
        }
    }
}
