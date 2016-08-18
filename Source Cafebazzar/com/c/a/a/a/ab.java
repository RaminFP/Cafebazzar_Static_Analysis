package com.c.a.a.a;

import com.c.a.a;
import com.c.a.a.k;
import com.c.a.a.n;
import com.c.a.a.u;
import com.c.a.a.v;
import com.c.a.ag;
import com.c.a.as;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class ab {
    final a a;
    final URI b;
    final u c;
    private final n d;
    private final ag e;
    private Proxy f;
    private InetSocketAddress g;
    private List h = Collections.emptyList();
    private int i;
    private List j = Collections.emptyList();
    private int k;
    private final List l = new ArrayList();

    ab(a aVar, URI uri, ag agVar) {
        this.a = aVar;
        this.b = uri;
        this.e = agVar;
        this.c = k.b.b(agVar);
        this.d = k.b.c(agVar);
        Proxy proxy = aVar.a;
        if (proxy != null) {
            this.h = Collections.singletonList(proxy);
        } else {
            this.h = new ArrayList();
            Collection select = this.e.h.select(uri);
            if (select != null) {
                this.h.addAll(select);
            }
            this.h.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.h.add(Proxy.NO_PROXY);
        }
        this.i = 0;
    }

    private void a(Proxy proxy) {
        String str;
        int a;
        this.j = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.a.b;
            a = v.a(this.b);
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                String hostName = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                int port = inetSocketAddress.getPort();
                str = hostName;
                a = port;
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (a <= 0 || a > 65535) {
            throw new SocketException("No route to " + str + ":" + a + "; port is out of range");
        }
        for (InetAddress inetSocketAddress2 : this.d.a(str)) {
            this.j.add(new InetSocketAddress(inetSocketAddress2, a));
        }
        this.k = 0;
    }

    private boolean c() {
        return this.i < this.h.size();
    }

    private boolean d() {
        return this.k < this.j.size();
    }

    private boolean e() {
        return !this.l.isEmpty();
    }

    public final boolean a() {
        return d() || c() || e();
    }

    public final as b() {
        while (true) {
            if (!d()) {
                if (!c()) {
                    break;
                } else if (c()) {
                    List list = this.h;
                    int i = this.i;
                    this.i = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    a(proxy);
                    this.f = proxy;
                } else {
                    throw new SocketException("No route to " + this.a.b + "; exhausted proxy configurations: " + this.h);
                }
            }
            if (d()) {
                list = this.j;
                i = this.k;
                this.k = i + 1;
                this.g = (InetSocketAddress) list.get(i);
                as asVar = new as(this.a, this.f, this.g);
                if (!this.c.c(asVar)) {
                    return asVar;
                }
                this.l.add(asVar);
            } else {
                throw new SocketException("No route to " + this.a.b + "; exhausted inet socket addresses: " + this.j);
            }
        }
        if (e()) {
            return (as) this.l.remove(0);
        }
        throw new NoSuchElementException();
    }
}
