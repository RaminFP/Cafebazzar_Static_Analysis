package com.farsitel.bazaar.d;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.b.a;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.i;
import org.json.JSONObject;

public final class bn extends bp {
    private String c;
    private long d = 0;

    protected final BaseAdapter a(Activity activity, JSONObject jSONObject) {
        return new a(activity, jSONObject);
    }

    public final void a(int i, long j) {
        com.farsitel.bazaar.g.c.a a = ((a) this.a).a(i);
        if (a != null) {
            long j2 = a.a;
            com.farsitel.bazaar.g.a a2 = com.farsitel.bazaar.g.a.a();
            c cVar = new c();
            cVar.c = "support";
            cVar.e = "item_click";
            a2.a(cVar.b("type", "article").b("item_id", Long.valueOf(j2)).a("referrer_id", Long.valueOf(this.d)));
            String str = a.c;
            String str2 = a.b;
            HomeActivity homeActivity = (HomeActivity) getActivity();
            long j3 = this.d;
            y bhVar = new bh();
            Bundle bundle = new Bundle();
            bundle.putLong("article_folder_id", Long.valueOf(j3).longValue());
            bundle.putLong("article_id", j2);
            bundle.putString("article_body", str);
            bundle.putString("article_title", str2);
            bhVar.setArguments(bundle);
            homeActivity.a(bhVar, getDialog() != null);
        }
    }

    public final long c() {
        return this.d;
    }

    public final String d() {
        return BazaarApplication.c().getString(2131165653);
    }

    public final String e() {
        return BazaarApplication.c().getString(2131165654);
    }

    public final void onCreate(Bundle bundle) {
        this.c = getString(2131165681);
        if (getArguments() != null) {
            this.d = getArguments().getLong("folder_id", 0);
            this.c = getArguments().getString("folder_title");
        }
        this.b = true;
        super.onCreate(bundle);
        BazaarApplication.c().d();
        i.a("/KnowledgeBase/folder/" + this.d + "/" + this.c);
    }
}
