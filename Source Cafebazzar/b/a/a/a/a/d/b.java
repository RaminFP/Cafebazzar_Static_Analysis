package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b {
    private final int a;
    protected final Context b;
    protected final a c;
    public final q d;
    protected final e e;
    protected volatile long f;
    protected final List g = new CopyOnWriteArrayList();

    public b(Context context, a aVar, q qVar, e eVar, int i) {
        this.b = context.getApplicationContext();
        this.c = aVar;
        this.e = eVar;
        this.d = qVar;
        this.f = this.d.a();
        this.a = 100;
    }

    private static long a(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public abstract String a();

    public final void a(f fVar) {
        if (fVar != null) {
            this.g.add(fVar);
        }
    }

    public final void a(Object obj) {
        byte[] a = this.c.a(obj);
        if (!this.e.a(a.length, c())) {
            l.a(this.b, 4, String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.e.a()), Integer.valueOf(a.length), Integer.valueOf(c())}));
            d();
        }
        this.e.a(a);
    }

    public final void a(List list) {
        this.e.a(list);
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return 8000;
    }

    public final boolean d() {
        boolean z = false;
        if (!this.e.b()) {
            this.e.a(a());
            l.a(this.b, 4, String.format(Locale.US, "generated new file %s", new Object[]{r2}));
            this.f = this.d.a();
            z = true;
        }
        for (f a : this.g) {
            try {
                a.a();
            } catch (Exception e) {
                l.b(this.b, "One of the roll over listeners threw an exception");
            }
        }
        return z;
    }

    public final List e() {
        return this.e.a(1);
    }

    public final void f() {
        this.e.a(this.e.c());
        this.e.d();
    }

    public final void g() {
        List<File> c = this.e.c();
        int b = b();
        if (c.size() > b) {
            int size = c.size() - b;
            l.a(this.b, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new c(this));
            for (File file : c) {
                treeSet.add(new d(file, a(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((d) it.next()).a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.e.a(arrayList);
        }
    }
}
