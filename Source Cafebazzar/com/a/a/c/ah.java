package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class ah implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ ac b;

    ah(ac acVar, String str) {
        this.b = acVar;
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
