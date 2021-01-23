/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.Gravity
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  f.b.o.i.g
 *  f.b.o.i.k
 *  f.b.p.j0
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import f.b.d;
import f.b.g;
import f.b.o.i.f;
import f.b.o.i.k;
import f.b.o.i.l;
import f.b.o.i.m;
import f.b.o.i.q;
import f.b.o.i.r;
import f.b.p.e0;
import f.b.p.j0;
import f.b.p.l0;

public final class q
extends k
implements PopupWindow.OnDismissListener,
AdapterView.OnItemClickListener,
m,
View.OnKeyListener {
    public static final int z = g.abc_popup_menu_item_layout;
    public final Context f;
    public final f.b.o.i.g g;
    public final f h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final l0 m;
    public final ViewTreeObserver.OnGlobalLayoutListener n = new ViewTreeObserver.OnGlobalLayoutListener(this){
        public final /* synthetic */ q e;
        {
            this.e = q2;
        }

        public void onGlobalLayout() {
            if (this.e.b()) {
                q q2 = this.e;
                if (!q2.m.E) {
                    View view = q2.r;
                    if (view != null && view.isShown()) {
                        this.e.m.f();
                        return;
                    }
                    this.e.dismiss();
                }
            }
        }
    };
    public final View.OnAttachStateChangeListener o = new View.OnAttachStateChangeListener(this){
        public final /* synthetic */ q e;
        {
            this.e = q2;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = this.e.t;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    this.e.t = view.getViewTreeObserver();
                }
                q q2 = this.e;
                q2.t.removeGlobalOnLayoutListener(q2.n);
            }
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
    };
    public PopupWindow.OnDismissListener p;
    public View q;
    public View r;
    public m.a s;
    public ViewTreeObserver t;
    public boolean u;
    public boolean v;
    public int w;
    public int x = 0;
    public boolean y;

    public q(Context context, f.b.o.i.g g2, View view, int n2, int n3, boolean bl) {
        this.f = context;
        this.g = g2;
        this.i = bl;
        this.h = new f(g2, LayoutInflater.from((Context)context), this.i, z);
        this.k = n2;
        this.l = n3;
        Resources resources = context.getResources();
        this.j = Math.max((int)(resources.getDisplayMetrics().widthPixels / 2), (int)resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.q = view;
        this.m = new l0(this.f, null, this.k, this.l);
        g2.b((m)this, context);
    }

    @Override
    public void a(f.b.o.i.g g2, boolean bl) {
        if (g2 != this.g) {
            return;
        }
        this.dismiss();
        m.a a2 = this.s;
        if (a2 != null) {
            a2.a(g2, bl);
        }
    }

    public boolean b() {
        return !this.u && this.m.b();
    }

    @Override
    public boolean c() {
        return false;
    }

    public void dismiss() {
        if (this.b()) {
            this.m.dismiss();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void f() {
        boolean bl = this.b();
        boolean bl2 = true;
        if (!bl) {
            View view;
            if (!this.u && (view = this.q) != null) {
                ViewTreeObserver viewTreeObserver;
                this.r = view;
                this.m.F.setOnDismissListener((PopupWindow.OnDismissListener)this);
                l0 l02 = this.m;
                l02.w = this;
                l02.s(bl2);
                View view2 = this.r;
                boolean bl3 = this.t == null ? bl2 : false;
                this.t = viewTreeObserver = view2.getViewTreeObserver();
                if (bl3) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.n);
                }
                view2.addOnAttachStateChangeListener(this.o);
                l0 l03 = this.m;
                l03.v = view2;
                l03.p = this.x;
                if (!this.v) {
                    this.w = k.n((ListAdapter)this.h, null, (Context)this.f, (int)this.j);
                    this.v = bl2;
                }
                this.m.r(this.w);
                this.m.F.setInputMethodMode(2);
                l0 l04 = this.m;
                Rect rect = this.e;
                if (l04 == null) throw null;
                Rect rect2 = rect != null ? new Rect(rect) : null;
                l04.D = rect2;
                this.m.f();
                e0 e02 = this.m.g;
                e02.setOnKeyListener((View.OnKeyListener)this);
                if (this.y && this.g.m != null) {
                    FrameLayout frameLayout = (FrameLayout)LayoutInflater.from((Context)this.f).inflate(g.abc_popup_menu_header_item_layout, (ViewGroup)e02, false);
                    TextView textView = (TextView)frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.g.m);
                    }
                    frameLayout.setEnabled(false);
                    e02.addHeaderView((View)frameLayout, null, false);
                }
                this.m.o((ListAdapter)this.h);
                this.m.f();
            } else {
                bl2 = false;
            }
        }
        if (!bl2) throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override
    public void h(m.a a2) {
        this.s = a2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean i(r r2) {
        boolean bl;
        if (!r2.hasVisibleItems()) return false;
        l l2 = new l(this.f, r2, this.r, this.i, this.k, this.l);
        l2.d(this.s);
        l2.h = bl = k.v((f.b.o.i.g)r2);
        k k2 = l2.j;
        if (k2 != null) {
            k2.p(bl);
        }
        l2.k = this.p;
        this.p = null;
        this.g.c(false);
        l0 l02 = this.m;
        int n2 = l02.j;
        int n3 = !l02.m ? 0 : l02.k;
        if ((7 & Gravity.getAbsoluteGravity((int)this.x, (int)f.h.l.l.n((View)this.q))) == 5) {
            n2 += this.q.getWidth();
        }
        if (!l2.b()) {
            if (l2.f == null) {
                return false;
            }
            l2.e(n2, n3, true, true);
        }
        boolean bl2 = true;
        if (!bl2) return false;
        m.a a2 = this.s;
        if (a2 == null) return true;
        a2.b(r2);
        return true;
    }

    @Override
    public void j(boolean bl) {
        this.v = false;
        f f2 = this.h;
        if (f2 != null) {
            f2.notifyDataSetChanged();
        }
    }

    public ListView k() {
        return this.m.g;
    }

    public void l(f.b.o.i.g g2) {
    }

    public void o(View view) {
        this.q = view;
    }

    public void onDismiss() {
        this.u = true;
        this.g.c(true);
        ViewTreeObserver viewTreeObserver = this.t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.t = this.r.getViewTreeObserver();
            }
            this.t.removeGlobalOnLayoutListener(this.n);
            this.t = null;
        }
        this.r.removeOnAttachStateChangeListener(this.o);
        PopupWindow.OnDismissListener onDismissListener = this.p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int n2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n2 == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }

    public void p(boolean bl) {
        this.h.g = bl;
    }

    public void q(int n2) {
        this.x = n2;
    }

    public void r(int n2) {
        this.m.j = n2;
    }

    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.p = onDismissListener;
    }

    public void t(boolean bl) {
        this.y = bl;
    }

    public void u(int n2) {
        l0 l02 = this.m;
        l02.k = n2;
        l02.m = true;
    }
}

