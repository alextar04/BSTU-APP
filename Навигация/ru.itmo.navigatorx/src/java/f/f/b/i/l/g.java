/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.l.f
 *  f.f.b.i.l.m
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.j;
import f.f.b.i.l.m;
import java.util.List;

public class g
extends f {
    public int m;

    public g(m m2) {
        super(m2);
        f.a a2 = m2 instanceof j ? f.a.f : f.a.g;
        this.e = a2;
    }

    public void c(int n2) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = n2;
        for (d d2 : this.k) {
            d2.a(d2);
        }
    }
}

