package com.farsitel.bazaar.service;

import com.farsitel.bazaar.util.ak;
import java.io.File;

final class a implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ String b;
    final /* synthetic */ AppDownloadService c;

    a(AppDownloadService appDownloadService, File file, String str) {
        this.c = appDownloadService;
        this.a = file;
        this.b = str;
    }

    public final void run() {
        ak.a(this.a.getPath(), this.b);
    }
}
