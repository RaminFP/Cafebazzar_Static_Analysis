package a.a.a.a.a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class g implements OnGlobalLayoutListener {
    final /* synthetic */ View a;
    final /* synthetic */ c b;
    final /* synthetic */ f c;

    g(f fVar, View view, c cVar) {
        this.c = fVar;
        this.a = view;
        this.b = cVar;
    }

    @TargetApi(16)
    public final void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        if (this.b.a() != null) {
            this.a.startAnimation(this.b.a());
            f.a(this.b.c, this.b.a);
            if (-1 != this.b.e().b) {
                this.c.a(this.b, -1040155167, ((long) this.b.e().b) + this.b.a().getDuration());
            }
        }
    }
}
