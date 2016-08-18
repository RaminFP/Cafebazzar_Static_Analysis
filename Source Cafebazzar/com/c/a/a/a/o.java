package com.c.a.a.a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.c.a.a;
import com.c.a.a.k;
import com.c.a.a.l;
import com.c.a.a.v;
import com.c.a.aa;
import com.c.a.ag;
import com.c.a.ak;
import com.c.a.al;
import com.c.a.am;
import com.c.a.ap;
import com.c.a.aq;
import com.c.a.ar;
import com.c.a.as;
import com.c.a.n;
import com.c.a.r;
import com.c.a.z;
import d.ab;
import d.ac;
import d.i;
import d.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class o {
    private static final ar j = new p();
    final ag a;
    public r b;
    public as c;
    public ag d;
    long e = -1;
    public final boolean f;
    final al g;
    public ab h;
    public i i;
    private a k;
    private ab l;
    private final ap m;
    private boolean n;
    private al o;
    private ap p;
    private ap q;
    private final boolean r;
    private final boolean s;
    private b t;
    private c u;

    public o(ag agVar, al alVar, boolean z, boolean z2, boolean z3, r rVar, ab abVar, z zVar, ap apVar) {
        this.a = agVar;
        this.g = alVar;
        this.f = z;
        this.r = z2;
        this.s = z3;
        this.b = rVar;
        this.l = abVar;
        this.h = zVar;
        this.m = apVar;
        if (rVar != null) {
            k.b.b(rVar, this);
            this.c = rVar.b;
            return;
        }
        this.c = null;
    }

    private static z a(z zVar, z zVar2) {
        int i;
        int i2 = 0;
        aa aaVar = new aa();
        int length = zVar.a.length / 2;
        for (i = 0; i < length; i++) {
            String a = zVar.a(i);
            String b = zVar.b(i);
            if (!("Warning".equalsIgnoreCase(a) && b.startsWith("1")) && (!u.a(a) || zVar2.a(a) == null)) {
                aaVar.a(a, b);
            }
        }
        i = zVar2.a.length / 2;
        while (i2 < i) {
            String a2 = zVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a2) && u.a(a2)) {
                aaVar.a(a2, zVar2.b(i2));
            }
            i2++;
        }
        return aaVar.a();
    }

    public static String a(URL url) {
        return v.a(url) != v.a(url.getProtocol()) ? url.getHost() + ":" + url.getPort() : url.getHost();
    }

    private void a(ab abVar, IOException iOException) {
        if (k.b.b(this.b) <= 0) {
            as asVar = this.b.b;
            if (!(asVar.b.type() == Type.DIRECT || abVar.a.k == null)) {
                abVar.a.k.connectFailed(abVar.b, asVar.b.address(), iOException);
            }
            abVar.c.a(asVar);
        }
    }

    public static boolean a(ap apVar) {
        if (!apVar.a.b.equals("HEAD")) {
            int i = apVar.c;
            if (((i < 100 || i >= Callback.DEFAULT_DRAG_ANIMATION_DURATION) && i != 204 && i != 304) || u.a(apVar) != -1) {
                return true;
            }
            if ("chunked".equalsIgnoreCase(apVar.a("Transfer-Encoding"))) {
                return true;
            }
        }
        return false;
    }

    private static ap b(ap apVar) {
        if (apVar == null || apVar.g == null) {
            return apVar;
        }
        aq d = apVar.d();
        d.g = null;
        return d.a();
    }

    private ap c(ap apVar) {
        if (!this.n || !"gzip".equalsIgnoreCase(this.q.a("Content-Encoding")) || apVar.g == null) {
            return apVar;
        }
        ac pVar = new p(apVar.g.b());
        z a = apVar.f.a().b("Content-Encoding").b("Content-Length").a();
        aq a2 = apVar.d().a(a);
        a2.g = new w(a, d.r.a(pVar));
        return a2.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.c.a.r k() {
        /*
        r4 = this;
        r0 = r4.a;
        r1 = r0.p;
    L_0x0004:
        r0 = r4.k;
        r0 = r1.a(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x000c:
        r2 = r4.o;
        r2 = r2.b;
        r3 = "GET";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0020;
    L_0x0018:
        r2 = com.c.a.a.k.b;
        r2 = r2.c(r0);
        if (r2 == 0) goto L_0x0021;
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = r0.c;
        com.c.a.a.v.a(r0);
        goto L_0x0004;
    L_0x0027:
        r0 = new com.c.a.r;	 Catch:{ IOException -> 0x0033 }
        r2 = r4.l;	 Catch:{ IOException -> 0x0033 }
        r2 = r2.b();	 Catch:{ IOException -> 0x0033 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0033 }
        goto L_0x0020;
    L_0x0033:
        r0 = move-exception;
        r1 = new com.c.a.a.a.aa;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.o.k():com.c.a.r");
    }

    private void l() {
        l a = k.b.a(this.a);
        if (a != null) {
            if (c.a(this.q, this.o)) {
                this.t = a.a(b(this.q));
            } else if (s.a(this.o.b)) {
                try {
                    a.b(this.o);
                } catch (IOException e) {
                }
            }
        }
    }

    private ap m() {
        this.d.a();
        aq b = this.d.b();
        b.a = this.o;
        b.e = this.b.i;
        ap a = b.a(u.b, Long.toString(this.e)).a(u.c, Long.toString(System.currentTimeMillis())).a();
        if (!this.s) {
            aq d = a.d();
            d.g = this.d.a(a);
            a = d.a();
        }
        k.b.a(this.b, a.b);
        return a;
    }

    public final o a(aa aaVar) {
        Object obj = null;
        if (!(this.l == null || this.b == null)) {
            a(this.l, aaVar.b);
        }
        if (!(this.l == null && this.b == null) && (this.l == null || this.l.a())) {
            if (this.a.s) {
                IOException iOException = aaVar.b;
                if (!((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)))) {
                    obj = 1;
                }
            }
            if (obj != null) {
                return new o(this.a, this.g, this.f, this.r, this.s, h(), this.l, (z) this.h, this.m);
            }
        }
        return null;
    }

    public final o a(IOException iOException, ab abVar) {
        Object obj = null;
        if (!(this.l == null || this.b == null)) {
            a(this.l, iOException);
        }
        Object obj2 = (abVar == null || (abVar instanceof z)) ? 1 : null;
        if (!(this.l == null && this.b == null) && (this.l == null || this.l.a())) {
            if (!(!this.a.s || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException))) {
                int i = 1;
            }
            if (!(obj == null || obj2 == null)) {
                return new o(this.a, this.g, this.f, this.r, this.s, h(), this.l, (z) abVar, this.m);
            }
        }
        return null;
    }

    public final void a() {
        if (this.u == null) {
            if (this.d != null) {
                throw new IllegalStateException();
            }
            al alVar = this.g;
            am c = alVar.c();
            if (alVar.a("Host") == null) {
                c.a("Host", a(alVar.a()));
            }
            if ((this.b == null || this.b.g != ak.HTTP_1_0) && alVar.a("Connection") == null) {
                c.a("Connection", "Keep-Alive");
            }
            if (alVar.a("Accept-Encoding") == null) {
                this.n = true;
                c.a("Accept-Encoding", "gzip");
            }
            CookieHandler cookieHandler = this.a.i;
            if (cookieHandler != null) {
                u.a(c, cookieHandler.get(alVar.b(), u.a(c.a().c, null)));
            }
            if (alVar.a("User-Agent") == null) {
                c.a("User-Agent", "okhttp/2.4.0");
            }
            al a = c.a();
            l a2 = k.b.a(this.a);
            ap a3 = a2 != null ? a2.a(a) : null;
            this.u = new d(System.currentTimeMillis(), a, a3).a();
            this.o = this.u.a;
            this.p = this.u.b;
            if (a2 != null) {
                a2.a(this.u);
            }
            if (a3 != null && this.p == null) {
                v.a(a3.g);
            }
            if (this.o != null) {
                if (this.b == null) {
                    if (this.b != null) {
                        throw new IllegalStateException();
                    }
                    if (this.l == null) {
                        ag agVar = this.a;
                        al alVar2 = this.o;
                        String host = alVar2.a().getHost();
                        if (host == null || host.length() == 0) {
                            throw new x(new UnknownHostException(alVar2.a().toString()));
                        }
                        SSLSocketFactory sSLSocketFactory;
                        HostnameVerifier hostnameVerifier;
                        n nVar;
                        if (alVar2.e()) {
                            sSLSocketFactory = agVar.l;
                            hostnameVerifier = agVar.m;
                            nVar = agVar.n;
                        } else {
                            nVar = null;
                            hostnameVerifier = null;
                            sSLSocketFactory = null;
                        }
                        this.k = new a(host, v.a(alVar2.a()), agVar.k, sSLSocketFactory, hostnameVerifier, nVar, agVar.o, agVar.c, agVar.d, agVar.e, agVar.h);
                        try {
                            this.l = new ab(this.k, this.o.b(), this.a);
                        } catch (IOException e) {
                            throw new x(e);
                        }
                    }
                    r k = k();
                    k.b.a(this.a, k, this, this.o);
                    this.b = k;
                    this.c = this.b.b;
                }
                this.d = k.b.a(this.b, this);
                if (this.r && c() && this.h == null) {
                    long a4 = u.a(a);
                    if (!this.f) {
                        this.d.a(this.o);
                        this.h = this.d.a(this.o, a4);
                        return;
                    } else if (a4 > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else if (a4 != -1) {
                        this.d.a(this.o);
                        this.h = new z((int) a4);
                        return;
                    } else {
                        this.h = new z();
                        return;
                    }
                }
                return;
            }
            if (this.b != null) {
                k.b.a(this.a.p, this.b);
                this.b = null;
            }
            aq d;
            if (this.p != null) {
                d = this.p.d();
                d.a = this.g;
                this.q = d.c(b(this.m)).b(b(this.p)).a();
            } else {
                d = new aq();
                d.a = this.g;
                d = d.c(b(this.m));
                d.b = ak.HTTP_1_1;
                d.c = 504;
                d.d = "Unsatisfiable Request (only-if-cached)";
                d.g = j;
                this.q = d.a();
            }
            this.q = c(this.q);
        }
    }

    public final void a(z zVar) {
        CookieHandler cookieHandler = this.a.i;
        if (cookieHandler != null) {
            cookieHandler.put(this.g.b(), u.a(zVar, null));
        }
    }

    public final void b() {
        if (this.e != -1) {
            throw new IllegalStateException();
        }
        this.e = System.currentTimeMillis();
    }

    public final boolean b(URL url) {
        URL a = this.g.a();
        return a.getHost().equals(url.getHost()) && v.a(a) == v.a(url) && a.getProtocol().equals(url.getProtocol());
    }

    final boolean c() {
        return s.c(this.g.b);
    }

    public final ab d() {
        if (this.u != null) {
            return this.h;
        }
        throw new IllegalStateException();
    }

    public final boolean e() {
        return this.q != null;
    }

    public final ap f() {
        if (this.q != null) {
            return this.q;
        }
        throw new IllegalStateException();
    }

    public final void g() {
        if (!(this.d == null || this.b == null)) {
            this.d.c();
        }
        this.b = null;
    }

    public final r h() {
        if (this.i != null) {
            v.a(this.i);
        } else if (this.h != null) {
            v.a(this.h);
        }
        if (this.q == null) {
            if (this.b != null) {
                v.a(this.b.c);
            }
            this.b = null;
            return null;
        }
        v.a(this.q.g);
        if (this.d == null || this.b == null || this.d.d()) {
            if (!(this.b == null || k.b.a(this.b))) {
                this.b = null;
            }
            r rVar = this.b;
            this.b = null;
            return rVar;
        }
        v.a(this.b.c);
        this.b = null;
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
        r10 = this;
        r8 = -1;
        r2 = 0;
        r1 = 1;
        r0 = r10.q;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r10.o;
        if (r0 != 0) goto L_0x0019;
    L_0x000d:
        r0 = r10.p;
        if (r0 != 0) goto L_0x0019;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;
        r1 = "call sendRequest() first!";
        r0.<init>(r1);
        throw r0;
    L_0x0019:
        r0 = r10.o;
        if (r0 == 0) goto L_0x0008;
    L_0x001d:
        r0 = r10.s;
        if (r0 == 0) goto L_0x00a1;
    L_0x0021:
        r0 = r10.d;
        r3 = r10.o;
        r0.a(r3);
    L_0x0028:
        r0 = r10.m();
    L_0x002c:
        r3 = r0.f;
        r10.a(r3);
        r3 = r10.p;
        if (r3 == 0) goto L_0x0154;
    L_0x0035:
        r3 = r10.p;
        r4 = r0.c;
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r5) goto L_0x012a;
    L_0x003d:
        if (r1 == 0) goto L_0x014d;
    L_0x003f:
        r1 = r10.p;
        r1 = r1.d();
        r2 = r10.g;
        r1.a = r2;
        r2 = r10.m;
        r2 = b(r2);
        r1 = r1.c(r2);
        r2 = r10.p;
        r2 = r2.f;
        r3 = r0.f;
        r2 = a(r2, r3);
        r1 = r1.a(r2);
        r2 = r10.p;
        r2 = b(r2);
        r1 = r1.b(r2);
        r2 = b(r0);
        r1 = r1.a(r2);
        r1 = r1.a();
        r10.q = r1;
        r0 = r0.g;
        r0.close();
        r10.g();
        r0 = com.c.a.a.k.b;
        r1 = r10.a;
        r0 = r0.a(r1);
        r0.a();
        r1 = r10.p;
        r2 = r10.q;
        r2 = b(r2);
        r0.a(r1, r2);
        r0 = r10.q;
        r0 = r10.c(r0);
        r10.q = r0;
        goto L_0x0008;
    L_0x00a1:
        r0 = r10.r;
        if (r0 != 0) goto L_0x00b4;
    L_0x00a5:
        r0 = new com.c.a.a.a.r;
        r3 = r10.o;
        r0.<init>(r10, r2, r3);
        r3 = r10.o;
        r0 = r0.a(r3);
        goto L_0x002c;
    L_0x00b4:
        r0 = r10.i;
        if (r0 == 0) goto L_0x00cb;
    L_0x00b8:
        r0 = r10.i;
        r0 = r0.b();
        r4 = r0.b;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cb;
    L_0x00c6:
        r0 = r10.i;
        r0.d();
    L_0x00cb:
        r4 = r10.e;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0106;
    L_0x00d1:
        r0 = r10.o;
        r4 = com.c.a.a.a.u.a(r0);
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x00ff;
    L_0x00db:
        r0 = r10.h;
        r0 = r0 instanceof com.c.a.a.a.z;
        if (r0 == 0) goto L_0x00ff;
    L_0x00e1:
        r0 = r10.h;
        r0 = (com.c.a.a.a.z) r0;
        r0 = r0.a;
        r4 = r0.b;
        r0 = r10.o;
        r0 = r0.c();
        r3 = "Content-Length";
        r4 = java.lang.Long.toString(r4);
        r0 = r0.a(r3, r4);
        r0 = r0.a();
        r10.o = r0;
    L_0x00ff:
        r0 = r10.d;
        r3 = r10.o;
        r0.a(r3);
    L_0x0106:
        r0 = r10.h;
        if (r0 == 0) goto L_0x0028;
    L_0x010a:
        r0 = r10.i;
        if (r0 == 0) goto L_0x0124;
    L_0x010e:
        r0 = r10.i;
        r0.close();
    L_0x0113:
        r0 = r10.h;
        r0 = r0 instanceof com.c.a.a.a.z;
        if (r0 == 0) goto L_0x0028;
    L_0x0119:
        r3 = r10.d;
        r0 = r10.h;
        r0 = (com.c.a.a.a.z) r0;
        r3.a(r0);
        goto L_0x0028;
    L_0x0124:
        r0 = r10.h;
        r0.close();
        goto L_0x0113;
    L_0x012a:
        r3 = r3.f;
        r4 = "Last-Modified";
        r3 = r3.b(r4);
        if (r3 == 0) goto L_0x014a;
    L_0x0134:
        r4 = r0.f;
        r5 = "Last-Modified";
        r4 = r4.b(r5);
        if (r4 == 0) goto L_0x014a;
    L_0x013e:
        r4 = r4.getTime();
        r6 = r3.getTime();
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 < 0) goto L_0x003d;
    L_0x014a:
        r1 = r2;
        goto L_0x003d;
    L_0x014d:
        r1 = r10.p;
        r1 = r1.g;
        com.c.a.a.v.a(r1);
    L_0x0154:
        r1 = r0.d();
        r2 = r10.g;
        r1.a = r2;
        r2 = r10.m;
        r2 = b(r2);
        r1 = r1.c(r2);
        r2 = r10.p;
        r2 = b(r2);
        r1 = r1.b(r2);
        r0 = b(r0);
        r0 = r1.a(r0);
        r0 = r0.a();
        r10.q = r0;
        r0 = r10.q;
        r0 = a(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x0186:
        r10.l();
        r1 = r10.t;
        r0 = r10.q;
        if (r1 != 0) goto L_0x0197;
    L_0x018f:
        r0 = r10.c(r0);
        r10.q = r0;
        goto L_0x0008;
    L_0x0197:
        r2 = r1.b();
        if (r2 == 0) goto L_0x018f;
    L_0x019d:
        r3 = new com.c.a.a.a.q;
        r4 = r0.g;
        r4 = r4.b();
        r2 = d.r.a(r2);
        r3.<init>(r10, r4, r1, r2);
        r1 = r0.d();
        r2 = new com.c.a.a.a.w;
        r0 = r0.f;
        r3 = d.r.a(r3);
        r2.<init>(r0, r3);
        r1.g = r2;
        r0 = r1.a();
        goto L_0x018f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.o.i():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.c.a.al j() {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.q;
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x000b:
        r0 = r4.c;
        if (r0 == 0) goto L_0x001c;
    L_0x000f:
        r0 = r4.c;
        r0 = r0.b;
    L_0x0013:
        r2 = r4.q;
        r2 = r2.c;
        switch(r2) {
            case 300: goto L_0x0056;
            case 301: goto L_0x0056;
            case 302: goto L_0x0056;
            case 303: goto L_0x0056;
            case 307: goto L_0x003c;
            case 308: goto L_0x003c;
            case 401: goto L_0x0031;
            case 407: goto L_0x0021;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r1;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = r4.a;
        r0 = r0.c;
        goto L_0x0013;
    L_0x0021:
        r1 = r0.type();
        r2 = java.net.Proxy.Type.HTTP;
        if (r1 == r2) goto L_0x0031;
    L_0x0029:
        r0 = new java.net.ProtocolException;
        r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r0.<init>(r1);
        throw r0;
    L_0x0031:
        r1 = r4.a;
        r1 = r1.o;
        r2 = r4.q;
        r0 = com.c.a.a.a.u.a(r1, r2, r0);
        goto L_0x001b;
    L_0x003c:
        r0 = r4.g;
        r0 = r0.b;
        r2 = "GET";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0056;
    L_0x0048:
        r0 = r4.g;
        r0 = r0.b;
        r2 = "HEAD";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x001b;
    L_0x0056:
        r0 = r4.a;
        r0 = r0.r;
        if (r0 != 0) goto L_0x005e;
    L_0x005c:
        r0 = r1;
        goto L_0x001b;
    L_0x005e:
        r0 = r4.q;
        r2 = "Location";
        r0 = r0.a(r2);
        if (r0 != 0) goto L_0x006a;
    L_0x0068:
        r0 = r1;
        goto L_0x001b;
    L_0x006a:
        r2 = new java.net.URL;
        r3 = r4.g;
        r3 = r3.a();
        r2.<init>(r3, r0);
        r0 = r2.getProtocol();
        r3 = "https";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x008f;
    L_0x0081:
        r0 = r2.getProtocol();
        r3 = "http";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x008f;
    L_0x008d:
        r0 = r1;
        goto L_0x001b;
    L_0x008f:
        r0 = r2.getProtocol();
        r3 = r4.g;
        r3 = r3.a();
        r3 = r3.getProtocol();
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00ac;
    L_0x00a3:
        r0 = r4.a;
        r0 = r0.q;
        if (r0 != 0) goto L_0x00ac;
    L_0x00a9:
        r0 = r1;
        goto L_0x001b;
    L_0x00ac:
        r0 = r4.g;
        r0 = r0.c();
        r3 = r4.g;
        r3 = r3.b;
        r3 = com.c.a.a.a.s.c(r3);
        if (r3 == 0) goto L_0x00d0;
    L_0x00bc:
        r3 = "GET";
        r0.a(r3, r1);
        r1 = "Transfer-Encoding";
        r0.b(r1);
        r1 = "Content-Length";
        r0.b(r1);
        r1 = "Content-Type";
        r0.b(r1);
    L_0x00d0:
        r1 = r4.b(r2);
        if (r1 != 0) goto L_0x00db;
    L_0x00d6:
        r1 = "Authorization";
        r0.b(r1);
    L_0x00db:
        r0 = r0.a(r2);
        r0 = r0.a();
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.o.j():com.c.a.al");
    }
}
