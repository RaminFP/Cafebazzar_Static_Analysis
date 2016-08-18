package b.a.a.a.a.e;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public final class l extends BufferedOutputStream {
    private final CharsetEncoder a;

    public l(OutputStream outputStream, String str, int i) {
        super(outputStream, i);
        this.a = Charset.forName(e.c(str)).newEncoder();
    }

    public final l a(String str) {
        ByteBuffer encode = this.a.encode(CharBuffer.wrap(str));
        super.write(encode.array(), 0, encode.limit());
        return this;
    }
}
