package com.android.a;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class r {
    final Map a;
    final Set b;
    final PriorityBlockingQueue c;
    private AtomicInteger d;
    private final PriorityBlockingQueue e;
    private final b f;
    private final j g;
    private final u h;
    private k[] i;
    private d j;

    public r(b bVar, j jVar) {
        this(bVar, jVar, 4);
    }

    private r(b bVar, j jVar, int i) {
        this(bVar, jVar, 4, new g(new Handler(Looper.getMainLooper())));
    }

    private r(b bVar, j jVar, int i, u uVar) {
        this.d = new AtomicInteger();
        this.a = new HashMap();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.e = new PriorityBlockingQueue();
        this.f = bVar;
        this.g = jVar;
        this.i = new k[i];
        this.h = uVar;
    }

    public final o a(o oVar) {
        oVar.f = this;
        synchronized (this.b) {
            this.b.add(oVar);
        }
        oVar.e = Integer.valueOf(this.d.incrementAndGet());
        oVar.a("add-to-queue");
        if (oVar.g) {
            synchronized (this.a) {
                String str = oVar.b;
                if (this.a.containsKey(str)) {
                    Queue queue = (Queue) this.a.get(str);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(oVar);
                    this.a.put(str, queue);
                    if (z.b) {
                        z.a("Request for cacheKey=%s is in flight, putting on hold.", str);
                    }
                } else {
                    this.a.put(str, null);
                    this.c.add(oVar);
                }
            }
        } else {
            this.e.add(oVar);
        }
        return oVar;
    }

    public final void a() {
        int i = 0;
        if (this.j != null) {
            d dVar = this.j;
            dVar.a = true;
            dVar.interrupt();
        }
        for (int i2 = 0; i2 < this.i.length; i2++) {
            if (this.i[i2] != null) {
                k kVar = this.i[i2];
                kVar.a = true;
                kVar.interrupt();
            }
        }
        this.j = new d(this.c, this.e, this.f, this.h);
        this.j.start();
        while (i < this.i.length) {
            k kVar2 = new k(this.e, this.g, this.f, this.h);
            this.i[i] = kVar2;
            kVar2.start();
            i++;
        }
    }
}
