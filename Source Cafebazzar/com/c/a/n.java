package com.c.a;

import com.c.a.a.v;
import d.e;
import d.k;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class n {
    public static final n a = new n(new o());
    private final Map b;

    private n(o oVar) {
        this.b = v.a(oVar.a);
    }

    private static k a(X509Certificate x509Certificate) {
        return v.a(k.a(x509Certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + e.a(a((X509Certificate) certificate).c);
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public final void a(String str, List list) {
        Set set = null;
        Set set2 = (Set) this.b.get(str);
        int indexOf = str.indexOf(46);
        Collection collection = indexOf != str.lastIndexOf(46) ? (Set) this.b.get("*." + str.substring(indexOf + 1)) : null;
        if (!(set2 == null && collection == null)) {
            if (set2 != null && collection != null) {
                Set linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll(set2);
                linkedHashSet.addAll(collection);
                set = linkedHashSet;
            } else if (set2 != null) {
                set = set2;
            } else {
                Collection collection2 = collection;
            }
        }
        if (r3 != null) {
            int size = list.size();
            indexOf = 0;
            while (indexOf < size) {
                if (!r3.contains(a((X509Certificate) list.get(indexOf)))) {
                    indexOf++;
                } else {
                    return;
                }
            }
            StringBuilder append = new StringBuilder("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (indexOf = 0; indexOf < size2; indexOf++) {
                Certificate certificate = (X509Certificate) list.get(indexOf);
                append.append("\n    ").append(a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            for (k kVar : r3) {
                append.append("\n    sha1/").append(e.a(kVar.c));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }
}
