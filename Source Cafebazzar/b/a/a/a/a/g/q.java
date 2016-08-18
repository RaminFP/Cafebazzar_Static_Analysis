package b.a.a.a.a.g;

import android.content.Context;
import android.os.Build.VERSION;
import b.a.a.a.a.b.ah;
import b.a.a.a.a.b.j;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.r;
import b.a.a.a.a.b.x;
import b.a.a.a.a.e.m;
import b.a.a.a.f;
import b.a.a.a.p;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class q {
    private final AtomicReference a;
    private final CountDownLatch b;
    private u c;
    private boolean d;

    private q() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    private void a(v vVar) {
        this.a.set(vVar);
        this.b.countDown();
    }

    public final q a(p pVar, x xVar, m mVar, String str, String str2, String str3) {
        synchronized (this) {
            if (!this.d) {
                if (this.c == null) {
                    Context context = pVar.p;
                    String str4 = xVar.d;
                    String a = new j().a(context);
                    String d = xVar.d();
                    ah ahVar = new ah();
                    k kVar = new k();
                    i iVar = new i(pVar);
                    String i = l.i(context);
                    p pVar2 = pVar;
                    String str5 = str3;
                    l lVar = new l(pVar2, str5, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{str4}), mVar);
                    this.c = new j(pVar, new y(a, xVar.b(), x.a(VERSION.INCREMENTAL), x.a(VERSION.RELEASE), xVar.f(), xVar.a(), xVar.g(), l.a(l.k(context)), str2, str, r.a(d).e, i), ahVar, kVar, iVar, lVar);
                }
                this.d = true;
            }
        }
        return this;
    }

    public final v a() {
        try {
            this.b.await();
            return (v) this.a.get();
        } catch (InterruptedException e) {
            f.a().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public final Object a(s sVar, Object obj) {
        v vVar = (v) this.a.get();
        return vVar == null ? obj : sVar.a(vVar);
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            v a = this.c.a();
            a(a);
            z = a != null;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            v a = this.c.a(t.SKIP_CACHE_LOOKUP);
            a(a);
            if (a == null) {
                f.a().c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            z = a != null;
        }
        return z;
    }
}
