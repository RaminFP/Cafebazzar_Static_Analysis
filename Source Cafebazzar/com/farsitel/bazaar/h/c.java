package com.farsitel.bazaar.h;

import com.android.a.y;
import com.farsitel.bazaar.BazaarApplication;
import java.util.HashMap;

public final class c extends y {
    public int b;
    public HashMap c;

    public c() {
        this((byte) 0);
    }

    public c(byte b) {
        this(10000, BazaarApplication.c().getString(2131165374));
    }

    public c(int i, int i2) {
        this(10002, BazaarApplication.c().getString(2131165466));
    }

    public c(int i, String str) {
        this.b = i;
        this.c = new HashMap();
        this.c.put("general", str);
    }

    public c(int i, HashMap hashMap) {
        this.b = i;
        this.c = hashMap;
    }

    public final String toString() {
        return "BazaarNetworkException :: " + this.b + " errors=" + this.c;
    }
}
