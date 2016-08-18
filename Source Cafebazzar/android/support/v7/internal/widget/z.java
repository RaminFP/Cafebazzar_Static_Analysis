package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

final class z implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView a;

    private z(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onClick(View view) {
        if (view == this.a.h) {
            this.a.b();
            Intent b = this.a.b.a.b(this.a.b.a.a(this.a.b.a.b()));
            if (b != null) {
                b.addFlags(524288);
                this.a.getContext().startActivity(b);
            }
        } else if (view == this.a.f) {
            this.a.o = false;
            this.a.a(this.a.p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void onDismiss() {
        if (this.a.n != null) {
            this.a.n.onDismiss();
        }
        if (this.a.a != null) {
            this.a.a.subUiVisibilityChanged(false);
        }
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (((y) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.a.b();
                if (!this.a.o) {
                    if (!this.a.b.b) {
                        i++;
                    }
                    Intent b = this.a.b.a.b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    n nVar = this.a.b.a;
                    synchronized (nVar.a) {
                        nVar.d();
                        o oVar = (o) nVar.b.get(i);
                        o oVar2 = (o) nVar.b.get(0);
                        nVar.a(new r(new ComponentName(oVar.a.activityInfo.packageName, oVar.a.activityInfo.name), System.currentTimeMillis(), oVar2 != null ? (oVar2.b - oVar.b) + 5.0f : 1.0f));
                    }
                    return;
                } else {
                    return;
                }
            case 1:
                this.a.a(Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        if (view == this.a.h) {
            if (this.a.b.getCount() > 0) {
                this.a.o = true;
                this.a.a(this.a.p);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
