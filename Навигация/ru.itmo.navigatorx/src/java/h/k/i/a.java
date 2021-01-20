/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package h.k.i;

public final class a
extends Enum<a> {
    public static final /* enum */ a e;
    public static final /* synthetic */ a[] f;

    public static {
        a a2;
        a[] arra = new a[3];
        e = a2 = new a();
        arra[0] = a2;
        arra[1] = new a();
        arra[2] = new a();
        f = arra;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])f.clone();
    }
}

