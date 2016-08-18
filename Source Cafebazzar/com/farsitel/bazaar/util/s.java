package com.farsitel.bazaar.util;

import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build.VERSION;
import com.farsitel.bazaar.BazaarApplication;

public final class s {
    private static int a = 0;

    public static void a() {
        try {
            if (VERSION.SDK_INT >= 10) {
                NfcAdapter defaultAdapter = ((NfcManager) BazaarApplication.c().getSystemService("nfc")).getDefaultAdapter();
                if (defaultAdapter == null) {
                    a = 2;
                    return;
                } else if (!defaultAdapter.isEnabled()) {
                    a = 5;
                    return;
                } else if (VERSION.SDK_INT < 16) {
                    a = 3;
                    return;
                } else if (defaultAdapter.isNdefPushEnabled()) {
                    a = 4;
                    return;
                } else {
                    a = 3;
                    return;
                }
            }
            a = 1;
        } catch (Exception e) {
        }
    }

    public static String b() {
        switch (a) {
            case 1:
                return "Low API Version";
            case 2:
                return "Not Supported";
            case 3:
                return "Turned On";
            case 4:
                return "Turned On + Beam";
            case 5:
                return "Turned Off";
            default:
                return "Unexpected";
        }
    }

    public static String c() {
        try {
            return BazaarApplication.c().getPackageManager().hasSystemFeature("android.hardware.bluetooth") ? BazaarApplication.c().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "Supported + LE" : "Supported" : "Not Supported";
        } catch (Exception e) {
            return "Unexpected";
        }
    }
}
