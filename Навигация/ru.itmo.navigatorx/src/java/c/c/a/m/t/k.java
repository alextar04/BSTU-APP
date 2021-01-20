/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.t;

import c.c.a.m.t.e;
import c.c.a.m.u.c0.b;
import c.c.a.m.w.c.s;
import java.io.InputStream;

public final class k
implements e<InputStream> {
    public final s a;

    public k(InputStream inputStream, b b2) {
        s s2;
        this.a = s2 = new s(inputStream, b2);
        s2.mark(5242880);
    }

    @Override
    public void b() {
        this.a.f();
    }

    public InputStream c() {
        this.a.reset();
        return this.a;
    }

    public static final class a
    implements e.a<InputStream> {
        public final b a;

        public a(b b2) {
            this.a = b2;
        }

        @Override
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override
        public e b(Object object) {
            return new k((InputStream)object, this.a);
        }
    }

}

