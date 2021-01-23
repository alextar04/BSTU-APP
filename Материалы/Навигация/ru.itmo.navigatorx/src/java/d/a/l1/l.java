/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.l1.j
 *  h.h
 *  h.k.d
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.l1;

import d.a.a.p;
import d.a.l1.j;
import d.a.l1.k;
import d.a.l1.n.b;
import d.a.l1.n.c;
import h.h;
import h.k.d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class l
extends c<j<?>> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, (String)"_state");
    public volatile Object _state = null;

    @Override
    public boolean a(Object object) {
        (j)object;
        if (this._state != null) {
            return false;
        }
        this._state = k.a;
        return true;
    }

    @Override
    public d[] b(Object object) {
        (j)object;
        this._state = null;
        return b.a;
    }
}

