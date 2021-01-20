/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.w.h.g
 *  f.e.a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicReference
 */
package c.c.a.p;

import c.c.a.m.q;
import c.c.a.m.u.j;
import c.c.a.m.u.u;
import c.c.a.m.w.h.e;
import c.c.a.m.w.h.g;
import c.c.a.s.i;
import f.e.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c {
    public static final u<?, ?, ?> c;
    public final a<i, u<?, ?, ?>> a = new a();
    public final AtomicReference<i> b = new AtomicReference();

    public static {
        j<Object, Object, Object> j2 = new j<Object, Object, Object>(Object.class, Object.class, Object.class, (List<q<Object, Object>>)Collections.emptyList(), (e<Object, Object>)new g(), null);
        u<Object, Object, Object> u2 = new u<Object, Object, Object>(Object.class, Object.class, Object.class, Collections.singletonList(j2), null);
        c = u2;
    }
}

