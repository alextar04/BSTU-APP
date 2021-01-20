/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m;

public final class b
extends Enum<b> {
    public static final /* enum */ b e;
    public static final /* enum */ b f;
    public static final b g;
    public static final /* synthetic */ b[] h;

    public static {
        b b2;
        e = new b();
        f = b2 = new b();
        b b3 = e;
        b[] arrb = new b[]{b3, b2};
        h = arrb;
        g = b3;
    }

    public static b valueOf(String string) {
        return (b)Enum.valueOf(b.class, (String)string);
    }

    public static b[] values() {
        return (b[])h.clone();
    }
}

