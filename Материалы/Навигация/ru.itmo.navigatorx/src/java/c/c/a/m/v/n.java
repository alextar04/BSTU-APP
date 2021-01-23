/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.o
 *  f.b.k.h
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package c.c.a.m.v;

import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import f.b.k.h;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {
    public a<Data> a(Model var1, int var2, int var3, o var4);

    public boolean b(Model var1);

    public static class a<Data> {
        public final m a;
        public final List<m> b;
        public final d<Data> c;

        public a(m m2, d<Data> d2) {
            List list = Collections.emptyList();
            h.i.p(m2, "Argument must not be null");
            this.a = m2;
            h.i.p(list, "Argument must not be null");
            this.b = list;
            h.i.p(d2, "Argument must not be null");
            this.c = d2;
        }
    }

}

