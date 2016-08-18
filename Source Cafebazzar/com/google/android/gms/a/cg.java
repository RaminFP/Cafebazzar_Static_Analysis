package com.google.android.gms.a;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.av;
import java.util.Set;

public final class cg {
    public static String[] a(Set set) {
        av.a((Object) set, (Object) "scopes can't be null.");
        Object obj = (Scope[]) set.toArray(new Scope[set.size()]);
        av.a(obj, (Object) "scopes can't be null.");
        String[] strArr = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            strArr[i] = obj[i].b;
        }
        return strArr;
    }
}
