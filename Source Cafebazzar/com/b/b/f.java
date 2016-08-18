package com.b.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

public final class f {
    String a;
    long b;
    boolean c;
    boolean d;
    long e;
    private int f;
    private Map g;

    public f(int i, String str, Map map, long j, boolean z) {
        this.f = i;
        this.a = str;
        this.g = map;
        this.b = j;
        this.c = z;
        if (this.c) {
            this.d = false;
        } else {
            this.d = true;
        }
    }

    public final byte[] a() {
        Throwable th;
        Closeable closeable = null;
        Closeable dataOutputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f);
                dataOutputStream.writeUTF(this.a);
                if (this.g == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(this.g.size());
                    for (Entry entry : this.g.entrySet()) {
                        dataOutputStream.writeUTF(bj.a((String) entry.getKey()));
                        dataOutputStream.writeUTF(bj.a((String) entry.getValue()));
                    }
                }
                dataOutputStream.writeLong(this.b);
                dataOutputStream.writeLong(this.e);
                dataOutputStream.flush();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                bj.a(dataOutputStream);
                return toByteArray;
            } catch (IOException e) {
                bj.a(dataOutputStream);
                return new byte[0];
            } catch (Throwable th2) {
                th = th2;
                closeable = dataOutputStream;
                bj.a(closeable);
                throw th;
            }
        } catch (IOException e2) {
            dataOutputStream = null;
            bj.a(dataOutputStream);
            return new byte[0];
        } catch (Throwable th3) {
            th = th3;
            bj.a(closeable);
            throw th;
        }
    }
}
