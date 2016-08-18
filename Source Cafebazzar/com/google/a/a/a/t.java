package com.google.a.a.a;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public final class t implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler a;
    private final bg b;
    private final bc c;
    private s d;

    public t(bg bgVar, bc bcVar, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (bgVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (bcVar == null) {
            throw new NullPointerException("serviceManager cannot be null");
        } else {
            this.a = uncaughtExceptionHandler;
            this.b = bgVar;
            this.c = bcVar;
            this.d = new bf(context, new ArrayList());
            as.c("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String str = null;
        String str2 = "UncaughtException";
        if (this.d != null) {
            str2 = this.d.a(thread != null ? thread.getName() : null, th);
        }
        as.c("Tracking Exception: " + str2);
        bg bgVar = this.b;
        Boolean valueOf = Boolean.valueOf(true);
        an.a().a(ao.CONSTRUCT_EXCEPTION);
        av avVar = new av();
        avVar.a("&t", "exception");
        avVar.a("&exd", str2);
        if (valueOf != null) {
            str = valueOf.booleanValue() ? "1" : "0";
        }
        avVar.a("&exf", str);
        bgVar.a(avVar.a());
        this.c.c();
        if (this.a != null) {
            as.c("Passing exception to original handler.");
            this.a.uncaughtException(thread, th);
        }
    }
}
