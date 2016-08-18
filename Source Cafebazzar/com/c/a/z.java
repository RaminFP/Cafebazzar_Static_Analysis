package com.c.a;

import com.c.a.a.a.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class z {
    public final String[] a;

    private z(aa aaVar) {
        this.a = (String[]) aaVar.a.toArray(new String[aaVar.a.size()]);
    }

    public final aa a() {
        aa aaVar = new aa();
        Collections.addAll(aaVar.a, this.a);
        return aaVar;
    }

    public final String a(int i) {
        int i2 = i << 1;
        return (i2 < 0 || i2 >= this.a.length) ? null : this.a[i2];
    }

    public final String a(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String b(int i) {
        int i2 = (i << 1) + 1;
        return (i2 < 0 || i2 >= this.a.length) ? null : this.a[i2];
    }

    public final Date b(String str) {
        String a = a(str);
        return a != null ? m.a(a) : null;
    }

    public final List c(String str) {
        int length = this.a.length / 2;
        List list = null;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(b(i));
            }
        }
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
