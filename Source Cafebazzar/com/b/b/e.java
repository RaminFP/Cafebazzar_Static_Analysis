package com.b.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class e {
    String a;
    private int b;
    private long c;
    private String d;
    private String e;
    private Throwable f;

    public e(int i, long j, String str, String str2, String str3, Throwable th) {
        this.b = i;
        this.c = j;
        this.a = str;
        this.d = str2;
        this.e = str3;
        this.f = th;
    }

    public final byte[] a() {
        Throwable th;
        Closeable closeable = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Closeable dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                byte[] bytes;
                dataOutputStream.writeShort(this.b);
                dataOutputStream.writeLong(this.c);
                dataOutputStream.writeUTF(this.a);
                dataOutputStream.writeUTF(this.d);
                dataOutputStream.writeUTF(this.e);
                if (this.f != null) {
                    if (this.a == "uncaught") {
                        dataOutputStream.writeByte(3);
                    } else {
                        dataOutputStream.writeByte(2);
                    }
                    dataOutputStream.writeByte(2);
                    StringBuilder stringBuilder = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (Object append : this.f.getStackTrace()) {
                        stringBuilder.append(append);
                        stringBuilder.append(property);
                    }
                    if (this.f.getCause() != null) {
                        stringBuilder.append(property);
                        stringBuilder.append("Caused by: ");
                        for (Object append2 : this.f.getCause().getStackTrace()) {
                            stringBuilder.append(append2);
                            stringBuilder.append(property);
                        }
                    }
                    bytes = stringBuilder.toString().getBytes();
                    dataOutputStream.writeInt(bytes.length);
                    dataOutputStream.write(bytes);
                } else {
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.flush();
                bytes = byteArrayOutputStream.toByteArray();
                bj.a(dataOutputStream);
                return bytes;
            } catch (IOException e) {
                closeable = dataOutputStream;
                bj.a(closeable);
                return new byte[0];
            } catch (Throwable th2) {
                Throwable th3 = th2;
                closeable = dataOutputStream;
                th = th3;
                bj.a(closeable);
                throw th;
            }
        } catch (IOException e2) {
            bj.a(closeable);
            return new byte[0];
        } catch (Throwable th4) {
            th = th4;
            bj.a(closeable);
            throw th;
        }
    }
}
