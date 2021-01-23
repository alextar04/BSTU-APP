/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.q0.h;

import c.b.a.a.a;

public final class c
extends Enum<c> {
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* synthetic */ c[] i;
    public final int e;

    public static {
        c c2;
        f = new c(0);
        g = new c(1);
        h = c2 = new c(2);
        c[] arrc = new c[]{f, g, c2};
        i = arrc;
    }

    public c(int n3) {
        this.e = n3;
    }

    public static c a(long l2) {
        for (c c2 : c.values()) {
            if ((long)c2.e != l2) continue;
            return c2;
        }
        throw new IllegalArgumentException(a.f("Unknown connection state code: ", l2));
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])i.clone();
    }
}

