package com.c.a;

import com.c.a.a.a.aa;
import com.c.a.a.a.ac;
import com.c.a.a.a.ad;
import com.c.a.a.a.ae;
import com.c.a.a.a.ag;
import com.c.a.a.a.f;
import com.c.a.a.a.o;
import com.c.a.a.a.t;
import com.c.a.a.d.ak;
import com.c.a.a.k;
import com.c.a.a.l;
import com.c.a.a.n;
import com.c.a.a.q;
import com.c.a.a.u;
import com.c.a.a.v;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

final class ah extends k {
    ah() {
    }

    public final ag a(r rVar, o oVar) {
        return rVar.f != null ? new ae(oVar, rVar.f) : new t(oVar, rVar.e);
    }

    public final l a(ag agVar) {
        return agVar.j;
    }

    public final void a(aa aaVar, String str) {
        aaVar.a(str);
    }

    public final void a(ag agVar, r rVar, o oVar, al alVar) {
        int i;
        rVar.a(oVar);
        if (!rVar.d) {
            List list = rVar.b.a.j;
            i = agVar.t;
            int i2 = agVar.u;
            int i3 = agVar.v;
            boolean z = agVar.s;
            if (rVar.d) {
                throw new IllegalStateException("already connected");
            }
            ad a;
            ac acVar = new ac(rVar, rVar.a);
            if (rVar.b.a.e != null) {
                a = acVar.a(i, i2, i3, alVar, rVar.b, list, z);
            } else if (list.contains(u.c)) {
                as asVar = rVar.b;
                a = new ad(asVar, ac.a(i2, i, asVar));
            } else {
                throw new aa(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
            }
            rVar.c = a.b;
            rVar.i = a.d;
            rVar.g = a.c == null ? ak.HTTP_1_1 : a.c;
            try {
                if (rVar.g == ak.SPDY_3 || rVar.g == ak.HTTP_2) {
                    rVar.c.setSoTimeout(0);
                    ak akVar = new ak(rVar.b.a.b, true, rVar.c);
                    akVar.d = rVar.g;
                    rVar.f = new com.c.a.a.d.ac(akVar);
                    com.c.a.a.d.ac acVar2 = rVar.f;
                    acVar2.i.a();
                    acVar2.i.b(acVar2.e);
                    i = acVar2.e.c(65536);
                    if (i != 65536) {
                        acVar2.i.a(0, (long) (i - 65536));
                    }
                } else {
                    rVar.e = new f(rVar.a, rVar, rVar.c);
                }
                rVar.d = true;
                if (rVar.e()) {
                    s sVar = agVar.p;
                    if (!rVar.e()) {
                        throw new IllegalArgumentException();
                    } else if (rVar.b()) {
                        synchronized (sVar) {
                            sVar.a(rVar);
                        }
                    }
                }
                agVar.a.b(rVar.b);
            } catch (IOException e) {
                throw new aa(e);
            }
        }
        int i4 = agVar.u;
        i = agVar.v;
        if (!rVar.d) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (rVar.e != null) {
            try {
                rVar.c.setSoTimeout(i4);
                rVar.e.a(i4, i);
            } catch (IOException e2) {
                throw new aa(e2);
            }
        }
    }

    public final void a(r rVar, ak akVar) {
        if (akVar == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        rVar.g = akVar;
    }

    public final void a(r rVar, Object obj) {
        if (rVar.e()) {
            throw new IllegalStateException();
        }
        synchronized (rVar.a) {
            if (rVar.k != obj) {
                return;
            }
            rVar.k = null;
            rVar.c.close();
        }
    }

    public final void a(s sVar, r rVar) {
        if (!rVar.e() && rVar.a()) {
            if (rVar.b()) {
                try {
                    q.a().b(rVar.c);
                    synchronized (sVar) {
                        sVar.a(rVar);
                        rVar.j++;
                        if (rVar.f != null) {
                            throw new IllegalStateException("spdyConnection != null");
                        }
                        rVar.h = System.nanoTime();
                    }
                    return;
                } catch (SocketException e) {
                    q.a();
                    q.a("Unable to untagSocket(): " + e);
                    v.a(rVar.c);
                    return;
                }
            }
            v.a(rVar.c);
        }
    }

    public final void a(u uVar, SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        Object obj = null;
        if (uVar.e != null) {
            obj = (String[]) v.a(String.class, uVar.e, sSLSocket.getEnabledCipherSuites());
        }
        if (z && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (obj == null) {
                obj = sSLSocket.getEnabledCipherSuites();
            }
            strArr = new String[(obj.length + 1)];
            System.arraycopy(obj, 0, strArr, 0, obj.length);
            strArr[strArr.length - 1] = "TLS_FALLBACK_SCSV";
        } else {
            Object obj2 = obj;
        }
        u a = new v(uVar).a(strArr).b((String[]) v.a(String.class, uVar.f, sSLSocket.getEnabledProtocols())).a();
        sSLSocket.setEnabledProtocols(a.f);
        String[] strArr2 = a.e;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public final boolean a(r rVar) {
        return rVar.a();
    }

    public final int b(r rVar) {
        return rVar.j;
    }

    public final u b(ag agVar) {
        return agVar.a;
    }

    public final void b(r rVar, o oVar) {
        rVar.a(oVar);
    }

    public final n c(ag agVar) {
        return agVar.A;
    }

    public final boolean c(r rVar) {
        return rVar.e != null ? rVar.e.b() : true;
    }
}
