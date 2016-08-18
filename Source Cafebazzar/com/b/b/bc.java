package com.b.b;

import android.os.Build.VERSION;
import android.text.TextUtils;

public final class bc extends be {
    private final int a;

    public bc(String str, int i) {
        bf bfVar = null;
        Object obj = (TextUtils.isEmpty(str) || VERSION.SDK_INT < 10) ? null : 1;
        if (obj != null) {
            bfVar = bd.a(str);
        }
        super(bfVar);
        this.a = 10;
    }
}
