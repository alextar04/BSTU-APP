/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  h.k.f$b
 *  h.m.a.l
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 */
package h.k;

import h.k.f;
import h.m.a.l;
import h.m.b.j;

public abstract class b<B extends f.a, E extends B>
implements f.b<E> {
    public final f.b<?> a;
    public final l<f.a, E> b;

    public b(f.b<B> object, l<? super f.a, ? extends E> l2) {
        j.e(object, (String)"baseKey");
        j.e(l2, (String)"safeCast");
        this.b = l2;
        if (object instanceof b) {
            object = ((b)object).a;
        }
        this.a = object;
    }

    public final E a(f.a a2) {
        j.e((Object)a2, (String)"element");
        return (E)((f.a)this.b.f((Object)a2));
    }
}

