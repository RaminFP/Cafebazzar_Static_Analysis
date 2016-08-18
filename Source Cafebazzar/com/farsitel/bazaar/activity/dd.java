package com.farsitel.bazaar.activity;

import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.a.a.a.a;
import com.a.a.a.ar;
import com.a.a.a.y;
import com.farsitel.bazaar.f.a.b;
import java.util.Map;

final class dd implements b {
    final /* synthetic */ SmsAuthenticationActivity a;

    dd(SmsAuthenticationActivity smsAuthenticationActivity) {
        this.a = smsAuthenticationActivity;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        this.a.n.dismiss();
        this.a.h.setText((CharSequence) map.get("general"));
        this.a.h.setTextColor(this.a.getResources().getColor(2131558529));
        String str = "unknown";
        switch (i) {
            case -5:
                str = "banned";
                break;
            case -4:
                str = "reached_attempt_limit";
                break;
            case -3:
                this.a.m.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968637));
                str = "reached_limit_code";
                break;
            case -2:
                this.a.m.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968637));
                str = "expired_code";
                break;
            case -1:
                this.a.m.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968637));
                str = "invalid_code";
                break;
            case 602:
                this.a.m.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968637));
                str = "too_many_devices";
                break;
        }
        if (this.a.f) {
            if (this.a.e) {
                a.c().a((ar) new ar().a("phone").a(false).a("reason", str));
            } else {
                a.c().a((y) new y().a("phone").a(false).a("reason", str));
            }
        }
        if (i == -4) {
            this.a.finish();
        }
    }

    public final void b() {
        this.a.n.dismiss();
        if (this.a.f) {
            Toast makeText = Toast.makeText(this.a, "", 1);
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.a.e) {
                a.c().a(new ar().a("phone").a(true));
                makeText.setView(from.inflate(2130903175, null));
            } else {
                a.c().a(new y().a("phone").a(true));
                makeText.setView(from.inflate(2130903137, null));
            }
            makeText.show();
        }
        this.a.setIntent(this.a.getIntent());
        this.a.setResult(-1);
        this.a.finish();
    }
}
