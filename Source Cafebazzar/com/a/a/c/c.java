package com.a.a.c;

import android.os.Process;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

final class c {
    private static final AtomicLong a = new AtomicLong(0);
    private static String b;

    public c(x xVar) {
        long time = new Date().getTime();
        long j = time / 1000;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        byte[] array = allocate.array();
        byte b = array[0];
        byte b2 = array[1];
        byte b3 = array[2];
        byte b4 = array[3];
        byte[] a = a(time % 1000);
        byte b5 = a[0];
        byte b6 = a[1];
        byte[] a2 = a(a.incrementAndGet());
        byte b7 = a2[0];
        byte b8 = a2[1];
        byte[] a3 = a((long) Integer.valueOf(Process.myPid()).shortValue());
        byte b9 = a3[0];
        byte b10 = a3[1];
        String a4 = l.a(xVar.a());
        String a5 = l.a(new byte[]{b, b2, b3, b4, b5, b6, b7, b8, b9, b10});
        b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a5.substring(0, 12), a5.substring(12, 16), a5.subSequence(16, 20), a4.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public final String toString() {
        return b;
    }
}
