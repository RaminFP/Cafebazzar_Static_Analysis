package b.a.a.a.a.f;

import android.content.Context;
import b.a.a.a.f;
import b.a.a.a.p;
import java.io.File;

public final class b implements a {
    private final Context a;
    private final String b;
    private final String c;

    public b(p pVar) {
        if (pVar.p == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = pVar.p;
        this.b = pVar.n();
        this.c = "Android/" + this.a.getPackageName();
    }

    public final File a() {
        File filesDir = this.a.getFilesDir();
        if (filesDir == null) {
            f.a().a("Fabric", "Null File");
        } else if (filesDir.exists() || filesDir.mkdirs()) {
            return filesDir;
        } else {
            f.a().d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
