package android.support.v7.internal.view.menu;

import android.content.Context;

public interface x {
    boolean collapseItemActionView(i iVar, m mVar);

    boolean expandItemActionView(i iVar, m mVar);

    boolean flagActionItems();

    void initForMenu(Context context, i iVar);

    void onCloseMenu(i iVar, boolean z);

    boolean onSubMenuSelected(ad adVar);

    void updateMenuView(boolean z);
}
