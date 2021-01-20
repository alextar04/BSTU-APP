/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.d
 *  h.p.b
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 */
package h.m.b;

import h.m.b.d;
import h.m.b.p;
import h.p.b;

public class o {
    public static final p a;

    public static {
        p p2;
        p2 = null;
        try {
            p p3;
            p2 = p3 = (p)Class.forName((String)"kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException throwable) {}
        if (p2 == null) {
            p2 = new p();
        }
        a = p2;
    }

    public static b a(Class class_) {
        if (a != null) {
            return new d(class_);
        }
        throw null;
    }
}

