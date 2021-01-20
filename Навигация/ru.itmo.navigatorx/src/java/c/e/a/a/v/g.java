/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.GridView
 *  android.widget.ListAdapter
 *  android.widget.Scroller
 *  androidx.fragment.app.Fragment
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$k
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$p
 *  com.google.android.material.button.MaterialButton
 *  f.h.l.l
 *  f.p.d.r
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.List
 */
package c.e.a.a.v;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.v.c0;
import c.e.a.a.v.g;
import c.e.a.a.v.h;
import c.e.a.a.v.i;
import c.e.a.a.v.j;
import c.e.a.a.v.k;
import c.e.a.a.v.l;
import c.e.a.a.v.m;
import c.e.a.a.v.o;
import c.e.a.a.v.s;
import c.e.a.a.v.v;
import c.e.a.a.v.x;
import c.e.a.a.v.y;
import com.google.android.material.button.MaterialButton;
import f.p.d.b0;
import f.p.d.r;
import java.util.List;

public final class g<S>
extends x<S> {
    public static final Object k0 = "MONTHS_VIEW_GROUP_TAG";
    public static final Object l0 = "NAVIGATION_PREV_TAG";
    public static final Object m0 = "NAVIGATION_NEXT_TAG";
    public static final Object n0 = "SELECTOR_TOGGLE_TAG";
    public int a0;
    public c.e.a.a.v.d<S> b0;
    public c.e.a.a.v.a c0;
    public s d0;
    public e e0;
    public c.e.a.a.v.c f0;
    public RecyclerView g0;
    public RecyclerView h0;
    public View i0;
    public View j0;

    public static int w0(Context context) {
        return context.getResources().getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_day_height);
    }

    public void A0(e e2) {
        this.e0 = e2;
        if (e2 == e.f) {
            this.g0.getLayoutManager().K0(((c0)this.g0.getAdapter()).f(this.d0.h));
            this.i0.setVisibility(0);
            this.j0.setVisibility(8);
            return;
        }
        if (e2 == e.e) {
            this.i0.setVisibility(8);
            this.j0.setVisibility(0);
            this.z0(this.d0);
        }
    }

    public void M(Bundle bundle) {
        Fragment.super.M(bundle);
        if (bundle == null) {
            bundle = this.j;
        }
        this.a0 = bundle.getInt("THEME_RES_ID_KEY");
        this.b0 = (c.e.a.a.v.d)bundle.getParcelable("GRID_SELECTOR_KEY");
        this.c0 = (c.e.a.a.v.a)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.d0 = (s)bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int n2;
        RecyclerView recyclerView;
        int n3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.o(), this.a0);
        this.f0 = new c.e.a.a.v.c((Context)contextThemeWrapper);
        LayoutInflater layoutInflater2 = layoutInflater.cloneInContext((Context)contextThemeWrapper);
        s s2 = this.c0.e;
        if (o.D0((Context)contextThemeWrapper)) {
            n2 = c.e.a.a.h.mtrl_calendar_vertical;
            n3 = 1;
        } else {
            n2 = c.e.a.a.h.mtrl_calendar_horizontal;
            n3 = 0;
        }
        View view = layoutInflater2.inflate(n2, viewGroup, false);
        GridView gridView = (GridView)view.findViewById(c.e.a.a.f.mtrl_calendar_days_of_week);
        f.h.l.l.S((View)gridView, (f.h.l.a)new f.h.l.a(this){

            public void d(View view, f.h.l.v.b b2) {
                this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
                b2.i(null);
            }
        });
        gridView.setAdapter((ListAdapter)new c.e.a.a.v.f());
        gridView.setNumColumns(s2.i);
        gridView.setEnabled(false);
        this.h0 = (RecyclerView)view.findViewById(c.e.a.a.f.mtrl_calendar_months);
        y y2 = new y(this, this.o(), n3, false, n3){
            public final /* synthetic */ int H;
            public final /* synthetic */ g I;
            {
                this.I = g2;
                this.H = n3;
                super(context, n2, bl);
            }

            public void X0(androidx.recyclerview.widget.RecyclerView$w w2, int[] arrn) {
                if (this.H == 0) {
                    arrn[0] = this.I.h0.getWidth();
                    arrn[1] = this.I.h0.getWidth();
                    return;
                }
                arrn[0] = this.I.h0.getHeight();
                arrn[1] = this.I.h0.getHeight();
            }
        };
        this.h0.setLayoutManager((RecyclerView.l)y2);
        this.h0.setTag((Object)"MONTHS_VIEW_GROUP_TAG");
        v v2 = new v((Context)contextThemeWrapper, this.b0, this.c0, new f(this){
            public final /* synthetic */ g a;
            {
                this.a = g2;
            }
        });
        this.h0.setAdapter((RecyclerView.d)v2);
        int n4 = contextThemeWrapper.getResources().getInteger(c.e.a.a.g.mtrl_calendar_year_selector_span);
        this.g0 = recyclerView = (RecyclerView)view.findViewById(c.e.a.a.f.mtrl_calendar_year_selector_frame);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.g0.setLayoutManager((RecyclerView.l)new GridLayoutManager((Context)contextThemeWrapper, n4, 1, false));
            this.g0.setAdapter((RecyclerView.d)new c0(this));
            this.g0.g((RecyclerView.k)new h(this));
        }
        if (view.findViewById(c.e.a.a.f.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton)view.findViewById(c.e.a.a.f.month_navigation_fragment_toggle);
            materialButton.setTag((Object)"SELECTOR_TOGGLE_TAG");
            f.h.l.l.S((View)materialButton, (f.h.l.a)new i(this));
            MaterialButton materialButton2 = (MaterialButton)view.findViewById(c.e.a.a.f.month_navigation_previous);
            materialButton2.setTag((Object)"NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton)view.findViewById(c.e.a.a.f.month_navigation_next);
            materialButton3.setTag((Object)"NAVIGATION_NEXT_TAG");
            this.i0 = view.findViewById(c.e.a.a.f.mtrl_calendar_year_selector_frame);
            this.j0 = view.findViewById(c.e.a.a.f.mtrl_calendar_day_selector_frame);
            this.A0(e.e);
            materialButton.setText((CharSequence)this.d0.f);
            this.h0.h((RecyclerView.p)new j(this, v2, materialButton));
            materialButton.setOnClickListener((View.OnClickListener)new k(this));
            materialButton3.setOnClickListener((View.OnClickListener)new l(this, v2));
            materialButton2.setOnClickListener((View.OnClickListener)new m(this, v2));
        }
        if (!o.D0((Context)contextThemeWrapper)) {
            r r2 = new r();
            RecyclerView recyclerView2 = r2.a;
            RecyclerView recyclerView3 = this.h0;
            if (recyclerView2 != recyclerView3) {
                if (recyclerView2 != null) {
                    RecyclerView.p p2 = r2.c;
                    List list = recyclerView2.l0;
                    if (list != null) {
                        list.remove((Object)p2);
                    }
                    r2.a.setOnFlingListener(null);
                }
                r2.a = recyclerView3;
                if (recyclerView3 != null) {
                    if (recyclerView3.getOnFlingListener() == null) {
                        r2.a.h(r2.c);
                        r2.a.setOnFlingListener((RecyclerView.n)r2);
                        r2.b = new Scroller(r2.a.getContext(), (Interpolator)new DecelerateInterpolator());
                        r2.c();
                    } else {
                        throw new IllegalStateException("An instance of OnFlingListener already set.");
                    }
                }
            }
        }
        this.h0.j0(v2.g(this.d0));
        return view;
    }

    public void b0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.a0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.b0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", (Parcelable)this.c0);
        bundle.putParcelable("CURRENT_MONTH_KEY", (Parcelable)this.d0);
    }

    public LinearLayoutManager x0() {
        return (LinearLayoutManager)this.h0.getLayoutManager();
    }

    public final void y0(int n2) {
        this.h0.post(new Runnable(this, n2){
            public final /* synthetic */ int e;
            public final /* synthetic */ g f;
            {
                this.f = g2;
                this.e = n2;
            }

            public void run() {
                RecyclerView recyclerView = this.f.h0;
                int n2 = this.e;
                if (recyclerView.A) {
                    return;
                }
                RecyclerView.l l2 = recyclerView.p;
                if (l2 == null) {
                    android.util.Log.e((String)"RecyclerView", (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    return;
                }
                l2.U0(recyclerView, recyclerView.j0, n2);
            }
        });
    }

    public void z0(s s2) {
        int n2;
        block6 : {
            int n3;
            RecyclerView recyclerView;
            block5 : {
                boolean bl;
                block4 : {
                    v v2 = (v)this.h0.getAdapter();
                    n2 = v2.c.e.k(s2);
                    int n4 = n2 - v2.g(this.d0);
                    int n5 = Math.abs((int)n4);
                    boolean bl2 = true;
                    bl = n5 > 3 ? bl2 : false;
                    if (n4 <= 0) {
                        bl2 = false;
                    }
                    this.d0 = s2;
                    if (!bl || !bl2) break block4;
                    recyclerView = this.h0;
                    n3 = n2 - 3;
                    break block5;
                }
                if (!bl) break block6;
                recyclerView = this.h0;
                n3 = n2 + 3;
            }
            recyclerView.j0(n3);
        }
        this.y0(n2);
    }

}

