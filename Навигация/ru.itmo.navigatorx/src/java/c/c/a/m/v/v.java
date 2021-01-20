/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.o
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.v;

import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.r.d;

public class v<Model>
implements n<Model, Model> {
    public static final v<?> a = new v<Model>();

    @Override
    public n.a<Model> a(Model Model, int n2, int n3, o o2) {
        return new n.a<Model>(new d(Model), new b<Model>(Model));
    }

    @Override
    public boolean b(Model Model) {
        return true;
    }

    public static class a<Model>
    implements c.c.a.m.v.o<Model, Model> {
        public static final a<?> a = new a<Model>();

        @Override
        public n<Model, Model> b(r r2) {
            return v.a;
        }
    }

    public static class b<Model>
    implements c.c.a.m.t.d<Model> {
        public final Model e;

        public b(Model Model) {
            this.e = Model;
        }

        @Override
        public Class<Model> a() {
            return this.e.getClass();
        }

        @Override
        public void b() {
        }

        @Override
        public c.c.a.m.a c() {
            return c.c.a.m.a.e;
        }

        @Override
        public void cancel() {
        }

        @Override
        public void e(e e2, d.a<? super Model> a2) {
            a2.f(this.e);
        }
    }

}

