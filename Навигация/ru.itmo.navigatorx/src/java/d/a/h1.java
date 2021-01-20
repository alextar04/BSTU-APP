/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  h.k.f$b
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package d.a;

import d.a.i1;
import d.a.v;
import h.k.f;

public final class h1
extends v {
    public static final h1 f = new h1();

    @Override
    public void L(f f2, Runnable runnable) {
        if ((i1)f2.get((f.b)i1.e) != null) {
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override
    public boolean M(f f2) {
        return false;
    }

    @Override
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}

