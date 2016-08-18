package b.a.a.a.a.a;

import android.content.Context;

public abstract class a implements c {
    private final c a;

    public a(c cVar) {
        this.a = cVar;
    }

    protected abstract Object a();

    public final Object a(Context context, d dVar) {
        Object a;
        synchronized (this) {
            a = a();
            if (a == null) {
                a = this.a != null ? this.a.a(context, dVar) : dVar.a(context);
                if (a == null) {
                    throw new NullPointerException();
                }
                a(a);
            }
        }
        return a;
    }

    protected abstract void a(Object obj);
}
