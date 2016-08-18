package com.farsitel.bazaar.util;

import com.d.a.b.a;

final class al extends a {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    al(int i, String[] strArr, boolean[] zArr, String str, String str2) {
        this.a = zArr;
        this.b = str;
        this.c = str2;
        super(0, strArr);
    }

    public final void a() {
        if (!this.a[0]) {
            ak.a(3, this.b, this.c);
        }
    }

    public final void a(int i, String str) {
        if (str.contains("Success")) {
            this.a[0] = true;
        }
    }
}
