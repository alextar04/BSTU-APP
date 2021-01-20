/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.i.a
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package d.a.l1;

import d.a.l1.b;
import d.a.l1.m;
import d.a.l1.n.g;
import f.b.k.h;
import h.h;
import h.k.d;
import h.k.f;
import h.k.j.a.c;

public final class m<T>
implements b<T> {
    public final b<T> e;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final Object b(d<? super h> var1_1) {
        if (!(var1_1 instanceof a)) ** GOTO lbl-1000
        var2_2 = var1_1;
        var13_3 = var2_2.i;
        if ((var13_3 & Integer.MIN_VALUE) != 0) {
            var2_2.i = var13_3 + Integer.MIN_VALUE;
        } else lbl-1000: // 2 sources:
        {
            var2_2 = new c(this, var1_1){
                public /* synthetic */ Object h;
                public int i;
                public final /* synthetic */ m j;
                public Object k;
                public Object l;
                {
                    this.j = m2;
                    super((d<Object>)d2);
                }

                public final Object i(Object object) {
                    this.h = object;
                    this.i = Integer.MIN_VALUE | this.i;
                    return this.j.b(this);
                }
            };
        }
        var3_4 = var2_2.h;
        var4_5 = h.k.i.a.e;
        var5_6 = var2_2.i;
        if (var5_6 != 0) {
            if (var5_6 != 1) {
                if (var5_6 != 2) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                (g)var2_2.l;
                (m)var2_2.k;
                h.i.O1(var3_4);
                return h.a;
            }
            var6_7 = (g<T>)var2_2.l;
            var8_8 = (m)var2_2.k;
            h.i.O1(var3_4);
            var9_9 = var8_8.e;
            if (var9_9 instanceof m == false) return h.a;
            var10_10 = (m)var9_9;
            var2_2.k = var8_8;
            var2_2.l = var6_7;
            var2_2.i = 2;
            if (var10_10.b(var2_2) != var4_5) return h.a;
            return var4_5;
        }
        h.i.O1(var3_4);
        var6_7 = new g<T>(null, var2_2.d());
        try {
            var2_2.k = this;
            var2_2.l = var6_7;
            var2_2.i = 1;
            throw null;
        }
        catch (Throwable var7_11) {
            throw var7_11;
        }
        finally {
            var6_7.j();
        }
    }

    @Override
    public Object f(T t2, d<? super h> d2) {
        throw null;
    }
}

