package com.c.a.a.c;

import d.ab;
import d.ac;
import d.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class b implements a {
    b() {
    }

    public final ac a(File file) {
        return r.a(file);
    }

    public final void a(File file, File file2) {
        d(file2);
        if (!file.renameTo(file2)) {
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    }

    public final ab b(File file) {
        try {
            return r.b(file);
        } catch (FileNotFoundException e) {
            file.getParentFile().mkdirs();
            return r.b(file);
        }
    }

    public final ab c(File file) {
        try {
            return r.c(file);
        } catch (FileNotFoundException e) {
            file.getParentFile().mkdirs();
            return r.c(file);
        }
    }

    public final void d(File file) {
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    public final boolean e(File file) {
        return file.exists();
    }

    public final long f(File file) {
        return file.length();
    }

    public final void g(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                g(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete " + file2);
            }
        }
    }
}
