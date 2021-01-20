/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.a.a.a.a.j;

import b.a.a.b.d;
import c.b.a.a.a;
import h.m.b.j;

public final class c {
    public final d a;
    public final boolean b;
    public final boolean c;
    public final String d;

    public c(d d2, boolean bl, boolean bl2, String string) {
        j.e((Object)d2, (String)"marker");
        this.a = d2;
        this.b = bl;
        this.c = bl2;
        this.d = string;
    }

    public /* synthetic */ c(d d2, boolean bl, boolean bl2, String string, int n2) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            string = null;
        }
        this(d2, bl, bl2, string);
    }

    public static c a(c c2, d d2, boolean bl, boolean bl2, String string, int n2) {
        d d3 = (n2 & 1) != 0 ? c2.a : null;
        if ((n2 & 2) != 0) {
            bl = c2.b;
        }
        if ((n2 & 4) != 0) {
            bl2 = c2.c;
        }
        String string2 = (n2 & 8) != 0 ? c2.d : null;
        if (c2 != null) {
            j.e((Object)d3, (String)"marker");
            return new c(d3, bl, bl2, string2);
        }
        throw null;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof c)) break block3;
                c c2 = (c)object;
                if (j.a((Object)this.a, (Object)c2.a) && this.b == c2.b && this.c == c2.c && j.a((Object)this.d, (Object)c2.d)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        d d2 = this.a;
        int n2 = d2 != null ? d2.hashCode() : 0;
        int n3 = n2 * 31;
        int n4 = this.b;
        int n5 = 1;
        if (n4 != 0) {
            n4 = n5;
        }
        int n6 = 31 * (n3 + n4);
        boolean bl = this.c;
        if (!bl) {
            n5 = bl ? 1 : 0;
        }
        int n7 = 31 * (n6 + n5);
        String string = this.d;
        int n8 = 0;
        if (string != null) {
            n8 = string.hashCode();
        }
        return n7 + n8;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("MarkerData(marker=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", isSelected=");
        stringBuilder.append(this.b);
        stringBuilder.append(", forceVisible=");
        stringBuilder.append(this.c);
        stringBuilder.append(", additionalText=");
        return a.l(stringBuilder, this.d, ")");
    }
}

