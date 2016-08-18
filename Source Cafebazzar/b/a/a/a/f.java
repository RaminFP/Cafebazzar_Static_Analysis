package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.a.a.a.a.b.x;
import b.a.a.a.a.c.n;
import b.a.a.a.a.c.w;
import b.a.a.a.a.c.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    static volatile f a;
    static final s b = new e();
    public final ExecutorService c;
    public a d;
    public WeakReference e;
    final s f;
    final boolean g;
    private final Context h;
    private final Map i;
    private final Handler j;
    private final l k;
    private final l l;
    private final x m;
    private AtomicBoolean n = new AtomicBoolean(false);

    f(Context context, Map map, w wVar, Handler handler, s sVar, boolean z, l lVar, x xVar) {
        this.h = context;
        this.i = map;
        this.c = wVar;
        this.j = handler;
        this.f = sVar;
        this.g = z;
        this.k = lVar;
        this.l = new h(this, map.size());
        this.m = xVar;
    }

    public static f a(Context context, p... pVarArr) {
        if (a == null) {
            synchronized (f.class) {
                try {
                    if (a == null) {
                        i iVar = new i(context);
                        if (iVar.b != null) {
                            throw new IllegalStateException("Kits already set.");
                        }
                        Map hashMap;
                        iVar.b = pVarArr;
                        if (iVar.c == null) {
                            iVar.c = w.a();
                        }
                        if (iVar.d == null) {
                            iVar.d = new Handler(Looper.getMainLooper());
                        }
                        if (iVar.e == null) {
                            if (iVar.f) {
                                iVar.e = new e(3);
                            } else {
                                iVar.e = new e();
                            }
                        }
                        if (iVar.h == null) {
                            iVar.h = iVar.a.getPackageName();
                        }
                        if (iVar.i == null) {
                            iVar.i = l.d;
                        }
                        if (iVar.b == null) {
                            hashMap = new HashMap();
                        } else {
                            Collection asList = Arrays.asList(iVar.b);
                            hashMap = new HashMap(asList.size());
                            a(hashMap, asList);
                        }
                        f fVar = new f(iVar.a, hashMap, iVar.c, iVar.d, iVar.e, iVar.f, iVar.i, new x(iVar.a, iVar.h, iVar.g, hashMap.values()));
                        a = fVar;
                        Context context2 = fVar.h;
                        fVar.a(context2 instanceof Activity ? (Activity) context2 : null);
                        fVar.d = new a(fVar.h);
                        fVar.d.a(new g(fVar));
                        fVar.a(fVar.h);
                    }
                } catch (Throwable th) {
                    Class cls = f.class;
                }
            }
        }
        return a;
    }

    public static p a(Class cls) {
        if (a != null) {
            return (p) a.i.get(cls);
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    public static s a() {
        return a == null ? b : a.f;
    }

    private void a(Context context) {
        Future submit = this.c.submit(new k(context.getPackageCodePath()));
        Collection values = this.i.values();
        t tVar = new t(submit, values);
        List<p> arrayList = new ArrayList(values);
        Collections.sort(arrayList);
        tVar.a(context, this, l.d, this.m);
        for (p a : arrayList) {
            a.a(context, this, this.l, this.m);
        }
        tVar.m();
        StringBuilder append = a().a(3) ? new StringBuilder("Initializing io.fabric.sdk.android:fabric").append(" [Version: 1.3.10.97").append("], with the following kits:\n") : null;
        for (p a2 : arrayList) {
            a2.o.a(tVar.o);
            a(this.i, a2);
            a2.m();
            if (append != null) {
                append.append(a2.b()).append(" [Version: ").append(a2.a()).append("]\n");
            }
        }
        if (append != null) {
            a().a("Fabric", append.toString());
        }
    }

    private static void a(Map map, p pVar) {
        n nVar = (n) pVar.getClass().getAnnotation(n.class);
        if (nVar != null) {
            for (Class cls : nVar.a()) {
                if (cls.isInterface()) {
                    for (p pVar2 : map.values()) {
                        if (cls.isAssignableFrom(pVar2.getClass())) {
                            pVar.o.a(pVar2.o);
                        }
                    }
                } else if (((p) map.get(cls)) == null) {
                    throw new z("Referenced Kit was null, does the kit exist?");
                } else {
                    pVar.o.a(((p) map.get(cls)).o);
                }
            }
        }
    }

    private static void a(Map map, Collection collection) {
        for (p pVar : collection) {
            map.put(pVar.getClass(), pVar);
            if (pVar instanceof q) {
                a(map, ((q) pVar).c());
            }
        }
    }

    public static boolean b() {
        return a == null ? false : a.g;
    }

    public final f a(Activity activity) {
        this.e = new WeakReference(activity);
        return this;
    }
}
