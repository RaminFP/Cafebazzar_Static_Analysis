package com.b.b;

import android.text.TextUtils;

public final class bd {
    private static final String a = bd.class.getSimpleName();

    public static bf a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        bf bfVar;
        try {
            bfVar = (bf) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable e) {
            ba.a(5, a, "FlurryModule " + str + " is not available:", e);
            bfVar = null;
        }
        return bfVar;
    }
}
