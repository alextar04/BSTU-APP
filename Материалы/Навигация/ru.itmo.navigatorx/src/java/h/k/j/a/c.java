/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.d
 *  h.k.e$a
 *  h.k.f
 *  h.k.f$b
 *  h.k.j.a.b
 *  h.m.b.j
 *  java.lang.Object
 */
package h.k.j.a;

import h.k.d;
import h.k.e;
import h.k.f;
import h.k.j.a.a;
import h.k.j.a.b;
import h.m.b.j;

public abstract class c
extends a {
    public transient d<Object> f;
    public final f g;

    public c(d<Object> d2) {
        f f2 = d2 != null ? d2.d() : null;
        super(d2);
        this.g = f2;
    }

    public c(d<Object> d2, f f2) {
        super(d2);
        this.g = f2;
    }

    public f d() {
        f f2 = this.g;
        j.c((Object)f2);
        return f2;
    }

    @Override
    public void j() {
        d<Object> d2 = this.f;
        if (d2 != null && d2 != this) {
            f.a a2 = this.d().get((f.b)e.b);
            j.c((Object)a2);
            ((e)a2).f(d2);
        }
        this.f = b.e;
    }
}

