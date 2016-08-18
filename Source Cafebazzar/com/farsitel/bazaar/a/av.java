package com.farsitel.bazaar.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.farsitel.bazaar.g.a.f;
import com.farsitel.bazaar.util.ab;
import java.util.LinkedList;
import java.util.Queue;

public final class av extends BaseAdapter {
    private Context a;
    private f[] b;
    private final int c;
    private final int d;
    private Queue e = new LinkedList();
    private ax f;

    public av(Context context, f[] fVarArr, int i) {
        this.a = context;
        this.b = fVarArr;
        this.d = 0;
        this.c = (int) context.getResources().getDimension(2131361929);
    }

    private void a(String str, ImageView imageView) {
        ab.a().a(str, imageView, true, new aw(this, imageView));
    }

    private void a(String str, ImageView imageView, int i) {
        imageView.setTag(2131165843, str);
        for (ax axVar : this.e) {
            if (axVar.c == i) {
                return;
            }
        }
        this.e.offer(new ax(this, str, imageView, i));
        if (this.f == null) {
            this.f = (ax) this.e.poll();
            a(this.f.a, this.f.b);
        }
    }

    public final int getCount() {
        return this.b.length;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.b[i];
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.a).inflate(2130903131, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(this.c, this.c, this.c, this.c);
        inflate.setLayoutParams(layoutParams);
        inflate.setOnClickListener(this.b[i].a(this.a));
        ImageView imageView = (ImageView) inflate.findViewById(2131624334);
        if ((this.b[i].a() != -1 ? 1 : 0) != 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(this.b[i].a());
        } else {
            imageView.setVisibility(8);
        }
        a(this.b[i].b, (ImageView) inflate.findViewById(2131624333), i);
        float f = (float) (this.d + i);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, 2130968596);
        loadAnimation.setStartOffset((long) (f * 100.0f));
        inflate.setAnimation(loadAnimation);
        return inflate;
    }
}
