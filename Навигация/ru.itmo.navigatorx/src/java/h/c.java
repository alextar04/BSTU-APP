/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h;

import h.m.b.j;
import java.io.Serializable;

public final class c<A, B>
implements Serializable {
    public final A e;
    public final B f;

    public c(A a2, B b2) {
        this.e = a2;
        this.f = b2;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof c)) break block3;
                c c2 = (c)object;
                if (j.a(this.e, c2.e) && j.a(this.f, c2.f)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.e;
        int n2 = a2 != null ? a2.hashCode() : 0;
        int n3 = n2 * 31;
        B b2 = this.f;
        int n4 = 0;
        if (b2 != null) {
            n4 = b2.hashCode();
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

