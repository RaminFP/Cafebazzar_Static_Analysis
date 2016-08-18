package b.a.a.a.a.b;

import android.content.Context;
import b.a.a.a.a.a.d;

final class aa implements d {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public final /* synthetic */ Object a(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
