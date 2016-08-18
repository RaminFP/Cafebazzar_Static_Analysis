package com.farsitel.bazaar.util;

import java.io.File;

public final class u implements Runnable {
    public final void run() {
        File[] listFiles = t.b().listFiles(new v(this));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (System.currentTimeMillis() - file.lastModified() > 86400000) {
                    file.delete();
                }
            }
        }
    }
}
