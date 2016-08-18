package com.farsitel.bazaar.a;

import com.farsitel.bazaar.g.g;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONArray;
import org.json.JSONObject;

final class at extends v {
    final /* synthetic */ ao a;

    private at(ao aoVar) {
        this.a = aoVar;
    }

    public final void a(c cVar) {
        this.a.s.b();
    }

    public final /* synthetic */ void a(Object obj) {
        JSONArray jSONArray = (JSONArray) obj;
        g[] gVarArr = new g[jSONArray.length()];
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                gVarArr[i] = new g(jSONObject.getInt("id"), jSONObject.getString("user"), jSONObject.get("date").toString(), jSONObject.getInt("rate"), jSONObject.getString("comment"), jSONObject.getInt("likes"), jSONObject.getInt("total"), jSONObject.getInt("vc"));
                i++;
            } catch (Exception e) {
                this.a.s.b();
                return;
            }
        }
        ao.a(this.a, gVarArr.length);
        if (gVarArr.length < 10 || gVarArr.length == 0) {
            this.a.q = true;
        }
        this.a.s.a(gVarArr, this.a.r);
        for (Object add : gVarArr) {
            this.a.j.add(add);
        }
        this.a.notifyDataSetChanged();
        this.a.r = false;
        this.a.p = false;
    }
}
