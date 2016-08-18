package com.farsitel.bazaar.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.farsitel.bazaar.BazaarApplication;

final class da implements OnItemClickListener {
    final /* synthetic */ cz a;

    da(cz czVar) {
        this.a = czVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = null;
        switch (i) {
            case 0:
                str = "fa";
                break;
            case 1:
                str = "en";
                break;
            case 2:
                str = "DEFAULT";
                break;
        }
        if (str != null) {
            SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
            if (!str.equals(sharedPreferences.getString("locale", "DEFAULT"))) {
                Editor edit = sharedPreferences.edit();
                edit.putString("locale", str);
                edit.commit();
                BazaarApplication.c().a(this.a.f);
                BazaarApplication.c().a();
            }
            this.a.e.dismiss();
        }
    }
}
