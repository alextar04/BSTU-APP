/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.m.a.l
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package d.a;

import c.b.a.a.a;
import d.a.r0;
import d.a.t0;
import f.b.k.h;
import h.h;
import h.m.a.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class p0
extends t0<r0> {
    public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(p0.class, (String)"_invoked");
    public volatile int _invoked;
    public final l<Throwable, h> i;

    public p0(r0 r02, l<? super Throwable, h> l2) {
        super(r02);
        this.i = l2;
        this._invoked = 0;
    }

    @Override
    public void l(Throwable throwable) {
        if (j.compareAndSet((Object)this, 0, 1)) {
            this.i.f((Object)throwable);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = a.c("InvokeOnCancelling[");
        stringBuilder.append(p0.class.getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0(this));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

