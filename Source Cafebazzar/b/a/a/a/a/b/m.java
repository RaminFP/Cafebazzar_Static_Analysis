package b.a.a.a.a.b;

import java.io.File;
import java.util.Comparator;

final class m implements Comparator {
    m() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((File) obj).lastModified() - ((File) obj2).lastModified());
    }
}
