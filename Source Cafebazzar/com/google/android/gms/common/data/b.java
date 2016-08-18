package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.av;
import java.util.ArrayList;
import java.util.HashMap;

public class b {
    private final String[] a;
    private final ArrayList b;
    private final String c;
    private final HashMap d;
    private boolean e;
    private String f;

    private b(String[] strArr, String str) {
        this.a = (String[]) av.a((Object) strArr);
        this.b = new ArrayList();
        this.c = str;
        this.d = new HashMap();
        this.e = false;
        this.f = null;
    }
}
