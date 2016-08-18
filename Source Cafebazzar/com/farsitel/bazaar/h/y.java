package com.farsitel.bazaar.h;

import com.android.a.a.g;
import com.c.a.ag;
import com.c.a.ai;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public final class y extends g {
    private final ai a;

    public y() {
        this(new ag());
    }

    private y(ag agVar) {
        try {
            m mVar = new m();
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{mVar}, null);
            agVar.l = instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        this.a = new ai(agVar);
    }

    protected final HttpURLConnection a(URL url) {
        return this.a.a(url);
    }
}
