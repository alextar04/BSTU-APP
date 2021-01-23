/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.OverScroller
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  c.e.a.a.m.g
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 *  f.h.l.l
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package c.e.a.a.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.e.a.a.m.g;
import com.google.android.material.appbar.AppBarLayout;
import f.h.l.l;
import java.lang.ref.WeakReference;

public abstract class e<V extends View>
extends g<V> {
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g = -1;
    public int h;
    public int i = -1;
    public VelocityTracker j;

    public e() {
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean A(CoordinatorLayout var1_1, V var2_2, MotionEvent var3_3) {
        block14 : {
            block11 : {
                block13 : {
                    block12 : {
                        var4_4 = var3_3.getActionMasked();
                        if (var4_4 == (var5_5 = 1)) break block11;
                        if (var4_4 == 2) break block12;
                        if (var4_4 == 3) ** GOTO lbl-1000
                        if (var4_4 == 6) {
                            var22_6 = var3_3.getActionIndex() == 0 ? var5_5 : 0;
                            this.g = var3_3.getPointerId(var22_6);
                            this.h = (int)(0.5f + var3_3.getY(var22_6));
                        }
                        break block13;
                    }
                    var18_7 = var3_3.findPointerIndex(this.g);
                    if (var18_7 == -1) {
                        return false;
                    }
                    var19_8 = (int)var3_3.getY(var18_7);
                    var20_9 = this.h - var19_8;
                    this.h = var19_8;
                    this.F(var1_1, var2_2, var20_9, -((AppBarLayout)var2_2).getDownNestedScrollRange(), 0);
                }
                var7_10 = 0;
                break block14;
            }
            var6_11 = this.j;
            if (var6_11 != null) {
                var6_11.addMovement(var3_3);
                this.j.computeCurrentVelocity(1000);
                var10_12 = this.j.getYVelocity(this.g);
                var11_13 = (AppBarLayout)var2_2;
                var12_14 = -var11_13.getTotalScrollRange();
                var13_15 = this.d;
                if (var13_15 != null) {
                    var2_2.removeCallbacks(var13_15);
                    this.d = null;
                }
                if (this.e == null) {
                    this.e = new OverScroller(var2_2.getContext());
                }
                this.e.fling(0, this.B(), 0, Math.round((float)var10_12), 0, 0, var12_14, 0);
                if (this.e.computeScrollOffset()) {
                    this.d = var14_16 = new Runnable(this, var1_1, var2_2){
                        public final CoordinatorLayout e;
                        public final V f;
                        {
                            this.e = coordinatorLayout;
                            this.f = v2;
                        }

                        public void run() {
                            OverScroller overScroller;
                            if (this.f != null && (overScroller = g.e) != null) {
                                if (overScroller.computeScrollOffset()) {
                                    e e2 = g;
                                    e2.G(this.e, this.f, e2.e.getCurrY());
                                    this.f.postOnAnimation((Runnable)this);
                                    return;
                                }
                                e e3 = g;
                                CoordinatorLayout coordinatorLayout = this.e;
                                V v2 = this.f;
                                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior)e3;
                                if (baseBehavior != null) {
                                    AppBarLayout appBarLayout = (AppBarLayout)v2;
                                    baseBehavior.O(coordinatorLayout, appBarLayout);
                                    if (appBarLayout.m) {
                                        appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
                                        return;
                                    }
                                } else {
                                    throw null;
                                }
                            }
                        }
                    };
                    l.L(var2_2, (Runnable)var14_16);
                } else {
                    var15_17 = (AppBarLayout.BaseBehavior)this;
                    var15_17.O(var1_1, var11_13);
                    if (var11_13.m) {
                        var11_13.c(var11_13.d(var15_17.K(var1_1)));
                    }
                }
                var7_10 = var5_5;
            } else lbl-1000: // 2 sources:
            {
                var7_10 = 0;
            }
            this.f = false;
            this.g = -1;
            var8_18 = this.j;
            if (var8_18 != null) {
                var8_18.recycle();
                this.j = null;
            }
        }
        var9_19 = this.j;
        if (var9_19 != null) {
            var9_19.addMovement(var3_3);
        }
        if (this.f != false) return (boolean)var5_5;
        if (var7_10 == 0) return (boolean)0;
        return (boolean)var5_5;
    }

    public abstract int E();

    public final int F(CoordinatorLayout coordinatorLayout, V v2, int n2, int n3, int n4) {
        return this.H(coordinatorLayout, v2, this.E() - n2, n3, n4);
    }

    public int G(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        return this.H(coordinatorLayout, v2, n2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int H(CoordinatorLayout var1, V var2, int var3, int var4, int var5);

    public boolean j(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.i < 0) {
            this.i = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f) {
            int n2 = this.g;
            if (n2 == -1) {
                return false;
            }
            int n3 = motionEvent.findPointerIndex(n2);
            if (n3 == -1) {
                return false;
            }
            int n4 = (int)motionEvent.getY(n3);
            if (Math.abs((int)(n4 - this.h)) > this.i) {
                this.h = n4;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            View view;
            this.g = -1;
            int n5 = (int)motionEvent.getX();
            int n6 = (int)motionEvent.getY();
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior)this;
            (AppBarLayout)v2;
            WeakReference weakReference = baseBehavior.q;
            boolean bl = weakReference == null || (view = (View)weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1);
            boolean bl2 = bl && coordinatorLayout.l(v2, n5, n6);
            this.f = bl2;
            if (bl2) {
                OverScroller overScroller;
                this.h = n6;
                this.g = motionEvent.getPointerId(0);
                if (this.j == null) {
                    this.j = VelocityTracker.obtain();
                }
                if ((overScroller = this.e) != null && !overScroller.isFinished()) {
                    this.e.abortAnimation();
                    return true;
                }
            }
        }
        if ((velocityTracker = this.j) != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

}

