package android.support.v7.app;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

final class e implements OnClickListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void onClick(View view) {
        Message obtain = (view != this.a.n || this.a.p == null) ? (view != this.a.q || this.a.s == null) ? (view != this.a.t || this.a.v == null) ? null : Message.obtain(this.a.v) : Message.obtain(this.a.s) : Message.obtain(this.a.p);
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.a.M.obtainMessage(1, this.a.b).sendToTarget();
    }
}
