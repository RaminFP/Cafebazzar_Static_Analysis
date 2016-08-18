package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class d {
    public static Creator a(f fVar) {
        return VERSION.SDK_INT >= 13 ? new g(fVar) : new e(fVar);
    }
}
