/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.a.a$a
 *  d.a.a.a$b
 *  d.a.a.a$c
 *  d.a.f1
 *  h.k.f
 *  h.k.f$a
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package d.a.a;

import d.a.a.a;
import d.a.a.p;
import d.a.a.t;
import d.a.f1;
import h.k.f;
import h.m.b.j;

public final class a {
    public static final p a = new p("ZERO");
    public static final h.m.a.p<Object, f.a, Object> b = b.f;
    public static final h.m.a.p<f1<?>, f.a, f1<?>> c = c.f;
    public static final h.m.a.p<t, f.a, t> d = a.h;
    public static final h.m.a.p<t, f.a, t> e = a.g;

    public static final void a(f f2, Object object) {
        if (object == a) {
            return;
        }
        if (object instanceof t) {
            ((t)object).b = 0;
            f2.fold(object, e);
            return;
        }
        Object object2 = f2.fold(null, c);
        if (object2 != null) {
            ((f1)object2).x(f2, object);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final Object b(f f2) {
        Object object = f2.fold((Object)0, b);
        j.c((Object)object);
        return object;
    }

    public static final Object c(f f2, Object object) {
        if (object == null) {
            object = a.b(f2);
        }
        if (object == Integer.valueOf((int)0)) {
            return a;
        }
        if (object instanceof Integer) {
            return f2.fold((Object)new t(f2, ((Number)object).intValue()), d);
        }
        if (object != null) {
            return ((f1)object).B(f2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}

