package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class ao implements FilenameFilter {
    private ao() {
    }

    public final boolean accept(File file, String str) {
        return !ac.a.accept(file, str) && ac.h.matcher(str).matches();
    }
}
