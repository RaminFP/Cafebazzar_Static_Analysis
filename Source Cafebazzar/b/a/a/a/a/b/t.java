package b.a.a.a.a.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class t {
    public static final ThreadFactory a(String str) {
        return new u(str, new AtomicLong(1));
    }

    public static final void a(String str, ExecutorService executorService) {
        Runtime.getRuntime().addShutdownHook(new Thread(new w(str, executorService, 2, TimeUnit.SECONDS), "Crashlytics Shutdown Hook for " + str));
    }
}
