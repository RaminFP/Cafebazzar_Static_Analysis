package com.c.a.a;

import com.c.a.ak;
import d.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

final class r extends q {
    private final p a;
    private final p b;
    private final Method c;
    private final Method d;
    private final p e;
    private final p f;

    public r(p pVar, p pVar2, Method method, Method method2, p pVar3, p pVar4) {
        this.a = pVar;
        this.b = pVar2;
        this.c = method;
        this.d = method2;
        this.e = pVar3;
        this.f = pVar4;
    }

    public final void a(Socket socket) {
        if (this.c != null) {
            try {
                this.c.invoke(null, new Object[]{socket});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (Throwable e) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e);
            throw iOException;
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.a.a(sSLSocket, Boolean.valueOf(true));
            this.b.a(sSLSocket, str);
        }
        if (this.f != null && this.f.a((Object) sSLSocket)) {
            f fVar = new f();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ak akVar = (ak) list.get(i);
                if (akVar != ak.HTTP_1_0) {
                    fVar.b(akVar.toString().length());
                    fVar.a(akVar.toString());
                }
            }
            byte[] q = fVar.q();
            this.f.b(sSLSocket, q);
        }
    }

    public final String b(SSLSocket sSLSocket) {
        if (this.e == null) {
            return null;
        }
        if (!this.e.a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.e.b(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, v.c) : null;
    }

    public final void b(Socket socket) {
        if (this.d != null) {
            try {
                this.d.invoke(null, new Object[]{socket});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
