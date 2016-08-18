package com.farsitel.bazaar.b;

import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;

final class ac extends v {
    final /* synthetic */ ab a;

    ac(ab abVar) {
        this.a = abVar;
    }

    public final void a(c cVar) {
        this.a.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        Integer num = (Integer) obj;
        Map hashMap = new HashMap();
        if (num.equals(Integer.valueOf(1))) {
            Editor edit = this.a.b.edit();
            edit.putString("user_nickname", this.a.d.getText().toString());
            edit.commit();
            this.a.b();
        } else if (num.equals(Integer.valueOf(2))) {
            Toast.makeText(ab.a, 2131165630, 1).show();
            this.a.b();
        } else if (num.equals(Integer.valueOf(-1))) {
            j.a().s().a(null).d(null).c(null).a(-1);
            hashMap.put("general", ab.a.getString(2131165751));
            this.a.a(600, hashMap);
        } else {
            if (num.equals(Integer.valueOf(-2))) {
                hashMap.put("general", ab.a.getString(2131165462));
            }
            if (num.equals(Integer.valueOf(-3))) {
                hashMap.put("general", ab.a.getString(2131165461));
            }
            this.a.a(700, hashMap);
        }
    }
}
