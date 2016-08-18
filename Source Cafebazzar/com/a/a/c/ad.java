package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class ad implements FilenameFilter {
    ad() {
    }

    public final boolean accept(File file, String str) {
        return str.length() == 39 && str.endsWith(".cls");
    }
}
