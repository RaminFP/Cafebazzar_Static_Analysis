package com.c.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class o implements n {
    o() {
    }

    public final InetAddress[] a(String str) {
        if (str != null) {
            return InetAddress.getAllByName(str);
        }
        throw new UnknownHostException("host == null");
    }
}
