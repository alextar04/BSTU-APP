/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.widget.OverScroller
 *  c.a.a.o.c.e$a$a
 *  c.a.a.o.c.e$b
 *  c.a.a.o.e.b
 *  h.h
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package c.a.a.o.c;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.OverScroller;
import c.a.a.i;
import c.a.a.k;
import c.a.a.o.c.e;
import c.a.a.o.d.a;
import c.a.a.o.d.b;
import c.a.a.o.e.b;
import h.h;
import h.m.a.l;
import h.m.b.f;
import h.m.b.j;

public final class e
implements GestureDetector.OnGestureListener {
    public static final String r;
    public static final k s;
    public final GestureDetector e;
    public final OverScroller f;
    public final b.a g;
    public final b.a h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final c.a.a.o.e.b o;
    public final c.a.a.o.a p;
    public final c.a.a.o.d.a q;

    public static {
        String string = r = e.class.getSimpleName();
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
        s = new k(string, null);
    }

    public e(Context context, c.a.a.o.e.b b2, c.a.a.o.a a2, c.a.a.o.d.a a3) {
        j.e((Object)context, (String)"context");
        j.e((Object)b2, (String)"panManager");
        j.e((Object)a2, (String)"stateController");
        j.e((Object)a3, (String)"matrixController");
        this.o = b2;
        this.p = a2;
        this.q = a3;
        GestureDetector gestureDetector = new GestureDetector(context, (GestureDetector.OnGestureListener)this);
        gestureDetector.setOnDoubleTapListener(null);
        this.e = gestureDetector;
        this.f = new OverScroller(context);
        this.g = new b.a();
        this.h = new b.a();
        this.i = true;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
    }

    public final void a() {
        this.f.forceFinished(true);
    }

    public boolean onDown(MotionEvent motionEvent) {
        j.e((Object)motionEvent, (String)"e");
        this.a();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.i) {
            return false;
        }
        c.a.a.o.e.b b2 = this.o;
        boolean bl = b2.d || b2.e;
        if (!bl) {
            return false;
        }
        float f4 = this.o.d ? f2 : 0.0f;
        int n2 = (int)f4;
        float f5 = this.o.e ? f3 : 0.0f;
        int n3 = (int)f5;
        this.o.d(true, this.g);
        this.o.d(false, this.h);
        b.a a2 = this.g;
        int n4 = a2.a;
        int n5 = a2.b;
        int n6 = a2.c;
        b.a a3 = this.h;
        int n7 = a3.a;
        int n8 = a3.b;
        int n9 = a3.c;
        if (!this.n && (a2.d || a3.d)) {
            return false;
        }
        if (n4 >= n6 && n7 >= n9 && !this.o.h()) {
            return false;
        }
        if (!this.p.c(4)) {
            return false;
        }
        this.e.setIsLongpressEnabled(false);
        c.a.a.o.e.b b3 = this.o;
        float f6 = b3.b ? b3.f() : 0.0f;
        c.a.a.o.e.b b4 = this.o;
        boolean bl2 = b4.c;
        float f7 = 0.0f;
        if (bl2) {
            f7 = b4.g();
        }
        k k2 = s;
        Object[] arrobject = new Object[]{"startFling", "velocityX:", n2, "velocityY:", n3};
        k2.a(arrobject);
        k k3 = s;
        Object[] arrobject2 = new Object[]{"startFling", "flingX:", "min:", n4, "max:", n6, "start:", n5, "overScroll:", Float.valueOf((float)f7)};
        k3.a(arrobject2);
        k k4 = s;
        Object[] arrobject3 = new Object[]{"startFling", "flingY:", "min:", n7, "max:", n9, "start:", n8, "overScroll:", Float.valueOf((float)f6)};
        k4.a(arrobject3);
        this.f.fling(n5, n8, n2, n3, n4, n6, n7, n9, (int)f6, (int)f7);
        c.a.a.o.d.a a4 = this.q;
        Runnable runnable = new Runnable(){

            public void run() {
                if (this.f.isFinished()) {
                    this.p.a();
                    this.e.setIsLongpressEnabled(true);
                    return;
                }
                if (this.f.computeScrollOffset()) {
                    i i2 = new i(this.f.getCurrX(), this.f.getCurrY());
                    this.q.d((l<? super b.a, h>)new a(i2));
                    c.a.a.o.d.a a2 = this.q;
                    if (a2 != null) {
                        j.e((Object)this, (String)"action");
                        a2.p.a(this);
                        return;
                    }
                    throw null;
                }
            }
        };
        if (a4 != null) {
            j.e((Object)runnable, (String)"action");
            a4.p.j(runnable);
            return true;
        }
        throw null;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.j) {
            return false;
        }
        boolean bl = motionEvent2 != null && motionEvent2.getPointerCount() == 1;
        boolean bl2 = motionEvent2 != null && motionEvent2.getPointerCount() == 2;
        boolean bl3 = motionEvent2 != null && motionEvent2.getPointerCount() == 3;
        if (!this.k && bl) {
            return false;
        }
        if (!this.l && bl2) {
            return false;
        }
        if (!this.m && bl3) {
            return false;
        }
        c.a.a.o.e.b b2 = this.o;
        boolean bl4 = b2.d || b2.e;
        if (!bl4) {
            return false;
        }
        if (!this.p.c(1)) {
            return false;
        }
        i i2 = new i(-f2, -f3);
        i i3 = this.o.e();
        float f4 = i3.a;
        float f5 = (float)false;
        if (f4 < f5 && i2.a > f5 || i3.a > f5 && i2.a < f5) {
            float f6 = 0.6f * (1.0f - (float)Math.pow((double)(Math.abs((float)i3.a) / this.o.f()), (double)0.4));
            k k2 = s;
            Object[] arrobject = new Object[]{"onScroll", "applying friction X:", Float.valueOf((float)f6)};
            k2.a(arrobject);
            i2.a = f6 * i2.a;
        }
        if (i3.b < f5 && i2.b > f5 || i3.b > f5 && i2.b < f5) {
            float f7 = 0.6f * (1.0f - (float)Math.pow((double)(Math.abs((float)i3.b) / this.o.g()), (double)0.4));
            k k3 = s;
            Object[] arrobject = new Object[]{"onScroll", "applying friction Y:", Float.valueOf((float)f7)};
            k3.a(arrobject);
            i2.b = f7 * i2.b;
        }
        if (!this.o.d) {
            i2.a = 0.0f;
        }
        if (!this.o.e) {
            i2.b = 0.0f;
        }
        if (i2.a != 0.0f || i2.b != 0.0f) {
            this.q.d((l<? super b.a, h>)new b(i2));
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

}

