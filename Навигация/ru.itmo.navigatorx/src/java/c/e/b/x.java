/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.x$a
 *  c.e.b.x$b
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.b;

import c.e.b.x;

public abstract class x
extends Enum<x> {
    public static final /* enum */ x e = new a("DEFAULT", 0);
    public static final /* enum */ x f;
    public static final /* synthetic */ x[] g;

    public static {
        b b2 = new b("STRING", 1);
        f = b2;
        x[] arrx = new x[]{e, b2};
        g = arrx;
    }

    public x(a a2) {
    }

    public static x valueOf(String string) {
        return (x)Enum.valueOf(x.class, (String)string);
    }

    public static x[] values() {
        return (x[])g.clone();
    }
}

