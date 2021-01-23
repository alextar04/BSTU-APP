/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  k.a.a1.c
 *  k.a.d0
 *  k.a.h0
 *  k.a.j0
 *  k.a.l
 */
package k.a.w0;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k.a.a1.a;
import k.a.a1.b;
import k.a.a1.c;
import k.a.a1.d;
import k.a.a1.e;
import k.a.a1.f;
import k.a.d0;
import k.a.h0;
import k.a.i0;
import k.a.j0;
import k.a.l;
import k.a.o0;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

public class b0 {
    public final Map<i0, Class<?>> a;

    public b0() {
        this(Collections.emptyMap());
    }

    public b0(Map<i0, Class<?>> map) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        hashMap.put((Object)i0.j, List.class);
        this.a.put((Object)i0.k, a.class);
        this.a.put((Object)i0.n, Boolean.class);
        this.a.put((Object)i0.o, Date.class);
        this.a.put((Object)i0.r, l.class);
        this.a.put((Object)i0.i, o0.class);
        this.a.put((Object)i0.g, Double.class);
        this.a.put((Object)i0.v, Integer.class);
        this.a.put((Object)i0.x, Long.class);
        this.a.put((Object)i0.y, Decimal128.class);
        this.a.put((Object)i0.A, d.class);
        this.a.put((Object)i0.z, e.class);
        this.a.put((Object)i0.s, b.class);
        this.a.put((Object)i0.u, c.class);
        this.a.put((Object)i0.m, ObjectId.class);
        this.a.put((Object)i0.q, d0.class);
        this.a.put((Object)i0.h, String.class);
        this.a.put((Object)i0.t, f.class);
        this.a.put((Object)i0.w, h0.class);
        this.a.put((Object)i0.l, j0.class);
        this.a.putAll(map);
    }

    public Class<?> a(i0 i02) {
        return (Class)this.a.get((Object)i02);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b0.class != object.getClass()) {
                return false;
            }
            b0 b02 = (b0)object;
            return this.a.equals(b02.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

