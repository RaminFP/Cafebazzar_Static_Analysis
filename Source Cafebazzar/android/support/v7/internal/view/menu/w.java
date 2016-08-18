package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class w extends BaseAdapter {
    final /* synthetic */ v a;
    private i b;
    private int c = -1;

    public w(v vVar, i iVar) {
        this.a = vVar;
        this.b = iVar;
        a();
    }

    private void a() {
        m mVar = this.a.mMenu.j;
        if (mVar != null) {
            ArrayList j = this.a.mMenu.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (((m) j.get(i)) == mVar) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public final m a(int i) {
        ArrayList j = this.a.mOverflowOnly ? this.b.j() : this.b.h();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (m) j.get(i);
    }

    public final int getCount() {
        ArrayList j = this.a.mOverflowOnly ? this.b.j() : this.b.h();
        return this.c < 0 ? j.size() : j.size() - 1;
    }

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.a.mInflater.inflate(v.ITEM_LAYOUT, viewGroup, false) : view;
        aa aaVar = (aa) inflate;
        if (this.a.mForceShowIcon) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aaVar.a(a(i), 0);
        return inflate;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
