package com.farsitel.bazaar.database;

import com.farsitel.bazaar.c.b.a;
import com.farsitel.bazaar.util.af;

public final class b {
    private static b a;

    private b() {
    }

    public static int a(String str) {
        int a = a.a().a(str);
        switch (a) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                if (g.a().c(str)) {
                    return 0;
                }
                af afVar = af.INSTANCE;
                return af.c(str) ? 2 : 1;
            case 2:
            case 12:
            case 14:
                return 4;
            case 13:
                return 3;
            default:
                throw new RuntimeException("no status" + a);
        }
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }
}
