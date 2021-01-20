/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package c.c.a.m.u.d0;

import c.c.a.m.m;
import c.c.a.m.u.d0.i;
import c.c.a.m.u.l;
import c.c.a.m.u.w;
import c.c.a.m.u.z;
import c.c.a.s.g;

public class h
extends g<m, w<?>>
implements i {
    public i.a d;

    public h(long l2) {
        super(l2);
    }

    @Override
    public int b(Object object) {
        w w2 = (w)object;
        if (w2 == null) {
            return 1;
        }
        return w2.c();
    }

    @Override
    public void c(Object object, Object object2) {
        (m)object;
        w w2 = (w)object2;
        i.a a2 = this.d;
        if (a2 != null && w2 != null) {
            ((l)a2).e.a(w2, true);
        }
    }
}

