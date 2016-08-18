package com.farsitel.bazaar.d;

import android.support.v7.a.g;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class bd implements OnItemClickListener {
    final /* synthetic */ aw a;

    bd(aw awVar) {
        this.a = awVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.c = true;
        TextView textView = (TextView) view.findViewById(g.text);
        this.a.n = this.a.o + "|" + i;
        this.a.a.setText(textView.getText().toString());
        a a = a.a();
        c cVar = new c();
        cVar.c = "search_frag";
        cVar.e = "prediction_click";
        a.a(cVar.b("query", this.a.a.getText().toString()).b("suggested_text", textView.getText().toString()).b("position", Integer.valueOf(i)));
        this.a.c(textView.getText().toString());
    }
}
