package com.c.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class p {
    private final Class a;
    private final String b;
    private final Class[] c;

    public p(Class cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    private Method a(Class cls) {
        if (this.b != null) {
            Method a = a(cls, this.b, this.c);
            if (a == null || this.a == null || this.a.isAssignableFrom(a.getReturnType())) {
                return a;
            }
        }
        return null;
    }

    private static Method a(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                return (method.getModifiers() & 1) == 0 ? null : method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    private Object c(Object obj, Object... objArr) {
        Object obj2 = null;
        Method a = a(obj.getClass());
        if (a != null) {
            try {
                obj2 = a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
            }
        }
        return obj2;
    }

    private Object d(Object obj, Object... objArr) {
        Object a = a(obj.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.b + " not supported for object " + obj);
        }
        try {
            return a.invoke(obj, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public final Object a(Object obj, Object... objArr) {
        try {
            return c(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public final boolean a(Object obj) {
        return a(obj.getClass()) != null;
    }

    public final Object b(Object obj, Object... objArr) {
        try {
            return d(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
