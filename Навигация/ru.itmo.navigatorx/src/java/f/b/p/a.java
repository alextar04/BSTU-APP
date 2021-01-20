/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  androidx.appcompat.widget.ActionMenuView
 *  f.b.o.i.b
 *  f.b.o.i.g
 *  f.b.p.a$a
 *  f.b.p.c
 *  f.h.l.l
 *  f.h.l.q
 *  f.h.l.r
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package f.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import f.b.j;
import f.b.o.i.b;
import f.b.o.i.g;
import f.b.p.a;
import f.b.p.c;
import f.h.l.l;
import f.h.l.q;
import f.h.l.r;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis.
 */
public abstract class a
extends ViewGroup {
    public final a e;
    public final Context f;
    public ActionMenuView g;
    public c h;
    public int i;
    public q j;
    public boolean k;
    public boolean l;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.e = new /* Unavailable Anonymous Inner Class!! */;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(f.b.a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f = new ContextThemeWrapper(context, typedValue.resourceId);
            return;
        }
        this.f = context;
    }

    public static /* synthetic */ void a(a a2, int n2) {
        super.setVisibility(n2);
    }

    public static /* synthetic */ void b(a a2, int n2) {
        super.setVisibility(n2);
    }

    public int c(View view, int n2, int n3, int n4) {
        view.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE), n3);
        return Math.max((int)0, (int)(n2 - view.getMeasuredWidth() - n4));
    }

    public int d(View view, int n2, int n3, int n4, boolean bl) {
        int n5 = view.getMeasuredWidth();
        int n6 = view.getMeasuredHeight();
        int n7 = n3 + (n4 - n6) / 2;
        if (bl) {
            view.layout(n2 - n5, n7, n2, n6 + n7);
        } else {
            view.layout(n2, n7, n2 + n5, n6 + n7);
        }
        if (bl) {
            n5 = -n5;
        }
        return n5;
    }

    public q e(int n2, long l2) {
        q q2 = this.j;
        if (q2 != null) {
            q2.b();
        }
        if (n2 == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            q q3 = l.a((View)this);
            q3.a(1.0f);
            q3.c(l2);
            a a2 = this.e;
            a2.c.j = q3;
            a2.b = n2;
            View view = (View)q3.a.get();
            if (view != null) {
                q3.e(view, (r)a2);
            }
            return q3;
        }
        q q4 = l.a((View)this);
        q4.a(0.0f);
        q4.c(l2);
        a a3 = this.e;
        a3.c.j = q4;
        a3.b = n2;
        View view = (View)q4.a.get();
        if (view != null) {
            q4.e(view, (r)a3);
        }
        return q4;
    }

    public int getAnimatedVisibility() {
        if (this.j != null) {
            return this.e.b;
        }
        return this.getVisibility();
    }

    public int getContentHeight() {
        return this.i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(null, j.ActionBar, f.b.a.actionBarStyle, 0);
        this.setContentHeight(typedArray.getLayoutDimension(j.ActionBar_height, 0));
        typedArray.recycle();
        c c2 = this.h;
        if (c2 != null) {
            Configuration configuration2 = c2.f.getResources().getConfiguration();
            int n2 = configuration2.screenWidthDp;
            int n3 = configuration2.screenHeightDp;
            int n4 = !(configuration2.smallestScreenWidthDp > 600 || n2 > 600 || n2 > 960 && n3 > 720 || n2 > 720 && n3 > 960) ? (!(n2 >= 500 || n2 > 640 && n3 > 480 || n2 > 480 && n3 > 640) ? (n2 >= 360 ? 3 : 2) : 4) : 5;
            c2.t = n4;
            g g2 = c2.g;
            if (g2 != null) {
                g2.q(true);
            }
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 9) {
            this.l = false;
        }
        if (!this.l) {
            boolean bl = super.onHoverEvent(motionEvent);
            if (n2 == 9 && !bl) {
                this.l = true;
            }
        }
        if (n2 == 10 || n2 == 3) {
            this.l = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 0) {
            this.k = false;
        }
        if (!this.k) {
            boolean bl = super.onTouchEvent(motionEvent);
            if (n2 == 0 && !bl) {
                this.k = true;
            }
        }
        if (n2 == 1 || n2 == 3) {
            this.k = false;
        }
        return true;
    }

    public abstract void setContentHeight(int var1);

    public void setVisibility(int n2) {
        if (n2 != this.getVisibility()) {
            q q2 = this.j;
            if (q2 != null) {
                q2.b();
            }
            super.setVisibility(n2);
        }
    }
}

