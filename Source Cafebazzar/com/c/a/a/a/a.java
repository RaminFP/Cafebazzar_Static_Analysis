package com.c.a.a.a;

import com.c.a.a.v;
import com.c.a.al;
import com.c.a.ap;
import com.c.a.b;
import com.c.a.p;
import com.c.a.w;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.List;

public final class a implements b {
    public static final b a = new a();

    private static InetAddress a(Proxy proxy, URL url) {
        return (proxy == null || proxy.type() == Type.DIRECT) ? InetAddress.getByName(url.getHost()) : ((InetSocketAddress) proxy.address()).getAddress();
    }

    public final al a(Proxy proxy, ap apVar) {
        List f = apVar.f();
        al alVar = apVar.a;
        URL a = alVar.a();
        int size = f.size();
        for (int i = 0; i < size; i++) {
            p pVar = (p) f.get(i);
            if ("Basic".equalsIgnoreCase(pVar.a)) {
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(a.getHost(), a(proxy, a), v.a(a), a.getProtocol(), pVar.b, pVar.a, a, RequestorType.SERVER);
                if (requestPasswordAuthentication != null) {
                    return alVar.c().a("Authorization", w.a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).a();
                }
            }
        }
        return null;
    }

    public final al b(Proxy proxy, ap apVar) {
        List f = apVar.f();
        al alVar = apVar.a;
        URL a = alVar.a();
        int size = f.size();
        for (int i = 0; i < size; i++) {
            p pVar = (p) f.get(i);
            if ("Basic".equalsIgnoreCase(pVar.a)) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), a(proxy, a), inetSocketAddress.getPort(), a.getProtocol(), pVar.b, pVar.a, a, RequestorType.PROXY);
                if (requestPasswordAuthentication != null) {
                    return alVar.c().a("Proxy-Authorization", w.a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).a();
                }
            }
        }
        return null;
    }
}
