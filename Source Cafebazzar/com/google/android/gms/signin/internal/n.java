package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.a.cz;
import com.google.android.gms.a.da;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.r;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class n extends l implements cz {
    private final boolean f;
    private final h g;
    private final Bundle h;
    private Integer i;

    public n(Context context, Looper looper, boolean z, h hVar, Bundle bundle, k kVar, com.google.android.gms.common.api.l lVar) {
        super(context, looper, 44, hVar, kVar, lVar);
        this.f = z;
        this.g = hVar;
        this.h = bundle;
        this.i = hVar.h;
    }

    public n(Context context, Looper looper, boolean z, h hVar, da daVar, k kVar, com.google.android.gms.common.api.l lVar, ExecutorService executorService) {
        Integer num = hVar.h;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", daVar.b);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", daVar.c);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", daVar.d);
        if (daVar.e != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new o(daVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", daVar.f);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", daVar.g);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", daVar.h);
        this(context, looper, true, hVar, bundle, kVar, lVar);
    }

    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        return j.a(iBinder);
    }

    public final void a(ad adVar, Set set, f fVar) {
        av.a((Object) fVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((i) n()).a(new AuthAccountRequest(adVar, set), fVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                fVar.a(new ConnectionResult(8, null), new AuthAccountResult(8, null));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final void a(ad adVar, boolean z) {
        try {
            ((i) n()).a(adVar, this.i.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void a(ap apVar) {
        av.a((Object) apVar, (Object) "Expecting a valid IResolveAccountCallbacks");
        try {
            Account a = this.g.a();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(a.name)) {
                googleSignInAccount = c.a(this.a).a();
            }
            ((i) n()).a(new ResolveAccountRequest(a, this.i.intValue(), googleSignInAccount), apVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                apVar.a(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final boolean c() {
        return this.f;
    }

    protected final String f() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final void h_() {
        try {
            ((i) n()).a(this.i.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void i() {
        a(new r(this));
    }

    protected final Bundle l() {
        if (!this.a.getPackageName().equals(this.g.e)) {
            this.h.putString("com.google.android.gms.signin.internal.realClientPackageName", this.g.e);
        }
        return this.h;
    }
}
