package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.a.g;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.congenialmobile.util.WhatsNewActivity;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.d.au;
import com.farsitel.bazaar.d.av;
import com.farsitel.bazaar.d.cb;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.an;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.p;

public final class co extends y implements OnSharedPreferenceChangeListener, OnClickListener {
    public static final BazaarApplication a = BazaarApplication.c();
    private View A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private String G;
    private String H;
    private SharedPreferences I;
    private SharedPreferences J;
    private Button K;
    private Button L;
    private View M;
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private CheckBox r;
    private CheckBox s;
    private CheckBox t;
    private CheckBox u;
    private CheckBox v;
    private CheckBox w;
    private CheckBox x;
    private CheckBox y;
    private View z;

    public static co a() {
        return new co();
    }

    public final void b() {
        String string;
        if (this.I.getBoolean("schedule_update", false)) {
            this.o.setVisibility(8);
            this.D.setVisibility(0);
            this.p.setVisibility(0);
            this.q.setVisibility(0);
        } else {
            this.o.setVisibility(0);
            this.D.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
        int[] b = an.b();
        int[] c = an.c();
        int i = b[0];
        int i2 = b[1];
        int i3 = c[0];
        int i4 = c[1];
        CharSequence b2 = e.b(String.format(BazaarApplication.c().getResources().getString(2131165856), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        CharSequence b3 = e.b(String.format(BazaarApplication.c().getResources().getString(2131165856), new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
        this.K.setText(b2);
        this.L.setText(b3);
        i4 -= i2;
        if (i4 < 0) {
            i4 += 60;
            i3--;
        }
        i3 -= i;
        if (i3 < 0) {
            i3 += 24;
        }
        if (i3 == 1) {
            string = BazaarApplication.c().getResources().getString(2131165404, new Object[]{Integer.valueOf(i3)});
        } else {
            string = BazaarApplication.c().getResources().getString(2131165405, new Object[]{Integer.valueOf(i3)});
        }
        if (i4 == 1) {
            string = string + " " + BazaarApplication.c().getResources().getString(2131165231, new Object[]{Integer.valueOf(i4)});
        } else if (i4 > 1) {
            string = string + " " + BazaarApplication.c().getResources().getString(2131165232, new Object[]{Integer.valueOf(i4)});
        }
        this.p.setText(BazaarApplication.c().getResources().getString(2131165614, new Object[]{b2, b3, string}));
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        a a;
        c cVar;
        CheckBox checkBox;
        c cVar2;
        HomeActivity homeActivity;
        y a2;
        switch (view.getId()) {
            case 2131624144:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "lang"));
                new cz(getActivity(), this.H).e.show();
                return;
            case 2131624147:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "clear_search_history"));
                BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).edit().clear().commit();
                Toast.makeText(getActivity(), 2131165626, 0).show();
                return;
            case 2131624148:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "bazaar_system_app_info"));
                Intent intent = new Intent();
                int i = VERSION.SDK_INT;
                if (i >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
                } else {
                    String str = i == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
                    intent.setAction("android.intent.action.VIEW");
                    intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    intent.putExtra(str, getActivity().getPackageName());
                }
                startActivity(intent);
                return;
            case 2131624149:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "update_net_type"));
                new db(getActivity(), this.G).e.show();
                return;
            case 2131624152:
                checkBox = this.s;
                if (this.s.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624154:
                this.v.setChecked(!this.v.isChecked());
                return;
            case 2131624162:
                checkBox = this.y;
                if (this.y.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624164:
                checkBox = this.u;
                if (this.u.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624166:
                checkBox = this.x;
                if (this.x.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624168:
                checkBox = this.r;
                if (this.r.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624170:
                checkBox = this.t;
                if (this.t.isChecked()) {
                    z = false;
                }
                checkBox.setChecked(z);
                return;
            case 2131624171:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "suggest"));
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("text/plain");
                intent2.putExtra("android.intent.extra.SUBJECT", getActivity().getResources().getString(2131165679));
                intent2.putExtra("android.intent.extra.TEXT", getActivity().getResources().getString(2131165678));
                com.farsitel.bazaar.util.c.a(getActivity(), intent2, view);
                return;
            case 2131624172:
                a = a.a();
                cVar2 = new c();
                cVar2.c = "settings_frag";
                cVar2.e = "item_click";
                a.a(cVar2.b("item", "terms"));
                homeActivity = (HomeActivity) getActivity();
                a2 = ca.a();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(a2, z);
                return;
            case 2131624173:
                a = a.a();
                cVar = new c();
                cVar.c = "settings_frag";
                cVar.e = "item_click";
                a.a(cVar.b("item", "release_note"));
                WhatsNewActivity.b();
                return;
            case 2131624174:
                a = a.a();
                cVar2 = new c();
                cVar2.c = "settings_frag";
                cVar2.e = "item_click";
                a.a(cVar2.b("item", "about"));
                Intent intent3 = new Intent();
                intent3.setData(Uri.parse("bazaar://webview?title=" + getString(2131165235) + "&url" + "=http://cafebazaar.ir/client/about/?l=" + (BazaarApplication.c().b() ? "fa" : "en") + "&is_internal" + "=true"));
                homeActivity = (HomeActivity) getActivity();
                a2 = cb.a(intent3);
                if (getDialog() != null) {
                    z2 = true;
                }
                homeActivity.a(a2, z2);
                return;
            case 2131624175:
                a = a.a();
                cVar2 = new c();
                cVar2.c = "settings_frag";
                cVar2.e = "item_click";
                a.a(cVar2.b("item", "android_id"));
                ((ClipboardManager) getActivity().getSystemService("clipboard")).setText(p.a());
                Toast.makeText(getActivity(), getString(2131165342, p.a()), 1).show();
                return;
            case 2131624410:
                new av().show(getChildFragmentManager(), "stopTimePicker");
                return;
            case 2131624411:
                new au().show(getChildFragmentManager(), "startTimePicker");
                return;
            default:
                return;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.M = layoutInflater.inflate(2130903079, viewGroup, false);
        this.b = (TextView) this.M.findViewById(2131624174);
        this.b.setText(BazaarApplication.c().getResources().getString(2131165236, new Object[]{k.c()}));
        this.c = (TextView) this.M.findViewById(2131624173);
        this.d = (TextView) this.M.findViewById(2131624175);
        this.d.setText(BazaarApplication.c().getResources().getString(2131165806, new Object[]{p.a()}));
        this.e = this.M.findViewById(2131624144);
        this.f = this.M.findViewById(2131624149);
        this.j = this.M.findViewById(2131624154);
        this.v = (CheckBox) this.M.findViewById(2131624156);
        this.o = (TextView) this.M.findViewById(2131624157);
        this.w = (CheckBox) this.M.findViewById(2131624161);
        this.p = (TextView) this.M.findViewById(2131624159);
        this.q = (TextView) this.M.findViewById(2131624160);
        this.D = this.M.findViewById(2131624158);
        this.K = (Button) this.M.findViewById(2131624411);
        this.L = (Button) this.M.findViewById(2131624410);
        this.k = (TextView) this.M.findViewById(2131624172);
        this.l = (TextView) this.M.findViewById(2131624171);
        this.m = (TextView) this.M.findViewById(2131624147);
        this.n = (TextView) this.M.findViewById(2131624148);
        this.r = (CheckBox) this.M.findViewById(2131624169);
        this.z = this.M.findViewById(2131624168);
        this.t = (CheckBox) this.M.findViewById(g.shortcut);
        this.B = this.M.findViewById(2131624170);
        this.s = (CheckBox) this.M.findViewById(2131624153);
        this.A = this.M.findViewById(2131624152);
        this.u = (CheckBox) this.M.findViewById(2131624165);
        this.C = this.M.findViewById(2131624164);
        this.x = (CheckBox) this.M.findViewById(2131624167);
        this.E = this.M.findViewById(2131624166);
        this.y = (CheckBox) this.M.findViewById(2131624163);
        this.F = this.M.findViewById(2131624162);
        this.I = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        this.J = BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0);
        this.I.registerOnSharedPreferenceChangeListener(this);
        this.r.setChecked(this.I.getBoolean("asroot", false));
        this.s.setChecked(this.J.getBoolean("notify_on_new_updates", true));
        this.t.setChecked(this.J.getBoolean("add_shortcut_to_app", true));
        this.u.setChecked(this.J.getBoolean("save_apks", false));
        this.x.setChecked(this.J.getBoolean("optimized_bandwidth", true));
        this.y.setChecked(this.J.getBoolean("update_launcher_badge", false));
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.v.setChecked(this.I.getBoolean("schedule_update", false));
        this.j.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.r.setOnCheckedChangeListener(new cp(this));
        this.v.setOnCheckedChangeListener(new cs(this));
        this.z.setOnClickListener(this);
        this.s.setOnCheckedChangeListener(new ct(this));
        this.w.setChecked(this.I.getBoolean("pref_key_ptching", true));
        this.w.setOnCheckedChangeListener(new cu(this));
        this.B.setOnClickListener(this);
        this.t.setOnCheckedChangeListener(new cv(this));
        this.C.setOnClickListener(this);
        this.u.setOnCheckedChangeListener(new cw(this));
        this.E.setOnClickListener(this);
        this.x.setOnCheckedChangeListener(new cx(this));
        this.F.setOnClickListener(this);
        this.y.setOnCheckedChangeListener(new cy(this));
        this.A.setOnClickListener(this);
        onSharedPreferenceChanged(this.I, null);
        return this.M;
    }

    public final void onResume() {
        super.onResume();
        a(getString(2131165633));
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        CharSequence string;
        this.H = sharedPreferences.getString("locale", "DEFAULT");
        if (this.H.equals("fa")) {
            string = BazaarApplication.c().getResources().getString(2131165827);
        } else {
            Object string2 = this.H.equals("en") ? BazaarApplication.c().getResources().getString(2131165826) : this.H.equals("DEFAULT") ? BazaarApplication.c().getResources().getString(2131165294) : "";
        }
        ((TextView) this.M.findViewById(2131624146)).setText(string);
        this.G = sharedPreferences.getString("update_network_type", "network_type_wifi_3g");
        if (this.G.equals("network_type_wifi_3g")) {
            string = BazaarApplication.c().getResources().getString(2131165454);
        } else {
            string2 = BazaarApplication.c().getResources().getString(2131165453);
        }
        ((TextView) this.M.findViewById(2131624151)).setText(string);
        b();
    }

    public final void onStart() {
        super.onStart();
        a.d();
        i.a("/Settings");
    }
}
