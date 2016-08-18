package d;

final class d extends Thread {
    public d() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    public final void run() {
        while (true) {
            try {
                a e = a.g();
                if (e != null) {
                    e.a();
                }
            } catch (InterruptedException e2) {
            }
        }
    }
}
