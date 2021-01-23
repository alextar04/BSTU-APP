/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package g.a;

public final class l0
extends Enum<l0> {
    public static final /* enum */ l0 f;
    public static final /* enum */ l0 g;
    public static final /* synthetic */ l0[] h;
    public final boolean e;

    public static {
        l0 l02;
        f = new l0(true);
        g = l02 = new l0(false);
        l0[] arrl0 = new l0[]{f, l02};
        h = arrl0;
    }

    public l0(boolean bl) {
        this.e = bl;
    }

    public static l0 valueOf(String string) {
        return (l0)Enum.valueOf(l0.class, (String)string);
    }

    public static l0[] values() {
        return (l0[])h.clone();
    }
}

