package com.farsitel.bazaar.h;

import java.util.Locale;

public enum t implements f {
    ;
    
    private final String b;

    static {
        String format;
        if ("http://%s.cafebazaar.ir/%s".lastIndexOf(37) == "http://%s.cafebazaar.ir/%s".indexOf(37)) {
            format = String.format(Locale.US, "http://%s.cafebazaar.ir/%s", new Object[]{"json/"});
        } else {
            format = String.format(Locale.US, "http://%s.cafebazaar.ir/%s", new Object[]{"as", "json/"});
        }
        a = new t("APPS_SEARCH", 0, format);
        c = new t[]{a};
    }

    private t(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
