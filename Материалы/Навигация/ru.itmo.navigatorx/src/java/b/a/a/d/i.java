/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.a.a.d;

import b.a.a.b.e;
import h.m.b.j;
import java.util.List;

public final class i {
    public final List<e> a;
    public final a b;

    public i(List<e> list, a a2) {
        j.e(list, (String)"path");
        j.e((Object)((Object)a2), (String)"breakType");
        this.a = list;
        this.b = a2;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* synthetic */ a[] h;

        public static {
            a a2;
            a a3;
            a a4;
            a[] arra = new a[3];
            e = a2 = new a();
            arra[0] = a2;
            f = a4 = new a();
            arra[1] = a4;
            g = a3 = new a();
            arra[2] = a3;
            h = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])h.clone();
        }
    }

}

