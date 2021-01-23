/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  h.k.f$a$a
 *  h.k.f$b
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 */
package h.k;

import h.k.f;
import h.m.a.p;
import h.m.b.j;

public abstract class a
implements f.a {
    public final f.b<?> key;

    public a(f.b<?> b2) {
        j.e(b2, (String)"key");
        this.key = b2;
    }

    public <R> R fold(R r2, p<? super R, ? super f.a, ? extends R> p2) {
        j.e(p2, (String)"operation");
        return (R)f.a.a.a((f.a)this, r2, p2);
    }

    @Override
    public <E extends f.a> E get(f.b<E> b2) {
        j.e(b2, (String)"key");
        return (E)f.a.a.b((f.a)this, b2);
    }

    @Override
    public f.b<?> getKey() {
        return this.key;
    }

    public f minusKey(f.b<?> b2) {
        j.e(b2, (String)"key");
        return f.a.a.c((f.a)this, b2);
    }

    public f plus(f f2) {
        j.e((Object)f2, (String)"context");
        return f.a.a.d((f.a)this, (f)f2);
    }
}

