package b.a.a.a;

import b.a.a.a.a.b.ai;
import b.a.a.a.a.c.p;
import b.a.a.a.a.c.z;

public final class o extends p {
    final p a;

    public o(p pVar) {
        this.a = pVar;
    }

    private ai a(String str) {
        ai aiVar = new ai(this.a.b() + "." + str, "KitInitialization");
        aiVar.a();
        return aiVar;
    }

    public final int a() {
        return b.a.a.a.a.c.o.c;
    }

    protected final /* synthetic */ Object a(Object[] objArr) {
        ai a = a("doInBackground");
        Object obj = null;
        if (!this.e.get()) {
            obj = this.a.e();
        }
        a.b();
        return obj;
    }

    protected final void a(Object obj) {
        this.a.q.a();
    }

    protected final void b() {
        super.b();
        ai a = a("onPreExecute");
        try {
            boolean a_ = this.a.a_();
            a.b();
            if (!a_) {
                a(true);
            }
        } catch (z e) {
            throw e;
        } catch (Throwable e2) {
            f.a().c("Fabric", "Failure onPreExecute()", e2);
            a.b();
            a(true);
        } catch (Throwable th) {
            a.b();
            a(true);
        }
    }

    protected final void b(Object obj) {
        this.a.q.a(new n(this.a.b() + " Initialization was cancelled"));
    }
}
