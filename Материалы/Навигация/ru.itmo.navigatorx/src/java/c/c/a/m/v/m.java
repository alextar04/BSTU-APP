/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.v.m$a
 *  java.lang.Object
 *  java.util.Queue
 */
package c.c.a.m.v;

import c.c.a.m.v.m;
import c.c.a.s.g;
import c.c.a.s.j;
import java.util.Queue;

public class m<A, B> {
    public final g<b<A>, B> a;

    public m(long l2) {
        this.a = new a(this, l2);
    }

    public static final class b<A> {
        public static final Queue<b<?>> d = j.c(0);
        public int a;
        public int b;
        public A c;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public static <A> b<A> a(A a2, int n2, int n3) {
            Queue<b<?>> queue;
            Queue<b<?>> queue2 = queue = d;
            // MONITORENTER : queue2
            b<A> b2 = (b<A>)d.poll();
            // MONITOREXIT : queue2
            if (b2 == null) {
                b2 = new b<A>();
            }
            b2.c = a2;
            b2.b = n2;
            b2.a = n3;
            return b2;
        }

        public boolean equals(Object object) {
            boolean bl = object instanceof b;
            boolean bl2 = false;
            if (bl) {
                b b2 = (b)object;
                int n2 = this.b;
                int n3 = b2.b;
                bl2 = false;
                if (n2 == n3) {
                    int n4 = this.a;
                    int n5 = b2.a;
                    bl2 = false;
                    if (n4 == n5) {
                        boolean bl3 = this.c.equals(b2.c);
                        bl2 = false;
                        if (bl3) {
                            bl2 = true;
                        }
                    }
                }
            }
            return bl2;
        }

        public int hashCode() {
            return 31 * (31 * this.a + this.b) + this.c.hashCode();
        }
    }

}

