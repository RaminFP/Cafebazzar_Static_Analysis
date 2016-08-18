package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.a.z;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.f;
import com.farsitel.bazaar.i;

public final class al extends w {
    private String d;
    private String e;

    public static al a(String str, k[] kVarArr, boolean z, String str2) {
        al alVar = new al();
        Bundle bundle = new Bundle();
        bundle.putString("android.intent.extra.TEXT", str);
        bundle.putString("android.intent.extra.REFERRER", str2);
        bundle.putSerializable("extra_apps", kVarArr);
        bundle.putBoolean("extra_show_ordinal", false);
        bundle.putInt("extra_transparent_content", 0);
        bundle.putBoolean("extra_collapse_action_bar", false);
        alVar.setArguments(bundle);
        return alVar;
    }

    public final int d() {
        return super.d();
    }

    public final String e() {
        return super.e();
    }

    protected final h g() {
        String string = getArguments().getString("android.intent.extra.TEXT");
        Object[] objArr = (Object[]) getArguments().getSerializable("extra_apps");
        boolean z = getArguments().getBoolean("extra_show_ordinal", false);
        this.a = getArguments().getInt("extra_transparent_content", 0);
        f[] fVarArr = new k[objArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            fVarArr[i] = (k) objArr[i];
        }
        return new z(getActivity(), LayoutInflater.from(getActivity()), string, fVarArr, this, z, this.a, null, getDialog() != null, this.e);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getArguments().getString("android.intent.extra.TEXT");
        this.e = getArguments().getString("android.intent.extra.REFERRER");
        this.c = getArguments().getBoolean("extra_collapse_action_bar");
    }

    public final void onResume() {
        super.onResume();
        if (this.d.equals("bought") || this.d.equals("installed") || this.d.equals("offline") || this.d.equals("by_author")) {
            BazaarApplication.c().d();
            i.a(("/NetApps/" + getArguments().getString("android.intent.extra.TEXT")).replace("?sm=", "/").replace("/?slug=", "/"));
        }
    }
}
