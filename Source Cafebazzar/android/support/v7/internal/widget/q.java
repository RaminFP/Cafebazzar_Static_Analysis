package android.support.v7.internal.widget;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class q implements p {
    final /* synthetic */ n a;
    private final Map b;

    private q(n nVar) {
        this.a = nVar;
        this.b = new HashMap();
    }

    public final void a(List list, List list2) {
        Map map = this.b;
        map.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            o oVar = (o) list.get(i);
            oVar.b = 0.0f;
            map.put(oVar.a.activityInfo.packageName, oVar);
        }
        float f = 1.0f;
        int size2 = list2.size() - 1;
        while (size2 >= 0) {
            float f2;
            r rVar = (r) list2.get(size2);
            o oVar2 = (o) map.get(rVar.a.getPackageName());
            if (oVar2 != null) {
                oVar2.b = (rVar.c * f) + oVar2.b;
                f2 = 0.95f * f;
            } else {
                f2 = f;
            }
            size2--;
            f = f2;
        }
        Collections.sort(list);
    }
}
