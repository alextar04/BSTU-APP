/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.q0.h;

public final class a
extends Enum<a> {
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* synthetic */ a[] h;

    public static {
        a a2;
        e = new a(0);
        f = new a(1);
        g = a2 = new a(2);
        a[] arra = new a[]{e, f, a2};
        h = arra;
    }

    public a(byte by) {
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])h.clone();
    }
}

