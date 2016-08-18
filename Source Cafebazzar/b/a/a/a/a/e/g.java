package b.a.a.a.a.e;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class g extends k {
    private final Closeable a;
    private final boolean b;

    protected g(Closeable closeable, boolean z) {
        this.a = closeable;
        this.b = z;
    }

    protected final void b() {
        if (this.a instanceof Flushable) {
            ((Flushable) this.a).flush();
        }
        if (this.b) {
            try {
                this.a.close();
                return;
            } catch (IOException e) {
                return;
            }
        }
        this.a.close();
    }
}
