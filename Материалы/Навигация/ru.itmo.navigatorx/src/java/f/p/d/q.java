/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.PointF
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$m
 *  androidx.recyclerview.widget.RecyclerView$v
 *  androidx.recyclerview.widget.RecyclerView$v$a
 *  androidx.recyclerview.widget.RecyclerView$w
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 */
package f.p.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class q
extends RecyclerView.v {
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public PointF k;
    public final DisplayMetrics l;
    public boolean m = false;
    public float n;
    public int o = 0;
    public int p = 0;

    public q(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    public void d(View view, RecyclerView.w w2, RecyclerView.v.a a2) {
        float f2;
        int n2;
        float f3;
        int n3;
        PointF pointF = this.k;
        int n4 = pointF != null && (f3 = (pointF.x FCMPL 0.0f)) != false ? (f3 > 0 ? 1 : -1) : 0;
        RecyclerView.l l2 = this.c;
        if (l2 != null && l2.e()) {
            RecyclerView.m m2 = (RecyclerView.m)view.getLayoutParams();
            n3 = this.f(l2.C(view) - m2.leftMargin, l2.F(view) + m2.rightMargin, l2.M(), l2.q - l2.N(), n4);
        } else {
            n3 = 0;
        }
        PointF pointF2 = this.k;
        int n5 = pointF2 != null && (f2 = (pointF2.y FCMPL 0.0f)) != false ? (f2 > 0 ? 1 : -1) : 0;
        RecyclerView.l l3 = this.c;
        int n6 = 0;
        if (l3 != null) {
            if (!l3.f()) {
                n6 = 0;
            } else {
                RecyclerView.m m3 = (RecyclerView.m)view.getLayoutParams();
                n6 = this.f(l3.G(view) - m3.topMargin, l3.B(view) + m3.bottomMargin, l3.O(), l3.r - l3.L(), n5);
            }
        }
        if ((n2 = (int)Math.ceil((double)((double)this.h((int)Math.sqrt((double)(n3 * n3 + n6 * n6))) / 0.3356))) > 0) {
            a2.b(-n3, -n6, n2, (Interpolator)this.j);
        }
    }

    public int f(int n2, int n3, int n4, int n5, int n6) {
        if (n6 != -1) {
            if (n6 != 0) {
                if (n6 == 1) {
                    return n5 - n3;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int n7 = n4 - n2;
            if (n7 > 0) {
                return n7;
            }
            int n8 = n5 - n3;
            if (n8 < 0) {
                return n8;
            }
            return 0;
        }
        return n4 - n2;
    }

    public float g(DisplayMetrics displayMetrics) {
        return 25.0f / (float)displayMetrics.densityDpi;
    }

    public int h(int n2) {
        float f2 = Math.abs((int)n2);
        if (!this.m) {
            this.n = this.g(this.l);
            this.m = true;
        }
        return (int)Math.ceil((double)(f2 * this.n));
    }
}

