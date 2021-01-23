/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.a.e
 *  d.a.b0
 *  d.a.g0
 *  d.a.r0
 *  d.a.r0$a
 *  d.a.v
 *  f.b.k.h
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$a
 *  h.k.f$b
 *  h.m.a.l
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package d.a.a;

import d.a.a.a;
import d.a.a.e;
import d.a.a.p;
import d.a.b0;
import d.a.g0;
import d.a.g1;
import d.a.q;
import d.a.r0;
import d.a.v;
import f.b.k.h;
import h.h;
import h.k.d;
import h.k.f;
import h.m.a.l;
import java.util.concurrent.CancellationException;

public final class f {
    public static final p a = new p("UNDEFINED");
    public static final p b = new p("REUSABLE_CLAIMED");

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final <T> void a(d<? super T> var0, Object var1_1, l<? super Throwable, h> var2_2) {
        if (!(var0 instanceof e)) {
            var0.e(var1_1);
            return;
        }
        var3_3 = (e)var0;
        var4_4 = h.i.S1(var1_1, var2_2);
        if (var3_3.k.M(var3_3.d())) {
            var3_3.h = var4_4;
            var3_3.g = 1;
            var3_3.k.L(var3_3.d(), (Runnable)var3_3);
            return;
        }
        var6_5 = g1.a();
        if (var6_5.R()) {
            var3_3.h = var4_4;
            var3_3.g = 1;
            var6_5.P((b0)var3_3);
            return;
        }
        var6_5.Q(true);
        var9_6 = (r0)var3_3.d().get((f.b)r0.d);
        if (var9_6 != null && !var9_6.c()) {
            var15_7 = var9_6.m();
            if (var4_4 instanceof q) {
                ((q)var4_4).b.f((Object)var15_7);
            }
            var3_3.e(h.i.K((Throwable)var15_7));
            var10_8 = true;
        } else {
            var10_8 = false;
        }
        if (var10_8) ** GOTO lbl39
        var11_9 = var3_3.d();
        var12_10 = a.c(var11_9, var3_3.j);
        var3_3.l.e(var1_1);
        {
            catch (Throwable var13_11) {
                a.a(var11_9, var12_10);
                throw var13_11;
            }
        }
        try {
            a.a(var11_9, var12_10);
lbl39: // 3 sources:
            while (var14_12 = var6_5.S()) {
            }
            return;
        }
        catch (Throwable var7_13) {
            try {
                var3_3.g(var7_13, null);
                return;
            }
            finally {
                var6_5.N(true);
            }
        }
    }
}

