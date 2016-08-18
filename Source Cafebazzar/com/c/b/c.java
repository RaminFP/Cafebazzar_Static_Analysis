package com.c.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;

final class c extends az {
    private static final int a = 22;
    private final AssetManager b;

    public c(Context context) {
        this.b = context.getAssets();
    }

    public final boolean a(aw awVar) {
        Uri uri = awVar.d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public final ba b(aw awVar) {
        return new ba(this.b.open(awVar.d.toString().substring(a)), ap.DISK);
    }
}
