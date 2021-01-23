/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  h.k.d
 *  h.k.e$a
 *  h.k.f
 *  h.k.f$b
 *  h.k.h
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a;

import d.a.a.e;
import d.a.a1;
import d.a.d0;
import d.a.g;
import d.a.u;
import f.b.k.h;
import h.k.b;
import h.k.d;
import h.k.e;
import h.k.f;
import h.m.a.l;
import h.m.b.j;

public abstract class v
extends h.k.a
implements h.k.e {
    public static final a e = new a(null);

    public v() {
        super((f.b<?>)h.k.e.b);
    }

    public abstract void L(f var1, Runnable var2);

    public boolean M(f f2) {
        return true;
    }

    @Override
    public void f(d<?> d2) {
        g g2;
        Object object = ((e)d2)._reusableCancellableContinuation;
        if (!(object instanceof g)) {
            object = null;
        }
        if ((g2 = (g)object) != null) {
            d0 d02 = (d0)g2._parentHandle;
            if (d02 != null) {
                d02.b();
            }
            g2._parentHandle = a1.e;
        }
    }

    @Override
    public <E extends f.a> E get(f.b<E> b2) {
        v v2;
        j.e(b2, (String)"key");
        if (b2 instanceof b) {
            b b3 = (b)b2;
            f.b<?> b4 = this.getKey();
            j.e(b4, (String)"key");
            boolean bl = b4 == b3 || b3.a == b4;
            v2 = null;
            if (bl) {
                j.e((Object)this, (String)"element");
                f.a a2 = (f.a)b3.b.f((Object)this);
                if (!(a2 instanceof f.a)) {
                    return null;
                }
                return (E)a2;
            }
        } else {
            e.a a3 = h.k.e.b;
            v2 = null;
            if (a3 == b2) {
                v2 = this;
            }
        }
        return (E)v2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public f minusKey(f.b<?> b2) {
        j.e(b2, (String)"key");
        if (!(b2 instanceof b)) {
            if (h.k.e.b != b2) return this;
            return h.k.h.e;
        }
        b b3 = (b)b2;
        f.b<?> b4 = this.getKey();
        j.e(b4, (String)"key");
        boolean bl = b4 == b3 || b3.a == b4;
        if (!bl) return this;
        if (b3.a(this) == null) return this;
        return h.k.h.e;
    }

    @Override
    public final <T> d<T> p(d<? super T> d2) {
        return new e<T>(this, d2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0(this));
        return stringBuilder.toString();
    }

    public static final class a
    extends b<h.k.e, v> {
        public a(h.m.b.f f2) {
            super(h.k.e.b, u.f);
        }
    }

}

