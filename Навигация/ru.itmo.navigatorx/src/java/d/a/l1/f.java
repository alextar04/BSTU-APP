/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.l1.f$a
 *  d.a.l1.h
 *  d.a.l1.m
 *  d.a.r0$a
 *  f.b.k.h
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$b
 *  h.k.i.a
 *  h.k.j.a.e
 *  h.m.a.l
 *  h.m.b.j
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.concurrent.CancellationException
 */
package d.a.l1;

import d.a.a.p;
import d.a.d0;
import d.a.e0;
import d.a.l1.c;
import d.a.l1.f;
import d.a.l1.g;
import d.a.l1.h;
import d.a.l1.m;
import d.a.r0;
import f.b.k.h;
import h.k.d;
import h.k.f;
import h.k.j.a.e;
import h.m.a.l;
import h.m.b.j;
import java.util.Arrays;
import java.util.concurrent.CancellationException;

/*
 * Exception performing whole class analysis.
 */
public final class f<T>
extends d.a.l1.n.a<h>
implements c<T>,
Object<T>,
Object<T> {
    public Object[] h;
    public long i;
    public long j;
    public int k;
    public int l;
    public final int m;
    public final int n;
    public final d.a.k1.a o;

    public f(int n2, int n3, d.a.k1.a a2) {
        this.m = n2;
        this.n = n3;
        this.o = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(T t2) {
        int n2;
        boolean bl;
        d<h.h>[] arrd = d.a.l1.n.b.a;
        f f2 = this;
        synchronized (f2) {
            boolean bl2 = this.q(t2);
            n2 = 0;
            if (bl2) {
                arrd = this.l();
                bl = true;
            } else {
                bl = false;
            }
        }
        int n3 = arrd.length;
        while (n2 < n3) {
            d<h.h> d2 = arrd[n2];
            if (d2 != null) {
                d2.e((Object)h.h.a);
            }
            ++n2;
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object b(d.a.l1.b<? super T> var1_1, d<? super h.h> var2_2) {
        block16 : {
            block20 : {
                block17 : {
                    block18 : {
                        block19 : {
                            if (!(var2_2 instanceof b)) ** GOTO lbl-1000
                            var3_3 = var2_2;
                            var18_4 = var3_3.i;
                            if ((var18_4 & Integer.MIN_VALUE) != 0) {
                                var3_3.i = var18_4 + Integer.MIN_VALUE;
                            } else lbl-1000: // 2 sources:
                            {
                                var3_3 = new h.k.j.a.c(var2_2){
                                    public /* synthetic */ Object h;
                                    public int i;
                                    public Object k;
                                    public Object l;
                                    public Object m;
                                    public Object n;
                                    public Object o;

                                    @Override
                                    public final Object i(Object object) {
                                        this.h = object;
                                        this.i = Integer.MIN_VALUE | this.i;
                                        return this.b(null, this);
                                    }
                                };
                            }
                            var4_5 = var3_3.h;
                            var5_6 = h.k.i.a.e;
                            var6_7 = var3_3.i;
                            if (var6_7 == 0) break block18;
                            if (var6_7 == 1) break block19;
                            if (var6_7 != 2) {
                                if (var6_7 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                var13_8 = (r0)var3_3.n;
                                var10_9 = (h)var3_3.m;
                                var12_10 = (d.a.l1.b)var3_3.l;
                                var9_11 = (f)var3_3.k;
                                h.i.O1(var4_5);
                                break block16;
                            }
                            var13_8 = (r0)var3_3.n;
                            var10_9 = (h)var3_3.m;
                            var12_10 = (d.a.l1.b)var3_3.l;
                            var9_11 = (f)var3_3.k;
                            try {
                                h.i.O1(var4_5);
                                ** GOTO lbl69
                            }
                            catch (Throwable var8_18) {}
                        }
                        var10_9 = (h)var3_3.m;
                        var1_1 = (d.a.l1.b)var3_3.l;
                        var9_11 = (f)var3_3.k;
                        h.i.O1(var4_5);
                        break block17;
                    }
                    h.i.O1(var4_5);
                    var7_12 = (h)this.c();
                    if (var1_1 instanceof m) {
                        var16_16 = (m)var1_1;
                        var3_3.k = this;
                        var3_3.l = var1_1;
                        var3_3.m = var7_12;
                        var3_3.i = 1;
                        var17_17 = var16_16.b((d)var3_3);
                        if (var17_17 == var5_6) {
                            return var5_6;
                        }
                    }
                    var9_11 = this;
                    var10_9 = var7_12;
                }
                var11_13 = (r0)var3_3.d().get((f.b)r0.d);
                ** GOTO lbl67
                var7_12 = var10_9;
                break block20;
                catch (Throwable var8_19) {
                    var9_11 = this;
                }
            }
            var9_11.g(var7_12);
            throw var8_20;
        }
        block7 : do {
            var11_13 = var13_8;
            var1_1 = var12_10;
lbl67: // 2 sources:
            var12_10 = var1_1;
            var13_8 = var11_13;
lbl69: // 2 sources:
            do {
                if ((var14_14 = var9_11.s(var10_9)) != g.a) {
                    if (var13_8 != null) {
                        if (var13_8.c() == false) throw var13_8.m();
                    }
                    var3_3.k = var9_11;
                    var3_3.l = var12_10;
                    var3_3.m = var10_9;
                    var3_3.n = var13_8;
                    var3_3.o = var14_14;
                    var3_3.i = 3;
                    if (var12_10.f(var14_14, var3_3) != var5_6) continue block7;
                    return var5_6;
                }
                var3_3.k = var9_11;
                var3_3.l = var12_10;
                var3_3.m = var10_9;
                var3_3.n = var13_8;
                var3_3.o = var14_14;
                var3_3.i = 2;
            } while ((var15_15 = var9_11.h(var10_9, var3_3)) != var5_6);
            break;
        } while (true);
        return var5_6;
    }

    @Override
    public d.a.l1.n.c d() {
        return new h();
    }

    public d.a.l1.n.c[] e(int n2) {
        return new h[n2];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public Object f(T t2, d<? super h.h> d2) {
        d<h.h>[] arrd;
        a a2;
        h.k.i.a a3 = h.k.i.a.e;
        if (this.a(t2)) {
            return h.h.a;
        }
        d.a.g<? super h.h> g2 = new d.a.g<h.h>(h.i.B0(d2), 1);
        g2.s();
        d<h.h>[] arrd2 = d.a.l1.n.b.a;
        f f2 = this;
        // MONITORENTER : f2
        if (this.q(t2)) {
            g2.e((Object)h.h.a);
            arrd = this.l();
            a2 = null;
        } else {
            a a4 = new /* Unavailable Anonymous Inner Class!! */;
            this.k((Object)a4);
            this.l = 1 + this.l;
            if (this.n == 0) {
                arrd2 = this.l();
            }
            arrd = arrd2;
            a2 = a4;
        }
        // MONITOREXIT : f2
        if (a2 != null) {
            g2.p((l<Throwable, h.h>)new e0((d0)a2));
        }
        for (d<h.h> d3 : arrd) {
            if (d3 == null) continue;
            d3.e((Object)h.h.a);
        }
        Object object = g2.o();
        if (object == a3) {
            j.e(d2, (String)"frame");
        }
        if (object != a3) return h.h.a;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object h(h h2, d<? super h.h> d2) {
        d.a.g<? super h.h> g2 = new d.a.g<h.h>(h.i.B0(d2), 1);
        g2.s();
        f f2 = this;
        synchronized (f2) {
            if (this.r(h2) < 0L) {
                h2.b = g2;
                h2.b = g2;
            } else {
                g2.e((Object)h.h.a);
            }
        }
        Object object = g2.o();
        if (object == h.k.i.a.e) {
            j.e(d2, (String)"frame");
        }
        return object;
    }

    public final void i() {
        if (this.n == 0 && this.l <= 1) {
            return;
        }
        Object[] arrobject = this.h;
        j.c((Object)arrobject);
        while (this.l > 0 && arrobject[(int)(this.n() + (long)this.o() - 1L) & -1 + arrobject.length] == g.a) {
            this.l = -1 + this.l;
            arrobject[(int)(this.n() + (long)this.o()) & -1 + arrobject.length] = null;
        }
    }

    public final void j() {
        Object[] arrobject = this.h;
        j.c((Object)arrobject);
        arrobject[(int)this.n() & -1 + arrobject.length] = null;
        this.k = -1 + this.k;
        long l2 = 1L + this.n();
        if (this.i < l2) {
            this.i = l2;
        }
        if (this.j < l2) {
            S[] arrS;
            if (this.f != 0 && (arrS = this.e) != null) {
                for (Object s2 : arrS) {
                    if (s2 == null) continue;
                    h h2 = (h)s2;
                    long l3 = h2.a;
                    if (l3 < 0L || l3 >= l2) continue;
                    h2.a = l2;
                }
            }
            this.j = l2;
        }
    }

    public final void k(Object object) {
        int n2 = this.o();
        Object[] arrobject = this.h;
        if (arrobject == null) {
            arrobject = this.p(null, 0, 2);
        } else if (n2 >= arrobject.length) {
            arrobject = this.p(arrobject, n2, 2 * arrobject.length);
        }
        arrobject[(int)(this.n() + (long)n2) & -1 + arrobject.length] = object;
    }

    public final d<h.h>[] l() {
        Object[] arrobject = d.a.l1.n.b.a;
        if (this.f == 0) {
            return arrobject;
        }
        S[] arrS = this.e;
        if (arrS != null) {
            int n2 = arrS.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object s2 = arrS[i2];
                if (s2 == null) continue;
                h h2 = (h)s2;
                d d2 = h2.b;
                if (d2 == null || this.r(h2) < 0L) continue;
                if (n3 >= arrobject.length) {
                    Object[] arrobject2 = Arrays.copyOf((Object[])arrobject, (int)Math.max((int)2, (int)(2 * arrobject.length)));
                    j.d((Object)arrobject2, (String)"java.util.Arrays.copyOf(this, newSize)");
                    arrobject = (d[])arrobject2;
                }
                int n4 = n3 + 1;
                arrobject[n3] = d2;
                h2.b = null;
                n3 = n4;
            }
        }
        return arrobject;
    }

    public final long m() {
        return this.n() + (long)this.k;
    }

    public final long n() {
        return Math.min((long)this.j, (long)this.i);
    }

    public final int o() {
        return this.k + this.l;
    }

    public final Object[] p(Object[] arrobject, int n2, int n3) {
        boolean bl = n3 > 0;
        if (bl) {
            Object[] arrobject2 = new Object[n3];
            this.h = arrobject2;
            if (arrobject == null) {
                return arrobject2;
            }
            long l2 = this.n();
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object;
                int n4 = (int)(l2 + (long)i2);
                arrobject2[n4 & n3 - 1] = object = arrobject[n4 & -1 + arrobject.length];
            }
            return arrobject2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean q(T t2) {
        long l2;
        long l3;
        int n2;
        if (this.f == 0) {
            int n3;
            if (this.m == 0) {
                return true;
            }
            this.k(t2);
            this.k = n3 = 1 + this.k;
            if (n3 > this.m) {
                this.j();
            }
            this.j = this.n() + (long)this.k;
            return true;
        }
        if (this.k >= this.n && this.j <= this.i) {
            int n4 = this.o.ordinal();
            if (n4 != 0) {
                if (n4 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        this.k(t2);
        this.k = n2 = 1 + this.k;
        if (n2 > this.n) {
            this.j();
        }
        if ((int)((l2 = this.n() + (long)this.k) - (l3 = this.i)) > this.m) {
            this.t(l3 + 1L, this.j, this.m(), this.n() + (long)this.k + (long)this.l);
        }
        return true;
    }

    public final long r(h h2) {
        long l2 = h2.a;
        if (l2 < this.m()) {
            return l2;
        }
        if (this.n > 0) {
            return -1L;
        }
        if (l2 > this.n()) {
            return -1L;
        }
        if (this.l == 0) {
            return -1L;
        }
        return l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object s(h h2) {
        Object object;
        d<h.h>[] arrd = d.a.l1.n.b.a;
        f f2 = this;
        synchronized (f2) {
            long l2 = this.r(h2);
            if (l2 < 0L) {
                object = g.a;
            } else {
                long l3 = h2.a;
                Object[] arrobject = this.h;
                j.c((Object)arrobject);
                Object object2 = arrobject[(int)l2 & -1 + arrobject.length];
                if (object2 instanceof a) {
                    object2 = (object2).g;
                }
                h2.a = l2 + 1L;
                d<h.h>[] arrd2 = this.u(l3);
                Object object3 = object2;
                arrd = arrd2;
                object = object3;
            }
        }
        int n2 = arrd.length;
        int n3 = 0;
        while (n3 < n2) {
            d<h.h> d2 = arrd[n3];
            if (d2 != null) {
                d2.e((Object)h.h.a);
            }
            ++n3;
        }
        return object;
    }

    public final void t(long l2, long l3, long l4, long l5) {
        long l6 = Math.min((long)l3, (long)l2);
        for (long i2 = this.n(); i2 < l6; ++i2) {
            Object[] arrobject = this.h;
            j.c((Object)arrobject);
            arrobject[(int)i2 & -1 + arrobject.length] = null;
        }
        this.i = l2;
        this.j = l3;
        this.k = (int)(l4 - l6);
        this.l = (int)(l5 - l4);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final d<h.h>[] u(long l2) {
        long l3;
        d<h.h>[] arrd;
        long l4;
        long l5;
        long l6;
        block15 : {
            S[] arrS;
            long l7;
            int n2;
            if (l2 > this.j) {
                return d.a.l1.n.b.a;
            }
            l6 = this.n();
            long l8 = l6 + (long)this.k;
            if (this.n == 0 && this.l > 0) {
                ++l8;
            }
            int n3 = this.f;
            int n4 = 0;
            if (n3 != 0 && (arrS = this.e) != null) {
                for (Object s2 : arrS) {
                    long l9;
                    if (s2 == null || (l9 = ((h)s2).a) < 0L || l9 >= l8) continue;
                    l8 = l9;
                }
            }
            if ((l7 = l8) <= this.j) {
                return d.a.l1.n.b.a;
            }
            long l10 = this.m();
            if (this.f > 0) {
                int n5 = (int)(l10 - l7);
                n2 = Math.min((int)this.l, (int)(this.n - n5));
            } else {
                n2 = this.l;
            }
            arrd = d.a.l1.n.b.a;
            long l11 = l10 + (long)this.l;
            if (n2 <= 0) {
                l5 = l7;
                l3 = l11;
                l4 = l10;
            } else {
                arrd = new d[n2];
                Object[] arrobject = this.h;
                j.c((Object)arrobject);
                l4 = l10;
                while (l10 < l11) {
                    long l12;
                    int n6 = (int)l10;
                    l5 = l7;
                    Object object = arrobject[n6 & -1 + arrobject.length];
                    p p2 = g.a;
                    if (object != p2) {
                        Object object2;
                        if (object == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        }
                        a a2 = object;
                        l3 = l11;
                        int n7 = n4 + 1;
                        arrd[n4] = a2.h;
                        arrobject[n6 & -1 + arrobject.length] = p2;
                        arrobject[(int)l4 & -1 + arrobject.length] = object2 = a2.g;
                        l12 = 1L;
                        l4 += l12;
                        if (n7 >= n2) break block15;
                        n4 = n7;
                    } else {
                        l3 = l11;
                        l12 = 1L;
                    }
                    l10 += l12;
                    l7 = l5;
                    l11 = l3;
                }
                l5 = l7;
                l3 = l11;
            }
        }
        d<h.h>[] arrd2 = arrd;
        int n8 = (int)(l4 - l6);
        long l13 = Math.max((long)this.i, (long)(l4 - (long)Math.min((int)this.m, (int)n8)));
        if (this.n == 0 && l13 < l3) {
            Object[] arrobject = this.h;
            j.c((Object)arrobject);
            if (j.a((Object)arrobject[(int)l13 & -1 + arrobject.length], (Object)g.a)) {
                ++l4;
                ++l13;
            }
        }
        this.t(l13, l5, l4, l3);
        this.i();
        return arrd2;
    }

}

