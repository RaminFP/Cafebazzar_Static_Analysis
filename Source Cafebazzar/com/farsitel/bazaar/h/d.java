package com.farsitel.bazaar.h;

import android.content.IntentFilter;
import com.android.a.a.j;
import com.android.a.r;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.k;
import com.farsitel.bazaar.util.q;
import java.util.concurrent.ExecutorService;

public enum d {
    INSTANCE;
    
    private r b;
    private ExecutorService c;

    public final Object a(k kVar, Object... objArr) {
        u uVar = new u(kVar, objArr, null);
        Object a = ab.a(uVar);
        if (a == null) {
            j a2 = j.a();
            this.b.a(new w(uVar, a2));
            a = a2.get();
            if (a == null) {
                throw new Exception("response is null");
            }
        }
        return a;
    }

    public final Object a(v vVar, k kVar, Object... objArr) {
        return a(vVar, null, kVar, objArr);
    }

    public final Object a(v vVar, String str, k kVar, Object... objArr) {
        Object obj = null;
        int i = 0;
        if (vVar != null) {
            obj = Integer.valueOf(vVar.hashCode());
            if (!vVar.e) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.farsitel.bazaar.NETWORK_RESPONSE");
                intentFilter.addAction("com.farsitel.bazaar.NETWORK_ERROR");
                android.support.v4.b.j.a(BazaarApplication.c()).a(vVar, intentFilter);
                vVar.e = true;
            }
            i = vVar.d;
        }
        this.c.execute(new e(kVar, objArr, str == null ? "null" : str, i, obj, this.b));
        return obj;
    }

    public final boolean b(k kVar, Object... objArr) {
        if (!q.e()) {
            return false;
        }
        a(null, kVar, objArr);
        return true;
    }
}
