package com.farsitel.bazaar.g.b;

import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.g.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;

public final class a implements Serializable {
    public String a;
    public String b;
    public boolean c = true;
    public ArrayList d = new ArrayList(24);

    public a(String str) {
        this.a = str;
    }

    public final int a(String str, Collection collection) {
        this.b = str;
        this.d.clear();
        for (d a : collection) {
            this.d.add(a.a());
        }
        return collection.size();
    }

    public final int a(String str, Set set) {
        this.b = str;
        this.d.clear();
        for (Entry entry : set) {
            this.d.add(new k((String) entry.getKey(), (String) entry.getValue(), "", 0.0f, false, 0, "", "", false, null));
        }
        return set.size();
    }

    public final void a(f[] fVarArr) {
        this.d.clear();
        Collections.addAll(this.d, fVarArr);
    }
}
