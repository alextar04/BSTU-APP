/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package d.a.k1;

public final class a
extends Enum<a> {
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* synthetic */ a[] h;

    public static {
        a a2;
        a a3;
        a a4;
        a[] arra = new a[3];
        e = a4 = new a();
        arra[0] = a4;
        f = a2 = new a();
        arra[1] = a2;
        g = a3 = new a();
        arra[2] = a3;
        h = arra;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])h.clone();
    }
}

