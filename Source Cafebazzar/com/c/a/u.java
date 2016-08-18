package com.c.a;

import com.c.a.a.v;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class u {
    public static final u a;
    public static final u b = new v(a).a(at.TLS_1_0).a(true).a();
    public static final u c = new v(false).a();
    private static final q[] h = new q[]{q.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, q.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, q.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, q.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, q.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, q.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, q.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, q.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, q.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, q.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, q.TLS_RSA_WITH_AES_128_GCM_SHA256, q.TLS_RSA_WITH_AES_128_CBC_SHA, q.TLS_RSA_WITH_AES_256_CBC_SHA, q.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    final boolean d;
    final String[] e;
    final String[] f;
    public final boolean g;

    static {
        v vVar = new v(true);
        q[] qVarArr = h;
        if (vVar.a) {
            String[] strArr = new String[qVarArr.length];
            for (int i = 0; i < qVarArr.length; i++) {
                strArr[i] = qVarArr[i].aS;
            }
            vVar.b = strArr;
            a = vVar.a(at.TLS_1_2, at.TLS_1_1, at.TLS_1_0).a(true).a();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    private u(v vVar) {
        this.d = vVar.a;
        this.e = vVar.b;
        this.f = vVar.c;
        this.g = vVar.d;
    }

    private List a() {
        Object[] objArr = new at[this.f.length];
        for (int i = 0; i < this.f.length; i++) {
            objArr[i] = at.a(this.f[i]);
        }
        return v.a(objArr);
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        boolean z = true;
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            z = false;
        } else {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                boolean z2;
                Object obj = strArr[i];
                for (Object a : strArr2) {
                    if (v.a(obj, a)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                    i++;
                }
            }
            return false;
        }
        return z;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (this.d) {
            if (a(this.f, sSLSocket.getEnabledProtocols())) {
                if (this.e != null) {
                    return a(this.e, sSLSocket.getEnabledCipherSuites());
                } else if (sSLSocket.getEnabledCipherSuites().length > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            if (obj == this) {
                return true;
            }
            u uVar = (u) obj;
            if (this.d == uVar.d) {
                if (!this.d) {
                    return true;
                }
                if (Arrays.equals(this.e, uVar.e) && Arrays.equals(this.f, uVar.f) && this.g == uVar.g) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        if (!this.d) {
            return 17;
        }
        int hashCode = Arrays.hashCode(this.e);
        return (this.g ? 0 : 1) + ((((hashCode + 527) * 31) + Arrays.hashCode(this.f)) * 31);
    }

    public final String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        Object obj;
        if (this.e == null) {
            obj = null;
        } else {
            Object[] objArr = new q[this.e.length];
            for (int i = 0; i < this.e.length; i++) {
                objArr[i] = q.a(this.e[i]);
            }
            obj = v.a(objArr);
        }
        return "ConnectionSpec(cipherSuites=" + (obj == null ? "[use default]" : obj.toString()) + ", tlsVersions=" + a() + ", supportsTlsExtensions=" + this.g + ")";
    }
}
