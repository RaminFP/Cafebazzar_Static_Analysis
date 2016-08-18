package com.farsitel.bazaar.widget;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.farsitel.bazaar.BazaarApplication;

public enum s {
    INSTANCE;

    public static void a(t tVar) {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        Editor edit = sharedPreferences.edit();
        int i = sharedPreferences.getInt(tVar.name(), tVar.c);
        if (i > 0) {
            edit.putInt(tVar.name(), i - 1);
            edit.commit();
        }
    }

    public static boolean b(t tVar) {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getInt(tVar.name(), 1) <= 0;
    }
}
