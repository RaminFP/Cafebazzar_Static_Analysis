package com.b.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class w {
    private static final String b = w.class.getSimpleName();
    byte[] a;

    public w(x xVar) {
        Throwable th;
        Closeable closeable = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Closeable dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                int i;
                int i2;
                dataOutputStream.writeShort(1);
                dataOutputStream.writeUTF(xVar.a);
                dataOutputStream.writeLong(xVar.b);
                dataOutputStream.writeLong(xVar.c);
                dataOutputStream.writeLong(xVar.d);
                dataOutputStream.writeUTF(xVar.e);
                dataOutputStream.writeUTF(xVar.f);
                dataOutputStream.writeByte(xVar.g);
                dataOutputStream.writeUTF(xVar.h);
                if (xVar.i == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeDouble(a(xVar.i.getLatitude()));
                    dataOutputStream.writeDouble(a(xVar.i.getLongitude()));
                    dataOutputStream.writeFloat(xVar.i.getAccuracy());
                }
                dataOutputStream.writeInt(xVar.j);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(xVar.k);
                if (xVar.l == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeLong(xVar.l.longValue());
                }
                Map map = xVar.m;
                if (map == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(map.size());
                    for (Entry entry : map.entrySet()) {
                        dataOutputStream.writeUTF((String) entry.getKey());
                        dataOutputStream.writeInt(((b) entry.getValue()).a);
                    }
                }
                List<f> list = xVar.n;
                if (list == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(list.size());
                    for (f a : list) {
                        dataOutputStream.write(a.a());
                    }
                }
                dataOutputStream.writeBoolean(xVar.o);
                List list2 = xVar.q;
                if (list2 != null) {
                    i = 0;
                    int i3 = 0;
                    i2 = 0;
                    while (i3 < list2.size()) {
                        int length = ((e) list2.get(i3)).a().length + i;
                        if (length > 160000) {
                            ba.a(5, b, "Error Log size exceeded. No more event details logged.");
                            i = i2;
                            break;
                        }
                        i3++;
                        i2++;
                        i = length;
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                dataOutputStream.writeInt(xVar.p);
                dataOutputStream.writeShort(i);
                for (i2 = 0; i2 < i; i2++) {
                    dataOutputStream.write(((e) list2.get(i2)).a());
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                this.a = byteArrayOutputStream.toByteArray();
                bj.a(dataOutputStream);
            } catch (Throwable e) {
                th = e;
                closeable = dataOutputStream;
                try {
                    ba.a(6, b, "", th);
                    throw th;
                } catch (Throwable th2) {
                    th = th2;
                    bj.a(closeable);
                    throw th;
                }
            } catch (Throwable e2) {
                th = e2;
                closeable = dataOutputStream;
                bj.a(closeable);
                throw th;
            }
        } catch (IOException e3) {
            th = e3;
            ba.a(6, b, "", th);
            throw th;
        } catch (Throwable th3) {
            th = th3;
            bj.a(closeable);
            throw th;
        }
    }

    public w(byte[] bArr) {
        this.a = bArr;
    }

    private static double a(double d) {
        return ((double) Math.round(d * 1000.0d)) / 1000.0d;
    }
}
