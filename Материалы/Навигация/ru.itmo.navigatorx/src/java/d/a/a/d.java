/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.v0
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.a;

import d.a.a.c;
import d.a.a.h;
import d.a.a.i;
import d.a.a.m;
import d.a.v0;
import h.m.b.j;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class d<T>
extends m {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"_consensus");
    public volatile Object _consensus = c.a;

    @Override
    public final Object a(Object object) {
        Object object2 = this._consensus;
        Object object3 = c.a;
        boolean bl = true;
        if (object2 == object3) {
            v0.c c2 = this;
            (i)object;
            boolean bl2 = c2.d.y() == c2.e ? bl : false;
            object2 = bl2 ? null : h.a;
            Object object4 = this._consensus;
            Object object5 = c.a;
            if (object4 != object5) {
                object2 = object4;
            } else if (!a.compareAndSet((Object)this, object5, object2)) {
                object2 = this._consensus;
            }
        }
        i.a a2 = this;
        i i2 = (i)object;
        if (object2 != null) {
            bl = false;
        }
        i i3 = bl ? a2.c : a2.b;
        if (i3 != null && i.e.compareAndSet((Object)i2, (Object)a2, (Object)i3) && bl) {
            i i4 = a2.c;
            i i5 = a2.b;
            j.c((Object)i5);
            i4.g(i5);
        }
        return object2;
    }
}

