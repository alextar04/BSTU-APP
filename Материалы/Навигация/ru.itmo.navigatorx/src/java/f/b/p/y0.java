/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.widget.TextView
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$d
 *  f.h.l.l
 *  f.h.l.q
 *  f.h.l.r
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import f.b.h;
import f.b.j;
import f.b.o.i.b;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.m;
import f.b.p.c;
import f.b.p.c0;
import f.b.p.o0;
import f.b.p.p0;
import f.b.p.w0;
import f.b.p.x0;
import f.b.p.y0;
import f.h.l.l;
import f.h.l.q;
import f.h.l.r;
import f.h.l.s;
import java.lang.ref.WeakReference;

public class y0
implements c0 {
    public Toolbar a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public c n;
    public int o;
    public int p;
    public Drawable q;

    public y0(Toolbar toolbar, boolean bl) {
        int n2 = h.abc_action_bar_up_description;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        boolean bl2 = this.i != null;
        this.h = bl2;
        this.g = toolbar.getNavigationIcon();
        w0 w02 = w0.q(toolbar.getContext(), null, j.ActionBar, f.b.a.actionBarStyle, 0);
        this.q = w02.g(j.ActionBar_homeAsUpIndicator);
        if (bl) {
            Drawable drawable;
            int n3;
            Drawable drawable2;
            Drawable drawable3;
            int n4;
            CharSequence charSequence;
            int n5;
            int n6;
            CharSequence charSequence2 = w02.n(j.ActionBar_title);
            if (!TextUtils.isEmpty((CharSequence)charSequence2)) {
                this.h = true;
                this.i = charSequence2;
                if ((8 & this.b) != 0) {
                    this.a.setTitle(charSequence2);
                }
            }
            if (!TextUtils.isEmpty((CharSequence)(charSequence = w02.n(j.ActionBar_subtitle)))) {
                this.j = charSequence;
                if ((8 & this.b) != 0) {
                    this.a.setSubtitle(charSequence);
                }
            }
            if ((drawable = w02.g(j.ActionBar_logo)) != null) {
                this.f = drawable;
                this.y();
            }
            if ((drawable3 = w02.g(j.ActionBar_icon)) != null) {
                this.e = drawable3;
                this.y();
            }
            if (this.g == null && (drawable2 = this.q) != null) {
                this.g = drawable2;
                this.x();
            }
            this.v(w02.j(j.ActionBar_displayOptions, 0));
            int n7 = w02.l(j.ActionBar_customNavigationLayout, 0);
            if (n7 != 0) {
                View view = LayoutInflater.from((Context)this.a.getContext()).inflate(n7, (ViewGroup)this.a, false);
                View view2 = this.d;
                if (view2 != null && (16 & this.b) != 0) {
                    this.a.removeView(view2);
                }
                this.d = view;
                if (view != null && (16 & this.b) != 0) {
                    this.a.addView(view);
                }
                this.v(16 | this.b);
            }
            if ((n3 = w02.k(j.ActionBar_height, 0)) > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = n3;
                this.a.setLayoutParams(layoutParams);
            }
            int n8 = w02.e(j.ActionBar_contentInsetStart, -1);
            int n9 = w02.e(j.ActionBar_contentInsetEnd, -1);
            if (n8 >= 0 || n9 >= 0) {
                Toolbar toolbar2 = this.a;
                int n10 = Math.max((int)n8, (int)0);
                int n11 = Math.max((int)n9, (int)0);
                toolbar2.d();
                toolbar2.x.a(n10, n11);
            }
            if ((n5 = w02.l(j.ActionBar_titleTextStyle, 0)) != 0) {
                Toolbar toolbar3 = this.a;
                Context context = toolbar3.getContext();
                toolbar3.p = n5;
                TextView textView = toolbar3.f;
                if (textView != null) {
                    textView.setTextAppearance(context, n5);
                }
            }
            if ((n6 = w02.l(j.ActionBar_subtitleTextStyle, 0)) != 0) {
                Toolbar toolbar4 = this.a;
                Context context = toolbar4.getContext();
                toolbar4.q = n6;
                TextView textView = toolbar4.g;
                if (textView != null) {
                    textView.setTextAppearance(context, n6);
                }
            }
            if ((n4 = w02.l(j.ActionBar_popupTheme, 0)) != 0) {
                this.a.setPopupTheme(n4);
            }
        } else {
            int n12;
            if (this.a.getNavigationIcon() != null) {
                n12 = 15;
                this.q = this.a.getNavigationIcon();
            } else {
                n12 = 11;
            }
            this.b = n12;
        }
        w02.b.recycle();
        if (n2 != this.p) {
            this.p = n2;
            if (TextUtils.isEmpty((CharSequence)this.a.getNavigationContentDescription())) {
                int n13 = this.p;
                String string = n13 == 0 ? null : this.d().getString(n13);
                this.k = string;
                this.w();
            }
        }
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener((View.OnClickListener)new x0(this));
    }

    @Override
    public void a(Menu menu, m.a a2) {
        if (this.n == null) {
            c c2;
            this.n = c2 = new c(this.a.getContext());
            if (c2 == null) {
                throw null;
            }
        }
        c c3 = this.n;
        c3.i = a2;
        Toolbar toolbar = this.a;
        g g2 = (g)menu;
        if (g2 == null && toolbar.e == null) {
            return;
        }
        toolbar.f();
        g g3 = toolbar.e.t;
        if (g3 == g2) {
            return;
        }
        if (g3 != null) {
            g3.u(toolbar.N);
            g3.u((m)toolbar.O);
        }
        if (toolbar.O == null) {
            toolbar.O = new Toolbar.d(toolbar);
        }
        c3.u = true;
        if (g2 != null) {
            g2.b(c3, toolbar.n);
            g2.b((m)toolbar.O, toolbar.n);
        } else {
            i i2;
            c3.d(toolbar.n, null);
            Toolbar.d d2 = toolbar.O;
            g g4 = d2.e;
            if (g4 != null && (i2 = d2.f) != null) {
                g4.d(i2);
            }
            d2.e = null;
            c3.j(true);
            toolbar.O.j(true);
        }
        toolbar.e.setPopupTheme(toolbar.o);
        toolbar.e.setPresenter(c3);
        toolbar.N = c3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean b() {
        ActionMenuView actionMenuView = this.a.e;
        if (actionMenuView == null) return false;
        c c2 = actionMenuView.x;
        if (c2 == null) return false;
        if (c2.z != null) return true;
        if (!c2.m()) return false;
        return true;
    }

    @Override
    public boolean c() {
        return this.a.o();
    }

    @Override
    public void collapseActionView() {
        Toolbar.d d2 = this.a.O;
        i i2 = d2 == null ? null : d2.f;
        if (i2 != null) {
            i2.collapseActionView();
        }
    }

    @Override
    public Context d() {
        return this.a.getContext();
    }

    @Override
    public boolean e() {
        c c2;
        boolean bl;
        ActionMenuView actionMenuView = this.a.e;
        return actionMenuView != null && (bl = (c2 = actionMenuView.x) != null && c2.k());
    }

    @Override
    public boolean f() {
        return this.a.u();
    }

    @Override
    public void g() {
        this.m = true;
    }

    @Override
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override
    public boolean h() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.e) != null && actionMenuView.w;
    }

    @Override
    public void i() {
        c c2;
        ActionMenuView actionMenuView = this.a.e;
        if (actionMenuView != null && (c2 = actionMenuView.x) != null) {
            c2.f();
        }
    }

    @Override
    public int j() {
        return this.b;
    }

    @Override
    public void k(int n2) {
        this.a.setVisibility(n2);
    }

    @Override
    public void l(int n2) {
        Drawable drawable = n2 != 0 ? f.b.l.a.a.b(this.d(), n2) : null;
        this.f = drawable;
        this.y();
    }

    @Override
    public void m(p0 p02) {
        Toolbar toolbar;
        ViewParent viewParent;
        View view = this.c;
        if (view != null && (viewParent = view.getParent()) == (toolbar = this.a)) {
            toolbar.removeView(this.c);
        }
        this.c = null;
    }

    @Override
    public ViewGroup n() {
        return this.a;
    }

    @Override
    public void o(boolean bl) {
    }

    @Override
    public int p() {
        return this.o;
    }

    @Override
    public q q(int n2, long l2) {
        q q2 = l.a((View)this.a);
        float f2 = n2 == 0 ? 1.0f : 0.0f;
        q2.a(f2);
        q2.c(l2);
        s s2 = new s(this, n2){
            public boolean a;
            public final /* synthetic */ int b;
            public final /* synthetic */ y0 c;
            {
                this.c = y02;
                this.b = n2;
                this.a = false;
            }

            public void a(View view) {
                if (!this.a) {
                    this.c.a.setVisibility(this.b);
                }
            }

            public void b(View view) {
                this.c.a.setVisibility(0);
            }

            public void c(View view) {
                this.a = true;
            }
        };
        View view = (View)q2.a.get();
        if (view != null) {
            q2.e(view, (r)s2);
        }
        return q2;
    }

    @Override
    public void r() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    @Override
    public boolean s() {
        Toolbar.d d2 = this.a.O;
        return d2 != null && d2.f != null;
    }

    @Override
    public void setIcon(int n2) {
        Drawable drawable = n2 != 0 ? f.b.l.a.a.b(this.d(), n2) : null;
        this.e = drawable;
        this.y();
    }

    @Override
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        this.y();
    }

    @Override
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            this.i = charSequence;
            if ((8 & this.b) != 0) {
                this.a.setTitle(charSequence);
            }
        }
    }

    @Override
    public void t() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    @Override
    public void u(boolean bl) {
        this.a.setCollapsible(bl);
    }

    @Override
    public void v(int n2) {
        int n3 = n2 ^ this.b;
        this.b = n2;
        if (n3 != 0) {
            View view;
            if ((n3 & 4) != 0) {
                if ((n2 & 4) != 0) {
                    this.w();
                }
                this.x();
            }
            if ((n3 & 3) != 0) {
                this.y();
            }
            if ((n3 & 8) != 0) {
                CharSequence charSequence;
                Toolbar toolbar;
                if ((n2 & 8) != 0) {
                    this.a.setTitle(this.i);
                    toolbar = this.a;
                    charSequence = this.j;
                } else {
                    Toolbar toolbar2 = this.a;
                    charSequence = null;
                    toolbar2.setTitle(null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((n3 & 16) != 0 && (view = this.d) != null) {
                if ((n2 & 16) != 0) {
                    this.a.addView(view);
                    return;
                }
                this.a.removeView(view);
            }
        }
    }

    public final void w() {
        if ((4 & this.b) != 0) {
            if (TextUtils.isEmpty((CharSequence)this.k)) {
                this.a.setNavigationContentDescription(this.p);
                return;
            }
            this.a.setNavigationContentDescription(this.k);
        }
    }

    public final void x() {
        Toolbar toolbar;
        Drawable drawable;
        if ((4 & this.b) != 0) {
            toolbar = this.a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void y() {
        Drawable drawable;
        int n2 = this.b;
        if ((n2 & 2) != 0) {
            if ((n2 & 1) == 0 || (drawable = this.f) == null) {
                drawable = this.e;
            }
        } else {
            drawable = null;
        }
        this.a.setLogo(drawable);
    }
}

