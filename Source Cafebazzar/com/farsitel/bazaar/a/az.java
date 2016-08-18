package com.farsitel.bazaar.a;

import android.app.ProgressDialog;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v7.a.g;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.h;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.w;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.aj;
import java.util.ArrayList;

public final class az extends BaseAdapter implements OnClickListener {
    private ArrayList a = new ArrayList();
    private LayoutInflater b;
    private Fragment c;
    private b d;
    private ProgressDialog e;

    public az(Fragment fragment, LayoutInflater layoutInflater, b bVar) {
        this.c = fragment;
        this.b = layoutInflater;
        this.d = bVar;
    }

    private static Drawable a(String str) {
        Drawable drawable = null;
        af afVar = af.INSTANCE;
        if (af.c(str)) {
            try {
                drawable = BazaarApplication.c().getPackageManager().getPackageInfo(str, 0).applicationInfo.loadIcon(BazaarApplication.c().getApplicationContext().getPackageManager());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return drawable;
    }

    public final void a() {
        this.d.a();
        d.INSTANCE.a(new bc(this), new w(), j.a().b, BazaarApplication.c().a.getLanguage());
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        h hVar = (h) this.a.get(i);
        if (view == null) {
            view = this.b.inflate(2130903135, null);
            bf bfVar = new bf();
            bfVar.a = (TextView) view.findViewById(g.title);
            bfVar.b = (TextView) view.findViewById(2131624338);
            bfVar.d = (TextView) view.findViewById(2131624339);
            bfVar.c = (ImageView) view.findViewById(2131624270);
            bfVar.e = (ImageView) view.findViewById(2131624320);
            view.setTag(bfVar);
        }
        bf bfVar2 = (bf) view.getTag();
        bfVar2.a.setText(hVar.c);
        bfVar2.b.setText(hVar.b);
        bfVar2.d.setText(hVar.i ? aj.a((long) hVar.d, hVar.e) : hVar.h);
        if (hVar.i) {
            if (VERSION.SDK_INT > 11) {
                view.setAlpha(1.0f);
            }
            bfVar2.e.setEnabled(true);
            bfVar2.e.setVisibility(0);
            bfVar2.e.setTag(Integer.valueOf(i));
            bfVar2.e.setOnClickListener(this);
        } else {
            if (VERSION.SDK_INT > 11) {
                view.setAlpha(0.4f);
            }
            bfVar2.e.setEnabled(false);
            bfVar2.e.setVisibility(4);
        }
        if (a(hVar.a) != null) {
            bfVar2.c.setImageDrawable(a(hVar.a));
        } else {
            ab.a().a(new com.farsitel.bazaar.g.a.j(hVar.a).j(), bfVar2.c);
        }
        return view;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        h hVar = (h) this.a.get(intValue);
        PopupMenu popupMenu = new PopupMenu(this.c.getActivity(), view);
        popupMenu.inflate(2131689474);
        popupMenu.getMenu().findItem(2131624437).setVisible(hVar.j);
        popupMenu.setOnMenuItemClickListener(new ba(this, hVar, intValue));
        popupMenu.show();
    }
}
