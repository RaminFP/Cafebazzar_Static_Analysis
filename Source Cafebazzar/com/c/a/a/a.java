package com.c.a.a;

import com.c.a.u;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class a {
    public boolean a;
    public boolean b;
    private final List c;
    private int d = 0;

    public a(List list) {
        this.c = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.d; i < this.c.size(); i++) {
            if (((u) this.c.get(i)).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final u a(SSLSocket sSLSocket) {
        u uVar;
        int i = this.d;
        int size = this.c.size();
        for (int i2 = i; i2 < size; i2++) {
            uVar = (u) this.c.get(i2);
            if (uVar.a(sSLSocket)) {
                this.d = i2 + 1;
                break;
            }
        }
        uVar = null;
        if (uVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.b + ", modes=" + this.c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.a = b(sSLSocket);
        k.b.a(uVar, sSLSocket, this.b);
        return uVar;
    }
}
