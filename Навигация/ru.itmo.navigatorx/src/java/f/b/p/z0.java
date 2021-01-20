/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnHoverListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.TextView
 *  f.h.l.l
 *  f.h.l.p
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package f.b.p;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import f.b.d;
import f.b.p.a1;
import f.h.l.l;
import f.h.l.p;

public class z0
implements View.OnLongClickListener,
View.OnHoverListener,
View.OnAttachStateChangeListener {
    public static z0 n;
    public static z0 o;
    public final View e;
    public final CharSequence f;
    public final int g;
    public final Runnable h = new Runnable(){

        public void run() {
            z0.this.d(false);
        }
    };
    public final Runnable i = new Runnable(){

        public void run() {
            z0.this.b();
        }
    };
    public int j;
    public int k;
    public a1 l;
    public boolean m;

    public z0(View view, CharSequence charSequence) {
        this.e = view;
        this.f = charSequence;
        this.g = p.c((ViewConfiguration)ViewConfiguration.get((Context)view.getContext()));
        this.a();
        this.e.setOnLongClickListener((View.OnLongClickListener)this);
        this.e.setOnHoverListener((View.OnHoverListener)this);
    }

    public static void c(z0 z02) {
        z0 z03 = n;
        if (z03 != null) {
            z03.e.removeCallbacks(z03.h);
        }
        n = z02;
        if (z02 != null) {
            z02.e.postDelayed(z02.h, (long)ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.j = Integer.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
    }

    public void b() {
        if (o == this) {
            o = null;
            a1 a12 = this.l;
            if (a12 != null) {
                a12.a();
                this.l = null;
                this.a();
                this.e.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            } else {
                Log.e((String)"TooltipCompatHandler", (String)"sActiveHandler.mPopup == null");
            }
        }
        if (n == this) {
            z0.c(null);
        }
        this.e.removeCallbacks(this.i);
    }

    public void d(boolean bl) {
        int n2;
        a1 a12;
        long l2;
        int n3;
        if (!l.z((View)this.e)) {
            return;
        }
        z0.c(null);
        z0 z02 = o;
        if (z02 != null) {
            z02.b();
        }
        o = this;
        this.m = bl;
        this.l = a12 = new a1(this.e.getContext());
        View view = this.e;
        int n4 = this.j;
        int n5 = this.k;
        boolean bl2 = this.m;
        CharSequence charSequence = this.f;
        boolean bl3 = a12.b.getParent() != null;
        if (bl3) {
            a12.a();
        }
        a12.c.setText(charSequence);
        WindowManager.LayoutParams layoutParams = a12.d;
        layoutParams.token = view.getApplicationWindowToken();
        int n6 = a12.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < n6) {
            n4 = view.getWidth() / 2;
        }
        if (view.getHeight() >= n6) {
            int n7 = a12.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            n2 = n5 + n7;
            n3 = n5 - n7;
        } else {
            n2 = view.getHeight();
            n3 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = a12.a.getResources();
        int n8 = bl2 ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch;
        int n9 = resources.getDimensionPixelOffset(n8);
        View view2 = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams)layoutParams2).type != 2) {
            Context context = view.getContext();
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    view2 = ((Activity)context).getWindow().getDecorView();
                    break;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
        }
        if (view2 == null) {
            Log.e((String)"TooltipPopup", (String)"Cannot find app view");
        } else {
            view2.getWindowVisibleDisplayFrame(a12.e);
            Rect rect = a12.e;
            if (rect.left < 0 && rect.top < 0) {
                Resources resources2 = a12.a.getResources();
                int n10 = resources2.getIdentifier("status_bar_height", "dimen", "android");
                int n11 = n10 != 0 ? resources2.getDimensionPixelSize(n10) : 0;
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                a12.e.set(0, n11, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            view2.getLocationOnScreen(a12.g);
            view.getLocationOnScreen(a12.f);
            int[] arrn = a12.f;
            int n12 = arrn[0];
            int[] arrn2 = a12.g;
            arrn[0] = n12 - arrn2[0];
            arrn[1] = arrn[1] - arrn2[1];
            layoutParams.x = n4 + arrn[0] - view2.getWidth() / 2;
            int n13 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            a12.b.measure(n13, n13);
            int n14 = a12.b.getMeasuredHeight();
            int[] arrn3 = a12.f;
            int n15 = n3 + arrn3[1] - n9 - n14;
            int n16 = n9 + (n2 + arrn3[1]);
            layoutParams.y = !(!bl2 ? n14 + n16 > a12.e.height() : n15 >= 0) ? n16 : n15;
        }
        ((WindowManager)a12.a.getSystemService("window")).addView(a12.b, (ViewGroup.LayoutParams)a12.d);
        this.e.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        if (this.m) {
            l2 = 2500L;
        } else {
            long l3 = (1 & this.e.getWindowSystemUiVisibility()) == 1 ? 3000L : 15000L;
            l2 = l3 - (long)ViewConfiguration.getLongPressTimeout();
        }
        this.e.removeCallbacks(this.i);
        this.e.postDelayed(this.i, l2);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.l != null && this.m) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager)this.e.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int n2 = motionEvent.getAction();
        if (n2 != 7) {
            if (n2 != 10) {
                return false;
            }
            this.a();
            this.b();
            return false;
        }
        if (this.e.isEnabled() && this.l == null) {
            boolean bl;
            int n3 = (int)motionEvent.getX();
            int n4 = (int)motionEvent.getY();
            if (Math.abs((int)(n3 - this.j)) <= this.g && Math.abs((int)(n4 - this.k)) <= this.g) {
                bl = false;
            } else {
                this.j = n3;
                this.k = n4;
                bl = true;
            }
            if (bl) {
                z0.c(this);
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.j = view.getWidth() / 2;
        this.k = view.getHeight() / 2;
        this.d(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.b();
    }

}

