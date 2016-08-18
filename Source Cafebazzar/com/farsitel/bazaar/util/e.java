package com.farsitel.bazaar.util;

import com.farsitel.bazaar.g.d;
import java.util.Comparator;

public final class e implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) Math.signum((float) (((d) obj2).g - ((d) obj).g));
    }
}
