package com.b.b;

import android.os.Looper;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class v {
    static final Integer a = Integer.valueOf(50);
    private static final String d = v.class.getSimpleName();
    String b;
    LinkedHashMap c;

    public v(String str) {
        b(str);
    }

    private void a() {
        synchronized (this) {
            List linkedList = new LinkedList(this.c.keySet());
            a(ah.a.b.getFileStreamPath(".FlurrySenderIndex.info." + this.b));
            if (!linkedList.isEmpty()) {
                a(this.b, linkedList);
            }
        }
    }

    private boolean a(File file) {
        boolean z;
        synchronized (this) {
            z = false;
            if (file != null) {
                if (file.exists()) {
                    ba.a(4, d, "Trying to delete persistence file : " + file.getAbsolutePath());
                    z = file.delete();
                    if (z) {
                        ba.a(4, d, "Deleted persistence file");
                    } else {
                        ba.a(6, d, "Cannot delete persistence file");
                    }
                }
            }
        }
        return z;
    }

    private boolean a(String str, List list) {
        Closeable dataOutputStream;
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ba.a(6, d, "saveToFile(byte[], ID) running on the MAIN thread!");
            }
            File fileStreamPath = ah.a.b.getFileStreamPath(".FlurrySenderIndex.info." + str);
            try {
                if (aw.a(fileStreamPath)) {
                    dataOutputStream = new DataOutputStream(new FileOutputStream(fileStreamPath));
                    try {
                        dataOutputStream.writeShort(list.size());
                        for (int i = 0; i < list.size(); i++) {
                            byte[] bytes = ((String) list.get(i)).getBytes();
                            int length = bytes.length;
                            ba.a(4, d, "write iter " + i + " dataLength = " + length);
                            dataOutputStream.writeShort(length);
                            dataOutputStream.write(bytes);
                        }
                        dataOutputStream.writeShort(0);
                        z = true;
                        bj.a(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        bj.a(dataOutputStream);
                        throw th;
                    }
                } else {
                    bj.a(null);
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                bj.a(dataOutputStream);
                throw th;
            }
        }
        return z;
    }

    private void b(String str) {
        this.c = new LinkedHashMap();
        this.b = str + "Main";
        List<String> e = e(this.b);
        if (e != null) {
            for (String str2 : e) {
                List e2 = e(str2);
                if (e2 != null) {
                    this.c.put(str2, e2);
                }
            }
        }
    }

    private static boolean c(String str) {
        t tVar = new t(str);
        if (tVar.e.exists()) {
            if (tVar.e.delete()) {
                ba.a(4, t.a, "Deleted persistence file");
                tVar.c = -1;
                tVar.d = -1;
                return true;
            }
            ba.a(6, t.a, "Cannot delete persistence file");
        }
        return false;
    }

    private boolean d(String str) {
        boolean a;
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ba.a(6, d, "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
            }
            File fileStreamPath = ah.a.b.getFileStreamPath(".FlurrySenderIndex.info." + str);
            List a2 = a(str);
            if (a2 != null) {
                ba.a(4, d, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a2.size());
                for (int i = 0; i < a2.size(); i++) {
                    String str2 = (String) a2.get(i);
                    c(str2);
                    ba.a(4, d, "discardOutdatedBlocksForDataKey: removed block = " + str2);
                }
            }
            this.c.remove(str);
            a = a(fileStreamPath);
            a();
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List e(java.lang.String r11) {
        /*
        r10 = this;
        r1 = 0;
        monitor-enter(r10);
        r0 = android.os.Looper.myLooper();	 Catch:{ all -> 0x0098 }
        r2 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0098 }
        if (r0 != r2) goto L_0x0014;
    L_0x000c:
        r0 = 6;
        r2 = d;	 Catch:{ all -> 0x0098 }
        r3 = "readFromFile(byte[], ID) running on the MAIN thread!";
        com.b.b.ba.a(r0, r2, r3);	 Catch:{ all -> 0x0098 }
    L_0x0014:
        r0 = com.b.b.ah.a;	 Catch:{ all -> 0x0098 }
        r0 = r0.b;	 Catch:{ all -> 0x0098 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0098 }
        r3 = ".FlurrySenderIndex.info.";
        r2.<init>(r3);	 Catch:{ all -> 0x0098 }
        r2 = r2.append(r11);	 Catch:{ all -> 0x0098 }
        r2 = r2.toString();	 Catch:{ all -> 0x0098 }
        r0 = r0.getFileStreamPath(r2);	 Catch:{ all -> 0x0098 }
        r2 = r0.exists();	 Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x00a1;
    L_0x0031:
        r2 = new java.io.DataInputStream;	 Catch:{ Throwable -> 0x0089, all -> 0x00b9 }
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0089, all -> 0x00b9 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0089, all -> 0x00b9 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0089, all -> 0x00b9 }
        r3 = r2.readUnsignedShort();	 Catch:{ Throwable -> 0x00ab, all -> 0x009b }
        if (r3 != 0) goto L_0x0046;
    L_0x0041:
        com.b.b.bj.a(r2);	 Catch:{ all -> 0x0098 }
    L_0x0044:
        monitor-exit(r10);
        return r1;
    L_0x0046:
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00ab, all -> 0x009b }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x00ab, all -> 0x009b }
        r1 = 0;
    L_0x004c:
        if (r1 >= r3) goto L_0x0081;
    L_0x004e:
        r4 = r2.readUnsignedShort();	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r5 = 4;
        r6 = d;	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r8 = "read iter ";
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r7 = r7.append(r1);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r8 = " dataLength = ";
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r7 = r7.append(r4);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        com.b.b.ba.a(r5, r6, r7);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r4 = new byte[r4];	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r2.readFully(r4);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r0.add(r5);	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        r1 = r1 + 1;
        goto L_0x004c;
    L_0x0081:
        r2.readUnsignedShort();	 Catch:{ Throwable -> 0x00b1, all -> 0x009b }
        com.b.b.bj.a(r2);	 Catch:{ all -> 0x0098 }
    L_0x0087:
        r1 = r0;
        goto L_0x0044;
    L_0x0089:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x008c:
        r3 = 6;
        r4 = d;	 Catch:{ all -> 0x00b6 }
        r5 = "Error when loading persistent file";
        com.b.b.ba.a(r3, r4, r5, r2);	 Catch:{ all -> 0x00b6 }
        com.b.b.bj.a(r1);	 Catch:{ all -> 0x0098 }
        goto L_0x0087;
    L_0x0098:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x009b:
        r0 = move-exception;
    L_0x009c:
        r1 = r2;
    L_0x009d:
        com.b.b.bj.a(r1);	 Catch:{ all -> 0x0098 }
        throw r0;	 Catch:{ all -> 0x0098 }
    L_0x00a1:
        r0 = 5;
        r2 = d;	 Catch:{ all -> 0x0098 }
        r3 = "Agent cache file doesn't exist.";
        com.b.b.ba.a(r0, r2, r3);	 Catch:{ all -> 0x0098 }
        r0 = r1;
        goto L_0x0087;
    L_0x00ab:
        r0 = move-exception;
        r9 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r9;
        goto L_0x008c;
    L_0x00b1:
        r1 = move-exception;
        r9 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x008c;
    L_0x00b6:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009c;
    L_0x00b9:
        r0 = move-exception;
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.b.v.e(java.lang.String):java.util.List");
    }

    public final List a(String str) {
        return (List) this.c.get(str);
    }

    public final void a(t tVar, String str) {
        Object obj = null;
        synchronized (this) {
            List linkedList;
            ba.a(4, d, "addBlockInfo");
            String str2 = tVar.b;
            List list = (List) this.c.get(str);
            if (list == null) {
                ba.a(4, d, "New Data Key");
                linkedList = new LinkedList();
                obj = 1;
            } else {
                linkedList = list;
            }
            linkedList.add(str2);
            if (linkedList.size() > a.intValue()) {
                c((String) linkedList.get(0));
                linkedList.remove(0);
            }
            this.c.put(str, linkedList);
            a(str, linkedList);
            if (obj != null) {
                a();
            }
        }
    }

    public final boolean a(String str, String str2) {
        List list = (List) this.c.get(str2);
        boolean z = false;
        if (list != null) {
            c(str);
            z = list.remove(str);
        }
        if (list == null || list.isEmpty()) {
            d(str2);
            return z;
        }
        this.c.put(str2, list);
        a(str2, list);
        return z;
    }
}
