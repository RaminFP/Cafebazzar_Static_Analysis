package com.a.a.a;

import android.os.Build.VERSION;
import android.os.Looper;
import b.a.a.a.a.b.ah;
import b.a.a.a.a.b.b;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.x;
import b.a.a.a.a.b.y;
import b.a.a.a.f;
import java.util.Map;
import java.util.UUID;

final class i implements Runnable {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        try {
            ap apVar = this.a.d;
            Map c = apVar.b.c();
            String str = apVar.b.d;
            String a = apVar.b.a();
            String str2 = (String) c.get(y.ANDROID_ID);
            String str3 = (String) c.get(y.ANDROID_ADVERTISING_ID);
            x xVar = apVar.b;
            Boolean bool = null;
            if (xVar.a) {
                b e = xVar.e();
                if (e != null) {
                    bool = Boolean.valueOf(e.b);
                }
            }
            String str4 = (String) c.get(y.FONT_TOKEN);
            String k = l.k(apVar.a);
            x xVar2 = apVar.b;
            an anVar = new an(str, UUID.randomUUID().toString(), a, str2, str3, bool, str4, k, x.a(VERSION.RELEASE) + "/" + x.a(VERSION.INCREMENTAL), apVar.b.b(), apVar.c, apVar.d);
            l lVar = this.a.c;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
            }
            ag agVar = new ag(lVar.a, new ao(), new ah(), new b.a.a.a.a.d.i(lVar.a, lVar.b.a(), "session_analytics.tap", "session_analytics_to_send"));
            agVar.a(this.a);
            this.a.g = new v(this.a.a, this.a.b, this.a.f, agVar, this.a.e, anVar);
        } catch (Throwable e2) {
            f.a().c("Answers", "Failed to enable events", e2);
        }
    }
}
