/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.res.ColorStateList
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  c.e.a.a.f0.g
 *  c.e.a.a.z.e$a
 *  c.e.a.a.z.e$b
 *  c.e.a.a.z.e$c
 *  c.e.a.a.z.e$d
 *  c.e.a.a.z.e$g
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$b
 *  f.b.k.h
 *  f.h.l.l
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package c.e.a.a.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.z.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.k.h;
import f.h.l.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class e {
    public static final TimeInterpolator A;
    public static final int[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;
    public static final int[] F;
    public static final int[] G;
    public j a;
    public c.e.a.a.f0.g b;
    public boolean c;
    public boolean d;
    public float e;
    public float f;
    public float g;
    public final c.e.a.a.a0.g h;
    public c.e.a.a.l.g i;
    public c.e.a.a.l.g j;
    public Animator k;
    public c.e.a.a.l.g l;
    public c.e.a.a.l.g m;
    public float n;
    public float o;
    public int p;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<Animator.AnimatorListener> r;
    public ArrayList<e> s;
    public final FloatingActionButton t;
    public final c.e.a.a.e0.b u;
    public final Rect v;
    public final RectF w;
    public final RectF x;
    public final Matrix y;
    public ViewTreeObserver.OnPreDrawListener z;

    public static {
        A = c.e.a.a.l.a.c;
        B = new int[]{16842919, 16842910};
        C = new int[]{16843623, 16842908, 16842910};
        D = new int[]{16842908, 16842910};
        E = new int[]{16843623, 16842910};
        F = new int[]{16842910};
        G = new int[0];
    }

    public e(FloatingActionButton floatingActionButton, c.e.a.a.e0.b b2) {
        c.e.a.a.a0.g g2;
        this.d = true;
        this.o = 1.0f;
        this.p = 0;
        this.v = new Rect();
        this.w = new RectF();
        this.x = new RectF();
        this.y = new Matrix();
        this.t = floatingActionButton;
        this.u = b2;
        this.h = g2 = new c.e.a.a.a0.g();
        g2.a(B, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.h.a(C, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.h.a(D, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.h.a(E, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.h.a(F, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.h.a(G, this.b((h)new /* Unavailable Anonymous Inner Class!! */));
        this.n = this.t.getRotation();
    }

    public final AnimatorSet a(c.e.a.a.l.g g2, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.t, (Property)View.ALPHA, (float[])new float[]{f2});
        g2.d("opacity").a((Animator)objectAnimator);
        arrayList.add((Object)objectAnimator);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this.t, (Property)View.SCALE_X, (float[])new float[]{f3});
        g2.d("scale").a((Animator)objectAnimator2);
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator2.setEvaluator((TypeEvaluator)new c.e.a.a.z.f(this));
        }
        arrayList.add((Object)objectAnimator2);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat((Object)this.t, (Property)View.SCALE_Y, (float[])new float[]{f3});
        g2.d("scale").a((Animator)objectAnimator3);
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator3.setEvaluator((TypeEvaluator)new c.e.a.a.z.f(this));
        }
        arrayList.add((Object)objectAnimator3);
        this.y.reset();
        this.t.getDrawable();
        FloatingActionButton floatingActionButton = this.t;
        c.e.a.a.l.e e2 = new c.e.a.a.l.e();
        a a2 = new a(this);
        Object[] arrobject = new Matrix[]{new Matrix(this.y)};
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofObject((Object)floatingActionButton, (Property)e2, (TypeEvaluator)a2, (Object[])arrobject);
        g2.d("iconScale").a((Animator)objectAnimator4);
        arrayList.add((Object)objectAnimator4);
        AnimatorSet animatorSet = new AnimatorSet();
        h.i.n1(animatorSet, (List<Animator>)arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h h2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(A);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener((Animator.AnimatorListener)h2);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)h2);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    public abstract float c();

    public void d(Rect rect) {
        boolean bl = this.c;
        int n2 = 0;
        if (bl) {
            n2 = (0 - this.t.getSizeDimension()) / 2;
        }
        float f2 = this.d ? this.c() + this.g : 0.0f;
        int n3 = Math.max((int)n2, (int)((int)Math.ceil((double)f2)));
        int n4 = Math.max((int)n2, (int)((int)Math.ceil((double)(f2 * 1.5f))));
        rect.set(n3, n4, n3, n4);
    }

    public boolean e() {
        if (this.t.getVisibility() == 0) {
            int n2 = this.p;
            boolean bl = false;
            if (n2 == 1) {
                bl = true;
            }
            return bl;
        }
        int n3 = this.p;
        boolean bl = false;
        if (n3 != 2) {
            bl = true;
        }
        return bl;
    }

    public boolean f() {
        if (this.t.getVisibility() != 0) {
            int n2 = this.p;
            boolean bl = false;
            if (n2 == 2) {
                bl = true;
            }
            return bl;
        }
        int n3 = this.p;
        boolean bl = false;
        if (n3 != 1) {
            bl = true;
        }
        return bl;
    }

    public abstract void g();

    public abstract void h();

    public abstract void i(int[] var1);

    public abstract void j(float var1, float var2, float var3);

    public void k() {
        ArrayList<e> arrayList = this.s;
        if (arrayList != null) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ((e)iterator.next()).a();
            }
        }
    }

    public void l() {
        ArrayList<e> arrayList = this.s;
        if (arrayList != null) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ((e)iterator.next()).b();
            }
        }
    }

    public abstract boolean m();

    public final void n(float f2) {
        this.o = f2;
        Matrix matrix = this.y;
        matrix.reset();
        this.t.getDrawable();
        this.t.setImageMatrix(matrix);
    }

    public abstract void o(ColorStateList var1);

    public abstract boolean p();

    public final boolean q() {
        return l.A((View)this.t) && !this.t.isInEditMode();
    }

    public final boolean r() {
        return !this.c || this.t.getSizeDimension() >= 0;
        {
        }
    }

    public abstract void s();

    public final void t() {
        block5 : {
            Rect rect;
            block4 : {
                block2 : {
                    block3 : {
                        rect = this.v;
                        this.d(rect);
                        h.i.o(null, "Didn't initialize content background");
                        if (!this.p()) break block2;
                        InsetDrawable insetDrawable = new InsetDrawable(null, rect.left, rect.top, rect.right, rect.bottom);
                        FloatingActionButton.b b2 = (FloatingActionButton.b)this.u;
                        if (b2 == null) break block3;
                        FloatingActionButton.c((FloatingActionButton)b2.a, (Drawable)insetDrawable);
                        break block4;
                    }
                    throw null;
                }
                if ((FloatingActionButton.b)this.u == null) break block5;
            }
            c.e.a.a.e0.b b3 = this.u;
            int n2 = rect.left;
            int n3 = rect.top;
            int n4 = rect.right;
            int n5 = rect.bottom;
            FloatingActionButton.b b4 = (FloatingActionButton.b)b3;
            b4.a.o.set(n2, n3, n4, n5);
            FloatingActionButton floatingActionButton = b4.a;
            int n6 = floatingActionButton.m;
            floatingActionButton.setPadding(n2 + n6, n3 + n6, n4 + n6, n5 + n6);
            return;
        }
        throw null;
    }

    public static interface e {
        public void a();

        public void b();
    }

    public static interface f {
    }

    public abstract class h
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float b;
        public float c;

        public h(c.e.a.a.z.c c2) {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            if (e.this != null) {
                this.a = false;
                return;
            }
            throw null;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                c.e.a.a.f0.g g2 = e.this.b;
                float f2 = g2 == null ? 0.0f : g2.e.o;
                this.b = f2;
                this.c = this.a();
                this.a = true;
            }
            e e2 = e.this;
            valueAnimator.getAnimatedFraction();
            if (e2 != null) {
                return;
            }
            throw null;
        }
    }

}

