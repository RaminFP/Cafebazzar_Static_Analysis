package com.b.b;

import android.os.Looper;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

public class t {
    static final String a = t.class.getSimpleName();
    String b;
    long c;
    int d;
    File e;

    public t() {
        this.b = null;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.b = UUID.randomUUID().toString();
        this.e = ah.a.b.getFileStreamPath(".flurrydatasenderblock." + this.b);
    }

    public t(String str) {
        this.b = null;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.b = str;
        this.e = ah.a.b.getFileStreamPath(".flurrydatasenderblock." + this.b);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(byte[] r9) {
        /*
        r8 = this;
        r5 = 6;
        r1 = 1;
        r0 = 0;
        r2 = 0;
        r3 = android.os.Looper.myLooper();
        r4 = android.os.Looper.getMainLooper();
        if (r3 != r4) goto L_0x0015;
    L_0x000e:
        r3 = a;
        r4 = "setData(byte[]) running on the MAIN thread!";
        com.b.b.ba.a(r5, r3, r4);
    L_0x0015:
        r3 = 4;
        r4 = a;
        r5 = new java.lang.StringBuilder;
        r6 = "Writing FlurryDataSenderBlockInfo: ";
        r5.<init>(r6);
        r6 = r8.e;
        r6 = r6.getAbsolutePath();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.b.b.ba.a(r3, r4, r5);
        r3 = r8.e;	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r3 = com.b.b.aw.a(r3);	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        if (r3 != 0) goto L_0x003c;
    L_0x0038:
        com.b.b.bj.a(r0);
    L_0x003b:
        return r2;
    L_0x003c:
        r3 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r5 = r8.e;	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0060, all -> 0x0081 }
        r0 = r9.length;	 Catch:{ Throwable -> 0x0078, all -> 0x0072 }
        r3.writeShort(r0);	 Catch:{ Throwable -> 0x0078, all -> 0x0072 }
        r3.write(r9);	 Catch:{ Throwable -> 0x0078, all -> 0x0072 }
        r4 = 0;
        r3.writeShort(r4);	 Catch:{ Throwable -> 0x0078, all -> 0x0072 }
        r8.d = r0;	 Catch:{ Throwable -> 0x007c, all -> 0x0072 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x007c, all -> 0x0072 }
        r8.c = r4;	 Catch:{ Throwable -> 0x007c, all -> 0x0072 }
        com.b.b.bj.a(r3);
        r2 = r1;
        goto L_0x003b;
    L_0x0060:
        r1 = move-exception;
        r7 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r7;
    L_0x0065:
        r3 = 6;
        r4 = a;	 Catch:{ all -> 0x007e }
        r5 = "";
        com.b.b.ba.a(r3, r4, r5, r0);	 Catch:{ all -> 0x007e }
        com.b.b.bj.a(r2);
        r2 = r1;
        goto L_0x003b;
    L_0x0072:
        r1 = move-exception;
        r0 = r3;
    L_0x0074:
        com.b.b.bj.a(r0);
        throw r1;
    L_0x0078:
        r0 = move-exception;
        r1 = r2;
    L_0x007a:
        r2 = r3;
        goto L_0x0065;
    L_0x007c:
        r0 = move-exception;
        goto L_0x007a;
    L_0x007e:
        r1 = move-exception;
        r0 = r2;
        goto L_0x0074;
    L_0x0081:
        r1 = move-exception;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.b.t.a(byte[]):boolean");
    }

    public final byte[] a() {
        Throwable th;
        Throwable th2;
        Closeable closeable;
        Throwable th3;
        Closeable closeable2 = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ba.a(6, a, "getData() running on the MAIN thread!");
        }
        if (this.e.exists()) {
            ba.a(4, a, "Reading FlurryDataSenderBlockInfo: " + this.e.getAbsolutePath());
            Closeable dataInputStream;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(this.e));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        bj.a(dataInputStream);
                        return closeable2;
                    }
                    byte[] bArr = new byte[readUnsignedShort];
                    try {
                        dataInputStream.readFully(bArr);
                        dataInputStream.readUnsignedShort();
                        bj.a(dataInputStream);
                        return bArr;
                    } catch (Throwable th22) {
                        th = th22;
                        closeable = bArr;
                        th3 = th;
                        try {
                            ba.a(6, a, "Error when loading persistent file", th3);
                            bj.a(dataInputStream);
                            return closeable;
                        } catch (Throwable th4) {
                            th22 = th4;
                            closeable2 = dataInputStream;
                            bj.a(closeable2);
                            throw th22;
                        }
                    }
                } catch (Throwable th222) {
                    th = th222;
                    closeable = closeable2;
                    th3 = th;
                    ba.a(6, a, "Error when loading persistent file", th3);
                    bj.a(dataInputStream);
                    return closeable;
                }
            } catch (Throwable th5) {
                th222 = th5;
                bj.a(closeable2);
                throw th222;
            }
        }
        ba.a(4, a, "Agent cache file doesn't exist.");
        return closeable2;
    }
}
