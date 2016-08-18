package com.farsitel.bazaar.widget;

import android.view.View;
import java.util.Comparator;

final class az implements Comparator {
    az() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ar arVar = (ar) ((View) obj).getLayoutParams();
        ar arVar2 = (ar) ((View) obj2).getLayoutParams();
        return arVar.a != arVar2.a ? arVar.a ? 1 : -1 : arVar.e - arVar2.e;
    }
}
