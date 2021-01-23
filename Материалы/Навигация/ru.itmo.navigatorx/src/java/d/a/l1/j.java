/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$b
 *  h.k.i.a
 *  h.m.b.j
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.l1;

import d.a.a.p;
import d.a.g;
import d.a.l1.b;
import d.a.l1.d;
import d.a.l1.j;
import d.a.l1.k;
import d.a.l1.l;
import d.a.l1.m;
import d.a.l1.n.c;
import d.a.l1.n.f;
import d.a.r0;
import f.b.k.h;
import h.h;
import h.k.f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class j<T>
extends d.a.l1.n.a<l>
implements d<T>,
Object<T>,
Object<T> {
    public volatile Object _state;
    public int h;

    public j(Object object) {
        this._state = object;
    }

    @Override
    public boolean a(T t2) {
        this.h(null, t2);
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public Object b(b<? super T> var1_1, h.k.d<? super h> var2_2) {
        block21 : {
            block25 : {
                block22 : {
                    block23 : {
                        block24 : {
                            var3_3 = var1_1;
                            var4_4 = h.k.i.a.e;
                            if (!(var2_2 instanceof a)) ** GOTO lbl-1000
                            var5_5 = var2_2;
                            var27_6 = var5_5.i;
                            if ((var27_6 & Integer.MIN_VALUE) != 0) {
                                var5_5.i = var27_6 + Integer.MIN_VALUE;
                            } else lbl-1000: // 2 sources:
                            {
                                var5_5 = new h.k.j.a.c(this, var2_2){
                                    public /* synthetic */ Object h;
                                    public int i;
                                    public final /* synthetic */ j j;
                                    public Object k;
                                    public Object l;
                                    public Object m;
                                    public Object n;
                                    public Object o;
                                    public Object p;
                                    {
                                        this.j = j2;
                                        super((h.k.d<Object>)d2);
                                    }

                                    public final Object i(Object object) {
                                        this.h = object;
                                        this.i = Integer.MIN_VALUE | this.i;
                                        return this.j.b(null, this);
                                    }
                                };
                            }
                            var6_7 = var5_5.h;
                            var7_8 = var5_5.i;
                            if (var7_8 == 0) break block23;
                            if (var7_8 == 1) break block24;
                            if (var7_8 != 2) {
                                if (var7_8 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                var15_9 = var5_5.o;
                                var12_10 = (r0)var5_5.n;
                                var11_11 = (l)var5_5.m;
                                var13_12 = (b)var5_5.l;
                                var10_13 = (j)var5_5.k;
                                h.i.O1(var6_7);
                                var14_14 = var4_4;
                                break block21;
                            }
                            var15_9 = var5_5.p;
                            var12_10 = (r0)var5_5.n;
                            var11_11 = (l)var5_5.m;
                            var13_12 = (b)var5_5.l;
                            var10_13 = (j)var5_5.k;
                            try {
                                h.i.O1(var6_7);
                                var19_15 = var4_4;
                                ** GOTO lbl91
                            }
                            catch (Throwable var9_17) {}
                        }
                        var11_11 = (l)var5_5.m;
                        var3_3 = (b)var5_5.l;
                        var10_13 = (j)var5_5.k;
                        h.i.O1(var6_7);
                        break block22;
                    }
                    h.i.O1(var6_7);
                    var8_16 = (l)this.c();
                    if (var3_3 instanceof m) {
                        var25_20 = (m)var3_3;
                        var5_5.k = this;
                        var5_5.l = var3_3;
                        var5_5.m = var8_16;
                        var5_5.i = 1;
                        var26_21 = var25_20.b(var5_5);
                        if (var26_21 == var4_4) {
                            return var4_4;
                        }
                    }
                    var10_13 = this;
                    var11_11 = var8_16;
                }
                var12_10 = (r0)var5_5.d().get((f.b)r0.d);
                var13_12 = var3_3;
                var14_14 = var4_4;
                var15_9 = null;
                break block21;
                catch (Throwable var9_18) {
                    var10_13 = this;
                }
                break block25;
                var8_16 = var11_11;
            }
            var10_13.g(var8_16);
            throw var9_19;
        }
        do lbl-1000: // 3 sources:
        {
            block26 : {
                var16_22 = var10_13._state;
                if (var12_10 != null) {
                    if (var12_10.c() == false) throw var12_10.m();
                }
                if (var15_9 != null && !(true ^ h.m.b.j.a((Object)var15_9, (Object)var16_22))) break block26;
                var17_23 = var16_22 == f.a ? null : var16_22;
                var5_5.k = var10_13;
                var5_5.l = var13_12;
                var5_5.m = var11_11;
                var5_5.n = var12_10;
                var5_5.o = var15_9;
                var5_5.p = var16_22;
                var5_5.i = 2;
                if (var13_12.f(var17_23, var5_5) == var4_4) {
                    return var4_4;
                }
                var15_9 = var16_22;
                var18_24 = var4_4;
                var4_4 = var14_14;
                var19_15 = var18_24;
lbl91: // 2 sources:
                var16_22 = var15_9;
                var20_25 = var4_4;
                var4_4 = var19_15;
                var14_14 = var20_25;
            }
            if (var11_11 == null) throw null;
            var21_26 = l.a.getAndSet((Object)var11_11, (Object)k.a);
            h.m.b.j.c((Object)var21_26);
            var22_27 = var21_26 == k.b;
            if (var22_27) ** GOTO lbl-1000
            var5_5.k = var10_13;
            var5_5.l = var13_12;
            var5_5.m = var11_11;
            var5_5.n = var12_10;
            var5_5.o = var15_9;
            var5_5.p = var16_22;
            var5_5.i = 3;
            var23_28 = new g<Object>(h.i.B0(var5_5), 1);
            var23_28.s();
            if (!l.a.compareAndSet((Object)var11_11, (Object)k.a, var23_28)) {
                var23_28.e((Object)h.a);
            }
            var24_29 = var23_28.o();
            if (var24_29 != var14_14) continue;
            {
                h.m.b.j.e((Object)var5_5, (String)"frame");
            }
        } while (var24_29 != var4_4);
        return var4_4;
    }

    @Override
    public c d() {
        return new l();
    }

    public c[] e(int n2) {
        return new l[n2];
    }

    @Override
    public Object f(T object, h.k.d<? super h> d2) {
        if (object == null) {
            object = f.a;
        }
        this.h(null, object);
        return h.a;
    }

    @Override
    public T getValue() {
        Object object = this._state;
        p p2 = f.a;
        if (object == p2) {
            object = null;
        }
        return (T)object;
    }

    public final boolean h(Object object, Object object2) {
        (l[])this.e;
        j j2 = this;
        synchronized (j2) {
            block16 : {
                Object object3;
                block15 : {
                    object3 = this._state;
                    if (object == null) break block15;
                    boolean bl = h.m.b.j.a((Object)object3, (Object)object);
                    if (bl ^ true) {
                        return false;
                    }
                }
                boolean bl = h.m.b.j.a((Object)object3, (Object)object2);
                if (!bl) break block16;
                return true;
            }
            this._state = object2;
            int n2 = this.h;
            if ((n2 & 1) == 0) {
                int n3 = n2 + 1;
                this.h = n3;
                l[] arrl = (l[])this.e;
                return (boolean)arrl;
            }
            int n4 = n2 + 2;
            this.h = n4;
            return true;
        }
    }

    @Override
    public void setValue(T t2) {
        this.h(null, t2);
    }
}

