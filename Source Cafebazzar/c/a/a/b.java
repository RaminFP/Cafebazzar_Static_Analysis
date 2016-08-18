package c.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import c.a.a.a.a;
import c.a.a.a.c;
import c.a.a.a.d;
import c.a.a.a.e;
import c.a.a.a.f;
import c.a.a.a.g;
import c.a.a.a.h;
import c.a.a.a.i;
import java.util.LinkedList;
import java.util.List;

public abstract class b {
    private static final String b = b.class.getSimpleName();
    private static final List c;
    private static b d;
    public Context a;

    static {
        List linkedList = new LinkedList();
        c = linkedList;
        linkedList.add(a.class);
        c.add(c.a.a.a.b.class);
        c.add(e.class);
        c.add(f.class);
        c.add(g.class);
        c.add(h.class);
        c.add(i.class);
        c.add(c.class);
    }

    private b() {
    }

    public b(Context context) {
        this.a = context;
    }

    public static b a(Context context) {
        return b(context);
    }

    private static b b(Context context) {
        if (d != null) {
            return d;
        }
        Log.d(b, "Finding badger");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            String str = context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName;
            b iVar;
            if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                iVar = new i(context);
                d = iVar;
                return iVar;
            }
            for (Class constructor : c) {
                iVar = (b) constructor.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                if (iVar.a().contains(str)) {
                    d = iVar;
                    break;
                }
            }
            if (d == null) {
                d = new d(context);
            }
            Log.d(b, "Returning badger:" + d.getClass().getCanonicalName());
            return d;
        } catch (Throwable e) {
            Log.e(b, e.getMessage(), e);
        }
    }

    public abstract List a();

    public abstract void a(int i);

    public final String b() {
        return this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName()).getComponent().getClassName();
    }

    public final void b(int i) {
        try {
            a(i);
        } catch (Throwable e) {
            Log.e(b, e.getMessage(), e);
        }
    }

    public final String c() {
        return this.a.getPackageName();
    }

    public final void d() {
        b(0);
    }
}
