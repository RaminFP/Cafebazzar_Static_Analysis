package com.farsitel.bazaar.a.b;

import android.app.Activity;
import android.support.v7.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.farsitel.bazaar.g.c.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends BaseAdapter {
    private ArrayList a = new ArrayList();
    private final LayoutInflater b;

    public c(Activity activity, JSONObject jSONObject) {
        this.b = LayoutInflater.from(activity);
        JSONArray jSONArray = jSONObject.getJSONArray("folders");
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getJSONObject(i).getInt("visibility") > 0) {
                this.a.add(new b(jSONArray.getJSONObject(i)));
            }
        }
    }

    public final b a(int i) {
        return (b) this.a.get(i);
    }

    public final int getCount() {
        return this.a.size();
    }

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public final long getItemId(int i) {
        return ((b) this.a.get(i)).a;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.inflate(2130903176, viewGroup, false);
            d dVar = new d();
            dVar.a = (TextView) view.findViewById(g.title);
            view.setTag(dVar);
        }
        ((d) view.getTag()).a.setText(((b) this.a.get(i)).b);
        return view;
    }
}
