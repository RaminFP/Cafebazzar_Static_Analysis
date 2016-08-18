package b.a.a.a.a.e;

import b.a.a.a.e;
import b.a.a.a.s;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class b implements m {
    private final s a;
    private n b;
    private SSLSocketFactory c;
    private boolean d;

    public b() {
        this(new e());
    }

    public b(s sVar) {
        this.a = sVar;
    }

    private void a() {
        synchronized (this) {
            this.d = false;
            this.c = null;
        }
    }

    private SSLSocketFactory b() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (this) {
            if (this.c == null && !this.d) {
                this.c = c();
            }
            sSLSocketFactory = this.c;
        }
        return sSLSocketFactory;
    }

    private SSLSocketFactory c() {
        SSLSocketFactory socketFactory;
        synchronized (this) {
            this.d = true;
            try {
                n nVar = this.b;
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{new o(new p(nVar.a(), nVar.b()), nVar)}, null);
                socketFactory = instance.getSocketFactory();
                this.a.a("Fabric", "Custom SSL pinning enabled");
            } catch (Throwable e) {
                this.a.c("Fabric", "Exception while validating pinned certs", e);
                socketFactory = null;
            }
        }
        return socketFactory;
    }

    public final e a(int i, String str, Map map) {
        e a;
        boolean z = true;
        switch (c.a[i - 1]) {
            case 1:
                a = e.a((CharSequence) str, map, true);
                break;
            case 2:
                a = e.b((CharSequence) str, map, true);
                break;
            case 3:
                a = e.a((CharSequence) str);
                break;
            case 4:
                a = e.b((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (str == null || !str.toLowerCase(Locale.US).startsWith("https")) {
            z = false;
        }
        if (z && this.b != null) {
            SSLSocketFactory b = b();
            if (b != null) {
                ((HttpsURLConnection) a.a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    public final void a(n nVar) {
        if (this.b != nVar) {
            this.b = nVar;
            a();
        }
    }
}
