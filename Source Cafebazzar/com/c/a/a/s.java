package com.c.a.a;

import com.c.a.ak;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

final class s extends q {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class d;
    private final Class e;

    public s(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public final void a(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List list) {
        Object newProxyInstance;
        List arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) list.get(i);
            if (akVar != ak.HTTP_1_0) {
                arrayList.add(akVar.toString());
            }
        }
        try {
            ClassLoader classLoader = q.class.getClassLoader();
            Class cls = this.d;
            Class cls2 = this.e;
            InvocationHandler tVar = new t(arrayList);
            newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{cls, cls2}, tVar);
            this.a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            newProxyInstance = e;
            throw new AssertionError(newProxyInstance);
        } catch (IllegalAccessException e2) {
            newProxyInstance = e2;
            throw new AssertionError(newProxyInstance);
        }
    }

    public final String b(SSLSocket sSLSocket) {
        try {
            t tVar = (t) Proxy.getInvocationHandler(this.b.invoke(null, new Object[]{sSLSocket}));
            if (tVar.b || tVar.c != null) {
                return tVar.b ? null : tVar.c;
            } else {
                k.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            }
        } catch (InvocationTargetException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }
}
