package d;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class ad {
    public static final ad b = new ae();
    private boolean a;
    private long c;
    private long d;

    public ad a(long j) {
        this.a = true;
        this.c = j;
        return this;
    }

    public ad a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long c() {
        if (this.a) {
            return this.c;
        }
        throw new IllegalStateException("No deadline");
    }

    public ad d() {
        this.d = 0;
        return this;
    }

    public void f() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.a && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long m_() {
        return this.d;
    }

    public boolean n_() {
        return this.a;
    }

    public ad o_() {
        this.a = false;
        return this;
    }
}
