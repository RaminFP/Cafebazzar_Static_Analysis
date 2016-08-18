package com.b.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bb implements bf {
    private static bb a;
    private final List b;

    private bb() {
        List arrayList = new ArrayList();
        arrayList.add(new bc("com.flurry.android.impl.appcloud.AppCloudModule", 10));
        arrayList.add(new bc("com.flurry.android.impl.ads.FlurryAdModule", 10));
        this.b = Collections.unmodifiableList(arrayList);
    }

    public static bb a() {
        synchronized (bb.class) {
            try {
                if (a == null) {
                    a = new bb();
                }
                bb bbVar = a;
                return bbVar;
            } finally {
                Object obj = bb.class;
            }
        }
    }

    public final void a(Context context) {
        for (bf a : this.b) {
            a.a(context);
        }
    }

    public final void b(Context context) {
        for (bf b : this.b) {
            b.b(context);
        }
    }
}
