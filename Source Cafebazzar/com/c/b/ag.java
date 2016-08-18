package com.c.b;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import java.io.InputStream;

final class ag extends az {
    private final v a;
    private final bc b;

    public ag(v vVar, bc bcVar) {
        this.a = vVar;
        this.b = bcVar;
    }

    final int a() {
        return 2;
    }

    final boolean a(NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public final boolean a(aw awVar) {
        String scheme = awVar.d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public final ba b(aw awVar) {
        w a = this.a.a(awVar.d, awVar.c);
        ap apVar = a.c ? ap.DISK : ap.NETWORK;
        Bitmap bitmap = a.b;
        if (bitmap != null) {
            return new ba(bitmap, apVar);
        }
        InputStream inputStream = a.a;
        if (inputStream == null) {
            return null;
        }
        if (apVar == ap.DISK && a.d == 0) {
            bj.a(inputStream);
            throw new ah("Received response with 0 content-length header.");
        }
        if (apVar == ap.NETWORK && a.d > 0) {
            bc bcVar = this.b;
            bcVar.c.sendMessage(bcVar.c.obtainMessage(4, Long.valueOf(a.d)));
        }
        return new ba(inputStream, apVar);
    }

    final boolean b() {
        return true;
    }
}
