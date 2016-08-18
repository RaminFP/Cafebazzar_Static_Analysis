package com.c.b;

import android.content.Context;
import android.media.ExifInterface;
import java.io.InputStream;

final class y extends o {
    y(Context context) {
        super(context);
    }

    public final boolean a(aw awVar) {
        return "file".equals(awVar.d.getScheme());
    }

    public final ba b(aw awVar) {
        int i;
        InputStream c = c(awVar);
        ap apVar = ap.DISK;
        switch (new ExifInterface(awVar.d.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                i = 180;
                break;
            case 6:
                i = 90;
                break;
            case 8:
                i = 270;
                break;
            default:
                i = 0;
                break;
        }
        return new ba(null, c, apVar, i);
    }
}
