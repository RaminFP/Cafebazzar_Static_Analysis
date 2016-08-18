package com.farsitel.bazaar.activity;

import android.os.Bundle;
import android.support.v7.a.g;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.farsitel.bazaar.BazaarApplication;

public class PurchasesAngulakActivity extends s implements OnClickListener, OnItemClickListener {
    public void onClick(View view) {
        BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit().putString("pref_key_custom_custom_purchases", ((EditText) findViewById(g.custom)).getText().toString() + "/%s").commit();
    }

    protected void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setContentView(2130903065);
        ((EditText) findViewById(g.custom)).setText(BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("pref_key_custom_custom_purchases", "http://192.168.100.1:8000"));
        ((Button) findViewById(2131624035)).setOnClickListener(this);
        ListView listView = (ListView) findViewById(2131624036);
        String[] stringArray = getResources().getStringArray(2131230730);
        ListAdapter arrayAdapter = new ArrayAdapter(this, 17367043);
        int length = stringArray.length;
        while (i < length) {
            arrayAdapter.add(stringArray[i]);
            i++;
        }
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
    }
}
