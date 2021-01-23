/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.m.a.p
 *  java.lang.Object
 *  java.lang.Throwable
 */
package d.a;

import d.a.a.f;
import d.a.d1;
import d.a.x;
import f.b.k.h;
import h.h;
import h.k.d;
import h.m.a.p;

public final class x0
extends d1 {
    public final d<h> h;

    public x0(h.k.f f2, p<? super x, ? super d<? super h>, ? extends Object> p2) {
        super(f2, false);
        this.h = h.i.J(p2, this, this);
    }

    @Override
    public void R() {
        d<h> d2 = this.h;
        try {
            f.a(h.i.B0(d2), (Object)h.a, null);
            return;
        }
        catch (Throwable throwable) {
            this.e(h.i.K(throwable));
            return;
        }
    }
}

