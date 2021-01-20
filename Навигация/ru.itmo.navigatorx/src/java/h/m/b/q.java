/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h.m.b;

import h.m.a.a;
import h.m.a.b;
import h.m.a.c;
import h.m.a.d;
import h.m.a.e;
import h.m.a.f;
import h.m.a.h;
import h.m.a.i;
import h.m.a.k;
import h.m.a.l;
import h.m.a.m;
import h.m.a.n;
import h.m.a.o;
import h.m.a.p;
import h.m.a.r;
import h.m.a.s;
import h.m.a.t;
import h.m.a.u;
import h.m.a.v;
import h.m.a.w;
import h.m.b.g;
import h.m.b.j;

public class q {
    public static Object a(Object object, int n2) {
        int n3 = 1;
        int n4 = object instanceof g ? ((g)object).b() : (object instanceof a ? 0 : (object instanceof l ? n3 : (object instanceof p ? 2 : (object instanceof h.m.a.q ? 3 : (object instanceof r ? 4 : (object instanceof s ? 5 : (object instanceof t ? 6 : (object instanceof u ? 7 : (object instanceof v ? 8 : (object instanceof w ? 9 : (object instanceof b ? 10 : (object instanceof c ? 11 : (object instanceof d ? 12 : (object instanceof e ? 13 : (object instanceof f ? 14 : (object instanceof h.m.a.g ? 15 : (object instanceof h ? 16 : (object instanceof i ? 17 : (object instanceof h.m.a.j ? 18 : (object instanceof k ? 19 : (object instanceof m ? 20 : (object instanceof n ? 21 : (object instanceof o ? 22 : -1)))))))))))))))))))))));
        if (n4 != n2) {
            n3 = 0;
        }
        if (n3 != 0) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("kotlin.jvm.functions.Function");
        stringBuilder.append(n2);
        q.b(object, stringBuilder.toString());
        throw null;
    }

    public static void b(Object object, String string) {
        String string2 = object == null ? "null" : object.getClass().getName();
        ClassCastException classCastException = new ClassCastException(c.b.a.a.a.k(string2, " cannot be cast to ", string));
        j.i(classCastException, q.class.getName());
        throw classCastException;
    }
}

