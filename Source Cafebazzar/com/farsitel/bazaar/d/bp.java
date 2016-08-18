package com.farsitel.bazaar.d;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.x;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.p;
import java.util.Map;
import org.json.JSONObject;

public abstract class bp extends y implements OnClickListener, OnItemClickListener, b {
    BaseAdapter a;
    boolean b = false;
    private ListView c;
    private View d;
    private View e;
    private View f;
    private View j;
    private TextView k;
    private View l;
    private TextView m;
    private boolean n = false;
    private View o;
    private String p = null;

    private void g() {
        this.j = this.o.findViewById(2131624181);
        l();
    }

    private void l() {
        this.k = (TextView) this.j.findViewById(2131624422);
        this.l = this.j.findViewById(2131624423);
        this.k.setText(d());
        this.l.setOnClickListener(this);
    }

    private void m() {
        a();
        d.INSTANCE.a(new bq(), new x(), "fa", Long.valueOf(c()));
    }

    protected abstract BaseAdapter a(Activity activity, JSONObject jSONObject);

    public final void a() {
        if (this.n) {
            Log.i(getClass().getSimpleName(), "onStartSendingRequest");
        }
        this.e.setVisibility(8);
        this.d.setVisibility(0);
        this.f.setVisibility(8);
        this.c.setVisibility(8);
    }

    abstract void a(int i, long j);

    public final void a(int i, Map map) {
        if (this.n) {
            Log.i(getClass().getSimpleName(), "onResponseContainsError");
        }
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.f.setVisibility(0);
        g();
        this.j.setVisibility(0);
    }

    public final void b() {
        if (this.n) {
            Log.i(getClass().getSimpleName(), "onResponseProcessedSuccessfully");
        }
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        if (this.a == null || this.a.isEmpty()) {
            this.c.setVisibility(8);
            this.e.setVisibility(0);
            g();
        } else {
            this.c.setVisibility(0);
            this.c.setAdapter(this.a);
            this.c.setOnItemClickListener(this);
        }
        this.j.setVisibility(0);
    }

    public abstract long c();

    public abstract String d();

    public abstract String e();

    public void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        switch (view.getId()) {
            case 2131624180:
                this.f.setVisibility(8);
                this.d.setVisibility(0);
                this.c.setVisibility(8);
                m();
                return;
            case 2131624423:
                HomeActivity homeActivity;
                y a;
                if (this.p != null) {
                    Intent intent = new Intent();
                    intent.putExtra("is_internal", true);
                    intent.putExtra("title", getString(2131165284));
                    intent.putExtra("post_data", "key=" + Uri.encode(j.a().b) + "&device_info=" + Uri.encode(p.b().toString()));
                    intent.putExtra("url", this.p);
                    homeActivity = (HomeActivity) getActivity();
                    a = cb.a(intent);
                    if (getDialog() != null) {
                        z2 = true;
                    }
                    homeActivity.a(a, z2);
                    return;
                }
                homeActivity = (HomeActivity) getActivity();
                a = bs.a();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(a, z);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.o = layoutInflater.inflate(2130903081, viewGroup, false);
        this.c = (ListView) this.o.findViewById(2131624036);
        this.e = this.o.findViewById(2131624178);
        this.d = this.o.findViewById(2131624179);
        this.f = this.o.findViewById(2131624180);
        View inflate = getActivity().getLayoutInflater().inflate(2130903178, null, false);
        this.m = (TextView) inflate.findViewById(2131624426);
        this.c.addHeaderView(inflate, null, false);
        this.m.setText(e());
        this.f.setOnClickListener(this);
        if (this.b) {
            this.j = getActivity().getLayoutInflater().inflate(2130903177, null, false);
            this.c.addFooterView(this.j, null, false);
            l();
        } else {
            g();
        }
        m();
        return this.o;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a(i - this.c.getHeaderViewsCount(), j);
    }

    public void onResume() {
        super.onResume();
        a(getString(2131165254));
    }
}
