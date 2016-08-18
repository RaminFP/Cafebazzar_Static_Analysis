package com.android.a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.util.Map;

public final class m {
    public final int a;
    public final byte[] b;
    public final Map c;
    public final boolean d;

    public m(int i, byte[] bArr, Map map, boolean z) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
    }

    public m(byte[] bArr, Map map) {
        this(Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false);
    }
}
