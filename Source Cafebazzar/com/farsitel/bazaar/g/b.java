package com.farsitel.bazaar.g;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.farsitel.bazaar.database.a;

final class b implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final void run() {
        a e = a.e();
        c cVar = this.a;
        if (cVar != null) {
            synchronized (e) {
                SQLiteDatabase writableDatabase = e.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.a[1], Long.valueOf(cVar.a));
                contentValues.put(a.a[2], cVar.b);
                contentValues.put(a.a[3], cVar.c);
                if (cVar.d != null) {
                    contentValues.put(a.a[4], cVar.d.toString());
                }
                contentValues.put(a.a[5], cVar.e);
                if (cVar.d != null) {
                    contentValues.put(a.a[6], cVar.g.toString());
                }
                contentValues.put(a.a[7], cVar.f);
                writableDatabase.insert("actions", null, contentValues);
            }
        }
        int a = a.e().a();
        if (a > 400) {
            e = a.e();
            int c = a.e().c();
            synchronized (e) {
                e.getWritableDatabase().delete("actions", a.a[0] + "=?", new String[]{Integer.toString(c)});
            }
        }
        if (a > 100 || System.currentTimeMillis() - a.e().b() > 21600000) {
            this.b.b();
        }
    }
}
