package com.c.a;

import com.c.a.a.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
    public final Proxy a;
    public final String b;
    public final int c;
    public final SocketFactory d;
    public final SSLSocketFactory e;
    public final HostnameVerifier f;
    public final n g;
    public final b h;
    public final List i;
    final List j;
    public final ProxySelector k;

    public a(String str, int i, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, n nVar, b bVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        } else if (bVar == null) {
            throw new IllegalArgumentException("authenticator == null");
        } else if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        } else if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        } else {
            this.a = proxy;
            this.b = str;
            this.c = i;
            this.d = socketFactory;
            this.e = sSLSocketFactory;
            this.f = hostnameVerifier;
            this.g = nVar;
            this.h = bVar;
            this.i = v.a(list);
            this.j = v.a(list2);
            this.k = proxySelector;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return v.a(this.a, aVar.a) && this.b.equals(aVar.b) && this.c == aVar.c && v.a(this.e, aVar.e) && v.a(this.f, aVar.f) && v.a(this.g, aVar.g) && v.a(this.h, aVar.h) && v.a(this.i, aVar.i) && v.a(this.j, aVar.j) && v.a(this.k, aVar.k);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.a != null ? this.a.hashCode() : 0;
        int hashCode2 = this.b.hashCode();
        int i2 = this.c;
        int hashCode3 = this.e != null ? this.e.hashCode() : 0;
        int hashCode4 = this.f != null ? this.f.hashCode() : 0;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return ((((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + i2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }
}
