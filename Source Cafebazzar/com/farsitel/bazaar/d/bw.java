package com.farsitel.bazaar.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.a.a.a.a;
import com.a.a.a.s;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.bg;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.service.CheckUpgradablesService;

public final class bw extends w {
    private h d = new bx(this);

    public static bw l() {
        return new bw();
    }

    private void m() {
        int size = g.a().a.size();
        if (size <= 0 || !j.a().o()) {
            j();
        } else {
            a((int) com.farsitel.bazaar.g.update_all_small, new by(this, size));
        }
    }

    public final String e() {
        return getString(2131165481);
    }

    protected final com.farsitel.bazaar.a.h g() {
        com.farsitel.bazaar.a.h bgVar = new bg(getActivity(), LayoutInflater.from(getActivity()), this);
        setHasOptionsMenu(true);
        bgVar.j = new bz(this, bgVar);
        Intent intent = new Intent(getActivity(), CheckUpgradablesService.class);
        intent.putExtra("force_check_upgradables", true);
        getActivity().startService(intent);
        return bgVar;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m();
        a.c().a(new s().b(getString(2131165722)).a("updates").c("Upgradable Apps page"));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onPause() {
        super.onPause();
        this.d.b();
    }

    public final void onResume() {
        super.onResume();
        this.d.a();
        a(getString(2131165722));
        BazaarApplication.c().d();
        i.a("/UpgradableApps/");
    }
}
