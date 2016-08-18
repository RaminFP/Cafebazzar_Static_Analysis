package com.c.a;

import d.f;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ab {
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List g;
    private final List h;
    private final String i;
    private final String j;

    private ab(ac acVar) {
        String str = null;
        this.a = acVar.a;
        this.c = d(acVar.b);
        this.d = d(acVar.c);
        this.e = acVar.d;
        this.f = acVar.a();
        this.g = a(acVar.f);
        this.h = acVar.g != null ? a(acVar.g) : null;
        if (acVar.h != null) {
            str = d(acVar.h);
        }
        this.i = str;
        this.j = acVar.toString();
    }

    static int a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    public static int a(String str) {
        return str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
    }

    public static ab a(URL url) {
        return c(url.toString());
    }

    static String a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            if (str.charAt(i3) == '%') {
                f fVar = new f();
                fVar.a(str, i, i3);
                while (i3 < i2) {
                    int codePointAt = str.codePointAt(i3);
                    if (codePointAt == 37 && i3 + 2 < i2) {
                        int a = a(str.charAt(i3 + 1));
                        int a2 = a(str.charAt(i3 + 2));
                        if (!(a == -1 || a2 == -1)) {
                            fVar.b((a << 4) + a2);
                            i3 += 2;
                            i3 += Character.charCount(codePointAt);
                        }
                    }
                    fVar.a(codePointAt);
                    i3 += Character.charCount(codePointAt);
                }
                return fVar.o();
            }
            i3++;
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt >= 127 || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z) || (z2 && codePointAt == 43))) {
                f fVar = new f();
                fVar.a(str, i, i3);
                f fVar2 = null;
                int i4 = i3;
                while (i4 < i2) {
                    f fVar3;
                    int codePointAt2 = str.codePointAt(i4);
                    if (z && (codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        fVar3 = fVar2;
                    } else if (z2 && codePointAt2 == 43) {
                        fVar.a(z ? "%20" : "%2B");
                        fVar3 = fVar2;
                    } else if (codePointAt2 < 32 || codePointAt2 >= 127 || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && !z)) {
                        fVar3 = fVar2 == null ? new f() : fVar2;
                        fVar3.a(codePointAt2);
                        while (!fVar3.e()) {
                            codePointAt = fVar3.g() & 255;
                            fVar.b(37);
                            fVar.b(b[(codePointAt >> 4) & 15]);
                            fVar.b(b[codePointAt & 15]);
                        }
                    } else {
                        fVar.a(codePointAt2);
                        fVar3 = fVar2;
                    }
                    i4 = Character.charCount(codePointAt2) + i4;
                    fVar2 = fVar3;
                }
                return fVar.o();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    private static List a(List list) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? d(str) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(StringBuilder stringBuilder, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    private static int b(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    static List b(String str) {
        List arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder stringBuilder, List list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    public static ab c(String str) {
        int i;
        int i2;
        ac acVar = new ac();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt;
            Object obj;
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3++;
                default:
                    break;
            }
            length = str.length() - 1;
            while (length >= i3) {
                char charAt2;
                int i4;
                Object obj2;
                int b;
                String a;
                Object obj3;
                Object obj4;
                switch (str.charAt(length)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        length--;
                    default:
                        i = length + 1;
                        break;
                }
                if (i - i3 >= 2) {
                    charAt2 = str.charAt(i3);
                    if ((charAt2 >= 'a' || charAt2 > 'z') && (charAt2 < 'A' || charAt2 > 'Z')) {
                        length = -1;
                        if (length != -1) {
                            if (str.regionMatches(true, i3, "https:", 0, 6)) {
                                acVar.a = "https";
                                length = i3 + 6;
                            } else {
                                if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                                    return null;
                                }
                                acVar.a = "http";
                                length = i3 + 5;
                            }
                            i2 = 0;
                            for (i4 = length; i4 < i; i4++) {
                                charAt = str.charAt(i4);
                                if (charAt != '\\' && charAt != '/') {
                                    i2 += length;
                                    obj2 = null;
                                    obj = null;
                                    while (true) {
                                        b = b(str, i2, i, "@/\\?#");
                                        switch (b == i ? str.charAt(b) : '￿') {
                                            case '￿':
                                            case '#':
                                            case '/':
                                            case '?':
                                            case '\\':
                                                length = ac.b(str, i2, b);
                                                if (length + 1 >= b) {
                                                    acVar.d = ac.c(str, i2, length);
                                                    acVar.e = ac.d(str, length + 1, b);
                                                    if (acVar.e == -1) {
                                                        return null;
                                                    }
                                                }
                                                acVar.d = ac.c(str, i2, length);
                                                acVar.e = a(acVar.a);
                                                if (acVar.d == null) {
                                                    return null;
                                                }
                                                length = b(str, b, i, "?#");
                                                acVar.a(str, b, length);
                                                if (length < i || str.charAt(length) != '?') {
                                                    i3 = length;
                                                } else {
                                                    i3 = b(str, length, i, "#");
                                                    acVar.g = b(a(str, length + 1, i3, " \"'<>#", true, true));
                                                }
                                                if (i3 < i && str.charAt(i3) == '#') {
                                                    acVar.h = a(str, i3 + 1, i, "", true, false);
                                                }
                                                if (acVar.a == null) {
                                                    throw new IllegalStateException("scheme == null");
                                                } else if (acVar.d == null) {
                                                    return new ab(acVar);
                                                } else {
                                                    throw new IllegalStateException("host == null");
                                                }
                                            case '@':
                                                if (obj != null) {
                                                    i3 = b(str, i2, b, ":");
                                                    a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                                    if (obj2 != null) {
                                                        a = acVar.b + "%40" + a;
                                                    }
                                                    acVar.b = a;
                                                    if (i3 != b) {
                                                        obj = 1;
                                                        acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                                    }
                                                    obj3 = 1;
                                                    obj4 = obj;
                                                } else {
                                                    acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                                    obj4 = obj;
                                                    obj3 = obj2;
                                                }
                                                i2 = b + 1;
                                                obj2 = obj3;
                                                obj = obj4;
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                i2++;
                            }
                            i2 += length;
                            obj2 = null;
                            obj = null;
                            while (true) {
                                b = b(str, i2, i, "@/\\?#");
                                if (b == i) {
                                }
                                switch (b == i ? str.charAt(b) : '￿') {
                                    case '￿':
                                    case '#':
                                    case '/':
                                    case '?':
                                    case '\\':
                                        length = ac.b(str, i2, b);
                                        if (length + 1 >= b) {
                                            acVar.d = ac.c(str, i2, length);
                                            acVar.e = a(acVar.a);
                                        } else {
                                            acVar.d = ac.c(str, i2, length);
                                            acVar.e = ac.d(str, length + 1, b);
                                            if (acVar.e == -1) {
                                                return null;
                                            }
                                        }
                                        if (acVar.d == null) {
                                            return null;
                                        }
                                        length = b(str, b, i, "?#");
                                        acVar.a(str, b, length);
                                        if (length < i) {
                                            break;
                                        }
                                        i3 = length;
                                        acVar.h = a(str, i3 + 1, i, "", true, false);
                                        if (acVar.a == null) {
                                            throw new IllegalStateException("scheme == null");
                                        } else if (acVar.d == null) {
                                            return new ab(acVar);
                                        } else {
                                            throw new IllegalStateException("host == null");
                                        }
                                    case '@':
                                        if (obj != null) {
                                            acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                            obj4 = obj;
                                            obj3 = obj2;
                                        } else {
                                            i3 = b(str, i2, b, ":");
                                            a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                            if (obj2 != null) {
                                                a = acVar.b + "%40" + a;
                                            }
                                            acVar.b = a;
                                            if (i3 != b) {
                                                obj = 1;
                                                acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                            }
                                            obj3 = 1;
                                            obj4 = obj;
                                        }
                                        i2 = b + 1;
                                        obj2 = obj3;
                                        obj = obj4;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        return null;
                    }
                    length = i3 + 1;
                    while (length < i) {
                        char charAt3 = str.charAt(length);
                        if ((charAt3 < 'a' || charAt3 > 'z') && !((charAt3 >= 'A' && charAt3 <= 'Z') || charAt3 == '+' || charAt3 == '-' || charAt3 == '.')) {
                            if (charAt3 != ':') {
                                length = -1;
                            }
                            if (length != -1) {
                                if (str.regionMatches(true, i3, "https:", 0, 6)) {
                                    if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                                        return null;
                                    }
                                    acVar.a = "http";
                                    length = i3 + 5;
                                } else {
                                    acVar.a = "https";
                                    length = i3 + 6;
                                }
                                i2 = 0;
                                for (i4 = length; i4 < i; i4++) {
                                    charAt = str.charAt(i4);
                                    if (charAt != '\\') {
                                    }
                                    i2++;
                                }
                                i2 += length;
                                obj2 = null;
                                obj = null;
                                while (true) {
                                    b = b(str, i2, i, "@/\\?#");
                                    if (b == i) {
                                    }
                                    switch (b == i ? str.charAt(b) : '￿') {
                                        case '￿':
                                        case '#':
                                        case '/':
                                        case '?':
                                        case '\\':
                                            length = ac.b(str, i2, b);
                                            if (length + 1 >= b) {
                                                acVar.d = ac.c(str, i2, length);
                                                acVar.e = ac.d(str, length + 1, b);
                                                if (acVar.e == -1) {
                                                    return null;
                                                }
                                            }
                                            acVar.d = ac.c(str, i2, length);
                                            acVar.e = a(acVar.a);
                                            if (acVar.d == null) {
                                                return null;
                                            }
                                            length = b(str, b, i, "?#");
                                            acVar.a(str, b, length);
                                            if (length < i) {
                                                break;
                                            }
                                            i3 = length;
                                            acVar.h = a(str, i3 + 1, i, "", true, false);
                                            if (acVar.a == null) {
                                                throw new IllegalStateException("scheme == null");
                                            } else if (acVar.d == null) {
                                                return new ab(acVar);
                                            } else {
                                                throw new IllegalStateException("host == null");
                                            }
                                        case '@':
                                            if (obj != null) {
                                                i3 = b(str, i2, b, ":");
                                                a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                                if (obj2 != null) {
                                                    a = acVar.b + "%40" + a;
                                                }
                                                acVar.b = a;
                                                if (i3 != b) {
                                                    obj = 1;
                                                    acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                                }
                                                obj3 = 1;
                                                obj4 = obj;
                                            } else {
                                                acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                                obj4 = obj;
                                                obj3 = obj2;
                                            }
                                            i2 = b + 1;
                                            obj2 = obj3;
                                            obj = obj4;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            return null;
                        }
                        length++;
                    }
                }
                length = -1;
                if (length != -1) {
                    if (str.regionMatches(true, i3, "https:", 0, 6)) {
                        acVar.a = "https";
                        length = i3 + 6;
                    } else {
                        if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                            return null;
                        }
                        acVar.a = "http";
                        length = i3 + 5;
                    }
                    i2 = 0;
                    for (i4 = length; i4 < i; i4++) {
                        charAt = str.charAt(i4);
                        if (charAt != '\\') {
                        }
                        i2++;
                    }
                    i2 += length;
                    obj2 = null;
                    obj = null;
                    while (true) {
                        b = b(str, i2, i, "@/\\?#");
                        if (b == i) {
                        }
                        switch (b == i ? str.charAt(b) : '￿') {
                            case '￿':
                            case '#':
                            case '/':
                            case '?':
                            case '\\':
                                length = ac.b(str, i2, b);
                                if (length + 1 >= b) {
                                    acVar.d = ac.c(str, i2, length);
                                    acVar.e = a(acVar.a);
                                } else {
                                    acVar.d = ac.c(str, i2, length);
                                    acVar.e = ac.d(str, length + 1, b);
                                    if (acVar.e == -1) {
                                        return null;
                                    }
                                }
                                if (acVar.d == null) {
                                    return null;
                                }
                                length = b(str, b, i, "?#");
                                acVar.a(str, b, length);
                                if (length < i) {
                                    break;
                                }
                                i3 = length;
                                acVar.h = a(str, i3 + 1, i, "", true, false);
                                if (acVar.a == null) {
                                    throw new IllegalStateException("scheme == null");
                                } else if (acVar.d == null) {
                                    return new ab(acVar);
                                } else {
                                    throw new IllegalStateException("host == null");
                                }
                            case '@':
                                if (obj != null) {
                                    acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    obj4 = obj;
                                    obj3 = obj2;
                                } else {
                                    i3 = b(str, i2, b, ":");
                                    a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                    if (obj2 != null) {
                                        a = acVar.b + "%40" + a;
                                    }
                                    acVar.b = a;
                                    if (i3 != b) {
                                        obj = 1;
                                        acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    }
                                    obj3 = 1;
                                    obj4 = obj;
                                }
                                i2 = b + 1;
                                obj2 = obj3;
                                obj = obj4;
                                break;
                            default:
                                break;
                        }
                    }
                }
                return null;
            }
            i = i3;
            if (i - i3 >= 2) {
                charAt2 = str.charAt(i3);
                if (charAt2 >= 'a') {
                }
                length = -1;
                if (length != -1) {
                    if (str.regionMatches(true, i3, "https:", 0, 6)) {
                        if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                            return null;
                        }
                        acVar.a = "http";
                        length = i3 + 5;
                    } else {
                        acVar.a = "https";
                        length = i3 + 6;
                    }
                    i2 = 0;
                    for (i4 = length; i4 < i; i4++) {
                        charAt = str.charAt(i4);
                        if (charAt != '\\') {
                        }
                        i2++;
                    }
                    i2 += length;
                    obj2 = null;
                    obj = null;
                    while (true) {
                        b = b(str, i2, i, "@/\\?#");
                        if (b == i) {
                        }
                        switch (b == i ? str.charAt(b) : '￿') {
                            case '￿':
                            case '#':
                            case '/':
                            case '?':
                            case '\\':
                                length = ac.b(str, i2, b);
                                if (length + 1 >= b) {
                                    acVar.d = ac.c(str, i2, length);
                                    acVar.e = ac.d(str, length + 1, b);
                                    if (acVar.e == -1) {
                                        return null;
                                    }
                                }
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = a(acVar.a);
                                if (acVar.d == null) {
                                    return null;
                                }
                                length = b(str, b, i, "?#");
                                acVar.a(str, b, length);
                                if (length < i) {
                                    break;
                                }
                                i3 = length;
                                acVar.h = a(str, i3 + 1, i, "", true, false);
                                if (acVar.a == null) {
                                    throw new IllegalStateException("scheme == null");
                                } else if (acVar.d == null) {
                                    return new ab(acVar);
                                } else {
                                    throw new IllegalStateException("host == null");
                                }
                            case '@':
                                if (obj != null) {
                                    i3 = b(str, i2, b, ":");
                                    a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                    if (obj2 != null) {
                                        a = acVar.b + "%40" + a;
                                    }
                                    acVar.b = a;
                                    if (i3 != b) {
                                        obj = 1;
                                        acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    }
                                    obj3 = 1;
                                    obj4 = obj;
                                } else {
                                    acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    obj4 = obj;
                                    obj3 = obj2;
                                }
                                i2 = b + 1;
                                obj2 = obj3;
                                obj = obj4;
                                break;
                            default:
                                break;
                        }
                    }
                }
                return null;
            }
            length = -1;
            if (length != -1) {
                if (str.regionMatches(true, i3, "https:", 0, 6)) {
                    acVar.a = "https";
                    length = i3 + 6;
                } else {
                    if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                        return null;
                    }
                    acVar.a = "http";
                    length = i3 + 5;
                }
                i2 = 0;
                for (i4 = length; i4 < i; i4++) {
                    charAt = str.charAt(i4);
                    if (charAt != '\\') {
                    }
                    i2++;
                }
                i2 += length;
                obj2 = null;
                obj = null;
                while (true) {
                    b = b(str, i2, i, "@/\\?#");
                    if (b == i) {
                    }
                    switch (b == i ? str.charAt(b) : '￿') {
                        case '￿':
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            length = ac.b(str, i2, b);
                            if (length + 1 >= b) {
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = a(acVar.a);
                            } else {
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = ac.d(str, length + 1, b);
                                if (acVar.e == -1) {
                                    return null;
                                }
                            }
                            if (acVar.d == null) {
                                return null;
                            }
                            length = b(str, b, i, "?#");
                            acVar.a(str, b, length);
                            if (length < i) {
                                break;
                            }
                            i3 = length;
                            acVar.h = a(str, i3 + 1, i, "", true, false);
                            if (acVar.a == null) {
                                throw new IllegalStateException("scheme == null");
                            } else if (acVar.d == null) {
                                return new ab(acVar);
                            } else {
                                throw new IllegalStateException("host == null");
                            }
                        case '@':
                            if (obj != null) {
                                acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                obj4 = obj;
                                obj3 = obj2;
                            } else {
                                i3 = b(str, i2, b, ":");
                                a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (obj2 != null) {
                                    a = acVar.b + "%40" + a;
                                }
                                acVar.b = a;
                                if (i3 != b) {
                                    obj = 1;
                                    acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                }
                                obj3 = 1;
                                obj4 = obj;
                            }
                            i2 = b + 1;
                            obj2 = obj3;
                            obj = obj4;
                            break;
                        default:
                            break;
                    }
                }
            }
            return null;
        }
        i3 = length;
        length = str.length() - 1;
        while (length >= i3) {
            switch (str.charAt(length)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    length--;
                default:
                    i = length + 1;
                    break;
            }
            if (i - i3 >= 2) {
                charAt2 = str.charAt(i3);
                if (charAt2 >= 'a') {
                }
                length = -1;
                if (length != -1) {
                    if (str.regionMatches(true, i3, "https:", 0, 6)) {
                        if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                            return null;
                        }
                        acVar.a = "http";
                        length = i3 + 5;
                    } else {
                        acVar.a = "https";
                        length = i3 + 6;
                    }
                    i2 = 0;
                    for (i4 = length; i4 < i; i4++) {
                        charAt = str.charAt(i4);
                        if (charAt != '\\') {
                        }
                        i2++;
                    }
                    i2 += length;
                    obj2 = null;
                    obj = null;
                    while (true) {
                        b = b(str, i2, i, "@/\\?#");
                        if (b == i) {
                        }
                        switch (b == i ? str.charAt(b) : '￿') {
                            case '￿':
                            case '#':
                            case '/':
                            case '?':
                            case '\\':
                                length = ac.b(str, i2, b);
                                if (length + 1 >= b) {
                                    acVar.d = ac.c(str, i2, length);
                                    acVar.e = ac.d(str, length + 1, b);
                                    if (acVar.e == -1) {
                                        return null;
                                    }
                                }
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = a(acVar.a);
                                if (acVar.d == null) {
                                    return null;
                                }
                                length = b(str, b, i, "?#");
                                acVar.a(str, b, length);
                                if (length < i) {
                                    break;
                                }
                                i3 = length;
                                acVar.h = a(str, i3 + 1, i, "", true, false);
                                if (acVar.a == null) {
                                    throw new IllegalStateException("scheme == null");
                                } else if (acVar.d == null) {
                                    return new ab(acVar);
                                } else {
                                    throw new IllegalStateException("host == null");
                                }
                            case '@':
                                if (obj != null) {
                                    i3 = b(str, i2, b, ":");
                                    a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                    if (obj2 != null) {
                                        a = acVar.b + "%40" + a;
                                    }
                                    acVar.b = a;
                                    if (i3 != b) {
                                        obj = 1;
                                        acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    }
                                    obj3 = 1;
                                    obj4 = obj;
                                } else {
                                    acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                    obj4 = obj;
                                    obj3 = obj2;
                                }
                                i2 = b + 1;
                                obj2 = obj3;
                                obj = obj4;
                                break;
                            default:
                                break;
                        }
                    }
                }
                return null;
            }
            length = -1;
            if (length != -1) {
                if (str.regionMatches(true, i3, "https:", 0, 6)) {
                    acVar.a = "https";
                    length = i3 + 6;
                } else {
                    if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                        return null;
                    }
                    acVar.a = "http";
                    length = i3 + 5;
                }
                i2 = 0;
                for (i4 = length; i4 < i; i4++) {
                    charAt = str.charAt(i4);
                    if (charAt != '\\') {
                    }
                    i2++;
                }
                i2 += length;
                obj2 = null;
                obj = null;
                while (true) {
                    b = b(str, i2, i, "@/\\?#");
                    if (b == i) {
                    }
                    switch (b == i ? str.charAt(b) : '￿') {
                        case '￿':
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            length = ac.b(str, i2, b);
                            if (length + 1 >= b) {
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = a(acVar.a);
                            } else {
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = ac.d(str, length + 1, b);
                                if (acVar.e == -1) {
                                    return null;
                                }
                            }
                            if (acVar.d == null) {
                                return null;
                            }
                            length = b(str, b, i, "?#");
                            acVar.a(str, b, length);
                            if (length < i) {
                                break;
                            }
                            i3 = length;
                            acVar.h = a(str, i3 + 1, i, "", true, false);
                            if (acVar.a == null) {
                                throw new IllegalStateException("scheme == null");
                            } else if (acVar.d == null) {
                                return new ab(acVar);
                            } else {
                                throw new IllegalStateException("host == null");
                            }
                        case '@':
                            if (obj != null) {
                                acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                obj4 = obj;
                                obj3 = obj2;
                            } else {
                                i3 = b(str, i2, b, ":");
                                a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (obj2 != null) {
                                    a = acVar.b + "%40" + a;
                                }
                                acVar.b = a;
                                if (i3 != b) {
                                    obj = 1;
                                    acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                }
                                obj3 = 1;
                                obj4 = obj;
                            }
                            i2 = b + 1;
                            obj2 = obj3;
                            obj = obj4;
                            break;
                        default:
                            break;
                    }
                }
            }
            return null;
        }
        i = i3;
        if (i - i3 >= 2) {
            charAt2 = str.charAt(i3);
            if (charAt2 >= 'a') {
            }
            length = -1;
            if (length != -1) {
                if (str.regionMatches(true, i3, "https:", 0, 6)) {
                    if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                        return null;
                    }
                    acVar.a = "http";
                    length = i3 + 5;
                } else {
                    acVar.a = "https";
                    length = i3 + 6;
                }
                i2 = 0;
                for (i4 = length; i4 < i; i4++) {
                    charAt = str.charAt(i4);
                    if (charAt != '\\') {
                    }
                    i2++;
                }
                i2 += length;
                obj2 = null;
                obj = null;
                while (true) {
                    b = b(str, i2, i, "@/\\?#");
                    if (b == i) {
                    }
                    switch (b == i ? str.charAt(b) : '￿') {
                        case '￿':
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            length = ac.b(str, i2, b);
                            if (length + 1 >= b) {
                                acVar.d = ac.c(str, i2, length);
                                acVar.e = ac.d(str, length + 1, b);
                                if (acVar.e == -1) {
                                    return null;
                                }
                            }
                            acVar.d = ac.c(str, i2, length);
                            acVar.e = a(acVar.a);
                            if (acVar.d == null) {
                                return null;
                            }
                            length = b(str, b, i, "?#");
                            acVar.a(str, b, length);
                            if (length < i) {
                                break;
                            }
                            i3 = length;
                            acVar.h = a(str, i3 + 1, i, "", true, false);
                            if (acVar.a == null) {
                                throw new IllegalStateException("scheme == null");
                            } else if (acVar.d == null) {
                                return new ab(acVar);
                            } else {
                                throw new IllegalStateException("host == null");
                            }
                        case '@':
                            if (obj != null) {
                                i3 = b(str, i2, b, ":");
                                a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (obj2 != null) {
                                    a = acVar.b + "%40" + a;
                                }
                                acVar.b = a;
                                if (i3 != b) {
                                    obj = 1;
                                    acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                }
                                obj3 = 1;
                                obj4 = obj;
                            } else {
                                acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                obj4 = obj;
                                obj3 = obj2;
                            }
                            i2 = b + 1;
                            obj2 = obj3;
                            obj = obj4;
                            break;
                        default:
                            break;
                    }
                }
            }
            return null;
        }
        length = -1;
        if (length != -1) {
            if (str.regionMatches(true, i3, "https:", 0, 6)) {
                acVar.a = "https";
                length = i3 + 6;
            } else {
                if (!str.regionMatches(true, i3, "http:", 0, 5)) {
                    return null;
                }
                acVar.a = "http";
                length = i3 + 5;
            }
            i2 = 0;
            for (i4 = length; i4 < i; i4++) {
                charAt = str.charAt(i4);
                if (charAt != '\\') {
                }
                i2++;
            }
            i2 += length;
            obj2 = null;
            obj = null;
            while (true) {
                b = b(str, i2, i, "@/\\?#");
                if (b == i) {
                }
                switch (b == i ? str.charAt(b) : '￿') {
                    case '￿':
                    case '#':
                    case '/':
                    case '?':
                    case '\\':
                        length = ac.b(str, i2, b);
                        if (length + 1 >= b) {
                            acVar.d = ac.c(str, i2, length);
                            acVar.e = a(acVar.a);
                        } else {
                            acVar.d = ac.c(str, i2, length);
                            acVar.e = ac.d(str, length + 1, b);
                            if (acVar.e == -1) {
                                return null;
                            }
                        }
                        if (acVar.d == null) {
                            return null;
                        }
                        length = b(str, b, i, "?#");
                        acVar.a(str, b, length);
                        if (length < i) {
                            break;
                        }
                        i3 = length;
                        acVar.h = a(str, i3 + 1, i, "", true, false);
                        if (acVar.a == null) {
                            throw new IllegalStateException("scheme == null");
                        } else if (acVar.d == null) {
                            return new ab(acVar);
                        } else {
                            throw new IllegalStateException("host == null");
                        }
                    case '@':
                        if (obj != null) {
                            acVar.c += "%40" + a(str, i2, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                            obj4 = obj;
                            obj3 = obj2;
                        } else {
                            i3 = b(str, i2, b, ":");
                            a = a(str, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                            if (obj2 != null) {
                                a = acVar.b + "%40" + a;
                            }
                            acVar.b = a;
                            if (i3 != b) {
                                obj = 1;
                                acVar.c = a(str, i3 + 1, b, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                            }
                            obj3 = 1;
                            obj4 = obj;
                        }
                        i2 = b + 1;
                        obj2 = obj3;
                        obj = obj4;
                        break;
                    default:
                        break;
                }
            }
        }
        return null;
    }

    private static String d(String str) {
        return a(str, 0, str.length());
    }

    public final URL a() {
        try {
            return new URL(this.j);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final URI b() {
        try {
            return new URI(this.j);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.j);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ab) && ((ab) obj).j.equals(this.j);
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final String toString() {
        return this.j;
    }
}
