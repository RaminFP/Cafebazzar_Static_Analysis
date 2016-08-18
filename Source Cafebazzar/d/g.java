package d;

import java.io.OutputStream;

final class g extends OutputStream {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final String toString() {
        return this + ".outputStream()";
    }

    public final void write(int i) {
        this.a.b((byte) i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.a.b(bArr, i, i2);
    }
}
