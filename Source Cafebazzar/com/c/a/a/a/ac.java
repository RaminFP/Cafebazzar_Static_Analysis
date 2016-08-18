package com.c.a.a.a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.c.a.a;
import com.c.a.a.e.b;
import com.c.a.a.q;
import com.c.a.a.v;
import com.c.a.ak;
import com.c.a.al;
import com.c.a.am;
import com.c.a.ap;
import com.c.a.aq;
import com.c.a.as;
import com.c.a.n;
import com.c.a.r;
import com.c.a.s;
import com.c.a.u;
import com.c.a.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ac {
    private final r a;
    private final s b;

    public ac(r rVar, s sVar) {
        this.a = rVar;
        this.b = sVar;
    }

    public static Socket a(int i, int i2, as asVar) {
        q a = q.a();
        try {
            Proxy proxy = asVar.b;
            Socket createSocket = (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) ? asVar.a.d.createSocket() : new Socket(proxy);
            createSocket.setSoTimeout(i);
            a.a(createSocket, asVar.c, i2);
            return createSocket;
        } catch (IOException e) {
            throw new aa(e);
        }
    }

    public final ad a(int i, int i2, int i3, al alVar, as asVar, List list, boolean z) {
        IOException e;
        Socket socket;
        IOException iOException;
        Object obj;
        aa aaVar;
        a aVar = asVar.a;
        com.c.a.a.a aVar2 = new com.c.a.a.a(list);
        aa aaVar2 = null;
        while (true) {
            Socket a = a(i2, i, asVar);
            Object obj2 = (asVar.a.e == null || asVar.b.type() != Type.HTTP) ? null : 1;
            if (obj2 != null) {
                String str;
                String host = alVar.a().getHost();
                int a2 = v.a(alVar.a());
                if (a2 == v.a("https")) {
                    str = host;
                } else {
                    try {
                        str = host + ":" + a2;
                    } catch (IOException e2) {
                        throw new aa(e2);
                    }
                }
                am a3 = new am().a(new URL("https", host, a2, "/")).a("Host", str).a("Proxy-Connection", "Keep-Alive");
                host = alVar.a("User-Agent");
                if (host != null) {
                    a3.a("User-Agent", host);
                }
                host = alVar.a("Proxy-Authorization");
                if (host != null) {
                    a3.a("Proxy-Authorization", host);
                }
                al a4 = a3.a();
                f fVar = new f(this.b, this.a, a);
                fVar.a(i2, i3);
                URL a5 = a4.a();
                String str2 = "CONNECT " + a5.getHost() + ":" + v.a(a5) + " HTTP/1.1";
                while (true) {
                    fVar.a(a4.c, str2);
                    fVar.a();
                    aq c = fVar.c();
                    c.a = a4;
                    ap a6 = c.a();
                    long a7 = u.a(a6);
                    if (a7 == -1) {
                        a7 = 0;
                    }
                    d.ac a8 = fVar.a(a7);
                    v.b(a8, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                    a8.close();
                    switch (a6.c) {
                        case Callback.DEFAULT_DRAG_ANIMATION_DURATION /*200*/:
                            if (fVar.c.b().b > 0) {
                                throw new IOException("TLS tunnel buffered too many bytes!");
                            }
                            break;
                        case 407:
                            a4 = u.a(asVar.a.h, a6, asVar.b);
                            if (a4 == null) {
                                throw new IOException("Failed to authenticate with proxy");
                            }
                        default:
                            throw new IOException("Unexpected response code for CONNECT: " + a6.c);
                    }
                }
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) aVar.e.createSocket(a, aVar.b, aVar.c, true);
                q a9;
                try {
                    u a10 = aVar2.a(sSLSocket);
                    a9 = q.a();
                    ak akVar = null;
                    if (a10.g) {
                        a9.a(sSLSocket, aVar.b, aVar.i);
                    }
                    sSLSocket.startHandshake();
                    y a11 = y.a(sSLSocket.getSession());
                    if (a10.g) {
                        String b = a9.b(sSLSocket);
                        if (b != null) {
                            akVar = ak.a(b);
                        }
                    }
                    a9.a(sSLSocket);
                    if (aVar.f.verify(aVar.b, sSLSocket.getSession())) {
                        aVar.g.a(aVar.b, a11.b);
                        return new ad(asVar, sSLSocket, akVar, a11);
                    }
                    Certificate certificate = (X509Certificate) sSLSocket.getSession().getPeerCertificates()[0];
                    throw new SSLPeerUnverifiedException("Hostname " + aVar.b + " not verified:\n    certificate: " + n.a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + b.a(certificate));
                } catch (IOException e3) {
                    socket = sSLSocket;
                    iOException = e3;
                } catch (Throwable th) {
                    a9.a(sSLSocket);
                }
            } catch (IOException e22) {
                socket = null;
                iOException = e22;
                if (z) {
                    aVar2.b = true;
                    obj2 = ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) && aVar2.a))) ? null : 1;
                    if (obj2 != null) {
                        obj = 1;
                        v.a(socket);
                        v.a(a);
                        if (aaVar2 != null) {
                            aaVar = new aa(iOException);
                        } else {
                            e22 = aaVar2.b;
                            if (aa.a != null) {
                                try {
                                    aa.a.invoke(iOException, new Object[]{e22});
                                } catch (InvocationTargetException e4) {
                                } catch (IllegalAccessException e5) {
                                }
                            }
                            aaVar2.b = iOException;
                            aaVar = aaVar2;
                        }
                        if (obj != null) {
                            throw aaVar;
                        }
                        aaVar2 = aaVar;
                    }
                }
                obj = null;
                v.a(socket);
                v.a(a);
                if (aaVar2 != null) {
                    e22 = aaVar2.b;
                    if (aa.a != null) {
                        aa.a.invoke(iOException, new Object[]{e22});
                    }
                    aaVar2.b = iOException;
                    aaVar = aaVar2;
                } else {
                    aaVar = new aa(iOException);
                }
                if (obj != null) {
                    aaVar2 = aaVar;
                } else {
                    throw aaVar;
                }
            }
            aaVar2 = aaVar;
        }
    }
}
