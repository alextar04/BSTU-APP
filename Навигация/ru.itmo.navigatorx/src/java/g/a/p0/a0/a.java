/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package g.a.p0.a0;

public class a<F, S> {
    public F a;
    public S b;

    public a(F f2, S s2) {
        this.a = f2;
        this.b = s2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        F f2 = a2.a;
        F f3 = this.a;
        boolean bl = f2 == f3 || f2 != null && f2.equals(f3);
        boolean bl2 = false;
        if (bl) {
            S s2 = a2.b;
            S s3 = this.b;
            boolean bl3 = s2 == s3 || s2 != null && s2.equals(s3);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        F f2 = this.a;
        int n2 = f2 == null ? 0 : f2.hashCode();
        S s2 = this.b;
        int n3 = s2 == null ? 0 : s2.hashCode();
        return n2 ^ n3;
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Pair{");
        stringBuilder.append(String.valueOf(this.a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

