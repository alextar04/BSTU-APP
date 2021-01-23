/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package k.a;

public final class g
extends Enum<g> {
    public static final /* enum */ g f;
    public static final /* enum */ g g;
    public static final /* enum */ g h;
    public static final /* enum */ g i;
    public static final /* enum */ g j;
    public static final /* enum */ g k;
    public static final /* enum */ g l;
    public static final /* synthetic */ g[] m;
    public final byte e;

    public static {
        g g2;
        f = new g(0);
        g = new g(1);
        h = new g(2);
        i = new g(3);
        j = new g(4);
        k = new g(5);
        l = g2 = new g(-128);
        g[] arrg = new g[]{f, g, h, i, j, k, g2};
        m = arrg;
    }

    public g(byte by) {
        this.e = by;
    }

    public static g valueOf(String string) {
        return (g)Enum.valueOf(g.class, (String)string);
    }

    public static g[] values() {
        return (g[])m.clone();
    }
}

