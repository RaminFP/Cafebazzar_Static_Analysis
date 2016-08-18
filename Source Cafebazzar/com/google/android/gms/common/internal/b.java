package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class b extends ae {
    int a;
    private Account b;
    private Context c;

    public static Account a(ad adVar) {
        Account account = null;
        if (adVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = adVar.a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final Account a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.a) {
            return this.b;
        }
        if (GooglePlayServicesUtil.zze(this.c, callingUid)) {
            this.a = callingUid;
            return this.b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof b) ? false : this.b.equals(((b) obj).b);
    }
}
