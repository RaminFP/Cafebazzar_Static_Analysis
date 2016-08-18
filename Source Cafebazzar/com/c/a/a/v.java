package com.c.a.a;

import d.ac;
import d.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class v {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final Charset c = Charset.forName("UTF-8");

    public static int a(String str) {
        return "http".equals(str) ? 80 : "https".equals(str) ? 443 : -1;
    }

    private static int a(String str, int i) {
        return i != -1 ? i : a(str);
    }

    public static int a(URI uri) {
        return a(uri.getScheme(), uri.getPort());
    }

    public static int a(URL url) {
        return a(url.getProtocol(), url.getPort());
    }

    public static k a(k kVar) {
        try {
            return k.a(MessageDigest.getInstance("SHA-1").digest(kVar.d()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static List a(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List a(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Map a(Map map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new w(str, true);
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Closeable closeable, Closeable closeable2) {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean a(ac acVar, int i, TimeUnit timeUnit) {
        try {
            return b(acVar, 100, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object[] a(Class cls, Object[] objArr, Object[] objArr2) {
        List arrayList = new ArrayList();
        for (Object obj : objArr) {
            for (Object obj2 : objArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
    }

    public static String b(String str) {
        Object e;
        try {
            return k.a(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).b();
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public static boolean b(d.ac r12, int r13, java.util.concurrent.TimeUnit r14) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0068 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = java.lang.System.nanoTime();
        r0 = r12.j_();
        r0 = r0.n_();
        if (r0 == 0) goto L_0x0050;
    L_0x0013:
        r0 = r12.j_();
        r0 = r0.c();
        r0 = r0 - r6;
    L_0x001c:
        r4 = r12.j_();
        r8 = (long) r13;
        r8 = r14.toNanos(r8);
        r8 = java.lang.Math.min(r0, r8);
        r8 = r8 + r6;
        r4.a(r8);
        r4 = new d.f;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r4.<init>();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
    L_0x0032:
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r8 = r12.a(r4, r8);	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r10 = -1;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        if (r5 == 0) goto L_0x0052;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
    L_0x003e:
        r4.r();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        goto L_0x0032;
    L_0x0042:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0068;
    L_0x0047:
        r0 = r12.j_();
        r0.o_();
    L_0x004e:
        r0 = 0;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r2;
        goto L_0x001c;
    L_0x0052:
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x005f;
    L_0x0056:
        r0 = r12.j_();
        r0.o_();
    L_0x005d:
        r0 = 1;
        goto L_0x004f;
    L_0x005f:
        r2 = r12.j_();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x005d;
    L_0x0068:
        r2 = r12.j_();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x004e;
    L_0x0071:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x007e;
    L_0x0076:
        r0 = r12.j_();
        r0.o_();
    L_0x007d:
        throw r4;
    L_0x007e:
        r2 = r12.j_();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.v.b(d.ac, int, java.util.concurrent.TimeUnit):boolean");
    }
}
