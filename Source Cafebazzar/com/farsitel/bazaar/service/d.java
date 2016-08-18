package com.farsitel.bazaar.service;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class d extends v {
    final /* synthetic */ CheckUpgradablesService a;

    d(CheckUpgradablesService checkUpgradablesService) {
        this.a = checkUpgradablesService;
    }

    public final void a(c cVar) {
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("ua");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                arrayList.add(new com.farsitel.bazaar.g.d(jSONArray2.getString(0), jSONArray2.getLong(2), jSONArray2.getString(1), true, jSONArray2.getLong(4) == 0));
            }
            new Thread(new e(this, arrayList)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
