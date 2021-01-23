/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package i.f0.h;

import i.q;
import j.h;

public final class c {
    public static final h d = h.e(":");
    public static final h e = h.e(":status");
    public static final h f = h.e(":method");
    public static final h g = h.e(":path");
    public static final h h = h.e(":scheme");
    public static final h i = h.e(":authority");
    public final h a;
    public final h b;
    public final int c;

    public c(h h2, h h3) {
        this.a = h2;
        this.b = h3;
        this.c = 32 + h2.k() + h3.k();
    }

    public c(h h2, String string) {
        this(h2, h.e(string));
    }

    public c(String string, String string2) {
        this(h.e(string), h.e(string2));
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof c;
        boolean bl2 = false;
        if (bl) {
            c c2 = (c)object;
            boolean bl3 = this.a.equals(c2.a);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.b.equals(c2.b);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (527 + this.a.hashCode()) + this.b.hashCode();
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.a.o(), this.b.o()};
        return i.f0.c.n("%s: %s", arrobject);
    }

    public static interface a {
        public void a(q var1);
    }

}

