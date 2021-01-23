/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m;

public final class c
extends Enum<c> {
    public static final /* enum */ c e;
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* synthetic */ c[] h;

    public static {
        c c2;
        e = new c();
        f = new c();
        g = c2 = new c();
        c[] arrc = new c[]{e, f, c2};
        h = arrc;
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])h.clone();
    }
}

