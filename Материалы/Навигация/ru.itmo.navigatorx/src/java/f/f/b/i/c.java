/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.f
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 */
package f.f.b.i;

import f.f.b.g;
import f.f.b.i.d;
import f.f.b.i.f;
import java.util.HashSet;

public class c {
    public HashSet<c> a = null;
    public final d b;
    public final a c;
    public c d;
    public int e = 0;
    public int f = -1;
    public g g;

    public c(d d2, a a2) {
        this.b = d2;
        this.c = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean a(c var1_1, int var2_2, int var3_3, boolean var4_4) {
        block16 : {
            block18 : {
                block17 : {
                    if (var1_1 == null) {
                        this.e();
                        return true;
                    }
                    if (var4_4) break block16;
                    var6_5 = a.m;
                    var7_6 = a.l;
                    var8_7 = a.j;
                    var9_8 = var1_1.c;
                    var10_9 = this.c;
                    if (var9_8 != var10_9) break block17;
                    if (var10_9 == var8_7) {
                        if (var1_1.b.w == false) return false;
                        if (!this.b.w) {
                            return false;
                        }
                    }
                    ** GOTO lbl38
                }
                switch (var10_9.ordinal()) {
                    default: {
                        throw new AssertionError((Object)this.c.name());
                    }
                    case 6: {
                        if (var9_8 == var8_7) return false;
                        if (var9_8 == var7_6) return false;
                        if (var9_8 == var6_5) return false;
                        ** GOTO lbl38
                    }
                    case 2: 
                    case 4: {
                        var12_11 = var9_8 == a.g || var9_8 == a.i;
                        if (!(var1_1.b instanceof f)) ** GOTO lbl31
                        if (!var12_11) {
                            if (var9_8 != var6_5) return false;
                        }
                        ** GOTO lbl38
lbl31: // 1 sources:
                        var11_10 = var12_11;
                        ** break;
                    }
                    case 1: 
                    case 3: {
                        var11_10 = var9_8 == a.f || var9_8 == a.h;
                        if (!(var1_1.b instanceof f)) break block18;
                        if (!var11_10) {
                            if (var9_8 != var7_6) return false;
                        }
lbl38: // 6 sources:
                        var11_10 = true;
                        break block18;
                    }
                    case 0: 
                    case 5: 
                    case 7: 
                    case 8: 
                }
                return false;
            }
            if (!var11_10) {
                return false;
            }
        }
        this.d = var1_1;
        if (var1_1.a == null) {
            var1_1.a = new HashSet();
        }
        this.d.a.add((Object)this);
        this.e = var2_2 > 0 ? var2_2 : 0;
        this.f = var3_3;
        return true;
    }

    public int b() {
        c c2;
        if (this.b.X == 8) {
            return 0;
        }
        int n2 = this.f;
        if (n2 > -1 && (c2 = this.d) != null && c2.b.X == 8) {
            return n2;
        }
        return this.e;
    }

    public boolean c() {
        HashSet<c> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        for (c c2 : hashSet) {
            c c3;
            switch (c2.c.ordinal()) {
                default: {
                    throw new AssertionError((Object)c2.c.name());
                }
                case 4: {
                    c3 = c2.b.z;
                    break;
                }
                case 3: {
                    c3 = c2.b.y;
                    break;
                }
                case 2: {
                    c3 = c2.b.B;
                    break;
                }
                case 1: {
                    c3 = c2.b.A;
                    break;
                }
                case 0: 
                case 5: 
                case 6: 
                case 7: 
                case 8: {
                    c3 = null;
                }
            }
            if (!c3.d()) continue;
            return true;
        }
        return false;
    }

    public boolean d() {
        return this.d != null;
    }

    public void e() {
        HashSet<c> hashSet;
        c c2 = this.d;
        if (c2 != null && (hashSet = c2.a) != null) {
            hashSet.remove((Object)this);
        }
        this.d = null;
        this.e = 0;
        this.f = -1;
    }

    public void f() {
        g g2 = this.g;
        if (g2 == null) {
            this.g = new g(g.a.e);
            return;
        }
        g2.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.Y);
        stringBuilder.append(":");
        stringBuilder.append(this.c.toString());
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* synthetic */ a[] n;

        public static {
            a a2;
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            i = new a();
            j = new a();
            k = new a();
            l = new a();
            m = a2 = new a();
            a[] arra = new a[]{e, f, g, h, i, j, k, l, a2};
            n = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])n.clone();
        }
    }

}

