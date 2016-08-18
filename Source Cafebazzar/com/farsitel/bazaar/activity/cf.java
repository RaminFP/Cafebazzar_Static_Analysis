package com.farsitel.bazaar.activity;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.m;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;

public final class cf extends v {
    private String a;
    private boolean b;
    private boolean c;

    public cf(String str, boolean z, boolean z2) {
        this.a = str;
        this.c = z;
        this.b = z2;
    }

    public final void a(c cVar) {
    }

    public final /* synthetic */ void a(Object obj) {
        m a;
        String str;
        if (((Boolean) obj).booleanValue()) {
            a = m.a();
            str = this.a;
            synchronized (a) {
                SQLiteDatabase writableDatabase = a.getWritableDatabase();
                writableDatabase.execSQL("UPDATE review SET sent = " + 1 + " WHERE packagename = '" + str + "' ");
                writableDatabase.close();
            }
            int i = this.c ? 2131165664 : 2131165663;
            if (this.b) {
                Toast.makeText(BazaarApplication.c(), i, 1).show();
                return;
            }
            return;
        }
        a = m.a();
        str = this.a;
        synchronized (a) {
            writableDatabase = a.getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM review WHERE packagename = '" + str + "' ");
            writableDatabase.close();
        }
        if (this.b) {
            Toast.makeText(BazaarApplication.c(), 2131165600, 1).show();
        }
    }
}
