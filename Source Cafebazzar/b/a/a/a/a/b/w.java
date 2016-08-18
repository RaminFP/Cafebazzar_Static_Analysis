package b.a.a.a.a.b;

import b.a.a.a.f;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class w extends k {
    final /* synthetic */ String a;
    final /* synthetic */ ExecutorService b;
    final /* synthetic */ long c;
    final /* synthetic */ TimeUnit d;

    w(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.a = str;
        this.b = executorService;
        this.c = j;
        this.d = timeUnit;
    }

    public final void a() {
        try {
            f.a().a("Fabric", "Executing shutdown hook for " + this.a);
            this.b.shutdown();
            if (!this.b.awaitTermination(this.c, this.d)) {
                f.a().a("Fabric", this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.b.shutdownNow();
            }
        } catch (InterruptedException e) {
            f.a().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.a}));
            this.b.shutdownNow();
        }
    }
}
