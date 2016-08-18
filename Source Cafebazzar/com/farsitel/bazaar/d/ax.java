package com.farsitel.bazaar.d;

import android.support.v7.a.g;
import android.text.Html;
import android.widget.ArrayAdapter;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONArray;
import org.json.JSONException;

final class ax extends v {
    final /* synthetic */ aw a;

    ax(aw awVar) {
        this.a = awVar;
    }

    public final void a(c cVar) {
    }

    public final /* synthetic */ void a(Object obj) {
        int i = 0;
        JSONArray jSONArray = (JSONArray) obj;
        try {
            aw awVar = this.a;
            Object arrayAdapter = new ArrayAdapter(awVar.getActivity(), (awVar.a.getText().toString().matches("^[A-Za-z0-9. ]+$") ? 1 : 0) != 0 ? 2130903132 : 2130903133, g.text);
            while (i < jSONArray.length()) {
                arrayAdapter.add(Html.fromHtml(jSONArray.getString(i)));
                i++;
            }
            awVar.d.setAdapter(arrayAdapter);
            if (awVar.c || arrayAdapter.getCount() == 0) {
                awVar.c();
                awVar.c = false;
                return;
            }
            awVar.d.setVisibility(0);
            awVar.e.setVisibility(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
