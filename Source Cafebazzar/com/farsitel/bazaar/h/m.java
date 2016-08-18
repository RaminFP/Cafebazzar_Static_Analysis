package com.farsitel.bazaar.h;

import com.congenialmobile.util.g;
import com.farsitel.bazaar.BazaarApplication;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class m implements X509TrustManager {
    private X509TrustManager a;
    private X509TrustManager b;

    public m() {
        TrustManager trustManager;
        int i = 0;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(null);
        for (TrustManager trustManager2 : instance.getTrustManagers()) {
            if (trustManager2 instanceof X509TrustManager) {
                this.a = (X509TrustManager) trustManager2;
                break;
            }
        }
        KeyStore a = g.a(BazaarApplication.c());
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init(a);
        TrustManager[] trustManagers = instance2.getTrustManagers();
        int length = trustManagers.length;
        while (i < length) {
            trustManager2 = trustManagers[i];
            if (trustManager2 instanceof X509TrustManager) {
                this.b = (X509TrustManager) trustManager2;
                return;
            }
            i++;
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.a != null) {
            try {
                this.a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                if (this.b != null) {
                    this.b.checkClientTrusted(x509CertificateArr, str);
                    return;
                }
                throw e;
            }
        }
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.a != null) {
            try {
                this.a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                if (this.b != null) {
                    this.b.checkServerTrusted(x509CertificateArr, str);
                    return;
                }
                throw e;
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        try {
            Object acceptedIssuers = this.a.getAcceptedIssuers();
            Object acceptedIssuers2 = this.a.getAcceptedIssuers();
            Object obj = new X509Certificate[(acceptedIssuers.length + acceptedIssuers2.length)];
            System.arraycopy(acceptedIssuers, 0, obj, 0, acceptedIssuers.length);
            System.arraycopy(acceptedIssuers2, 0, obj, acceptedIssuers.length, acceptedIssuers2.length);
            return obj;
        } catch (Throwable th) {
            return new X509Certificate[0];
        }
    }
}
