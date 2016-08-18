package b.a.a.a.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ab implements Closeable {
    private static final Logger b = Logger.getLogger(ab.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private ad e;
    private ad f;
    private final byte[] g = new byte[16];

    public ab(File file) {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile a = a(file2);
            try {
                a.setLength(4096);
                a.seek(0);
                byte[] bArr = new byte[16];
                a(bArr, 4096, 0, 0, 0);
                a.write(bArr);
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } finally {
                a.close();
            }
        }
        this.c = a(file);
        this.c.seek(0);
        this.c.readFully(this.g);
        this.a = a(this.g, 0);
        if (((long) this.a) > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
        }
        this.d = a(this.g, 4);
        int a2 = a(this.g, 8);
        int a3 = a(this.g, 12);
        this.e = a(a2);
        this.f = a(a3);
    }

    private static int a(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private ad a(int i) {
        if (i == 0) {
            return ad.a;
        }
        this.c.seek((long) i);
        return new ad(i, this.c.readInt());
    }

    private static RandomAccessFile a(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private void a(int i, int i2, int i3, int i4) {
        a(this.g, i, i2, i3, i4);
        this.c.seek(0);
        this.c.write(this.g);
    }

    private void a(int i, byte[] bArr, int i2, int i3) {
        int b = b(i);
        if (b + i3 <= this.a) {
            this.c.seek((long) b);
            this.c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.a - b;
        this.c.seek((long) b);
        this.c.write(bArr, i2, i4);
        this.c.seek(16);
        this.c.write(bArr, i2 + i4, i3 - i4);
    }

    static /* synthetic */ void a(ab abVar, int i, byte[] bArr, int i2, int i3) {
        int b = abVar.b(i);
        if (b + i3 <= abVar.a) {
            abVar.c.seek((long) b);
            abVar.c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = abVar.a - b;
        abVar.c.seek((long) b);
        abVar.c.readFully(bArr, i2, i4);
        abVar.c.seek(16);
        abVar.c.readFully(bArr, i2 + i4, i3 - i4);
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            b(bArr, i, iArr[i2]);
            i += 4;
        }
    }

    private int b(int i) {
        return i < this.a ? i : (i + 16) - this.a;
    }

    private static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    private static void b(byte[] bArr, int i, int i2) {
        bArr[i] = i2 >> 24;
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private void c(int i) {
        int i2 = i + 4;
        int a = this.a - a();
        if (a < i2) {
            int i3 = this.a;
            do {
                a += i3;
                i3 <<= 1;
            } while (a < i2);
            this.c.setLength((long) i3);
            this.c.getChannel().force(true);
            i2 = b((this.f.b + 4) + this.f.c);
            if (i2 < this.e.b) {
                FileChannel channel = this.c.getChannel();
                channel.position((long) this.a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f.b < this.e.b) {
                a = (this.a + this.f.b) - 16;
                a(i3, this.d, this.e.b, a);
                this.f = new ad(a, this.f.c);
            } else {
                a(i3, this.d, this.e.b, this.f.b);
            }
            this.a = i3;
        }
    }

    public final int a() {
        return this.d == 0 ? 16 : this.f.b >= this.e.b ? (((this.f.b - this.e.b) + 4) + this.f.c) + 16 : (((this.f.b + 4) + this.f.c) + this.a) - this.e.b;
    }

    public final void a(af afVar) {
        synchronized (this) {
            int i = this.e.b;
            for (int i2 = 0; i2 < this.d; i2++) {
                ad a = a(i);
                afVar.a(new ae(this, a, (byte) 0), a.c);
                i = b(a.c + (a.b + 4));
            }
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        synchronized (this) {
            b(bArr, "buffer");
            if ((i2 | 0) < 0 || i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            c(i2);
            boolean b = b();
            ad adVar = new ad(b ? 16 : b((this.f.b + 4) + this.f.c), i2);
            b(this.g, 0, i2);
            a(adVar.b, this.g, 0, 4);
            a(adVar.b + 4, bArr, 0, i2);
            a(this.a, this.d + 1, b ? adVar.b : this.e.b, adVar.b);
            this.f = adVar;
            this.d++;
            if (b) {
                this.e = this.f;
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.d == 0;
        }
        return z;
    }

    public void close() {
        synchronized (this) {
            this.c.close();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.a);
        stringBuilder.append(", size=").append(this.d);
        stringBuilder.append(", first=").append(this.e);
        stringBuilder.append(", last=").append(this.f);
        stringBuilder.append(", element lengths=[");
        try {
            a(new ac(this, stringBuilder));
        } catch (Throwable e) {
            b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
