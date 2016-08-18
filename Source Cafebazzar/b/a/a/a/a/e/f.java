package b.a.a.a.a.e;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

final class f extends g {
    final /* synthetic */ InputStream a;
    final /* synthetic */ OutputStream b;
    final /* synthetic */ e c;

    f(e eVar, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
        this.c = eVar;
        this.a = inputStream;
        this.b = outputStream;
        super(closeable, z);
    }

    public final /* synthetic */ Object a() {
        byte[] bArr = new byte[this.c.j];
        while (true) {
            int read = this.a.read(bArr);
            if (read == -1) {
                return this.c;
            }
            this.b.write(bArr, 0, read);
        }
    }
}
