package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.a.da;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    final Account a;
    public final Set b;
    public final Set c;
    public final Map d;
    public final String e;
    final String f;
    public final da g;
    public Integer h;
    private final int i;
    private final View j;

    public h(Account account, Set set, Map map, int i, View view, String str, String str2, da daVar) {
        this.a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.d = map;
        this.j = view;
        this.i = i;
        this.e = str;
        this.f = str2;
        this.g = daVar;
        Set hashSet = new HashSet(this.b);
        for (i iVar : this.d.values()) {
            hashSet.addAll(iVar.a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.a != null ? this.a : new Account("<<default account>>", "com.google");
    }
}
