package com.farsitel.bazaar.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.congenialmobile.util.h;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.ac;
import com.farsitel.bazaar.a.ao;
import com.farsitel.bazaar.a.av;
import com.farsitel.bazaar.b.al;
import com.farsitel.bazaar.b.ar;
import com.farsitel.bazaar.b.bd;
import com.farsitel.bazaar.b.bg;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.database.m;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.f.a.c;
import com.farsitel.bazaar.f.d;
import com.farsitel.bazaar.f.f;
import com.farsitel.bazaar.f.k;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.l;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.ah;
import com.farsitel.bazaar.util.ai;
import com.farsitel.bazaar.util.aj;
import com.farsitel.bazaar.util.j;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.q;
import com.farsitel.bazaar.widget.BazaarTitleBar;
import com.farsitel.bazaar.widget.HorizontalListView;
import com.farsitel.bazaar.widget.ObservableScrollView;
import com.farsitel.bazaar.widget.RetryView;
import com.farsitel.bazaar.widget.SlidingTabBar;
import com.farsitel.bazaar.widget.ak;
import com.farsitel.bazaar.widget.s;
import com.farsitel.bazaar.widget.t;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import ir.cafebazaar.pardakht.a.e;

public final class a extends y implements OnClickListener, com.farsitel.bazaar.f.a.a, c {
    private TextView A;
    private View B;
    private boolean C;
    private TextView D;
    private ah E;
    private int F;
    private boolean G = false;
    private boolean H = false;
    private View I;
    private View J;
    private SlidingTabBar K;
    private SlidingTabBar L;
    private View M;
    private ao N;
    private View O;
    private TextView P;
    private int Q = -1;
    private e R;
    private Handler a = new Handler();
    private String b;
    private String c;
    private d d;
    private com.farsitel.bazaar.g.a.a e;
    private f f;
    private r j;
    private BroadcastReceiver k;
    private NfcAdapter l;
    private b m = new b(this);
    private View n;
    private Button o;
    private TextView p;
    private View q;
    private View r;
    private View s;
    private TextView t;
    private ProgressBar u;
    private ObservableScrollView v;
    private ListView w;
    private ObservableScrollView x;
    private View y;
    private RetryView z;

    public static Uri a(String str, String str2) {
        return Uri.parse(b(str, str2));
    }

    public static a a(String str, String str2, String str3, float f, String str4) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("app_slug", str);
        bundle.putString("app_name", str2);
        bundle.putString("app_author", str3);
        bundle.putString("intent_action", str4);
        bundle.putFloat("app_rating", f);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void a(int i) {
        if (i == 0 && this.t.getVisibility() != 0) {
            this.t.setVisibility(i);
        } else if (i != 0 && this.t.getVisibility() == 0) {
            this.t.setVisibility(i);
        }
    }

    private void a(int i, int i2, boolean z) {
        boolean z2 = true;
        if (this.e != null && getActivity() != null && isAdded()) {
            if (i == -1) {
                i = this.e.l() ? 1 : 10;
            }
            if (i == 1 || i == 0) {
                this.e.e();
                e();
            }
            if (this.e.I == -1 || !this.e.d()) {
                this.o.setText(g());
                this.o.setEnabled(false);
                this.o.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            switch (i) {
                case 0:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                    a(8);
                    if (this.e.m()) {
                        if (this.e != null) {
                            this.o.setEnabled(true);
                        } else {
                            this.o.setEnabled(false);
                        }
                        this.o.setVisibility(0);
                        switch (i) {
                            case 4:
                                this.o.setText(2131165596);
                                break;
                            case 5:
                                this.o.setText(2131165382);
                                break;
                            case 8:
                                this.o.setText(2131165381);
                                break;
                            default:
                                this.o.setText(2131165724);
                                break;
                        }
                        this.r.setVisibility(8);
                    } else if (this.e.l()) {
                        this.o.setVisibility(8);
                        if (this.e.n()) {
                            this.r.setVisibility(0);
                        } else {
                            this.r.setVisibility(8);
                        }
                    } else if (this.e != null) {
                        this.r.setVisibility(8);
                        this.o.setEnabled(true);
                        this.o.setVisibility(0);
                        switch (i) {
                            case 4:
                                this.o.setText(2131165596);
                                break;
                            case 5:
                                this.o.setText(2131165382);
                                break;
                            case 8:
                                this.o.setText(2131165381);
                                break;
                            default:
                                this.o.setText(g());
                                if (this.e.C == -1) {
                                    z2 = false;
                                }
                                if (z2) {
                                    this.p.setVisibility(0);
                                    this.p.setText(aj.a((long) this.e.C));
                                    break;
                                }
                                break;
                        }
                    } else {
                        this.o.setVisibility(8);
                    }
                    if (this.e.o()) {
                        this.s.setVisibility(0);
                    } else {
                        this.s.setVisibility(8);
                    }
                    this.q.setVisibility(8);
                    this.P.setVisibility(0);
                    this.u.setVisibility(4);
                    return;
                case 1:
                    a(8);
                    if (this.e.m()) {
                        this.o.setVisibility(0);
                        this.o.setText(2131165724);
                    } else {
                        this.o.setVisibility(8);
                        if (this.e.n()) {
                            this.r.setVisibility(0);
                            if (this.e.o()) {
                                this.s.setVisibility(8);
                            } else {
                                this.s.setVisibility(0);
                            }
                            this.q.setVisibility(8);
                            this.P.setVisibility(0);
                            this.u.setVisibility(4);
                            return;
                        }
                    }
                    this.r.setVisibility(8);
                    if (this.e.o()) {
                        this.s.setVisibility(8);
                    } else {
                        this.s.setVisibility(0);
                    }
                    this.q.setVisibility(8);
                    this.P.setVisibility(0);
                    this.u.setVisibility(4);
                    return;
                case 2:
                    this.t.setText(2131165425);
                    a(0);
                    this.o.setVisibility(8);
                    this.s.setVisibility(8);
                    this.q.setVisibility(8);
                    this.P.setVisibility(4);
                    this.r.setVisibility(8);
                    this.u.setVisibility(0);
                    this.u.setIndeterminate(true);
                    return;
                case 3:
                    a(8);
                    if (this.e.m()) {
                        if (this.e != null) {
                            this.o.setEnabled(true);
                        } else {
                            this.o.setEnabled(false);
                        }
                        this.o.setVisibility(0);
                        this.o.setText(2131165724);
                        this.r.setVisibility(8);
                    } else if (this.e.l()) {
                        this.o.setVisibility(8);
                        if (this.e.n()) {
                            this.r.setVisibility(0);
                        } else {
                            this.r.setVisibility(8);
                        }
                    } else {
                        if (this.e != null) {
                            this.o.setEnabled(true);
                        } else {
                            this.o.setEnabled(false);
                        }
                        this.o.setVisibility(0);
                        this.o.setText(g());
                        this.r.setVisibility(8);
                    }
                    if (this.e.o()) {
                        this.s.setVisibility(0);
                    } else {
                        this.s.setVisibility(8);
                    }
                    this.q.setVisibility(8);
                    this.P.setVisibility(0);
                    this.u.setVisibility(4);
                    return;
                case 7:
                    a(8);
                    this.o.setVisibility(0);
                    this.o.setEnabled(false);
                    this.o.setText(2131165384);
                    this.s.setVisibility(8);
                    this.q.setVisibility(8);
                    this.P.setVisibility(0);
                    this.u.setVisibility(4);
                    if (!this.e.n() || this.e.m()) {
                        this.r.setVisibility(8);
                        return;
                    } else {
                        this.r.setVisibility(0);
                        return;
                    }
                case 12:
                    this.t.setText(2131165552);
                    a(0);
                    if (q.e()) {
                        this.t.setText(2131165552);
                        a(0);
                    } else {
                        this.t.setText(2131165785);
                        a(0);
                    }
                    this.o.setVisibility(8);
                    this.s.setVisibility(8);
                    this.r.setVisibility(8);
                    this.q.setVisibility(0);
                    this.P.setVisibility(4);
                    this.u.setVisibility(0);
                    this.u.setIndeterminate(true);
                    return;
                case 13:
                    this.t.setText(2131165357);
                    a(0);
                    this.o.setVisibility(8);
                    this.s.setVisibility(8);
                    this.q.setVisibility(0);
                    this.P.setVisibility(4);
                    this.r.setVisibility(8);
                    this.u.setVisibility(0);
                    this.u.setIndeterminate(false);
                    if (VERSION.SDK_INT >= 11) {
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.u, "progress", new int[]{j.a(i2)});
                        ofInt.setDuration(50);
                        ofInt.setInterpolator(new DecelerateInterpolator());
                        ofInt.start();
                        return;
                    }
                    this.u.setProgress(j.a(i2));
                    return;
                case 14:
                    this.t.setText(2131165355);
                    a(0);
                    this.o.setVisibility(8);
                    this.s.setVisibility(8);
                    this.q.setVisibility(0);
                    this.P.setVisibility(4);
                    this.r.setVisibility(8);
                    this.u.setVisibility(0);
                    this.u.setIndeterminate(true);
                    if (this.C) {
                        this.C = false;
                        s sVar = s.INSTANCE;
                        s.a(t.ROOT_INSTALL);
                        int i3 = 0;
                        while (i3 < 4) {
                            String str = new String[]{"eu.chainfire.supersu", "com.koushikdutta.superuser", "eu.chainfire.supersu.pro", "com.noshufou.android.su"}[i3];
                            af afVar = af.INSTANCE;
                            if (!af.c(str)) {
                                i3++;
                            } else if (z2 && getChildFragmentManager() != null) {
                                new bg(getActivity()).e.show();
                                return;
                            } else {
                                return;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, float f, String str4) {
        ((HomeActivity) context).a(a(b(str, str4), str2, str3, f, null), true, bj.APPEAR);
    }

    private void a(View view) {
        if (com.farsitel.bazaar.g.j.a().n()) {
            if (this.h != null) {
                BazaarTitleBar bazaarTitleBar = this.h;
                bazaarTitleBar.e.setVisibility(8);
                bazaarTitleBar.f.setVisibility(0);
            }
            com.farsitel.bazaar.h.d dVar = com.farsitel.bazaar.h.d.INSTANCE;
            v iVar = new i(this);
            k dVar2 = new com.farsitel.bazaar.h.b.d();
            String str = com.farsitel.bazaar.g.j.a().b;
            String g = this.e.g();
            boolean z = !com.farsitel.bazaar.database.e.a().a(this.e.g());
            dVar.a(iVar, dVar2, str, g, Boolean.valueOf(z));
            return;
        }
        Intent intent = new Intent(getActivity(), JoinActivity.class);
        intent.putExtra("extra_referer", "bookmark");
        intent.putExtra("android.intent.extra.TITLE", getString(2131165312));
        com.farsitel.bazaar.util.c.a(getActivity(), intent, 40004, view);
    }

    private void a(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) this.I.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.I);
        }
        viewGroup.addView(this.I, -1, -2);
        d();
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        if (aVar.x.getVisibility() != 0) {
            aVar.v.setVisibility(8);
            aVar.w.setVisibility(8);
            aVar.x.setVisibility(0);
            aVar.x.scrollTo(0, 0);
            if (!aVar.H) {
                com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
                com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
                cVar.f = z ? "user" : "system";
                cVar.c = "app_details";
                com.farsitel.bazaar.g.c a2 = cVar.a("pn", aVar.e.g());
                a2.e = "tab_click";
                a.a(a2.b("which", "related"));
                LinearLayout linearLayout = (LinearLayout) aVar.x.findViewById(2131624041);
                View frameLayout = new FrameLayout(aVar.getActivity());
                frameLayout.setId(2131624048);
                linearLayout.addView(frameLayout, -1, -2);
                if (aVar.e.E == null || aVar.e.E.length <= 0) {
                    View inflate = LayoutInflater.from(aVar.getActivity()).inflate(2130903107, null);
                    ((TextView) inflate.findViewById(2131624271)).setText(aVar.getString(2131165469));
                    linearLayout.addView(inflate, -1, -1);
                } else {
                    ac acVar = new ac(aVar.getActivity(), LayoutInflater.from(aVar.getActivity()), aVar.e.E, null, null, aVar.e.g(), aVar.getDialog() != null);
                    for (int i = 0; i < acVar.getCount(); i++) {
                        linearLayout.addView(acVar.getView(i, null, null), -1, -2);
                    }
                }
                linearLayout.setVisibility(0);
                aVar.H = true;
            }
            if (aVar.O.getVisibility() == 0) {
                aVar.O.setVisibility(8);
            }
            aVar.a((ViewGroup) aVar.x.findViewById(2131624048));
        }
    }

    private void a(String str, boolean z) {
        if (z) {
            ReviewActivity.a(getActivity(), str);
        } else {
            ReviewActivity.a(getActivity(), 40005, str);
        }
    }

    private void a(boolean z) {
        boolean a = com.farsitel.bazaar.database.e.a().a(this.e.g());
        OnClickListener hVar = new h(this);
        if (this.h != null) {
            BazaarTitleBar bazaarTitleBar = this.h;
            if (a) {
                bazaarTitleBar.e.setImageResource(g.ic_bookmark_on);
            } else {
                bazaarTitleBar.e.setImageResource(g.ic_bookmark_off);
            }
            bazaarTitleBar.e.setOnClickListener(hVar);
            bazaarTitleBar.e.setVisibility(0);
        }
        if (z) {
            com.farsitel.bazaar.g.a a2 = com.farsitel.bazaar.g.a.a();
            com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
            cVar.f = "user";
            cVar.c = "app_details";
            cVar = cVar.a("pn", this.b);
            cVar.e = "btn_click";
            a2.a(cVar.b("which", "bookmark").b("state", a ? "added" : "removed"));
            if (a) {
                Toast.makeText(getActivity(), 2131165309, 1).show();
            } else {
                Toast.makeText(getActivity(), 2131165310, 1).show();
            }
        }
    }

    private static String b(String str, String str2) {
        return "bazaar://details?id=" + str + "&ref" + "=" + str2;
    }

    private void d() {
        if (this.Q > 0) {
            int[] iArr = new int[2];
            this.K.getLocationInWindow(iArr);
            if (iArr[1] < this.Q) {
                this.L.setVisibility(0);
                this.M.setVisibility(0);
                if (getView() != null) {
                    a(this.e.h());
                    return;
                }
                return;
            }
            this.L.setVisibility(4);
            this.M.setVisibility(4);
            if (getView() != null) {
                a("");
            }
        }
    }

    private void e() {
        if (getActivity() != null && isAdded()) {
            String str;
            TextView textView = (TextView) this.n.findViewById(2131624059);
            if (this.e.m() && com.farsitel.bazaar.util.d.a() && this.e.H > 0) {
                textView.setPaintFlags(((TextView) this.n.findViewById(2131624057)).getPaintFlags() | 16);
                textView.setTextColor(-16777216);
                TextView textView2 = (TextView) this.n.findViewById(2131624060);
                textView2.setText(com.congenialmobile.util.e.b(h.a(getActivity(), this.e.H)));
                textView2.setVisibility(0);
            } else {
                textView.setPaintFlags(((TextView) this.n.findViewById(2131624057)).getPaintFlags());
                textView.setTextColor(getResources().getColor(2131558530));
                ((TextView) this.n.findViewById(2131624060)).setVisibility(8);
            }
            textView.setText(com.congenialmobile.util.e.b(h.a(getActivity(), this.e.G)));
            textView.setVisibility(0);
            textView = (TextView) this.n.findViewById(2131624062);
            textView.setVisibility(0);
            ((TextView) this.n.findViewById(2131624061)).setVisibility(0);
            if (this.e.m()) {
                af afVar = af.INSTANCE;
                CharSequence charSequence = af.b(this.e.g()).c;
                CharSequence charSequence2 = this.e.a;
                if (charSequence == null) {
                    charSequence = "-";
                }
                if (charSequence.equals(charSequence2)) {
                    af afVar2 = af.INSTANCE;
                    long j = af.b(this.e.g()).d;
                    long i = this.e.i();
                    charSequence = getString(2131165280, charSequence, Long.valueOf(j));
                    charSequence2 = getString(2131165280, charSequence2, Long.valueOf(i));
                }
                textView.setText(charSequence);
                textView = (TextView) this.n.findViewById(2131624064);
                textView.setVisibility(0);
                textView.setText(charSequence2);
                ((TextView) this.n.findViewById(2131624063)).setVisibility(0);
                ExpandableTextView expandableTextView = (ExpandableTextView) this.n.findViewById(2131624051);
                Spanned spanned = this.e.w;
                str = "";
                if (spanned != null) {
                    String[] split = spanned.toString().split("\n");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        String str2 = split[i2];
                        if (!str2.matches("\\s*")) {
                            str = str + str2;
                            if (i2 < split.length - 1) {
                                str = str + "<BR/>";
                            }
                        }
                    }
                    if (!str.equals("")) {
                        expandableTextView.setText(Html.fromHtml(str));
                        expandableTextView.setVisibility(0);
                        this.n.findViewById(2131624050).setVisibility(0);
                    }
                }
            } else {
                textView.setText(this.e.a);
                ((TextView) this.n.findViewById(2131624064)).setVisibility(8);
                ((TextView) this.n.findViewById(2131624063)).setVisibility(8);
            }
            str = this.e.u;
            if (!(str == null || str.equals(""))) {
                textView = (TextView) this.n.findViewById(2131624066);
                textView.setText(com.congenialmobile.util.e.b(str));
                textView.setVisibility(0);
                this.n.findViewById(2131624065).setVisibility(0);
            }
            View findViewById = this.n.findViewById(2131624068);
            if (!(this.e.w == null || TextUtils.isEmpty(this.e.w))) {
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
                this.n.findViewById(2131624067).setVisibility(0);
            }
            this.n.findViewById(2131624070).setOnClickListener(this);
        }
    }

    static /* synthetic */ void f(a aVar) {
        TextView textView;
        View findViewById;
        boolean z;
        ((TextView) aVar.I.findViewById(2131624212)).setText(aVar.e.h());
        aVar.n.findViewById(2131624053).setVisibility(0);
        aVar.n.findViewById(2131624052).setVisibility(0);
        ImageView imageView = (ImageView) aVar.n.findViewById(2131624073);
        if (!aVar.e.d.isEmpty()) {
            ImageView imageView2 = (ImageView) aVar.I.findViewById(2131624213);
            imageView2.setVisibility(0);
            ab.a().a(com.farsitel.bazaar.g.j.a().l() + aVar.e.c, imageView2);
            aVar.n.findViewById(2131624071).setVisibility(0);
            textView = (TextView) aVar.n.findViewById(2131624072);
            textView.setVisibility(0);
            textView.setText(aVar.e.d);
            imageView.setVisibility(0);
            ab.a().a(com.farsitel.bazaar.g.j.a().l() + aVar.e.b, imageView);
        }
        TextView textView2 = (TextView) aVar.I.findViewById(2131624210);
        textView2.setText(aVar.e.e);
        textView2.setOnClickListener(aVar);
        RatingBar ratingBar = (RatingBar) aVar.I.findViewById(2131624214);
        if (aVar.e.j > 0.0f) {
            ratingBar.setRating(aVar.e.j);
            ratingBar.setVisibility(0);
            findViewById = aVar.I.findViewById(2131624216);
            findViewById.setOnClickListener(aVar);
            findViewById.setVisibility(0);
        }
        aVar.P.setText(com.congenialmobile.util.e.b(aVar.getString(2131165229, Integer.valueOf(aVar.e.k))));
        textView2 = (TextView) aVar.n.findViewById(2131624055);
        textView2.setText(aVar.e.r);
        textView2.setOnClickListener(aVar);
        ((TextView) aVar.n.findViewById(2131624057)).setText(com.congenialmobile.util.e.b(aVar.e.q));
        aVar.e();
        aVar.a(false);
        if (aVar.e.J) {
            OnClickListener pVar = new p(aVar);
            if (aVar.h != null) {
                BazaarTitleBar bazaarTitleBar = aVar.h;
                bazaarTitleBar.g.setVisibility(0);
                bazaarTitleBar.g.setOnClickListener(pVar);
            }
        }
        HorizontalListView horizontalListView = (HorizontalListView) aVar.n.findViewById(2131624049);
        com.farsitel.bazaar.g.a.b bVar = new com.farsitel.bazaar.g.a.b(aVar.e);
        if (bVar.c.length > 0) {
            horizontalListView.setAdapter(new av(aVar.getActivity(), bVar.c, 0));
            horizontalListView.setVisibility(0);
        }
        aVar.n.findViewById(2131624074).setVisibility(0);
        String str = aVar.e.v;
        if (!(str == null || str.equals(""))) {
            ExpandableTextView expandableTextView = (ExpandableTextView) aVar.n.findViewById(2131624076);
            expandableTextView.setVisibility(0);
            aVar.n.findViewById(2131624075).setVisibility(0);
            expandableTextView.setText(Html.fromHtml(str));
        }
        LinearLayout linearLayout = (LinearLayout) aVar.n.findViewById(2131624088);
        com.farsitel.bazaar.g.a.c[] cVarArr = aVar.e.D;
        LayoutInflater from = LayoutInflater.from(aVar.getActivity());
        if (cVarArr != null) {
            for (com.farsitel.bazaar.g.a.c cVar : cVarArr) {
                View inflate = from.inflate(2130903162, null);
                ((TextView) inflate.findViewById(2131624393)).setText(cVar.b);
                ab.a().a(com.farsitel.bazaar.g.j.a().l() + "press/" + cVar.a + "_72x72.png", (ImageView) inflate.findViewById(2131624392), (int) g.icon_not_loaded);
                inflate.setOnClickListener(new q(aVar, cVar.c));
                linearLayout.addView(inflate);
            }
            if (cVarArr.length > 0) {
                linearLayout.setVisibility(0);
                aVar.n.findViewById(2131624087).setVisibility(0);
                aVar.n.findViewById(2131624086).setVisibility(0);
            }
        }
        View findViewById2 = aVar.n.findViewById(2131624080);
        View findViewById3 = aVar.n.findViewById(2131624081);
        View findViewById4 = aVar.n.findViewById(2131624082);
        textView2 = (TextView) aVar.n.findViewById(2131624083);
        textView = (TextView) aVar.n.findViewById(2131624084);
        TextView textView3 = (TextView) aVar.n.findViewById(2131624085);
        CharSequence charSequence = aVar.e.g;
        CharSequence charSequence2 = aVar.e.f;
        String str2 = aVar.e.h;
        if (charSequence.equals("")) {
            z = false;
        } else {
            textView3.setText(charSequence);
            textView3.setVisibility(0);
            findViewById4.setVisibility(0);
            z = true;
        }
        if (!charSequence2.equals("")) {
            textView2.setText(charSequence2);
            textView2.setVisibility(0);
            findViewById2.setVisibility(0);
            z = true;
        }
        if (!str2.equals("")) {
            CharSequence spannableString = new SpannableString(str2);
            spannableString.setSpan(new UnderlineSpan(), 0, str2.length(), 0);
            textView.setText(spannableString);
            textView.setVisibility(0);
            findViewById3.setVisibility(0);
            z = true;
        }
        textView.setOnClickListener(new d(aVar, str2));
        if (z) {
            aVar.n.findViewById(2131624079).setVisibility(0);
            aVar.n.findViewById(2131624078).setVisibility(0);
            aVar.n.findViewById(2131624077).setVisibility(0);
        }
        aVar.n.findViewById(2131624089).setVisibility(0);
        findViewById = aVar.n.findViewById(2131624090);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(aVar);
        View inflate2 = LayoutInflater.from(aVar.getActivity()).inflate(2130903090, null);
        ratingBar = (RatingBar) inflate2.findViewById(2131624225);
        l a = m.a().a(aVar.e.g());
        if (a != null) {
            aVar.F = a.b;
            ratingBar.setRating((float) aVar.F);
        }
        ratingBar.setOnRatingBarChangeListener(new e(aVar, ratingBar));
        aVar.w.addHeaderView(inflate2);
        findViewById = new View(aVar.getActivity());
        findViewById.setLayoutParams(new LayoutParams(-1, (int) aVar.getActivity().getResources().getDimension(2131361912)));
        aVar.w.addFooterView(findViewById);
        aVar.N = new ao(aVar.getActivity(), LayoutInflater.from(aVar.getActivity()), aVar.w, aVar.b, aVar, aVar.e.i());
        aVar.w.setAdapter(aVar.N);
        if (aVar.e.I == -1) {
            aVar.D.setVisibility(0);
            aVar.D.setText(com.congenialmobile.util.e.b(aVar.getString(2131165446, aVar.e.t)));
        } else if (aVar.e.A) {
            aVar.D.setVisibility(0);
            aVar.D.setText(2131165796);
        }
        com.farsitel.bazaar.widget.ah fVar = new f(aVar);
        aVar.K.setOnTabChangeListener(fVar);
        aVar.L.setOnTabChangeListener(fVar);
        aVar.a(com.farsitel.bazaar.c.b.a.a().a(aVar.b), 0, true);
    }

    private String g() {
        Object obj = 1;
        if (this.e.I == -1) {
            return getString(2131165473);
        }
        if (!this.e.d()) {
            return getString(2131165474);
        }
        if (this.e.a() || this.R.a(this.b)) {
            return getString(2131165409);
        }
        if (this.e.B.length <= 1) {
            obj = null;
        }
        return obj != null ? getString(2131165395) : aj.a((long) this.e.b());
    }

    static /* synthetic */ void g(a aVar) {
        if (VERSION.SDK_INT >= 14) {
            try {
                aVar.l = NfcAdapter.getDefaultAdapter(aVar.getActivity());
                if (aVar.l != null) {
                    aVar.l.setNdefPushMessage(new NdefMessage(new NdefRecord[]{NdefRecord.createUri(b(aVar.e.g(), "nfc"))}), aVar.getActivity(), new Activity[0]);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void l() {
        this.w.removeFooterView(this.y);
    }

    static /* synthetic */ void p(a aVar) {
        if (aVar.v.getVisibility() != 0) {
            aVar.v.setVisibility(0);
            aVar.v.scrollTo(0, 0);
            aVar.w.setVisibility(8);
            aVar.x.setVisibility(8);
            if (aVar.O.getVisibility() == 0) {
                aVar.O.setVisibility(8);
            }
            aVar.a((ViewGroup) aVar.v.findViewById(2131624048));
        }
    }

    static /* synthetic */ void q(a aVar) {
        if (aVar.w.getVisibility() != 0) {
            aVar.v.setVisibility(8);
            aVar.w.setVisibility(0);
            aVar.w.setSelection(0);
            aVar.x.setVisibility(8);
            if (!(aVar.N == null || aVar.G)) {
                aVar.N.a();
                aVar.G = true;
                com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
                com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", aVar.e.g());
                cVar.e = "tab_click";
                a.a(cVar.b("which", "review"));
            }
            if (aVar.O.getVisibility() != 0) {
                aVar.O.setVisibility(0);
            }
            aVar.a((ViewGroup) aVar.w.findViewById(2131624048));
        }
    }

    public final void a() {
        this.w.addFooterView(this.y);
    }

    public final void a(com.farsitel.bazaar.g.g[] gVarArr, boolean z) {
        l();
    }

    public final void b() {
        l();
    }

    public final void c() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        if (this.f != null) {
            this.f.a(i, i2, intent);
        }
        switch (i) {
            case 40002:
                if (i2 == -1) {
                    String string = getArguments().getString("intent_action");
                    String g = this.e.g();
                    if (string != null && string.equals("android.intent.action.EDIT")) {
                        z = true;
                    }
                    a(g, z);
                    return;
                }
                return;
            case 40004:
                if (i2 == -1) {
                    a(null);
                    return;
                }
                return;
            case 40005:
                if (i2 == -1) {
                    int intExtra = intent.getIntExtra("app_rate", 0);
                    if (intExtra > 0) {
                        ((RatingBar) this.w.findViewById(2131624224).findViewById(2131624225)).setRating((float) intExtra);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onClick(View view) {
        boolean z = true;
        Intent intent;
        HomeActivity homeActivity;
        com.farsitel.bazaar.g.a a;
        com.farsitel.bazaar.g.c cVar;
        switch (view.getId()) {
            case 2131624055:
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("bazaar://page?slug=by_category&cid=" + this.e.s + "&ref=appdetails-category-" + this.e.g()));
                intent.putExtra("name", this.e.r);
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(intent, z, false);
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "app_category"));
                return;
            case 2131624068:
                new com.farsitel.bazaar.b.s(getActivity(), this.e).e.show();
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "app_upgrade_changelog"));
                return;
            case 2131624070:
                new al(getActivity(), this.e).e.show();
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "app_permissions"));
                return;
            case 2131624090:
                if (com.farsitel.bazaar.g.j.a().n()) {
                    new ar(getActivity(), this.e.g()).e.show();
                    return;
                }
                Intent intent2 = new Intent(getActivity(), JoinActivity.class);
                intent2.putExtra("extra_referer", "report-app");
                intent2.putExtra("android.intent.extra.TITLE", getString(2131165577));
                com.farsitel.bazaar.util.c.a(getActivity(), intent2, view);
                return;
            case 2131624208:
                if (this.e != null && this.e.l()) {
                    this.e.k();
                    BazaarApplication.c().d();
                    i.b("open_icon");
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new com.farsitel.bazaar.g.c();
                    cVar.f = "user";
                    cVar.c = "app_details";
                    cVar = cVar.a("pn", this.b);
                    cVar.e = "btn_click";
                    a.a(cVar.b("which", "app_icon"));
                    return;
                }
                return;
            case 2131624209:
                this.e.a(getActivity());
                BazaarApplication.c().d();
                i.b("uninstall_button");
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "uninstall"));
                return;
            case 2131624210:
                intent = new Intent();
                intent.setData(Uri.parse("bazaar://page?slug=by_author&aid=" + this.e.i + "&ref=appdetails-author-" + this.e.g()));
                intent.putExtra("name", this.e.e);
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(intent, z, false);
                return;
            case 2131624216:
                new bd(getActivity(), this.e).e.show();
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "average_rate_stars"));
                return;
            case 2131624217:
                if (this.f != null) {
                    this.f.a(view);
                    if (!this.H && this.e.F) {
                        this.a.postDelayed(new g(this), 500);
                    }
                    BazaarApplication.c().d();
                    i.b("install_button");
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new com.farsitel.bazaar.g.c();
                    cVar.f = "user";
                    cVar.c = "app_details";
                    cVar = cVar.a("pn", this.b);
                    cVar.e = "btn_click";
                    a.a(cVar.b("which", "install"));
                    return;
                }
                return;
            case 2131624220:
                if (this.e != null) {
                    this.e.k();
                    BazaarApplication.c().d();
                    i.b("open_button");
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new com.farsitel.bazaar.g.c();
                    cVar.f = "user";
                    cVar.c = "app_details";
                    cVar = cVar.a("pn", this.b);
                    cVar.e = "btn_click";
                    a.a(cVar.b("which", "launch"));
                    return;
                }
                return;
            case 2131624221:
                AppDownloadService.a(this.e.g());
                BazaarApplication.c().d();
                i.b("pause_button");
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.f = "user";
                cVar.c = "app_details";
                cVar = cVar.a("pn", this.b);
                cVar.e = "btn_click";
                a.a(cVar.b("which", "pause"));
                return;
            default:
                return;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.J = layoutInflater.inflate(2130903066, null);
        this.I = layoutInflater.inflate(2130903089, null);
        this.R = new e(getActivity());
        Uri parse = Uri.parse(getArguments().getString("app_slug"));
        this.b = parse.getQueryParameter("id");
        if (this.b == null) {
            this.b = parse.getQueryParameter("app");
        }
        if (this.b == null) {
            this.b = parse.getPath().replace("/app/", "").replaceAll("/", "");
        }
        if (this.b == null) {
            BazaarApplication.c().d();
            i.a("/AppInfo/Error/" + this.b + "/");
            if (getDialog() != null) {
                getDialog().dismiss();
            } else {
                getActivity().onBackPressed();
            }
            return this.J;
        }
        BazaarApplication.c().d();
        i.a("/AppInfo/" + this.b + "/");
        Object queryParameter = parse.getQueryParameter("vs");
        String queryParameter2 = parse.getQueryParameter("vst");
        char charAt = queryParameter2 != null ? queryParameter2.charAt(0) : 'U';
        if (!TextUtils.isEmpty(queryParameter)) {
            VideoPlayerActivity.a(getActivity(), queryParameter, charAt, null);
        }
        if ("android.intent.action.EDIT".equals(getArguments().getString("intent_action"))) {
            a(this.b, true);
            getActivity().finish();
            return this.J;
        }
        this.c = parse.getQueryParameter("ref");
        com.a.a.a.a.c().a((com.a.a.a.s) new com.a.a.a.s().b(this.b).a(this.b).c("app page").a("referrer", "- " + this.c));
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
        cVar.f = "user";
        cVar.c = "app_details";
        cVar = cVar.a("pn", this.b);
        cVar.e = "app_visit";
        a.a(cVar.b("referer", this.c));
        CharSequence string = getArguments().getString("app_name");
        CharSequence string2 = getArguments().getString("app_author");
        this.d = new d(this.b, BazaarApplication.c().a.getLanguage(), this.m, this.c);
        if (!this.b.equals(BazaarApplication.c().getPackageName())) {
            com.farsitel.bazaar.util.k.a(getActivity());
        }
        this.K = (SlidingTabBar) this.I.findViewById(2131624115);
        this.L = (SlidingTabBar) this.J.findViewById(2131624045);
        this.L.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        this.M = this.J.findViewById(2131624046);
        this.K.a();
        this.L.a();
        ak aVar = new com.farsitel.bazaar.a.a();
        this.K.setAdapter(aVar);
        this.L.setAdapter(aVar);
        this.v = (ObservableScrollView) this.J.findViewById(2131624038);
        this.w = (ListView) this.J.findViewById(2131624039);
        this.w.setDrawingCacheEnabled(true);
        this.x = (ObservableScrollView) this.J.findViewById(2131624040);
        this.v.setOnScrollChangedListener(new k(this));
        this.w.setOnScrollListener(new l(this));
        this.x.setOnScrollChangedListener(new m(this));
        this.n = LayoutInflater.from(getActivity()).inflate(2130903068, null);
        ImageView imageView = (ImageView) this.I.findViewById(2131624208);
        imageView.setOnClickListener(this);
        ab a2 = ab.a();
        String str = this.b;
        a2.a(String.format(VERSION.SDK_INT >= 17 ? "%sicons/%s_%s.webp" : "%sicons/%s_%s.png", new Object[]{com.farsitel.bazaar.g.j.a().l(), str, o.c()}), imageView, false, (int) g.icon_not_loaded);
        imageView.setVisibility(0);
        if (string != null) {
            ((TextView) this.I.findViewById(2131624212)).setText(string);
        }
        if (string2 != null) {
            ((TextView) this.I.findViewById(2131624210)).setText(string2);
        }
        this.o = (Button) this.I.findViewById(2131624217);
        this.o.setOnClickListener(this);
        this.p = (TextView) this.I.findViewById(2131624218);
        this.p.setPaintFlags(this.p.getPaintFlags() | 16);
        this.q = this.I.findViewById(2131624221);
        this.q.setOnClickListener(this);
        this.r = this.I.findViewById(2131624220);
        this.r.setOnClickListener(this);
        this.s = this.I.findViewById(2131624209);
        this.s.setOnClickListener(this);
        this.t = (TextView) this.I.findViewById(2131624223);
        this.t.setOnClickListener(this);
        this.u = (ProgressBar) this.I.findViewById(2131624222);
        this.B = this.J.findViewById(2131624043);
        this.v.addView(this.n);
        a((ViewGroup) this.v.findViewById(2131624048));
        this.j = new r(this, this.b);
        BroadcastReceiver broadcastReceiver = this.j;
        if (!broadcastReceiver.b) {
            android.support.v4.b.j.a(BazaarApplication.c()).a(broadcastReceiver, new IntentFilter("com.farsitel.bazaar.DOWNLOAD_PROGRESS"));
            broadcastReceiver.b = true;
        }
        s sVar = s.INSTANCE;
        this.C = !s.b(t.ROOT_INSTALL);
        this.y = LayoutInflater.from(getActivity()).inflate(2130903149, null);
        this.A = (TextView) this.J.findViewById(2131624042);
        this.z = (RetryView) this.I.findViewById(2131624207);
        this.P = (TextView) this.I.findViewById(2131624215);
        this.D = (TextView) this.I.findViewById(2131624219);
        this.O = this.J.findViewById(2131624044);
        this.O.setOnClickListener(new n(this));
        this.d.a();
        this.v.setVisibility(0);
        return this.J;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            BroadcastReceiver broadcastReceiver = this.j;
            if (broadcastReceiver.b) {
                android.support.v4.b.j.a(BazaarApplication.c()).a(broadcastReceiver);
                broadcastReceiver.b = false;
            }
        }
        if (this.E != null) {
            this.E.a = null;
        }
        this.a.removeCallbacksAndMessages(null);
        this.E = null;
    }

    public final void onDetach() {
        super.onDetach();
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
        cVar.f = "user";
        cVar.c = "app_details";
        cVar = cVar.a("pn", this.b);
        cVar.e = "close";
        a.a(cVar.b("referer", this.c));
    }

    public final void onPause() {
        super.onPause();
        if (this.E != null) {
            ah ahVar = this.E;
            ahVar.c = false;
            ahVar.b.interrupt();
        }
        if (this.k != null) {
            getActivity().unregisterReceiver(this.k);
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.E != null) {
            ah ahVar = this.E;
            ahVar.d = System.currentTimeMillis();
            ahVar.c = true;
            ahVar.b = new Thread(new ai(ahVar));
            ahVar.b.start();
        }
        this.k = new o(this);
        getActivity().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onStop() {
        super.onStop();
        if (VERSION.SDK_INT >= 14) {
            try {
                if (this.l != null) {
                    this.l.setNdefPushMessage(null, getActivity(), new Activity[0]);
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a("");
    }
}
