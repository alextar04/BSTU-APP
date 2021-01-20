/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.c0.a0.a
 *  c.e.b.c0.a0.c
 *  java.lang.Object
 *  java.lang.reflect.AccessibleObject
 */
package c.e.b.c0.a0;

import c.e.b.c0.a0.a;
import c.e.b.c0.a0.c;
import c.e.b.c0.p;
import java.lang.reflect.AccessibleObject;

public abstract class b {
    public static final b a;

    public static {
        Object object = p.a < 9 ? new a() : new c();
        a = object;
    }

    public abstract void a(AccessibleObject var1);
}

