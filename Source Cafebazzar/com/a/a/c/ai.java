package com.a.a.c;

import java.io.File;
import java.util.Comparator;

final class ai implements Comparator {
    ai() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
