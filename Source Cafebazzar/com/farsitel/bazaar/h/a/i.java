package com.farsitel.bazaar.h.a;

import android.database.sqlite.SQLiteDatabase;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.m;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.receiver.d;
import ir.cafebazaar.pardakht.a.e;
import ir.cafebazaar.pardakht.ab;
import org.json.JSONObject;

final class i extends v {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void a(c cVar) {
        this.a.b.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            j a = j.a();
            boolean n = a.n();
            a.s().b(null).c(null).d(null).e(null).a();
            this.a.a(jSONObject);
            if (n != a.n()) {
                d.b();
            }
            ab.d();
            m a2 = m.a();
            synchronized (a2) {
                SQLiteDatabase writableDatabase = a2.getWritableDatabase();
                writableDatabase.execSQL("DELETE FROM review");
                writableDatabase.close();
            }
            new e(BazaarApplication.c().getApplicationContext()).b();
            com.farsitel.bazaar.database.e.a().b();
            new ir.cafebazaar.pardakht.a.c(BazaarApplication.c().getApplicationContext()).c();
            this.a.b.b();
        } catch (Exception e) {
            c cVar = new c();
            this.a.b.a(cVar.b, cVar.c);
        }
    }
}
