package com.farsitel.bazaar.widget;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.farsitel.bazaar.f.a.a;

public class RetryView extends RelativeLayout implements OnClickListener {
    private BazaarViewFlipper a;
    private View b;
    private View c;
    private boolean d = false;
    private Handler e = new Handler();
    private Context f;
    private a g;
    private ab h;

    public RetryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = context;
    }

    public final void a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f.getSystemService("connectivity")).getActiveNetworkInfo();
        Object obj = (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? null : 1;
        if (obj != null && this.a.getDisplayedChild() == 1) {
            if (this.g != null) {
                this.g.c();
                this.g = null;
            }
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
        }
    }

    public final void a(int i, ab abVar, a aVar) {
        this.h = abVar;
        this.g = aVar;
        switch (i) {
            case 10000:
            case 10001:
                this.a.setDisplayedChild(0);
                return;
            case 10002:
                this.a.setDisplayedChild(1);
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624180:
                this.d = false;
                this.a.setDisplayedChild(0);
                if (this.g != null) {
                    this.g.c();
                    this.g = null;
                }
                if (this.h != null) {
                    this.h.a();
                    this.h = null;
                    return;
                }
                return;
            case 2131624431:
                Toast.makeText(getContext(), 2131165701, 0).show();
                return;
            default:
                return;
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (BazaarViewFlipper) findViewById(2131624260);
        this.b = findViewById(2131624180);
        this.b.setOnClickListener(this);
        this.c = findViewById(2131624431);
        this.c.setOnClickListener(this);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        } else {
            setAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        }
        super.setVisibility(i);
    }
}
