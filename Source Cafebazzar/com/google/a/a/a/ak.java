package com.google.a.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class ak implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ aj b;

    ak(aj ajVar, Map map) {
        this.b = ajVar;
        this.a = map;
    }

    public final void run() {
        if (TextUtils.isEmpty((CharSequence) this.a.get("&cid"))) {
            this.a.put("&cid", this.b.f);
        }
        ap a = ap.a(this.b.i);
        an.a().a(ao.GET_APP_OPT_OUT);
        if (!a.b.booleanValue() && !aj.a(this.b, this.a)) {
            Map map;
            if (!TextUtils.isEmpty(this.b.e)) {
                an.a().a(true);
                map = this.a;
                av avVar = new av();
                String c = this.b.e;
                an.a().a(ao.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
                c = bi.b(c);
                if (!TextUtils.isEmpty(c)) {
                    Map a2 = bi.a(c);
                    avVar.a("&cc", (String) a2.get("utm_content"));
                    avVar.a("&cm", (String) a2.get("utm_medium"));
                    avVar.a("&cn", (String) a2.get("utm_campaign"));
                    avVar.a("&cs", (String) a2.get("utm_source"));
                    avVar.a("&ck", (String) a2.get("utm_term"));
                    avVar.a("&ci", (String) a2.get("utm_id"));
                    avVar.a("&gclid", (String) a2.get("gclid"));
                    avVar.a("&dclid", (String) a2.get("dclid"));
                    avVar.a("&gmob_t", (String) a2.get("gmob_t"));
                }
                map.putAll(avVar.a());
                an.a().a(false);
                this.b.e = null;
            }
            aj.b(this.b, this.a);
            Map map2 = this.a;
            map = new HashMap();
            for (Entry entry : map2.entrySet()) {
                if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                    CharSequence substring = ((String) entry.getKey()).substring(1);
                    if (!TextUtils.isEmpty(substring)) {
                        map.put(substring, entry.getValue());
                    }
                }
            }
            this.b.h.a(map, Long.valueOf((String) this.a.get("&ht")).longValue(), aj.c(this.b, this.a), this.b.d);
        }
    }
}
