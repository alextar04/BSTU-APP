/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  h.h
 *  h.m.a.l
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package d.a;

import c.b.a.a.a;
import d.a.r0;
import d.a.u0;
import f.b.k.h;
import h.h;
import h.m.a.l;

public final class q0
extends u0<r0> {
    public final l<Throwable, h> i;

    public q0(r0 r02, l<? super Throwable, h> l2) {
        super(r02);
        this.i = l2;
    }

    public Object f(Object object) {
        Throwable throwable = (Throwable)object;
        this.i.f((Object)throwable);
        return h.a;
    }

    public void l(Throwable throwable) {
        this.i.f((Object)throwable);
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("InvokeOnCompletion[");
        stringBuilder.append(q0.class.getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0(this));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

