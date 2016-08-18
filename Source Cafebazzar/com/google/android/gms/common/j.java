package com.google.android.gms.common;

import java.util.HashSet;
import java.util.Set;

final class j {
    static final k[] a = new k[]{gd.a[0], gg.a[0], ff.a[0], lk.a[0], bs.a[0], ky.a[0], fi.a[0], cl.a[0], lh.a[0], lb.a[0], ez.a[0], ds.a[0], fs.a[0], ao.a[0], dp.a[0], fx.a[0], jg.a[0], ch.a[0], ig.a[0], im.a[0], hx.a[0], bm.a[0], cx.a[0], cr.a[0], cu.a[0], id.a[0], jw.a[0], bg.a[0], bj.a[0], ek.a[0], dg.a[0], kf.a[0], kf.a[1], au.a[0], ai.a[0], jz.a[0], jm.a[0], jd.a[0], dd.a[0], hc.a[0], hc.a[1], co.a[0], da.a[0], bd.a[0], q.a[0], ce.a[0], z.a[0], dm.a[0], is.a[0], ja.a[0], eh.a[0], ga.a[0], jj.a[0], gr.a[0], fp.a[0], ee.a[0], o.a[0], by.a[0], go.a[0], kk.a[0], w.a[0], cb.a[0], eq.a[0], gu.a[0], kn.a[0], ba.a[0], dj.a[0], ia.a[0], ac.a[0], jr.a[0], hs.a[0], kc.a[0], dy.a[0], hg.a[0], kv.a[0], le.a[0], ks.a[0], t.a[0], en.a[0], l.a[0], gl.a[0], ew.a[0], dv.a[0], gj.a[0], hm.a[0], ax.a[0], ip.a[0], ij.a[0], af.a[0], gw.a[0], bv.a[0], fm.a[0], hj.a[0], ix.a[0], jp.a[0], ar.a[0], fc.a[0], hu.a[0], eb.a[0], iu.a[0], ju.a[0], fu.a[0], ln.a[0], lw.a[0], hp.a[0], lq.a[0], gz.a[0], al.a[0], lt.a[0], bp.a[0], et.a[0]};
    static final k[] b;
    private static Set c;
    private static Set d;

    static {
        int i;
        k[][] kVarArr = new k[][]{gd.a, gg.a, kq.a, ff.a, lk.a, bs.a, ky.a, fi.a, cl.a, lh.a, lb.a, ez.a, ds.a, fs.a, ao.a, dp.a, fx.a, jg.a, ch.a, ig.a, im.a, hx.a, bm.a, cx.a, cr.a, cu.a, id.a, jw.a, bg.a, bj.a, ek.a, dg.a, kf.a, au.a, ai.a, jz.a, jm.a, jd.a, dd.a, hc.a, co.a, da.a, bd.a, q.a, ce.a, z.a, dm.a, is.a, ja.a, eh.a, ga.a, jj.a, gr.a, fp.a, ee.a, o.a, by.a, go.a, kk.a, w.a, cb.a, eq.a, gu.a, kn.a, ba.a, dj.a, ia.a, ac.a, jr.a, hs.a, kc.a, dy.a, hg.a, kv.a, le.a, ks.a, t.a, en.a, l.a, gl.a, ew.a, dv.a, gj.a, hm.a, ax.a, ip.a, ij.a, af.a, gw.a, bv.a, fm.a, hj.a, ix.a, jp.a, ar.a, fc.a, hu.a, eb.a, iu.a, ju.a, fu.a, ln.a, lw.a, hp.a, lq.a, gz.a, al.a, lt.a, bp.a, et.a};
        int i2 = 0;
        for (i = 0; i < 110; i++) {
            i2 += kVarArr[i].length;
        }
        k[] kVarArr2 = new k[i2];
        int i3 = 0;
        i2 = 0;
        while (i3 < 110) {
            k[] kVarArr3 = kVarArr[i3];
            i = i2;
            i2 = 0;
            while (i2 < kVarArr3.length) {
                kVarArr2[i] = kVarArr3[i2];
                i2++;
                i++;
            }
            i3++;
            i2 = i;
        }
        b = kVarArr2;
    }

    static Set a() {
        if (c == null) {
            c = a(b);
        }
        return c;
    }

    private static Set a(k[] kVarArr) {
        Set hashSet = new HashSet(kVarArr.length);
        for (Object add : kVarArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    static Set b() {
        if (d == null) {
            d = a(a);
        }
        return d;
    }
}
