package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public final class i implements OnItemClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ f b;

    public i(f fVar, d dVar) {
        this.b = fVar;
        this.a = dVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.b.u.onClick(this.a.b, i);
        if (!this.b.E) {
            this.a.b.dismiss();
        }
    }
}
