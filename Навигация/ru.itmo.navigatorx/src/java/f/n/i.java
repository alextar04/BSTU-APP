/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LifecycleCoroutineScopeImpl
 *  f.n.g
 *  f.n.g$b
 *  f.n.l
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.j.a.e
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package f.n;

import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import d.a.x;
import f.b.k.h;
import f.n.g;
import f.n.l;
import f.n.o;
import h.h;
import h.k.d;
import h.k.f;
import h.k.j.a.e;
import h.m.a.p;
import h.m.b.j;

@e(c="androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f="Lifecycle.kt", l={}, m="invokeSuspend")
public final class i
extends h.k.j.a.h
implements p<x, d<? super h>, Object> {
    public x i;
    public final /* synthetic */ LifecycleCoroutineScopeImpl j;

    public i(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, d d2) {
        this.j = lifecycleCoroutineScopeImpl;
        super(2, (d<Object>)d2);
    }

    public final Object c(Object object, Object object2) {
        d d2 = (d)object2;
        j.f((Object)d2, (String)"completion");
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.j;
        d2.d();
        x x2 = (x)object;
        h.i.O1((Object)h.a);
        if (((o)lifecycleCoroutineScopeImpl.e).c.compareTo((Enum)g.b.f) >= 0) {
            lifecycleCoroutineScopeImpl.e.a((l)lifecycleCoroutineScopeImpl);
        } else {
            h.i.j(x2.s(), null, 1, null);
        }
        return h.a;
    }

    @Override
    public final d<h> g(Object object, d<?> d2) {
        j.f(d2, (String)"completion");
        i i2 = new i(this.j, d2);
        i2.i = (x)object;
        return i2;
    }

    @Override
    public final Object i(Object object) {
        h.i.O1(object);
        x x2 = this.i;
        if (((o)this.j.e).c.compareTo((Enum)g.b.f) >= 0) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.j;
            lifecycleCoroutineScopeImpl.e.a((l)lifecycleCoroutineScopeImpl);
        } else {
            h.i.j(x2.s(), null, 1, null);
        }
        return h.a;
    }
}

