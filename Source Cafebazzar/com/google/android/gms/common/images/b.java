package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.support.v4.f.g;

final class b extends g {
    protected final /* synthetic */ int b(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }
}
