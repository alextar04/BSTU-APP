/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.b0
 *  d.a.g0
 *  f.b.k.h
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.j.a.d
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.a;

import d.a.a.a;
import d.a.a.f;
import d.a.a.p;
import d.a.b0;
import d.a.g0;
import d.a.g1;
import d.a.q;
import d.a.v;
import f.b.k.h;
import h.h;
import h.k.f;
import h.k.j.a.d;
import h.m.a.l;
import h.m.b.j;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class e<T>
extends b0<T>
implements d,
h.k.d<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, (String)"_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;
    public Object h;
    public final d i;
    public final Object j;
    public final v k;
    public final h.k.d<T> l;

    public e(v v2, h.k.d<? super T> d2) {
        super(-1);
        this.k = v2;
        this.l = d2;
        this.h = f.a;
        if (!(d2 instanceof d)) {
            d2 = null;
        }
        this.i = (d)d2;
        Object object = this.d().fold((Object)0, a.b);
        j.c((Object)object);
        this.j = object;
        this._reusableCancellableContinuation = null;
    }

    public void a(Object object, Throwable throwable) {
        if (object instanceof q) {
            ((q)object).b.f((Object)throwable);
        }
    }

    public h.k.d<T> b() {
        return this;
    }

    public h.k.f d() {
        return this.l.d();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void e(Object object) {
        h.k.f f2 = this.l.d();
        Object object2 = h.i.S1(object, null);
        if (this.k.M(f2)) {
            this.h = object2;
            this.g = 0;
            this.k.L(f2, (Runnable)this);
            return;
        }
        g0 g02 = g1.a();
        if (g02.R()) {
            this.h = object2;
            this.g = 0;
            g02.P((b0)this);
            return;
        }
        g02.Q(true);
        h.k.f f3 = this.d();
        Object object3 = a.c(f3, this.j);
        this.l.e(object);
        try {
            a.a(f3, object3);
            while (g02.S()) {
            }
            return;
            catch (Throwable throwable) {
                a.a(f3, object3);
                throw throwable;
            }
        }
        catch (Throwable throwable) {
            try {
                this.g(throwable, null);
                return;
            }
            finally {
                g02.N(true);
            }
        }
    }

    public Object h() {
        Object object = this.h;
        this.h = f.a;
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("DispatchedContinuation[");
        stringBuilder.append((Object)this.k);
        stringBuilder.append(", ");
        stringBuilder.append(h.i.Q1(this.l));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

