/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package i.f0.h;

public final class b
extends Enum<b> {
    public static final /* enum */ b f;
    public static final /* enum */ b g;
    public static final /* enum */ b h;
    public static final /* enum */ b i;
    public static final /* enum */ b j;
    public static final /* enum */ b k;
    public static final /* enum */ b l;
    public static final /* enum */ b m;
    public static final /* enum */ b n;
    public static final /* enum */ b o;
    public static final /* enum */ b p;
    public static final /* synthetic */ b[] q;
    public final int e;

    public static {
        b b2;
        f = new b(0);
        g = new b(1);
        h = new b(2);
        i = new b(3);
        j = new b(7);
        k = new b(8);
        l = new b(9);
        m = new b(10);
        n = new b(11);
        o = new b(12);
        p = b2 = new b(13);
        b[] arrb = new b[]{f, g, h, i, j, k, l, m, n, o, b2};
        q = arrb;
    }

    public b(int n3) {
        this.e = n3;
    }

    public static b a(int n2) {
        for (b b2 : b.values()) {
            if (b2.e != n2) continue;
            return b2;
        }
        return null;
    }

    public static b valueOf(String string) {
        return (b)Enum.valueOf(b.class, (String)string);
    }

    public static b[] values() {
        return (b[])q.clone();
    }
}

