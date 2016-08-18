package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ap;

public interface i extends IInterface {
    void a(int i);

    void a(int i, Account account, f fVar);

    void a(AuthAccountRequest authAccountRequest, f fVar);

    void a(ResolveAccountRequest resolveAccountRequest, ap apVar);

    void a(ad adVar, int i, boolean z);

    void a(CheckServerAuthResult checkServerAuthResult);

    void a(RecordConsentRequest recordConsentRequest, f fVar);

    void a(f fVar);

    void a(boolean z);
}
