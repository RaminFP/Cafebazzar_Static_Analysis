package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.av;
import java.util.Iterator;

public final class o {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    o(ap apVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        av.a(str2);
        av.a(str3);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.c = str;
        this.d = j;
        this.e = 0;
        if (this.e != 0 && this.e > this.d) {
            apVar.e().b.a("Event created with reverse previous/current timestamps");
        }
        this.f = a(apVar, bundle);
    }

    o(ap apVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        av.a(str2);
        av.a(str3);
        av.a((Object) eventParams);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.c = str;
        this.d = j;
        this.e = j2;
        if (this.e != 0 && this.e > this.d) {
            apVar.e().b.a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    private static EventParams a(ap apVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                it.remove();
            } else {
                apVar.g();
                Object obj = bundle2.get(str);
                int o = (TextUtils.isEmpty(str) || !str.startsWith("_")) ? i.o() : i.p();
                Object a = g.a(o, obj, false);
                if (a == null) {
                    it.remove();
                } else {
                    apVar.g().a(bundle2, str, a);
                }
            }
        }
        return new EventParams(bundle2);
    }

    public final String toString() {
        return "Event{appId='" + this.a + '\'' + ", name='" + this.b + '\'' + ", params=" + this.f + '}';
    }
}
