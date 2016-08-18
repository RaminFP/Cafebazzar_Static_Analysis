package com.farsitel.bazaar.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.farsitel.bazaar.BazaarApplication;

final class dc implements OnItemClickListener {
    final /* synthetic */ db a;

    dc(db dbVar) {
        this.a = dbVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = null;
        switch (i) {
            case 0:
                str = "network_type_wifi_3g";
                break;
            case 1:
                str = "network_type_wifi";
                break;
        }
        if (str != null) {
            SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
            if (!str.equals(sharedPreferences.getString("update_network_type", "network_type_wifi_3g"))) {
                Editor edit = sharedPreferences.edit();
                edit.putString("update_network_type", str);
                edit.commit();
            }
            this.a.e.dismiss();
        }
    }
}
