package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.c.b.a;
import com.farsitel.bazaar.c.b.c;

final class by extends o {
    public by(Activity activity) {
        super(activity, 2131165401, 2131165801, 0, 2131165463);
    }

    public final void a() {
        a a = a.a();
        c cVar = new c(BazaarApplication.c());
        synchronized (a) {
            SQLiteDatabase writableDatabase = cVar.getWritableDatabase();
            writableDatabase.delete("dls", "lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ?", a.a);
            writableDatabase.close();
        }
        a.b.clear();
        d();
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
