package d;

import java.io.IOException;
import java.io.InterruptedIOException;

public class a extends ad {
    private static a a;
    private boolean c;
    private a d;
    private long e;

    private static void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            try {
                if (a == null) {
                    a = new a();
                    new d().start();
                }
                long nanoTime = System.nanoTime();
                if (j != 0 && z) {
                    aVar.e = Math.min(j, aVar.c() - nanoTime) + nanoTime;
                } else if (j != 0) {
                    aVar.e = nanoTime + j;
                } else if (z) {
                    aVar.e = aVar.c();
                } else {
                    throw new AssertionError();
                }
                long j2 = aVar.e;
                a aVar2 = a;
                while (aVar2.d != null && j2 - nanoTime >= aVar2.d.e - nanoTime) {
                    aVar2 = aVar2.d;
                }
                aVar.d = aVar2.d;
                aVar2.d = aVar;
                if (aVar2 == a) {
                    aVar2.notify();
                }
            } finally {
                Class cls = a.class;
            }
        }
    }

    private static boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            try {
                for (a aVar2 = a; aVar2 != null; aVar2 = aVar2.d) {
                    if (aVar2.d == aVar) {
                        aVar2.d = aVar.d;
                        aVar.d = null;
                        z = false;
                        break;
                    }
                }
                z = true;
            } catch (Throwable th) {
                Class cls = a.class;
            }
        }
        return z;
    }

    private static a g() {
        a aVar = null;
        synchronized (a.class) {
            Object obj;
            try {
                obj = a.d;
                if (obj == null) {
                    obj.wait();
                } else {
                    long nanoTime = obj.e - System.nanoTime();
                    if (nanoTime > 0) {
                        long j = nanoTime / 1000000;
                        a.class.wait(j, (int) (nanoTime - (1000000 * j)));
                    } else {
                        a.d = obj.d;
                        obj.d = null;
                        aVar = obj;
                    }
                }
            } finally {
                obj = a.class;
            }
        }
        return aVar;
    }

    final IOException a(IOException iOException) {
        if (!l_()) {
            return iOException;
        }
        IOException interruptedIOException = new InterruptedIOException("timeout");
        interruptedIOException.initCause(iOException);
        return interruptedIOException;
    }

    public void a() {
    }

    final void a(boolean z) {
        if (l_() && z) {
            throw new InterruptedIOException("timeout");
        }
    }

    public final void k_() {
        if (this.c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long m_ = m_();
        boolean n_ = n_();
        if (m_ != 0 || n_) {
            this.c = true;
            a(this, m_, n_);
        }
    }

    public final boolean l_() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return a(this);
    }
}
