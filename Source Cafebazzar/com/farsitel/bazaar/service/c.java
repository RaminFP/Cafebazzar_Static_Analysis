package com.farsitel.bazaar.service;

import com.farsitel.bazaar.util.z;
import java.io.File;
import java.io.IOException;

final class c implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ File b;
    final /* synthetic */ AppDownloadService c;

    c(AppDownloadService appDownloadService, File file, File file2) {
        this.c = appDownloadService;
        this.a = file;
        this.b = file2;
    }

    public final void run() {
        try {
            z.a(this.a, this.b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
