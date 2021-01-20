/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.o
 *  c.c.a.m.t.j
 *  c.c.a.m.v.g
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Queue
 */
package c.c.a.m.v.y;

import c.c.a.m.m;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.t.j;
import c.c.a.m.v.g;
import c.c.a.m.v.m;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.InputStream;
import java.util.Queue;

public class a
implements c.c.a.m.v.n<g, InputStream> {
    public static final n<Integer> b = n.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    public final c.c.a.m.v.m<g, g> a;

    public a(c.c.a.m.v.m<g, g> m2) {
        this.a = m2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Queue<m.b<?>> queue;
        g g2 = (g)object;
        c.c.a.m.v.m<g, g> m2 = this.a;
        if (m2 == null) return new n.a((m)g2, new j(g2, ((Integer)o2.c(b)).intValue()));
        m.b<g> b2 = m.b.a(g2, 0, 0);
        Object b3 = m2.a.a(b2);
        Queue<m.b<?>> queue2 = queue = m.b.d;
        synchronized (queue2) {
            m.b.d.offer(b2);
        }
        g g3 = (g)b3;
        if (g3 == null) {
            c.c.a.m.v.m<g, g> m3 = this.a;
            if (m3 == null) throw null;
            m.b<g> b4 = m.b.a(g2, 0, 0);
            m3.a.d(b4, g2);
            return new n.a((m)g2, new j(g2, ((Integer)o2.c(b)).intValue()));
        }
        g2 = g3;
        return new n.a((m)g2, new j(g2, ((Integer)o2.c(b)).intValue()));
    }

    @Override
    public boolean b(Object object) {
        (g)object;
        return true;
    }

    public static class a
    implements c.c.a.m.v.o<g, InputStream> {
        public final c.c.a.m.v.m<g, g> a = new c.c.a.m.v.m(500L);

        @Override
        public c.c.a.m.v.n<g, InputStream> b(r r2) {
            return new a(this.a);
        }
    }

}

