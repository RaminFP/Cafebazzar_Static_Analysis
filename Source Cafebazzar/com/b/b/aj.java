package com.b.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aj {
    private Map a = new HashMap();
    private Map b = new HashMap();

    public final Object a(String str) {
        Object obj;
        synchronized (this) {
            obj = this.a.get(str);
        }
        return obj;
    }

    public final void a(String str, ak akVar) {
        synchronized (this) {
            if (!(TextUtils.isEmpty(str) || akVar == null)) {
                List list = (List) this.b.get(str);
                if (list == null) {
                    list = new LinkedList();
                }
                list.add(akVar);
                this.b.put(str, list);
            }
        }
    }

    public final void a(String str, Object obj) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                Object obj2 = this.a.get(str);
                obj2 = (obj == obj2 || (obj != null && obj.equals(obj2))) ? 1 : null;
                if (obj2 == null) {
                    if (obj == null) {
                        this.a.remove(str);
                    } else {
                        this.a.put(str, obj);
                    }
                    if (this.b.get(str) != null) {
                        for (ak a : (List) this.b.get(str)) {
                            a.a(str, obj);
                        }
                    }
                }
            }
        }
    }

    public final boolean b(String str, ak akVar) {
        boolean z;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else if (akVar == null) {
                z = false;
            } else {
                List list = (List) this.b.get(str);
                z = list == null ? false : list.remove(akVar);
            }
        }
        return z;
    }
}
