package android.support.v4.os;

import android.os.Bundle;

final class i extends b {
    final /* synthetic */ ResultReceiver a;

    i(ResultReceiver resultReceiver) {
        this.a = resultReceiver;
    }

    public final void a(int i, Bundle bundle) {
        if (this.a.b != null) {
            this.a.b.post(new j(this.a, i, bundle));
        } else {
            this.a.a(i, bundle);
        }
    }
}
