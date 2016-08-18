package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.a.s;
import com.congenialmobile.util.WhatsNewActivity;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.ac;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.a.z;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.f.a.a;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.e.c;
import com.farsitel.bazaar.g.e.d;
import com.farsitel.bazaar.g.e.e;
import com.farsitel.bazaar.g.e.f;
import com.farsitel.bazaar.h.b.q;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.SnappingHorizontalScrollView;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.w;
import com.farsitel.bazaar.widget.BazaarTitleBar;
import com.farsitel.bazaar.widget.ForegroundImageView;
import com.farsitel.bazaar.widget.HeaderGridView;
import com.farsitel.bazaar.widget.RetryView;
import com.farsitel.bazaar.widget.listener.BazaarExpandableTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class u extends y implements a, b {
    protected String a;
    protected String b;
    public boolean c;
    public String d;
    public v e = new v(this);
    Runnable f = new aa(this);
    private final int j = 5000;
    private h k;
    private Queue l = new LinkedList();
    private al m;
    private RetryView n;
    private View o;
    private ProgressBar p;
    private int q;
    private Handler r;
    private int s;
    private ProgressDialog t;
    private c u;
    private SnappingHorizontalScrollView v;
    private com.farsitel.bazaar.receiver.b w;

    public static u a(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public static u a(String str, String str2, String str3, String str4, String str5) {
        u uVar = new u();
        Bundle bundle = new Bundle();
        bundle.putString("page_slug", str);
        bundle.putString("title", str2);
        bundle.putString("page_referrer", str3);
        bundle.putString("page_video_hash_or_url", str4);
        bundle.putString("page_video_type", str5);
        uVar.setArguments(bundle);
        return uVar;
    }

    public static u a(String str, String str2, String str3, boolean z) {
        u uVar = new u();
        Bundle bundle = new Bundle();
        bundle.putBoolean("page_show_title_bar", z);
        bundle.putString("page_slug", str);
        bundle.putString("title", str2);
        bundle.putString("page_referrer", str3);
        uVar.setArguments(bundle);
        return uVar;
    }

    private ArrayList a(e[] eVarArr, String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i / 2);
        layoutParams.setMargins(0, 0, 0, 0);
        int i3 = 0;
        for (e eVar : eVarArr) {
            View inflate = getActivity().getLayoutInflater().inflate(2130903134, null);
            ForegroundImageView foregroundImageView = (ForegroundImageView) inflate.findViewById(2131624336);
            foregroundImageView.setForegroundResource(g.splash_selector);
            a(eVar.b(), foregroundImageView.getImageView(), i3);
            foregroundImageView.setOnClickListener(new z(this, eVar, str));
            inflate.setLayoutParams(layoutParams);
            arrayList.add(inflate);
            i3++;
        }
        return arrayList;
    }

    private void a(String str, ImageView imageView) {
        ab.a().a(str, imageView, true, new ab(this));
    }

    private void a(String str, ImageView imageView, int i) {
        imageView.setTag(2131165843, str);
        for (al alVar : this.l) {
            if (alVar.c == i) {
                return;
            }
        }
        this.l.offer(new al(this, str, imageView, i));
        if (this.m == null) {
            this.m = (al) this.l.poll();
            a(this.m.a, this.m.b);
        }
    }

    private void a(e[] eVarArr, String str) {
        int width = (getView() != null ? getView().getWidth() : o.f()) / (getDialog() != null ? Math.min(getResources().getInteger(2131296269), 2) : getResources().getInteger(2131296269));
        this.v.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Object a = a(eVarArr, str, width, 0);
        if (BazaarApplication.c().b()) {
            Collections.reverse(a);
        }
        ((LinearLayout) this.v.getChildAt(0)).removeAllViews();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((LinearLayout) this.v.getChildAt(0)).addView((View) it.next());
        }
        ViewTreeObserver viewTreeObserver = this.v.getChildAt(0).getViewTreeObserver();
        this.v.setItemWidth(width);
        viewTreeObserver.addOnPreDrawListener(new x(this));
        this.v.setOnScrollChangedListener(new y(this));
        this.r.postDelayed(this.f, 5000);
    }

    public h a(c cVar) {
        return new z(getActivity(), LayoutInflater.from(getActivity()), this.a, cVar.j, this, cVar.i, 1, cVar.g, getDialog() != null, this.u.h);
    }

    public final void a() {
        if (this.s == 0 || this.s != d.a) {
            if (this.o != null) {
                this.o.setVisibility(0);
            }
        } else if (this.p != null) {
            this.p.setVisibility(0);
        }
    }

    public final void a(int i, Map map) {
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.p != null) {
            this.p.setVisibility(8);
        }
        if (this.n != null) {
            this.n.setVisibility(0);
            RetryView retryView = this.n;
            map.get("general");
            retryView.a(i, new w(this), this);
        }
    }

    protected final void a(JSONObject jSONObject) {
        f[] fVarArr;
        int i;
        boolean z = true;
        c cVar = new c();
        if (jSONObject.has("background")) {
            cVar.f = jSONObject.getString("background");
        }
        if (jSONObject.has("text_color")) {
            cVar.g = jSONObject.getString("text_color");
        }
        if (jSONObject.has("description")) {
            cVar.b = jSONObject.getString("description");
        } else {
            cVar.b = "";
        }
        if (jSONObject.has("title")) {
            cVar.a = jSONObject.getString("title");
        }
        if (jSONObject.has("ref")) {
            cVar.h = jSONObject.getString("ref");
        }
        if (jSONObject.has("action")) {
            cVar.k = jSONObject.getString("action");
        }
        if (jSONObject.has("has_ordinal")) {
            cVar.i = jSONObject.getBoolean("has_ordinal");
        }
        JSONArray jSONArray;
        if (jSONObject.getString("type").equalsIgnoreCase("vitrin")) {
            cVar.c = d.b;
            jSONArray = jSONObject.getJSONArray("rows");
            fVarArr = new f[jSONArray.length()];
            for (i = 0; i < jSONArray.length(); i++) {
                fVarArr[i] = f.a(jSONArray.getJSONObject(i));
            }
            cVar.e = fVarArr;
        } else {
            cVar.c = d.a;
            jSONArray = jSONObject.getJSONArray("app_list");
            com.farsitel.bazaar.g.f[] fVarArr2 = new com.farsitel.bazaar.g.f[jSONArray.length()];
            i = 0;
            while (i < jSONArray.length()) {
                if (jSONArray.getJSONObject(i).has("type") && jSONArray.getJSONObject(i).getString("type").equals("promo")) {
                    fVarArr2[i] = new e(jSONArray.getJSONObject(i));
                } else {
                    fVarArr2[i] = new k(jSONArray.getJSONObject(i));
                }
                i++;
            }
            cVar.j = fVarArr2;
        }
        if (jSONObject.has("header")) {
            com.farsitel.bazaar.g.e.a aVar;
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            com.farsitel.bazaar.g.e.a aVar2 = new com.farsitel.bazaar.g.e.a();
            if (jSONObject2.has("type")) {
                String string = jSONObject2.getString("type");
                if (jSONObject2.has("ref")) {
                    aVar2.d = jSONObject2.getString("ref");
                }
                if (string.equalsIgnoreCase("hero")) {
                    aVar2.a = com.farsitel.bazaar.g.e.b.a;
                    e eVar = new e();
                    eVar.a = jSONObject2.getString("im");
                    aVar2.b = eVar;
                    aVar = aVar2;
                } else {
                    aVar2.a = com.farsitel.bazaar.g.e.b.b;
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("content");
                    e[] eVarArr = new e[jSONArray2.length()];
                    for (i = 0; i < jSONArray2.length(); i++) {
                        eVarArr[i] = new e(jSONArray2.getJSONObject(i));
                    }
                    aVar2.c = eVarArr;
                    aVar = aVar2;
                }
            } else {
                aVar = null;
            }
            cVar.d = aVar;
        } else {
            cVar.d = null;
        }
        this.u = cVar;
        if (this.i) {
            if (!(this.c || "home".equals(this.a))) {
                a(this.u.a);
            }
        } else if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (!this.c) {
            com.a.a.a.a.c().a((s) ((s) ((s) new s().b(this.u.a).a(this.a).c("catalogue page").a("NFC state", com.farsitel.bazaar.util.s.b())).a("bluetooth state", com.farsitel.bazaar.util.s.c())).a("referrer", "- " + this.b));
            com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
            com.farsitel.bazaar.g.c cVar2 = new com.farsitel.bazaar.g.c();
            cVar2.f = "user";
            cVar2.c = "page";
            cVar2 = cVar2.a("slug", this.a);
            cVar2.e = "page_visit";
            a.a(cVar2.b("referer", this.b));
        }
        this.s = this.u.c;
        ImageView imageView = (ImageView) getView().findViewById(2131624295);
        NestedScrollView nestedScrollView = (NestedScrollView) getView().findViewById(2131624292);
        AbsListView absListView = (AbsListView) getView().findViewById(2131624286);
        int i2;
        if (this.u.c == d.b) {
            nestedScrollView.setVisibility(0);
            absListView.setVisibility(8);
            nestedScrollView.setOnScrollChangeListener(new ad(this, nestedScrollView));
            Activity activity = getActivity();
            LayoutInflater from = LayoutInflater.from(getActivity());
            fVarArr = this.u.e;
            String str = this.u.g;
            String str2 = this.u.f;
            String str3 = this.u.h;
            if (getDialog() == null) {
                z = false;
            }
            ac acVar = new ac(activity, from, fVarArr, str, str2, str3, z);
            LinearLayout linearLayout = (LinearLayout) getView().findViewById(2131624297);
            for (i2 = 0; i2 < acVar.getCount(); i2++) {
                View view = acVar.getView(i2, null, null);
                com.farsitel.bazaar.util.g.a(getActivity(), view, (float) i2);
                linearLayout.addView(view);
            }
            this.v = (SnappingHorizontalScrollView) getView().findViewById(2131624293);
            if (this.u.d != null) {
                switch (ac.a[this.u.d.a - 1]) {
                    case 1:
                        this.v.setVisibility(8);
                        imageView.setVisibility(0);
                        ab.a().a(this.u.d.b.b(), imageView, new ae(this, imageView));
                        break;
                    case 2:
                        if (this.u.d.c.length <= 0) {
                            this.v.setVisibility(8);
                            imageView.setVisibility(8);
                            break;
                        }
                        a(this.u.d.c, this.u.h);
                        imageView.setVisibility(8);
                        this.v.setVisibility(0);
                        break;
                }
            }
            this.v.setVisibility(8);
            imageView.setVisibility(8);
            BazaarExpandableTextView bazaarExpandableTextView = (BazaarExpandableTextView) getView().findViewById(2131624296);
            if (TextUtils.isEmpty(this.u.b)) {
                ((View) bazaarExpandableTextView.getParent()).setVisibility(8);
            } else {
                bazaarExpandableTextView.setText(Html.fromHtml(this.u.b));
                bazaarExpandableTextView.setTextColor(this.u.g);
                bazaarExpandableTextView.setBackgroundColor(Color.parseColor(this.u.f));
                if (!TextUtils.isEmpty(this.u.k)) {
                    int a2 = w.a(8);
                    bazaarExpandableTextView.setPadding(a2, a2 << 1, a2, a2 << 1);
                    bazaarExpandableTextView.setAction(new af(this));
                }
                bazaarExpandableTextView.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.u.f)) {
                nestedScrollView.setBackgroundColor(Color.parseColor(this.u.f));
            }
        } else if (this.u.c == d.a) {
            nestedScrollView.setVisibility(8);
            absListView.setVisibility(0);
            absListView.setOnScrollListener(new ag(this, absListView));
            this.k = a(this.u);
            View inflate = getActivity().getLayoutInflater().inflate(2130903136, null);
            BazaarExpandableTextView bazaarExpandableTextView2 = (BazaarExpandableTextView) inflate.findViewById(2131624296);
            ImageView imageView2 = (ImageView) inflate.findViewById(2131624340);
            this.v = (SnappingHorizontalScrollView) inflate.findViewById(2131624341);
            if (this.u.d != null) {
                switch (ac.a[this.u.d.a - 1]) {
                    case 1:
                        imageView2.setVisibility(0);
                        ab.a().a(this.u.d.b.b(), imageView2, new ah(this, imageView2));
                        this.v.setVisibility(8);
                        break;
                    case 2:
                        if (this.u.d.c.length <= 0) {
                            imageView2.setVisibility(8);
                            this.v.setVisibility(8);
                            break;
                        }
                        a(this.u.d.c, this.u.h);
                        imageView2.setVisibility(8);
                        this.v.setVisibility(0);
                        break;
                }
            }
            imageView2.setVisibility(8);
            this.v.setVisibility(8);
            if (TextUtils.isEmpty(this.u.b)) {
                ((View) bazaarExpandableTextView2.getParent()).setVisibility(8);
            } else {
                bazaarExpandableTextView2.setText(Html.fromHtml(this.u.b));
                bazaarExpandableTextView2.setTextColor(this.u.g);
                bazaarExpandableTextView2.setBackgroundColor(Color.parseColor(this.u.f));
                if (!TextUtils.isEmpty(this.u.k)) {
                    i2 = w.a(8);
                    bazaarExpandableTextView2.setPadding(i2, i2 << 1, i2, i2 << 1);
                    bazaarExpandableTextView2.setAction(new ai(this));
                }
                bazaarExpandableTextView2.setVisibility(0);
            }
            if (absListView instanceof GridView) {
                ((HeaderGridView) absListView).a(inflate, null, false);
                ((GridView) absListView).setNumColumns(this.k.k);
                ((GridView) absListView).setAdapter(this.k);
                this.w = new com.farsitel.bazaar.receiver.b(absListView);
                this.w.a();
                i2 = this.k.k;
            } else {
                ((ListView) absListView).addHeaderView(inflate, null, false);
                ((ListView) absListView).setAdapter(this.k);
                this.w = new com.farsitel.bazaar.receiver.b(absListView);
                this.w.a();
                i2 = 1;
            }
            TextView textView = (TextView) getView().findViewById(2131624178);
            CharSequence d = d();
            if (d != null) {
                textView.setText(d);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            absListView.setEmptyView(textView);
            h hVar = this.k;
            if (this.q != 1) {
                z = false;
            }
            hVar.l = z;
            absListView.setOnItemClickListener(new aj(this, i2));
            if (!TextUtils.isEmpty(this.u.f)) {
                absListView.setBackgroundColor(Color.parseColor(this.u.f));
            }
        }
        b();
        com.farsitel.bazaar.util.a.a(false);
        ReviewActivity.a();
    }

    public final void b() {
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.p != null) {
            this.p.setVisibility(8);
        }
    }

    public final void c() {
        e();
    }

    public String d() {
        return getResources().getString(2131165478);
    }

    public void e() {
        a();
        com.farsitel.bazaar.h.d.INSTANCE.a(this.e, this.b, new q(), BazaarApplication.c().a.getLanguage(), this.a, Integer.valueOf(0));
    }

    public final void f() {
        super.f();
        if (getView() != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) getView().findViewById(2131624292);
            AbsListView absListView = (AbsListView) getView().findViewById(2131624286);
            if (nestedScrollView != null) {
                nestedScrollView.a(0, 0);
            } else if (absListView != null) {
                absListView.smoothScrollToPosition(0);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.k != null && this.k.n != null) {
            this.k.n.a(i, i2, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        BazaarApplication.c().a(configuration);
        getView().getViewTreeObserver().addOnGlobalLayoutListener(new ak(this));
        AbsListView absListView = (AbsListView) getView().findViewById(2131624286);
        if (this.k != null && (absListView instanceof GridView)) {
            ((GridView) absListView).setNumColumns(this.k.a(getResources()));
            this.k.notifyDataSetChanged();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903112, null);
        this.q++;
        this.n = (RetryView) inflate.findViewById(2131624207);
        this.p = (ProgressBar) inflate.findViewById(2131624288);
        this.o = inflate.findViewById(2131624179);
        this.t = new ProgressDialog(getActivity());
        this.t.setMessage(getString(2131165546));
        this.t.setCancelable(false);
        this.b = getArguments().getString("page_referrer");
        this.a = getArguments().getString("page_slug");
        this.i = getArguments().getBoolean("page_show_title_bar", true);
        Object string = getArguments().getString("page_video_hash_or_url");
        String string2 = getArguments().getString("page_video_type");
        char charAt = string2 != null ? string2.charAt(0) : 'U';
        if (!TextUtils.isEmpty(string)) {
            VideoPlayerActivity.a(getActivity(), string, charAt, null);
        }
        a();
        e();
        this.r = new Handler();
        WhatsNewActivity.a();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
        cVar.f = "user";
        cVar.c = "page";
        cVar = cVar.a("slug", this.a);
        cVar.e = "close";
        a.a(cVar.b("referer", this.b));
        this.e.b();
        this.t = null;
        if (this.r != null) {
            this.r.removeCallbacks(null);
            this.r = null;
        }
        this.p = null;
        this.o = null;
        this.n = null;
    }

    public void onDetach() {
        super.onDetach();
        if (this.w != null) {
            this.w.b();
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.c && "home".equals(this.a) && this.h != null) {
            BazaarTitleBar bazaarTitleBar = this.h;
            bazaarTitleBar.d.setVisibility(0);
            bazaarTitleBar.b.setVisibility(0);
            bazaarTitleBar.c.setVisibility(0);
            bazaarTitleBar = this.h;
            ab.a().a("http://fe.cafebazaar.ir/static/fehrest/images/bazaar_logo.png?" + (System.currentTimeMillis() / 10800000), bazaarTitleBar.a, false, (int) g.ic_bazaar_logo_green);
            bazaarTitleBar.a.setVisibility(0);
        }
    }
}
