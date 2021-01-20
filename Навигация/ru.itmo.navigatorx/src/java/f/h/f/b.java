/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.h.f;

import c.b.a.a.a;

public final class b {
    public static final b e = new b(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public b(int n2, int n3, int n4, int n5) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
    }

    public static b a(int n2, int n3, int n4, int n5) {
        if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
            return e;
        }
        return new b(n2, n3, n4, n5);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b.class != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            if (this.d != b2.d) {
                return false;
            }
            if (this.a != b2.a) {
                return false;
            }
            if (this.c != b2.c) {
                return false;
            }
            return this.b == b2.b;
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * (31 * this.a + this.b) + this.c) + this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c((String)"Insets{left=");
        stringBuilder.append(this.a);
        stringBuilder.append(", top=");
        stringBuilder.append(this.b);
        stringBuilder.append(", right=");
        stringBuilder.append(this.c);
        stringBuilder.append(", bottom=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

