/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.f0
 *  d.a.r
 *  d.a.v0
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a;

import d.a.a.i;
import d.a.a.m;
import d.a.a.n;
import d.a.d0;
import d.a.f0;
import d.a.n0;
import d.a.r;
import d.a.r0;
import d.a.v0;
import d.a.w0;
import d.a.z0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class u0<J extends r0>
extends r
implements d0,
n0 {
    public final J h;

    public u0(J j2) {
        this.h = j2;
    }

    @Override
    public void b() {
        J j2 = this.h;
        if (j2 != null) {
            Object object;
            v0 v02 = (v0)j2;
            while ((object = v02.y()) instanceof u0) {
                if (object != this) {
                    return;
                }
                if (!v0.e.compareAndSet((Object)v02, object, (Object)w0.g)) continue;
                return;
            }
            if (object instanceof n0 && ((n0)object).e() != null) {
                block7 : {
                    Object object2;
                    i i2;
                    n n2;
                    do {
                        if ((object2 = ((i)((Object)this)).h()) instanceof n) {
                            return;
                        }
                        if (object2 == this) {
                            (i)object2;
                            return;
                        }
                        if (object2 == null) break block7;
                        i2 = (i)object2;
                        n2 = (n)i2._removedRef;
                        if (n2 != null) continue;
                        n2 = new n(i2);
                        i.g.lazySet((Object)i2, (Object)n2);
                    } while (!i.e.compareAndSet((Object)this, object2, (Object)n2));
                    i2.a(null);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public z0 e() {
        return null;
    }
}

