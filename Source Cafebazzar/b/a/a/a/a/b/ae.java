package b.a.a.a.a.b;

import java.io.InputStream;

final class ae extends InputStream {
    final /* synthetic */ ab a;
    private int b;
    private int c;

    private ae(ab abVar, ad adVar) {
        this.a = abVar;
        this.b = abVar.b(adVar.b + 4);
        this.c = adVar.c;
    }

    public final int read() {
        if (this.c == 0) {
            return -1;
        }
        this.a.c.seek((long) this.b);
        int read = this.a.c.read();
        this.b = this.a.b(this.b + 1);
        this.c--;
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        ab.b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (this.c <= 0) {
            return -1;
        } else {
            if (i2 > this.c) {
                i2 = this.c;
            }
            ab.a(this.a, this.b, bArr, i, i2);
            this.b = this.a.b(this.b + i2);
            this.c -= i2;
            return i2;
        }
    }
}
