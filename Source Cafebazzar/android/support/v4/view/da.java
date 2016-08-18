package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

final class da implements Comparator {
    da() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ct ctVar = (ct) ((View) obj).getLayoutParams();
        ct ctVar2 = (ct) ((View) obj2).getLayoutParams();
        return ctVar.a != ctVar2.a ? ctVar.a ? 1 : -1 : ctVar.e - ctVar2.e;
    }
}
