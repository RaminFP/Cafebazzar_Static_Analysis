package com.a.a.a;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class b {
    final d a;
    public final Map b = new ConcurrentHashMap();

    public b(d dVar) {
        this.a = dVar;
    }

    private void a(String str, Object obj) {
        int i = 1;
        d dVar = this.a;
        Map map = this.b;
        if (map.size() < dVar.a || map.containsKey(str)) {
            i = 0;
        } else {
            dVar.a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(dVar.a)})));
        }
        if (i == 0) {
            this.b.put(str, obj);
        }
    }

    public final void a(String str, Number number) {
        if (!this.a.a(str, "key") && !this.a.a(number, "value")) {
            a(this.a.a(str), (Object) number);
        }
    }

    public final void a(String str, String str2) {
        if (!this.a.a(str, "key") && !this.a.a(str2, "value")) {
            a(this.a.a(str), this.a.a(str2));
        }
    }

    public final String toString() {
        return new JSONObject(this.b).toString();
    }
}
