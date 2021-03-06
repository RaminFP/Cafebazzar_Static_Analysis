package b.a.a.a.a.e;

import b.a.a.a.f;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

final class o implements X509TrustManager {
    private final TrustManager[] a;
    private final p b;
    private final long c;
    private final List d = new LinkedList();
    private final Set e = Collections.synchronizedSet(new HashSet());

    public o(p pVar, n nVar) {
        this.a = a(pVar);
        this.b = pVar;
        this.c = -1;
        for (String a : nVar.c()) {
            this.d.add(a(a));
        }
    }

    private boolean a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.d) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private static TrustManager[] a(p pVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(pVar.a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.e.contains(x509CertificateArr[0])) {
            for (TrustManager trustManager : this.a) {
                ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
            }
            if (this.c == -1 || System.currentTimeMillis() - this.c <= 15552000000L) {
                X509Certificate[] a = a.a(x509CertificateArr, this.b);
                int length = a.length;
                int i = 0;
                while (i < length) {
                    if (!a(a[i])) {
                        i++;
                    }
                }
                throw new CertificateException("No valid pins found in chain!");
            }
            f.a().d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.c) + " millis vs 15552000000" + " millis) falling back to system trust.");
            this.e.add(x509CertificateArr[0]);
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
