package com.farsitel.bazaar.a;

import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.ax;
import ir.cafebazaar.pardakht.PaymentActivity;
import java.util.ArrayList;
import org.json.JSONArray;

public final class ag extends BaseAdapter {
    private ArrayList a = new ArrayList();
    private int b;
    private Intent c;
    private PaymentActivity d;
    private final LayoutInflater e;
    private final String f;
    private OnItemClickListener g = new ah(this);

    public ag(JSONArray jSONArray, PaymentActivity paymentActivity, int i, String str) {
        this.b = i;
        this.d = paymentActivity;
        this.e = LayoutInflater.from(this.d);
        this.f = str;
        this.c = this.d.b;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            boolean z;
            ai aiVar = new ai(jSONArray.getJSONObject(i2));
            int i3 = this.b;
            if (aiVar.a()) {
                switch (i3) {
                    case 0:
                        z = aiVar.a;
                        break;
                    case 1:
                        z = aiVar.a;
                        break;
                    case 2:
                        if (!aiVar.a || !aiVar.b) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                        break;
                    default:
                        z = aiVar.a;
                        break;
                }
            }
            z = false;
            if (z) {
                this.a.add(aiVar);
            }
        }
        ((ListView) this.d.findViewById(2131624261)).setOnItemClickListener(this.g);
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        if (view == null) {
            view = this.e.inflate(2130903160, viewGroup, false);
            aj ajVar = new aj();
            ajVar.a = (TextView) view.findViewById(2131624387);
            ajVar.b = (TextView) view.findViewById(2131624388);
            ajVar.c = (ImageView) view.findViewById(2131624386);
            ajVar.d = view.findViewById(2131624385);
            view.setTag(ajVar);
        }
        aj ajVar2 = (aj) view.getTag();
        ai aiVar = (ai) this.a.get(i);
        ajVar2.a.setText(aiVar.d);
        ajVar2.b.setText(aiVar.b() ? Html.fromHtml(aiVar.g) : "");
        TextView textView = ajVar2.b;
        if (!aiVar.b()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        ImageView imageView = ajVar2.c;
        if (TextUtils.isEmpty(aiVar.c)) {
            imageView.setImageResource(g.icon_not_loaded);
        } else if (aiVar.c.contains("http")) {
            ab.a().a(aiVar.c, imageView, (int) g.icon_not_loaded);
        } else {
            int a = ax.a(aiVar.c, g.class);
            if (a == -1) {
                a = g.ic_default_payment;
            }
            imageView.setImageResource(a);
        }
        return view;
    }
}
