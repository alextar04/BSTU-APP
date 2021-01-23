/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 */
package c.c.a.m.u;

import c.b.a.a.a;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.s;
import c.c.a.m.u.c0.b;
import c.c.a.s.g;
import c.c.a.s.j;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class y
implements m {
    public static final g<Class<?>, byte[]> j = new g(50L);
    public final b b;
    public final m c;
    public final m d;
    public final int e;
    public final int f;
    public final Class<?> g;
    public final o h;
    public final s<?> i;

    public y(b b2, m m2, m m3, int n2, int n3, s<?> s2, Class<?> class_, o o2) {
        this.b = b2;
        this.c = m2;
        this.d = m3;
        this.e = n2;
        this.f = n3;
        this.i = s2;
        this.g = class_;
        this.h = o2;
    }

    @Override
    public void a(MessageDigest messageDigest) {
        byte[] arrby = this.b.e(8, byte[].class);
        ByteBuffer.wrap((byte[])arrby).putInt(this.e).putInt(this.f).array();
        this.d.a(messageDigest);
        this.c.a(messageDigest);
        messageDigest.update(arrby);
        s<?> s2 = this.i;
        if (s2 != null) {
            s2.a(messageDigest);
        }
        this.h.a(messageDigest);
        byte[] arrby2 = j.a(this.g);
        if (arrby2 == null) {
            arrby2 = this.g.getName().getBytes(m.a);
            j.d(this.g, arrby2);
        }
        messageDigest.update(arrby2);
        this.b.f(arrby);
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof y;
        boolean bl2 = false;
        if (bl) {
            y y2 = (y)object;
            int n2 = this.f;
            int n3 = y2.f;
            bl2 = false;
            if (n2 == n3) {
                int n4 = this.e;
                int n5 = y2.e;
                bl2 = false;
                if (n4 == n5) {
                    boolean bl3 = j.b(this.i, y2.i);
                    bl2 = false;
                    if (bl3) {
                        boolean bl4 = this.g.equals(y2.g);
                        bl2 = false;
                        if (bl4) {
                            boolean bl5 = this.c.equals(y2.c);
                            bl2 = false;
                            if (bl5) {
                                boolean bl6 = this.d.equals(y2.d);
                                bl2 = false;
                                if (bl6) {
                                    boolean bl7 = this.h.equals(y2.h);
                                    bl2 = false;
                                    if (bl7) {
                                        bl2 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    @Override
    public int hashCode() {
        int n2 = 31 * (31 * (31 * this.c.hashCode() + this.d.hashCode()) + this.e) + this.f;
        s<?> s2 = this.i;
        if (s2 != null) {
            n2 = n2 * 31 + s2.hashCode();
        }
        return 31 * (n2 * 31 + this.g.hashCode()) + this.h.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("ResourceCacheKey{sourceKey=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", signature=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", width=");
        stringBuilder.append(this.e);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f);
        stringBuilder.append(", decodedResourceClass=");
        stringBuilder.append(this.g);
        stringBuilder.append(", transformation='");
        stringBuilder.append(this.i);
        stringBuilder.append('\'');
        stringBuilder.append(", options=");
        stringBuilder.append((Object)this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

