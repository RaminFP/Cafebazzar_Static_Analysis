package com.farsitel.bazaar.a.b;

import android.app.Activity;
import android.support.v7.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends BaseAdapter {
    private ArrayList a = new ArrayList();
    private final LayoutInflater b;

    public a(Activity activity, JSONObject jSONObject) {
        this.b = LayoutInflater.from(activity);
        JSONArray jSONArray = jSONObject.getJSONArray("articles");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.a.add(new com.farsitel.bazaar.g.c.a(jSONArray.getJSONObject(i)));
        }
    }

    public final com.farsitel.bazaar.g.c.a a(int i) {
        return (com.farsitel.bazaar.g.c.a) this.a.get(i);
    }

    public final int getCount() {
        return this.a.size();
    }

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public final long getItemId(int i) {
        return ((com.farsitel.bazaar.g.c.a) this.a.get(i)).a;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.inflate(2130903176, viewGroup, false);
            b bVar = new b();
            bVar.a = (TextView) view.findViewById(g.title);
            view.setTag(bVar);
        }
        ((b) view.getTag()).a.setText(((com.farsitel.bazaar.g.c.a) this.a.get(i)).b);
        return view;
    }
}
