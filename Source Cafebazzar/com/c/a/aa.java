package com.c.a;

import java.util.ArrayList;
import java.util.List;

public final class aa {
    public final List a = new ArrayList(20);

    private aa c(String str, String str2) {
        this.a.add(str);
        this.a.add(str2.trim());
        return this;
    }

    final aa a(String str) {
        int indexOf = str.indexOf(":", 1);
        return indexOf != -1 ? c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? c("", str.substring(1)) : c("", str);
    }

    public final aa a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        } else if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
            return c(str, str2);
        } else {
            throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
        }
    }

    public final z a() {
        return new z();
    }

    public final aa b(String str) {
        int i = 0;
        while (i < this.a.size()) {
            if (str.equalsIgnoreCase((String) this.a.get(i))) {
                this.a.remove(i);
                this.a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }

    public final aa b(String str, String str2) {
        b(str);
        a(str, str2);
        return this;
    }
}
