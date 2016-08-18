package com.farsitel.bazaar.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.a.a;
import com.a.a.a.s;
import com.farsitel.bazaar.a.az;
import com.farsitel.bazaar.f.a.b;
import java.util.Map;

public final class br extends y implements OnClickListener, b {
    private az a;
    private ListView b;
    private View c;

    public static br c() {
        return new br();
    }

    public final void a() {
        if ((this.a == null || this.a.isEmpty()) && this.c != null) {
            this.c.findViewById(2131624178).setVisibility(8);
            this.c.findViewById(2131624179).setVisibility(0);
            this.c.findViewById(2131624180).setVisibility(8);
        }
    }

    public final void a(int i, Map map) {
        if (this.a.getCount() == 0 && this.c != null) {
            this.c.findViewById(2131624179).setVisibility(8);
            this.c.findViewById(2131624180).setVisibility(0);
        }
    }

    public final void b() {
        this.b.setAdapter(this.a);
        if (this.c != null) {
            this.b.setEmptyView((TextView) this.c.findViewById(2131624178));
            this.c.findViewById(2131624179).setVisibility(8);
            this.c.findViewById(2131624180).setVisibility(8);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 16 && i2 == -1) {
            Toast.makeText(getContext(), 2131165518, 1).show();
            this.a.a();
        }
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case 2131624180:
                if (this.c != null) {
                    this.c.findViewById(2131624180).setVisibility(8);
                    this.c.findViewById(2131624179).setVisibility(0);
                    this.a.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(2130903120, null);
        this.a = new az(this, layoutInflater, this);
        this.a.a();
        this.b = (ListView) this.c.findViewById(2131624036);
        this.c.findViewById(2131624180).setOnClickListener(this);
        a.c().a(new s().b(getString(2131165666)).a("subscriptions").c("Subs Apps page"));
        return this.c;
    }

    public final void onResume() {
        super.onResume();
        a(getString(2131165666));
    }
}
