package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.a.a;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.af;

final class e implements OnRatingBarChangeListener {
    final /* synthetic */ RatingBar a;
    final /* synthetic */ a b;

    e(a aVar, RatingBar ratingBar) {
        this.b = aVar;
        this.a = ratingBar;
    }

    public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (f == 0.0f) {
            this.a.setRating(f);
        } else if (j.a().n()) {
            af afVar = af.INSTANCE;
            if (af.c(this.b.e.g())) {
                if (z) {
                    Toast.makeText(BazaarApplication.c(), 2131165665, 0).show();
                    a.a(this.b.e.g(), (int) f);
                }
                this.a.setRating(f);
                this.b.F = (int) f;
                return;
            }
            Toast.makeText(this.b.getActivity(), 2131165410, 0).show();
            this.a.setRating(0.0f);
        } else {
            Intent intent = new Intent(this.b.getActivity(), JoinActivity.class);
            intent.putExtra("extra_referer", "rate");
            intent.putExtra("android.intent.extra.TITLE", this.b.getString(2131165597));
            this.b.startActivityForResult(intent, 40002);
            this.a.setRating(0.0f);
        }
    }
}
