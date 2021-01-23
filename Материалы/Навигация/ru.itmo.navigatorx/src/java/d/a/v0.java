/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.f
 *  h.k.f$a$a
 *  h.k.f$b
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a;

import d.a.a.i;
import d.a.a.m;
import d.a.a1;
import d.a.c1;
import d.a.d0;
import d.a.f0;
import d.a.j;
import d.a.k;
import d.a.l;
import d.a.m0;
import d.a.n0;
import d.a.o0;
import d.a.p;
import d.a.p0;
import d.a.q0;
import d.a.r0;
import d.a.s;
import d.a.s0;
import d.a.t0;
import d.a.u0;
import d.a.v0;
import d.a.w0;
import d.a.z0;
import f.b.k.h;
import h.h;
import h.k.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class v0
implements r0,
l,
c1 {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, (String)"_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    public v0(boolean bl) {
        f0 f02 = bl ? w0.g : w0.f;
        this._state = f02;
        this._parentHandle = null;
    }

    public void A(Throwable throwable) {
        throw throwable;
    }

    public final void C(r0 r02) {
        if (r02 == null) {
            this._parentHandle = a1.e;
            return;
        }
        r02.start();
        j j2 = r02.J(this);
        this._parentHandle = j2;
        if (true ^ this.y() instanceof n0) {
            j2.b();
            this._parentHandle = a1.e;
        }
    }

    public boolean D() {
        return false;
    }

    public final u0<?> E(h.m.a.l<? super Throwable, h> l2, boolean bl) {
        if (bl) {
            h.m.a.l<? super Throwable, h> l3 = !(l2 instanceof t0) ? null : l2;
            t0 t02 = (t0)l3;
            if (t02 != null) {
                return t02;
            }
            return new p0(this, l2);
        }
        h.m.a.l<? super Throwable, h> l4 = !(l2 instanceof u0) ? null : l2;
        u0 u02 = (u0)l4;
        if (u02 != null) {
            return u02;
        }
        return new q0(this, l2);
    }

    public String F() {
        return this.getClass().getSimpleName();
    }

    public final k G(i i2) {
        while (i2.k()) {
            i2 = i2.j();
        }
        do {
            if ((i2 = i2.i()).k()) {
                continue;
            }
            if (i2 instanceof k) {
                return (k)i2;
            }
            if (i2 instanceof z0) break;
        } while (true);
        return null;
    }

    public final void H(z0 z02, Throwable throwable) {
        s s2 = null;
        Object object = z02.h();
        if (object != null) {
            i i2 = (i)object;
            while (true ^ h.m.b.j.a((Object)i2, (Object)z02)) {
                if (i2 instanceof t0) {
                    u0 u02 = (u0)i2;
                    try {
                        u02.l(throwable);
                    }
                    catch (Throwable throwable2) {
                        if (s2 != null) {
                            h.i.a(s2, throwable2);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Exception in completion handler ");
                        stringBuilder.append((Object)u02);
                        stringBuilder.append(" for ");
                        stringBuilder.append((Object)this);
                        s2 = new s(stringBuilder.toString(), throwable2);
                    }
                }
                i2 = i2.i();
            }
            if (s2 != null) {
                this.A((Throwable)s2);
            }
            this.i(throwable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public void I(Object object) {
    }

    @Override
    public final j J(l l2) {
        d0 d02 = h.i.D0(this, true, false, new k(this, l2), 2, null);
        if (d02 != null) {
            return (j)d02;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public void K() {
    }

    public final void L(u0<?> u02) {
        z0 z02 = new z0();
        i.f.lazySet((Object)z02, u02);
        i.e.lazySet((Object)z02, u02);
        while (u02.h() == u02) {
            if (!i.e.compareAndSet(u02, u02, (Object)z02)) continue;
            z02.g(u02);
            break;
        }
        i i2 = u02.i();
        e.compareAndSet((Object)this, u02, (Object)i2);
    }

    public final String M(Object object) {
        boolean bl = object instanceof b;
        String string = "Active";
        if (bl) {
            b b2 = object;
            if (b2.d()) {
                return "Cancelling";
            }
            if (b2._isCompleting != 0) {
                return "Completing";
            }
        } else {
            if (object instanceof n0) {
                if (((n0)object).c()) {
                    return string;
                }
                return "New";
            }
            if (object instanceof p) {
                return "Cancelled";
            }
            string = "Completed";
        }
        return string;
    }

    public final CancellationException N(Throwable throwable, String string) {
        Throwable throwable2 = !(throwable instanceof CancellationException) ? null : throwable;
        CancellationException cancellationException = (CancellationException)throwable2;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (string == null) {
            string = this.k();
        }
        return new s0(string, throwable, this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object O(Object object, Object object2) {
        k k2;
        n0 n02;
        k k3;
        if (!(object instanceof n0)) {
            return w0.a;
        }
        boolean bl = object instanceof f0;
        int n2 = 1;
        if ((bl || object instanceof u0) && !(object instanceof k) && !(object2 instanceof p)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            n0 n03 = (n0)object;
            Object object3 = object2 instanceof n0 ? new o0((n0)object2) : object2;
            if (!atomicReferenceFieldUpdater.compareAndSet((Object)this, (Object)n03, object3)) {
                n2 = 0;
            } else {
                this.I(object2);
                this.n(n03, object2);
            }
            if (n2 == 0) return w0.c;
            return object2;
        }
        n0 n04 = (n0)object;
        z0 z02 = this.w(n04);
        if (z02 == null) return w0.c;
        n0 n05 = !(n04 instanceof b) ? null : n04;
        b b2 = n05;
        if (b2 == null) {
            b2 = new n0(z02, false, null){
                public volatile Object _exceptionsHolder;
                public volatile int _isCompleting;
                public volatile Object _rootCause;
                public final z0 e;
                {
                    this.e = z02;
                    this._isCompleting = bl ? 1 : 0;
                    this._rootCause = throwable;
                    this._exceptionsHolder = null;
                }

                public final void a(Throwable throwable) {
                    Throwable throwable2 = (Throwable)this._rootCause;
                    if (throwable2 == null) {
                        this._rootCause = throwable;
                        return;
                    }
                    if (throwable == throwable2) {
                        return;
                    }
                    Object object = this._exceptionsHolder;
                    if (object == null) {
                        this._exceptionsHolder = throwable;
                        return;
                    }
                    if (object instanceof Throwable) {
                        if (throwable == object) {
                            return;
                        }
                        ArrayList<Throwable> arrayList = this.b();
                        arrayList.add(object);
                        arrayList.add((Object)throwable);
                        this._exceptionsHolder = arrayList;
                        return;
                    }
                    if (object instanceof ArrayList) {
                        ((ArrayList)object).add((Object)throwable);
                        return;
                    }
                    throw new IllegalStateException(c.b.a.a.a.i("State is ", object).toString());
                }

                public final ArrayList<Throwable> b() {
                    return new ArrayList(4);
                }

                @Override
                public boolean c() {
                    return (Throwable)this._rootCause == null;
                }

                public final boolean d() {
                    return (Throwable)this._rootCause != null;
                }

                @Override
                public z0 e() {
                    return this.e;
                }

                public final boolean f() {
                    return this._exceptionsHolder == w0.e;
                }

                public final List<Throwable> g(Throwable throwable) {
                    Object object;
                    block8 : {
                        ArrayList<Throwable> arrayList;
                        block6 : {
                            block7 : {
                                block5 : {
                                    object = this._exceptionsHolder;
                                    if (object != null) break block5;
                                    arrayList = this.b();
                                    break block6;
                                }
                                if (!(object instanceof Throwable)) break block7;
                                ArrayList<Throwable> arrayList2 = this.b();
                                arrayList2.add(object);
                                arrayList = arrayList2;
                                break block6;
                            }
                            if (!(object instanceof ArrayList)) break block8;
                            arrayList = (ArrayList<Throwable>)object;
                        }
                        Throwable throwable2 = (Throwable)this._rootCause;
                        if (throwable2 != null) {
                            arrayList.add(0, (Object)throwable2);
                        }
                        if (throwable != null && true ^ h.m.b.j.a((Object)throwable, (Object)throwable2)) {
                            arrayList.add((Object)throwable);
                        }
                        this._exceptionsHolder = w0.e;
                        return arrayList;
                    }
                    throw new IllegalStateException(c.b.a.a.a.i("State is ", object).toString());
                }

                public String toString() {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Finishing[cancelling=");
                    stringBuilder.append(this.d());
                    stringBuilder.append(", completing=");
                    stringBuilder.append((boolean)this._isCompleting);
                    stringBuilder.append(", rootCause=");
                    stringBuilder.append((Object)((Throwable)this._rootCause));
                    stringBuilder.append(", exceptions=");
                    stringBuilder.append(this._exceptionsHolder);
                    stringBuilder.append(", list=");
                    stringBuilder.append((Object)this.e);
                    stringBuilder.append(']');
                    return stringBuilder.toString();
                }
            };
        }
        b b3 = b2;
        // MONITORENTER : b3
        if (b2._isCompleting != 0) {
            d.a.a.p p2 = w0.a;
            // MONITOREXIT : b3
            return p2;
        }
        b2._isCompleting = n2;
        if (b2 != n04 && !e.compareAndSet((Object)this, (Object)n04, (Object)b2)) {
            return w0.c;
        }
        int n3 = b2.d();
        Object object4 = !(object2 instanceof p) ? null : object2;
        p p3 = (p)object4;
        if (p3 != null) {
            b2.a(p3.a);
        }
        Throwable throwable = (Throwable)b2._rootCause;
        if ((n2 ^ n3) == 0) {
            throwable = null;
        }
        // MONITOREXIT : b3
        if (throwable != null) {
            this.H(z02, throwable);
        }
        if ((k2 = (k)(n02 = !(n04 instanceof k) ? null : n04)) != null) {
            k3 = k2;
        } else {
            z0 z03 = n04.e();
            k3 = null;
            if (z03 != null) {
                k3 = this.G(z03);
            }
        }
        if (k3 == null) return this.q(b2, object2);
        if (!this.P(b2, k3, object2)) return this.q(b2, object2);
        return w0.b;
    }

    public final boolean P(b b2, k k2, Object object) {
        do {
            if (h.i.D0(k2.i, false, false, new u0<r0>(this, b2, k2, object){
                public final v0 i;
                public final b j;
                public final k k;
                public final Object l;
                {
                    this.i = v02;
                    this.j = b2;
                    this.k = k2;
                    this.l = object;
                }

                @Override
                public void l(Throwable throwable) {
                    v0 v02 = this.i;
                    b b2 = this.j;
                    k k2 = this.k;
                    Object object = this.l;
                    k k3 = v02.G(k2);
                    if (k3 != null && v02.P(b2, k3, object)) {
                        return;
                    }
                    v02.b(v02.q(b2, object));
                }

                @Override
                public String toString() {
                    StringBuilder stringBuilder = c.b.a.a.a.c("ChildCompletion[");
                    stringBuilder.append((Object)this.k);
                    stringBuilder.append(", ");
                    stringBuilder.append(this.l);
                    stringBuilder.append(']');
                    return stringBuilder.toString();
                }
            }, 1, null) == a1.e) continue;
            return true;
        } while ((k2 = this.G(k2)) != null);
        return false;
    }

    public final boolean a(Object object, z0 z02, u0<?> u02) {
        boolean bl;
        block2 : {
            i.a a2 = new i.a(u02, u02, this, object){
                public final /* synthetic */ v0 d;
                public final /* synthetic */ Object e;
                {
                    this.d = v02;
                    this.e = object;
                    super(i3);
                }
            };
            do {
                i i2 = z02.j();
                i.f.lazySet(u02, (Object)i2);
                i.e.lazySet(u02, (Object)z02);
                a2.b = z02;
                int n2 = !i.e.compareAndSet((Object)i2, (Object)z02, (Object)a2) ? 0 : (a2.a(i2) == null ? 1 : 2);
                if (n2 == true) break;
                bl = false;
                if (n2 != 2) {
                    continue;
                }
                break block2;
                break;
            } while (true);
            bl = true;
        }
        return bl;
    }

    public void b(Object object) {
    }

    @Override
    public boolean c() {
        Object object = this.y();
        return object instanceof n0 && ((n0)object).c();
    }

    public <R> R fold(R r2, h.m.a.p<? super R, ? super f.a, ? extends R> p2) {
        return (R)f.a.a.a((f.a)this, r2, p2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final boolean g(Object var1_1) {
        block23 : {
            block18 : {
                block22 : {
                    block19 : {
                        block20 : {
                            block21 : {
                                var2_2 = w0.a;
                                if (this.t()) {
                                    block17 : {
                                        while ((var16_3 = this.y()) instanceof n0 && (!(var16_3 instanceof b) || (var16_3)._isCompleting == 0)) {
                                            var2_2 = this.O(var16_3, new p(this.o(var1_1), false, 2));
                                            if (var2_2 == w0.c) continue;
                                            break block17;
                                        }
                                        var2_2 = w0.a;
                                    }
                                    if (var2_2 == w0.b) {
                                        return true;
                                    }
                                }
                                if (var2_2 != w0.a) break block23;
                                var3_4 = null;
                                do lbl-1000: // 3 sources:
                                {
                                    block24 : {
                                        if ((var4_5 = this.y()) instanceof b) {
                                            var17_11 = var4_5;
                                            // MONITORENTER : var17_11
                                            if ((var4_5).f()) {
                                                var5_12 = w0.d;
                                                // MONITOREXIT : var17_11
                                                break block18;
                                            }
                                            var12_13 = (var4_5).d();
                                            if (var1_1 == null && var12_13) break block19;
                                            break block20;
                                        }
                                        if (!(var4_5 instanceof n0)) break block21;
                                        if (var3_4 == null) {
                                            var3_4 = this.o(var1_1);
                                        }
                                        var6_6 = (n0)var4_5;
                                        if (!var6_6.c()) break block24;
                                        var8_8 = this.w(var6_6);
                                        if (var8_8 != null && v0.e.compareAndSet((Object)this, (Object)var6_6, (Object)(var9_9 = new /* invalid duplicate definition of identical inner class */))) {
                                            this.H(var8_8, var3_4);
                                            var10_10 = true;
                                        } else {
                                            var10_10 = false;
                                        }
                                        if (!var10_10) ** GOTO lbl-1000
                                        break block22;
                                    }
                                    var7_7 = this.O(var4_5, new p(var3_4, false, 2));
                                    if (var7_7 == w0.a) throw new IllegalStateException(c.b.a.a.a.i("Cannot happen in ", var4_5).toString());
                                } while (var7_7 == w0.c);
                                var2_2 = var7_7;
                                break block23;
                            }
                            var5_12 = w0.d;
                            break block18;
                        }
                        if (var3_4 == null) {
                            var3_4 = this.o(var1_1);
                        }
                        (var4_5).a(var3_4);
                    }
                    var13_14 = (Throwable)(var4_5)._rootCause;
                    var14_15 = var12_13 ^ true;
                    var15_16 = null;
                    if (var14_15) {
                        var15_16 = var13_14;
                    }
                    // MONITOREXIT : var17_11
                    if (var15_16 != null) {
                        this.H((var4_5).e, var15_16);
                    }
                }
                var5_12 = w0.a;
            }
            var2_2 = var5_12;
        }
        if (var2_2 == w0.a) {
            return true;
        }
        if (var2_2 == w0.b) {
            return true;
        }
        if (var2_2 == w0.d) {
            return false;
        }
        this.b(var2_2);
        return true;
    }

    @Override
    public <E extends f.a> E get(f.b<E> b2) {
        return (E)f.a.a.b((f.a)this, b2);
    }

    @Override
    public final f.b<?> getKey() {
        return r0.d;
    }

    @Override
    public CancellationException h() {
        Object object;
        block7 : {
            Throwable throwable;
            block5 : {
                block6 : {
                    block4 : {
                        object = this.y();
                        if (!(object instanceof b)) break block4;
                        throwable = (Throwable)(object)._rootCause;
                        break block5;
                    }
                    if (!(object instanceof p)) break block6;
                    throwable = ((p)object).a;
                    break block5;
                }
                if (object instanceof n0) break block7;
                throwable = null;
            }
            Throwable throwable2 = !(throwable instanceof CancellationException) ? null : throwable;
            CancellationException cancellationException = (CancellationException)throwable2;
            if (cancellationException != null) {
                return cancellationException;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Parent job is ");
            stringBuilder.append(this.M(object));
            return new s0(stringBuilder.toString(), throwable, this);
        }
        throw new IllegalStateException(c.b.a.a.a.i("Cannot be cancelling child in this state: ", object).toString());
    }

    public final boolean i(Throwable throwable) {
        boolean bl = this.D();
        boolean bl2 = true;
        if (bl) {
            return bl2;
        }
        boolean bl3 = throwable instanceof CancellationException;
        j j2 = (j)this._parentHandle;
        if (j2 != null) {
            if (j2 == a1.e) {
                return bl3;
            }
            if (!j2.d(throwable)) {
                if (bl3) {
                    return bl2;
                }
                bl2 = false;
            }
            return bl2;
        }
        return bl3;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    @Override
    public final d0 j(boolean bl, boolean bl2, h.m.a.l<? super Throwable, h> l2) {
        Object object;
        block18 : {
            u0<?> u02 = null;
            do {
                z0 z02;
                Throwable throwable;
                block22 : {
                    block21 : {
                        if ((object = this.y()) instanceof f0) {
                            void var16_13;
                            f0 f02 = (f0)object;
                            if (f02.e) {
                                if (u02 == null) {
                                    u02 = this.E(l2, bl);
                                }
                                if (!e.compareAndSet((Object)this, object, u02)) continue;
                                return u02;
                            }
                            z0 z03 = new z0();
                            if (!f02.e) {
                                m0 m02 = new m0(z03);
                            }
                            e.compareAndSet((Object)this, (Object)f02, (Object)var16_13);
                            continue;
                        }
                        if (!(object instanceof n0)) break block18;
                        z02 = ((n0)object).e();
                        if (z02 == null) {
                            if (object != null) {
                                this.L((u0)object);
                                continue;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                        }
                        a1 a12 = a1.e;
                        if (!bl || !(object instanceof b)) break block21;
                        Object object2 = object;
                        synchronized (object2) {
                            block19 : {
                                block20 : {
                                    boolean bl3;
                                    throwable = (Throwable)(object)._rootCause;
                                    if (throwable != null && (!(l2 instanceof k) || (object)._isCompleting != 0)) break block19;
                                    if (u02 == null) {
                                        u02 = this.E(l2, bl);
                                    }
                                    if (bl3 = this.a(object, z02, u02)) break block20;
                                    continue;
                                }
                                if (throwable == null) {
                                    return u02;
                                }
                                u0<?> u03 = u02;
                            }
                            break block22;
                        }
                    }
                    throwable = null;
                }
                if (throwable != null) {
                    void var10_7;
                    if (bl2) {
                        l2.f(throwable);
                    }
                    return var10_7;
                }
                if (u02 == null) {
                    u02 = this.E(l2, bl);
                }
                if (this.a(object, z02, u02)) break;
            } while (true);
            return u02;
        }
        if (bl2) {
            if (!(object instanceof p)) {
                object = null;
            }
            p p2 = (p)object;
            Throwable throwable = null;
            if (p2 != null) {
                throwable = p2.a;
            }
            l2.f((Object)throwable);
        }
        return a1.e;
    }

    public String k() {
        return "Job was cancelled";
    }

    public boolean l(Throwable throwable) {
        if (throwable instanceof CancellationException) {
            return true;
        }
        return this.g((Object)throwable) && this.r();
    }

    @Override
    public final CancellationException m() {
        Object object = this.y();
        if (object instanceof b) {
            Throwable throwable = (Throwable)(object)._rootCause;
            if (throwable != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getClass().getSimpleName());
                stringBuilder.append(" is cancelling");
                return this.N(throwable, stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Job is still new or active: ");
            stringBuilder.append((Object)this);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        if (!(object instanceof n0)) {
            if (object instanceof p) {
                return this.N(((p)object).a, null);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" has completed normally");
            return new s0(stringBuilder.toString(), null, this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Job is still new or active: ");
        stringBuilder.append((Object)this);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public f minusKey(f.b<?> b2) {
        return f.a.a.c((f.a)this, b2);
    }

    public final void n(n0 n02, Object object) {
        p p2;
        j j2 = (j)this._parentHandle;
        if (j2 != null) {
            j2.b();
            this._parentHandle = a1.e;
        }
        boolean bl = object instanceof p;
        s s2 = null;
        if (!bl) {
            object = null;
        }
        Throwable throwable = (p2 = (p)object) != null ? p2.a : null;
        if (n02 instanceof u0) {
            try {
                ((u0)n02).l(throwable);
                return;
            }
            catch (Throwable throwable2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception in completion handler ");
                stringBuilder.append((Object)n02);
                stringBuilder.append(" for ");
                stringBuilder.append((Object)this);
                this.A((Throwable)new s(stringBuilder.toString(), throwable2));
                return;
            }
        }
        z0 z02 = n02.e();
        if (z02 != null) {
            Object object2 = z02.h();
            if (object2 != null) {
                i i2 = (i)object2;
                while (true ^ h.m.b.j.a((Object)i2, (Object)z02)) {
                    if (i2 instanceof u0) {
                        u0 u02 = (u0)i2;
                        try {
                            u02.l(throwable);
                        }
                        catch (Throwable throwable3) {
                            if (s2 != null) {
                                h.i.a(s2, throwable3);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Exception in completion handler ");
                            stringBuilder.append((Object)u02);
                            stringBuilder.append(" for ");
                            stringBuilder.append((Object)this);
                            s2 = new s(stringBuilder.toString(), throwable3);
                        }
                    }
                    i2 = i2.i();
                }
                if (s2 != null) {
                    this.A((Throwable)s2);
                    return;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final Throwable o(Object object) {
        boolean bl = object != null ? object instanceof Throwable : true;
        if (bl) {
            if (object != null) {
                return (Throwable)object;
            }
            return new s0(this.k(), null, this);
        }
        if (object != null) {
            return ((c1)object).h();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public f plus(f f2) {
        return f.a.a.d((f.a)this, (f)f2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object q(b b2, Object object) {
        Object object2;
        Object object3 = !(object instanceof p) ? null : object;
        p p2 = (p)object3;
        Throwable throwable = p2 != null ? p2.a : null;
        b b3 = b2;
        // MONITORENTER : b3
        b2.d();
        List<Throwable> list = b2.g(throwable);
        if (list.isEmpty()) {
            boolean bl = b2.d();
            object2 = null;
            if (bl) {
                object2 = new s0(this.k(), null, this);
            }
        } else {
            Object object4;
            block13 : {
                Object object5;
                Iterator iterator = list.iterator();
                do {
                    boolean bl = iterator.hasNext();
                    object4 = null;
                    if (!bl) break block13;
                } while (!(true ^ (Throwable)(object5 = iterator.next()) instanceof CancellationException));
                object4 = object5;
            }
            if ((object2 = (Throwable)object4) == null) {
                object2 = (Throwable)list.get(0);
            }
        }
        if (object2 != null && list.size() > 1) {
            Set set = Collections.newSetFromMap((Map)new IdentityHashMap(list.size()));
            for (Throwable throwable2 : list) {
                if (throwable2 == object2 || throwable2 == object2 || throwable2 instanceof CancellationException || !set.add((Object)throwable2)) continue;
                h.i.a(object2, throwable2);
            }
        }
        // MONITOREXIT : b3
        if (object2 != null && object2 != throwable) {
            object = new p((Throwable)object2, false, 2);
        }
        if (object2 != null) {
            boolean bl = this.i((Throwable)object2) || this.z((Throwable)object2);
            if (bl) {
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                p p3 = (p)object;
                p.b.compareAndSet((Object)p3, 0, 1);
            }
        }
        this.I(object);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        Object object6 = object instanceof n0 ? new o0((n0)object) : object;
        atomicReferenceFieldUpdater.compareAndSet((Object)this, (Object)b2, object6);
        this.n(b2, object);
        return object;
    }

    public boolean r() {
        return true;
    }

    @Override
    public final boolean start() {
        block3 : {
            int n2;
            do {
                block7 : {
                    block5 : {
                        block6 : {
                            Object object;
                            block4 : {
                                object = this.y();
                                boolean bl = object instanceof f0;
                                n2 = -1;
                                if (!bl) break block4;
                                if (((f0)object).e) break block5;
                                if (e.compareAndSet((Object)this, object, (Object)w0.g)) break block6;
                                break block7;
                            }
                            if (!(object instanceof m0)) break block5;
                            if (!e.compareAndSet((Object)this, object, (Object)((m0)object).e)) break block7;
                        }
                        this.K();
                        n2 = 1;
                        break block7;
                    }
                    n2 = 0;
                }
                if (n2 == 0) break block3;
            } while (n2 != 1);
            return true;
        }
        return false;
    }

    public boolean t() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.F());
        stringBuilder2.append('{');
        stringBuilder2.append(this.M(this.y()));
        stringBuilder2.append('}');
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0(this));
        return stringBuilder.toString();
    }

    @Override
    public void u(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new s0(this.k(), null, this);
        }
        this.g((Object)cancellationException);
    }

    @Override
    public final void v(c1 c12) {
        this.g(c12);
    }

    public final z0 w(n0 n02) {
        z0 z02 = n02.e();
        if (z02 != null) {
            return z02;
        }
        if (n02 instanceof f0) {
            return new z0();
        }
        if (n02 instanceof u0) {
            this.L((u0)n02);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State should have list: ");
        stringBuilder.append((Object)n02);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public final Object y() {
        Object object;
        while ((object = this._state) instanceof m) {
            ((m)object).a(this);
        }
        return object;
    }

    public boolean z(Throwable throwable) {
        return false;
    }

}

