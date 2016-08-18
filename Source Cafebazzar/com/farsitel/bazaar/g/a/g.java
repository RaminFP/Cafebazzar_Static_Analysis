package com.farsitel.bazaar.g.a;

import android.content.Context;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.VideoPlayerActivity;
import java.util.Arrays;
import org.json.JSONObject;

public final class g extends f {
    final char a;
    final String d;
    final boolean e;

    public g(JSONObject jSONObject) {
        boolean z = false;
        super(jSONObject.getString("vsp"));
        this.a = jSONObject.getString("vst").charAt(0);
        this.d = jSONObject.getString("vs");
        if (Arrays.binarySearch(VideoPlayerActivity.a, this.a) >= 0) {
            z = true;
        }
        this.e = z;
    }

    public final int a() {
        return com.farsitel.bazaar.g.ic_av_play_circle_outline;
    }

    public final OnClickListener a(Context context) {
        return new h(this, context);
    }
}
