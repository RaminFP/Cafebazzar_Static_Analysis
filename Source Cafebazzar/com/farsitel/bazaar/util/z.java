package com.farsitel.bazaar.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public final class z {
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c = a.multiply(b);
    public static final BigInteger d = a.multiply(c);
    public static final BigInteger e = a.multiply(d);
    public static final BigInteger f = a.multiply(e);
    public static final BigInteger g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger h = a.multiply(g);
    public static final File[] i = new File[0];

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        a = valueOf;
        b = valueOf.multiply(a);
    }

    public static void a(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                a(file, file2, true);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    private static void a(File file, File file2, boolean z) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2;
        Object obj;
        FileChannel channel;
        Object obj2;
        Object obj3;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        Closeable closeable3 = null;
        Closeable closeable4 = null;
        try {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                closeable2 = null;
                obj = fileInputStream;
                aa.a(closeable, closeable4, closeable2, closeable3);
                throw th;
            }
            try {
                ReadableByteChannel channel2 = fileInputStream.getChannel();
                try {
                    channel = fileOutputStream.getChannel();
                } catch (Throwable th3) {
                    closeable = null;
                    th = th3;
                    obj2 = channel2;
                    obj3 = fileOutputStream;
                    obj = fileInputStream;
                    aa.a(closeable, closeable4, closeable2, closeable3);
                    throw th;
                }
                try {
                    long size = channel2.size();
                    long j = 0;
                    while (j < size) {
                        long j2 = size - j;
                        if (j2 > 31457280) {
                            j2 = 31457280;
                        }
                        j2 = channel.transferFrom(channel2, j, j2);
                        if (j2 == 0) {
                            break;
                        }
                        j += j2;
                    }
                    aa.a(channel, fileOutputStream, channel2, fileInputStream);
                    long length = file.length();
                    j = file2.length();
                    if (length != j) {
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + j);
                    } else if (z) {
                        file2.setLastModified(file.lastModified());
                    }
                } catch (Throwable th32) {
                    Object obj4 = channel;
                    th = th32;
                    obj2 = channel2;
                    obj3 = fileOutputStream;
                    obj = fileInputStream;
                    aa.a(closeable, closeable4, closeable2, closeable3);
                    throw th;
                }
            } catch (Throwable th322) {
                closeable = null;
                th = th322;
                closeable2 = null;
                obj3 = fileOutputStream;
                obj = fileInputStream;
                aa.a(closeable, closeable4, closeable2, closeable3);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable2 = null;
            closeable = null;
            aa.a(closeable, closeable4, closeable2, closeable3);
            throw th;
        }
    }
}
