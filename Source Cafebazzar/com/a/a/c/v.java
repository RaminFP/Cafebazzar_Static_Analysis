package com.a.a.c;

import android.os.Looper;
import b.a.a.a.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

final class v {
    private final ExecutorService a;

    public v(ExecutorService executorService) {
        this.a = executorService;
    }

    final Object a(Callable callable) {
        try {
            return Looper.getMainLooper() == Looper.myLooper() ? this.a.submit(callable).get(4, TimeUnit.SECONDS) : this.a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            f.a().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            f.a().c("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    final Future a(Runnable runnable) {
        try {
            return this.a.submit(new w(this, runnable));
        } catch (RejectedExecutionException e) {
            f.a().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    final Future b(Callable callable) {
        try {
            return this.a.submit(new x(this, callable));
        } catch (RejectedExecutionException e) {
            f.a().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
