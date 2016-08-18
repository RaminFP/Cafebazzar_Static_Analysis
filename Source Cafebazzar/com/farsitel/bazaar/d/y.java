package com.farsitel.bazaar.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.widget.BazaarTitleBar;
import com.farsitel.bazaar.widget.m;
import java.lang.reflect.Field;

public abstract class y extends DialogFragment {
    private BroadcastReceiver a;
    protected long g;
    public BazaarTitleBar h;
    public boolean i = true;

    private void a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
        } else if ((view instanceof ImageView) && view.getTag(2131165843) != null) {
            ((ImageView) view).setImageDrawable(null);
        }
    }

    private void b(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            while (i < viewGroup.getChildCount()) {
                b(viewGroup.getChildAt(i));
                i++;
            }
        } else if ((view instanceof ImageView) && view.getTag(2131165843) != null) {
            ImageView imageView = (ImageView) view;
            if (view.getTag(2131165842) == null) {
                ab.a().a(view.getTag(2131165843).toString(), imageView, false, null);
                return;
            }
            int i2;
            int i3;
            int intValue = ((Integer) view.getTag(2131165842)).intValue();
            if (view.getTag(2131165844) == null || view.getTag(2131165841) == null) {
                i2 = 0;
                i3 = 0;
            } else {
                i3 = ((Integer) view.getTag(2131165844)).intValue();
                i2 = ((Integer) view.getTag(2131165841)).intValue();
            }
            ab.a().a(view.getTag(2131165843).toString(), imageView, false, g.icon_not_loaded, intValue, i3, i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        if (this.h != null) {
            BazaarTitleBar bazaarTitleBar = this.h;
            bazaarTitleBar.h.setImageResource(i);
            bazaarTitleBar.h.setOnClickListener(onClickListener);
            bazaarTitleBar.h.setVisibility(0);
        }
    }

    public final void a(String str) {
        if (this.h != null) {
            this.h.setTitle(str);
            if (getDialog() != null) {
                BazaarTitleBar bazaarTitleBar = this.h;
                Dialog dialog = getDialog();
                bazaarTitleBar.i.setVisibility(0);
                bazaarTitleBar.i.setImageDrawable(bazaarTitleBar.getResources().getDrawable(g.ic_action_close));
                bazaarTitleBar.i.setOnClickListener(new m(bazaarTitleBar, dialog));
            } else {
                this.h.c();
            }
            this.h.a();
        }
    }

    public final void b(boolean z) {
        if (!o.e() && !z) {
            b(getView());
        }
    }

    public void f() {
    }

    public final void h() {
        if (this.h != null) {
            this.h.b();
        }
    }

    public final void i() {
        if (this.h != null) {
            this.h.setVisibility(8);
        } else {
            this.i = false;
        }
    }

    public final void j() {
        if (this.h != null) {
            this.h.h.setVisibility(8);
        }
    }

    public final void k() {
        if (this.h != null) {
            BazaarTitleBar bazaarTitleBar = this.h;
            bazaarTitleBar.e.setVisibility(0);
            bazaarTitleBar.f.setVisibility(8);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        return onCreateDialog;
    }

    public void onDetach() {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.a != null) {
            getActivity().unregisterReceiver(this.a);
        }
    }

    public void onResume() {
        int i = -1;
        super.onResume();
        this.a = new z(this);
        getActivity().registerReceiver(this.a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (getDialog() != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int dimension = (int) getResources().getDimension(2131361822);
            int dimension2 = (int) getResources().getDimension(2131361821);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i2 <= dimension || i3 <= dimension2) {
                dimension = -1;
            } else {
                i = dimension2;
            }
            getDialog().getWindow().setLayout(dimension, i);
            getDialog().getWindow().setBackgroundDrawableResource(g.background_light_drawable);
        }
        System.gc();
    }

    public void onStart() {
        super.onStart();
        this.g = System.currentTimeMillis();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.h = (BazaarTitleBar) view.findViewById(2131624037);
        if (!this.i) {
            this.h.setVisibility(8);
        }
    }
}
