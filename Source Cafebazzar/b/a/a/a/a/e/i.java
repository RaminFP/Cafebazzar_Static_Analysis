package b.a.a.a.a.e;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

final class i implements h {
    i() {
    }

    public final HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public final HttpURLConnection a(URL url, Proxy proxy) {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
