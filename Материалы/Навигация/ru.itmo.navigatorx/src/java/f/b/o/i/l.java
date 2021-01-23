/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.Gravity
 *  android.view.View
 *  android.view.WindowManager
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  f.b.o.i.d
 *  f.b.o.i.g
 *  f.b.o.i.k
 *  f.b.o.i.q
 *  f.h.l.l
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import f.b.o.i.d;
import f.b.o.i.g;
import f.b.o.i.k;
import f.b.o.i.m;
import f.b.o.i.q;

public class l {
    public final Context a;
    public final g b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g = 8388611;
    public boolean h;
    public m.a i;
    public k j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener(){

        public void onDismiss() {
            l.this.c();
        }
    };

    public l(Context context, g g2, View view, boolean bl, int n2, int n3) {
        this.a = context;
        this.b = g2;
        this.f = view;
        this.c = bl;
        this.d = n2;
        this.e = n3;
    }

    public k a() {
        if (this.j == null) {
            d d2;
            Display display = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            boolean bl = Math.min((int)point.x, (int)point.y) >= this.a.getResources().getDimensionPixelSize(f.b.d.abc_cascading_menus_min_smallest_width);
            if (bl) {
                Context context = this.a;
                View view = this.f;
                int n2 = this.d;
                int n3 = this.e;
                boolean bl2 = this.c;
                d2 = new d(context, view, n2, n3, bl2);
            } else {
                Context context = this.a;
                g g2 = this.b;
                View view = this.f;
                int n4 = this.d;
                int n5 = this.e;
                boolean bl3 = this.c;
                d2 = new q(context, g2, view, n4, n5, bl3);
            }
            d2.l(this.b);
            d2.s(this.l);
            d2.o(this.f);
            d2.h(this.i);
            d2.p(this.h);
            d2.q(this.g);
            this.j = d2;
        }
        return this.j;
    }

    public boolean b() {
        k k2 = this.j;
        return k2 != null && k2.b();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a a2) {
        this.i = a2;
        k k2 = this.j;
        if (k2 != null) {
            k2.h(a2);
        }
    }

    public final void e(int n2, int n3, boolean bl, boolean bl2) {
        k k2 = this.a();
        k2.t(bl2);
        if (bl) {
            if ((7 & Gravity.getAbsoluteGravity((int)this.g, (int)f.h.l.l.n((View)this.f))) == 5) {
                n2 -= this.f.getWidth();
            }
            k2.r(n2);
            k2.u(n3);
            int n4 = (int)(48.0f * this.a.getResources().getDisplayMetrics().density / 2.0f);
            k2.e = new Rect(n2 - n4, n3 - n4, n2 + n4, n3 + n4);
        }
        k2.f();
    }

    public boolean f() {
        if (this.b()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        this.e(0, 0, false, false);
        return true;
    }

}

