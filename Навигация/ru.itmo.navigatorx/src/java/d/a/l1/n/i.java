/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.a.o
 *  d.a.b
 *  d.a.r0$a
 *  h.k.f
 *  h.k.f$b
 *  h.m.a.p
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a.l1.n;

import d.a.a.o;
import d.a.b;
import d.a.l1.n.g;
import d.a.r0;
import h.k.f;
import h.m.a.p;
import h.m.b.k;

public final class i
extends k
implements p<Integer, f.a, Integer> {
    public final /* synthetic */ g f;

    public i(g g2) {
        this.f = g2;
        super(2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Object c(Object object, Object object2) {
        int n2 = ((Number)object).intValue();
        f.a a2 = (f.a)object2;
        f.b<?> b2 = a2.getKey();
        f.a a3 = this.f.l.get(b2);
        if (b2 != r0.d) {
            if (a2 == a3) return ++n2;
            {
                n2 = Integer.MIN_VALUE;
                return n2;
            }
        }
        r0 r02 = (r0)a3;
        r0 r03 = (r0)a2;
        do {
            block11 : {
                block10 : {
                    block9 : {
                        if (r03 != null) break block9;
                        r03 = null;
                        break block10;
                    }
                    if (r03 != r02 && r03 instanceof o) break block11;
                }
                if (r03 != r02) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n");
                    stringBuilder.append("\t\tChild of ");
                    stringBuilder.append((Object)r03);
                    stringBuilder.append(", expected child of ");
                    stringBuilder.append((Object)r02);
                    stringBuilder.append(".\n");
                    stringBuilder.append("\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n");
                    stringBuilder.append("\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
                    throw new IllegalStateException(stringBuilder.toString().toString());
                }
                if (r02 == null) return n2;
                return ++n2;
            }
            r03 = (r0)((o)r03).g.get((f.b)r0.d);
        } while (true);
    }
}

