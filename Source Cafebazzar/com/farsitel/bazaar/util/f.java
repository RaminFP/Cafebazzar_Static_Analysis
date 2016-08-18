package com.farsitel.bazaar.util;

public final class f {
    public static Object[] a(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        for (int i = 0; i < objArr.length / 2; i++) {
            Object obj = objArr[i];
            objArr[i] = objArr[(objArr.length - i) - 1];
            objArr[(objArr.length - i) - 1] = obj;
        }
        return objArr;
    }
}
