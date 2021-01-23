/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  k.a.d
 *  k.a.e
 *  k.a.n
 *  k.a.t
 *  k.a.v
 */
package k.a;

import k.a.d;
import k.a.e;
import k.a.i0;
import k.a.n;
import k.a.t;
import k.a.v;

public abstract class k0 {
    public d b() {
        this.g(i0.j);
        return (d)this;
    }

    public e c() {
        this.g(i0.k);
        return (e)this;
    }

    public n d() {
        this.g(i0.i);
        return (n)this;
    }

    public v e() {
        this.g(i0.u);
        return (v)this;
    }

    public abstract i0 f();

    public final void g(i0 i02) {
        if (this.f() == i02) {
            return;
        }
        Object[] arrobject = new Object[]{i02, this.f()};
        throw new t(String.format((String)"Value expected to be of type %s is of unexpected type %s", (Object[])arrobject));
    }
}

