/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$Op
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  c.e.a.a.f0.g
 *  c.e.a.a.f0.g$a
 *  c.e.a.a.f0.l
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.BitSet
 *  java.util.Collection
 *  java.util.List
 */
package c.e.a.a.f0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c.e.a.a.f0.c;
import c.e.a.a.f0.d;
import c.e.a.a.f0.f;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.f0.l;
import c.e.a.a.f0.m;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;

public class k {
    public final m[] a = new m[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final m g = new m();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public boolean j = true;

    public k() {
        for (int i2 = 0; i2 < 4; ++i2) {
            this.a[i2] = new m();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    public void a(j j2, float f2, RectF rectF, a a2, Path path) {
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        int n2 = 0;
        while (n2 < 4) {
            block15 : {
                float f3;
                float f4;
                PointF pointF;
                int n3;
                float f5;
                block18 : {
                    block19 : {
                        block16 : {
                            block17 : {
                                c c2 = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? j2.f : j2.e) : j2.h) : j2.g;
                                d d2 = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? j2.b : j2.a) : j2.d) : j2.c;
                                m m2 = this.a[n2];
                                if (d2 == null) break block15;
                                d2.a(m2, 90.0f, f2, c2.a(rectF));
                                n3 = n2 + 1;
                                f3 = n3 * 90;
                                this.b[n2].reset();
                                pointF = this.d;
                                if (n2 == 1) break block16;
                                if (n2 == 2) break block17;
                                f5 = n2 != 3 ? rectF.right : rectF.left;
                                f4 = rectF.top;
                                break block18;
                            }
                            f5 = rectF.left;
                            break block19;
                        }
                        f5 = rectF.right;
                    }
                    f4 = rectF.bottom;
                }
                pointF.set(f5, f4);
                Matrix matrix = this.b[n2];
                PointF pointF2 = this.d;
                matrix.setTranslate(pointF2.x, pointF2.y);
                this.b[n2].preRotate(f3);
                float[] arrf = this.h;
                m[] arrm = this.a;
                arrf[0] = arrm[n2].c;
                arrf[1] = arrm[n2].d;
                this.b[n2].mapPoints(arrf);
                this.c[n2].reset();
                Matrix matrix2 = this.c[n2];
                float[] arrf2 = this.h;
                matrix2.setTranslate(arrf2[0], arrf2[1]);
                this.c[n2].preRotate(f3);
                n2 = n3;
                continue;
            }
            throw null;
        }
        int n4 = 0;
        while (n4 < 4) {
            int n5;
            float f6;
            Path path2;
            float f7;
            Matrix matrix;
            m m3;
            f f8;
            float[] arrf = this.h;
            m[] arrm = this.a;
            arrf[0] = arrm[n4].a;
            arrf[1] = arrm[n4].b;
            this.b[n4].mapPoints(arrf);
            float[] arrf3 = this.h;
            if (n4 == 0) {
                path.moveTo(arrf3[0], arrf3[1]);
            } else {
                path.lineTo(arrf3[0], arrf3[1]);
            }
            this.a[n4].c(this.b[n4], path);
            if (a2 != null) {
                m m4 = this.a[n4];
                Matrix matrix3 = this.b[n4];
                g.a a3 = (g.a)a2;
                a3.a.h.set(n4, m4.i);
                m.f[] arrf4 = a3.a.f;
                m4.b(m4.f);
                arrf4[n4] = new l(m4, (List)new ArrayList(m4.h), matrix3);
            }
            int n6 = n4 + 1;
            int n7 = n6 % 4;
            float[] arrf5 = this.h;
            m[] arrm2 = this.a;
            arrf5[0] = arrm2[n4].c;
            arrf5[1] = arrm2[n4].d;
            this.b[n4].mapPoints(arrf5);
            float[] arrf6 = this.i;
            m[] arrm3 = this.a;
            arrf6[0] = arrm3[n7].a;
            arrf6[1] = arrm3[n7].b;
            this.b[n7].mapPoints(arrf6);
            float[] arrf7 = this.h;
            float f9 = arrf7[0];
            float[] arrf8 = this.i;
            float f10 = Math.max((float)((float)Math.hypot((double)(f9 - arrf8[0]), (double)(arrf7[1] - arrf8[1])) - 0.001f), (float)0.0f);
            float[] arrf9 = this.h;
            m[] arrm4 = this.a;
            arrf9[0] = arrm4[n4].c;
            arrf9[1] = arrm4[n4].d;
            this.b[n4].mapPoints(arrf9);
            if (n4 != 1 && n4 != 3) {
                f6 = rectF.centerY();
                f7 = this.h[1];
            } else {
                f6 = rectF.centerX();
                f7 = this.h[0];
            }
            float f11 = Math.abs((float)(f6 - f7));
            this.g.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (n4 != 1) {
                if (n4 != 2) {
                    n5 = 3;
                    f8 = n4 != n5 ? j2.j : j2.i;
                } else {
                    n5 = 3;
                    f8 = j2.l;
                }
            } else {
                n5 = 3;
                f8 = j2.k;
            }
            f8.a(f10, f11, f2, this.g);
            Path path3 = new Path();
            this.g.c(this.c[n4], path3);
            if (this.j && (this.b(path3, n4) || this.b(path3, n7))) {
                path3.op(path3, this.f, Path.Op.DIFFERENCE);
                float[] arrf10 = this.h;
                m m5 = this.g;
                arrf10[0] = m5.a;
                arrf10[1] = m5.b;
                this.c[n4].mapPoints(arrf10);
                Path path4 = this.e;
                float[] arrf11 = this.h;
                path4.moveTo(arrf11[0], arrf11[1]);
                m3 = this.g;
                matrix = this.c[n4];
                path2 = this.e;
            } else {
                m3 = this.g;
                matrix = this.c[n4];
                path2 = path;
            }
            m3.c(matrix, path2);
            if (a2 != null) {
                m m6 = this.g;
                Matrix matrix4 = this.c[n4];
                g.a a4 = (g.a)a2;
                a4.a.h.set(n4 + 4, m6.i);
                m.f[] arrf12 = a4.a.g;
                m6.b(m6.f);
                arrf12[n4] = new l(m6, (List)new ArrayList(m6.h), matrix4);
            }
            n4 = n6;
        }
        path.close();
        this.e.close();
        if (!this.e.isEmpty()) {
            path.op(this.e, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int n2) {
        Path path2 = new Path();
        this.a[n2].c(this.b[n2], path2);
        RectF rectF = new RectF();
        boolean bl = true;
        path.computeBounds(rectF, bl);
        path2.computeBounds(rectF, bl);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, bl);
        if (rectF.isEmpty()) {
            if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public static interface a {
    }

}

