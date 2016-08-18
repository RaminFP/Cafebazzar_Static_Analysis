package b.a.a.a;

import android.content.Context;
import b.a.a.a.a.b.x;
import b.a.a.a.a.c.n;
import java.io.File;

public abstract class p implements Comparable {
    public f n;
    public o o = new o(this);
    public Context p;
    l q;
    public x r;

    private boolean a(p pVar) {
        n nVar = (n) getClass().getAnnotation(n.class);
        if (nVar != null) {
            for (Object equals : nVar.a()) {
                if (equals.equals(pVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean c() {
        return ((n) getClass().getAnnotation(n.class)) != null;
    }

    public abstract String a();

    final void a(Context context, f fVar, l lVar, x xVar) {
        this.n = fVar;
        this.p = new j(context, b(), n());
        this.q = lVar;
        this.r = xVar;
    }

    public boolean a_() {
        return true;
    }

    public abstract String b();

    public /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (!a(pVar)) {
            if (pVar.a(this)) {
                return -1;
            }
            if (!c() || pVar.c()) {
                return (c() || !pVar.c()) ? 0 : -1;
            }
        }
        return 1;
    }

    public abstract Object e();

    final void m() {
        this.o.a(this.n.c, null);
    }

    public final String n() {
        return ".Fabric" + File.separator + b();
    }
}
