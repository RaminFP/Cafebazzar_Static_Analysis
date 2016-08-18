package com.congenialmobile.util;

import android.content.Context;
import java.text.DecimalFormat;
import java.util.UUID;

public final class h {
    public static String a(Context context, long j) {
        if (j <= 0) {
            return "0";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)) + " " + context.getString(new int[]{2131165291, 2131165293, 2131165296, 2131165292, 2131165297}[log10]);
    }

    public static boolean a(String str) {
        return !str.matches("[a-zA-Z0-9]");
    }

    public static byte[] a(UUID uuid) {
        int i = 8;
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((int) (mostSignificantBits >>> ((7 - i2) * 8)));
        }
        while (i < 16) {
            bArr[i] = (byte) ((int) (leastSignificantBits >>> ((7 - i) * 8)));
            i++;
        }
        return bArr;
    }
}
