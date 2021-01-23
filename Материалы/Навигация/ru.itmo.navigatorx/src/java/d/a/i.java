/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a;

import c.b.a.a.a;
import d.a.a.e;
import d.a.a.f;
import d.a.a.p;
import d.a.b0;
import d.a.g;
import d.a.r0;
import d.a.t0;
import d.a.u0;
import h.h;
import h.k.d;
import h.m.b.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class i
extends t0<r0> {
    public final g<?> i;

    public i(r0 r02, g<?> g2) {
        super(r02);
        this.i = g2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void l(Throwable var1_1) {
        block5 : {
            block3 : {
                block4 : {
                    var2_2 = this.i;
                    var3_3 = this.h;
                    if (var2_2 == null) throw null;
                    var4_4 = var3_3.m();
                    var5_5 = var2_2.g;
                    var6_6 = true;
                    var7_7 = var5_5 == 2 ? var6_6 : false;
                    if (var7_7) break block4;
                    var8_8 = false;
                    break block5;
                }
                var10_9 = var2_2.i;
                if (!(var10_9 instanceof e)) {
                    var10_9 = null;
                }
                var11_10 = (e)var10_9;
                var8_8 = false;
                if (var11_10 == null) break block5;
                do lbl-1000: // 3 sources:
                {
                    block6 : {
                        if (!j.a((Object)(var12_11 = var11_10._reusableCancellableContinuation), (Object)f.b)) break block6;
                        if (!e.m.compareAndSet((Object)var11_10, (Object)f.b, (Object)var4_4)) ** GOTO lbl-1000
                        break block3;
                    }
                    if (var12_11 instanceof Throwable) break block3;
                } while (!e.m.compareAndSet((Object)var11_10, var12_11, null));
                var6_6 = false;
            }
            var8_8 = var6_6;
        }
        if (var8_8) {
            return;
        }
        var2_2.l((Throwable)var4_4);
        var2_2.m();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = a.c("ChildContinuation[");
        stringBuilder.append(this.i);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

