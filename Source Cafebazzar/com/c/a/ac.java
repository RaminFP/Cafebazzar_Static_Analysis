package com.c.a;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ac {
    String a;
    String b = "";
    String c = "";
    String d;
    int e = -1;
    final List f = new ArrayList();
    List g;
    String h;

    public ac() {
        this.f.add("");
    }

    private static String a(String str) {
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            return toLowerCase.isEmpty() ? null : toLowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int b(java.lang.String r3, int r4, int r5) {
        /*
        r0 = r4;
    L_0x0001:
        if (r0 >= r5) goto L_0x001a;
    L_0x0003:
        r1 = r3.charAt(r0);
        switch(r1) {
            case 58: goto L_0x001b;
            case 91: goto L_0x000d;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000d:
        r0 = r0 + 1;
        if (r0 >= r5) goto L_0x000a;
    L_0x0011:
        r1 = r3.charAt(r0);
        r2 = 93;
        if (r1 != r2) goto L_0x000d;
    L_0x0019:
        goto L_0x000a;
    L_0x001a:
        r0 = r5;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.ac.b(java.lang.String, int, int):int");
    }

    static String c(String str, int i, int i2) {
        String a = ab.a(str, i, i2);
        if (a.startsWith("[") && a.endsWith("]")) {
            InetAddress e = e(a, 1, a.length() - 1);
            return e != null ? e.getHostAddress() : null;
        } else {
            a = a(a);
            if (a == null) {
                return null;
            }
            int length = a.length();
            return ab.b(a, 0, length, "\u0000\t\n\r #%/:?@[\\]") == length ? a : null;
        }
    }

    static int d(String str, int i, int i2) {
        try {
            int parseInt = Integer.parseInt(ab.a(str, i, i2, "", false, false));
            return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static InetAddress e(String str, int i, int i2) {
        Object obj = new byte[16];
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = 1;
        while (i6 < i2) {
            if (i3 == 16) {
                return null;
            }
            int i7;
            int i8;
            if (i6 + 2 > i2 || !str.regionMatches(i6, "::", 0, 2)) {
                if (i3 != 0) {
                    if (str.regionMatches(i6, ":", 0, 1)) {
                        i6++;
                    } else if (!str.regionMatches(i6, ".", 0, 1)) {
                        return null;
                    } else {
                        Object obj2;
                        int i9 = i3 - 2;
                        i7 = i9;
                        i6 = i5;
                        loop2:
                        while (i6 < i2) {
                            if (i7 == 16) {
                                obj2 = null;
                                break;
                            }
                            if (i7 != i9) {
                                if (str.charAt(i6) != '.') {
                                    obj2 = null;
                                    break;
                                }
                                i6++;
                            }
                            i8 = 0;
                            i5 = i6;
                            while (i5 < i2) {
                                char charAt = str.charAt(i5);
                                if (charAt >= '0' && charAt <= '9') {
                                    if (i8 == 0 && i6 != i5) {
                                        obj2 = null;
                                        break loop2;
                                    }
                                    i8 = ((i8 * 10) + charAt) - 48;
                                    if (i8 > 255) {
                                        obj2 = null;
                                        break loop2;
                                    }
                                    i5++;
                                } else {
                                    break;
                                }
                            }
                            if (i5 - i6 == 0) {
                                obj2 = null;
                                break;
                            }
                            obj[i7] = (byte) i8;
                            i7++;
                            i6 = i5;
                        }
                        obj2 = i7 != i9 + 4 ? null : 1;
                        if (obj2 == null) {
                            return null;
                        }
                        i3 += 2;
                    }
                }
            } else if (i4 != -1) {
                return null;
            } else {
                i4 = i6 + 2;
                i3 += 2;
                if (i4 == i2) {
                    i4 = i3;
                    break;
                }
                i6 = i4;
                i4 = i3;
            }
            i8 = 0;
            i5 = i6;
            while (i5 < i2) {
                i7 = ab.a(str.charAt(i5));
                if (i7 == -1) {
                    break;
                }
                i8 = (i8 << 4) + i7;
                i5++;
            }
            i7 = i5 - i6;
            if (i7 == 0 || i7 > 4) {
                return null;
            }
            i7 = i3 + 1;
            obj[i3] = (byte) (i8 >>> 8);
            i3 = i7 + 1;
            obj[i7] = (byte) i8;
            int i10 = i5;
            i5 = i6;
            i6 = i10;
        }
        if (i3 != 16) {
            if (i4 == -1) {
                return null;
            }
            System.arraycopy(obj, i4, obj, 16 - (i3 - i4), i3 - i4);
            Arrays.fill(obj, i4, (16 - i3) + i4, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(obj);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    final int a() {
        return this.e != -1 ? this.e : ab.a(this.a);
    }

    void a(String str, int i, int i2) {
        if (i != i2) {
            int i3;
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i3 = i + 1;
            } else {
                this.f.set(this.f.size() - 1, "");
                i3 = i;
            }
            while (i3 < i2) {
                int a = ab.b(str, i3, i2, "/\\");
                boolean z = a < i2;
                String a2 = ab.a(str, i3, a, " \"<>^`{}|/\\?#", true, false);
                boolean z2 = a2.equals(".") || a2.equalsIgnoreCase("%2e");
                if (!z2) {
                    z2 = a2.equals("..") || a2.equalsIgnoreCase("%2e.") || a2.equalsIgnoreCase(".%2e") || a2.equalsIgnoreCase("%2e%2e");
                    if (!z2) {
                        if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                            this.f.set(this.f.size() - 1, a2);
                        } else {
                            this.f.add(a2);
                        }
                        if (z) {
                            this.f.add("");
                        }
                    } else if (!((String) this.f.remove(this.f.size() - 1)).isEmpty() || this.f.isEmpty()) {
                        this.f.add("");
                    } else {
                        this.f.set(this.f.size() - 1, "");
                    }
                }
                if (z) {
                    a++;
                }
                i3 = a;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("://");
        if (!(this.b.isEmpty() && this.c.isEmpty())) {
            stringBuilder.append(this.b);
            if (!this.c.isEmpty()) {
                stringBuilder.append(':');
                stringBuilder.append(this.c);
            }
            stringBuilder.append('@');
        }
        if (this.d.indexOf(58) != -1) {
            stringBuilder.append('[');
            stringBuilder.append(this.d);
            stringBuilder.append(']');
        } else {
            stringBuilder.append(this.d);
        }
        int a = a();
        if (a != ab.a(this.a)) {
            stringBuilder.append(':');
            stringBuilder.append(a);
        }
        ab.a(stringBuilder, this.f);
        if (this.g != null) {
            stringBuilder.append('?');
            ab.b(stringBuilder, this.g);
        }
        if (this.h != null) {
            stringBuilder.append('#');
            stringBuilder.append(this.h);
        }
        return stringBuilder.toString();
    }
}
