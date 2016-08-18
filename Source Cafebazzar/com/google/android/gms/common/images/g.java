package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.at;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class g extends e {
    private WeakReference d;

    protected final void a(Drawable drawable, boolean z, boolean z2) {
        this.d.get();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        g gVar = (g) obj;
        a aVar = (a) this.d.get();
        a aVar2 = (a) gVar.d.get();
        return aVar2 != null && aVar != null && at.a(aVar2, aVar) && at.a(gVar.a, this.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }
}
