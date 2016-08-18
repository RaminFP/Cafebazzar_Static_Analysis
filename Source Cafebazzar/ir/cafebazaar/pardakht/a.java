package ir.cafebazaar.pardakht;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.b.ay;

final class a implements OnClickListener {
    final /* synthetic */ AuthenticateActivity a;

    a(AuthenticateActivity authenticateActivity) {
        this.a = authenticateActivity;
    }

    public final void onClick(View view) {
        new ay(this.a).e.show();
    }
}
