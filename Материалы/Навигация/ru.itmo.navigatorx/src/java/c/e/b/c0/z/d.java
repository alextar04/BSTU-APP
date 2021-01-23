/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.g;
import c.e.b.c0.t;
import c.e.b.c0.z.m;
import c.e.b.d0.a;
import c.e.b.j;
import c.e.b.n;
import c.e.b.v;
import c.e.b.y;
import c.e.b.z;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class d
implements a0 {
    public final g e;

    public d(g g2) {
        this.e = g2;
    }

    @Override
    public <T> z<T> a(j j2, a<T> a2) {
        c.e.b.b0.a a3 = (c.e.b.b0.a)a2.a.getAnnotation(c.e.b.b0.a.class);
        if (a3 == null) {
            return null;
        }
        return this.b(this.e, j2, a2, a3);
    }

    public z<?> b(g g2, j j2, a<?> a2, c.e.b.b0.a a3) {
        z z2;
        Object t2 = g2.a(new a((Type)a3.value())).a();
        if (t2 instanceof z) {
            z2 = (y)t2;
        } else if (t2 instanceof a0) {
            z2 = ((a0)t2).a(j2, a2);
        } else {
            boolean bl = t2 instanceof v;
            if (!bl && !(t2 instanceof n)) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Invalid attempt to bind an instance of ");
                stringBuilder.append(t2.getClass().getName());
                stringBuilder.append(" as a @JsonAdapter for ");
                stringBuilder.append(a2.toString());
                stringBuilder.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            v v2 = bl ? (v)t2 : null;
            boolean bl2 = t2 instanceof n;
            n n2 = null;
            if (bl2) {
                n2 = (n)t2;
            }
            n n3 = n2;
            z2 = new m(v2, n3, j2, a2, null);
        }
        if (z2 != null && a3.nullSafe()) {
            z2 = new y(z2);
        }
        return z2;
    }
}

