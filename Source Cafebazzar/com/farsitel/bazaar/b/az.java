package com.farsitel.bazaar.b;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;

final class az extends v {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public final void a(c cVar) {
        this.a.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        String str = (String) obj;
        Map hashMap = new HashMap();
        if (str.length() > 0) {
            hashMap.put("general", str);
            this.a.a(702, hashMap);
            return;
        }
        this.a.b();
    }
}
