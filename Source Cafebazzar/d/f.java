package d;

import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class f implements i, j, Cloneable {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    z a;
    public long b;

    private String a(long j, Charset charset) {
        af.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            z zVar = this.a;
            if (((long) zVar.b) + j > ((long) zVar.c)) {
                return new String(e(j), charset);
            }
            String str = new String(zVar.a, zVar.b, (int) j, charset);
            zVar.b = (int) (((long) zVar.b) + j);
            this.b -= j;
            if (zVar.b != zVar.c) {
                return str;
            }
            this.a = zVar.a();
            aa.a(zVar);
            return str;
        }
    }

    private void c(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    private String k(long j) {
        return a(j, af.a);
    }

    private f t() {
        f fVar = new f();
        if (this.b == 0) {
            return fVar;
        }
        fVar.a = new z(this.a);
        z zVar = fVar.a;
        z zVar2 = fVar.a;
        z zVar3 = fVar.a;
        zVar2.g = zVar3;
        zVar.f = zVar3;
        for (zVar = this.a.f; zVar != this.a; zVar = zVar.f) {
            fVar.a.g.a(new z(zVar));
        }
        fVar.b = this.b;
        return fVar;
    }

    public final int a(byte[] bArr, int i, int i2) {
        af.a((long) bArr.length, (long) i, (long) i2);
        z zVar = this.a;
        if (zVar == null) {
            return -1;
        }
        int min = Math.min(i2, zVar.c - zVar.b);
        System.arraycopy(zVar.a, zVar.b, bArr, i, min);
        zVar.b += min;
        this.b -= (long) min;
        if (zVar.b != zVar.c) {
            return min;
        }
        this.a = zVar.a();
        aa.a(zVar);
        return min;
    }

    public final long a(byte b) {
        return a(b, 0);
    }

    public final long a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        z zVar = this.a;
        if (zVar == null) {
            return -1;
        }
        long j2 = 0;
        do {
            int i = zVar.c - zVar.b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = zVar.a;
                long j3 = (long) zVar.c;
                for (long j4 = ((long) zVar.b) + j; j4 < j3; j4++) {
                    if (bArr[(int) j4] == b) {
                        return (j2 + j4) - ((long) zVar.b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            zVar = zVar.f;
        } while (zVar != this.a);
        return -1;
    }

    public final long a(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = acVar.a(this, 2048);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    public final long a(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            fVar.a_(this, j);
            return j;
        }
    }

    public final f a(int i) {
        if (i < NotificationCompat.FLAG_HIGH_PRIORITY) {
            b(i);
        } else if (i < ItemAnimator.FLAG_MOVED) {
            b((i >> 6) | 192);
            b((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | 224);
                b(((i >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                b((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            b(((i >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            b((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public final f a(f fVar, long j, long j2) {
        if (fVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        af.a(this.b, j, j2);
        if (j2 != 0) {
            fVar.b += j2;
            z zVar = this.a;
            while (j >= ((long) (zVar.c - zVar.b))) {
                j -= (long) (zVar.c - zVar.b);
                zVar = zVar.f;
            }
            while (j2 > 0) {
                z zVar2 = new z(zVar);
                zVar2.b = (int) (((long) zVar2.b) + j);
                zVar2.c = Math.min(zVar2.b + ((int) j2), zVar2.c);
                if (fVar.a == null) {
                    zVar2.g = zVar2;
                    zVar2.f = zVar2;
                    fVar.a = zVar2;
                } else {
                    fVar.a.g.a(zVar2);
                }
                j2 -= (long) (zVar2.c - zVar2.b);
                zVar = zVar.f;
                j = 0;
            }
        }
        return this;
    }

    public final f a(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        b(kVar.c, 0, kVar.c.length);
        return this;
    }

    public final f a(String str) {
        return a(str, 0, str.length());
    }

    public final f a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                if (charAt < '') {
                    z e = e(1);
                    byte[] bArr = e.a;
                    int i4 = e.c - i;
                    int min = Math.min(i2, 2048 - i4);
                    i3 = i + 1;
                    bArr[i4 + i] = (byte) charAt;
                    while (i3 < min) {
                        charAt = str.charAt(i3);
                        if (charAt >= '') {
                            break;
                        }
                        bArr[i3 + i4] = (byte) charAt;
                        i3++;
                    }
                    int i5 = (i3 + i4) - e.c;
                    e.c += i5;
                    this.b += (long) i5;
                    i = i3;
                } else if (charAt < 'ࠀ') {
                    b((charAt >> 6) | 192);
                    b((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    i++;
                } else if (charAt < '?' || charAt > '?') {
                    b((charAt >> 12) | 224);
                    b(((charAt >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    b((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    i++;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        b((i3 >> 18) | 240);
                        b(((i3 >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        b(((i3 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        b((i3 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        i += 2;
                    }
                }
            }
            return this;
        }
    }

    public final f a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final void a(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public final void a_(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (fVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            af.a(fVar.b, 0, j);
            while (j > 0) {
                z zVar;
                z zVar2;
                if (j < ((long) (fVar.a.c - fVar.a.b))) {
                    zVar = this.a != null ? this.a.g : null;
                    if (zVar != null && zVar.e) {
                        if ((((long) zVar.c) + j) - ((long) (zVar.d ? 0 : zVar.b)) <= 2048) {
                            fVar.a.a(zVar, (int) j);
                            fVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    zVar2 = fVar.a;
                    int i = (int) j;
                    if (i <= 0 || i > zVar2.c - zVar2.b) {
                        throw new IllegalArgumentException();
                    }
                    z zVar3 = new z(zVar2);
                    zVar3.c = zVar3.b + i;
                    zVar2.b = i + zVar2.b;
                    zVar2.g.a(zVar3);
                    fVar.a = zVar3;
                }
                zVar2 = fVar.a;
                long j2 = (long) (zVar2.c - zVar2.b);
                fVar.a = zVar2.a();
                if (this.a == null) {
                    this.a = zVar2;
                    zVar2 = this.a;
                    zVar = this.a;
                    z zVar4 = this.a;
                    zVar.g = zVar4;
                    zVar2.f = zVar4;
                } else {
                    zVar = this.a.g.a(zVar2);
                    if (zVar.g == zVar) {
                        throw new IllegalStateException();
                    } else if (zVar.g.e) {
                        int i2 = zVar.c - zVar.b;
                        if (i2 <= (zVar.g.d ? 0 : zVar.g.b) + (2048 - zVar.g.c)) {
                            zVar.a(zVar.g, i2);
                            zVar.a();
                            aa.a(zVar);
                        }
                    }
                }
                fVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public final byte b(long j) {
        af.a(this.b, j, 1);
        z zVar = this.a;
        while (true) {
            int i = zVar.c - zVar.b;
            if (j < ((long) i)) {
                return zVar.a[zVar.b + ((int) j)];
            }
            j -= (long) i;
            zVar = zVar.f;
        }
    }

    public final f b() {
        return this;
    }

    public final f b(int i) {
        z e = e(1);
        byte[] bArr = e.a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public final f b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        af.a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            z e = e(1);
            int min = Math.min(i3 - i, 2048 - e.c);
            System.arraycopy(bArr, i, e.a, e.c, min);
            i += min;
            e.c = min + e.c;
        }
        this.b += (long) i2;
        return this;
    }

    public final /* synthetic */ i b(k kVar) {
        return a(kVar);
    }

    public final /* synthetic */ i b(String str) {
        return a(str);
    }

    public final /* synthetic */ i b(byte[] bArr) {
        return a(bArr);
    }

    public final f c(int i) {
        z e = e(2);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        e.c = i3 + 1;
        this.b += 2;
        return this;
    }

    public final /* synthetic */ i c(byte[] bArr, int i, int i2) {
        return b(bArr, i, i2);
    }

    public final k c(long j) {
        return new k(e(j));
    }

    public final OutputStream c() {
        return new g(this);
    }

    public final /* synthetic */ Object clone() {
        return t();
    }

    public final void close() {
    }

    public final f d(int i) {
        z e = e(4);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        e.c = i3 + 1;
        this.b += 4;
        return this;
    }

    public final i d() {
        return this;
    }

    final String d(long j) {
        if (j <= 0 || b(j - 1) != (byte) 13) {
            String k = k(j);
            f(1);
            return k;
        }
        k = k(j - 1);
        f(2);
        return k;
    }

    final z e(int i) {
        if (i <= 0 || i > ItemAnimator.FLAG_MOVED) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            this.a = aa.a();
            z zVar = this.a;
            z zVar2 = this.a;
            r0 = this.a;
            zVar2.g = r0;
            zVar.f = r0;
            return r0;
        } else {
            r0 = this.a.g;
            return (r0.c + i > ItemAnimator.FLAG_MOVED || !r0.e) ? r0.a(aa.a()) : r0;
        }
    }

    public final boolean e() {
        return this.b == 0;
    }

    public final byte[] e(long j) {
        af.a(this.b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        c(bArr);
        return bArr;
    }

    public final boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.b != fVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        z zVar = this.a;
        z zVar2 = fVar.a;
        int i = zVar.b;
        int i2 = zVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(zVar.c - i, zVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                if (zVar.a[i] != zVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2++;
                i++;
            }
            if (i == zVar.c) {
                zVar = zVar.f;
                i = zVar.b;
            }
            if (i2 == zVar2.c) {
                zVar2 = zVar2.f;
                i2 = zVar2.b;
            }
            j += min;
        }
        return true;
    }

    public final /* synthetic */ i f(int i) {
        return d(i);
    }

    public final InputStream f() {
        return new h(this);
    }

    public final void f(long j) {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            this.b -= (long) min;
            j -= (long) min;
            z zVar = this.a;
            zVar.b = min + zVar.b;
            if (this.a.b == this.a.c) {
                z zVar2 = this.a;
                this.a = zVar2.a();
                aa.a(zVar2);
            }
        }
    }

    public final void flush() {
    }

    public final byte g() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        z zVar = this.a;
        int i = zVar.b;
        int i2 = zVar.c;
        int i3 = i + 1;
        byte b = zVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = zVar.a();
            aa.a(zVar);
        } else {
            zVar.b = i3;
        }
        return b;
    }

    public final f g(long j) {
        if (j == 0) {
            return b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        z e = e(i);
        byte[] bArr = e.a;
        int i2 = e.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.c += i;
        this.b = ((long) i) + this.b;
        return this;
    }

    public final /* synthetic */ i g(int i) {
        return c(i);
    }

    public final f h(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        z e = e(numberOfTrailingZeros);
        byte[] bArr = e.a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b = ((long) numberOfTrailingZeros) + this.b;
        return this;
    }

    public final /* synthetic */ i h(int i) {
        return b(i);
    }

    public final short h() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        z zVar = this.a;
        int i = zVar.b;
        int i2 = zVar.c;
        if (i2 - i < 2) {
            return (short) (((g() & 255) << 8) | (g() & 255));
        }
        byte[] bArr = zVar.a;
        int i3 = i + 1;
        byte b = bArr[i];
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        this.b -= 2;
        if (i4 == i2) {
            this.a = zVar.a();
            aa.a(zVar);
        } else {
            zVar.b = i4;
        }
        return (short) (((b & 255) << 8) | (b2 & 255));
    }

    public final int hashCode() {
        z zVar = this.a;
        if (zVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = zVar.b;
            int i3 = zVar.c;
            while (i2 < i3) {
                byte b = zVar.a[i2];
                i2++;
                i = (i * 31) + b;
            }
            zVar = zVar.f;
        } while (zVar != this.a);
        return i;
    }

    public final int i() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        z zVar = this.a;
        int i = zVar.b;
        int i2 = zVar.c;
        if (i2 - i < 4) {
            return ((((g() & 255) << 24) | ((g() & 255) << 16)) | ((g() & 255) << 8)) | (g() & 255);
        }
        byte[] bArr = zVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        i = ((((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16)) | ((bArr[i4] & 255) << 8)) | (bArr[i5] & 255);
        this.b -= 4;
        if (i6 == i2) {
            this.a = zVar.a();
            aa.a(zVar);
            return i;
        }
        zVar.b = i6;
        return i;
    }

    public final /* synthetic */ i i(long j) {
        return h(j);
    }

    public final /* synthetic */ i j(long j) {
        return g(j);
    }

    public final short j() {
        return af.a(h());
    }

    public final ad j_() {
        return ad.b;
    }

    public final int k() {
        return af.a(i());
    }

    public final long l() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        long j2 = -7;
        do {
            z zVar = this.a;
            byte[] bArr = zVar.a;
            int i2 = zVar.b;
            int i3 = zVar.c;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    int i4 = 48 - b;
                    if (j < -922337203685477580L || (j == -922337203685477580L && ((long) i4) < j2)) {
                        f b2 = new f().g(j).b((int) b);
                        if (obj == null) {
                            b2.g();
                        }
                        throw new NumberFormatException("Number too large: " + b2.o());
                    }
                    j = (j * 10) + ((long) i4);
                } else if (b != (byte) 45 || i != 0) {
                    if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            this.a = zVar.a();
                            aa.a(zVar);
                        } else {
                            zVar.b = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    obj = 1;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
                zVar.b = i2;
            } else {
                this.a = zVar.a();
                aa.a(zVar);
            }
            if (obj2 == null) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i;
        return obj != null ? j : -j;
    }

    public final long m() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        Object obj = null;
        int i = 0;
        long j = 0;
        do {
            z zVar = this.a;
            byte[] bArr = zVar.a;
            int i2 = zVar.b;
            int i3 = zVar.c;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.a = zVar.a();
                            aa.a(zVar);
                        } else {
                            zVar.b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new f().h(j).b((int) b).o());
                }
                long j2 = (long) i2;
                j = (j << 4) | j2;
                i4++;
                i++;
            }
            if (i4 != i3) {
                zVar.b = i4;
            } else {
                this.a = zVar.a();
                aa.a(zVar);
            }
            if (obj == null) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i;
        return j;
    }

    public final k n() {
        return new k(q());
    }

    public final String o() {
        try {
            return a(this.b, af.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String p() {
        long a = a((byte) 10, 0);
        if (a != -1) {
            return d(a);
        }
        f fVar = new f();
        a(fVar, 0, Math.min(32, this.b));
        throw new EOFException("\\n not found: size=" + this.b + " content=" + fVar.n().b() + "...");
    }

    public final byte[] q() {
        try {
            return e(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void r() {
        try {
            f(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ i s() {
        return this;
    }

    public final String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            k n = t().n();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.b), n.b()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.a.a, this.a.b, this.a.c - this.a.b);
            for (z zVar = this.a.f; zVar != this.a; zVar = zVar.f) {
                instance.update(zVar.a, zVar.b, zVar.c - zVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.b), k.a(instance.digest()).b()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
