package ir.cafebazaar.pardakht;

import android.view.View;
import android.view.View.OnClickListener;

final class r implements OnClickListener {
    final /* synthetic */ PardakhtActivity a;

    r(PardakhtActivity pardakhtActivity) {
        this.a = pardakhtActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
