/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.ThreadLocal
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a;

import d.a.a.b;
import d.a.a.k;
import d.a.a.p;
import d.a.a.r;
import d.a.b0;
import d.a.g1;
import d.a.h0;
import d.a.j0;
import d.a.v;
import f.b.k.h;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class g0
extends v {
    public long f;
    public boolean g;
    public b<b0<?>> h;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void N(boolean var1_1) {
        this.f = var2_2 = this.f - this.O(var1_1);
        if (var2_2 > 0L) {
            return;
        }
        if (this.g == false) return;
        var4_3 = (h0)this;
        g1.a.set(null);
        var4_3._isCompleted = 1;
        do lbl-1000: // 3 sources:
        {
            block7 : {
                if ((var6_4 = var4_3._queue) != null) break block7;
                if (!h0.i.compareAndSet((Object)var4_3, null, (Object)j0.b)) ** GOTO lbl-1000
                break;
            }
            if (var6_4 instanceof k) {
                ((k)var6_4).b();
                break;
            }
            if (var6_4 == j0.b) break;
            var7_5 = new k<Runnable>(8, true);
            var7_5.a((Runnable)var6_4);
        } while (!h0.i.compareAndSet((Object)var4_3, var6_4, var7_5));
        while (var4_3.Y() <= 0L) {
        }
        var9_6 = System.nanoTime();
        while ((var11_8 = var4_3._delayed) != null) {
            var16_7 = var11_8;
            // MONITORENTER : var16_7
            var13_9 = var11_8._size > 0 ? var11_8.c(0) : null;
            // MONITOREXIT : var16_7
            var14_10 = var13_9;
            if (var14_10 == null) return;
            var4_3.U(var9_6, var14_10);
        }
    }

    public final long O(boolean bl) {
        if (bl) {
            return 0x100000000L;
        }
        return 1L;
    }

    public final void P(b0<?> b02) {
        int n2;
        b<b0<Object>> b2 = this.h;
        if (b2 == null) {
            this.h = b2 = new b();
        }
        Object[] arrobject = b2.a;
        int n3 = b2.c;
        arrobject[n3] = b02;
        b2.c = n2 = n3 + 1 & -1 + arrobject.length;
        int n4 = b2.b;
        if (n2 == n4) {
            int n5 = arrobject.length;
            Object[] arrobject2 = new Object[n5 << 1];
            h.i.C(arrobject, arrobject2, 0, n4, 0, 10);
            Object[] arrobject3 = b2.a;
            int n6 = arrobject3.length;
            int n7 = b2.b;
            h.i.C(arrobject3, arrobject2, n6 - n7, 0, n7, 4);
            b2.a = arrobject2;
            b2.b = 0;
            b2.c = n5;
        }
    }

    public final void Q(boolean bl) {
        this.f += this.O(bl);
        if (!bl) {
            this.g = true;
        }
    }

    public final boolean R() {
        return this.f >= this.O(true);
    }

    public final boolean S() {
        block4 : {
            block7 : {
                Object object;
                block6 : {
                    int n2;
                    b<b0<?>> b2;
                    block5 : {
                        b2 = this.h;
                        if (b2 == null) break block4;
                        n2 = b2.b;
                        if (n2 != b2.c) break block5;
                        object = null;
                        break block6;
                    }
                    Object[] arrobject = b2.a;
                    Object object2 = arrobject[n2];
                    arrobject[n2] = null;
                    b2.b = n2 + 1 & -1 + arrobject.length;
                    if (object2 == null) break block7;
                    object = object2;
                }
                b0 b02 = (b0)object;
                if (b02 != null) {
                    b02.run();
                    return true;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
        return false;
    }
}

