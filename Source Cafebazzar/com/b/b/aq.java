package com.b.b;

import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class aq {
    private static final String a = aq.class.getSimpleName();
    private static final Set b;
    private static String c;

    static {
        Set hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        b = Collections.unmodifiableSet(hashSet);
    }

    public static String a() {
        Object obj = null;
        synchronized (aq.class) {
            boolean isEmpty;
            try {
                String str;
                isEmpty = TextUtils.isEmpty(c);
                if (isEmpty) {
                    String string = Secure.getString(ah.a.b.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        if (!b.contains(string.toLowerCase(Locale.US))) {
                            obj = 1;
                        }
                    }
                    str = obj == null ? null : "AND" + string;
                    isEmpty = TextUtils.isEmpty(str);
                    if (isEmpty) {
                        str = b();
                        isEmpty = TextUtils.isEmpty(str);
                        if (isEmpty) {
                            str = c();
                            if (TextUtils.isEmpty(str)) {
                                str = "ID" + Long.toString(Double.doubleToLongBits(Math.random()) + ((System.nanoTime() + ((long) (am.a(ah.a.b).hashCode() * 37))) * 37), 16);
                            }
                            isEmpty = TextUtils.isEmpty(str);
                            if (!isEmpty) {
                                isEmpty = ah.a.b.getFileStreamPath(".flurryb.");
                                if (aw.a(isEmpty)) {
                                    a(str, isEmpty);
                                }
                            }
                        }
                    }
                    c = str;
                }
                str = c;
                return str;
            } finally {
                isEmpty = aq.class;
            }
        }
    }

    private static void a(String str, File file) {
        Closeable dataOutputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Closeable closeable = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeUTF(str);
                bj.a(dataOutputStream);
            } catch (Throwable th4) {
                th = th4;
                try {
                    ba.a(6, a, "Error when saving phoneId", th);
                    bj.a(dataOutputStream);
                } catch (Throwable th5) {
                    th2 = th5;
                    closeable = dataOutputStream;
                    th3 = th2;
                    bj.a(closeable);
                    throw th3;
                }
            }
        } catch (Throwable th6) {
            th3 = th6;
            bj.a(closeable);
            throw th3;
        }
    }

    private static String b() {
        Closeable dataInputStream;
        String readUTF;
        Throwable th;
        Closeable closeable = null;
        File fileStreamPath = ah.a.b.getFileStreamPath(".flurryb.");
        if (fileStreamPath != null && fileStreamPath.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    if (1 == dataInputStream.readInt()) {
                        readUTF = dataInputStream.readUTF();
                    }
                    bj.a(dataInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ba.a(6, a, "Error when loading phoneId", th);
                        bj.a(dataInputStream);
                        return readUTF;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = dataInputStream;
                        bj.a(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bj.a(closeable);
                throw th;
            }
        }
        return readUTF;
    }

    private static String c() {
        String readUTF;
        Throwable th;
        Closeable closeable = null;
        File filesDir = ah.a.b.getFilesDir();
        if (filesDir != null) {
            String[] list = filesDir.list(new ar());
            if (!(list == null || list.length == 0)) {
                filesDir = ah.a.b.getFileStreamPath(list[0]);
                if (filesDir != null && filesDir.exists()) {
                    Closeable dataInputStream;
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(filesDir));
                        try {
                            if (46586 == dataInputStream.readUnsignedShort()) {
                                if (2 == dataInputStream.readUnsignedShort()) {
                                    dataInputStream.readUTF();
                                    readUTF = dataInputStream.readUTF();
                                }
                            }
                            bj.a(dataInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ba.a(6, a, "Error when loading phoneId", th);
                                bj.a(dataInputStream);
                                return readUTF;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = dataInputStream;
                                bj.a(closeable);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bj.a(closeable);
                        throw th;
                    }
                }
            }
        }
        return readUTF;
    }
}
