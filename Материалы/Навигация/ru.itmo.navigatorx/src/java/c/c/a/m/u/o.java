/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.security.MessageDigest
 *  java.util.Map
 */
package c.c.a.m.u;

import c.b.a.a.a;
import c.c.a.m.m;
import c.c.a.m.s;
import f.b.k.h;
import java.security.MessageDigest;
import java.util.Map;

public class o
implements m {
    public final Object b;
    public final int c;
    public final int d;
    public final Class<?> e;
    public final Class<?> f;
    public final m g;
    public final Map<Class<?>, s<?>> h;
    public final c.c.a.m.o i;
    public int j;

    public o(Object object, m m2, int n2, int n3, Map<Class<?>, s<?>> map, Class<?> class_, Class<?> class_2, c.c.a.m.o o2) {
        h.i.p(object, "Argument must not be null");
        this.b = object;
        h.i.p(m2, "Signature must not be null");
        this.g = m2;
        this.c = n2;
        this.d = n3;
        h.i.p(map, "Argument must not be null");
        this.h = map;
        h.i.p(class_, "Resource class must not be null");
        this.e = class_;
        h.i.p(class_2, "Transcode class must not be null");
        this.f = class_2;
        h.i.p(o2, "Argument must not be null");
        this.i = o2;
    }

    @Override
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof o;
        boolean bl2 = false;
        if (bl) {
            o o2 = (o)object;
            boolean bl3 = this.b.equals(o2.b);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.g.equals(o2.g);
                bl2 = false;
                if (bl4) {
                    int n2 = this.d;
                    int n3 = o2.d;
                    bl2 = false;
                    if (n2 == n3) {
                        int n4 = this.c;
                        int n5 = o2.c;
                        bl2 = false;
                        if (n4 == n5) {
                            boolean bl5 = this.h.equals(o2.h);
                            bl2 = false;
                            if (bl5) {
                                boolean bl6 = this.e.equals(o2.e);
                                bl2 = false;
                                if (bl6) {
                                    boolean bl7 = this.f.equals(o2.f);
                                    bl2 = false;
                                    if (bl7) {
                                        boolean bl8 = this.i.equals(o2.i);
                                        bl2 = false;
                                        if (bl8) {
                                            bl2 = true;
                                        }
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
        if (this.j == 0) {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            this.j = n5 = this.b.hashCode();
            this.j = n3 = n5 * 31 + this.g.hashCode();
            this.j = n8 = n3 * 31 + this.c;
            this.j = n6 = n8 * 31 + this.d;
            this.j = n2 = n6 * 31 + this.h.hashCode();
            this.j = n4 = n2 * 31 + this.e.hashCode();
            this.j = n7 = n4 * 31 + this.f.hashCode();
            this.j = n7 * 31 + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("EngineKey{model=");
        stringBuilder.append(this.b);
        stringBuilder.append(", width=");
        stringBuilder.append(this.c);
        stringBuilder.append(", height=");
        stringBuilder.append(this.d);
        stringBuilder.append(", resourceClass=");
        stringBuilder.append(this.e);
        stringBuilder.append(", transcodeClass=");
        stringBuilder.append(this.f);
        stringBuilder.append(", signature=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(", hashCode=");
        stringBuilder.append(this.j);
        stringBuilder.append(", transformations=");
        stringBuilder.append(this.h);
        stringBuilder.append(", options=");
        stringBuilder.append((Object)this.i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

