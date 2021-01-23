/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.z.n;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E>
extends z<Object> {
    public static final a0 c = new a0(){

        @Override
        public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
            Type type = a2.b;
            boolean bl = type instanceof GenericArrayType;
            if (!(bl || type instanceof Class && ((Class)type).isArray())) {
                return null;
            }
            Object object = bl ? ((GenericArrayType)type).getGenericComponentType() : ((Class)type).getComponentType();
            return new a(j2, j2.b(new c.e.b.d0.a((Type)object)), c.e.b.c0.a.e(object));
        }
    };
    public final Class<E> a;
    public final z<E> b;

    public a(j j2, z<E> z2, Class<E> class_) {
        this.b = new n<E>(j2, z2, (Type)class_);
        this.a = class_;
    }

    @Override
    public Object a(c.e.b.e0.a a2) {
        if (a2.T() == b.m) {
            a2.P();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a2.c();
        while (a2.v()) {
            arrayList.add(this.b.a(a2));
        }
        a2.m();
        int n2 = arrayList.size();
        Object object = Array.newInstance(this.a, (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Array.set((Object)object, (int)i2, (Object)arrayList.get(i2));
        }
        return object;
    }

    @Override
    public void b(c c2, Object object) {
        if (object == null) {
            c2.u();
            return;
        }
        c2.f();
        int n2 = Array.getLength((Object)object);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = Array.get((Object)object, (int)i2);
            this.b.b(c2, object2);
        }
        c2.m();
    }

}

