/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.view.Window
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.appcompat.widget.ActionBarContainer
 *  androidx.appcompat.widget.ActionBarContextView
 *  androidx.appcompat.widget.ActionBarOverlayLayout
 *  androidx.appcompat.widget.ActionBarOverlayLayout$d
 *  androidx.appcompat.widget.Toolbar
 *  f.h.l.l
 *  f.h.l.q
 *  f.h.l.r
 *  f.h.l.t
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 */
package f.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import f.b.f;
import f.b.j;
import f.b.k.a;
import f.b.k.s;
import f.b.o.a;
import f.b.o.g;
import f.b.o.i.g;
import f.b.p.c0;
import f.b.p.p0;
import f.h.l.l;
import f.h.l.q;
import f.h.l.r;
import f.h.l.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class s
extends f.b.k.a
implements ActionBarOverlayLayout.d {
    public static final Interpolator A = new AccelerateInterpolator();
    public static final Interpolator B = new DecelerateInterpolator();
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public c0 e;
    public ActionBarContextView f;
    public View g;
    public boolean h;
    public d i;
    public f.b.o.a j;
    public a.a k;
    public boolean l;
    public ArrayList<a.b> m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public g u;
    public boolean v;
    public boolean w;
    public final r x;
    public final r y;
    public final t z;

    public s(Activity activity, boolean bl) {
        new ArrayList();
        this.m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.t = true;
        this.x = new f.h.l.s(this){
            public final /* synthetic */ s a;
            {
                this.a = s2;
            }

            public void a(View view) {
                ActionBarOverlayLayout actionBarOverlayLayout;
                View view2;
                s s2 = this.a;
                if (s2.p && (view2 = s2.g) != null) {
                    view2.setTranslationY(0.0f);
                    this.a.d.setTranslationY(0.0f);
                }
                this.a.d.setVisibility(8);
                this.a.d.setTransitioning(false);
                s s3 = this.a;
                s3.u = null;
                a.a a2 = s3.k;
                if (a2 != null) {
                    a2.d(s3.j);
                    s3.j = null;
                    s3.k = null;
                }
                if ((actionBarOverlayLayout = this.a.c) != null) {
                    l.Q((View)actionBarOverlayLayout);
                }
            }
        };
        this.y = new f.h.l.s(this){
            public final /* synthetic */ s a;
            {
                this.a = s2;
            }

            public void a(View view) {
                s s2 = this.a;
                s2.u = null;
                s2.d.requestLayout();
            }
        };
        this.z = new t(){};
        View view = activity.getWindow().getDecorView();
        this.l(view);
        if (!bl) {
            this.g = view.findViewById(16908290);
        }
    }

    public s(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.t = true;
        this.x = new /* invalid duplicate definition of identical inner class */;
        this.y = new /* invalid duplicate definition of identical inner class */;
        this.z = new /* invalid duplicate definition of identical inner class */;
        this.l(dialog.getWindow().getDecorView());
    }

    @Override
    public boolean a() {
        c0 c02 = this.e;
        if (c02 != null && c02.s()) {
            this.e.collapseActionView();
            return true;
        }
        return false;
    }

    @Override
    public void b(boolean bl) {
        if (bl == this.l) {
            return;
        }
        this.l = bl;
        int n2 = this.m.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((a.b)this.m.get(i2)).a(bl);
        }
    }

    @Override
    public int c() {
        return this.e.j();
    }

    @Override
    public Context d() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(f.b.a.actionBarWidgetTheme, typedValue, true);
            int n2 = typedValue.resourceId;
            this.b = n2 != 0 ? new ContextThemeWrapper(this.a, n2) : this.a;
        }
        return this.b;
    }

    @Override
    public void e(Configuration configuration) {
        this.m(this.a.getResources().getBoolean(f.b.b.abc_action_bar_embed_tabs));
    }

    @Override
    public boolean f(int n2, KeyEvent keyEvent) {
        d d2 = this.i;
        if (d2 == null) {
            return false;
        }
        f.b.o.i.g g2 = d2.h;
        if (g2 != null) {
            int n3;
            int n4 = keyEvent != null ? keyEvent.getDeviceId() : -1;
            int n5 = KeyCharacterMap.load((int)n4).getKeyboardType();
            if (n5 == (n3 = 1)) {
                n3 = 0;
            }
            g2.setQwertyMode((boolean)n3);
            return g2.performShortcut(n2, keyEvent, 0);
        }
        return false;
    }

    @Override
    public void g(boolean bl) {
        if (!this.h) {
            int n2 = bl ? 4 : 0;
            int n3 = this.e.j();
            this.h = true;
            this.e.v(n2 & 4 | n3 & -5);
        }
    }

    @Override
    public void h(boolean bl) {
        g g2;
        this.v = bl;
        if (!bl && (g2 = this.u) != null) {
            g2.a();
        }
    }

    @Override
    public void i(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override
    public f.b.o.a j(a.a a2) {
        d d2;
        block4 : {
            d d3 = this.i;
            if (d3 != null) {
                d3.c();
            }
            this.c.setHideOnContentScrollEnabled(false);
            this.f.h();
            d2 = new d(this.f.getContext(), a2);
            d2.h.z();
            boolean bl = d2.i.c(d2, d2.h);
            if (!bl) break block4;
            this.i = d2;
            d2.i();
            this.f.f((f.b.o.a)d2);
            this.k(true);
            this.f.sendAccessibilityEvent(32);
            return d2;
        }
        return null;
        finally {
            d2.h.y();
        }
    }

    public void k(boolean bl) {
        if (bl) {
            if (!this.s) {
                this.s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                this.n(false);
            }
        } else if (this.s) {
            this.s = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            this.n(false);
        }
        if (l.A((View)this.d)) {
            q q2;
            q q3;
            if (bl) {
                q3 = this.e.q(4, 100L);
                q2 = this.f.e(0, 200L);
            } else {
                q2 = this.e.q(0, 200L);
                q3 = this.f.e(8, 100L);
            }
            g g2 = new g();
            g2.a.add((Object)q3);
            View view = (View)q3.a.get();
            long l2 = view != null ? view.animate().getDuration() : 0L;
            View view2 = (View)q2.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(l2);
            }
            g2.a.add((Object)q2);
            g2.b();
            return;
        }
        if (bl) {
            this.e.k(4);
            this.f.setVisibility(0);
            return;
        }
        this.e.k(0);
        this.f.setVisibility(8);
    }

    public final void l(View view) {
        View view2;
        block12 : {
            c0 c02;
            ActionBarContainer actionBarContainer;
            block11 : {
                block10 : {
                    ActionBarOverlayLayout actionBarOverlayLayout;
                    this.c = actionBarOverlayLayout = (ActionBarOverlayLayout)view.findViewById(f.decor_content_parent);
                    if (actionBarOverlayLayout != null) {
                        actionBarOverlayLayout.setActionBarVisibilityCallback((ActionBarOverlayLayout.d)this);
                    }
                    if (!((view2 = view.findViewById(f.action_bar)) instanceof c0)) break block10;
                    c02 = (c0)view2;
                    break block11;
                }
                if (!(view2 instanceof Toolbar)) break block12;
                c02 = ((Toolbar)view2).getWrapper();
            }
            this.e = c02;
            this.f = (ActionBarContextView)view.findViewById(f.action_context_bar);
            this.d = actionBarContainer = (ActionBarContainer)view.findViewById(f.action_bar_container);
            c0 c03 = this.e;
            if (c03 != null && this.f != null && actionBarContainer != null) {
                int n2;
                this.a = c03.d();
                boolean bl = (4 & this.e.j()) != 0;
                if (bl) {
                    this.h = true;
                }
                Context context = this.a;
                boolean bl2 = context.getApplicationInfo().targetSdkVersion < 14;
                boolean bl3 = bl2 || bl;
                this.e.o(bl3);
                this.m(context.getResources().getBoolean(f.b.b.abc_action_bar_embed_tabs));
                TypedArray typedArray = this.a.obtainStyledAttributes(null, j.ActionBar, f.b.a.actionBarStyle, 0);
                if (typedArray.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
                    ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                    if (actionBarOverlayLayout.l) {
                        this.w = true;
                        actionBarOverlayLayout.setHideOnContentScrollEnabled(true);
                    } else {
                        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                    }
                }
                if ((n2 = typedArray.getDimensionPixelSize(j.ActionBar_elevation, 0)) != 0) {
                    float f2 = n2;
                    l.X((View)this.d, (float)f2);
                }
                typedArray.recycle();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.class.getSimpleName());
            stringBuilder.append(" can only be used with a compatible window decor layout");
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = c.b.a.a.a.c("Can't make a decor toolbar out of ");
        String string = view2 != null ? view2.getClass().getSimpleName() : "null";
        stringBuilder.append(string);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void m(boolean bl) {
        this.n = bl;
        if (!bl) {
            this.e.m(null);
            this.d.setTabContainer(null);
        } else {
            this.d.setTabContainer(null);
            this.e.m(null);
        }
        int n2 = this.e.p();
        boolean bl2 = true;
        boolean bl3 = n2 == 2 ? bl2 : false;
        c0 c02 = this.e;
        boolean bl4 = !this.n && bl3 ? bl2 : false;
        c02.u(bl4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (this.n || !bl3) {
            bl2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(bl2);
    }

    public final void n(boolean bl) {
        boolean bl2 = this.r;
        boolean bl3 = this.s || !bl2;
        if (bl3) {
            if (!this.t) {
                this.t = true;
                g g2 = this.u;
                if (g2 != null) {
                    g2.a();
                }
                this.d.setVisibility(0);
                if (this.o == 0 && (this.v || bl)) {
                    View view;
                    this.d.setTranslationY(0.0f);
                    float f2 = -this.d.getHeight();
                    if (bl) {
                        int[] arrn = new int[]{0, 0};
                        this.d.getLocationInWindow(arrn);
                        f2 -= (float)arrn[1];
                    }
                    this.d.setTranslationY(f2);
                    g g3 = new g();
                    q q2 = l.a((View)this.d);
                    q2.g(0.0f);
                    q2.f(this.z);
                    if (!g3.e) {
                        g3.a.add((Object)q2);
                    }
                    if (this.p && (view = this.g) != null) {
                        view.setTranslationY(f2);
                        q q3 = l.a((View)this.g);
                        q3.g(0.0f);
                        if (!g3.e) {
                            g3.a.add((Object)q3);
                        }
                    }
                    Interpolator interpolator = B;
                    if (!g3.e) {
                        g3.c = interpolator;
                    }
                    if (!g3.e) {
                        g3.b = 250L;
                    }
                    r r2 = this.y;
                    if (!g3.e) {
                        g3.d = r2;
                    }
                    this.u = g3;
                    g3.b();
                } else {
                    View view;
                    this.d.setAlpha(1.0f);
                    this.d.setTranslationY(0.0f);
                    if (this.p && (view = this.g) != null) {
                        view.setTranslationY(0.0f);
                    }
                    this.y.a(null);
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    l.Q((View)actionBarOverlayLayout);
                    return;
                }
            }
        } else if (this.t) {
            this.t = false;
            g g4 = this.u;
            if (g4 != null) {
                g4.a();
            }
            if (this.o == 0 && (this.v || bl)) {
                View view;
                this.d.setAlpha(1.0f);
                this.d.setTransitioning(true);
                g g5 = new g();
                float f3 = -this.d.getHeight();
                if (bl) {
                    int[] arrn = new int[]{0, 0};
                    this.d.getLocationInWindow(arrn);
                    f3 -= (float)arrn[1];
                }
                q q4 = l.a((View)this.d);
                q4.g(f3);
                q4.f(this.z);
                if (!g5.e) {
                    g5.a.add((Object)q4);
                }
                if (this.p && (view = this.g) != null) {
                    q q5 = l.a((View)view);
                    q5.g(f3);
                    if (!g5.e) {
                        g5.a.add((Object)q5);
                    }
                }
                Interpolator interpolator = A;
                if (!g5.e) {
                    g5.c = interpolator;
                }
                if (!g5.e) {
                    g5.b = 250L;
                }
                r r3 = this.x;
                if (!g5.e) {
                    g5.d = r3;
                }
                this.u = g5;
                g5.b();
                return;
            }
            this.x.a(null);
        }
    }

    public class d
    extends f.b.o.a
    implements g.a {
        public final Context g;
        public final f.b.o.i.g h;
        public a.a i;
        public WeakReference<View> j;

        public d(Context context, a.a a2) {
            this.g = context;
            this.i = a2;
            f.b.o.i.g g2 = new f.b.o.i.g(context);
            g2.l = 1;
            this.h = g2;
            g2.e = this;
        }

        @Override
        public boolean a(f.b.o.i.g g2, MenuItem menuItem) {
            a.a a2 = this.i;
            if (a2 != null) {
                return a2.b(this, menuItem);
            }
            return false;
        }

        @Override
        public void b(f.b.o.i.g g2) {
            if (this.i == null) {
                return;
            }
            this.i();
            f.b.p.c c2 = s.this.f.h;
            if (c2 != null) {
                c2.n();
            }
        }

        @Override
        public void c() {
            s s2 = s.this;
            if (s2.i != this) {
                return;
            }
            boolean bl = s2.q;
            boolean bl2 = s2.r;
            boolean bl3 = true;
            if (bl || bl2) {
                bl3 = false;
            }
            if (!bl3) {
                s s3 = s.this;
                s3.j = this;
                s3.k = this.i;
            } else {
                this.i.d(this);
            }
            this.i = null;
            s.this.k(false);
            ActionBarContextView actionBarContextView = s.this.f;
            if (actionBarContextView.o == null) {
                actionBarContextView.h();
            }
            s.this.e.n().sendAccessibilityEvent(32);
            s s4 = s.this;
            s4.c.setHideOnContentScrollEnabled(s4.w);
            s.this.i = null;
        }

        @Override
        public View d() {
            WeakReference<View> weakReference = this.j;
            if (weakReference != null) {
                return (View)weakReference.get();
            }
            return null;
        }

        @Override
        public Menu e() {
            return this.h;
        }

        @Override
        public MenuInflater f() {
            return new f.b.o.f(this.g);
        }

        @Override
        public CharSequence g() {
            return s.this.f.getSubtitle();
        }

        @Override
        public CharSequence h() {
            return s.this.f.getTitle();
        }

        @Override
        public void i() {
            if (s.this.i != this) {
                return;
            }
            this.h.z();
            try {
                this.i.a(this, this.h);
                return;
            }
            finally {
                this.h.y();
            }
        }

        @Override
        public boolean j() {
            return s.this.f.v;
        }

        @Override
        public void k(View view) {
            s.this.f.setCustomView(view);
            this.j = new WeakReference((Object)view);
        }

        @Override
        public void l(int n2) {
            String string = s.this.a.getResources().getString(n2);
            s.this.f.setSubtitle((CharSequence)string);
        }

        @Override
        public void m(CharSequence charSequence) {
            s.this.f.setSubtitle(charSequence);
        }

        @Override
        public void n(int n2) {
            String string = s.this.a.getResources().getString(n2);
            s.this.f.setTitle((CharSequence)string);
        }

        @Override
        public void o(CharSequence charSequence) {
            s.this.f.setTitle(charSequence);
        }

        @Override
        public void p(boolean bl) {
            this.f = bl;
            s.this.f.setTitleOptional(bl);
        }
    }

}

