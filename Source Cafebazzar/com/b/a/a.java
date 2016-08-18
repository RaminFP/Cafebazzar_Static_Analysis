package com.b.a;

import android.content.Context;
import com.b.b.ah;
import com.b.b.ao;
import com.b.b.ba;
import com.b.b.bb;
import com.b.b.bh;
import com.b.b.h;
import com.b.b.y;
import java.util.Map;

public final class a {
    private static final String a = a.class.getSimpleName();

    private a() {
    }

    public static int a() {
        com.b.b.a.a();
        return com.b.b.a.b();
    }

    public static void a(Context context) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        bb.a().b(context);
        try {
            y yVar = com.b.b.a.a().a;
            if (yVar != null) {
                yVar.b();
            }
        } catch (Throwable th) {
            ba.a(a, "", th);
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("Null context");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        } else {
            ah.a(context);
            try {
                y yVar;
                Object a = com.b.b.a.a();
                bh.a().b();
                ao.a().b();
                if (a.c == null) {
                    a.c = new h();
                }
                if (a.b.isEmpty()) {
                    ao.a().c();
                }
                if (a.b.containsKey(str)) {
                    yVar = (y) a.b.get(str);
                } else {
                    yVar = new y(context, str, a);
                    yVar.i = com.b.b.a.a(context);
                    a.b.put(str, yVar);
                }
                yVar.a();
                a.a = yVar;
            } catch (Throwable th) {
                ba.a(a, "", th);
            }
            bb.a().a(context);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null) {
            ba.b(a, "String message passed to onError was null.");
        } else if (th == null) {
            ba.b(a, "Throwable passed to onError was null.");
        } else {
            try {
                y yVar = com.b.b.a.a().a;
                if (yVar != null) {
                    yVar.a(str, str2, th.getClass().getName(), th);
                }
            } catch (Throwable th2) {
                ba.a(a, "", th2);
            }
        }
    }

    public static void a(String str, Map map) {
        if (map == null) {
            ba.b(a, "String parameters passed to logEvent was null.");
            return;
        }
        try {
            y yVar = com.b.b.a.a().a;
            if (yVar != null) {
                yVar.a(str, map, false);
            }
        } catch (Throwable th) {
            ba.a(a, "Failed to log event: " + str, th);
        }
    }

    public static void a(boolean z) {
        ba.a();
    }
}
