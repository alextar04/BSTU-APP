/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.util.SparseBooleanArray
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.ActionMenuView$c
 *  f.b.o.i.b
 *  f.b.o.i.g
 *  f.b.o.i.i
 *  f.b.o.i.k
 *  f.b.p.c$a
 *  f.b.p.c$b
 *  f.b.p.c$d
 *  f.b.p.c$e
 *  f.b.p.c$f
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 */
package f.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.ActionMenuView;
import f.b.g;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.k;
import f.b.o.i.l;
import f.b.o.i.m;
import f.b.o.i.n;
import f.b.o.i.r;
import f.b.p.c;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis.
 */
public class c
extends f.b.o.i.b {
    public b A;
    public final f B;
    public int C;
    public d m;
    public Drawable n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public int v;
    public final SparseBooleanArray w;
    public e x;
    public a y;
    public c z;

    public c(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
        this.w = new SparseBooleanArray();
        this.B = new /* Unavailable Anonymous Inner Class!! */;
    }

    public void a(f.b.o.i.g g2, boolean bl) {
        this.f();
        m.a a2 = this.i;
        if (a2 != null) {
            a2.a(g2, bl);
        }
    }

    public View b(i i2, View view, ViewGroup viewGroup) {
        View view2 = i2.getActionView();
        if (view2 == null || i2.f()) {
            view2 = super.b(i2, view, viewGroup);
        }
        int n2 = i2.C ? 8 : 0;
        view2.setVisibility(n2);
        ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            view2.setLayoutParams((ViewGroup.LayoutParams)actionMenuView.s(layoutParams));
        }
        return view2;
    }

    public boolean c() {
        int n2;
        int n3;
        ArrayList arrayList;
        int n4;
        f.b.o.i.g g2 = this.g;
        if (g2 != null) {
            arrayList = g2.l();
            n3 = arrayList.size();
        } else {
            arrayList = null;
            n3 = 0;
        }
        int n5 = this.t;
        int n6 = this.s;
        int n7 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        ViewGroup viewGroup = (ViewGroup)this.l;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        do {
            n2 = 2;
            n4 = 1;
            if (n8 >= n3) break;
            i i2 = (i)arrayList.get(n8);
            int n12 = (n2 & i2.y) == n2 ? n4 : 0;
            if (n12 != 0) {
                ++n11;
            } else {
                int n13 = (n4 & i2.y) == n4 ? n4 : 0;
                if (n13 != 0) {
                    ++n10;
                } else {
                    n9 = n4;
                }
            }
            if (this.u && i2.C) {
                n5 = 0;
            }
            ++n8;
        } while (true);
        if (this.p && (n9 != 0 || n10 + n11 > n5)) {
            --n5;
        }
        int n14 = n5 - n11;
        SparseBooleanArray sparseBooleanArray = this.w;
        sparseBooleanArray.clear();
        int n15 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            i i4 = (i)arrayList.get(i3);
            int n16 = (n2 & i4.y) == n2 ? n4 : 0;
            if (n16 != 0) {
                int n17;
                View view = this.b(i4, null, viewGroup);
                view.measure(n7, n7);
                int n18 = view.getMeasuredWidth();
                n6 -= n18;
                if (n15 == 0) {
                    n15 = n18;
                }
                if ((n17 = i4.b) != 0) {
                    sparseBooleanArray.put(n17, (boolean)n4);
                }
                i4.k((boolean)n4);
            } else {
                int n19 = (n4 & i4.y) == n4 ? n4 : 0;
                if (n19 != 0) {
                    int n20;
                    int n21 = i4.b;
                    boolean bl = sparseBooleanArray.get(n21);
                    int n22 = (n14 > 0 || bl) && n6 > 0 ? n4 : 0;
                    if (n22 != 0) {
                        View view = this.b(i4, null, viewGroup);
                        view.measure(n7, n7);
                        int n23 = view.getMeasuredWidth();
                        n6 -= n23;
                        if (n15 == 0) {
                            n15 = n23;
                        }
                        int n24 = n6 + n15 > 0 ? n4 : 0;
                        n22 &= n24;
                    }
                    if ((n20 = n22) != 0 && n21 != 0) {
                        sparseBooleanArray.put(n21, (boolean)n4);
                    } else if (bl) {
                        sparseBooleanArray.put(n21, false);
                        for (int i5 = 0; i5 < i3; ++i5) {
                            i i6 = (i)arrayList.get(i5);
                            if (i6.b != n21) continue;
                            if (i6.g()) {
                                ++n14;
                            }
                            i6.k(false);
                        }
                    }
                    if (n20 != 0) {
                        --n14;
                    }
                    i4.k((boolean)n20);
                } else {
                    i4.k(false);
                }
            }
            n2 = 2;
            n4 = 1;
        }
        return (boolean)n4;
    }

    public void d(Context context, f.b.o.i.g g2) {
        this.f = context;
        LayoutInflater.from((Context)context);
        this.g = g2;
        Resources resources = context.getResources();
        if (!this.q) {
            this.p = true;
        }
        int n2 = context.getResources().getDisplayMetrics().widthPixels;
        int n3 = 2;
        this.r = n2 / n3;
        Configuration configuration = context.getResources().getConfiguration();
        int n4 = configuration.screenWidthDp;
        int n5 = configuration.screenHeightDp;
        if (!(configuration.smallestScreenWidthDp > 600 || n4 > 600 || n4 > 960 && n5 > 720 || n4 > 720 && n5 > 960)) {
            if (!(n4 >= 500 || n4 > 640 && n5 > 480 || n4 > 480 && n5 > 640)) {
                if (n4 >= 360) {
                    n3 = 3;
                }
            } else {
                n3 = 4;
            }
        } else {
            n3 = 5;
        }
        this.t = n3;
        int n6 = this.r;
        if (this.p) {
            if (this.m == null) {
                d d2;
                this.m = d2 = new /* Unavailable Anonymous Inner Class!! */;
                if (this.o) {
                    d2.setImageDrawable(this.n);
                    this.n = null;
                    this.o = false;
                }
                int n7 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.m.measure(n7, n7);
            }
            n6 -= this.m.getMeasuredWidth();
        } else {
            this.m = null;
        }
        this.s = n6;
        this.v = (int)(56.0f * resources.getDisplayMetrics().density);
    }

    public boolean f() {
        return this.k() | this.l();
    }

    public boolean i(r r2) {
        a a2;
        View view;
        f.b.o.i.g g2;
        boolean bl;
        if (!r2.hasVisibleItems()) {
            return false;
        }
        r r3 = r2;
        while ((g2 = r3.A) != this.g) {
            r3 = (r)g2;
        }
        i i2 = r3.B;
        ViewGroup viewGroup = (ViewGroup)this.l;
        if (viewGroup == null) {
            view = null;
        } else {
            int n2 = viewGroup.getChildCount();
            int n3 = 0;
            do {
                view = null;
                if (n3 >= n2) break;
                View view2 = viewGroup.getChildAt(n3);
                if (view2 instanceof n.a && ((n.a)view2).getItemData() == i2) {
                    view = view2;
                    break;
                }
                ++n3;
            } while (true);
        }
        if (view == null) {
            return false;
        }
        int n4 = r2.size();
        int n5 = 0;
        do {
            bl = false;
            if (n5 >= n4) break;
            MenuItem menuItem = r2.getItem(n5);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
                bl = true;
                break;
            }
            ++n5;
        } while (true);
        this.y = a2 = new /* Unavailable Anonymous Inner Class!! */;
        a2.h = bl;
        k k2 = a2.j;
        if (k2 != null) {
            k2.p(bl);
        }
        if (this.y.f()) {
            super.i(r2);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void j(boolean bl) {
        ArrayList arrayList;
        n n2;
        ViewParent viewParent;
        f.b.o.i.g g2;
        super.j(bl);
        ((View)this.l).requestLayout();
        f.b.o.i.g g3 = this.g;
        if (g3 != null) {
            g3.i();
            ArrayList arrayList2 = g3.i;
            int n3 = arrayList2.size();
            for (int i2 = 0; i2 < n3; ++i2) {
            }
        }
        if ((g2 = this.g) != null) {
            g2.i();
            arrayList = g2.j;
        } else {
            arrayList = null;
        }
        boolean bl2 = this.p;
        boolean bl3 = false;
        if (bl2) {
            bl3 = false;
            if (arrayList != null) {
                int n4 = arrayList.size();
                if (n4 == 1) {
                    bl3 = true ^ ((i)arrayList.get((int)0)).C;
                } else {
                    bl3 = false;
                    if (n4 > 0) {
                        bl3 = true;
                    }
                }
            }
        }
        d d2 = this.m;
        if (bl3) {
            ViewGroup viewGroup;
            if (d2 == null) {
                this.m = new /* Unavailable Anonymous Inner Class!! */;
            }
            if ((viewGroup = (ViewGroup)this.m.getParent()) != this.l) {
                if (viewGroup != null) {
                    viewGroup.removeView((View)this.m);
                }
                ActionMenuView actionMenuView = (ActionMenuView)this.l;
                d d3 = this.m;
                ActionMenuView.c c2 = actionMenuView.r();
                c2.c = true;
                actionMenuView.addView((View)d3, (ViewGroup.LayoutParams)c2);
            }
        } else if (d2 != null && (viewParent = d2.getParent()) == (n2 = this.l)) {
            ((ViewGroup)n2).removeView((View)this.m);
        }
        ((ActionMenuView)this.l).setOverflowReserved(this.p);
    }

    public boolean k() {
        n n2;
        c c2 = this.z;
        if (c2 != null && (n2 = this.l) != null) {
            ((View)n2).removeCallbacks((Runnable)c2);
            this.z = null;
            return true;
        }
        e e2 = this.x;
        if (e2 != null) {
            if (e2.b()) {
                e2.j.dismiss();
            }
            return true;
        }
        return false;
    }

    public boolean l() {
        a a2 = this.y;
        if (a2 != null) {
            if (a2.b()) {
                a2.j.dismiss();
            }
            return true;
        }
        return false;
    }

    public boolean m() {
        e e2 = this.x;
        return e2 != null && e2.b();
    }

    public boolean n() {
        f.b.o.i.g g2;
        if (this.p && !this.m() && (g2 = this.g) != null && this.l != null && this.z == null) {
            g2.i();
            if (!g2.j.isEmpty()) {
                e e2 = new /* Unavailable Anonymous Inner Class!! */;
                Runnable runnable = new Runnable(e2){
                    public e e;
                    {
                        this.e = e2;
                    }

                    public void run() {
                        View view;
                        g.a a2;
                        f.b.o.i.g g2 = c.this.g;
                        if (g2 != null && (a2 = g2.e) != null) {
                            a2.b(g2);
                        }
                        if ((view = (View)c.this.l) != null && view.getWindowToken() != null && this.e.f()) {
                            c.this.x = this.e;
                        }
                        c.this.z = null;
                    }
                };
                this.z = runnable;
                ((View)this.l).post(runnable);
                return true;
            }
        }
        return false;
    }

}

