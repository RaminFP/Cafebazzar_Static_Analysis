package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.d.a;
import com.farsitel.bazaar.d.aa;
import com.farsitel.bazaar.d.ab;
import com.farsitel.bazaar.d.af;
import com.farsitel.bazaar.d.ag;
import com.farsitel.bazaar.d.ai;
import com.farsitel.bazaar.d.aj;
import com.farsitel.bazaar.d.ak;
import com.farsitel.bazaar.d.al;
import com.farsitel.bazaar.d.aw;
import com.farsitel.bazaar.d.bo;
import com.farsitel.bazaar.d.bs;
import com.farsitel.bazaar.d.bw;
import com.farsitel.bazaar.d.cb;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.a.r;
import com.farsitel.bazaar.h.a.s;
import com.farsitel.bazaar.h.b.au;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.at;
import com.farsitel.bazaar.util.c;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.widget.HomeTabBar;
import com.farsitel.bazaar.widget.NonSwipeableViewPager;
import com.farsitel.bazaar.widget.w;
import java.util.ArrayList;

public class HomeActivity extends FragmentActivity implements w {
    public aj a;
    public int b;
    HomeTabBar c;
    private ProgressDialog d;
    private NonSwipeableViewPager e;
    private Intent f;
    private boolean g;
    private int h;

    private void a(Intent intent) {
        findViewById(2131624115).getViewTreeObserver().addOnGlobalLayoutListener(new bh(this, intent));
    }

    private void b(Intent intent, boolean z, boolean z2) {
        Uri data = intent.getData();
        if (data != null) {
            String queryParameter = data.getQueryParameter("slug");
            String queryParameter2 = data.getQueryParameter("ref");
            String queryParameter3 = data.getQueryParameter("vs");
            String queryParameter4 = data.getQueryParameter("vst");
            if (queryParameter != null) {
                Bundle extras = intent.getExtras();
                String queryParameter5;
                if (queryParameter.startsWith("by_author")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    queryParameter5 = data.getQueryParameter("aid");
                    queryParameter = intent.getStringExtra("name");
                    if (TextUtils.isEmpty(queryParameter2)) {
                        queryParameter2 = "by_author";
                    }
                    a(u.a("developer_apps/?slug=" + queryParameter5, queryParameter, queryParameter2, queryParameter3, queryParameter4), z);
                } else if (queryParameter.startsWith("by_category")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(2));
                    }
                    queryParameter5 = data.getQueryParameter("cid");
                    queryParameter = intent.getStringExtra("name");
                    if (TextUtils.isEmpty(queryParameter2)) {
                        queryParameter2 = "by_category";
                    }
                    a(u.a("category/?cat=" + queryParameter5, queryParameter, queryParameter2, queryParameter3, queryParameter4), z);
                } else {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    queryParameter5 = data.getQueryParameter("title");
                    if (extras != null && TextUtils.isEmpty(queryParameter5)) {
                        queryParameter5 = extras.getString("android.intent.extra.TITLE");
                    }
                    a(u.a(queryParameter, queryParameter5, queryParameter2, queryParameter3, queryParameter4), z);
                }
            }
        }
    }

    private void c(Intent intent, boolean z, boolean z2) {
        Uri data = intent.getData();
        String queryParameter = data.getQueryParameter("slug");
        String queryParameter2 = data.getQueryParameter("ref");
        if (queryParameter != null) {
            boolean z3 = true;
            switch (queryParameter.hashCode()) {
                case -1999270845:
                    if (queryParameter.equals("upgradable")) {
                        z3 = true;
                        break;
                    }
                    break;
                case -1548612125:
                    if (queryParameter.equals("offline")) {
                        z3 = true;
                        break;
                    }
                    break;
                case -1383211797:
                    if (queryParameter.equals("bought")) {
                        z3 = true;
                        break;
                    }
                    break;
                case -1271710635:
                    if (queryParameter.equals("bookmarked")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 29046650:
                    if (queryParameter.equals("installed")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 691917427:
                    if (queryParameter.equals("by_author")) {
                        z3 = false;
                        break;
                    }
                    break;
            }
            String stringExtra;
            y l;
            switch (z3) {
                case false:
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    String queryParameter3 = data.getQueryParameter("aid");
                    stringExtra = intent.getStringExtra("name");
                    if (TextUtils.isEmpty(queryParameter2)) {
                        queryParameter2 = "by_author";
                    }
                    a(u.a("developer_apps/?slug=" + queryParameter3, stringExtra, queryParameter2), z);
                    return;
                case true:
                    l = bw.l();
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(4));
                    }
                    a(l, z);
                    return;
                case true:
                    l = ab.l();
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(4));
                    }
                    a(l, z);
                    return;
                case true:
                    l = ak.l();
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(4));
                    }
                    a(l, z);
                    return;
                case true:
                    l = af.l();
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(4));
                    }
                    a(l, z);
                    return;
                case true:
                    if (intent.getExtras() != null && intent.getExtras().containsKey("extra_apps")) {
                        stringExtra = TextUtils.isEmpty(queryParameter2) ? "offline_collection" : queryParameter2;
                        Object[] objArr = (Object[]) intent.getExtras().getSerializable("extra_apps");
                        k[] kVarArr = new k[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            kVarArr[i] = (k) objArr[i];
                        }
                        l = al.a(queryParameter, kVarArr, false, stringExtra);
                        if (z2) {
                            this.c.setSelectedTab(Integer.valueOf(4));
                        }
                        a(l, z);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void d(HomeActivity homeActivity) {
        Toast makeText = Toast.makeText(homeActivity, "", 1);
        makeText.setView(((LayoutInflater) homeActivity.getSystemService("layout_inflater")).inflate(2130903185, null));
        makeText.show();
    }

    public final void a(Intent intent, boolean z, boolean z2) {
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                String replace = data.toString().replace("bazaar://", "").replace("market://", "");
                if (replace.startsWith("search")) {
                    this.c.setSelectedTab(Integer.valueOf(3));
                    ai aiVar = this.a.b[3];
                    String queryParameter = data.getQueryParameter("q");
                    if (aiVar.a == 3 && aiVar.getChildFragmentManager().getBackStackEntryCount() > 0) {
                        Fragment fragment = (Fragment) aiVar.getChildFragmentManager().getFragments().get(0);
                        if (fragment instanceof aw) {
                            ((aw) fragment).c(queryParameter);
                        }
                    }
                } else if (replace.startsWith("page") || replace.startsWith("collection")) {
                    intent.setData(Uri.parse(data.toString().replace("bazaar://collection", "bazaar://page")));
                    b(intent, z, z2);
                } else if (replace.toLowerCase().contains("cafebazaar.ir/pages/")) {
                    intent.setData(Uri.parse("bazaar://page?slug=" + data.toString().replace("cafebazaar.ir/pages/", "").replace("https://", "").replace("http://", "").replace("/?", "&").replace("?", "&")));
                    b(intent, z, z2);
                } else if (replace.toLowerCase().contains("cafebazaar.ir/lists/")) {
                    intent.setData(Uri.parse("bazaar://page?slug=dynamic?slug=" + data.toString().replace("cafebazaar.ir/lists/", "").replace("https://", "").replace("http://", "").replace("/?", "&").replace("?", "&")));
                    b(intent, z, z2);
                } else if (replace.toLowerCase().contains("cafebazaar.ir/verify/")) {
                    this.d.show();
                    Object lastPathSegment = data.getLastPathSegment();
                    if (lastPathSegment != null && !TextUtils.isEmpty(lastPathSegment)) {
                        b biVar = new bi(this);
                        r rVar = new r(lastPathSegment);
                        rVar.c = biVar;
                        d.INSTANCE.a(new s(rVar, biVar), new au(), rVar.a(rVar.b));
                    }
                } else if (replace.toLowerCase().contains("cafebazaar.ir/developer")) {
                    replace = data.toString().substring(data.toString().indexOf("/developer/") + 11);
                    if (replace.contains("/")) {
                        replace = replace.substring(0, replace.indexOf("/"));
                    }
                    if (replace.contains("?")) {
                        replace = replace.substring(0, replace.indexOf("?"));
                    }
                    intent.setData(Uri.parse("bazaar://page?slug=by_author&aid=" + replace));
                    b(intent, z, z2);
                } else if (replace.startsWith("details") || replace.toLowerCase().contains("cafebazaar.ir/app/") || replace.toLowerCase().contains("play.google.com") || replace.toLowerCase().contains("market.android.com")) {
                    if ("android.intent.action.EDIT".equals(intent.getAction())) {
                        replace = Uri.parse(data.toString()).getQueryParameter("id");
                        if (replace == null) {
                            replace = data.getQueryParameter("app");
                        }
                        if (replace == null) {
                            replace = data.getPath().replace("/app/", "").replaceAll("/", "");
                        }
                        if (replace != null) {
                            ReviewActivity.a(this, replace);
                            finish();
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(a.a(data.toString(), "", "", 0.0f, intent.getAction()), true);
                } else if (replace.startsWith("catslist") || replace.toLowerCase().contains("cafebazaar.ir/catslist/")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(2));
                    }
                    this.a.b[2].a();
                } else if (replace.startsWith("downloads")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(4));
                    }
                    this.a.b[4].a();
                } else if (replace.startsWith("apps")) {
                    c(intent, z, z2);
                } else if (replace.startsWith("account")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    if (j.a().n()) {
                        a(a.a(), true);
                        return;
                    }
                    Intent intent2 = new Intent(this, JoinActivity.class);
                    intent2.putExtra("extra_referer", "external_intent");
                    c.a(intent2);
                    if (BazaarApplication.c().b()) {
                        intent2.putExtra("bazaar_activity_start_enter_anim", 2130968620);
                        intent2.putExtra("bazaar_activity_start_exit_anim", 2130968617);
                        intent2.putExtra("bazaar_activity_finish_enter_anim", 0);
                        if (o.e()) {
                            intent2.putExtra("bazaar_activity_finish_exit_anim", 2130968621);
                        } else {
                            intent2.putExtra("bazaar_activity_finish_exit_anim", 2130968587);
                        }
                    } else {
                        intent2.putExtra("bazaar_activity_start_enter_anim", 2130968620);
                        intent2.putExtra("bazaar_activity_start_exit_anim", 2130968617);
                        intent2.putExtra("bazaar_activity_finish_enter_anim", 0);
                        if (o.e()) {
                            intent2.putExtra("bazaar_activity_finish_exit_anim", 2130968621);
                        } else {
                            intent2.putExtra("bazaar_activity_finish_exit_anim", 2130968586);
                        }
                    }
                    try {
                        startActivity(intent2);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(BazaarApplication.c(), 2131165703, 0).show();
                    }
                } else if (replace.startsWith("feedback")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(bs.a(), true);
                } else if (replace.startsWith("support")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(bo.g(), true);
                } else if (replace.startsWith("settings")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(co.a(), true);
                } else if (replace.startsWith("webview")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(cb.a(intent), z);
                } else if (replace.startsWith("change_email")) {
                    a(ag.a(true), z);
                } else if (replace.startsWith("change_phone")) {
                    a(ag.a(false), z);
                } else if (replace.startsWith("notes")) {
                    if (z2) {
                        this.c.setSelectedTab(Integer.valueOf(0));
                    }
                    a(ca.a(), z);
                } else {
                    try {
                        c.a(this, intent);
                    } catch (Exception e2) {
                        Toast.makeText(this, getString(2131165374), 0).show();
                    }
                }
            }
        }
    }

    public final void a(y yVar, boolean z) {
        a(yVar, z, bj.APPEAR);
    }

    public final void a(y yVar, boolean z, bj bjVar) {
        this.h++;
        aj ajVar = this.a;
        FragmentManager childFragmentManager = ajVar.b[this.b].getChildFragmentManager();
        com.farsitel.bazaar.util.ag.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
        try {
            if (o.e() && z && DialogFragment.class.isInstance(yVar)) {
                yVar.show(childFragmentManager, "dialog_fragment");
            } else {
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                if (bjVar != null) {
                    beginTransaction.setCustomAnimations(bjVar.f, 0, 0, bjVar.g);
                }
                beginTransaction.add(2131624299, (Fragment) yVar);
                beginTransaction.addToBackStack(null);
                beginTransaction.commitAllowingStateLoss();
                if (childFragmentManager.getBackStackEntryCount() > 0) {
                    ajVar = this.a;
                    childFragmentManager = ajVar.b[this.b].getChildFragmentManager();
                    y yVar2 = (y) childFragmentManager.getFragments().get(childFragmentManager.getBackStackEntryCount() - 1);
                    if (!o.e()) {
                        new Handler().postDelayed(new aa(yVar2), 100);
                    }
                }
            }
            System.gc();
            yVar.b(true);
        } catch (Exception e) {
            BazaarApplication.c().a(this.f, false);
        }
    }

    public final void a(Object obj, boolean z) {
        com.farsitel.bazaar.util.ag.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
        int intValue = ((Integer) obj).intValue();
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
        cVar.f = z ? "user" : "system";
        cVar.e = "change_tab";
        cVar.c = "main";
        a.a(cVar.b("from", Integer.valueOf(this.b)).b("to", Integer.valueOf(intValue)));
        if (z) {
            this.g = false;
            this.h = -1;
        }
        this.b = intValue;
        switch (intValue) {
            case 0:
                this.e.a(0, false);
                break;
            case 1:
                this.e.a(1, false);
                break;
            case 2:
                this.e.a(2, false);
                break;
            case 3:
                this.e.a(3, false);
                break;
            case 4:
                this.e.a(4, false);
                break;
        }
        ai aiVar = this.a.b[intValue];
        long currentTimeMillis = System.currentTimeMillis();
        if (aiVar.b > 0 && currentTimeMillis - aiVar.b > 300000) {
            aiVar.a();
        }
        aiVar.b = currentTimeMillis;
        if (aiVar.a == 3 && aiVar.getChildFragmentManager().getFragments() != null && aiVar.getChildFragmentManager().getFragments().size() > 0) {
            ((aw) aiVar.getChildFragmentManager().getFragments().get(0)).a();
        }
    }

    public final void b(Object obj, boolean z) {
        com.farsitel.bazaar.util.ag.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
        if (z) {
            ai aiVar = this.a.b[((Integer) obj).intValue()];
            if (aiVar.getChildFragmentManager().getBackStackEntryCount() > 1) {
                aiVar.a();
            } else if (aiVar.getChildFragmentManager().getFragments() != null && aiVar.getChildFragmentManager().getFragments().size() > 0) {
                ((y) aiVar.getChildFragmentManager().getFragments().get(0)).f();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        aj ajVar = this.a;
        ajVar.b[this.b].onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.g && this.h == 0) {
            finish();
            return;
        }
        boolean z;
        this.h--;
        ai aiVar = this.a.b[this.b];
        if (aiVar.a == 3 || aiVar.getChildFragmentManager().getBackStackEntryCount() > 1) {
            Fragment fragment = (Fragment) aiVar.getChildFragmentManager().getFragments().get(aiVar.getChildFragmentManager().getBackStackEntryCount() - 1);
            if (aiVar.a != 3 || fragment == null) {
                aiVar.getChildFragmentManager().popBackStackImmediate();
                z = true;
            } else if (fragment instanceof aw) {
                aw awVar = (aw) fragment;
                if (awVar.d.getVisibility() == 0) {
                    awVar.c();
                    z = true;
                } else if (awVar.getChildFragmentManager().getBackStackEntryCount() > 0) {
                    awVar.getChildFragmentManager().popBackStackImmediate();
                    awVar.b.pop();
                    awVar.a.setText(awVar.b.size() > 0 ? (String) awVar.b.peek() : "");
                    z = true;
                } else {
                    z = false;
                }
            } else {
                aiVar.getChildFragmentManager().popBackStackImmediate();
                z = true;
            }
        } else {
            z = false;
        }
        if (z) {
            FragmentManager childFragmentManager = this.a.b[this.b].getChildFragmentManager();
            y yVar = (y) childFragmentManager.getFragments().get(childFragmentManager.getBackStackEntryCount() - 1);
            if (yVar != null) {
                yVar.b(false);
            }
        } else if (this.b != 0) {
            this.c.setSelectedTab(Integer.valueOf(0));
        } else {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o.e()) {
            setRequestedOrientation(1);
        }
        this.f = getIntent();
        setContentView(2130903073);
        com.farsitel.bazaar.util.k.a((Activity) this);
        this.d = new ProgressDialog(this);
        this.d.setMessage(getString(2131165546));
        this.d.setCancelable(false);
        this.e = (NonSwipeableViewPager) findViewById(2131624116);
        this.a = new aj(getSupportFragmentManager());
        this.e.setAdapter(this.a);
        NonSwipeableViewPager nonSwipeableViewPager = this.e;
        this.a.getClass();
        nonSwipeableViewPager.setOffscreenPageLimit(5);
        ViewPager viewPager = this.e;
        bg bgVar = new bg(this);
        if (viewPager.a == null) {
            viewPager.a = new ArrayList();
        }
        viewPager.a.add(bgVar);
        this.c = (HomeTabBar) findViewById(2131624115);
        this.c.setOnTabItemClickListener(this);
        a(getIntent());
        if (VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
            at atVar = new at(this);
            atVar.a(true);
            atVar.a(getResources().getColor(2131558471));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f = intent;
        a(intent);
    }
}
