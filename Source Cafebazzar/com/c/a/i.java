package com.c.a;

import com.c.a.a.a.af;
import com.c.a.a.a.u;
import com.c.a.a.v;
import d.ac;
import d.e;
import d.f;
import d.j;
import d.k;
import d.r;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class i {
    final String a;
    final z b;
    final String c;
    final ak d;
    final int e;
    final String f;
    final z g;
    final y h;

    public i(ap apVar) {
        this.a = apVar.a.a.toString();
        this.b = u.c(apVar);
        this.c = apVar.a.b;
        this.d = apVar.b;
        this.e = apVar.c;
        this.f = apVar.d;
        this.g = apVar.f;
        this.h = apVar.e;
    }

    public i(ac acVar) {
        int i = 0;
        try {
            j a = r.a(acVar);
            this.a = a.p();
            this.c = a.p();
            aa aaVar = new aa();
            int a2 = c.a(a);
            for (int i2 = 0; i2 < a2; i2++) {
                aaVar.a(a.p());
            }
            this.b = aaVar.a();
            af a3 = af.a(a.p());
            this.d = a3.a;
            this.e = a3.b;
            this.f = a3.c;
            aa aaVar2 = new aa();
            int a4 = c.a(a);
            while (i < a4) {
                aaVar2.a(a.p());
                i++;
            }
            this.g = aaVar2.a();
            if (a()) {
                String p = a.p();
                if (p.length() > 0) {
                    throw new IOException("expected \"\" but was \"" + p + "\"");
                }
                p = a.p();
                List a5 = a(a);
                List a6 = a(a);
                if (p == null) {
                    throw new IllegalArgumentException("cipherSuite == null");
                }
                this.h = new y(p, v.a(a5), v.a(a6));
            } else {
                this.h = null;
            }
            acVar.close();
        } catch (Throwable th) {
            acVar.close();
        }
    }

    private static List a(j jVar) {
        int a = c.a(jVar);
        if (a == -1) {
            return Collections.emptyList();
        }
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            List arrayList = new ArrayList(a);
            for (int i = 0; i < a; i++) {
                String p = jVar.p();
                f fVar = new f();
                fVar.a(k.b(p));
                arrayList.add(instance.generateCertificate(fVar.f()));
            }
            return arrayList;
        } catch (CertificateException e) {
            throw new IOException(e.getMessage());
        }
    }

    private static void a(d.i iVar, List list) {
        try {
            iVar.j((long) list.size());
            iVar.h(10);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                iVar.b(e.a(k.a(((Certificate) list.get(i)).getEncoded()).c));
                iVar.h(10);
            }
        } catch (CertificateEncodingException e) {
            throw new IOException(e.getMessage());
        }
    }

    private boolean a() {
        return this.a.startsWith("https://");
    }

    public final void a(com.c.a.a.f fVar) {
        int i;
        int i2 = 0;
        d.i a = r.a(fVar.a(0));
        a.b(this.a);
        a.h(10);
        a.b(this.c);
        a.h(10);
        a.j((long) (this.b.a.length / 2));
        a.h(10);
        int length = this.b.a.length / 2;
        for (i = 0; i < length; i++) {
            a.b(this.b.a(i));
            a.b(": ");
            a.b(this.b.b(i));
            a.h(10);
        }
        a.b(new af(this.d, this.e, this.f).toString());
        a.h(10);
        a.j((long) (this.g.a.length / 2));
        a.h(10);
        i = this.g.a.length / 2;
        while (i2 < i) {
            a.b(this.g.a(i2));
            a.b(": ");
            a.b(this.g.b(i2));
            a.h(10);
            i2++;
        }
        if (a()) {
            a.h(10);
            a.b(this.h.a);
            a.h(10);
            a(a, this.h.b);
            a(a, this.h.c);
        }
        a.close();
    }
}
