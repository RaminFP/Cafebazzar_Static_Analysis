package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class h extends BaseAdapter {
    final /* synthetic */ g a;
    private int b = -1;

    public h(g gVar) {
        this.a = gVar;
        a();
    }

    private void a() {
        m mVar = this.a.c.j;
        if (mVar != null) {
            ArrayList j = this.a.c.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (((m) j.get(i)) == mVar) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public final m a(int i) {
        ArrayList j = this.a.c.j();
        int a = this.a.i + i;
        if (this.b >= 0 && a >= this.b) {
            a++;
        }
        return (m) j.get(a);
    }

    public final int getCount() {
        int size = this.a.c.j().size() - this.a.i;
        return this.b < 0 ? size : size - 1;
    }

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.a.b.inflate(this.a.f, viewGroup, false) : view;
        ((aa) inflate).a(a(i), 0);
        return inflate;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
