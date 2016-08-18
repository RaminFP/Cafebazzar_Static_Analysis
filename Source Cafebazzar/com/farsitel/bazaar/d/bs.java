package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.o;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ar;
import com.farsitel.bazaar.util.as;

public final class bs extends y {
    private static final BazaarApplication a = BazaarApplication.c();
    private EditText b;
    private Spinner c;
    private String d;
    private AutoCompleteTextView e;
    private TextView f;
    private TextView j;
    private final int k = 20;
    private final int l = 1000;

    public static bs a() {
        return new bs();
    }

    static /* synthetic */ Object[] f(bs bsVar) {
        r0 = new Object[5];
        r0[2] = bsVar.getString(2131165387, bsVar.d);
        r0[3] = bsVar.b.getText().toString();
        r0[4] = Character.valueOf(bsVar.getResources().getStringArray(2131230734)[bsVar.c.getSelectedItemPosition()].charAt(0));
        return r0;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903084, viewGroup, false);
        this.f = (TextView) inflate.findViewById(2131624198);
        this.e = (AutoCompleteTextView) inflate.findViewById(2131624196);
        this.b = (EditText) inflate.findViewById(2131624199);
        String[] stringArray = getResources().getStringArray(2131230721);
        this.c = (Spinner) inflate.findViewById(2131624197);
        ArrayAdapter btVar = new bt(this, getActivity(), 2130903180, 16908308);
        btVar.setDropDownViewResource(2130903179);
        for (Object add : stringArray) {
            btVar.add(add);
        }
        btVar.add(getString(2131165683));
        this.c.setAdapter(btVar);
        this.c.setSelection(btVar.getCount());
        this.j = (TextView) inflate.findViewById(2131624194);
        this.j.setText(2131165682);
        TextView textView = this.j;
        Spanned spanned = (Spanned) this.j.getText();
        ar asVar = new as();
        CharSequence spannableString = new SpannableString(spanned);
        for (CharacterStyle characterStyle : (CharacterStyle[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            int spanStart = spannableString.getSpanStart(characterStyle);
            int spanEnd = spannableString.getSpanEnd(characterStyle);
            int spanFlags = spannableString.getSpanFlags(characterStyle);
            spannableString.removeSpan(characterStyle);
            spannableString.setSpan(asVar.a(characterStyle), spanStart, spanEnd, spanFlags);
        }
        textView.setText(spannableString);
        TextView textView2 = (TextView) inflate.findViewById(2131624195);
        textView2.setText(Html.fromHtml(getString(2131165385)));
        Linkify.addLinks(textView2, 15);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.addTextChangedListener(new bu(this));
        if (j.a().n() && j.a().i()) {
            this.d = j.a().h();
            this.e.setVisibility(8);
        } else {
            String[] a = o.a(false);
            this.e.setAdapter(new ArrayAdapter(getActivity(), 17367050, a));
            this.e.setThreshold(0);
            if (a.length > 0) {
                this.e.setText(a[0]);
            }
        }
        inflate.findViewById(2131624200).setOnClickListener(new bv(this, btVar));
        return inflate;
    }

    public final void onStart() {
        super.onStart();
        a.d();
        i.a("/Support");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(getActivity().getString(2131165284));
    }
}
