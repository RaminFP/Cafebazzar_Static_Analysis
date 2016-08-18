package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class bz implements FilenameFilter {
    bz() {
    }

    public final boolean accept(File file, String str) {
        return str.endsWith(".cls") && !str.contains("Session");
    }
}
