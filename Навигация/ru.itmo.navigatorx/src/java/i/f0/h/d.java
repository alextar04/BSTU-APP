/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.e
 *  j.g
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package i.f0.h;

import i.f0.c;
import i.f0.h.r;
import j.e;
import j.g;
import j.h;
import j.o;
import j.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class d {
    public static final i.f0.h.c[] a;
    public static final Map<h, Integer> b;

    public static {
        i.f0.h.c[] arrc;
        i.f0.h.c[] arrc2 = new i.f0.h.c[61];
        i.f0.h.c c2 = new i.f0.h.c(i.f0.h.c.i, "");
        arrc2[0] = c2;
        arrc2[1] = new i.f0.h.c(i.f0.h.c.f, "GET");
        arrc2[2] = new i.f0.h.c(i.f0.h.c.f, "POST");
        arrc2[3] = new i.f0.h.c(i.f0.h.c.g, "/");
        arrc2[4] = new i.f0.h.c(i.f0.h.c.g, "/index.html");
        arrc2[5] = new i.f0.h.c(i.f0.h.c.h, "http");
        arrc2[6] = new i.f0.h.c(i.f0.h.c.h, "https");
        arrc2[7] = new i.f0.h.c(i.f0.h.c.e, "200");
        arrc2[8] = new i.f0.h.c(i.f0.h.c.e, "204");
        arrc2[9] = new i.f0.h.c(i.f0.h.c.e, "206");
        arrc2[10] = new i.f0.h.c(i.f0.h.c.e, "304");
        arrc2[11] = new i.f0.h.c(i.f0.h.c.e, "400");
        arrc2[12] = new i.f0.h.c(i.f0.h.c.e, "404");
        arrc2[13] = new i.f0.h.c(i.f0.h.c.e, "500");
        arrc2[14] = new i.f0.h.c("accept-charset", "");
        arrc2[15] = new i.f0.h.c("accept-encoding", "gzip, deflate");
        arrc2[16] = new i.f0.h.c("accept-language", "");
        arrc2[17] = new i.f0.h.c("accept-ranges", "");
        arrc2[18] = new i.f0.h.c("accept", "");
        arrc2[19] = new i.f0.h.c("access-control-allow-origin", "");
        arrc2[20] = new i.f0.h.c("age", "");
        arrc2[21] = new i.f0.h.c("allow", "");
        arrc2[22] = new i.f0.h.c("authorization", "");
        arrc2[23] = new i.f0.h.c("cache-control", "");
        arrc2[24] = new i.f0.h.c("content-disposition", "");
        arrc2[25] = new i.f0.h.c("content-encoding", "");
        arrc2[26] = new i.f0.h.c("content-language", "");
        arrc2[27] = new i.f0.h.c("content-length", "");
        arrc2[28] = new i.f0.h.c("content-location", "");
        arrc2[29] = new i.f0.h.c("content-range", "");
        arrc2[30] = new i.f0.h.c("content-type", "");
        arrc2[31] = new i.f0.h.c("cookie", "");
        arrc2[32] = new i.f0.h.c("date", "");
        arrc2[33] = new i.f0.h.c("etag", "");
        arrc2[34] = new i.f0.h.c("expect", "");
        arrc2[35] = new i.f0.h.c("expires", "");
        arrc2[36] = new i.f0.h.c("from", "");
        arrc2[37] = new i.f0.h.c("host", "");
        arrc2[38] = new i.f0.h.c("if-match", "");
        arrc2[39] = new i.f0.h.c("if-modified-since", "");
        arrc2[40] = new i.f0.h.c("if-none-match", "");
        arrc2[41] = new i.f0.h.c("if-range", "");
        arrc2[42] = new i.f0.h.c("if-unmodified-since", "");
        arrc2[43] = new i.f0.h.c("last-modified", "");
        arrc2[44] = new i.f0.h.c("link", "");
        arrc2[45] = new i.f0.h.c("location", "");
        arrc2[46] = new i.f0.h.c("max-forwards", "");
        arrc2[47] = new i.f0.h.c("proxy-authenticate", "");
        arrc2[48] = new i.f0.h.c("proxy-authorization", "");
        arrc2[49] = new i.f0.h.c("range", "");
        arrc2[50] = new i.f0.h.c("referer", "");
        arrc2[51] = new i.f0.h.c("refresh", "");
        arrc2[52] = new i.f0.h.c("retry-after", "");
        arrc2[53] = new i.f0.h.c("server", "");
        arrc2[54] = new i.f0.h.c("set-cookie", "");
        arrc2[55] = new i.f0.h.c("strict-transport-security", "");
        arrc2[56] = new i.f0.h.c("transfer-encoding", "");
        arrc2[57] = new i.f0.h.c("user-agent", "");
        arrc2[58] = new i.f0.h.c("vary", "");
        arrc2[59] = new i.f0.h.c("via", "");
        arrc2[60] = new i.f0.h.c("www-authenticate", "");
        a = arrc2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        for (int i2 = 0; i2 < (arrc = a).length; ++i2) {
            if (linkedHashMap.containsKey((Object)arrc[i2].a)) continue;
            linkedHashMap.put((Object)d.a[i2].a, (Object)i2);
        }
        b = Collections.unmodifiableMap((Map)linkedHashMap);
    }

    public static h a(h h2) {
        int n2 = h2.k();
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = h2.f(i2);
            if (by < 65 || by > 90) continue;
            StringBuilder stringBuilder = c.b.a.a.a.c("PROTOCOL_ERROR response malformed: mixed case name: ");
            stringBuilder.append(h2.o());
            throw new IOException(stringBuilder.toString());
        }
        return h2;
    }

    public static final class a {
        public final List<i.f0.h.c> a = new ArrayList();
        public final g b;
        public final int c;
        public int d;
        public i.f0.h.c[] e = new i.f0.h.c[8];
        public int f = 7;
        public int g = 0;
        public int h = 0;

        public a(int n2, w w2) {
            this.c = n2;
            this.d = n2;
            this.b = o.b(w2);
        }

        public final void a() {
            Arrays.fill((Object[])this.e, null);
            this.f = -1 + this.e.length;
            this.g = 0;
            this.h = 0;
        }

        public final int b(int n2) {
            return n2 + (1 + this.f);
        }

        public final int c(int n2) {
            int n3 = 0;
            if (n2 > 0) {
                for (int i2 = -1 + this.e.length; i2 >= this.f && n2 > 0; --i2) {
                    i.f0.h.c[] arrc = this.e;
                    n2 -= arrc[i2].c;
                    this.h -= arrc[i2].c;
                    this.g = -1 + this.g;
                    ++n3;
                }
                i.f0.h.c[] arrc = this.e;
                int n4 = this.f;
                System.arraycopy((Object)arrc, (int)(n4 + 1), (Object)arrc, (int)(n3 + (n4 + 1)), (int)this.g);
                this.f = n3 + this.f;
            }
            return n3;
        }

        public final h d(int n2) {
            block4 : {
                i.f0.h.c c2;
                block3 : {
                    i.f0.h.c[] arrc;
                    block2 : {
                        boolean bl = n2 >= 0 && n2 <= d.a.length - 1;
                        if (!bl) break block2;
                        c2 = d.a[n2];
                        break block3;
                    }
                    int n3 = this.b(n2 - d.a.length);
                    if (n3 < 0 || n3 >= (arrc = this.e).length) break block4;
                    c2 = arrc[n3];
                }
                return c2.a;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Header index too large ");
            stringBuilder.append(n2 + 1);
            throw new IOException(stringBuilder.toString());
        }

        public final void e(int n2, i.f0.h.c c2) {
            int n3;
            this.a.add((Object)c2);
            int n4 = c2.c;
            if (n2 != -1) {
                n4 -= this.e[n2 + (1 + this.f)].c;
            }
            if (n4 > (n3 = this.d)) {
                this.a();
                return;
            }
            int n5 = this.c(n4 + this.h - n3);
            if (n2 == -1) {
                int n6 = 1 + this.g;
                i.f0.h.c[] arrc = this.e;
                if (n6 > arrc.length) {
                    i.f0.h.c[] arrc2 = new i.f0.h.c[2 * arrc.length];
                    System.arraycopy((Object)arrc, (int)0, (Object)arrc2, (int)arrc.length, (int)arrc.length);
                    this.f = -1 + this.e.length;
                    this.e = arrc2;
                }
                int n7 = this.f;
                this.f = n7 - 1;
                this.e[n7] = c2;
                this.g = 1 + this.g;
            } else {
                int n8 = n2 + (n5 + (n2 + (1 + this.f)));
                this.e[n8] = c2;
            }
            this.h = n4 + this.h;
        }

        public h f() {
            int n2 = 255 & this.b.readByte();
            int n3 = n2 & 128;
            boolean bl = n3 == 128;
            int n4 = this.g(n2, 127);
            if (bl) {
                r r2 = r.d;
                byte[] arrby = this.b.F((long)n4);
                if (r2 != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    r.a a2 = r2.a;
                    int n5 = 0;
                    r.a a3 = a2;
                    int n6 = 0;
                    for (int i2 = 0; i2 < arrby.length; ++i2) {
                        n6 = 255 & arrby[i2] | n6 << 8;
                        n5 += 8;
                        while (n5 >= 8) {
                            int n7 = n5 - 8;
                            int n8 = 255 & n6 >>> n7;
                            a3 = a3.a[n8];
                            if (a3.a == null) {
                                byteArrayOutputStream.write(a3.b);
                                n5 -= a3.c;
                                a3 = r2.a;
                                continue;
                            }
                            n5 = n7;
                        }
                    }
                    while (n5 > 0) {
                        int n9 = 255 & n6 << 8 - n5;
                        r.a a4 = a3.a[n9];
                        if (a4.a != null || a4.c > n5) break;
                        byteArrayOutputStream.write(a4.b);
                        n5 -= a4.c;
                        a3 = r2.a;
                    }
                    return h.h(byteArrayOutputStream.toByteArray());
                }
                throw null;
            }
            return this.b.o((long)n4);
        }

        public int g(int n2, int n3) {
            int n4;
            int n5 = n2 & n3;
            if (n5 < n3) {
                return n5;
            }
            int n6 = 0;
            while (((n4 = 255 & this.b.readByte()) & 128) != 0) {
                n3 += (n4 & 127) << n6;
                n6 += 7;
            }
            return n3 + (n4 << n6);
        }
    }

    public static final class b {
        public final e a;
        public final boolean b = true;
        public int c = Integer.MAX_VALUE;
        public boolean d;
        public int e = 4096;
        public i.f0.h.c[] f = new i.f0.h.c[8];
        public int g = 7;
        public int h = 0;
        public int i = 0;

        public b(e e2) {
            this.a = e2;
        }

        public final void a() {
            Arrays.fill((Object[])this.f, null);
            this.g = -1 + this.f.length;
            this.h = 0;
            this.i = 0;
        }

        public final int b(int n2) {
            int n3 = 0;
            if (n2 > 0) {
                for (int i2 = -1 + this.f.length; i2 >= this.g && n2 > 0; --i2) {
                    i.f0.h.c[] arrc = this.f;
                    n2 -= arrc[i2].c;
                    this.i -= arrc[i2].c;
                    this.h = -1 + this.h;
                    ++n3;
                }
                i.f0.h.c[] arrc = this.f;
                int n4 = this.g;
                System.arraycopy((Object)arrc, (int)(n4 + 1), (Object)arrc, (int)(n3 + (n4 + 1)), (int)this.h);
                Object[] arrobject = this.f;
                int n5 = this.g;
                Arrays.fill((Object[])arrobject, (int)(n5 + 1), (int)(n3 + (n5 + 1)), null);
                this.g = n3 + this.g;
            }
            return n3;
        }

        public final void c(i.f0.h.c c2) {
            int n2 = c2.c;
            int n3 = this.e;
            if (n2 > n3) {
                this.a();
                return;
            }
            this.b(n2 + this.i - n3);
            int n4 = 1 + this.h;
            i.f0.h.c[] arrc = this.f;
            if (n4 > arrc.length) {
                i.f0.h.c[] arrc2 = new i.f0.h.c[2 * arrc.length];
                System.arraycopy((Object)arrc, (int)0, (Object)arrc2, (int)arrc.length, (int)arrc.length);
                this.g = -1 + this.f.length;
                this.f = arrc2;
            }
            int n5 = this.g;
            this.g = n5 - 1;
            this.f[n5] = c2;
            this.h = 1 + this.h;
            this.i = n2 + this.i;
        }

        public void d(h h2) {
            block13 : {
                e e2;
                block12 : {
                    block9 : {
                        block10 : {
                            block11 : {
                                boolean bl = this.b;
                                int n2 = 0;
                                if (!bl) break block9;
                                if (r.d == null) break block10;
                                long l2 = 0L;
                                for (int i2 = 0; i2 < h2.k(); ++i2) {
                                    int n3 = 255 & h2.f(i2);
                                    l2 += (long)r.c[n3];
                                }
                                if ((int)(l2 + 7L >> 3) >= h2.k()) break block9;
                                e e3 = new e();
                                if (r.d == null) break block11;
                                long l3 = 0L;
                                int n4 = 0;
                                while (n2 < h2.k()) {
                                    int n5 = 255 & h2.f(n2);
                                    int n6 = r.b[n5];
                                    byte by = r.c[n5];
                                    l3 = l3 << by | (long)n6;
                                    n4 += by;
                                    while (n4 >= 8) {
                                        e3.M((int)(l3 >> (n4 -= 8)));
                                    }
                                    ++n2;
                                }
                                if (n4 > 0) {
                                    e3.M((int)(l3 << 8 - n4 | (long)(255 >>> n4)));
                                }
                                h2 = e3.p();
                                this.f(h2.e.length, 127, 128);
                                e2 = this.a;
                                if (e2 == null) {
                                    throw null;
                                }
                                break block12;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    this.f(h2.k(), 127, 0);
                    e2 = this.a;
                    if (e2 == null) break block13;
                }
                h2.p(e2);
                return;
            }
            throw null;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void e(List<i.f0.h.c> var1_1) {
            if (this.d) {
                var15_2 = this.c;
                if (var15_2 < this.e) {
                    this.f(var15_2, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                this.f(this.e, 31, 32);
            }
            var2_3 = var1_1.size();
            var3_4 = 0;
            while (var3_4 < var2_3) {
                block15 : {
                    block16 : {
                        block14 : {
                            block13 : {
                                block12 : {
                                    block11 : {
                                        var4_5 = (i.f0.h.c)var1_1.get(var3_4);
                                        var5_6 = var4_5.a.m();
                                        var6_7 = var4_5.b;
                                        var7_8 = (Integer)d.b.get((Object)var5_6);
                                        if (var7_8 == null) break block11;
                                        var8_9 = 1 + var7_8;
                                        if (var8_9 <= 1 || var8_9 >= 8) ** GOTO lbl-1000
                                        if (!c.m(d.a[var8_9 - 1].b, var6_7)) {
                                            ** if (!c.m((Object)d.a[var8_9].b, (Object)var6_7)) goto lbl-1000
lbl-1000: // 1 sources:
                                            {
                                                var14_14 = var8_9 + 1;
                                                var9_10 = var8_9;
                                                var8_9 = var14_14;
                                                ** GOTO lbl32
                                            }
                                        }
                                        break block12;
lbl-1000: // 2 sources:
                                        {
                                            var9_10 = var8_9;
                                            var8_9 = -1;
                                        }
                                        break block13;
                                    }
                                    var8_9 = -1;
                                }
                                var9_10 = var8_9;
                            }
                            if (var8_9 == -1) {
                                var13_13 = this.f.length;
                                for (var12_12 = 1 + this.g; var12_12 < var13_13; ++var12_12) {
                                    if (!c.m(this.f[var12_12].a, var5_6)) continue;
                                    if (c.m(this.f[var12_12].b, var6_7)) {
                                        var8_9 = var12_12 - this.g + d.a.length;
                                        break;
                                    }
                                    if (var9_10 != -1) continue;
                                    var9_10 = var12_12 - this.g + d.a.length;
                                }
                            }
                            if (var8_9 == -1) break block14;
                            this.f(var8_9, 127, 128);
                            break block15;
                        }
                        if (var9_10 != -1) break block16;
                        this.a.M(64);
                        this.d(var5_6);
                        ** GOTO lbl59
                    }
                    var10_11 = i.f0.h.c.d;
                    if (var5_6 == null) throw null;
                    if (var5_6.i(0, var10_11, 0, var10_11.k()) && !i.f0.h.c.i.equals(var5_6)) {
                        this.f(var9_10, 15, 0);
                        this.d(var6_7);
                    } else {
                        this.f(var9_10, 63, 64);
lbl59: // 2 sources:
                        this.d(var6_7);
                        this.c(var4_5);
                    }
                }
                ++var3_4;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public void f(int n2, int n3, int n4) {
            int n5;
            e e2;
            if (n2 < n3) {
                e2 = this.a;
                n5 = n2 | n4;
            } else {
                this.a.M(n4 | n3);
                for (n5 = n2 - n3; n5 >= 128; n5 >>>= 7) {
                    int n6 = n5 & 127;
                    this.a.M(128 | n6);
                }
                e2 = this.a;
            }
            e2.M(n5);
        }
    }

}

