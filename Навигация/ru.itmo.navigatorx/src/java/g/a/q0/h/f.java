/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.q0.h;

public final class f
extends Enum<f> {
    public static final /* enum */ f e;
    public static final /* enum */ f f;
    public static final /* synthetic */ f[] g;

    public static {
        f f2;
        e = new f();
        f = f2 = new f();
        f[] arrf = new f[]{e, f2};
        g = arrf;
    }

    public static f valueOf(String string) {
        return (f)Enum.valueOf(f.class, (String)string);
    }

    public static f[] values() {
        return (f[])g.clone();
    }
}

