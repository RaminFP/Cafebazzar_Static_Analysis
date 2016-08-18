package com.a.a.c;

import com.a.a.c.a.a.a;
import com.a.a.c.a.a.b;
import com.a.a.c.a.a.c;
import com.a.a.c.a.a.d;
import com.a.a.c.a.a.e;
import com.a.a.c.a.a.f;
import com.a.a.c.a.a.g;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class bg {
    private static final e a = new e("", "", 0);
    private static final bq[] b = new bq[0];
    private static final bt[] c = new bt[0];
    private static final bn[] d = new bn[0];
    private static final bi[] e = new bi[0];
    private static final bj[] f = new bj[0];

    private static br a(b[] bVarArr) {
        bq[] bqVarArr = bVarArr != null ? new bj[bVarArr.length] : f;
        for (int i = 0; i < bqVarArr.length; i++) {
            bqVarArr[i] = new bj(bVarArr[i]);
        }
        return new br(bqVarArr);
    }

    private static br a(g[] gVarArr) {
        bq[] bqVarArr = gVarArr != null ? new bn[gVarArr.length] : d;
        for (int i = 0; i < bqVarArr.length; i++) {
            bqVarArr[i] = new bn(gVarArr[i]);
        }
        return new br(bqVarArr);
    }

    public static void a(d dVar, bb bbVar, Map map, f fVar) {
        int i;
        int i2;
        bs bsVar = new bs(dVar.b != null ? dVar.b : a);
        f[] fVarArr = dVar.c;
        bq[] bqVarArr = fVarArr != null ? new bt[fVarArr.length] : c;
        for (i = 0; i < bqVarArr.length; i++) {
            f fVar2 = fVarArr[i];
            bqVarArr[i] = new bt(fVar2, a(fVar2.c));
        }
        br brVar = new br(bqVarArr);
        a[] aVarArr = dVar.d;
        bqVarArr = aVarArr != null ? new bi[aVarArr.length] : e;
        for (i = 0; i < bqVarArr.length; i++) {
            bqVarArr[i] = new bi(aVarArr[i]);
        }
        bm bmVar = new bm(bsVar, brVar, new br(bqVarArr));
        b[] bVarArr = dVar.e;
        Map treeMap = new TreeMap(map);
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                treeMap.put(bVar.a, bVar.b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        b[] bVarArr2 = new b[entryArr.length];
        for (i2 = 0; i2 < bVarArr2.length; i2++) {
            bVarArr2[i2] = new b((String) entryArr[i2].getKey(), (String) entryArr[i2].getValue());
        }
        bh bhVar = new bh(bmVar, a(bVarArr2));
        c cVar = dVar.f;
        bk bkVar = new bk(((float) cVar.f) / 100.0f, cVar.g, cVar.h, cVar.a, cVar.b - cVar.d, cVar.c - cVar.e);
        b a = bbVar.a();
        if (a == null) {
            b.a.a.a.f.a().a("CrashlyticsCore", "No log data to include with this event.");
        }
        bbVar.b();
        bo boVar = a != null ? new bo(a) : new bp();
        new bl(dVar.a, "ndk-crash", bhVar, bkVar, boVar).b(fVar);
    }
}
