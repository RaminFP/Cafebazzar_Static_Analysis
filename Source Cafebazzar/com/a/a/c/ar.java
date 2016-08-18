package com.a.a.c;

import java.io.File;
import java.io.FilenameFilter;

final class ar implements FilenameFilter {
    private final String a;

    public ar(String str) {
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return (str.equals(new StringBuilder().append(this.a).append(".cls").toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
    }
}
