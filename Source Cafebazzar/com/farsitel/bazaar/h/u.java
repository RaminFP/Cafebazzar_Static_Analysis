package com.farsitel.bazaar.h;

import com.congenialmobile.util.d;
import com.farsitel.bazaar.f.k;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    final k a;
    final String b;
    final String c;
    private final Object[] d;

    public u(k kVar, Object[] objArr, String str) {
        this.a = kVar;
        this.d = objArr;
        this.b = str;
        this.c = a(kVar.b, objArr);
    }

    private static String a(String str, Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"7cc78271-e338-4edc-849c-b105c5d51ba5\":[\"").append(str).append("\"");
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] == null) {
                stringBuffer.append(",null");
            } else if ((objArr[i] instanceof Integer) || (objArr[i] instanceof Double) || (objArr[i] instanceof Long) || (objArr[i] instanceof Boolean)) {
                stringBuffer.append(",").append(objArr[i]);
            } else {
                stringBuffer.append(",\"");
                for (char c : objArr[i].toString().toCharArray()) {
                    if (c < '') {
                        stringBuffer.append(c);
                    } else {
                        stringBuffer.append("\\u").append(String.format(Locale.US, "%04x", new Object[]{Integer.valueOf(c)}));
                    }
                }
                stringBuffer.append("\"");
            }
            i++;
        }
        stringBuffer.append("]}");
        return d.a(stringBuffer.toString().getBytes());
    }

    public final int a() {
        return this.a.a;
    }

    public final JSONObject b() {
        JSONArray jSONArray = new JSONArray();
        for (Object put : this.d) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", 1);
            jSONObject.put("method", this.a.b);
            jSONObject.put("params", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
