package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class ap implements FilenameFilter {
    private final String a;

    public ap(String str) {
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return str.contains(this.a) && !str.endsWith(".cls_temp");
    }
}
