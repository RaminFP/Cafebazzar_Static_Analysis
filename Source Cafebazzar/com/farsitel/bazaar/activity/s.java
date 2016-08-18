package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.i;
import com.google.a.a.a.p;

public class s extends Activity {
    private int a = -1;
    private int b = -1;

    public void finish() {
        super.finish();
        if (this.a != -1 && this.b != -1) {
            overridePendingTransition(this.a, this.b);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("bazaar_activity_start_enter_anim") && extras.containsKey("bazaar_activity_start_exit_anim")) {
            overridePendingTransition(extras.getInt("bazaar_activity_start_enter_anim"), extras.getInt("bazaar_activity_start_exit_anim"));
        }
        if (extras != null && extras.containsKey("bazaar_activity_finish_enter_anim") && extras.containsKey("bazaar_activity_finish_exit_anim")) {
            this.a = extras.getInt("bazaar_activity_finish_enter_anim");
            this.b = extras.getInt("bazaar_activity_finish_exit_anim");
        }
        if (VERSION.SDK_INT >= 21) {
            setTaskDescription(new TaskDescription("", BitmapFactory.decodeResource(getResources(), g.logo_normal_square), getResources().getColor(2131558472)));
        }
    }

    protected void onStart() {
        super.onStart();
        p.a((Context) this).a((Activity) this);
        i.a((Context) this);
    }

    public void onStop() {
        super.onStop();
        p.a((Context) this).a();
        i.b((Context) this);
    }
}
