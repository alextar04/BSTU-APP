/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 */
package c.c.a.l;

import android.graphics.Bitmap;
import android.util.Log;
import c.c.a.l.a;
import c.c.a.l.b;
import c.c.a.l.c;
import c.c.a.m.u.c0.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
implements a {
    public int[] a;
    public final int[] b = new int[256];
    public final a.a c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public int[] j;
    public int k;
    public c l;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Boolean s;
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e(a.a a2, c c2, ByteBuffer byteBuffer, int n2) {
        this.c = a2;
        this.l = new c();
        e e2 = this;
        synchronized (e2) {
            ByteBuffer byteBuffer2;
            if (n2 <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sample size must be >=0, not: ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            int n3 = Integer.highestOneBit((int)n2);
            this.o = 0;
            this.l = c2;
            this.k = -1;
            this.d = byteBuffer2 = byteBuffer.asReadOnlyBuffer();
            byteBuffer2.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator iterator = c2.e.iterator();
            while (iterator.hasNext()) {
                if (((b)iterator.next()).g != 3) continue;
                this.n = true;
                break;
            }
            this.p = n3;
            this.r = c2.f / n3;
            this.q = c2.g / n3;
            a.a a3 = this.c;
            int n4 = c2.f;
            int n5 = c2.g;
            int n6 = n4 * n5;
            c.c.a.m.w.g.b b2 = (c.c.a.m.w.g.b)a3;
            this.i = b2.a(n6);
            a.a a4 = this.c;
            int n7 = this.r * this.q;
            c.c.a.m.u.c0.b b3 = ((c.c.a.m.w.g.b)a4).b;
            int[] arrn = b3 == null ? new int[n7] : b3.g(n7, int[].class);
            this.j = arrn;
            return;
        }
    }

    @Override
    public int a() {
        return this.k;
    }

    @Override
    public int b() {
        return this.d.limit() + this.i.length + 4 * this.j.length;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Bitmap c() {
        e e2 = this;
        synchronized (e2) {
            if (this.l.c <= 0 || this.k < 0) {
                if (Log.isLoggable((String)"e", (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to decode frame, frameCount=");
                    stringBuilder.append(this.l.c);
                    stringBuilder.append(", framePointer=");
                    stringBuilder.append(this.k);
                    Log.d((String)"e", (String)stringBuilder.toString());
                }
                this.o = 1;
            }
            if (this.o != 1 && this.o != 2) {
                this.o = 0;
                if (this.e == null) {
                    a.a a2 = this.c;
                    c.c.a.m.w.g.b b2 = (c.c.a.m.w.g.b)a2;
                    this.e = b2.a(255);
                }
                b b3 = (b)this.l.e.get(this.k);
                int n2 = this.k - 1;
                b b4 = n2 >= 0 ? (b)this.l.e.get(n2) : null;
                int[] arrn = b3.k != null ? b3.k : this.l.a;
                this.a = arrn;
                if (arrn == null) {
                    if (Log.isLoggable((String)"e", (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("No valid color table found for frame #");
                        stringBuilder.append(this.k);
                        Log.d((String)"e", (String)stringBuilder.toString());
                    }
                    this.o = 1;
                    return null;
                }
                if (!b3.f) return this.k(b3, b4);
                System.arraycopy((Object)arrn, (int)0, (Object)this.b, (int)0, (int)arrn.length);
                int[] arrn2 = this.b;
                this.a = arrn2;
                arrn2[b3.h] = 0;
                if (b3.g != 2) return this.k(b3, b4);
                if (this.k != 0) return this.k(b3, b4);
                this.s = Boolean.TRUE;
                return this.k(b3, b4);
            }
            if (!Log.isLoggable((String)"e", (int)3)) return null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to decode frame, status=");
            stringBuilder.append(this.o);
            Log.d((String)"e", (String)stringBuilder.toString());
            return null;
        }
    }

    @Override
    public void clear() {
        int[] arrn;
        Bitmap bitmap;
        c.c.a.m.u.c0.b b2;
        c.c.a.m.u.c0.b b3;
        this.l = null;
        byte[] arrby = this.i;
        if (arrby != null && (b3 = ((c.c.a.m.w.g.b)this.c).b) != null) {
            b3.f(arrby);
        }
        if ((arrn = this.j) != null && (b2 = ((c.c.a.m.w.g.b)this.c).b) != null) {
            b2.f(arrn);
        }
        if ((bitmap = this.m) != null) {
            ((c.c.a.m.w.g.b)this.c).a.c(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] arrby2 = this.e;
        if (arrby2 != null) {
            c.c.a.m.u.c0.b b4 = ((c.c.a.m.w.g.b)this.c).b;
            if (b4 == null) {
                return;
            }
            b4.f(arrby2);
        }
    }

    @Override
    public void d() {
        this.k = (1 + this.k) % this.l.c;
    }

    @Override
    public int e() {
        return this.l.c;
    }

    @Override
    public int f() {
        int n2;
        c c2 = this.l;
        int n3 = c2.c;
        if (n3 > 0 && (n2 = this.k) >= 0) {
            if (n2 >= 0 && n2 < n3) {
                return ((b)c2.e.get((int)n2)).i;
            }
            return -1;
        }
        return 0;
    }

    @Override
    public ByteBuffer g() {
        return this.d;
    }

    @Override
    public void h() {
        this.k = -1;
    }

    public final Bitmap i() {
        Boolean bl = this.s;
        Bitmap.Config config = bl != null && !bl.booleanValue() ? this.t : Bitmap.Config.ARGB_8888;
        a.a a2 = this.c;
        int n2 = this.r;
        int n3 = this.q;
        Bitmap bitmap = ((c.c.a.m.w.g.b)a2).a.e(n2, n3, config);
        bitmap.setHasAlpha(true);
        return bitmap;
    }

    public void j(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported format: ");
            stringBuilder.append((Object)config);
            stringBuilder.append(", must be one of ");
            stringBuilder.append((Object)Bitmap.Config.ARGB_8888);
            stringBuilder.append(" or ");
            stringBuilder.append((Object)Bitmap.Config.RGB_565);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.t = config;
    }

    public final Bitmap k(b b2, b b3) {
        int n2;
        int n3;
        byte[] arrby;
        int[] arrn;
        int n4;
        block71 : {
            int[] arrn2;
            block75 : {
                Bitmap bitmap;
                int n5;
                block76 : {
                    int n6;
                    int n7;
                    block78 : {
                        block77 : {
                            arrn2 = this.j;
                            if (b3 == null) {
                                Bitmap bitmap2 = this.m;
                                if (bitmap2 != null) {
                                    ((c.c.a.m.w.g.b)this.c).a.c(bitmap2);
                                }
                                this.m = null;
                                Arrays.fill((int[])arrn2, (int)0);
                            }
                            if (b3 != null && b3.g == 3 && this.m == null) {
                                Arrays.fill((int[])arrn2, (int)0);
                            }
                            if (b3 == null || (n5 = b3.g) <= 0) break block75;
                            if (n5 != 2) break block76;
                            if (b2.f) break block77;
                            c c2 = this.l;
                            n6 = c2.l;
                            if (b2.k == null || c2.j != b2.h) break block78;
                        }
                        n6 = 0;
                    }
                    int n8 = b3.d;
                    int n9 = this.p;
                    int n10 = n8 / n9;
                    int n11 = b3.b / n9;
                    int n12 = b3.c / n9;
                    int n13 = b3.a / n9;
                    int n14 = this.r;
                    int n15 = n7 + n10 * n14;
                    for (n7 = n13 + n11 * n14; n7 < n15; n7 += this.r) {
                        int n16 = n7 + n12;
                        for (int i2 = n7; i2 < n16; ++i2) {
                            arrn2[i2] = n6;
                        }
                    }
                    break block75;
                }
                if (n5 == 3 && (bitmap = this.m) != null) {
                    int n17 = this.r;
                    int n18 = this.q;
                    bitmap.getPixels(arrn2, 0, n17, 0, 0, n17, n18);
                }
            }
            this.d.position(b2.j);
            n4 = b2.c * b2.d;
            byte[] arrby2 = this.i;
            if (arrby2 == null || arrby2.length < n4) {
                this.i = ((c.c.a.m.w.g.b)this.c).a(n4);
            }
            arrby = this.i;
            if (this.f == null) {
                this.f = new short[4096];
            }
            short[] arrs = this.f;
            if (this.g == null) {
                this.g = new byte[4096];
            }
            byte[] arrby3 = this.g;
            if (this.h == null) {
                this.h = new byte[4097];
            }
            byte[] arrby4 = this.h;
            int n19 = 255 & this.d.get();
            int n20 = 1 << n19;
            int n21 = n20 + 1;
            int n22 = n20 + 2;
            int n23 = n19 + 1;
            int n24 = -1 + (1 << n23);
            for (int i3 = 0; i3 < n20; ++i3) {
                arrs[i3] = 0;
                arrby3[i3] = (byte)i3;
            }
            byte[] arrby5 = this.e;
            e e2 = this;
            int n25 = n23;
            int n26 = 0;
            int n27 = 0;
            int n28 = 0;
            int n29 = 0;
            int n30 = 0;
            int n31 = 0;
            int n32 = 0;
            int n33 = 0;
            int n34 = n22;
            int n35 = n24;
            int n36 = -1;
            while (n26 < n4) {
                int n37;
                int n38;
                int n39;
                int n40;
                byte[] arrby6;
                block72 : {
                    int n41;
                    int n42;
                    if (n28 == 0) {
                        int n43 = 255 & e2.d.get();
                        if (n43 <= 0) {
                            n38 = n23;
                            n42 = n26;
                            arrn = arrn2;
                            n41 = n36;
                        } else {
                            n38 = n23;
                            ByteBuffer byteBuffer = e2.d;
                            n42 = n26;
                            byte[] arrby7 = e2.e;
                            n41 = n36;
                            int n44 = Math.min((int)n43, (int)byteBuffer.remaining());
                            arrn = arrn2;
                            byteBuffer.get(arrby7, 0, n44);
                        }
                        if (n43 <= 0) {
                            e2.o = 3;
                            n2 = n27;
                            break block71;
                        }
                        n28 = n43;
                        n29 = 0;
                    } else {
                        n38 = n23;
                        n42 = n26;
                        arrn = arrn2;
                        n41 = n36;
                    }
                    n31 += (255 & arrby5[n29]) << n30;
                    int n45 = n30 + 8;
                    ++n29;
                    --n28;
                    n37 = n45;
                    n40 = n34;
                    n39 = n25;
                    n26 = n42;
                    n36 = n41;
                    arrby6 = arrby5;
                    int n46 = n32;
                    while (n37 >= n39) {
                        int n47;
                        int n48;
                        e e3 = e2;
                        int n49 = n31 & n35;
                        n31 >>= n39;
                        n37 -= n39;
                        if (n49 == n20) {
                            n48 = n37;
                            n40 = n22;
                            n35 = n24;
                            e2 = e3;
                            n39 = n38;
                            n36 = -1;
                            n47 = n46;
                        } else {
                            byte by;
                            int n50;
                            if (n49 == n21) {
                                n32 = n46;
                                e2 = e3;
                                break block72;
                            }
                            n48 = n37;
                            if (n36 == -1) {
                                arrby[n27] = arrby3[n49];
                                ++n27;
                                ++n26;
                                n36 = n46 = n49;
                                n37 = n48;
                                e2 = this;
                                continue;
                            }
                            if (n49 >= n40) {
                                arrby4[n33] = (byte)n46;
                                ++n33;
                                n50 = n36;
                            } else {
                                n50 = n49;
                            }
                            while (n50 >= n20) {
                                arrby4[n33] = arrby3[n50];
                                ++n33;
                                n50 = arrs[n50];
                            }
                            int n51 = 255 & arrby3[n50];
                            arrby[n27] = by = (byte)n51;
                            do {
                                ++n27;
                                ++n26;
                                if (n33 <= 0) break;
                                arrby[n27] = arrby4[--n33];
                            } while (true);
                            n47 = n51;
                            if (n40 < 4096) {
                                arrs[n40] = (short)n36;
                                arrby3[n40] = by;
                                if ((++n40 & n35) == 0 && n40 < 4096) {
                                    ++n39;
                                    n35 += n40;
                                }
                            }
                            n36 = n49;
                            e2 = this;
                        }
                        n46 = n47;
                        n37 = n48;
                    }
                    n32 = n46;
                    e2 = this;
                }
                n25 = n39;
                n34 = n40;
                arrby5 = arrby6;
                n23 = n38;
                n30 = n37;
                arrn2 = arrn;
            }
            arrn = arrn2;
            n2 = n27;
        }
        Arrays.fill((byte[])arrby, (int)n2, (int)n4, (byte)0);
        if (!b2.e && this.p == 1) {
            int[] arrn3 = this.j;
            int n52 = b2.d;
            int n53 = b2.b;
            int n54 = b2.c;
            int n55 = b2.a;
            boolean bl = this.k == 0;
            int n56 = this.r;
            byte[] arrby8 = this.i;
            int[] arrn4 = this.a;
            int n57 = -1;
            block7 : for (int i4 = 0; i4 < n52; ++i4) {
                int n58 = n56 * (i4 + n53);
                int n59 = n58 + n56;
                int n60 = n58 + n55;
                int n61 = n60 + n54;
                if (n59 < n61) {
                    n61 = n59;
                }
                int n62 = i4 * b2.c;
                do {
                    int n63 = n52;
                    if (n60 >= n61) continue block7;
                    int n64 = arrby8[n62];
                    int n65 = n53;
                    int n66 = n64 & 255;
                    if (n66 != n57) {
                        int n67 = arrn4[n66];
                        if (n67 != 0) {
                            arrn3[n60] = n67;
                        } else {
                            n57 = n64;
                        }
                    }
                    ++n62;
                    ++n60;
                    n52 = n63;
                    n53 = n65;
                } while (true);
            }
            Boolean bl2 = this.s;
            boolean bl3 = bl2 != null && bl2 != false || this.s == null && bl && n57 != -1;
            this.s = bl3;
        } else {
            Boolean bl;
            int[] arrn5 = this.j;
            int n68 = b2.d;
            int n69 = this.p;
            int n70 = n68 / n69;
            int n71 = b2.b / n69;
            int n72 = b2.c / n69;
            int n73 = b2.a / n69;
            boolean bl4 = this.k == 0;
            int n74 = this.p;
            int n75 = this.r;
            int n76 = this.q;
            byte[] arrby9 = this.i;
            int[] arrn6 = this.a;
            Boolean bl5 = this.s;
            int n77 = 8;
            int n78 = 0;
            int n79 = 0;
            int n80 = 1;
            do {
                int n81;
                int n82;
                int n83;
                int n84;
                int n85;
                int n86;
                int n87;
                int n88;
                bl = bl5;
                if (n78 >= n70) break;
                if (b2.e) {
                    if (n79 >= n70) {
                        int n89 = n80 + 1;
                        n81 = n70;
                        if (n89 != 2) {
                            if (n89 != 3) {
                                n80 = n89;
                                if (n89 == 4) {
                                    n79 = 1;
                                    n77 = 2;
                                }
                            } else {
                                n77 = 4;
                                n80 = n89;
                                n79 = 2;
                            }
                        } else {
                            n79 = 4;
                            n80 = n89;
                        }
                    } else {
                        n81 = n70;
                    }
                    n86 = n79 + n77;
                } else {
                    n81 = n70;
                    n86 = n79;
                    n79 = n78;
                }
                int n90 = n79 + n71;
                boolean bl6 = n74 == 1;
                if (n90 < n76) {
                    block73 : {
                        int n91 = n90 * n75;
                        int n92 = n91 + n73;
                        n87 = n86;
                        int n93 = n91 + n75;
                        int n94 = n92 + n72;
                        if (n93 < n94) {
                            n94 = n93;
                        }
                        int n95 = n78 * n74;
                        n88 = n71;
                        int n96 = n95 * b2.c;
                        if (bl6) {
                            bl5 = bl;
                            int n97 = n92;
                            do {
                                n85 = n72;
                                if (n97 < n94) {
                                    int n98 = arrn6[255 & arrby9[n96]];
                                    if (n98 != 0) {
                                        arrn5[n97] = n98;
                                    } else if (bl4 && bl5 == null) {
                                        bl5 = Boolean.TRUE;
                                    }
                                    n96 += n74;
                                    ++n97;
                                    n72 = n85;
                                    continue;
                                }
                                break block73;
                                break;
                            } while (true);
                        }
                        n85 = n72;
                        int n99 = n96 + n74 * (n94 - n92);
                        bl5 = bl;
                        for (int i5 = n92; i5 < n94; ++i5) {
                            byte[] arrby10;
                            int n100;
                            int n101;
                            int n102;
                            int n103;
                            int n104;
                            int n105;
                            int n106;
                            int n107;
                            int n108;
                            int n109;
                            block74 : {
                                n101 = n94;
                                int n110 = b2.c;
                                n105 = n73;
                                n104 = n75;
                                n106 = 0;
                                n107 = 0;
                                n109 = 0;
                                n108 = 0;
                                n103 = 0;
                                for (int i6 = n96; i6 < n96 + this.p; ++i6) {
                                    byte[] arrby11 = this.i;
                                    n100 = n76;
                                    if (i6 < arrby11.length && i6 < n99) {
                                        int n111 = 255 & arrby11[i6];
                                        int n112 = this.a[n111];
                                        if (n112 != 0) {
                                            n106 += 255 & n112 >> 24;
                                            n107 += 255 & n112 >> 16;
                                            n109 += 255 & n112 >> 8;
                                            n108 += n112 & 255;
                                            ++n103;
                                        }
                                        n76 = n100;
                                        continue;
                                    }
                                    break block74;
                                }
                                n100 = n76;
                            }
                            for (int i7 = n102 = n110 + n96; i7 < n102 + this.p && i7 < (arrby10 = this.i).length && i7 < n99; ++i7) {
                                int n113 = 255 & arrby10[i7];
                                int n114 = this.a[n113];
                                if (n114 == 0) continue;
                                n106 += 255 & n114 >> 24;
                                n107 += 255 & n114 >> 16;
                                n109 += 255 & n114 >> 8;
                                n108 += n114 & 255;
                                ++n103;
                            }
                            int n115 = n103 == 0 ? 0 : n106 / n103 << 24 | n107 / n103 << 16 | n109 / n103 << 8 | n108 / n103;
                            if (n115 != 0) {
                                arrn5[i5] = n115;
                            } else if (bl4 && bl5 == null) {
                                bl5 = Boolean.TRUE;
                            }
                            n96 += n74;
                            n94 = n101;
                            n73 = n105;
                            n75 = n104;
                            n76 = n100;
                        }
                    }
                    n82 = n73;
                    n83 = n75;
                    n84 = n76;
                } else {
                    n87 = n86;
                    n88 = n71;
                    n85 = n72;
                    n82 = n73;
                    n83 = n75;
                    n84 = n76;
                    bl5 = bl;
                }
                ++n78;
                n70 = n81;
                n79 = n87;
                n71 = n88;
                n72 = n85;
                n73 = n82;
                n75 = n83;
                n76 = n84;
            } while (true);
            if (this.s == null) {
                boolean bl7 = bl == null ? false : bl;
                this.s = bl7;
            }
        }
        if (this.n && ((n3 = b2.g) == 0 || n3 == 1)) {
            if (this.m == null) {
                this.m = this.i();
            }
            Bitmap bitmap = this.m;
            int n116 = this.r;
            int n117 = this.q;
            bitmap.setPixels(arrn, 0, n116, 0, 0, n116, n117);
        }
        Bitmap bitmap = this.i();
        int n118 = this.r;
        int n119 = this.q;
        bitmap.setPixels(arrn, 0, n118, 0, 0, n118, n119);
        return bitmap;
    }
}

