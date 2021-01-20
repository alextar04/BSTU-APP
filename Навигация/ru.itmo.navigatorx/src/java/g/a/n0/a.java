/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.n0;

public final class a
extends Enum<a> {
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    public static final /* enum */ a i;
    public static final /* synthetic */ a[] j;

    public static {
        a a2;
        e = new a();
        f = new a();
        g = new a();
        h = new a();
        i = a2 = new a();
        a[] arra = new a[]{e, f, g, h, a2};
        j = arra;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])j.clone();
    }
}

