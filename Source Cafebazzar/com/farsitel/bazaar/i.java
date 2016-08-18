package com.farsitel.bazaar;

import android.content.Context;
import com.b.a.a;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.h;
import com.farsitel.bazaar.util.q;
import com.google.a.a.a.ap;
import com.google.a.a.a.av;
import com.google.a.a.a.bg;
import com.google.a.a.a.u;

public final class i {
    private static ap a;
    private static bg b;
    private static String d = "GCS4KW2TFHHTGCBSKWHX";
    private final BazaarApplication c = BazaarApplication.c();

    public i(int i) {
        ap a = ap.a(this.c.getApplicationContext());
        a = a;
        String string = j.a().a.getString("ganal_key", "UA-45251554-1");
        bg a2 = a.a(string, string);
        b = a2;
        a2.a("&sf", j.a().a.getString("ganal_sample_rate", "0.001"));
        a.a(false);
        switch (j.a[i - 1]) {
            case 1:
                b.a(av.a("UX", "appStart", null, null).a("&sc", "start").a(u.a(1), j.a().p()).a(u.a(2), q.a()).a(u.a(3), h.INSTANCE.b()).a(u.a(4), h.INSTANCE.c()).a(u.a(5), q.g()).a());
                a.a("appStart", av.a("UX", "appStart", null, null).a("&sc", "start").a(u.a(1), j.a().p()).a(u.a(2), q.a()).a(u.a(3), h.INSTANCE.b()).a(u.a(4), h.INSTANCE.c()).a(u.a(5), q.g()).a());
                return;
            case 2:
                b.a(av.a("UX", "widgetStart", null, null).a("&sc", "start").a(u.a(1), j.a().p()).a(u.a(2), q.a()).a(u.a(3), h.INSTANCE.b()).a(u.a(4), h.INSTANCE.c()).a(u.a(5), q.g()).a());
                a.a("widgetStart", av.a("UX", "widgetStart", null, null).a("&sc", "start").a(u.a(1), j.a().p()).a(u.a(2), q.a()).a(u.a(3), h.INSTANCE.b()).a(u.a(4), h.INSTANCE.c()).a(u.a(5), q.g()).a());
                return;
            default:
                return;
        }
    }

    public static void a() {
        b.a(av.a("UX", "appStart", null, null).a("&sc", "stop").a(u.a(1), j.a().p()).a(u.a(2), q.a()).a(u.a(3), h.INSTANCE.b()).a(u.a(4), h.INSTANCE.c()).a(u.a(5), q.g()).a());
    }

    public static void a(Context context) {
        a.a(context, d);
    }

    public static void a(String str) {
        b.a(av.b().a("&cd", str).a());
        a.a("appView", av.b().a("&cd", str).a());
    }

    public static void b(Context context) {
        a.a(context);
    }

    public static void b(String str) {
        b.a(av.a("UI", "button_press", str, null).a());
        a.a("actionLabel", av.a("UI", "button_press", str, null).a());
    }
}
