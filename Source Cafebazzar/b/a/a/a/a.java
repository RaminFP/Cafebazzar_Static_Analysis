package b.a.a.a;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;

public final class a {
    public b a;
    private final Application b;

    public a(Context context) {
        this.b = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.a = new b(this.b);
        }
    }

    public final boolean a(d dVar) {
        if (this.a != null) {
            boolean z;
            b bVar = this.a;
            if (bVar.b != null) {
                ActivityLifecycleCallbacks cVar = new c(bVar, dVar);
                bVar.b.registerActivityLifecycleCallbacks(cVar);
                bVar.a.add(cVar);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
