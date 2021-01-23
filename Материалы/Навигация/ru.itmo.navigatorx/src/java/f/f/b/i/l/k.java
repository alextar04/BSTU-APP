/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.l.f
 *  f.f.b.i.l.i
 *  f.f.b.i.l.m
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.i;
import f.f.b.i.l.m;
import java.util.ArrayList;
import java.util.List;

public class k {
    public static int c;
    public m a = null;
    public ArrayList<m> b = new ArrayList();

    public k(m m2, int n2) {
        c = 1 + c;
        this.a = m2;
    }

    public final long a(f f2, long l2) {
        m m2 = f2.d;
        if (m2 instanceof i) {
            return l2;
        }
        int n2 = f2.k.size();
        long l3 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            if (!(d2 instanceof f)) continue;
            f f3 = (f)d2;
            if (f3.d == m2) continue;
            l3 = Math.min((long)l3, (long)this.a(f3, l2 + (long)f3.f));
        }
        if (f2 == m2.i) {
            long l4 = m2.j();
            f f4 = m2.h;
            long l5 = l2 - l4;
            l3 = Math.min((long)Math.min((long)l3, (long)this.a(f4, l5)), (long)(l5 - (long)m2.h.f));
        }
        return l3;
    }

    public final long b(f f2, long l2) {
        m m2 = f2.d;
        if (m2 instanceof i) {
            return l2;
        }
        int n2 = f2.k.size();
        long l3 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            if (!(d2 instanceof f)) continue;
            f f3 = (f)d2;
            if (f3.d == m2) continue;
            l3 = Math.max((long)l3, (long)this.b(f3, l2 + (long)f3.f));
        }
        if (f2 == m2.h) {
            long l4 = m2.j();
            f f4 = m2.i;
            long l5 = l2 + l4;
            l3 = Math.max((long)Math.max((long)l3, (long)this.b(f4, l5)), (long)(l5 - (long)m2.i.f));
        }
        return l3;
    }
}

