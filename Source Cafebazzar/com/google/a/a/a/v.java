package com.google.a.a.a;

import android.os.Build.VERSION;

final class v {
    public static int a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            as.a("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}
