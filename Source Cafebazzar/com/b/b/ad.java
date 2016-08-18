package com.b.b;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ad {
    private static final String d = ad.class.getSimpleName();
    boolean a;
    List b;
    long c = -1;

    private static String a(String str) {
        if (str == null || str.length() <= 4) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) {
            stringBuilder.append('*');
        }
        stringBuilder.append(str.substring(str.length() - 4));
        return stringBuilder.toString();
    }

    private boolean a(String str, DataInputStream dataInputStream) {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        ba.a(3, d, "File version: " + readUnsignedShort);
        if (readUnsignedShort > 2) {
            ba.a(6, d, "Unknown agent file version: " + readUnsignedShort);
            throw new IOException("Unknown agent file version: " + readUnsignedShort);
        } else if (readUnsignedShort >= 2) {
            String readUTF = dataInputStream.readUTF();
            ba.a(3, d, "Loading API key: " + a(str));
            if (readUTF.equals(str)) {
                List arrayList = new ArrayList();
                dataInputStream.readUTF();
                boolean readBoolean = dataInputStream.readBoolean();
                long readLong = dataInputStream.readLong();
                ba.a(3, d, "Loading session reports");
                readUnsignedShort = 0;
                while (true) {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort2 != 0) {
                        byte[] bArr = new byte[readUnsignedShort2];
                        dataInputStream.readFully(bArr);
                        arrayList.add(0, new w(bArr));
                        readUnsignedShort++;
                        ba.a(3, d, "Session report added: " + readUnsignedShort);
                    } else {
                        ba.a(3, d, "Persistent file loaded");
                        this.a = readBoolean;
                        this.c = readLong;
                        this.b = arrayList;
                        return true;
                    }
                }
            }
            ba.a(3, d, "Api keys do not match, old: " + a(str) + ", new: " + a(readUTF));
            return false;
        } else {
            ba.a(5, d, "Deleting old file version: " + readUnsignedShort);
            return false;
        }
    }

    public final void a(DataOutputStream dataOutputStream, String str, String str2) {
        try {
            dataOutputStream.writeShort(46586);
            dataOutputStream.writeShort(2);
            dataOutputStream.writeUTF(str);
            dataOutputStream.writeUTF(str2);
            dataOutputStream.writeBoolean(this.a);
            dataOutputStream.writeLong(this.c);
            for (int size = this.b.size() - 1; size >= 0; size--) {
                byte[] bArr = ((w) this.b.get(size)).a;
                int length = bArr.length;
                if ((length + 2) + dataOutputStream.size() > 50000) {
                    ba.a(6, d, "discarded sessions: " + size);
                    break;
                }
                dataOutputStream.writeShort(length);
                dataOutputStream.write(bArr);
            }
            dataOutputStream.writeShort(0);
            bj.a((Closeable) dataOutputStream);
        } catch (Throwable th) {
            bj.a((Closeable) dataOutputStream);
        }
    }

    public final boolean a(DataInputStream dataInputStream, String str) {
        boolean z = false;
        try {
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            ba.a(4, d, "Magic: " + readUnsignedShort);
            if (readUnsignedShort == 46586) {
                z = a(str, dataInputStream);
            } else {
                ba.a(3, d, "Unexpected file type");
            }
            bj.a((Closeable) dataInputStream);
            return z;
        } catch (Throwable th) {
            bj.a((Closeable) dataInputStream);
        }
    }
}
