package com.c.a;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class as {
    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public as(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.a = aVar;
            this.b = proxy;
            this.c = inetSocketAddress;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof as)) {
            return false;
        }
        as asVar = (as) obj;
        return this.a.equals(asVar.a) && this.b.equals(asVar.b) && this.c.equals(asVar.c);
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
