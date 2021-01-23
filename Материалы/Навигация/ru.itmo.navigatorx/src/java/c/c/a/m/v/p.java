/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package c.c.a.m.v;

import c.c.a.m.v.n;
import c.c.a.m.v.r;
import f.h.k.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p {
    public final r a;
    public final a b;

    public p(c<List<Throwable>> c2) {
        r r2 = new r(c2);
        this.b = new a();
        this.a = r2;
    }

    public static class c.c.a.m.v.p$a {
        public final Map<Class<?>, a<?>> a = new HashMap();

        public static class a<Model> {
            public final List<n<Model, ?>> a;

            public a(List<n<Model, ?>> list) {
                this.a = list;
            }
        }

    }

}

