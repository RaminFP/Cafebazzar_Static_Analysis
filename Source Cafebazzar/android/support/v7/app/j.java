package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class j implements OnItemClickListener {
    final /* synthetic */ ListView a;
    final /* synthetic */ d b;
    final /* synthetic */ f c;

    public j(f fVar, ListView listView, d dVar) {
        this.c = fVar;
        this.a = listView;
        this.b = dVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.c.C != null) {
            this.c.C[i] = this.a.isItemChecked(i);
        }
        this.c.G.onClick(this.b.b, i, this.a.isItemChecked(i));
    }
}
