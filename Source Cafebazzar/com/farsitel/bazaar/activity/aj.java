package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.e.e;

final class aj implements OnItemClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ u b;

    aj(u uVar, int i) {
        this.b = uVar;
        this.a = i;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = i - this.a;
        if (this.b.k.a(i2) instanceof k) {
            k kVar = (k) this.b.k.a(i2);
            if (kVar != null) {
                String str;
                if (TextUtils.isEmpty(this.b.u.h)) {
                    str = "apps_list_" + this.b.k.b().a;
                } else {
                    String str2 = this.b.u.h;
                    if (this.b.c && !TextUtils.isEmpty(this.b.d)) {
                        str2 = str2 + "|" + this.b.d;
                    }
                    str = str2 + "|" + kVar.n;
                }
                a.a(this.b.getActivity(), kVar.a, kVar.b, kVar.c, kVar.f, str);
            }
        } else if (this.b.k.a(i2) instanceof e) {
            e eVar = (e) this.b.k.a(i2);
            if (!TextUtils.isEmpty(eVar.d)) {
                ((HomeActivity) this.b.getActivity()).a(new Intent("android.intent.action.VIEW", Uri.parse(eVar.d + ((eVar.d.contains("?") ? "&" : "?") + "ref=" + this.b.u.h + "|" + eVar.e))), this.b.getDialog() != null, false);
            }
        }
    }
}
