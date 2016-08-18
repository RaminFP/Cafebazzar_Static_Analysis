package b.a.a.a.a.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import b.a.a.a.a.b.l;
import b.a.a.a.f;

public final class n {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    private n(String str, int i, int i2, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public static n a(Context context, String str) {
        if (str != null) {
            try {
                int j = l.j(context);
                f.a().a("Fabric", "App icon resource ID is " + j);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), j, options);
                return new n(str, j, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                f.a().c("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
