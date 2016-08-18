package b.a.a.a.a.c;

final class i implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ h b;

    i(h hVar, Runnable runnable) {
        this.b = hVar;
        this.a = runnable;
    }

    public final void run() {
        try {
            this.a.run();
        } finally {
            this.b.a();
        }
    }
}
