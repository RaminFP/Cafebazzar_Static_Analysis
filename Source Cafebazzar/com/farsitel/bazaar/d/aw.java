package com.farsitel.bazaar.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.h.b.t;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.ag;
import com.farsitel.bazaar.widget.BazaarAutoCompleteEditText;
import java.util.Stack;

public final class aw extends y {
    public BazaarAutoCompleteEditText a;
    public Stack b;
    boolean c;
    public ListView d;
    View e;
    Runnable f = new bf(this);
    private String j;
    private View k;
    private View l;
    private Handler m;
    private String n = "-1";
    private String o;
    private v p = new ax(this);

    public static aw b(String str) {
        aw awVar = new aw();
        Bundle bundle = new Bundle();
        bundle.putString("arg_query", null);
        awVar.setArguments(bundle);
        return awVar;
    }

    private void e(String str) {
        Fragment a = bg.a(str, String.valueOf(this.n));
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.add(2131624313, a);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    public final void a() {
        if (getChildFragmentManager().getBackStackEntryCount() == 0) {
            this.a.requestFocus();
            b();
            Context activity = getActivity();
            try {
                ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(this.a, 1);
            } catch (Exception e) {
            }
        }
    }

    public final void b() {
        this.p.b();
        if (this.m != null) {
            this.m.removeCallbacks(null);
            this.m.postDelayed(this.f, 0);
        }
    }

    public final void c() {
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str.trim()) || str.trim().equals(" ")) {
            this.a.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130968637));
            return;
        }
        this.a.setText(str);
        this.a.clearFocus();
        a a = a.a();
        c cVar = new c();
        cVar.c = "search_frag";
        cVar.e = "search";
        a.a(cVar.b("query", str));
        if (this.p != null) {
            this.p.b();
        }
        if (this.m != null) {
            this.m.removeCallbacks(this.f);
        }
        c();
        ag.a(getActivity(), this.a.getWindowToken());
        if (!(str == null || str.equals(""))) {
            String trim = str.trim();
            SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0);
            sharedPreferences.edit().putString("search_history_pref", sharedPreferences.getString("search_history_pref", "") + trim + "/").commit();
        }
        this.b.push(str);
        e(str);
        this.n = "-1";
    }

    public final void d(String str) {
        this.o = str;
        d.INSTANCE.a(this.p, new t(), BazaarApplication.c().a.getLanguage(), str);
    }

    public final void f() {
        super.f();
        while (getChildFragmentManager().getBackStackEntryCount() > 0) {
            getChildFragmentManager().popBackStackImmediate();
        }
        this.a.setText("");
        this.b.removeAllElements();
        a();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getChildFragmentManager() != null && getChildFragmentManager().getBackStackEntryCount() > 0) {
            ((Fragment) getChildFragmentManager().getFragments().get(getChildFragmentManager().getBackStackEntryCount() - 1)).onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new Stack();
        this.m = new Handler();
        if (getArguments() != null) {
            this.j = getArguments().getString("arg_query");
        }
        if (!TextUtils.isEmpty(this.j)) {
            e(this.j);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903119, viewGroup, false);
        this.d = (ListView) inflate.findViewById(2131624315);
        this.e = inflate.findViewById(2131624314);
        this.l = inflate.findViewById(2131624419);
        this.l.setOnClickListener(new ay(this));
        this.k = inflate.findViewById(2131624420);
        this.k.setOnClickListener(new az(this));
        this.a = (BazaarAutoCompleteEditText) inflate.findViewById(2131624418);
        this.a.setOnEditorActionListener(new ba(this));
        this.a.setOnTouchListener(new bb(this));
        this.a.addTextChangedListener(new bc(this));
        this.d.setOnItemClickListener(new bd(this));
        getChildFragmentManager().addOnBackStackChangedListener(new be(this));
        return inflate;
    }

    public final void onPause() {
        super.onPause();
        this.a.clearFocus();
        this.p.b();
    }

    public final void onResume() {
        super.onResume();
        if (((HomeActivity) getActivity()).b == 3) {
            a();
        }
    }
}
