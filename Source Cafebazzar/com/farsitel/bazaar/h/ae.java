package com.farsitel.bazaar.h;

import java.util.Locale;

public enum ae implements f {
    ;
    
    private final String b;

    static {
        String format;
        if ("http://%s.cafebazaar.ir/%s".lastIndexOf(37) == "http://%s.cafebazaar.ir/%s".indexOf(37)) {
            format = String.format(Locale.US, "http://%s.cafebazaar.ir/%s", new Object[]{"json/"});
        } else {
            format = String.format(Locale.US, "http://%s.cafebazaar.ir/%s", new Object[]{"sejel", "json/"});
        }
        a = new ae("SEJEL", 0, format);
        c = new ae[]{a};
    }

    private ae(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
