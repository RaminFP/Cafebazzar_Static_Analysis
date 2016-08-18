package com.c.a.a;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

public class q {
    private static final q a = c();

    public static q a() {
        return a;
    }

    public static void a(String str) {
        System.out.println(str);
    }

    public static String b() {
        return "OkHttp";
    }

    private static q c() {
        Method method;
        Method method2;
        p pVar;
        p pVar2;
        Method method3;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        Class cls;
        try {
            p pVar3 = new p(null, "setUseSessionTickets", Boolean.TYPE);
            p pVar4 = new p(null, "setHostname", String.class);
            try {
                cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", new Class[]{Socket.class});
                try {
                    method2 = cls.getMethod("untagSocket", new Class[]{Socket.class});
                } catch (ClassNotFoundException e2) {
                    method2 = null;
                    pVar = null;
                    pVar2 = null;
                    method3 = method;
                    return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                } catch (NoSuchMethodException e3) {
                    method2 = null;
                    pVar = null;
                    pVar2 = null;
                    method3 = method;
                    return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                }
                try {
                    Class.forName("android.net.Network");
                    pVar = new p(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        pVar2 = new p(null, "setAlpnProtocols", byte[].class);
                        method3 = method;
                    } catch (ClassNotFoundException e4) {
                        pVar2 = null;
                        method3 = method;
                        return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                    } catch (NoSuchMethodException e5) {
                        pVar2 = null;
                        method3 = method;
                        return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                    }
                } catch (ClassNotFoundException e6) {
                    pVar = null;
                    pVar2 = null;
                    method3 = method;
                    return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                } catch (NoSuchMethodException e7) {
                    pVar = null;
                    pVar2 = null;
                    method3 = method;
                    return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
                }
            } catch (ClassNotFoundException e8) {
                method = null;
                method2 = null;
                pVar = null;
                pVar2 = null;
                method3 = method;
                return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
            } catch (NoSuchMethodException e9) {
                method = null;
                method2 = null;
                pVar = null;
                pVar2 = null;
                method3 = method;
                return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
            }
            return new r(pVar3, pVar4, method3, method2, pVar, pVar2);
        } catch (ClassNotFoundException e10) {
            try {
                Class cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
                cls = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
                Class cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
                return new s(cls2.getMethod("put", new Class[]{SSLSocket.class, cls3}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod("remove", new Class[]{SSLSocket.class}), cls, cls4);
            } catch (ClassNotFoundException e11) {
                return new q();
            } catch (NoSuchMethodException e12) {
                return new q();
            }
        }
    }

    public void a(Socket socket) {
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List list) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public void b(Socket socket) {
    }
}
