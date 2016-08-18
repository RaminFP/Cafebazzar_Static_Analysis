package com.farsitel.bazaar.util;

import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;

public final class aj {
    public static String a(long j) {
        return e.b(BazaarApplication.c().getString(j > 99999 ? 2131165549 : 2131165233, new Object[]{Long.valueOf(j / 10)}));
    }

    public static String a(long j, char c) {
        if (c == 'C') {
            return a(j);
        }
        switch (c) {
            case 'A':
                return BazaarApplication.c().getString(2131165271, new Object[]{a(j)});
            case 'M':
                return BazaarApplication.c().getString(2131165447, new Object[]{a(j)});
            default:
                return a(j);
        }
    }
}
