/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package b.a.a.b;

import c.b.a.a.a;
import h.m.b.j;
import java.util.List;

public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List<String> f;
    public final String g;

    public f(String string, String string2, String string3, String string4, String string5, List<String> list, String string6) {
        j.e(list, (String)"equipment");
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = list;
        this.g = null;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof f)) break block3;
                f f2 = (f)object;
                if (j.a((Object)this.a, (Object)f2.a) && j.a((Object)this.b, (Object)f2.b) && j.a((Object)this.c, (Object)f2.c) && j.a((Object)this.d, (Object)f2.d) && j.a((Object)this.e, (Object)f2.e) && j.a(this.f, f2.f) && j.a((Object)this.g, (Object)f2.g)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String string = this.a;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.b;
        int n4 = string2 != null ? string2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string3 = this.c;
        int n6 = string3 != null ? string3.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string4 = this.d;
        int n8 = string4 != null ? string4.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        String string5 = this.e;
        int n10 = string5 != null ? string5.hashCode() : 0;
        int n11 = 31 * (n9 + n10);
        List<String> list = this.f;
        int n12 = list != null ? list.hashCode() : 0;
        int n13 = 31 * (n11 + n12);
        String string6 = this.g;
        int n14 = 0;
        if (string6 != null) {
            n14 = string6.hashCode();
        }
        return n13 + n14;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("RoomInfo(square=");
        stringBuilder.append(this.a);
        stringBuilder.append(", name=");
        stringBuilder.append(this.b);
        stringBuilder.append(", capacity=");
        stringBuilder.append(this.c);
        stringBuilder.append(", realUsage=");
        stringBuilder.append(this.d);
        stringBuilder.append(", departmentName=");
        stringBuilder.append(this.e);
        stringBuilder.append(", equipment=");
        stringBuilder.append(this.f);
        stringBuilder.append(", bookUrl=");
        return a.l(stringBuilder, this.g, ")");
    }
}

