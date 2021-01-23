/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  c.e.a.a.f0.m$a
 *  c.e.a.a.f0.m$b
 *  c.e.a.a.f0.m$c
 *  c.e.a.a.f0.m$d
 *  java.lang.Deprecated
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package c.e.a.a.f0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import c.e.a.a.f0.m;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class m {
    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    public final List<e> g;
    public final List<f> h;
    public boolean i;

    public m() {
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c c2 = new /* Unavailable Anonymous Inner Class!! */;
        c2.f = f6;
        c2.g = f7;
        this.g.add((Object)c2);
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        float f8 = f6 + f7;
        boolean bl = f7 < 0.0f;
        if (bl) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = bl ? (180.0f + f8) % 360.0f : f8;
        this.b(f6);
        this.h.add((Object)a2);
        this.e = f9;
        float f10 = 0.5f * (f2 + f4);
        float f11 = (f4 - f2) / 2.0f;
        double d2 = f8;
        this.c = f10 + f11 * (float)Math.cos((double)Math.toRadians((double)d2));
        this.d = 0.5f * (f3 + f5) + (f5 - f3) / 2.0f * (float)Math.sin((double)Math.toRadians((double)d2));
    }

    public final void b(float f2) {
        float f3 = this.e;
        if (f3 == f2) {
            return;
        }
        float f4 = (360.0f + (f2 - f3)) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.c;
        float f6 = this.d;
        c c2 = new /* Unavailable Anonymous Inner Class!! */;
        c2.f = this.e;
        c2.g = f4;
        this.h.add((Object)new /* Unavailable Anonymous Inner Class!! */);
        this.e = f2;
    }

    public void c(Matrix matrix, Path path) {
        int n2 = this.g.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((e)this.g.get(i2)).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d d2 = new /* Unavailable Anonymous Inner Class!! */;
        d2.b = f2;
        d2.c = f3;
        this.g.add((Object)d2);
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        float f4 = 270.0f + b2.b();
        float f5 = 270.0f + b2.b();
        this.b(f4);
        this.h.add((Object)b2);
        this.e = f5;
        this.c = f2;
        this.d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    public static abstract class e {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix var1, Path var2);
    }

    public static abstract class f {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix var1, c.e.a.a.e0.a var2, int var3, Canvas var4);
    }

}

