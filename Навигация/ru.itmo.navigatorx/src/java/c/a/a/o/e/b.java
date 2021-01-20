/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a.o.e;

import android.annotation.SuppressLint;
import android.graphics.RectF;
import c.a.a.e;
import c.a.a.i;
import c.a.a.k;
import f.b.k.h;
import h.m.b.f;
import h.m.b.j;

public final class b
extends c.a.a.o.e.a {
    public static final String j = "b";
    public static final k k;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public e g;
    public final i h;
    public final c.a.a.a i;

    public static {
        String string = j;
        j.d(string, "TAG");
        j.e(string, "tag");
        k = new k(string, null);
    }

    public b(c.a.a.a a2, h.m.a.a<c.a.a.o.d.a> a3) {
        j.e(a2, "engine");
        j.e(a3, "provider");
        super(a3);
        this.i = a2;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = 51;
        this.g = e.a;
        this.h = new i(0.0f, 0.0f, 3);
    }

    @SuppressLint(value={"RtlHardcoded"})
    public final float b(int n2, float f2, boolean bl) {
        block4 : {
            block2 : {
                block3 : {
                    int n3 = bl ? n2 & 7 : n2 & 112;
                    if (n3 == 1) break block2;
                    if (n3 == 3) break block3;
                    if (n3 == 5) break block4;
                    if (n3 == 16) break block2;
                    if (n3 != 48 && n3 == 80) break block4;
                }
                return 0.0f;
            }
            f2 *= 0.5f;
        }
        return f2;
    }

    @SuppressLint(value={"RtlHardcoded"})
    public final float c(boolean bl, boolean bl2) {
        float f2;
        c.a.a.o.d.a a2 = this.a();
        float f3 = bl ? a2.a.left : a2.a.top;
        c.a.a.o.d.a a3 = this.a();
        float f4 = bl ? a3.f : a3.g;
        c.a.a.o.d.a a4 = this.a();
        float f5 = bl ? a4.g() : a4.f();
        boolean bl3 = bl ? this.b : this.c;
        float f6 = bl3 && bl2 ? (bl ? this.f() : this.g()) : 0.0f;
        int n2 = 16;
        int n3 = 3;
        int n4 = this.f;
        if (bl) {
            int n5 = n4 & 240;
            if (n5 != n2) {
                n3 = n5 != 32 ? (n5 != 48 ? 0 : 1) : 5;
            }
        } else {
            int n6 = n4 & -241;
            if (n6 != 1) {
                if (n6 != 2) {
                    if (n6 != n3) {
                        n2 = 0;
                    }
                } else {
                    n2 = 80;
                }
            } else {
                n2 = 48;
            }
            n3 = n2;
        }
        float f7 = f5 FCMPG f4;
        float f8 = f4 - f5;
        if (f7 <= 0) {
            f2 = 0.0f;
            if (n3 != 0) {
                f8 = f2 = this.b(n3, f8, bl);
            }
        } else {
            f2 = f8;
            f8 = 0.0f;
        }
        return h.i.v(f3, f2 - f6, f8 + f6) - f3;
    }

    public final void d(boolean bl, a a2) {
        j.e(a2, "output");
        c.a.a.o.d.a a3 = this.a();
        float f2 = bl ? a3.a.left : a3.a.top;
        int n2 = (int)f2;
        c.a.a.o.d.a a4 = this.a();
        float f3 = bl ? a4.f : a4.g;
        int n3 = (int)f3;
        c.a.a.o.d.a a5 = this.a();
        float f4 = bl ? a5.g() : a5.f();
        int n4 = (int)f4;
        int n5 = (int)this.c(bl, false);
        int n6 = bl ? 240 & this.f : -241 & this.f;
        if (n4 > n3) {
            a2.a = -(n4 - n3);
            a2.c = 0;
        } else {
            boolean bl2 = n6 == 68 || n6 == 0 || n6 == 64 || n6 == 4;
            if (bl2) {
                int n7 = n3 - n4;
                a2.a = 0;
                a2.c = n7;
            } else {
                int n8;
                a2.a = n8 = n2 + n5;
                a2.c = n8;
            }
        }
        a2.b = n2;
        boolean bl3 = false;
        if (n5 != 0) {
            bl3 = true;
        }
        a2.d = bl3;
    }

    public final i e() {
        this.h.b((Number)Float.valueOf((float)this.c(true, false)), (Number)Float.valueOf((float)this.c(false, false)));
        return this.h;
    }

    public final float f() {
        float f2 = this.g.a(this.i, true);
        if (f2 < (float)false) {
            k.e("Received negative maxHorizontalOverPan value, coercing to 0");
            f2 = h.i.u(f2, 0.0f);
        }
        return f2;
    }

    public final float g() {
        float f2 = this.g.a(this.i, false);
        if (f2 < (float)false) {
            k.e("Received negative maxVerticalOverPan value, coercing to 0");
            f2 = h.i.u(f2, 0.0f);
        }
        return f2;
    }

    public boolean h() {
        return this.b || this.c;
        {
        }
    }

}

