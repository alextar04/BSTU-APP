/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.WildcardType
 *  java.util.Collection
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.g;
import c.e.b.c0.t;
import c.e.b.c0.z.n;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

public final class b
implements a0 {
    public final g e;

    public b(g g2) {
        this.e = g2;
    }

    @Override
    public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
        Type type = a2.b;
        Class class_ = a2.a;
        if (!Collection.class.isAssignableFrom(class_)) {
            return null;
        }
        Type type2 = c.e.b.c0.a.f(type, class_, Collection.class);
        if (type2 instanceof WildcardType) {
            type2 = ((WildcardType)type2).getUpperBounds()[0];
        }
        Type type3 = type2 instanceof ParameterizedType ? ((ParameterizedType)type2).getActualTypeArguments()[0] : Object.class;
        return new a(j2, type3, j2.b(new c.e.b.d0.a(type3)), this.e.a(a2));
    }

    public static final class a<E>
    extends z<Collection<E>> {
        public final z<E> a;
        public final t<? extends Collection<E>> b;

        public a(j j2, Type type, z<E> z2, t<? extends Collection<E>> t2) {
            this.a = new n<E>(j2, z2, type);
            this.b = t2;
        }

        @Override
        public Object a(c.e.b.e0.a a2) {
            if (a2.T() == c.e.b.e0.b.m) {
                a2.P();
                return null;
            }
            Collection<E> collection = this.b.a();
            a2.c();
            while (a2.v()) {
                collection.add(this.a.a(a2));
            }
            a2.m();
            return collection;
        }

        @Override
        public void b(c c2, Object object) {
            Collection collection = (Collection)object;
            if (collection == null) {
                c2.u();
                return;
            }
            c2.f();
            for (Object object2 : collection) {
                this.a.b(c2, object2);
            }
            c2.m();
        }
    }

}

