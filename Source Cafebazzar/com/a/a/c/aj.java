package com.a.a.c;

import java.io.File;
import java.util.Comparator;

final class aj implements Comparator {
    aj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj).getName().compareTo(((File) obj2).getName());
    }
}
