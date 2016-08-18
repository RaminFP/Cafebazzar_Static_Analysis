package com.b.b;

import android.os.Build;
import android.os.Build.VERSION;
import com.b.a.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class g {
    private static final String b = g.class.getSimpleName();
    byte[] a = null;

    public g(String str, String str2, String str3, boolean z, long j, long j2, List list, Map map, Map map2, Map map3, long j3) {
        byte[] array;
        Throwable th;
        Closeable closeable;
        try {
            MessageDigest avVar = new av();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, avVar);
            Closeable dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(27);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(a.a());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeShort(map.size() + 1);
                dataOutputStream.writeShort(a.c());
                dataOutputStream.writeUTF(str3);
                if (!map.isEmpty()) {
                    for (Entry entry : map.entrySet()) {
                        dataOutputStream.writeShort(((al) entry.getKey()).c);
                        array = ((ByteBuffer) entry.getValue()).array();
                        dataOutputStream.writeShort(array.length);
                        dataOutputStream.write(array);
                    }
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                dataOutputStream.writeShort(6);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(VERSION.RELEASE);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                dataOutputStream.writeShort(map2 != null ? map2.keySet().size() : 0);
                if (map2 != null) {
                    ba.a(3, b, "sending referrer values because it exists");
                    for (Entry entry2 : map2.entrySet()) {
                        ba.a(3, b, "Referrer Entry:  " + ((String) entry2.getKey()) + "=" + entry2.getValue());
                        dataOutputStream.writeUTF((String) entry2.getKey());
                        ba.a(3, b, "referrer key is :" + ((String) entry2.getKey()));
                        dataOutputStream.writeShort(((List) entry2.getValue()).size());
                        for (String str4 : (List) entry2.getValue()) {
                            dataOutputStream.writeUTF(str4);
                            ba.a(3, b, "referrer value is :" + str4);
                        }
                    }
                }
                dataOutputStream.writeBoolean(false);
                int size = map3 != null ? map3.keySet().size() : 0;
                ba.a(3, b, "optionsMapSize is:  " + size);
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    ba.a(3, b, "sending launch options");
                    for (Entry entry22 : map3.entrySet()) {
                        ba.a(3, b, "Launch Options Key:  " + ((String) entry22.getKey()));
                        dataOutputStream.writeUTF((String) entry22.getKey());
                        dataOutputStream.writeShort(((List) entry22.getValue()).size());
                        for (String str42 : (List) entry22.getValue()) {
                            dataOutputStream.writeUTF(str42);
                            ba.a(3, b, "Launch Options value is :" + str42);
                        }
                    }
                }
                int size2 = list.size();
                dataOutputStream.writeShort(size2);
                for (int i = 0; i < size2; i++) {
                    dataOutputStream.write(((w) list.get(i)).a);
                }
                digestOutputStream.on(false);
                dataOutputStream.write(avVar.a());
                dataOutputStream.close();
                array = byteArrayOutputStream.toByteArray();
                bj.a(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeable = dataOutputStream;
                bj.a(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            bj.a(closeable);
            throw th;
        }
        this.a = array;
    }
}
