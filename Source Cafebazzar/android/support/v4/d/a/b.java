package android.support.v4.d.a;

import android.support.v4.view.ax;
import android.support.v4.view.n;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(ax axVar);

    b a(n nVar);

    n a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
