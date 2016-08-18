package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public final class ag extends y {
    private boolean a;

    public static ag a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_is_email", z);
        ag agVar = new ag();
        agVar.setArguments(bundle);
        return agVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903113, null);
        this.a = getArguments().getBoolean("extra_is_email");
        ((TextView) inflate.findViewById(2131624262)).setText(this.a ? 2131165327 : 2131165330);
        inflate.findViewById(2131624298).setOnClickListener(new ah(this));
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        a(getString(this.a ? 2131165326 : 2131165329));
    }
}
