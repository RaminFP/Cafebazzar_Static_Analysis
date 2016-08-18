package com.android.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public abstract class o implements Comparable {
    public final int a;
    public final String b;
    final int c;
    final t d;
    Integer e;
    r f;
    boolean g;
    public boolean h;
    boolean i;
    public v j;
    public c k;
    public Object l;
    private final aa m;
    private long n;

    public o(int i, String str, t tVar) {
        this.m = aa.a ? new aa() : null;
        this.g = true;
        this.h = false;
        this.i = false;
        this.n = 0;
        this.k = null;
        this.a = 1;
        this.b = str;
        this.d = tVar;
        this.j = new f();
        this.c = TextUtils.isEmpty(str) ? 0 : Uri.parse(str).getHost().hashCode();
    }

    protected static y a(y yVar) {
        return yVar;
    }

    public static Map a() {
        return Collections.emptyMap();
    }

    private static byte[] a(Map map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public abstract s a(m mVar);

    public abstract void a(Object obj);

    public final void a(String str) {
        if (aa.a) {
            this.m.a(str, Thread.currentThread().getId());
        } else if (this.n == 0) {
            this.n = SystemClock.elapsedRealtime();
        }
    }

    public final String b() {
        return d();
    }

    final void b(String str) {
        if (this.f != null) {
            r rVar = this.f;
            synchronized (rVar.b) {
                rVar.b.remove(this);
            }
            if (this.g) {
                synchronized (rVar.a) {
                    Queue queue = (Queue) rVar.a.remove(this.b);
                    if (queue != null) {
                        if (z.b) {
                            z.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r3);
                        }
                        rVar.c.addAll(queue);
                    }
                }
            }
        }
        if (aa.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new p(this, str, id));
                return;
            }
            this.m.a(str, id);
            this.m.a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.n >= 3000) {
            z.b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.n), toString());
        }
    }

    public final byte[] c() {
        return null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        o oVar = (o) obj;
        q qVar = q.NORMAL;
        q qVar2 = q.NORMAL;
        return qVar == qVar2 ? this.e.intValue() - oVar.e.intValue() : qVar2.ordinal() - qVar.ordinal();
    }

    public final String d() {
        return "application/x-www-form-urlencoded; charset=" + "UTF-8";
    }

    public byte[] e() {
        return null;
    }

    public final int f() {
        return this.j.a();
    }

    public String toString() {
        return (this.h ? "[X] " : "[ ] ") + this.b + " " + ("0x" + Integer.toHexString(this.c)) + " " + q.NORMAL + " " + this.e;
    }
}
