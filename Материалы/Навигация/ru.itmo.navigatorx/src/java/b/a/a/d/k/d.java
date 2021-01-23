/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Boolean
 *  java.lang.Object
 */
package b.a.a.d.k;

import h.m.a.l;
import h.m.a.p;
import h.m.b.j;
import h.m.b.k;

public final class d
extends k
implements p<Model, Model, Boolean> {
    public final /* synthetic */ l f;
    public final /* synthetic */ l g;

    public d(l l2, l l3) {
        this.f = l2;
        this.g = l3;
        super(2);
    }

    public Object c(Object object, Object object2) {
        boolean bl;
        boolean bl2 = j.a((Object)this.f.f(object), (Object)this.f.f(object2));
        if (!(bl2 ^ (bl = true)) && !(bl ^ j.a((Object)this.g.f(object), (Object)this.g.f(object2)))) {
            bl = false;
        }
        return bl;
    }
}

