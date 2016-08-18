package com.farsitel.bazaar.d;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.b.c;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c.b;
import com.farsitel.bazaar.i;
import org.json.JSONObject;

public final class bo extends bp {
    public static bo g() {
        return new bo();
    }

    protected final BaseAdapter a(Activity activity, JSONObject jSONObject) {
        return new c(activity, jSONObject);
    }

    public final void a(int i, long j) {
        b a = ((c) this.a).a(i);
        if (a != null) {
            a a2 = a.a();
            com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
            cVar.c = "support";
            cVar.e = "item_click";
            a2.a(cVar.b("type", "articles_list").a("item_id", Long.valueOf(j)).a("referrer_id", Long.valueOf(-1)));
            String str = a.b;
            HomeActivity homeActivity = (HomeActivity) getActivity();
            y bnVar = new bn();
            Bundle bundle = new Bundle();
            bundle.putLong("folder_id", Long.valueOf(j).longValue());
            bundle.putString("folder_title", str);
            bnVar.setArguments(bundle);
            homeActivity.a(bnVar, getDialog() != null);
        }
    }

    public final long c() {
        return -1;
    }

    public final String d() {
        return BazaarApplication.c().getString(2131165398);
    }

    public final String e() {
        return BazaarApplication.c().getString(2131165655);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BazaarApplication.c().d();
        i.a("/KnowledgeBase/");
    }
}
