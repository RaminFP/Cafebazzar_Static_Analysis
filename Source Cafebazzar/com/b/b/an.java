package com.b.b;

import android.telephony.TelephonyManager;
import java.util.Arrays;

public class an {
    private static final String a = an.class.getSimpleName();
    private static byte[] b;

    public static byte[] a() {
        if (b != null) {
            return b;
        }
        if (ah.a.b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ah.a.b.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null && deviceId.trim().length() > 0) {
                try {
                    byte[] b = bj.b(deviceId);
                    if (b == null || b.length != 20) {
                        ba.a(6, a, "sha1 is not " + 20 + " bytes long: " + Arrays.toString(b));
                    } else {
                        b = b;
                    }
                } catch (Exception e) {
                    ba.a(6, a, "Exception in generateHashedImei()");
                }
            }
        }
        return b;
    }
}
