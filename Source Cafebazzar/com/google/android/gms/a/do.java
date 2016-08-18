package com.google.android.gms.a;

public final class do {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    static int a(int i) {
        return i & 7;
    }

    static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(dc dcVar, int i) {
        return dcVar.a(i);
    }

    public static int b(int i) {
        return i >>> 3;
    }

    public static final int b(dc dcVar, int i) {
        int i2 = 1;
        int i3 = dcVar.i();
        dcVar.a(i);
        while (dcVar.a() == i) {
            dcVar.a(i);
            i2++;
        }
        dcVar.d(i3);
        return i2;
    }
}
