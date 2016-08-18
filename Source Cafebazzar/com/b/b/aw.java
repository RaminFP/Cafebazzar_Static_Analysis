package com.b.b;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class aw {
    private static String a = aw.class.getSimpleName();

    public static boolean a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        ba.a(6, a, "Unable to create persistent dir: " + parentFile);
        return false;
    }

    @Deprecated
    public static String b(File file) {
        StringBuilder stringBuilder;
        Throwable th;
        Closeable closeable = null;
        if (file == null || !file.exists()) {
            ba.a(4, a, "Persistent file doesn't exist.");
            return null;
        }
        ba.a(4, a, "Loading persistent data: " + file.getAbsolutePath());
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                stringBuilder = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                bj.a(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    ba.a(6, a, "Error when loading persistent file", th);
                    bj.a(fileInputStream);
                    stringBuilder = null;
                    return stringBuilder != null ? null : stringBuilder.toString();
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    bj.a(closeable);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bj.a(closeable);
            throw th;
        }
        if (stringBuilder != null) {
        }
    }
}
