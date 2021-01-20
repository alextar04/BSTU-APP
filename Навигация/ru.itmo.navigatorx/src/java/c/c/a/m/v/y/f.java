/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.o
 *  c.c.a.m.v.g
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.net.URL
 */
package c.c.a.m.v.y;

import c.c.a.m.v.g;
import c.c.a.m.v.n;
import c.c.a.m.v.o;
import c.c.a.m.v.r;
import java.io.InputStream;
import java.net.URL;

public class f
implements n<URL, InputStream> {
    public final n<g, InputStream> a;

    public f(n<g, InputStream> n2) {
        this.a = n2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, c.c.a.m.o o2) {
        URL uRL = (URL)object;
        return this.a.a(new g(uRL), n2, n3, o2);
    }

    @Override
    public boolean b(Object object) {
        (URL)object;
        return true;
    }

    public static class a
    implements o<URL, InputStream> {
        @Override
        public n<URL, InputStream> b(r r2) {
            return new f(r2.b(g.class, InputStream.class));
        }
    }

}

