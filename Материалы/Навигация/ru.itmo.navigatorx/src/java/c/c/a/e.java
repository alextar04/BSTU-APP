/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a;

public final class e
extends Enum<e> {
    public static final /* enum */ e e;
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    public static final /* synthetic */ e[] i;

    public static {
        e e2;
        e = new e();
        f = new e();
        g = new e();
        h = e2 = new e();
        e[] arre = new e[]{e, f, g, e2};
        i = arre;
    }

    public static e valueOf(String string) {
        return (e)Enum.valueOf(e.class, (String)string);
    }

    public static e[] values() {
        return (e[])i.clone();
    }
}

