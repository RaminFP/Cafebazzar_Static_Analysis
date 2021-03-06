package com.google.android.gms.a;

import android.support.v4.app.NotificationCompat;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class dd {
    private final ByteBuffer a;

    private dd(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private dd(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int a(int i) {
        return i >= 0 ? d(i) : 10;
    }

    private static int a(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i2 = i + i3;
                if (i2 < length) {
                    return i2;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
            }
        }
        i2 = i3;
        if (i2 < length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('?' > charAt2 || charAt2 > '?' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static int a(String str) {
        int a = a((CharSequence) str);
        return a + d(a);
    }

    public static dd a(byte[] bArr) {
        return new dd(bArr, 0, bArr.length);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            b(charSequence, byteBuffer);
        }
    }

    public static int b(int i) {
        return d(do.a(i, 0));
    }

    public static int b(int i, int i2) {
        return b(i) + a(i2);
    }

    public static int b(int i, long j) {
        return b(i) + b(j);
    }

    public static int b(int i, dl dlVar) {
        int b = b(i);
        int d = dlVar.d();
        return b + (d + d(d));
    }

    public static int b(int i, String str) {
        return b(i) + a(str);
    }

    public static int b(int i, byte[] bArr) {
        return b(i) + b(bArr);
    }

    public static int b(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static int b(byte[] bArr) {
        return d(bArr.length) + bArr.length;
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                byteBuffer.put((byte) ((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) ((toCodePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static long c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    private void e(int i) {
        byte b = (byte) i;
        if (this.a.hasRemaining()) {
            this.a.put(b);
            return;
        }
        throw new de(this.a.position(), this.a.limit());
    }

    public final void a() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void a(int i, float f) {
        c(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.a.remaining() < 4) {
            throw new de(this.a.position(), this.a.limit());
        }
        this.a.putInt(floatToIntBits);
    }

    public final void a(int i, int i2) {
        c(i, 0);
        if (i2 >= 0) {
            c(i2);
        } else {
            a((long) i2);
        }
    }

    public final void a(int i, long j) {
        c(i, 0);
        a(j);
    }

    public final void a(int i, dl dlVar) {
        c(i, 2);
        a(dlVar);
    }

    public final void a(int i, String str) {
        c(i, 2);
        try {
            int d = d(str.length());
            if (d == d(str.length() * 3)) {
                int position = this.a.position();
                if (this.a.remaining() < d) {
                    throw new de(d + position, this.a.limit());
                }
                this.a.position(position + d);
                a((CharSequence) str, this.a);
                int position2 = this.a.position();
                this.a.position(position);
                c((position2 - position) - d);
                this.a.position(position2);
                return;
            }
            c(a((CharSequence) str));
            a((CharSequence) str, this.a);
        } catch (Throwable e) {
            de deVar = new de(this.a.position(), this.a.limit());
            deVar.initCause(e);
            throw deVar;
        }
    }

    public final void a(int i, boolean z) {
        int i2 = 0;
        c(i, 0);
        if (z) {
            i2 = 1;
        }
        e(i2);
    }

    public final void a(int i, byte[] bArr) {
        c(i, 2);
        c(bArr.length);
        c(bArr);
    }

    public final void a(long j) {
        while ((-128 & j) != 0) {
            e((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        e((int) j);
    }

    public final void a(dl dlVar) {
        c(dlVar.c());
        dlVar.a(this);
    }

    public final void c(int i) {
        while ((i & -128) != 0) {
            e((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        e(i);
    }

    public final void c(int i, int i2) {
        c(do.a(i, i2));
    }

    public final void c(byte[] bArr) {
        int length = bArr.length;
        if (this.a.remaining() >= length) {
            this.a.put(bArr, 0, length);
            return;
        }
        throw new de(this.a.position(), this.a.limit());
    }
}
