package d;

import java.io.IOException;
import java.io.InputStream;

final class y extends InputStream {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    public final int available() {
        if (!this.a.c) {
            return (int) Math.min(this.a.a.b, 2147483647L);
        }
        throw new IOException("closed");
    }

    public final void close() {
        this.a.close();
    }

    public final int read() {
        if (!this.a.c) {
            return (this.a.a.b == 0 && this.a.b.a(this.a.a, 2048) == -1) ? -1 : this.a.a.g() & 255;
        } else {
            throw new IOException("closed");
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.a.c) {
            throw new IOException("closed");
        }
        af.a((long) bArr.length, (long) i, (long) i2);
        return (this.a.a.b == 0 && this.a.b.a(this.a.a, 2048) == -1) ? -1 : this.a.a.a(bArr, i, i2);
    }

    public final String toString() {
        return this.a + ".inputStream()";
    }
}
