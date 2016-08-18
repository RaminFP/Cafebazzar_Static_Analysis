package com.farsitel.bazaar.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.receiver.h;

final class ca implements OnMenuItemClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ bz b;

    ca(bz bzVar, View view) {
        this.b = bzVar;
        this.a = view;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i = 0;
        switch (menuItem.getItemId()) {
            case 2131624435:
                String str = (String) this.a.getTag(2131165861);
                String str2 = (String) this.a.getTag(2131165864);
                long longValue = ((Long) this.a.getTag(2131165863)).longValue();
                if (str == null) {
                    return true;
                }
                int i2;
                g a = g.a();
                d dVar;
                if (a.a.containsKey(str)) {
                    dVar = (d) a.a.get(str);
                    dVar.e = false;
                    a.b.put(str, dVar);
                    a.a.remove(str);
                    i2 = 0;
                } else {
                    if (a.b.containsKey(str)) {
                        dVar = (d) a.b.get(str);
                        dVar.e = true;
                        a.a.put(str, dVar);
                        a.b.remove(str);
                        boolean z = true;
                    }
                    this.b.a.e();
                    return true;
                }
                synchronized (a) {
                    SQLiteDatabase writableDatabase = a.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("version_name", str2);
                    contentValues.put("version_code", Long.valueOf(longValue));
                    if (i2 != 0) {
                        i = 1;
                    }
                    contentValues.put("count_as_upgradable", Integer.valueOf(i));
                    writableDatabase.update("upgradables_apps", contentValues, "pkgname = ?", new String[]{str});
                    writableDatabase.close();
                }
                h.c();
                this.b.a.e();
                return true;
            default:
                return false;
        }
    }
}
