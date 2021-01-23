/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 */
package c.e.b.d0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a<T> {
    public final Class<? super T> a;
    public final Type b;
    public final int c;

    public a() {
        Type type = a.class.getGenericSuperclass();
        if (!(type instanceof Class)) {
            Type type2;
            this.b = type2 = c.e.b.c0.a.a(((ParameterizedType)type).getActualTypeArguments()[0]);
            this.a = c.e.b.c0.a.e(type2);
            this.c = this.b.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public a(Type type) {
        if (type != null) {
            Type type2;
            this.b = type2 = c.e.b.c0.a.a(type);
            this.a = c.e.b.c0.a.e(type2);
            this.c = this.b.hashCode();
            return;
        }
        throw null;
    }

    public final boolean equals(Object object) {
        return object instanceof a && c.e.b.c0.a.c(this.b, ((a)object).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return c.e.b.c0.a.i(this.b);
    }
}

