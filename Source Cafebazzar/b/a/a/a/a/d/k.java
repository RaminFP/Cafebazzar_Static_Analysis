package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.b.l;

public final class k implements Runnable {
    private final Context a;
    private final g b;

    public k(Context context, g gVar) {
        this.a = context;
        this.b = gVar;
    }

    public final void run() {
        try {
            l.a(this.a, "Performing time based file roll over.");
            if (!this.b.c()) {
                this.b.d();
            }
        } catch (Exception e) {
            l.b(this.a, "Failed to roll over file");
        }
    }
}
