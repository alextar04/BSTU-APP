/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.s;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class h
extends z<Object> {
    public static final a0 b = new a0(){

        @Override
        public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
            if (a2.a == Object.class) {
                return new h(j2);
            }
            return null;
        }
    };
    public final j a;

    public h(j j2) {
        this.a = j2;
    }

    @Override
    public Object a(c.e.b.e0.a a2) {
        int n2 = a2.T().ordinal();
        if (n2 != 0) {
            if (n2 != 2) {
                if (n2 != 5) {
                    if (n2 != 6) {
                        if (n2 != 7) {
                            if (n2 == 8) {
                                a2.P();
                                return null;
                            }
                            throw new IllegalStateException();
                        }
                        return a2.J();
                    }
                    return a2.K();
                }
                return a2.R();
            }
            s<String, Object> s2 = new s<String, Object>();
            a2.f();
            while (a2.v()) {
                s2.put(a2.N(), this.a(a2));
            }
            a2.p();
            return s2;
        }
        ArrayList arrayList = new ArrayList();
        a2.c();
        while (a2.v()) {
            arrayList.add(this.a(a2));
        }
        a2.m();
        return arrayList;
    }

    @Override
    public void b(c c2, Object object) {
        if (object == null) {
            c2.u();
            return;
        }
        j j2 = this.a;
        Class class_ = object.getClass();
        if (j2 != null) {
            z<Object> z2 = j2.b(new c.e.b.d0.a((Type)class_));
            if (z2 instanceof h) {
                c2.h();
                c2.p();
                return;
            }
            z2.b(c2, object);
            return;
        }
        throw null;
    }

}

