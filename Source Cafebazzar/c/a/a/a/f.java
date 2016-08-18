package c.a.a.a;

import android.content.ContentValues;
import android.net.Uri;
import c.a.a.a;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class f extends b {
    public final List a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }

    protected final void a(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("tag", c() + "/" + b());
            contentValues.put("count", Integer.valueOf(i));
            this.a.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
        } catch (IllegalArgumentException e) {
        } catch (Exception e2) {
            throw new a(e2.getMessage());
        }
    }
}
