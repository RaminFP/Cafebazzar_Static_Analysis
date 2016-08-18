package com.b.b;

import java.lang.Thread.UncaughtExceptionHandler;

final class au implements UncaughtExceptionHandler {
    final /* synthetic */ at a;

    private au(at atVar) {
        this.a = atVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        for (UncaughtExceptionHandler uncaughtException : this.a.b()) {
            try {
                uncaughtException.uncaughtException(thread, th);
            } catch (Throwable th2) {
            }
        }
        at atVar = this.a;
        if (atVar.a != null) {
            atVar.a.uncaughtException(thread, th);
        }
    }
}
