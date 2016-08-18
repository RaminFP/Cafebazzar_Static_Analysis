package com.android.a.a;

import com.android.a.o;
import com.android.a.t;
import com.android.a.y;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class j implements t, Future {
    private o a;
    private boolean b = false;
    private Object c;
    private y d;

    private j() {
    }

    public static j a() {
        return new j();
    }

    private Object a(Long l) {
        Object obj;
        synchronized (this) {
            if (this.d != null) {
                throw new ExecutionException(this.d);
            }
            if (this.b) {
                obj = this.c;
            } else {
                if (l == null) {
                    wait(0);
                } else if (l.longValue() > 0) {
                    wait(l.longValue());
                }
                if (this.d != null) {
                    throw new ExecutionException(this.d);
                } else if (this.b) {
                    obj = this.c;
                } else {
                    throw new TimeoutException();
                }
            }
        }
        return obj;
    }

    public final void a(y yVar) {
        synchronized (this) {
            this.d = yVar;
            notifyAll();
        }
    }

    public final void a(Object obj) {
        synchronized (this) {
            this.b = true;
            this.c = obj;
            notifyAll();
        }
    }

    public final boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (this.a != null) {
                if (!isDone()) {
                    this.a.h = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public final Object get() {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public final boolean isCancelled() {
        return this.a == null ? false : this.a.h;
    }

    public final boolean isDone() {
        boolean z;
        synchronized (this) {
            z = this.b || this.d != null || isCancelled();
        }
        return z;
    }
}
