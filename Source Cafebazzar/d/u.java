package d;

import java.net.Socket;
import java.util.logging.Level;

final class u extends a {
    final /* synthetic */ Socket a;

    u(Socket socket) {
        this.a = socket;
    }

    protected final void a() {
        try {
            this.a.close();
        } catch (Throwable e) {
            r.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, e);
        }
    }
}
