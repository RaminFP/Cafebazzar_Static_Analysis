package com.google.android.gms.a;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.av;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class bi extends Fragment implements OnCancelListener {
    private static final b d = b.a();
    public boolean a;
    public boolean b;
    public final SparseArray c = new SparseArray();
    private int e = -1;
    private ConnectionResult f;
    private final Handler g = new Handler(Looper.getMainLooper());
    private be h;

    public static bi a(FragmentActivity fragmentActivity) {
        av.b("Must be called from main thread of process");
        try {
            bi biVar = (bi) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            return (biVar == null || biVar.isRemoving()) ? null : biVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        bj bjVar = (bj) this.c.get(i);
        if (bjVar != null) {
            l lVar = (bj) this.c.get(i);
            this.c.remove(i);
            if (lVar != null) {
                lVar.b.b(lVar);
                lVar.b.b();
            }
            l lVar2 = bjVar.c;
            if (lVar2 != null) {
                lVar2.a(connectionResult);
            }
        }
        b();
    }

    public static bi b(FragmentActivity fragmentActivity) {
        bi a = a(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a != null) {
            return a;
        }
        Fragment biVar = new bi();
        supportFragmentManager.beginTransaction().add(biVar, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return biVar;
    }

    private void b() {
        this.b = false;
        this.e = -1;
        this.f = null;
        if (this.h != null) {
            this.h.b();
            this.h = null;
        }
        for (int i = 0; i < this.c.size(); i++) {
            ((bj) this.c.valueAt(i)).b.a();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.c.size(); i++) {
            bj bjVar = (bj) this.c.valueAt(i);
            printWriter.append(str).append("GoogleApiClient #").print(bjVar.a);
            printWriter.println(":");
            bjVar.b.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        switch(r4) {
            case 1: goto L_0x0016;
            case 2: goto L_0x000b;
            default: goto L_0x0004;
        };
    L_0x0004:
        r0 = 0;
    L_0x0005:
        if (r0 == 0) goto L_0x0026;
    L_0x0007:
        r3.b();
    L_0x000a:
        return;
    L_0x000b:
        r1 = r3.getActivity();
        r1 = com.google.android.gms.common.b.a(r1);
        if (r1 != 0) goto L_0x0004;
    L_0x0015:
        goto L_0x0005;
    L_0x0016:
        r1 = -1;
        if (r5 == r1) goto L_0x0005;
    L_0x0019:
        if (r5 != 0) goto L_0x0004;
    L_0x001b:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r1 = 13;
        r2 = 0;
        r0.<init>(r1, r2);
        r3.f = r0;
        goto L_0x0004;
    L_0x0026:
        r0 = r3.e;
        r1 = r3.f;
        r3.a(r0, r1);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.bi.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.e, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = bundle.getBoolean("resolving_error", false);
            this.e = bundle.getInt("failed_client_id", -1);
            if (this.e >= 0) {
                this.f = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.b);
        if (this.e >= 0) {
            bundle.putInt("failed_client_id", this.e);
            bundle.putInt("failed_status", this.f.c);
            bundle.putParcelable("failed_resolution", this.f.d);
        }
    }

    public final void onStart() {
        super.onStart();
        this.a = true;
        if (!this.b) {
            for (int i = 0; i < this.c.size(); i++) {
                ((bj) this.c.valueAt(i)).b.a();
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.a = false;
        for (int i = 0; i < this.c.size(); i++) {
            ((bj) this.c.valueAt(i)).b.b();
        }
    }
}
