package com.c.a.a.a;

import com.c.a.a.q;
import com.c.a.a.v;
import com.c.a.aa;
import com.c.a.al;
import com.c.a.am;
import com.c.a.ap;
import com.c.a.b;
import com.c.a.p;
import com.c.a.z;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class u {
    static final String a = q.b();
    public static final String b = (a + "-Sent-Millis");
    public static final String c = (a + "-Received-Millis");
    public static final String d = (a + "-Selected-Protocol");
    private static final Comparator e = new v();

    static {
        q.a();
    }

    public static long a(al alVar) {
        return a(alVar.c);
    }

    public static long a(ap apVar) {
        return a(apVar.f);
    }

    public static long a(z zVar) {
        return b(zVar.a("Content-Length"));
    }

    public static al a(b bVar, ap apVar, Proxy proxy) {
        return apVar.c == 407 ? bVar.b(proxy, apVar) : bVar.a(proxy, apVar);
    }

    public static Map a(z zVar, String str) {
        Map treeMap = new TreeMap(e);
        int length = zVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            String a = zVar.a(i);
            String b = zVar.b(i);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(a);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(b);
            treeMap.put(a, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static void a(am amVar, Map map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                String str2;
                List list = (List) entry.getValue();
                if (list.size() == 1) {
                    str2 = (String) list.get(0);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (i > 0) {
                            stringBuilder.append("; ");
                        }
                        stringBuilder.append((String) list.get(i));
                    }
                    str2 = stringBuilder.toString();
                }
                amVar.b(str, str2);
            }
        }
    }

    public static boolean a(ap apVar, z zVar, al alVar) {
        for (String str : b(apVar.f)) {
            if (!v.a(zVar.c(str), alVar.c.c(str))) {
                return false;
            }
        }
        return true;
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static long b(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static List b(z zVar, String str) {
        List arrayList = new ArrayList();
        int length = zVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(zVar.a(i))) {
                String b = zVar.b(i);
                int i2 = 0;
                while (i2 < b.length()) {
                    int a = e.a(b, i2, " ");
                    String trim = b.substring(i2, a).trim();
                    a = e.a(b, a);
                    if (!b.regionMatches(true, a, "realm=\"", 0, 7)) {
                        break;
                    }
                    i2 = a + 7;
                    a = e.a(b, i2, "\"");
                    String substring = b.substring(i2, a);
                    i2 = e.a(b, e.a(b, a + 1, ",") + 1);
                    arrayList.add(new p(trim, substring));
                }
            }
        }
        return arrayList;
    }

    private static Set b(z zVar) {
        Set emptySet = Collections.emptySet();
        int length = zVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            if ("Vary".equalsIgnoreCase(zVar.a(i))) {
                String b = zVar.b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static boolean b(ap apVar) {
        return b(apVar.f).contains("*");
    }

    public static z c(ap apVar) {
        z zVar = apVar.h.a.c;
        Set b = b(apVar.f);
        if (b.isEmpty()) {
            return new aa().a();
        }
        aa aaVar = new aa();
        int length = zVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            String a = zVar.a(i);
            if (b.contains(a)) {
                aaVar.a(a, zVar.b(i));
            }
        }
        return aaVar.a();
    }
}
