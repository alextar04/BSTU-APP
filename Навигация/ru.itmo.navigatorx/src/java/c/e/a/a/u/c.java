/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  f.b.k.h
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.u;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import f.b.k.h;

public interface c {
    public void a();

    public void b();

    public int getCircularRevealScrimColor();

    public e getRevealInfo();

    public void setCircularRevealOverlayDrawable(Drawable var1);

    public void setCircularRevealScrimColor(int var1);

    public void setRevealInfo(e var1);

    public static class b
    implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new b();
        public final e a = new e(null);

        public Object evaluate(float f2, Object object, Object object2) {
            e e2 = (e)object;
            e e3 = (e)object2;
            e e4 = this.a;
            float f3 = h.i.Q0(e2.a, e3.a, f2);
            float f4 = h.i.Q0(e2.b, e3.b, f2);
            float f5 = h.i.Q0(e2.c, e3.c, f2);
            e4.a = f3;
            e4.b = f4;
            e4.c = f5;
            return this.a;
        }
    }

    public static class c
    extends Property<c, e> {
        public static final Property<c, e> a = new c("circularReveal");

        public c(String string) {
            super(e.class, string);
        }

        public Object get(Object object) {
            return ((c)object).getRevealInfo();
        }

        public void set(Object object, Object object2) {
            ((c)object).setRevealInfo((e)object2);
        }
    }

    public static class d
    extends Property<c, Integer> {
        public static final Property<c, Integer> a = new d("circularRevealScrimColor");

        public d(String string) {
            super(Integer.class, string);
        }

        public Object get(Object object) {
            return ((c)object).getCircularRevealScrimColor();
        }

        public void set(Object object, Object object2) {
            ((c)object).setCircularRevealScrimColor((Integer)object2);
        }
    }

    public static class e {
        public float a;
        public float b;
        public float c;

        public e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public e(a a2) {
        }
    }

}

