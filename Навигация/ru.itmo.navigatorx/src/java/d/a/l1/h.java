/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  java.lang.Object
 */
package d.a.l1;

import d.a.l1.f;
import d.a.l1.n.c;
import h.k.d;

public final class h
extends c<f<?>> {
    public long a = -1L;
    public d<? super h.h> b;

    @Override
    public boolean a(Object object) {
        f f2 = (f)object;
        if (this.a >= 0L) {
            return false;
        }
        long l2 = f2.i;
        if (l2 < f2.j) {
            f2.j = l2;
        }
        this.a = l2;
        return true;
    }

    @Override
    public d[] b(Object object) {
        f f2 = (f)object;
        long l2 = this.a;
        this.a = -1L;
        this.b = null;
        return f2.u(l2);
    }
}

