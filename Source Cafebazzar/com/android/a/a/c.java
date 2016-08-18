package com.android.a.a;

import android.os.SystemClock;
import com.android.a.b;
import com.android.a.z;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements b {
    private final Map a;
    private long b;
    private final File c;
    private final int d;

    public c(File file) {
        this(file, 5242880);
    }

    private c(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = 5242880;
    }

    static int a(InputStream inputStream) {
        return (((e(inputStream) | 0) | (e(inputStream) << 8)) | (e(inputStream) << 16)) | (e(inputStream) << 24);
    }

    static void a(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, d dVar) {
        if (this.a.containsKey(str)) {
            d dVar2 = (d) this.a.get(str);
            this.b = (dVar.a - dVar2.a) + this.b;
        } else {
            this.b += dVar.a;
        }
        this.a.put(str, dVar);
    }

    private static byte[] a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long b(InputStream inputStream) {
        return (((((((0 | (((long) e(inputStream)) & 255)) | ((((long) e(inputStream)) & 255) << 8)) | ((((long) e(inputStream)) & 255) << 16)) | ((((long) e(inputStream)) & 255) << 24)) | ((((long) e(inputStream)) & 255) << 32)) | ((((long) e(inputStream)) & 255) << 40)) | ((((long) e(inputStream)) & 255) << 48)) | ((((long) e(inputStream)) & 255) << 56);
    }

    private void b(String str) {
        synchronized (this) {
            boolean delete = d(str).delete();
            d dVar = (d) this.a.get(str);
            if (dVar != null) {
                this.b -= dVar.a;
                this.a.remove(str);
            }
            if (!delete) {
                z.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
        }
    }

    static String c(InputStream inputStream) {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    private static String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private File d(String str) {
        return new File(this.c, c(str));
    }

    static Map d(InputStream inputStream) {
        int a = a(inputStream);
        Map emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public final com.android.a.c a(String str) {
        com.android.a.c cVar;
        e eVar;
        IOException e;
        e eVar2;
        Throwable th;
        synchronized (this) {
            d dVar = (d) this.a.get(str);
            if (dVar == null) {
                cVar = null;
            } else {
                File d = d(str);
                try {
                    eVar = new e(new FileInputStream(d));
                    try {
                        d.a((InputStream) eVar);
                        byte[] a = a((InputStream) eVar, (int) (d.length() - ((long) eVar.a)));
                        com.android.a.c cVar2 = new com.android.a.c();
                        cVar2.a = a;
                        cVar2.b = dVar.c;
                        cVar2.c = dVar.d;
                        cVar2.d = dVar.e;
                        cVar2.e = dVar.f;
                        cVar2.f = dVar.g;
                        try {
                            eVar.close();
                            cVar = cVar2;
                        } catch (IOException e2) {
                            cVar = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        eVar2 = eVar;
                        try {
                            z.b("%s: %s", d.getAbsolutePath(), e.toString());
                            b(str);
                            if (eVar2 != null) {
                                try {
                                    eVar2.close();
                                } catch (IOException e4) {
                                    cVar = null;
                                }
                            }
                            cVar = null;
                            return cVar;
                        } catch (Throwable th2) {
                            th = th2;
                            eVar = eVar2;
                            if (eVar != null) {
                                try {
                                    eVar.close();
                                } catch (IOException e5) {
                                    cVar = null;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (eVar != null) {
                            eVar.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    eVar2 = null;
                    z.b("%s: %s", d.getAbsolutePath(), e.toString());
                    b(str);
                    if (eVar2 != null) {
                        eVar2.close();
                    }
                    cVar = null;
                    return cVar;
                } catch (Throwable th4) {
                    th = th4;
                    eVar = null;
                    if (eVar != null) {
                        eVar.close();
                    }
                    throw th;
                }
            }
        }
        return cVar;
    }

    public final void a() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        synchronized (this) {
            if (this.c.exists()) {
                File[] listFiles = this.c.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                d a = d.a((InputStream) fileInputStream);
                                a.a = file.length();
                                a(a.b, a);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                            } catch (IOException e2) {
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileInputStream2 = fileInputStream;
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            }
                        } catch (IOException e4) {
                            fileInputStream = null;
                            if (file != null) {
                                file.delete();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }
            } else if (!this.c.mkdirs()) {
                z.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
        }
        return;
        throw th;
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
    }

    public final void a(String str, com.android.a.c cVar) {
        int i = 0;
        synchronized (this) {
            int length = cVar.a.length;
            if (this.b + ((long) length) >= ((long) this.d)) {
                int i2;
                if (z.b) {
                    z.a("Pruning old cache entries.", new Object[0]);
                }
                long j = this.b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    d dVar = (d) ((Entry) it.next()).getValue();
                    if (d(dVar.b).delete()) {
                        this.b -= dVar.a;
                    } else {
                        z.b("Could not delete cache entry for key=%s, filename=%s", dVar.b, c(dVar.b));
                    }
                    it.remove();
                    i2 = i + 1;
                    if (((float) (this.b + ((long) length))) >= ((float) this.d) * 0.9f) {
                        i = i2;
                    }
                }
                i2 = i;
                if (z.b) {
                    z.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File d = d(str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(d);
                d dVar2 = new d(str, cVar);
                dVar2.a(fileOutputStream);
                fileOutputStream.write(cVar.a);
                fileOutputStream.close();
                a(str, dVar2);
            } catch (IOException e) {
                if (!d.delete()) {
                    z.b("Could not clean up file %s", d.getAbsolutePath());
                }
            }
        }
    }
}
