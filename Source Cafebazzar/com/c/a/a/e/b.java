package com.c.a.a.e;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;

public final class b implements HostnameVerifier {
    public static final b a = new b();
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private b() {
    }

    public static List a(X509Certificate x509Certificate) {
        Collection a = a(x509Certificate, 7);
        Collection a2 = a(x509Certificate, 2);
        List arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    private static List a(X509Certificate x509Certificate, int i) {
        List arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private static boolean a(String str, String str2) {
        if (!(str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith(".."))) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String toLowerCase = str2.toLowerCase(Locale.US);
            if (!toLowerCase.contains("*")) {
                return str.equals(toLowerCase);
            }
            if (toLowerCase.startsWith("*.") && toLowerCase.indexOf(42, 1) == -1 && str.length() >= toLowerCase.length() && !"*.".equals(toLowerCase)) {
                toLowerCase = toLowerCase.substring(1);
                if (str.endsWith(toLowerCase)) {
                    int length = str.length() - toLowerCase.length();
                    if (length <= 0) {
                        return true;
                    }
                    if (str.lastIndexOf(46, length - 1) == -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean verify(java.lang.String r11, javax.net.ssl.SSLSession r12) {
        /*
        r10 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r12.getPeerCertificates();	 Catch:{ SSLException -> 0x00d6 }
        r1 = 0;
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00d6 }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ SSLException -> 0x00d6 }
        r1 = b;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.matcher(r11);	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.matches();	 Catch:{ SSLException -> 0x00d6 }
        if (r1 == 0) goto L_0x0033;
    L_0x0018:
        r1 = 7;
        r4 = a(r0, r1);	 Catch:{ SSLException -> 0x00d6 }
        r5 = r4.size();	 Catch:{ SSLException -> 0x00d6 }
        r1 = r3;
    L_0x0022:
        if (r1 >= r5) goto L_0x01a5;
    L_0x0024:
        r0 = r4.get(r1);	 Catch:{ SSLException -> 0x00d6 }
        r0 = (java.lang.String) r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r11.equalsIgnoreCase(r0);	 Catch:{ SSLException -> 0x00d6 }
        if (r0 == 0) goto L_0x01a0;
    L_0x0030:
        r0 = r2;
    L_0x0031:
        r2 = r0;
    L_0x0032:
        return r2;
    L_0x0033:
        r1 = java.util.Locale.US;	 Catch:{ SSLException -> 0x00d6 }
        r6 = r11.toLowerCase(r1);	 Catch:{ SSLException -> 0x00d6 }
        r1 = 2;
        r7 = a(r0, r1);	 Catch:{ SSLException -> 0x00d6 }
        r8 = r7.size();	 Catch:{ SSLException -> 0x00d6 }
        r5 = r3;
        r1 = r3;
    L_0x0044:
        if (r5 >= r8) goto L_0x0057;
    L_0x0046:
        r1 = r7.get(r5);	 Catch:{ SSLException -> 0x00d6 }
        r1 = (java.lang.String) r1;	 Catch:{ SSLException -> 0x00d6 }
        r1 = a(r6, r1);	 Catch:{ SSLException -> 0x00d6 }
        if (r1 != 0) goto L_0x0032;
    L_0x0052:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r2;
        goto L_0x0044;
    L_0x0057:
        if (r1 != 0) goto L_0x019d;
    L_0x0059:
        r2 = new com.c.a.a.e.a;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0.getSubjectX500Principal();	 Catch:{ SSLException -> 0x00d6 }
        r2.<init>(r0);	 Catch:{ SSLException -> 0x00d6 }
        r0 = 0;
        r2.c = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = 0;
        r2.d = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = 0;
        r2.e = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = 0;
        r2.f = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r2.a;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0.toCharArray();	 Catch:{ SSLException -> 0x00d6 }
        r2.g = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r2.a();	 Catch:{ SSLException -> 0x00d6 }
        if (r0 != 0) goto L_0x0084;
    L_0x007c:
        r1 = r4;
    L_0x007d:
        if (r1 == 0) goto L_0x019d;
    L_0x007f:
        r2 = a(r6, r1);	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x0032;
    L_0x0084:
        r1 = "";
        r5 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r2.b;	 Catch:{ SSLException -> 0x00d6 }
        if (r5 != r7) goto L_0x008e;
    L_0x008c:
        r1 = r4;
        goto L_0x007d;
    L_0x008e:
        r5 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r5[r7];	 Catch:{ SSLException -> 0x00d6 }
        switch(r5) {
            case 34: goto L_0x00ab;
            case 35: goto L_0x013f;
            case 43: goto L_0x009b;
            case 44: goto L_0x009b;
            case 59: goto L_0x009b;
            default: goto L_0x0097;
        };	 Catch:{ SSLException -> 0x00d6 }
    L_0x0097:
        r1 = r2.c();	 Catch:{ SSLException -> 0x00d6 }
    L_0x009b:
        r5 = "cn";
        r0 = r5.equalsIgnoreCase(r0);	 Catch:{ SSLException -> 0x00d6 }
        if (r0 != 0) goto L_0x007d;
    L_0x00a3:
        r0 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.b;	 Catch:{ SSLException -> 0x00d6 }
        if (r0 < r1) goto L_0x0145;
    L_0x00a9:
        r1 = r4;
        goto L_0x007d;
    L_0x00ab:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1 + 1;
        r2.c = r1;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r2.d = r1;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.d;	 Catch:{ SSLException -> 0x00d6 }
        r2.e = r1;	 Catch:{ SSLException -> 0x00d6 }
    L_0x00b9:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.b;	 Catch:{ SSLException -> 0x00d6 }
        if (r1 != r5) goto L_0x00da;
    L_0x00bf:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00d6 }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00d6 }
        r4 = "Unexpected end of DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00d6 }
        r2 = r2.a;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00d6 }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00d6 }
        throw r0;	 Catch:{ SSLException -> 0x00d6 }
    L_0x00d6:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0032;
    L_0x00da:
        r1 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1[r5];	 Catch:{ SSLException -> 0x00d6 }
        r5 = 34;
        if (r1 != r5) goto L_0x0101;
    L_0x00e4:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1 + 1;
        r2.c = r1;	 Catch:{ SSLException -> 0x00d6 }
    L_0x00ea:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.b;	 Catch:{ SSLException -> 0x00d6 }
        if (r1 >= r5) goto L_0x012f;
    L_0x00f0:
        r1 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1[r5];	 Catch:{ SSLException -> 0x00d6 }
        r5 = 32;
        if (r1 != r5) goto L_0x012f;
    L_0x00fa:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1 + 1;
        r2.c = r1;	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x00ea;
    L_0x0101:
        r1 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1[r5];	 Catch:{ SSLException -> 0x00d6 }
        r5 = 92;
        if (r1 != r5) goto L_0x0122;
    L_0x010b:
        r1 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.e;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r2.d();	 Catch:{ SSLException -> 0x00d6 }
        r1[r5] = r7;	 Catch:{ SSLException -> 0x00d6 }
    L_0x0115:
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1 + 1;
        r2.c = r1;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.e;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1 + 1;
        r2.e = r1;	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x00b9;
    L_0x0122:
        r1 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.e;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r8 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r7[r8];	 Catch:{ SSLException -> 0x00d6 }
        r1[r5] = r7;	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x0115;
    L_0x012f:
        r1 = new java.lang.String;	 Catch:{ SSLException -> 0x00d6 }
        r5 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r7 = r2.d;	 Catch:{ SSLException -> 0x00d6 }
        r8 = r2.e;	 Catch:{ SSLException -> 0x00d6 }
        r9 = r2.d;	 Catch:{ SSLException -> 0x00d6 }
        r8 = r8 - r9;
        r1.<init>(r5, r7, r8);	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x009b;
    L_0x013f:
        r1 = r2.b();	 Catch:{ SSLException -> 0x00d6 }
        goto L_0x009b;
    L_0x0145:
        r0 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00d6 }
        r1 = 44;
        if (r0 == r1) goto L_0x017a;
    L_0x014f:
        r0 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00d6 }
        r1 = 59;
        if (r0 == r1) goto L_0x017a;
    L_0x0159:
        r0 = r2.g;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0[r1];	 Catch:{ SSLException -> 0x00d6 }
        r1 = 43;
        if (r0 == r1) goto L_0x017a;
    L_0x0163:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00d6 }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00d6 }
        r4 = "Malformed DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00d6 }
        r2 = r2.a;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00d6 }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00d6 }
        throw r0;	 Catch:{ SSLException -> 0x00d6 }
    L_0x017a:
        r0 = r2.c;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r0 + 1;
        r2.c = r0;	 Catch:{ SSLException -> 0x00d6 }
        r0 = r2.a();	 Catch:{ SSLException -> 0x00d6 }
        if (r0 != 0) goto L_0x0084;
    L_0x0186:
        r0 = new java.lang.IllegalStateException;	 Catch:{ SSLException -> 0x00d6 }
        r1 = new java.lang.StringBuilder;	 Catch:{ SSLException -> 0x00d6 }
        r4 = "Malformed DN: ";
        r1.<init>(r4);	 Catch:{ SSLException -> 0x00d6 }
        r2 = r2.a;	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.append(r2);	 Catch:{ SSLException -> 0x00d6 }
        r1 = r1.toString();	 Catch:{ SSLException -> 0x00d6 }
        r0.<init>(r1);	 Catch:{ SSLException -> 0x00d6 }
        throw r0;	 Catch:{ SSLException -> 0x00d6 }
    L_0x019d:
        r0 = r3;
        goto L_0x0031;
    L_0x01a0:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x01a5:
        r0 = r3;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.e.b.verify(java.lang.String, javax.net.ssl.SSLSession):boolean");
    }
}
