package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class ah extends ag {
    ah() {
    }

    public void a(LayoutInflater layoutInflater, an anVar) {
        Factory2 amVar = anVar != null ? new am(anVar) : null;
        layoutInflater.setFactory2(amVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            al.a(layoutInflater, (Factory2) factory);
        } else {
            al.a(layoutInflater, amVar);
        }
    }
}
