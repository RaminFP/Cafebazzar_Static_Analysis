package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.a;
import com.google.android.gms.plus.d;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public final class g extends l {
    private a f;
    private final PlusSession g;

    public g(Context context, Looper looper, h hVar, PlusSession plusSession, k kVar, com.google.android.gms.common.api.l lVar) {
        super(context, looper, 2, hVar, kVar, lVar);
        this.g = plusSession;
    }

    private Bundle q() {
        PlusSession plusSession = this.g;
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        SafeParcelable safeParcelable = plusSession.j;
        Parcel obtain = Parcel.obtain();
        safeParcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", marshall);
        bundle.putStringArray("request_visible_actions", this.g.d);
        bundle.putString("auth_package", this.g.f);
        return bundle;
    }

    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        return e.a(iBinder);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.f = PersonEntity.a(bundle.getByteArray("loaded_person"));
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final boolean c() {
        Set set;
        h hVar = this.b;
        i iVar = (i) hVar.d.get(d.c);
        if (iVar == null || iVar.a.isEmpty()) {
            set = hVar.b;
        } else {
            Set hashSet = new HashSet(hVar.b);
            hashSet.addAll(iVar.a);
            set = hashSet;
        }
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    protected final String f() {
        return "com.google.android.gms.plus.service.START";
    }

    protected final String g() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected final Bundle l() {
        return q();
    }

    protected final Bundle o() {
        return q();
    }

    public final String p() {
        m();
        try {
            return ((d) n()).a();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
