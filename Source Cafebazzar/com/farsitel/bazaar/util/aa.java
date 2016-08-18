package com.farsitel.bazaar.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class aa {
    public static final char a = File.separatorChar;

    public static void a(Closeable... closeableArr) {
        for (int i = 0; i < 4; i++) {
            Closeable closeable = closeableArr[i];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
