package com.farsitel.bazaar.d;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;

public final class ai extends Fragment {
    private static String c = "child_fragment_tag";
    public int a;
    public long b = 0;

    public static ai a(int i) {
        ai aiVar = new ai();
        Bundle bundle = new Bundle();
        bundle.putInt(c, i);
        aiVar.setArguments(bundle);
        return aiVar;
    }

    public final void a() {
        while (getChildFragmentManager().getBackStackEntryCount() > 1) {
            getChildFragmentManager().popBackStackImmediate();
        }
        if (getChildFragmentManager().getFragments() != null) {
            Fragment fragment = (Fragment) getChildFragmentManager().getFragments().get(0);
            if (fragment instanceof y) {
                ((y) fragment).b(false);
            }
        }
        System.gc();
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getChildFragmentManager() != null && getChildFragmentManager().getBackStackEntryCount() > 0) {
            Fragment fragment = (Fragment) getChildFragmentManager().getFragments().get(getChildFragmentManager().getFragments().size() - 1);
            if (fragment != null) {
                fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903114, viewGroup, false);
        this.a = getArguments().getInt(c);
        return inflate;
    }

    public final void onDetach() {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
