package com.farsitel.bazaar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import com.farsitel.bazaar.g;

public class BazaarAutoCompleteEditText extends AutoCompleteTextView {
    private a a;

    public BazaarAutoCompleteEditText(Context context) {
        super(context);
        setDropDownBackgroundResource(g.dropdown_background);
    }

    public BazaarAutoCompleteEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDropDownBackgroundResource(g.dropdown_background);
    }

    public BazaarAutoCompleteEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setDropDownBackgroundResource(g.dropdown_background);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setKeyboardListener(a aVar) {
        this.a = aVar;
    }
}
