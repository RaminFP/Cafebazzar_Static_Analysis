package d;

import java.io.IOException;
import java.io.OutputStream;

final class w extends OutputStream {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void close() {
        this.a.close();
    }

    public final void flush() {
        if (!this.a.c) {
            this.a.flush();
        }
    }

    public final String toString() {
        return this.a + ".outputStream()";
    }

    public final void write(int i) {
        if (this.a.c) {
            throw new IOException("closed");
        }
        this.a.a.b((byte) i);
        this.a.s();
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (this.a.c) {
            throw new IOException("closed");
        }
        this.a.a.b(bArr, i, i2);
        this.a.s();
    }
}
