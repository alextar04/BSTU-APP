/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.d
 *  h.k.j.a.d
 *  java.lang.Object
 *  java.lang.Throwable
 */
package d.a.a;

import d.a.a.f;
import d.a.b;
import d.a.p;
import f.b.k.h;
import h.k.j.a.d;

public class o<T>
extends b<T>
implements d {
    @Override
    public final boolean D() {
        return true;
    }

    @Override
    public void Q(Object object) {
        if (object instanceof p) {
            h.i.K(((p)object).a);
        }
        throw null;
    }

    @Override
    public void b(Object object) {
        h.k.d d2 = h.i.B0(null);
        if (object instanceof p) {
            object = h.i.K(((p)object).a);
        }
        f.a(d2, object, null);
    }
}

