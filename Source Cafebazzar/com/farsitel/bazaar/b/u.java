package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.farsitel.bazaar.util.aj;
import org.json.JSONArray;

public final class u extends m {
    public RadioGroup a;

    public u(Activity activity, JSONArray jSONArray, long j) {
        super(activity, activity.getString(2131165488), false);
        a(new v(this));
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130903154, null);
        this.a = (RadioGroup) inflate.findViewById(2131624378);
        Object obj = null;
        int i = 0;
        while (i < jSONArray.length()) {
            Object obj2;
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            long j2 = jSONArray2.getLong(0);
            CharSequence string = jSONArray2.getString(1);
            if (j2 >= j) {
                RadioButton radioButton = (RadioButton) layoutInflater.inflate(2130903153, null);
                radioButton.setText(string);
                radioButton.setTag(Long.valueOf(j2));
                this.a.addView(radioButton);
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            long ceil = (long) (Math.ceil(((double) j) / 1000000.0d) * 1000000.0d);
            RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(2130903153, null);
            radioButton2.setText(aj.a(ceil));
            radioButton2.setTag(Long.valueOf(ceil));
            this.a.addView(radioButton2);
        }
        this.a.setOnCheckedChangeListener(new w(this));
        a(inflate);
        a(2131165317, new x(this));
        c(2131165323, new y(this));
        a(false);
    }
}
