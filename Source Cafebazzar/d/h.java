package d;

import java.io.InputStream;

final class h extends InputStream {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public final int available() {
        return (int) Math.min(this.a.b, 2147483647L);
    }

    public final void close() {
    }

    public final int read() {
        return this.a.b > 0 ? this.a.g() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        return this.a.a(bArr, i, i2);
    }

    public final String toString() {
        return this.a + ".inputStream()";
    }
}
