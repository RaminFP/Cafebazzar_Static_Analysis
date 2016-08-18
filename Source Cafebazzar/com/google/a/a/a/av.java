package com.google.a.a.a;

import java.util.HashMap;
import java.util.Map;

public final class av {
    private Map a = new HashMap();

    public static av a(String str, String str2, String str3, Long l) {
        an.a().a(ao.CONSTRUCT_EVENT);
        av avVar = new av();
        avVar.a("&t", "event");
        avVar.a("&ec", str);
        avVar.a("&ea", str2);
        avVar.a("&el", str3);
        avVar.a("&ev", null);
        return avVar;
    }

    public static av b() {
        an.a().a(ao.CONSTRUCT_APP_VIEW);
        av avVar = new av();
        avVar.a("&t", "appview");
        return avVar;
    }

    public final av a(String str, String str2) {
        an.a().a(ao.MAP_BUILDER_SET);
        if (str != null) {
            this.a.put(str, str2);
        } else {
            as.d(" MapBuilder.set() called with a null paramName.");
        }
        return this;
    }

    public final Map a() {
        return new HashMap(this.a);
    }
}
