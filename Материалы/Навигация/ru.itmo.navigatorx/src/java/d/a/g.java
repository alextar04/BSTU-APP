/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.b0
 *  d.a.c
 *  d.a.g0
 *  d.a.h
 *  d.a.i
 *  d.a.r0$a
 *  f.b.k.h
 *  h.d
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$b
 *  h.k.i.a
 *  h.k.j.a.d
 *  h.m.a.l
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a;

import d.a.a.f;
import d.a.a1;
import d.a.b0;
import d.a.b1;
import d.a.c;
import d.a.d0;
import d.a.e;
import d.a.g0;
import d.a.g1;
import d.a.h;
import d.a.i;
import d.a.o;
import d.a.p;
import d.a.r0;
import d.a.s;
import d.a.v;
import f.b.k.h;
import h.k.f;
import h.k.i.a;
import h.k.j.a.d;
import h.m.a.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class g<T>
extends b0<T>
implements Object<T>,
d {
    public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(g.class, (String)"_decision");
    public static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, (String)"_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;
    public final h.k.f h;
    public final h.k.d<T> i;

    public g(h.k.d<? super T> d2, int n2) {
        super(n2);
        this.i = d2;
        this.h = d2.d();
        this._decision = 0;
        this._state = c.e;
        this._parentHandle = null;
    }

    public void a(Object object, Throwable throwable) {
        Object object2;
        while (!((object2 = this._state) instanceof b1)) {
            if (object2 instanceof p) {
                return;
            }
            if (object2 instanceof o) {
                o o2 = (o)object2;
                boolean bl = o2.e != null;
                if (bl ^ true) {
                    l<Throwable, h.h> l2;
                    o o3 = o.a(o2, null, null, null, null, throwable, 15);
                    if (!k.compareAndSet((Object)this, object2, (Object)o3)) continue;
                    e e2 = o2.b;
                    if (e2 != null) {
                        this.j(e2, throwable);
                    }
                    if ((l2 = o2.c) != null) {
                        this.k(l2, throwable);
                    }
                    return;
                }
                throw new IllegalStateException("Must be called at most once".toString());
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
            o o4 = new o(object2, null, null, null, throwable, 14);
            if (!atomicReferenceFieldUpdater.compareAndSet((Object)this, object2, (Object)o4)) continue;
            return;
        }
        throw new IllegalStateException("Not completed".toString());
    }

    public final h.k.d<T> b() {
        return this.i;
    }

    public Throwable c(Object object) {
        Throwable throwable = super.c(object);
        if (throwable != null) {
            return throwable;
        }
        return null;
    }

    public h.k.f d() {
        return this.h;
    }

    public void e(Object object) {
        Object object2;
        Throwable throwable = h.d.a((Object)object);
        if (throwable != null) {
            object = new p(throwable, false, 2);
        }
        int n2 = this.g;
        while ((object2 = this._state) instanceof b1) {
            Object object3;
            b1 b12 = (b1)object2;
            if (!(object instanceof p) && h.i.E0(n2) && b12 instanceof e) {
                if (!(b12 instanceof e)) {
                    b12 = null;
                }
                e e2 = (e)b12;
                object3 = new o(object, e2, null, null, null, 16);
            } else {
                object3 = object;
            }
            if (!k.compareAndSet((Object)this, object2, object3)) continue;
            this.m();
            this.n(n2);
            return;
        }
        if (object2 instanceof h) {
            h h2 = (h)object2;
            if (h2 != null) {
                if (h.c.compareAndSet((Object)h2, 0, 1)) {
                    return;
                }
            } else {
                throw null;
            }
        }
        throw new IllegalStateException(c.b.a.a.a.i("Already resumed, but proposed with update ", object).toString());
    }

    public <T> T f(Object object) {
        if (object instanceof o) {
            object = ((o)object).a;
        }
        return (T)object;
    }

    public Object h() {
        return this._state;
    }

    public final void i(l<? super Throwable, h.h> l2, Throwable throwable) {
        try {
            l2.f((Object)throwable);
            return;
        }
        catch (Throwable throwable2) {
            h.k.f f2 = this.h;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception in invokeOnCancellation handler for ");
            stringBuilder.append((Object)this);
            h.i.y0(f2, (Throwable)new s(stringBuilder.toString(), throwable2));
            return;
        }
    }

    public final void j(e e2, Throwable throwable) {
        try {
            e2.a(throwable);
            return;
        }
        catch (Throwable throwable2) {
            h.k.f f2 = this.h;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception in invokeOnCancellation handler for ");
            stringBuilder.append((Object)this);
            h.i.y0(f2, (Throwable)new s(stringBuilder.toString(), throwable2));
            return;
        }
    }

    public final void k(l<? super Throwable, h.h> l2, Throwable throwable) {
        try {
            l2.f((Object)throwable);
            return;
        }
        catch (Throwable throwable2) {
            h.k.f f2 = this.h;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception in resume onCancellation handler for ");
            stringBuilder.append((Object)this);
            h.i.y0(f2, (Throwable)new s(stringBuilder.toString(), throwable2));
            return;
        }
    }

    public boolean l(Throwable throwable) {
        h h2;
        Object object;
        boolean bl;
        e e2;
        do {
            if ((object = this._state) instanceof b1) continue;
            return false;
        } while (!k.compareAndSet((Object)this, object, (Object)(h2 = new h((h.k.d)this, throwable, bl = object instanceof e))));
        if (!bl) {
            object = null;
        }
        if ((e2 = (e)object) != null) {
            this.j(e2, throwable);
        }
        this.m();
        this.n(this.g);
        return true;
    }

    public final void m() {
        if (!this.q()) {
            d0 d02 = (d0)this._parentHandle;
            if (d02 != null) {
                d02.b();
            }
            this._parentHandle = a1.e;
        }
    }

    public final void n(int n2) {
        boolean bl;
        block13 : {
            do {
                int n3;
                if ((n3 = this._decision) == 0) continue;
                if (n3 == 1) {
                    bl = false;
                    break block13;
                }
                throw new IllegalStateException("Already resumed".toString());
            } while (!j.compareAndSet((Object)this, 0, 2));
            bl = true;
        }
        if (bl) {
            return;
        }
        h.k.d d2 = this.b();
        boolean bl2 = false;
        if (n2 == 4) {
            bl2 = true;
        }
        if (!bl2 && d2 instanceof d.a.a.e && h.i.E0(n2) == h.i.E0(this.g)) {
            v v2 = ((d.a.a.e)d2).k;
            h.k.f f2 = d2.d();
            if (v2.M(f2)) {
                v2.L(f2, (Runnable)this);
                return;
            }
            g0 g02 = g1.a();
            if (g02.R()) {
                g02.P((b0)this);
                return;
            }
            g02.Q(true);
            try {
                boolean bl3;
                h.i.u1(this, this.b(), true);
                while (bl3 = g02.S()) {
                }
            }
            catch (Throwable throwable) {
                this.g(throwable, null);
            }
            return;
            {
                finally {
                    g02.N(true);
                }
            }
        }
        h.i.u1(this, d2, bl2);
    }

    public final Object o() {
        r0 r02;
        boolean bl;
        block5 : {
            this.s();
            do {
                int n2;
                if ((n2 = this._decision) == 0) continue;
                if (n2 == 2) {
                    bl = false;
                    break block5;
                }
                throw new IllegalStateException("Already suspended".toString());
            } while (!j.compareAndSet((Object)this, 0, 1));
            bl = true;
        }
        if (bl) {
            return a.e;
        }
        Object object = this._state;
        if (object instanceof p) {
            throw ((p)object).a;
        }
        if (h.i.E0(this.g) && (r02 = (r0)this.h.get((f.b)r0.d)) != null && !r02.c()) {
            CancellationException cancellationException = r02.m();
            this.a(object, (Throwable)cancellationException);
            throw cancellationException;
        }
        return this.f(object);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void p(l<? super Throwable, h.h> var1_1) {
        var2_2 = (e)var1_1;
        do lbl-1000: // 4 sources:
        {
            block9 : {
                if (!((var3_3 = this._state) instanceof c)) break block9;
                if (!g.k.compareAndSet((Object)this, var3_3, (Object)var2_2)) ** GOTO lbl-1000
                return;
            }
            if (var3_3 instanceof e) {
                this.r(var1_1, var3_3);
                throw null;
            }
            var4_4 = var3_3 instanceof p;
            var5_5 = 1;
            if (var4_4) {
                var9_9 = (p)var3_3;
                if (var9_9 == null) throw null;
                if (!p.b.compareAndSet((Object)var9_9, 0, var5_5)) {
                    this.r(var1_1, var3_3);
                    throw null;
                }
                if (var3_3 instanceof h == false) return;
                if (!var4_4) {
                    var3_3 = null;
                }
                var10_10 = (p)var3_3;
                var11_11 = null;
                if (var10_10 != null) {
                    var11_11 = var10_10.a;
                }
                this.i(var1_1, var11_11);
                return;
            }
            if (!(var3_3 instanceof o)) continue;
            var7_7 = (o)var3_3;
            if (var7_7.b != null) {
                this.r(var1_1, var3_3);
                throw null;
            }
            if (var7_7.e == null) {
                var5_5 = 0;
            }
            if (var5_5 != 0) {
                this.i(var1_1, var7_7.e);
                return;
            }
            var8_8 = o.a(var7_7, null, var2_2, null, null, null, 29);
            if (!g.k.compareAndSet((Object)this, var3_3, (Object)var8_8)) ** GOTO lbl-1000
            return;
        } while (!g.k.compareAndSet((Object)this, var3_3, (Object)(var6_6 = new o(var3_3, var2_2, null, null, null, 28))));
    }

    public final boolean q() {
        Object object;
        boolean bl;
        h.k.d<T> d2 = this.i;
        return d2 instanceof d.a.a.e && (bl = (object = ((d.a.a.e)d2)._reusableCancellableContinuation) != null && (!(object instanceof g) || object == this));
    }

    public final void r(l<? super Throwable, h.h> l2, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It's prohibited to register multiple handlers, tried to register ");
        stringBuilder.append(l2);
        stringBuilder.append(", already has ");
        stringBuilder.append(object);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void s() {
        boolean bl = true ^ this._state instanceof b1;
        boolean bl2 = this.g == 2;
        if (bl2) {
            d.a.a.e e2;
            h.k.d<T> d2 = this.i;
            if (!(d2 instanceof d.a.a.e)) {
                d2 = null;
            }
            if ((e2 = (d.a.a.e)d2) != null) {
                Throwable throwable;
                block9 : {
                    Object object;
                    d.a.a.p p2;
                    while ((object = e2._reusableCancellableContinuation) == (p2 = f.b)) {
                        if (!d.a.a.e.m.compareAndSet((Object)e2, (Object)p2, (Object)this)) continue;
                        throwable = null;
                        break block9;
                    }
                    if (object == null) {
                        throwable = null;
                    } else {
                        if (!(object instanceof Throwable)) throw new IllegalStateException(c.b.a.a.a.i("Inconsistent state ", object).toString());
                        if (!d.a.a.e.m.compareAndSet((Object)e2, object, null)) throw new IllegalArgumentException("Failed requirement.".toString());
                        throwable = (Throwable)object;
                    }
                }
                if (throwable != null) {
                    if (bl) return;
                    this.l(throwable);
                    return;
                }
            }
        }
        if (bl) {
            return;
        }
        if ((d0)this._parentHandle != null) {
            return;
        }
        r0 r02 = (r0)this.i.d().get((f.b)r0.d);
        if (r02 == null) return;
        d0 d02 = h.i.D0(r02, true, false, (l)new i(r02, this), 2, null);
        this._parentHandle = d02;
        if (!(true ^ this._state instanceof b1)) return;
        if (this.q()) return;
        d02.b();
        this._parentHandle = a1.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CancellableContinuation");
        stringBuilder.append('(');
        stringBuilder.append(h.i.Q1(this.i));
        stringBuilder.append("){");
        stringBuilder.append(this._state);
        stringBuilder.append("}@");
        stringBuilder.append(h.i.g0(this));
        return stringBuilder.toString();
    }
}

