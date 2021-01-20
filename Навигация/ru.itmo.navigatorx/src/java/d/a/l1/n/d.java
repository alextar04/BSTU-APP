/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.l1.n.d$a
 *  h.k.f
 *  h.k.f$a$a
 *  h.k.f$b
 *  h.m.a.p
 *  h.m.b.f
 *  java.lang.Object
 *  java.lang.Throwable
 */
package d.a.l1.n;

import d.a.l1.n.d;
import h.k.f;
import h.m.a.p;

/*
 * Exception performing whole class analysis.
 */
public final class d
implements f.a {
    public static final a g;
    public final f.b<?> e;
    public final Throwable f;

    public static {
        g = new /* Unavailable Anonymous Inner Class!! */;
    }

    public d(Throwable throwable) {
        this.f = throwable;
        this.e = g;
    }

    public <R> R fold(R r2, p<? super R, ? super f.a, ? extends R> p2) {
        return (R)f.a.a.a((f.a)this, r2, p2);
    }

    @Override
    public <E extends f.a> E get(f.b<E> b2) {
        return (E)f.a.a.b((f.a)this, b2);
    }

    @Override
    public f.b<?> getKey() {
        return this.e;
    }

    public f minusKey(f.b<?> b2) {
        return f.a.a.c((f.a)this, b2);
    }

    public f plus(f f2) {
        return f.a.a.d((f.a)this, (f)f2);
    }
}

