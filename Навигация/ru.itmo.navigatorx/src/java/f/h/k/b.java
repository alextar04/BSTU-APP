/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package f.h.k;

import java.util.Objects;

public class b<F, S> {
    public final F a;
    public final S b;

    public boolean equals(Object object) {
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        boolean bl = Objects.equals(b2.a, null);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = Objects.equals(b2.b, null);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Pair{null null}";
    }
}

