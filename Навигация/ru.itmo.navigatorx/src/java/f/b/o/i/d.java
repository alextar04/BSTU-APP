/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.transition.Transition
 *  android.util.DisplayMetrics
 *  android.view.Gravity
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  f.b.o.i.d$c
 *  f.b.o.i.g
 *  f.b.o.i.k
 *  f.b.p.j0
 *  f.h.l.l
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package f.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import f.b.g;
import f.b.o.i.d;
import f.b.o.i.f;
import f.b.o.i.k;
import f.b.o.i.m;
import f.b.o.i.r;
import f.b.p.e0;
import f.b.p.j0;
import f.b.p.k0;
import f.b.p.l0;
import f.h.l.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
extends k
implements m,
View.OnKeyListener,
PopupWindow.OnDismissListener {
    public static final int F = g.abc_cascading_menu_item_layout;
    public boolean A;
    public m.a B;
    public ViewTreeObserver C;
    public PopupWindow.OnDismissListener D;
    public boolean E;
    public final Context f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;
    public final Handler k;
    public final List<f.b.o.i.g> l = new ArrayList();
    public final List<d> m = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener n = new ViewTreeObserver.OnGlobalLayoutListener(this){
        public final /* synthetic */ d e;
        {
            this.e = d2;
        }

        public void onGlobalLayout() {
            if (this.e.b() && this.e.m.size() > 0 && !(this.e.m.get((int)0)).a.E) {
                View view = this.e.t;
                if (view != null && view.isShown()) {
                    Iterator iterator = this.e.m.iterator();
                    while (iterator.hasNext()) {
                        (iterator.next()).a.f();
                    }
                } else {
                    this.e.dismiss();
                }
            }
        }
    };
    public final View.OnAttachStateChangeListener o = new View.OnAttachStateChangeListener(this){
        public final /* synthetic */ d e;
        {
            this.e = d2;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = this.e.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    this.e.C = view.getViewTreeObserver();
                }
                d d2 = this.e;
                d2.C.removeGlobalOnLayoutListener(d2.n);
            }
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
    };
    public final k0 p = new c(this);
    public int q = 0;
    public int r = 0;
    public View s;
    public View t;
    public int u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public d(Context context, View view, int n2, int n3, boolean bl) {
        this.f = context;
        this.s = view;
        this.h = n2;
        this.i = n3;
        this.j = bl;
        this.z = false;
        int n4 = l.n((View)view) == 1 ? 0 : 1;
        this.u = n4;
        Resources resources = context.getResources();
        this.g = Math.max((int)(resources.getDisplayMetrics().widthPixels / 2), (int)resources.getDimensionPixelSize(f.b.d.abc_config_prefDialogWidth));
        this.k = new Handler();
    }

    @Override
    public void a(f.b.o.i.g g2, boolean bl) {
        int n2;
        block10 : {
            int n3 = this.m.size();
            for (n2 = 0; n2 < n3; ++n2) {
                if (g2 != (this.m.get((int)n2)).b) {
                    continue;
                }
                break block10;
            }
            n2 = -1;
        }
        if (n2 < 0) {
            return;
        }
        int n4 = n2 + 1;
        if (n4 < this.m.size()) {
            (this.m.get((int)n4)).b.c(false);
        }
        d d2 = this.m.remove(n2);
        d2.b.u((m)this);
        if (this.E) {
            d2.a.F.setExitTransition(null);
            d2.a.F.setAnimationStyle(0);
        }
        d2.a.dismiss();
        int n5 = this.m.size();
        int n6 = n5 > 0 ? (this.m.get((int)(n5 - 1))).c : (l.n((View)this.s) == 1 ? 0 : 1);
        this.u = n6;
        if (n5 == 0) {
            ViewTreeObserver viewTreeObserver;
            this.dismiss();
            m.a a2 = this.B;
            if (a2 != null) {
                a2.a(g2, true);
            }
            if ((viewTreeObserver = this.C) != null) {
                if (viewTreeObserver.isAlive()) {
                    this.C.removeGlobalOnLayoutListener(this.n);
                }
                this.C = null;
            }
            this.t.removeOnAttachStateChangeListener(this.o);
            this.D.onDismiss();
            return;
        }
        if (bl) {
            (this.m.get((int)0)).b.c(false);
        }
    }

    public boolean b() {
        int n2 = this.m.size();
        boolean bl = false;
        if (n2 > 0) {
            boolean bl2 = (this.m.get((int)0)).a.b();
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public boolean c() {
        return false;
    }

    public void dismiss() {
        int n2 = this.m.size();
        if (n2 > 0) {
            d[] arrd = (d[])this.m.toArray((Object[])new d[n2]);
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                d d2 = arrd[i2];
                if (!d2.a.b()) continue;
                d2.a.dismiss();
            }
        }
    }

    public void f() {
        View view;
        if (this.b()) {
            return;
        }
        Iterator iterator = this.l.iterator();
        while (iterator.hasNext()) {
            this.w((f.b.o.i.g)iterator.next());
        }
        this.l.clear();
        this.t = view = this.s;
        if (view != null) {
            ViewTreeObserver viewTreeObserver;
            boolean bl = this.C == null;
            this.C = viewTreeObserver = this.t.getViewTreeObserver();
            if (bl) {
                viewTreeObserver.addOnGlobalLayoutListener(this.n);
            }
            this.t.addOnAttachStateChangeListener(this.o);
        }
    }

    @Override
    public void h(m.a a2) {
        this.B = a2;
    }

    @Override
    public boolean i(r r2) {
        for (d d2 : this.m) {
            if (r2 != d2.b) continue;
            d2.a.g.requestFocus();
            return true;
        }
        if (r2.hasVisibleItems()) {
            r2.b((m)this, this.f);
            if (this.b()) {
                this.w(r2);
            } else {
                this.l.add((Object)r2);
            }
            m.a a2 = this.B;
            if (a2 != null) {
                a2.b(r2);
            }
            return true;
        }
        return false;
    }

    @Override
    public void j(boolean bl) {
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            ListAdapter listAdapter = (iterator.next()).a.g.getAdapter();
            if (listAdapter instanceof HeaderViewListAdapter) {
                listAdapter = ((HeaderViewListAdapter)listAdapter).getWrappedAdapter();
            }
            ((f)listAdapter).notifyDataSetChanged();
        }
    }

    public ListView k() {
        if (this.m.isEmpty()) {
            return null;
        }
        List<d> list = this.m;
        return (list.get((int)(-1 + list.size()))).a.g;
    }

    public void l(f.b.o.i.g g2) {
        g2.b((m)this, this.f);
        if (this.b()) {
            this.w(g2);
            return;
        }
        this.l.add((Object)g2);
    }

    public boolean m() {
        return false;
    }

    public void o(View view) {
        if (this.s != view) {
            this.s = view;
            this.r = Gravity.getAbsoluteGravity((int)this.q, (int)l.n((View)view));
        }
    }

    public void onDismiss() {
        d d2;
        block3 : {
            int n2 = this.m.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                d2 = this.m.get(i2);
                if (d2.a.b()) {
                    continue;
                }
                break block3;
            }
            d2 = null;
        }
        if (d2 != null) {
            d2.b.c(false);
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
        this.z = bl;
    }

    public void q(int n2) {
        if (this.q != n2) {
            this.q = n2;
            this.r = Gravity.getAbsoluteGravity((int)n2, (int)l.n((View)this.s));
        }
    }

    public void r(int n2) {
        this.v = true;
        this.x = n2;
    }

    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.D = onDismissListener;
    }

    public void t(boolean bl) {
        this.A = bl;
    }

    public void u(int n2) {
        this.w = true;
        this.y = n2;
    }

    /*
     * Exception decompiling
     */
    public final void w(f.b.o.i.g var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl238 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

}

