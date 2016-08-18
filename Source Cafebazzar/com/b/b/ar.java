package com.b.b;

import java.io.File;
import java.io.FilenameFilter;

final class ar implements FilenameFilter {
    ar() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(".flurryagent.");
    }
}
