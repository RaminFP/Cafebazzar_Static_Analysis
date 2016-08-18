package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.b.j;
import android.view.View;
import android.widget.AbsListView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.k;
import com.farsitel.bazaar.util.aj;
import ir.cafebazaar.pardakht.a.e;

public final class b extends BroadcastReceiver {
    public c a;
    private final AbsListView b;
    private boolean c = false;
    private e d;

    public b(AbsListView absListView) {
        this.b = absListView;
        this.d = new e(BazaarApplication.c());
    }

    public final void a() {
        if (!this.c) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.farsitel.bazaar.DOWNLOAD_PROGRESS");
            intentFilter.addAction("com.farsitel.bazaar.DOWNLOAD_QUEUE_CHANGE");
            j.a(BazaarApplication.c()).a(this, intentFilter);
            this.c = true;
        }
    }

    public final void b() {
        if (this.c) {
            j.a(BazaarApplication.c()).a((BroadcastReceiver) this);
            this.c = false;
            this.a = null;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.DOWNLOAD_PROGRESS".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("package_name");
            if (stringExtra != null) {
                View findViewWithTag = this.b.findViewWithTag(stringExtra);
                if (findViewWithTag != null) {
                    k kVar = (k) findViewWithTag.getTag(2131165869);
                    long longValue = ((Long) findViewWithTag.getTag(2131165862)).longValue();
                    com.farsitel.bazaar.database.b.a();
                    switch (com.farsitel.bazaar.database.b.a(stringExtra)) {
                        case 0:
                            kVar.d.setText(2131165707);
                            kVar.h.setVisibility(8);
                            return;
                        case 1:
                            if (longValue == 0 || this.d.a(stringExtra)) {
                                kVar.d.setText(2131165409);
                            } else {
                                kVar.d.setText(aj.a(longValue));
                            }
                            kVar.d.setEnabled(true);
                            kVar.h.setVisibility(8);
                            return;
                        case 2:
                            kVar.d.setText(2131165433);
                            kVar.h.setVisibility(8);
                            return;
                        case 3:
                            long longExtra = intent.getLongExtra("downloaded_size", 0);
                            longValue = intent.getLongExtra("total_size", 1);
                            kVar.d.setText(2131165514);
                            kVar.d.setEnabled(true);
                            kVar.h.setVisibility(0);
                            kVar.h.setIndeterminate(false);
                            kVar.h.setProgress(com.farsitel.bazaar.util.j.a((int) ((100.0f * ((float) longExtra)) / ((float) longValue))));
                            if (this.a != null) {
                                this.a.c();
                                return;
                            }
                            return;
                        case 4:
                            kVar.d.setText(2131165514);
                            kVar.d.setEnabled(true);
                            kVar.h.setVisibility(0);
                            kVar.h.setIndeterminate(true);
                            return;
                        default:
                            return;
                    }
                } else if (this.a != null) {
                    this.a.b();
                }
            }
        } else if ("com.farsitel.bazaar.DOWNLOAD_QUEUE_CHANGE".equals(intent.getAction())) {
            boolean booleanExtra = intent.getBooleanExtra("downloading_cunt_in_queue", false);
            if (this.a != null) {
                this.a.a(booleanExtra);
            }
        }
    }
}
