/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$r
 *  androidx.recyclerview.widget.RecyclerView$w
 *  f.h.l.v.b
 *  f.h.l.v.b$b
 *  f.h.l.v.c
 *  java.lang.Object
 *  java.util.Map
 *  java.util.WeakHashMap
 */
package f.p.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import f.h.l.v.b;
import f.h.l.v.c;
import java.util.Map;
import java.util.WeakHashMap;

public class z
extends f.h.l.a {
    public final RecyclerView d;
    public final a e;

    public z(RecyclerView recyclerView) {
        this.d = recyclerView;
        a a2 = this.e;
        if (a2 == null) {
            a2 = new a(this);
        }
        this.e = a2;
    }

    @Override
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView;
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (view instanceof RecyclerView && !this.j() && (recyclerView = (RecyclerView)view).getLayoutManager() != null) {
            recyclerView.getLayoutManager().h0(accessibilityEvent);
        }
    }

    @Override
    public void d(View view, b b2) {
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        if (!this.j() && this.d.getLayoutManager() != null) {
            RecyclerView.l l2 = this.d.getLayoutManager();
            RecyclerView recyclerView = l2.b;
            RecyclerView.r r2 = recyclerView.f;
            RecyclerView.w w2 = recyclerView.j0;
            if (recyclerView.canScrollVertically(-1) || l2.b.canScrollHorizontally(-1)) {
                b2.a.addAction(8192);
                b2.a.setScrollable(true);
            }
            if (l2.b.canScrollVertically(1) || l2.b.canScrollHorizontally(1)) {
                b2.a.addAction(4096);
                b2.a.setScrollable(true);
            }
            b2.i((Object)new b.b((Object)AccessibilityNodeInfo.CollectionInfo.obtain((int)l2.R(r2, w2), (int)l2.A(r2, w2), (boolean)l2.V(), (int)l2.S())));
        }
    }

    @Override
    public boolean g(View view, int n2, Bundle bundle) {
        if (super.g(view, n2, bundle)) {
            return true;
        }
        if (!this.j() && this.d.getLayoutManager() != null) {
            RecyclerView.l l2 = this.d.getLayoutManager();
            return l2.A0(n2);
        }
        return false;
    }

    public boolean j() {
        return this.d.N();
    }

    public static class a
    extends f.h.l.a {
        public final z d;
        public Map<View, f.h.l.a> e = new WeakHashMap();

        public a(z z2) {
            this.d = z2;
        }

        @Override
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                return a2.a(view, accessibilityEvent);
            }
            return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override
        public c b(View view) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                return a2.b(view);
            }
            return super.b(view);
        }

        @Override
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                a2.c(view, accessibilityEvent);
                return;
            }
            this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override
        public void d(View view, b b2) {
            if (!this.d.j() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().j0(view, b2);
                f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
                if (a2 != null) {
                    a2.d(view, b2);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        }

        @Override
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                a2.e(view, accessibilityEvent);
                return;
            }
            this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)viewGroup);
            if (a2 != null) {
                return a2.f(viewGroup, view, accessibilityEvent);
            }
            return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override
        public boolean g(View view, int n2, Bundle bundle) {
            if (!this.d.j() && this.d.d.getLayoutManager() != null) {
                f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
                if (a2 != null ? a2.g(view, n2, bundle) : super.g(view, n2, bundle)) {
                    return true;
                }
                RecyclerView.l l2 = this.d.d.getLayoutManager();
                return l2.B0();
            }
            return super.g(view, n2, bundle);
        }

        @Override
        public void h(View view, int n2) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                a2.h(view, n2);
                return;
            }
            this.a.sendAccessibilityEvent(view, n2);
        }

        @Override
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            f.h.l.a a2 = (f.h.l.a)this.e.get((Object)view);
            if (a2 != null) {
                a2.i(view, accessibilityEvent);
                return;
            }
            this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

}

