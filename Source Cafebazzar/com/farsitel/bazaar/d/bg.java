package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.ay;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.activity.u;
import com.farsitel.bazaar.g.e.c;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;

public final class bg extends u {
    private String j;

    public static bg a(String str, String str2) {
        bg bgVar = new bg();
        Bundle bundle = new Bundle();
        bundle.putString("android.intent.extra.TEXT", str);
        bundle.putString("prediction_index", str2);
        bgVar.setArguments(bundle);
        return bgVar;
    }

    protected final h a(c cVar) {
        h ayVar = new ay(getActivity(), LayoutInflater.from(getActivity()), this.j, this, cVar.j, cVar.h, String.valueOf(this.d));
        BazaarApplication.c().d();
        String str = "";
        if (getArguments() != null) {
            str = "/?q=" + getArguments().getString("android.intent.extra.TEXT");
        }
        i.a("/Search" + str);
        return ayVar;
    }

    public final String d() {
        return getString(2131165480, this.j);
    }

    protected final void e() {
        a();
        String str = "search|" + this.j + "|" + this.d;
        d.INSTANCE.a(this.e, str, new com.farsitel.bazaar.h.b.u(), BazaarApplication.c().a.getLanguage(), this.j.toLowerCase(), Integer.valueOf(0));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = true;
        this.j = getArguments().getString("android.intent.extra.TEXT");
        this.d = getArguments().getString("prediction_index");
        setHasOptionsMenu(true);
    }

    public final void onResume() {
        super.onResume();
        i();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(2131624140).setVisibility(8);
    }
}
