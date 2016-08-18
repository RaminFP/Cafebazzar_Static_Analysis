package b.a.a.a.a.b;

import java.io.InputStream;

final class ac implements af {
    boolean a = true;
    final /* synthetic */ StringBuilder b;
    final /* synthetic */ ab c;

    ac(ab abVar, StringBuilder stringBuilder) {
        this.c = abVar;
        this.b = stringBuilder;
    }

    public final void a(InputStream inputStream, int i) {
        if (this.a) {
            this.a = false;
        } else {
            this.b.append(", ");
        }
        this.b.append(i);
    }
}
