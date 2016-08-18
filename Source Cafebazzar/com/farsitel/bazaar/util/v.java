package com.farsitel.bazaar.util;

import java.io.File;
import java.io.FileFilter;

final class v implements FileFilter {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final boolean accept(File file) {
        return file.getAbsolutePath().endsWith("apk");
    }
}
