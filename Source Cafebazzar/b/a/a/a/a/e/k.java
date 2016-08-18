package b.a.a.a.a.e;

import java.io.IOException;
import java.util.concurrent.Callable;

public abstract class k implements Callable {
    protected k() {
    }

    protected abstract Object a();

    protected abstract void b();

    public Object call() {
        Throwable th;
        Object obj = 1;
        try {
            Object a = a();
            try {
                b();
                return a;
            } catch (IOException e) {
                throw new j(e);
            }
        } catch (j e2) {
            throw e2;
        } catch (IOException e3) {
            throw new j(e3);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            b();
        } catch (IOException e4) {
            if (obj == null) {
                throw new j(e4);
            }
        }
        throw th;
    }
}
