package d;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class k implements Serializable {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final k b = a(new byte[0]);
    public final byte[] c;
    transient int d;
    transient String e;

    k(byte[] bArr) {
        this.c = bArr;
    }

    public static k a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        k kVar = new k(str.getBytes(af.a));
        kVar.e = str;
        return kVar;
    }

    public static k a(byte... bArr) {
        if (bArr != null) {
            return new k((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static k b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a = e.a(str);
        return a != null ? new k(a) : null;
    }

    private k c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        str = new String(this.c, af.a);
        this.e = str;
        return str;
    }

    public final String b() {
        int i = 0;
        char[] cArr = new char[(this.c.length << 1)];
        for (byte b : this.c) {
            int i2 = i + 1;
            cArr[i] = a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b & 15];
        }
        return new String(cArr);
    }

    public final k c() {
        int i = 0;
        while (i < this.c.length) {
            byte b = this.c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.c.clone();
                bArr[i] = (byte) (b + 32);
                for (i++; i < bArr.length; i++) {
                    b = bArr[i];
                    if (b >= (byte) 65 && b <= (byte) 90) {
                        bArr[i] = (byte) (b + 32);
                    }
                }
                return new k(bArr);
            }
        }
        return this;
    }

    public final byte[] d() {
        return (byte[]) this.c.clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof k) && ((k) obj).c.length == this.c.length) {
            k kVar = (k) obj;
            byte[] bArr = this.c;
            int length = this.c.length;
            int i = (kVar.c.length - length < 0 || bArr.length - length < 0 || !af.a(kVar.c, 0, bArr, 0, length)) ? 0 : 1;
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.c);
        this.d = i;
        return i;
    }

    public final String toString() {
        if (this.c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.c.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.c.length), b()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.c.length), c("MD5").b()});
    }
}
