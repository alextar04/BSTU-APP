/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
package c.e.b.c0.z;

import c.e.b.c0.z.j;
import c.e.b.e0.a;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class n<T>
extends z<T> {
    public final j a;
    public final z<T> b;
    public final Type c;

    public n(j j2, z<T> z2, Type type) {
        this.a = j2;
        this.b = z2;
        this.c = type;
    }

    @Override
    public T a(a a2) {
        return this.b.a(a2);
    }

    @Override
    public void b(c c2, T t2) {
        z<T> z2;
        z<T> z3 = this.b;
        Type type = this.c;
        if (t2 != null && (type == Object.class || type instanceof TypeVariable || type instanceof Class)) {
            type = t2.getClass();
        }
        if (type != this.c && (z3 = this.a.b(new c.e.b.d0.a(type))) instanceof j.a && !((z2 = this.b) instanceof j.a)) {
            z3 = z2;
        }
        z3.b(c2, t2);
    }
}

