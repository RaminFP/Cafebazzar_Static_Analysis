package android.support.v4.view;

import android.view.LayoutInflater;

class ag implements af {
    ag() {
    }

    public void a(LayoutInflater layoutInflater, an anVar) {
        layoutInflater.setFactory(anVar != null ? new ak(anVar) : null);
    }
}
