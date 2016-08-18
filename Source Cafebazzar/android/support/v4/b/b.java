package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class b {
    private static final c a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            a = new f();
        } else if (i >= 11) {
            a = new e();
        } else {
            a = new d();
        }
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }
}
