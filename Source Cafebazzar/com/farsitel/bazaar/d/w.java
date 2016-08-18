package com.farsitel.bazaar.d;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.activity.a;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.widget.HeaderGridView;
import java.util.Map;

public abstract class w extends y implements OnClickListener, OnItemClickListener, b {
    protected int a;
    h b;
    boolean c = false;
    private boolean d;
    private int e = 0;
    private com.farsitel.bazaar.receiver.b f;

    private void a(boolean z) {
        View view = getView();
        if (getActivity() != null && view != null) {
            View findViewById = view.findViewById(2131624288);
            if (findViewById.getVisibility() == 0) {
                findViewById.setAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 2130968588));
                findViewById.setVisibility(8);
                if (z) {
                    ((AbsListView) view.findViewById(2131624286)).smoothScrollBy((int) BazaarApplication.c().getResources().getDimension(2131361930), 500);
                }
            }
        }
    }

    protected static void c() {
    }

    static /* synthetic */ void c(w wVar) {
        View view = wVar.getView();
        if (wVar.getActivity() != null && view != null) {
            view = view.findViewById(2131624288);
            if (view.getVisibility() == 8) {
                view.setAnimation(AnimationUtils.loadAnimation(wVar.getActivity().getApplicationContext(), 2130968619));
                view.setVisibility(0);
            }
        }
    }

    public final void a() {
        if (this.b != null && this.b.isEmpty()) {
            View view = getView();
            if (view != null) {
                view.findViewById(2131624178).setVisibility(8);
                view.findViewById(2131624179).setVisibility(0);
                view.findViewById(2131624180).setVisibility(8);
            }
        }
    }

    public final void a(int i, Map map) {
        if (this.b.getCount() == 0) {
            View view = getView();
            if (view != null) {
                view.findViewById(2131624179).setVisibility(8);
                view.findViewById(2131624180).setVisibility(0);
            }
        }
        a(false);
    }

    public final void b() {
        View view = getView();
        if (view != null) {
            view.findViewById(2131624179).setVisibility(8);
            view.findViewById(2131624180).setVisibility(8);
            a(true);
        }
    }

    public int d() {
        return 0;
    }

    public String e() {
        return null;
    }

    protected abstract h g();

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.b != null && this.b.n != null) {
            this.b.n.a(i, i2, intent);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624180:
                View view2 = getView();
                if (view2 != null) {
                    view2.findViewById(2131624180).setVisibility(8);
                    view2.findViewById(2131624179).setVisibility(0);
                    this.b.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int a = this.b.a(getResources());
        View view = getView();
        if (view != null) {
            AbsListView absListView = (AbsListView) view.findViewById(2131624286);
            if (absListView instanceof GridView) {
                ((GridView) absListView).setNumColumns(a);
            }
            if (this.b != null) {
                this.b.notifyDataSetChanged();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = bundle == null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903111, null);
        TextView textView = (TextView) inflate.findViewById(2131624178);
        CharSequence e = e();
        if (e != null) {
            textView.setText(e);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, d(), 0, 0);
        AbsListView absListView = (AbsListView) inflate.findViewById(2131624286);
        absListView.setEmptyView(textView);
        absListView.setOnScrollListener(new x(this));
        absListView.setSelector(g.selector);
        absListView.setOnItemClickListener(this);
        inflate.findViewById(2131624180).setOnClickListener(this);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        if (this.f != null) {
            this.f.b();
        }
    }

    @TargetApi(16)
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = i + this.e;
        k kVar = (k) this.b.a(i2);
        int b = BazaarApplication.c().b() ? this.b.b(i2) : i2;
        if (kVar != null) {
            a.a(getActivity(), kVar.a, kVar.b, kVar.c, kVar.f, "apps_list_" + this.b.b().a + "_" + this.b.k + "_" + b);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b = g();
        this.b.l = this.d;
        View view2 = getView();
        if (view2 != null) {
            AbsListView absListView = (AbsListView) view2.findViewById(2131624286);
            if (absListView instanceof GridView) {
                HeaderGridView headerGridView = (HeaderGridView) absListView;
                headerGridView.setNumColumns(this.b.a(getResources()));
                headerGridView.setAdapter(this.b);
            } else {
                ((ListView) absListView).setAdapter(this.b);
            }
            if (this.b != null && this.b.isEmpty()) {
                this.b.a();
            }
            this.f = new com.farsitel.bazaar.receiver.b(absListView);
            this.f.a();
        }
    }
}
