package com.c.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

final class t implements InvocationHandler {
    private final List a;
    private boolean b;
    private String c;

    public t(List list) {
        this.a = list;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Class returnType = method.getReturnType();
        if (objArr == null) {
            objArr = v.b;
        }
        if (name.equals("supports") && Boolean.TYPE == returnType) {
            return Boolean.valueOf(true);
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.b = true;
            return null;
        } else if (name.equals("protocols") && objArr.length == 0) {
            return this.a;
        } else {
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.contains(list.get(i))) {
                        name = (String) list.get(i);
                        this.c = name;
                        return name;
                    }
                }
                name = (String) this.a.get(0);
                this.c = name;
                return name;
            } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            } else {
                this.c = (String) objArr[0];
                return null;
            }
        }
    }
}
