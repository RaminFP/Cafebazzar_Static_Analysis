package com.c.a.a.a;

import com.c.a.ak;
import com.c.a.ap;
import java.net.ProtocolException;

public final class af {
    public final ak a;
    public final int b;
    public final String c;

    public af(ak akVar, int i, String str) {
        this.a = akVar;
        this.b = i;
        this.c = str;
    }

    public static af a(ap apVar) {
        return new af(apVar.b, apVar.c, apVar.d);
    }

    public static af a(String str) {
        ak akVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                akVar = ak.HTTP_1_0;
            } else if (charAt == 1) {
                akVar = ak.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            akVar = ak.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            if (str.length() <= i + 3) {
                str2 = "";
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new af(akVar, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a == ak.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ').append(this.c);
        }
        return stringBuilder.toString();
    }
}
