package com.b.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class m implements bg {
    protected static String d;
    Set e = new HashSet();
    protected ExecutorService f;
    protected ExecutorService g;
    v h;
    protected String i = "defaultDataKey_";

    public m(String str, String str2) {
        d = str2;
        bh.a().a((bg) this);
        this.f = Executors.newSingleThreadExecutor(new bi("FlurryAgent", 1));
        this.g = Executors.newCachedThreadPool(new bi("FlurryAgent", 1));
        this.f.submit(new n(this, str));
    }

    protected static void b() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
    }

    private boolean d() {
        return this.e.size() <= 8;
    }

    protected final void a() {
        a(null);
    }

    protected final void a(s sVar) {
        this.f.submit(new p(this, sVar));
    }

    protected final void a(String str) {
        this.f.submit(new r(this, str));
    }

    protected void a(String str, String str2, int i) {
        this.f.submit(new q(this, str, str2));
    }

    public final void a(boolean z) {
        ba.a(4, d, "onNetworkStateChanged : isNetworkEnable = " + z);
        if (z) {
            a(null);
        }
    }

    protected abstract void a(byte[] bArr, String str, String str2);

    public final void b(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            ba.a(6, d, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        this.f.submit(new o(this, bArr, str, str2));
        a(null);
    }

    protected final String c(byte[] bArr, String str, String str2) {
        String str3 = this.i + str + "_" + str2;
        t tVar = new t();
        tVar.a(bArr);
        String str4 = tVar.b;
        this.h.a(tVar, str3);
        return str4;
    }

    protected final void c() {
        bh a = bh.a();
        if (a.b != null ? a.b.booleanValue() : a.a) {
            List<String> arrayList = new ArrayList(this.h.c.keySet());
            if (arrayList.isEmpty()) {
                ba.a(4, d, "No more reports to send.");
                return;
            }
            for (String str : arrayList) {
                if (d()) {
                    List a2 = this.h.a(str);
                    ba.a(4, d, "Number of not sent blocks = " + a2.size());
                    for (int i = 0; i < a2.size(); i++) {
                        String str2 = (String) a2.get(i);
                        if (!this.e.contains(str2)) {
                            if (!d()) {
                                break;
                            }
                            byte[] a3 = new t(str2).a();
                            if (a3 == null || a3.length == 0) {
                                ba.a(6, d, "Internal ERROR! Report is empty!");
                                this.h.a(str2, str);
                            } else {
                                this.e.add(str2);
                                a(a3, str2, str);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            return;
        }
        ba.a(5, d, "Reports were not sent! No Internet connection!");
    }
}
