package com.c.a;

import com.c.a.a.q;
import com.c.a.a.v;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class s {
    private static final s a;
    private final int b;
    private final long c;
    private final LinkedList d = new LinkedList();
    private Executor e = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), v.a("OkHttp ConnectionPool", true));
    private final Runnable f = new t(this);

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            a = new s(0, parseLong);
        } else if (property3 != null) {
            a = new s(Integer.parseInt(property3), parseLong);
        } else {
            a = new s(5, parseLong);
        }
    }

    private s(int i, long j) {
        this.b = i;
        this.c = (j * 1000) * 1000;
    }

    public static s a() {
        return a;
    }

    static /* synthetic */ void a(s sVar) {
        do {
        } while (sVar.b());
    }

    private boolean b() {
        int i;
        synchronized (this) {
            List arrayList;
            int i2;
            if (this.d.isEmpty()) {
                return false;
            }
            arrayList = new ArrayList();
            int i3 = 0;
            long nanoTime = System.nanoTime();
            long j = this.c;
            ListIterator listIterator = this.d.listIterator(this.d.size());
            while (listIterator.hasPrevious()) {
                long min;
                r rVar = (r) listIterator.previous();
                long d = (rVar.d() + this.c) - nanoTime;
                if (d <= 0 || !rVar.b()) {
                    listIterator.remove();
                    arrayList.add(rVar);
                } else {
                    if (rVar.c()) {
                        min = Math.min(j, d);
                        i = i3 + 1;
                    } else {
                        min = j;
                        i = i3;
                    }
                    i3 = i;
                    j = min;
                }
            }
            ListIterator listIterator2 = this.d.listIterator(this.d.size());
            i2 = i3;
            while (listIterator2.hasPrevious() && i2 > this.b) {
                int i4;
                rVar = (r) listIterator2.previous();
                if (rVar.c()) {
                    arrayList.add(rVar);
                    listIterator2.remove();
                    i4 = i2 - 1;
                } else {
                    i4 = i2;
                }
                i2 = i4;
            }
            if (arrayList.isEmpty()) {
                try {
                    min = j / 1000000;
                    wait(min, (int) (j - (1000000 * min)));
                    return true;
                } catch (InterruptedException e) {
                    i = arrayList.size();
                    for (i2 = 0; i2 < i; i2++) {
                        v.a(((r) arrayList.get(i2)).c);
                    }
                    return true;
                }
            }
        }
    }

    public final r a(a aVar) {
        r rVar;
        synchronized (this) {
            ListIterator listIterator = this.d.listIterator(this.d.size());
            while (listIterator.hasPrevious()) {
                rVar = (r) listIterator.previous();
                if (rVar.b.a.equals(aVar) && rVar.b() && System.nanoTime() - rVar.d() < this.c) {
                    listIterator.remove();
                    if (rVar.e()) {
                        break;
                    }
                    try {
                        q.a().a(rVar.c);
                        break;
                    } catch (SocketException e) {
                        v.a(rVar.c);
                        q.a();
                        q.a("Unable to tagSocket(): " + e);
                    }
                }
            }
            rVar = null;
            if (rVar != null) {
                if (rVar.e()) {
                    this.d.addFirst(rVar);
                }
            }
        }
        return rVar;
    }

    void a(r rVar) {
        boolean isEmpty = this.d.isEmpty();
        this.d.addFirst(rVar);
        if (isEmpty) {
            this.e.execute(this.f);
        } else {
            notifyAll();
        }
    }
}
