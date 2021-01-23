/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.SuppressLint
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  c.a.a.o.d.a$b$a
 *  c.a.a.o.e.b
 *  c.a.a.o.e.c
 *  h.h
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  h.m.b.q
 *  h.m.b.r.a
 *  java.lang.Float
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package c.a.a.o.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import c.a.a.i;
import c.a.a.k;
import c.a.a.o.d.a;
import c.a.a.o.d.b;
import h.h;
import h.m.a.l;
import h.m.b.f;
import h.m.b.j;
import h.m.b.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class a {
    public static final String q = "a";
    public static final k r;
    public static final AccelerateDecelerateInterpolator s;
    public RectF a;
    public RectF b;
    public Matrix c;
    public boolean d;
    public final Matrix e;
    public float f;
    public float g;
    public final i h;
    public final c.a.a.b i;
    public long j;
    public final Set<ValueAnimator> k;
    public final c l;
    public final c.a.a.o.e.c m;
    public final c.a.a.o.e.b n;
    public final c.a.a.o.a o;
    public final a p;

    public static {
        String string = q;
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
        r = new k(string, null);
        s = new AccelerateDecelerateInterpolator();
    }

    public a(c.a.a.o.e.c c2, c.a.a.o.e.b b2, c.a.a.o.a a2, a a3) {
        j.e((Object)c2, (String)"zoomManager");
        j.e((Object)b2, (String)"panManager");
        j.e((Object)a2, (String)"stateController");
        j.e((Object)a3, (String)"callback");
        this.m = c2;
        this.n = b2;
        this.o = a2;
        this.p = a3;
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.e = new Matrix();
        this.h = new i(0.0f, 0.0f, 3);
        this.i = new c.a.a.b(0.0f, 0.0f, 3);
        this.j = 280L;
        this.k = new LinkedHashSet();
        this.l = new AnimatorListenerAdapter(){

            public final void a(Animator animator) {
                animator.removeListener((Animator.AnimatorListener)this);
                Set<ValueAnimator> set = this.k;
                if (set != null) {
                    if (!(set instanceof h.m.b.r.a)) {
                        set.remove((Object)animator);
                        if (this.k.isEmpty()) {
                            this.o.a();
                        }
                        return;
                    }
                    q.b(set, (String)"kotlin.collections.MutableCollection");
                    throw null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }

            public void onAnimationCancel(Animator animator) {
                j.e((Object)animator, (String)"animator");
                this.a(animator);
            }

            public void onAnimationEnd(Animator animator) {
                j.e((Object)animator, (String)"animator");
                this.a(animator);
            }
        };
    }

    @SuppressLint(value={"ObjectAnimatorBinding"})
    public final void a(final c.a.a.o.d.b b2) {
        Object[] arrobject;
        ArrayList arrayList;
        block13 : {
            PropertyValuesHolder propertyValuesHolder;
            String string;
            block12 : {
                block11 : {
                    j.e((Object)b2, (String)"update");
                    if (!this.d) {
                        return;
                    }
                    if (!this.o.c(3)) {
                        return;
                    }
                    arrayList = new ArrayList();
                    c.a.a.b b3 = b2.e;
                    if (b3 == null) break block11;
                    if (b2.g) {
                        b3 = this.i().b(b2.e);
                    }
                    float[] arrf = new float[]{this.j(), b3.a};
                    PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat((String)"panX", (float[])arrf);
                    j.d((Object)propertyValuesHolder2, (String)"PropertyValuesHolder.ofF\u2026t(\"panX\", panX, target.x)");
                    arrayList.add((Object)propertyValuesHolder2);
                    float[] arrf2 = new float[]{this.k(), b3.b};
                    propertyValuesHolder = PropertyValuesHolder.ofFloat((String)"panY", (float[])arrf2);
                    string = "PropertyValuesHolder.ofF\u2026t(\"panY\", panY, target.y)";
                    break block12;
                }
                i i2 = b2.f;
                if (i2 == null) break block13;
                if (b2.g) {
                    i i3 = this.l();
                    i i4 = b2.f;
                    if (i3 != null) {
                        j.e((Object)i4, (String)"scaledPoint");
                        i2 = new i(i3.a + i4.a, i3.b + i4.b);
                    } else {
                        throw null;
                    }
                }
                float[] arrf = new float[]{this.a.left, i2.a};
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat((String)"panX", (float[])arrf);
                j.d((Object)propertyValuesHolder3, (String)"PropertyValuesHolder.ofF\u2026X\", scaledPanX, target.x)");
                arrayList.add((Object)propertyValuesHolder3);
                float[] arrf3 = new float[]{this.a.top, i2.b};
                propertyValuesHolder = PropertyValuesHolder.ofFloat((String)"panY", (float[])arrf3);
                string = "PropertyValuesHolder.ofF\u2026Y\", scaledPanY, target.y)";
            }
            j.d((Object)propertyValuesHolder, (String)string);
            arrayList.add((Object)propertyValuesHolder);
        }
        if (b2.a()) {
            float f2 = b2.c ? this.m() * b2.b : b2.b;
            float f3 = this.m.b(f2, b2.d);
            float[] arrf = new float[]{this.m(), f3};
            PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat((String)"zoom", (float[])arrf);
            j.d((Object)propertyValuesHolder, (String)"PropertyValuesHolder.ofF\u2026at(\"zoom\", zoom, newZoom)");
            arrayList.add((Object)propertyValuesHolder);
        }
        if ((arrobject = arrayList.toArray((Object[])new PropertyValuesHolder[0])) != null) {
            Object[] arrobject2 = (PropertyValuesHolder[])arrobject;
            ValueAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder((PropertyValuesHolder[])((PropertyValuesHolder[])Arrays.copyOf((Object[])arrobject2, (int)arrobject2.length)));
            j.d((Object)valueAnimator, (String)"animator");
            valueAnimator.setDuration(this.j);
            valueAnimator.setInterpolator((TimeInterpolator)s);
            valueAnimator.addListener((Animator.AnimatorListener)this.l);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.d((l<? super b.a, h>)new a(this, valueAnimator));
                }
            });
            valueAnimator.start();
            this.k.add((Object)valueAnimator);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void b(l<? super b.a, h> l2) {
        j.e(l2, (String)"update");
        this.a(c.a.a.o.d.b.m.a(l2));
    }

    public final void c(c.a.a.o.d.b b2) {
        block11 : {
            block10 : {
                block9 : {
                    j.e((Object)b2, (String)"update");
                    if (!this.d) {
                        return;
                    }
                    c.a.a.b b3 = b2.e;
                    if (b3 == null) break block9;
                    if (!b2.g) {
                        b3 = b3.a(this.i());
                    }
                    this.c.preTranslate(b3.a, b3.b);
                    break block10;
                }
                i i2 = b2.f;
                if (i2 == null) break block11;
                if (!b2.g) {
                    i2 = i2.a(this.l());
                }
                this.c.postTranslate(i2.a, i2.b);
            }
            this.o();
        }
        if (b2.a()) {
            float f2 = b2.c ? this.m() * b2.b : b2.b;
            float f3 = this.m.b(f2, b2.d) / this.m();
            Float f4 = b2.i;
            float f5 = f4 != null ? f4.floatValue() : (b2.a ? 0.0f : this.f / 2.0f);
            Float f6 = b2.j;
            float f7 = f6 != null ? f6.floatValue() : (b2.a ? 0.0f : this.g / 2.0f);
            this.c.postScale(f3, f3, f5, f7);
            this.o();
        }
        boolean bl = b2.h;
        float f8 = this.n.c(true, bl);
        float f9 = this.n.c(false, bl);
        if (f8 != 0.0f || f9 != 0.0f) {
            this.c.postTranslate(f8, f9);
            this.o();
        }
        if (b2.k) {
            this.p.i();
        }
    }

    public final void d(l<? super b.a, h> l2) {
        j.e(l2, (String)"update");
        this.c(c.a.a.o.d.b.m.a(l2));
    }

    public final float e() {
        return this.b.height();
    }

    public final float f() {
        return this.a.height();
    }

    public final float g() {
        return this.a.width();
    }

    public final float h() {
        return this.b.width();
    }

    public final c.a.a.b i() {
        this.i.d((Number)Float.valueOf((float)this.j()), (Number)Float.valueOf((float)this.k()));
        return this.i;
    }

    public final float j() {
        return this.a.left / this.m();
    }

    public final float k() {
        return this.a.top / this.m();
    }

    public final i l() {
        this.h.b((Number)Float.valueOf((float)this.a.left), (Number)Float.valueOf((float)this.a.top));
        return this.h;
    }

    public final float m() {
        return this.a.width() / this.b.width();
    }

    public final void n(float f2, boolean bl) {
        block4 : {
            block5 : {
                boolean bl2;
                block7 : {
                    block6 : {
                        float f3;
                        this.o();
                        float f4 = this.h();
                        float f5 = (float)false;
                        if (f4 <= f5 || this.e() <= f5 || (f3 = this.f) <= f5) break block4;
                        if (this.g <= f5) {
                            return;
                        }
                        k k2 = r;
                        Object[] arrobject = new Object[]{"onSizeChanged:", "containerWidth:", Float.valueOf((float)f3), "containerHeight:", Float.valueOf((float)this.g), "contentWidth:", Float.valueOf((float)this.h()), "contentHeight:", Float.valueOf((float)this.e())};
                        if (k2 == null) break block5;
                        j.e((Object)arrobject, (String)"data");
                        k2.e(k2.c(2, Arrays.copyOf((Object[])arrobject, (int)9)));
                        if (!this.d) break block6;
                        bl2 = false;
                        if (!bl) break block7;
                    }
                    bl2 = true;
                }
                this.d = true;
                this.p.h(f2, bl2);
                return;
            }
            throw null;
        }
    }

    public final void o() {
        this.c.mapRect(this.a, this.b);
    }

    public static interface a {
        public void a(Runnable var1);

        public void h(float var1, boolean var2);

        public void i();

        public boolean j(Runnable var1);
    }

}

