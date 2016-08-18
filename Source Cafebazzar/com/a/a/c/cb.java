package com.a.a.c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import b.a.a.a.a.b.y;
import b.a.a.a.f;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class cb {
    private static final b a = b.a("0");
    private static final b b = b.a("Unity");

    private static int a() {
        return ((f.b(1, a) + 0) + f.b(2, a)) + f.b(3, 0);
    }

    private static int a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((f.b(1, f) + 0) + f.f(2, i)) + f.b(3, z)) + f.d(4, i2)) + f.b(5, j)) + f.b(6, j2);
    }

    private static int a(y yVar, String str) {
        return f.e(1, yVar.h) + f.b(2, b.a(str));
    }

    private static int a(b bVar) {
        return f.b(1, bVar) + 0;
    }

    private static int a(b bVar, b bVar2) {
        int b = ((f.b(1, 0) + 0) + f.b(2, 0)) + f.b(3, bVar);
        return bVar2 != null ? b + f.b(4, bVar2) : b;
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int b = (stackTraceElement.isNativeMethod() ? f.b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0 : f.b(1, 0) + 0) + f.b(2, b.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += f.b(3, b.a(stackTraceElement.getFileName()));
        }
        int b2 = (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) ? b : b + f.b(4, (long) stackTraceElement.getLineNumber());
        return f.d(5, z ? 2 : 0) + b2;
    }

    private static int a(String str, String str2) {
        int b = f.b(1, b.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + f.b(2, b.a(str2));
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int b = f.b(1, b.a(thread.getName())) + f.d(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = a(a, z);
            b += a2 + (f.a(3) + f.c(a2));
        }
        return b;
    }

    private static int a(Throwable th, int i, int i2) {
        int i3 = 0;
        int b = f.b(1, b.a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += f.b(3, b.a(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i4 = 0;
        while (i4 < length) {
            int a = a(stackTrace[i4], true);
            i4++;
            b += a + (f.a(4) + f.c(a));
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < i2) {
            i3 = a(cause, i + 1, i2);
            return b + (i3 + (f.a(6) + f.c(i3)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        return b + f.d(7, i3);
    }

    private static int a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List list, int i, b bVar, b bVar2) {
        int a = a(thread, stackTraceElementArr, 4, true);
        int a2 = f.a(1);
        int c = f.c(a);
        int length = threadArr.length;
        c = (a + (a2 + c)) + 0;
        for (a2 = 0; a2 < length; a2++) {
            a = a(threadArr[a2], (StackTraceElement[]) list.get(a2), 0, false);
            c += a + (f.a(1) + f.c(a));
        }
        a = a(th, 1, i);
        a2 = f.a(2);
        length = f.c(a);
        int a3 = a();
        int a4 = f.a(3);
        int c2 = f.c(a3);
        int a5 = a(bVar, bVar2);
        return (((a + (a2 + length)) + c) + ((a4 + c2) + a3)) + ((f.a(3) + f.c(a5)) + a5);
    }

    private static int a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List list, int i, b bVar, b bVar2, Map map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int i3;
        int a = a(th, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2);
        a = (a + (f.a(1) + f.c(a))) + 0;
        if (map != null) {
            int i4 = a;
            for (Entry entry : map.entrySet()) {
                a = a((String) entry.getKey(), (String) entry.getValue());
                i4 = (a + (f.a(2) + f.c(a))) + i4;
            }
            i3 = i4;
        } else {
            i3 = a;
        }
        if (runningAppProcessInfo != null) {
            a = f.b(3, runningAppProcessInfo.importance != 100) + i3;
        } else {
            a = i3;
        }
        return a + f.d(4, i2);
    }

    private static b a(String str) {
        return str == null ? null : b.a(str);
    }

    private static void a(f fVar, int i, StackTraceElement stackTraceElement, boolean z) {
        int i2 = 4;
        fVar.g(i, 2);
        fVar.b(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            fVar.a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            fVar.a(1, 0);
        }
        fVar.a(2, b.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            fVar.a(3, b.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            fVar.a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        fVar.a(5, i2);
    }

    public static void a(f fVar, long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List list, Map map, bb bbVar, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, float f, int i2, boolean z, long j2, long j3) {
        b a = b.a(str2);
        b a2 = str3 == null ? null : b.a(str3.replace("-", ""));
        b a3 = bbVar.a();
        if (a3 == null) {
            f.a().a("CrashlyticsCore", "No log data to include with this event.");
        }
        bbVar.b();
        fVar.g(10, 2);
        int b = f.b(1, j);
        int b2 = f.b(2, b.a(str));
        int a4 = a(th, thread, stackTraceElementArr, threadArr, list, 8, a, a2, map, runningAppProcessInfo, i);
        int a5 = f.a(3);
        int c = f.c(a4);
        int a6 = a(f, i2, z, i, j2, j3);
        a4 = ((a4 + (a5 + c)) + ((b + 0) + b2)) + ((f.a(5) + f.c(a6)) + a6);
        if (a3 != null) {
            a5 = f.b(1, a3);
            a4 += a5 + (f.a(6) + f.c(a5));
        }
        fVar.b(a4);
        fVar.a(1, j);
        fVar.a(2, b.a(str));
        fVar.g(3, 2);
        fVar.b(a(th, thread, stackTraceElementArr, threadArr, list, 8, a, a2, map, runningAppProcessInfo, i));
        fVar.g(1, 2);
        fVar.b(a(th, thread, stackTraceElementArr, threadArr, list, 8, a, a2));
        a(fVar, thread, stackTraceElementArr, 4, true);
        c = threadArr.length;
        for (a5 = 0; a5 < c; a5++) {
            a(fVar, threadArr[a5], (StackTraceElement[]) list.get(a5), 0, false);
        }
        a(fVar, th, 1, 8, 2);
        fVar.g(3, 2);
        fVar.b(a());
        fVar.a(1, a);
        fVar.a(2, a);
        fVar.a(3, 0);
        fVar.g(4, 2);
        fVar.b(a(a, a2));
        fVar.a(1, 0);
        fVar.a(2, 0);
        fVar.a(3, a);
        if (a2 != null) {
            fVar.a(4, a2);
        }
        if (!(map == null || map.isEmpty())) {
            for (Entry entry : map.entrySet()) {
                fVar.g(2, 2);
                fVar.b(a((String) entry.getKey(), (String) entry.getValue()));
                fVar.a(1, b.a((String) entry.getKey()));
                String str4 = (String) entry.getValue();
                if (str4 == null) {
                    str4 = "";
                }
                fVar.a(2, b.a(str4));
            }
        }
        if (runningAppProcessInfo != null) {
            fVar.a(3, runningAppProcessInfo.importance != 100);
        }
        fVar.a(4, i);
        fVar.g(5, 2);
        fVar.b(a(f, i2, z, i, j2, j3));
        fVar.a(1, f);
        fVar.c(2, i2);
        fVar.a(3, z);
        fVar.a(4, i);
        fVar.a(5, j2);
        fVar.a(6, j3);
        if (a3 != null) {
            fVar.g(6, 2);
            fVar.b(f.b(1, a3));
            fVar.a(1, a3);
        }
    }

    public static void a(f fVar, String str, int i, String str2, int i2, long j, long j2, boolean z, Map map, int i3, String str3, String str4) {
        int i4;
        b a = b.a(str);
        b a2 = a(str2);
        b a3 = a(str4);
        b a4 = a(str3);
        fVar.g(9, 2);
        int b = (((((a2 == null ? 0 : f.b(4, a2)) + ((f.b(1, a) + 0) + f.e(3, i))) + f.d(5, i2)) + f.b(6, j)) + f.b(7, j2)) + f.b(10, z);
        if (map != null) {
            i4 = b;
            for (Entry entry : map.entrySet()) {
                b = a((y) entry.getKey(), (String) entry.getValue());
                i4 = (b + (f.a(11) + f.c(b))) + i4;
            }
        } else {
            i4 = b;
        }
        int d = f.d(12, i3);
        fVar.b((a3 == null ? 0 : f.b(14, a3)) + ((a4 == null ? 0 : f.b(13, a4)) + (i4 + d)));
        fVar.a(1, a);
        fVar.b(3, i);
        fVar.a(4, a2);
        fVar.a(5, i2);
        fVar.a(6, j);
        fVar.a(7, j2);
        fVar.a(10, z);
        for (Entry entry2 : map.entrySet()) {
            fVar.g(11, 2);
            fVar.b(a((y) entry2.getKey(), (String) entry2.getValue()));
            fVar.b(1, ((y) entry2.getKey()).h);
            fVar.a(2, b.a((String) entry2.getValue()));
        }
        fVar.a(12, i3);
        if (a4 != null) {
            fVar.a(13, a4);
        }
        if (a3 != null) {
            fVar.a(14, a3);
        }
    }

    public static void a(f fVar, String str, String str2, long j) {
        fVar.a(1, b.a(str2));
        fVar.a(2, b.a(str));
        fVar.a(3, j);
    }

    public static void a(f fVar, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        b a = b.a(str);
        b a2 = a(str2);
        b a3 = a(str3);
        int b = f.b(1, a) + 0;
        if (str2 != null) {
            b += f.b(2, a2);
        }
        if (str3 != null) {
            b += f.b(3, a3);
        }
        fVar.g(6, 2);
        fVar.b(b);
        fVar.a(1, a);
        if (str2 != null) {
            fVar.a(2, a2);
        }
        if (str3 != null) {
            fVar.a(3, a3);
        }
    }

    public static void a(f fVar, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        b a = b.a(str);
        b a2 = b.a(str2);
        b a3 = b.a(str3);
        b a4 = b.a(str4);
        b a5 = b.a(str5);
        b a6 = str6 != null ? b.a(str6) : null;
        fVar.g(7, 2);
        int b = f.b(1, a);
        int b2 = f.b(2, a3);
        int b3 = f.b(3, a4);
        int a7 = a(a2);
        b = ((((b + 0) + b2) + b3) + ((f.a(5) + f.c(a7)) + a7)) + f.b(6, a5);
        if (a6 != null) {
            b = (b + f.b(8, b)) + f.b(9, a6);
        }
        fVar.b(b + f.e(10, i));
        fVar.a(1, a);
        fVar.a(2, a3);
        fVar.a(3, a4);
        fVar.g(5, 2);
        fVar.b(a(a2));
        fVar.a(1, a2);
        fVar.a(6, a5);
        if (a6 != null) {
            fVar.a(8, b);
            fVar.a(9, a6);
        }
        fVar.b(10, i);
    }

    private static void a(f fVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        fVar.g(1, 2);
        fVar.b(a(thread, stackTraceElementArr, i, z));
        fVar.a(1, b.a(thread.getName()));
        fVar.a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            a(fVar, 3, a, z);
        }
    }

    private static void a(f fVar, Throwable th, int i, int i2, int i3) {
        int i4 = 0;
        fVar.g(i3, 2);
        fVar.b(a(th, 1, i2));
        fVar.a(1, b.a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            fVar.a(3, b.a(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            a(fVar, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < i2) {
            a(fVar, cause, i + 1, i2, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i4++;
        }
        fVar.a(7, i4);
    }

    public static void a(f fVar, boolean z) {
        b a = b.a(VERSION.RELEASE);
        b a2 = b.a(VERSION.CODENAME);
        fVar.g(8, 2);
        fVar.b((((f.e(1, 3) + 0) + f.b(2, a)) + f.b(3, a2)) + f.b(4, z));
        fVar.b(1, 3);
        fVar.a(2, a);
        fVar.a(3, a2);
        fVar.a(4, z);
    }
}
