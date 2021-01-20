/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 */
package c.c.a.m.u;

import c.c.a.m.a;
import c.c.a.m.m;
import c.c.a.m.t.d;
import c.c.a.m.u.b0;
import c.c.a.m.u.e;
import c.c.a.m.u.g;
import c.c.a.m.u.h;
import c.c.a.m.u.k;
import c.c.a.m.v.n;

public class a0
implements d.a<Object> {
    public final /* synthetic */ n.a e;
    public final /* synthetic */ b0 f;

    public a0(b0 b02, n.a a2) {
        this.f = b02;
        this.e = a2;
    }

    @Override
    public void d(Exception exception) {
        b0 b02 = this.f;
        n.a a2 = this.e;
        n.a<?> a3 = b02.j;
        boolean bl = a3 != null && a3 == a2;
        if (bl) {
            b0 b03 = this.f;
            n.a a4 = this.e;
            g.a a5 = b03.f;
            e e2 = b03.k;
            d d2 = a4.c;
            a5.d(e2, exception, d2, d2.c());
        }
    }

    @Override
    public void f(Object object) {
        b0 b02 = this.f;
        n.a a2 = this.e;
        n.a<?> a3 = b02.j;
        boolean bl = a3 != null && a3 == a2;
        if (bl) {
            b0 b03 = this.f;
            n.a a4 = this.e;
            k k2 = b03.e.p;
            if (object != null && k2.c(a4.c.c())) {
                b03.i = object;
                b03.f.b();
                return;
            }
            g.a a5 = b03.f;
            m m2 = a4.a;
            d d2 = a4.c;
            a5.c(m2, object, d2, d2.c(), b03.k);
        }
    }
}

