/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.Gravity
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$c
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$f
 *  c.e.a.a.m.g
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 *  com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
 *  f.b.k.h
 *  f.h.l.l
 *  f.h.l.u
 *  java.util.List
 */
package c.e.a.a.m;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.e.a.a.m.g;
import com.google.android.material.appbar.AppBarLayout;
import f.b.k.h;
import f.h.l.l;
import f.h.l.u;
import java.util.List;

public abstract class f
extends g<View> {
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public int f = 0;
    public int g;

    public f() {
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void C(CoordinatorLayout coordinatorLayout, View view, int n2) {
        int n3;
        List list = coordinatorLayout.e(view);
        AppBarLayout appBarLayout = ((AppBarLayout.ScrollingViewBehavior)this).F(list);
        if (appBarLayout != null) {
            CoordinatorLayout.f f2 = (CoordinatorLayout.f)view.getLayoutParams();
            Rect rect = this.d;
            rect.set(coordinatorLayout.getPaddingLeft() + f2.leftMargin, appBarLayout.getBottom() + f2.topMargin, coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight() - f2.rightMargin, coordinatorLayout.getHeight() + appBarLayout.getBottom() - coordinatorLayout.getPaddingBottom() - f2.bottomMargin);
            u u2 = coordinatorLayout.getLastWindowInsets();
            if (u2 != null && l.k((View)coordinatorLayout) && !view.getFitsSystemWindows()) {
                rect.left += u2.b();
                rect.right -= u2.c();
            }
            Rect rect2 = this.e;
            int n4 = f2.c;
            if (n4 == 0) {
                n4 = 8388659;
            }
            Gravity.apply((int)n4, (int)view.getMeasuredWidth(), (int)view.getMeasuredHeight(), (Rect)rect, (Rect)rect2, (int)n2);
            int n5 = this.E((View)appBarLayout);
            view.layout(rect2.left, rect2.top - n5, rect2.right, rect2.bottom - n5);
            n3 = rect2.top - appBarLayout.getBottom();
        } else {
            coordinatorLayout.q(view, n2);
            n3 = 0;
        }
        this.f = n3;
    }

    public final int E(View view) {
        if (this.g == 0) {
            return 0;
        }
        boolean bl = view instanceof AppBarLayout;
        float f2 = 0.0f;
        if (bl) {
            AppBarLayout appBarLayout = (AppBarLayout)view;
            int n2 = appBarLayout.getTotalScrollRange();
            int n3 = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c c2 = ((CoordinatorLayout.f)appBarLayout.getLayoutParams()).a;
            int n4 = c2 instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior)c2).E() : 0;
            if (n3 != 0 && n2 + n4 <= n3) {
                f2 = 0.0f;
            } else {
                int n5 = n2 - n3;
                f2 = 0.0f;
                if (n5 != 0) {
                    f2 = 1.0f + (float)n4 / (float)n5;
                }
            }
        }
        int n6 = this.g;
        return h.i.t((int)(f2 * (float)n6), 0, n6);
    }

    public boolean l(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4, int n5) {
        List list;
        AppBarLayout appBarLayout;
        int n6 = view.getLayoutParams().height;
        if ((n6 == -1 || n6 == -2) && (appBarLayout = ((AppBarLayout.ScrollingViewBehavior)this).F(list = coordinatorLayout.e(view))) != null) {
            int n7 = View.MeasureSpec.getSize((int)n4);
            if (n7 > 0) {
                u u2;
                if (l.k((View)appBarLayout) && (u2 = coordinatorLayout.getLastWindowInsets()) != null) {
                    n7 += u2.d() + u2.a();
                }
            } else {
                n7 = coordinatorLayout.getHeight();
            }
            int n8 = n7 + appBarLayout.getTotalScrollRange() - appBarLayout.getMeasuredHeight();
            int n9 = n6 == -1 ? 1073741824 : Integer.MIN_VALUE;
            coordinatorLayout.r(view, n2, n3, View.MeasureSpec.makeMeasureSpec((int)n8, (int)n9), n5);
            return true;
        }
        return false;
    }
}

