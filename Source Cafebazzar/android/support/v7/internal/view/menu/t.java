package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.d.a.b;
import android.view.ActionProvider;

@TargetApi(16)
final class t extends o {
    t(Context context, b bVar) {
        super(context, bVar);
    }

    final p a(ActionProvider actionProvider) {
        return new u(this, this.a, actionProvider);
    }
}
