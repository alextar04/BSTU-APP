/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package d.a;

import c.b.a.a.a;
import d.a.c1;
import d.a.j;
import d.a.l;
import d.a.t0;
import d.a.u0;
import d.a.v0;
import h.h;

public final class k
extends t0<v0>
implements j {
    public final l i;

    public k(v0 v02, l l2) {
        super(v02);
        this.i = l2;
    }

    @Override
    public boolean d(Throwable throwable) {
        return ((v0)this.h).l(throwable);
    }

    @Override
    public void l(Throwable throwable) {
        this.i.v((c1)this.h);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = a.c("ChildHandle[");
        stringBuilder.append((Object)this.i);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

