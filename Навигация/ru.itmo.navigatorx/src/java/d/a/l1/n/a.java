/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.k.d
 *  h.m.b.j
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package d.a.l1.n;

import d.a.l1.n.c;
import h.h;
import h.k.d;
import h.m.b.j;
import java.util.Arrays;

public abstract class a<S extends c<?>> {
    public S[] e;
    public int f;
    public int g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final S c() {
        a a2 = this;
        synchronized (a2) {
            Object object;
            Object[] arrobject = this.e;
            if (arrobject == null) {
                arrobject = this.e(2);
                this.e = arrobject;
            } else if (this.f >= arrobject.length) {
                Object[] arrobject2 = Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
                j.d((Object)arrobject2, (String)"java.util.Arrays.copyOf(this, newSize)");
                this.e = (c[])arrobject2;
                arrobject = (c[])arrobject2;
            }
            int n2 = this.g;
            do {
                if ((object = arrobject[n2]) == null) {
                    arrobject[n2] = object = this.d();
                }
                if (++n2 >= arrobject.length) {
                    n2 = 0;
                }
                if (object != null) continue;
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!((c)object).a(this));
            this.g = n2;
            this.f = 1 + this.f;
            return (S)object;
        }
    }

    public abstract S d();

    public abstract S[] e(int var1);

    public final void g(S s2) {
        a a2 = this;
        synchronized (a2) {
            int n2;
            block9 : {
                int n3;
                this.f = n3 = -1 + this.f;
                n2 = 0;
                if (n3 != 0) break block9;
                this.g = 0;
            }
            if (s2 != null) {
                d<h>[] arrd = ((c)s2).b((a)this);
                // MONITOREXIT [2, 4, 8] lbl12 : w: MONITOREXIT : var8_2
                int n4 = arrd.length;
                while (n2 < n4) {
                    d<h> d2 = arrd[n2];
                    if (d2 != null) {
                        d2.e((Object)h.a);
                    }
                    ++n2;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
        }
    }
}

