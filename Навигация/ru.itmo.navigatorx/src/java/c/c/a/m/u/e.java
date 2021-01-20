/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 */
package c.c.a.m.u;

import c.b.a.a.a;
import c.c.a.m.m;
import java.security.MessageDigest;

public final class e
implements m {
    public final m b;
    public final m c;

    public e(m m2, m m3) {
        this.b = m2;
        this.c = m3;
    }

    @Override
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof e;
        boolean bl2 = false;
        if (bl) {
            e e2 = (e)object;
            boolean bl3 = this.b.equals(e2.b);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.c.equals(e2.c);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    @Override
    public int hashCode() {
        return 31 * this.b.hashCode() + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("DataCacheKey{sourceKey=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", signature=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

