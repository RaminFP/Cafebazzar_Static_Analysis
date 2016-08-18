package com.farsitel.bazaar.service;

import android.content.Intent;
import android.net.Uri;
import com.farsitel.bazaar.BazaarApplication;
import java.io.File;

final class b implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ AppDownloadService b;

    b(AppDownloadService appDownloadService, File file) {
        this.b = appDownloadService;
        this.a = file;
    }

    public final void run() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(this.a), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        BazaarApplication.c().startActivity(intent);
    }
}
