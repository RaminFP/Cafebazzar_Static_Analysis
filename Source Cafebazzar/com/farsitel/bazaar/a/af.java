package com.farsitel.bazaar.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;

final class af {
    RelativeLayout a;
    TextView b;
    ImageView c;
    TextView d;
    RecyclerView e;
    View f;
    final /* synthetic */ ac g;

    public af(ac acVar, View view) {
        this.g = acVar;
        this.d = (TextView) view.findViewById(2131624250);
        this.b = (TextView) view.findViewById(2131624252);
        this.c = (ImageView) view.findViewById(2131624251);
        this.f = view.findViewById(2131624254);
        this.a = (RelativeLayout) view.findViewById(2131624249);
        this.e = (RecyclerView) view.findViewById(2131624253);
        LayoutManager linearLayoutManager = new LinearLayoutManager(acVar.b, 0, false);
        if (BazaarApplication.c().b()) {
            linearLayoutManager.setReverseLayout(true);
        }
        this.e.setLayoutManager(linearLayoutManager);
        this.e.setHasFixedSize(true);
    }
}
