/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 *  java.util.concurrent.locks.LockSupport
 */
package d.a;

import d.a.a.k;
import d.a.a.p;
import d.a.a.r;
import d.a.a.s;
import d.a.a0;
import d.a.b0;
import d.a.d0;
import d.a.g0;
import d.a.i0;
import d.a.j0;
import h.k.f;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public abstract class h0
extends i0 {
    public static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(h0.class, Object.class, (String)"_queue");
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(h0.class, Object.class, (String)"_delayed");
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;
    public volatile Object _queue = null;

    @Override
    public final void L(f f2, Runnable runnable) {
        this.V(runnable);
    }

    public final void V(Runnable runnable) {
        if (this.W(runnable)) {
            Thread thread = this.T();
            if (Thread.currentThread() != thread) {
                LockSupport.unpark((Thread)thread);
                return;
            }
        } else {
            a0.l.V(runnable);
        }
    }

    public final boolean W(Runnable runnable) {
        do {
            Object object = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (object == null) {
                if (!i.compareAndSet((Object)this, null, (Object)runnable)) continue;
                return true;
            }
            if (object instanceof k) {
                k k2 = (k)object;
                int n2 = k2.a(runnable);
                if (n2 != 0) {
                    if (n2 != 1) {
                        if (n2 != 2) continue;
                        return false;
                    }
                    i.compareAndSet((Object)this, object, k2.d());
                    continue;
                }
                return true;
            }
            if (object == j0.b) {
                return false;
            }
            k<Runnable> k3 = new k<Runnable>(8, true);
            k3.a((Runnable)object);
            k3.a(runnable);
            if (i.compareAndSet((Object)this, object, k3)) break;
        } while (true);
        return true;
    }

    public boolean X() {
        boolean bl;
        d.a.a.b<b0<?>> b2 = this.h;
        boolean bl2 = b2 == null || b2.b == b2.c;
        if (!bl2) {
            return false;
        }
        b b3 = this._delayed;
        if (b3 != null && !(bl = b3._size == 0)) {
            return false;
        }
        Object object = this._queue;
        if (object == null) {
            return true;
        }
        if (object instanceof k) {
            return ((k)object).c();
        }
        return object == j0.b;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public long Y() {
        block22 : {
            var1_1 = this.S();
            var2_2 = 0L;
            if (var1_1) {
                return var2_2;
            }
            var4_3 = this._delayed;
            var5_4 = true;
            if (var4_3 != null && !(var21_5 = var4_3._size == 0 ? var5_4 : false)) {
                var22_6 = System.nanoTime();
                do {
                    var30_12 = var4_3;
                    // MONITORENTER : var30_12
                    var25_7 = var4_3.b();
                    if (var25_7 != null) {
                        var26_8 = var25_7;
                        var27_9 = var22_6 - var26_8.g >= var2_2 ? var5_4 : false;
                        var28_10 = var27_9 != false ? this.W(var26_8) : false;
                        var29_11 = var28_10 != false ? var4_3.c(0) : null;
                        // MONITOREXIT : var30_12
                        continue;
                    }
                    // MONITOREXIT : var30_12
                    var29_11 = null;
                } while (var29_11 != null);
            }
            do {
                if ((var6_13 = this._queue) == null) {
                    var7_16 = null;
                    break block22;
                }
                if (var6_13 instanceof k) {
                    var18_14 = (k)var6_13;
                    var19_15 = var18_14.e();
                    if (var19_15 != k.g) {
                        var7_16 = (Runnable)var19_15;
                        break block22;
                    }
                    h0.i.compareAndSet((Object)this, var6_13, var18_14.d());
                    continue;
                }
                if (var6_13 == j0.b) {
                    var7_16 = null;
                    break block22;
                }
                if (h0.i.compareAndSet((Object)this, var6_13, null)) break;
            } while (true);
            var7_16 = (Runnable)var6_13;
        }
        if (var7_16 != null) {
            var7_16.run();
            return var2_2;
        }
        var8_17 = this.h;
        if (var8_17 == null) ** GOTO lbl-1000
        if (var8_17.b != var8_17.c) {
            var5_4 = false;
        }
        if (!var5_4) {
            var9_18 = var2_2;
        } else lbl-1000: // 2 sources:
        {
            var9_18 = Long.MAX_VALUE;
        }
        if (var9_18 == var2_2) {
            return var2_2;
        }
        var11_19 = this._queue;
        if (var11_19 != null) {
            if (var11_19 instanceof k) {
                if (!((k)var11_19).c()) {
                    return var2_2;
                } else {
                    ** GOTO lbl-1000
                }
            }
        } else lbl-1000: // 3 sources:
        {
            var12_20 = this._delayed;
            if (var12_20 == null) return Long.MAX_VALUE;
            var31_21 = var12_20;
            // MONITORENTER : var31_21
            var14_22 = var12_20.b();
            // MONITOREXIT : var31_21
            var15_23 = var14_22;
            if (var15_23 == null) return Long.MAX_VALUE;
            var16_24 = var15_23.g - System.nanoTime();
            if (var16_24 >= var2_2) return var16_24;
            return var2_2;
        }
        if (var11_19 != j0.b) return var2_2;
        return Long.MAX_VALUE;
    }

}

