package b.a.a.a.a.b;

import b.a.a.a.a.e.e;
import b.a.a.a.a.e.m;
import b.a.a.a.p;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class a {
    private static final Pattern c = Pattern.compile("http(s?)://[^\\/]+", 2);
    public final String a;
    public final p b;
    private final m d;
    private final int e;
    private final String f;

    public a(p pVar, String str, String str2, m mVar, int i) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (mVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.b = pVar;
            this.f = str;
            if (!l.c(this.f)) {
                str2 = c.matcher(str2).replaceFirst(this.f);
            }
            this.a = str2;
            this.d = mVar;
            this.e = i;
        }
    }

    public final e a() {
        return a(Collections.emptyMap());
    }

    public final e a(Map map) {
        e a = this.d.a(this.e, this.a, map);
        a.a().setUseCaches(false);
        a.a().setConnectTimeout(10000);
        return a.a("User-Agent", "Crashlytics Android SDK/" + this.b.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }
}
