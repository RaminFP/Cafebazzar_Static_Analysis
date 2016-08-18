package com.farsitel.bazaar.activity;

import android.support.v4.view.bj;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.ab;

final class cl extends bj {
    final /* synthetic */ ScreenshotActivity a;

    public cl(ScreenshotActivity screenshotActivity) {
        this.a = screenshotActivity;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.a.d.length;
    }

    public final /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a).inflate(2130903170, null);
        View findViewById = relativeLayout.findViewById(2131624179);
        ImageView imageView = (ImageView) relativeLayout.findViewById(2131624417);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(2131624416);
        ab.a().a(this.a.e[i], imageView);
        ab.a().a(j.a().l() + this.a.d[i], imageView2, new cm(this, findViewById, imageView));
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
