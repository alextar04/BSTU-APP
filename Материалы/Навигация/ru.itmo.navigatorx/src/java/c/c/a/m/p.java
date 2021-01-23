/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m;

public final class p
extends Enum<p> {
    public static final /* enum */ p e;
    public static final /* enum */ p f;
    public static final /* synthetic */ p[] g;

    public static {
        p p2;
        e = new p();
        f = p2 = new p();
        p[] arrp = new p[]{e, p2};
        g = arrp;
    }

    public static p valueOf(String string) {
        return (p)Enum.valueOf(p.class, (String)string);
    }

    public static p[] values() {
        return (p[])g.clone();
    }
}

