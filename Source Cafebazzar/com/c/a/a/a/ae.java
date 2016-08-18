package com.c.a.a.a;

import com.c.a.a.d.a;
import com.c.a.a.d.ac;
import com.c.a.a.d.ao;
import com.c.a.a.d.e;
import com.c.a.a.v;
import com.c.a.aa;
import com.c.a.ak;
import com.c.a.al;
import com.c.a.ap;
import com.c.a.aq;
import com.c.a.ar;
import com.c.a.z;
import d.ab;
import d.k;
import d.r;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ae implements ag {
    private static final List a = v.a(k.a("connection"), k.a("host"), k.a("keep-alive"), k.a("proxy-connection"), k.a("transfer-encoding"));
    private static final List b = v.a(k.a("connection"), k.a("host"), k.a("keep-alive"), k.a("proxy-connection"), k.a("te"), k.a("transfer-encoding"), k.a("encoding"), k.a("upgrade"));
    private final o c;
    private final ac d;
    private ao e;

    public ae(o oVar, ac acVar) {
        this.c = oVar;
        this.d = acVar;
    }

    private static boolean a(ak akVar, k kVar) {
        if (akVar == ak.SPDY_3) {
            return a.contains(kVar);
        }
        if (akVar == ak.HTTP_2) {
            return b.contains(kVar);
        }
        throw new AssertionError(akVar);
    }

    public final ar a(ap apVar) {
        return new w(apVar.f, r.a(this.e.f));
    }

    public final ab a(al alVar, long j) {
        return this.e.d();
    }

    public final void a() {
        this.e.d().close();
    }

    public final void a(o oVar) {
        if (this.e != null) {
            this.e.a(a.CANCEL);
        }
    }

    public final void a(z zVar) {
        zVar.a(this.e.d());
    }

    public final void a(al alVar) {
        if (this.e == null) {
            this.c.b();
            boolean c = this.c.c();
            String a = y.a(this.c.b.g);
            ac acVar = this.d;
            ak akVar = this.d.a;
            z zVar = alVar.c;
            List arrayList = new ArrayList((zVar.a.length / 2) + 10);
            arrayList.add(new e(e.b, alVar.b));
            arrayList.add(new e(e.c, y.a(alVar.a())));
            String a2 = o.a(alVar.a());
            if (ak.SPDY_3 == akVar) {
                arrayList.add(new e(e.g, a));
                arrayList.add(new e(e.f, a2));
            } else if (ak.HTTP_2 == akVar) {
                arrayList.add(new e(e.e, a2));
            } else {
                throw new AssertionError();
            }
            arrayList.add(new e(e.d, alVar.a().getProtocol()));
            Set linkedHashSet = new LinkedHashSet();
            int length = zVar.a.length / 2;
            for (int i = 0; i < length; i++) {
                k a3 = k.a(zVar.a(i).toLowerCase(Locale.US));
                String b = zVar.b(i);
                if (!a(akVar, a3) && !a3.equals(e.b) && !a3.equals(e.c) && !a3.equals(e.d) && !a3.equals(e.e) && !a3.equals(e.f) && !a3.equals(e.g)) {
                    if (linkedHashSet.add(a3)) {
                        arrayList.add(new e(a3, b));
                    } else {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            if (((e) arrayList.get(i2)).h.equals(a3)) {
                                arrayList.set(i2, new e(a3, new StringBuilder(((e) arrayList.get(i2)).i.a()).append('\u0000').append(b).toString()));
                                break;
                            }
                        }
                    }
                }
            }
            this.e = acVar.a(0, arrayList, c, true);
            this.e.h.a((long) this.c.a.u, TimeUnit.MILLISECONDS);
        }
    }

    public final aq b() {
        List c = this.e.c();
        ak akVar = this.d.a;
        String str = null;
        String str2 = "HTTP/1.1";
        aa aaVar = new aa();
        aaVar.b(u.d, akVar.toString());
        int size = c.size();
        int i = 0;
        while (i < size) {
            k kVar = ((e) c.get(i)).h;
            String a = ((e) c.get(i)).i.a();
            String str3 = str2;
            int i2 = 0;
            while (i2 < a.length()) {
                int indexOf = a.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = a.length();
                }
                str2 = a.substring(i2, indexOf);
                if (!kVar.equals(e.a)) {
                    if (kVar.equals(e.g)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!a(akVar, kVar)) {
                            aaVar.a(kVar.a(), str2);
                        }
                        str2 = str;
                    }
                }
                String str4 = str2;
                i2 = indexOf + 1;
                str = str4;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        af a2 = af.a(str2 + " " + str);
        aq aqVar = new aq();
        aqVar.b = akVar;
        aqVar.c = a2.b;
        aqVar.d = a2.c;
        return aqVar.a(aaVar.a());
    }

    public final void c() {
    }

    public final boolean d() {
        return true;
    }
}
