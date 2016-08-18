package android.support.v7.app;

import android.support.v4.view.bi;
import android.support.v4.view.bp;
import android.support.v4.view.eb;
import android.view.View;

final class w implements bi {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    w(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final eb a(View view, eb ebVar) {
        int b = ebVar.b();
        int b2 = AppCompatDelegateImplV7.b(this.a, b);
        if (b != b2) {
            ebVar = ebVar.a(ebVar.a(), b2, ebVar.c(), ebVar.d());
        }
        return bp.a(view, ebVar);
    }
}
