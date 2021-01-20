/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 *  android.widget.ListView
 *  java.lang.Object
 *  java.lang.Runnable
 */
package f.b.p;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import f.b.o.i.p;
import f.b.p.e0;

public abstract class g0
implements View.OnTouchListener,
View.OnAttachStateChangeListener {
    public final float e;
    public final int f;
    public final int g;
    public final View h;
    public Runnable i;
    public Runnable j;
    public boolean k;
    public int l;
    public final int[] m = new int[2];

    public g0(View view) {
        int n2;
        this.h = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.e = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.f = n2 = ViewConfiguration.getTapTimeout();
        this.g = (n2 + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public final void a() {
        Runnable runnable;
        Runnable runnable2 = this.j;
        if (runnable2 != null) {
            this.h.removeCallbacks(runnable2);
        }
        if ((runnable = this.i) != null) {
            this.h.removeCallbacks(runnable);
        }
    }

    public abstract p b();

    public abstract boolean c();

    public boolean d() {
        p p2 = this.b();
        if (p2 != null && p2.b()) {
            p2.dismiss();
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onTouch(View var1_1, MotionEvent var2_2) {
        block6 : {
            block11 : {
                block7 : {
                    block8 : {
                        block9 : {
                            block10 : {
                                block5 : {
                                    var3_3 = this.k;
                                    var4_4 = 1;
                                    if (!var3_3) break block5;
                                    var21_5 = this.h;
                                    var22_6 = this.b();
                                    if (var22_6 == null || !var22_6.b() || (var24_7 = (e0)var22_6.k()) == null || !var24_7.isShown()) ** GOTO lbl-1000
                                    var25_8 = MotionEvent.obtainNoHistory((MotionEvent)var2_2);
                                    var26_9 = this.m;
                                    var21_5.getLocationOnScreen(var26_9);
                                    var25_8.offsetLocation((float)var26_9[0], (float)var26_9[var4_4]);
                                    var27_10 = this.m;
                                    var24_7.getLocationOnScreen(var27_10);
                                    var25_8.offsetLocation((float)(-var27_10[0]), (float)(-var27_10[var4_4]));
                                    var28_11 = var24_7.b(var25_8, this.l);
                                    var25_8.recycle();
                                    var29_12 = var2_2.getActionMasked();
                                    var30_13 = var29_12 != var4_4 && var29_12 != 3 ? var4_4 : 0;
                                    if (var28_11 && var30_13 != 0) {
                                        var23_14 = var4_4;
                                    } else lbl-1000: // 2 sources:
                                    {
                                        var23_14 = 0;
                                    }
                                    var10_15 = var23_14 == 0 && this.d() ? 0 : var4_4;
                                    break block6;
                                }
                                var5_16 = this.h;
                                if (!var5_16.isEnabled()) break block7;
                                var6_18 = var2_2.getActionMasked();
                                if (var6_18 == 0) break block8;
                                if (var6_18 == var4_4) break block9;
                                if (var6_18 == 2) break block10;
                                if (var6_18 == 3) break block9;
                                break block7;
                            }
                            var15_19 = var2_2.findPointerIndex(this.l);
                            if (var15_19 < 0) break block7;
                            var16_20 = var2_2.getX(var15_19);
                            var17_21 = var2_2.getY(var15_19);
                            var18_22 = this.e;
                            var19_23 = -var18_22;
                            var20_24 = var16_20 >= var19_23 && var17_21 >= var19_23 && var16_20 < var18_22 + (float)(var5_16.getRight() - var5_16.getLeft()) && var17_21 < var18_22 + (float)(var5_16.getBottom() - var5_16.getTop()) ? var4_4 : 0;
                            if (var20_24 != 0) break block7;
                            this.a();
                            var5_16.getParent().requestDisallowInterceptTouchEvent((boolean)var4_4);
                            var9_17 = var4_4;
                            break block11;
                        }
                        this.a();
                        break block7;
                    }
                    this.l = var2_2.getPointerId(0);
                    if (this.i == null) {
                        this.i = new a();
                    }
                    var5_16.postDelayed(this.i, (long)this.f);
                    if (this.j == null) {
                        this.j = new b();
                    }
                    var5_16.postDelayed(this.j, (long)this.g);
                }
                var9_17 = 0;
            }
            var10_15 = var9_17 != 0 && this.c() != false ? var4_4 : 0;
            if (var10_15 != 0) {
                var11_25 = SystemClock.uptimeMillis();
                var13_26 = MotionEvent.obtain((long)var11_25, (long)var11_25, (int)3, (float)0.0f, (float)0.0f, (int)0);
                this.h.onTouchEvent(var13_26);
                var13_26.recycle();
            }
        }
        this.k = var10_15;
        if (var10_15 != 0) return (boolean)var4_4;
        if (var3_3 == false) return (boolean)0;
        return (boolean)var4_4;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.k = false;
        this.l = -1;
        Runnable runnable = this.i;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
        }
    }

    public class a
    implements Runnable {
        public void run() {
            ViewParent viewParent = g0.this.h.getParent();
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b
    implements Runnable {
        public void run() {
            g0 g02 = g0.this;
            g02.a();
            View view = g02.h;
            if (view.isEnabled()) {
                if (view.isLongClickable()) {
                    return;
                }
                if (!g02.c()) {
                    return;
                }
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long l2 = SystemClock.uptimeMillis();
                MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
                view.onTouchEvent(motionEvent);
                motionEvent.recycle();
                g02.k = true;
            }
        }
    }

}

