/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.c
 *  c.e.b.c0.o
 *  c.e.b.c0.z.a
 *  c.e.b.c0.z.b
 *  c.e.b.c0.z.c
 *  c.e.b.c0.z.d
 *  c.e.b.c0.z.g
 *  c.e.b.c0.z.h
 *  c.e.b.c0.z.j
 *  c.e.b.c0.z.k
 *  c.e.b.c0.z.l
 *  c.e.b.c0.z.p
 *  c.e.b.c0.z.q
 *  c.e.b.e
 *  c.e.b.f
 *  c.e.b.g
 *  c.e.b.h
 *  c.e.b.i
 *  c.e.b.j$a
 *  c.e.b.y
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
package c.e.b;

import c.e.b.a0;
import c.e.b.c;
import c.e.b.c0.o;
import c.e.b.c0.z.b;
import c.e.b.c0.z.l;
import c.e.b.c0.z.p;
import c.e.b.c0.z.q;
import c.e.b.d;
import c.e.b.e;
import c.e.b.f;
import c.e.b.g;
import c.e.b.h;
import c.e.b.i;
import c.e.b.j;
import c.e.b.k;
import c.e.b.x;
import c.e.b.y;
import c.e.b.z;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/*
 * Exception performing whole class analysis.
 */
public final class j {
    public static final c.e.b.d0.a<?> h;
    public final ThreadLocal<Map<c.e.b.d0.a<?>, a<?>>> a;
    public final Map<c.e.b.d0.a<?>, z<?>> b;
    public final c.e.b.c0.g c;
    public final c.e.b.c0.z.d d;
    public final List<a0> e;
    public final boolean f;
    public final boolean g;

    public static {
        h = new c.e.b.d0.a((Type)Object.class);
    }

    public j() {
        c.e.b.c0.z.d d2;
        o o2 = o.j;
        c c2 = c.e;
        Map map = Collections.emptyMap();
        x x2 = x.e;
        Collections.emptyList();
        Collections.emptyList();
        List list = Collections.emptyList();
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.c = new c.e.b.c0.g(map);
        this.f = false;
        this.g = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)c.e.b.c0.z.o.Y);
        arrayList.add((Object)c.e.b.c0.z.h.b);
        arrayList.add((Object)o2);
        arrayList.addAll((Collection)list);
        arrayList.add((Object)c.e.b.c0.z.o.D);
        arrayList.add((Object)c.e.b.c0.z.o.m);
        arrayList.add((Object)c.e.b.c0.z.o.g);
        arrayList.add((Object)c.e.b.c0.z.o.i);
        arrayList.add((Object)c.e.b.c0.z.o.k);
        g g2 = x2 == x.e ? c.e.b.c0.z.o.t : new g();
        arrayList.add((Object)new q(Long.TYPE, Long.class, (z)g2));
        arrayList.add((Object)new q(Double.TYPE, Double.class, (z)new e(this)));
        arrayList.add((Object)new q(Float.TYPE, Float.class, (z)new f(this)));
        arrayList.add((Object)c.e.b.c0.z.o.x);
        arrayList.add((Object)c.e.b.c0.z.o.o);
        arrayList.add((Object)c.e.b.c0.z.o.q);
        arrayList.add((Object)new p(AtomicLong.class, (z)new y((z)new h((z)g2))));
        arrayList.add((Object)new p(AtomicLongArray.class, (z)new y((z)new i((z)g2))));
        arrayList.add((Object)c.e.b.c0.z.o.s);
        arrayList.add((Object)c.e.b.c0.z.o.z);
        arrayList.add((Object)c.e.b.c0.z.o.F);
        arrayList.add((Object)c.e.b.c0.z.o.H);
        arrayList.add((Object)new p(BigDecimal.class, c.e.b.c0.z.o.B));
        arrayList.add((Object)new p(BigInteger.class, c.e.b.c0.z.o.C));
        arrayList.add((Object)c.e.b.c0.z.o.J);
        arrayList.add((Object)c.e.b.c0.z.o.L);
        arrayList.add((Object)c.e.b.c0.z.o.P);
        arrayList.add((Object)c.e.b.c0.z.o.R);
        arrayList.add((Object)c.e.b.c0.z.o.W);
        arrayList.add((Object)c.e.b.c0.z.o.N);
        arrayList.add((Object)c.e.b.c0.z.o.d);
        arrayList.add((Object)c.e.b.c0.z.c.b);
        arrayList.add((Object)c.e.b.c0.z.o.U);
        arrayList.add((Object)l.b);
        arrayList.add((Object)c.e.b.c0.z.k.b);
        arrayList.add((Object)c.e.b.c0.z.o.S);
        arrayList.add((Object)c.e.b.c0.z.a.c);
        arrayList.add((Object)c.e.b.c0.z.o.b);
        arrayList.add((Object)new b(this.c));
        arrayList.add((Object)new c.e.b.c0.z.g(this.c, false));
        this.d = d2 = new c.e.b.c0.z.d(this.c);
        arrayList.add((Object)d2);
        arrayList.add((Object)c.e.b.c0.z.o.Z);
        arrayList.add((Object)new c.e.b.c0.z.j(this.c, (d)c2, o2, this.d));
        this.e = Collections.unmodifiableList((List)arrayList);
    }

    public static void a(double d2) {
        if (!Double.isNaN((double)d2) && !Double.isInfinite((double)d2)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public <T> z<T> b(c.e.b.d0.a<T> a2) {
        a a3;
        z z2 = (z)this.b.get(a2);
        if (z2 != null) {
            return z2;
        }
        Map map = (Map)this.a.get();
        boolean bl = false;
        if (map == null) {
            map = new HashMap();
            this.a.set((Object)map);
            bl = true;
        }
        if ((a3 = map.get(a2)) != null) {
            return a3;
        }
        try {
            a a4 = new /* Unavailable Anonymous Inner Class!! */;
            map.put(a2, (Object)a4);
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                z<T> z3 = ((a0)iterator.next()).a(this, a2);
                if (z3 == null) continue;
                if (a4.a == null) {
                    a4.a = z3;
                    this.b.put(a2, z3);
                    return z3;
                }
                throw new AssertionError();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GSON (2.8.6) cannot handle ");
            stringBuilder.append(a2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        finally {
            map.remove(a2);
            if (bl) {
                this.a.remove();
            }
        }
    }

    public <T> z<T> c(a0 a02, c.e.b.d0.a<T> a2) {
        if (!this.e.contains((Object)a02)) {
            a02 = this.d;
        }
        boolean bl = false;
        for (a0 a03 : this.e) {
            if (!bl) {
                if (a03 != a02) continue;
                bl = true;
                continue;
            }
            z<T> z2 = a03.a(this, a2);
            if (z2 == null) continue;
            return z2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GSON cannot serialize ");
        stringBuilder.append(a2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.f);
        stringBuilder.append(",factories:");
        stringBuilder.append(this.e);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append((Object)this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

