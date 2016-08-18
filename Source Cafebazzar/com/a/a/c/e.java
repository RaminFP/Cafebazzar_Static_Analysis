package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class e implements FilenameFilter {
    e() {
    }

    public final boolean accept(File file, String str) {
        return str.endsWith(".cls_temp");
    }
}
