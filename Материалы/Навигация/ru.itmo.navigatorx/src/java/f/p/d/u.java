/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$m
 *  f.p.d.w
 */
package f.p.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import f.p.d.w;

public final class u
extends w {
    public u(RecyclerView.l l2) {
        super(l2, null);
    }

    public int b(View view) {
        RecyclerView.m m2 = (RecyclerView.m)view.getLayoutParams();
        return this.a.F(view) + m2.rightMargin;
    }

    public int c(View view) {
        RecyclerView.m m2 = (RecyclerView.m)view.getLayoutParams();
        return this.a.E(view) + m2.leftMargin + m2.rightMargin;
    }

    public int d(View view) {
        RecyclerView.m m2 = (RecyclerView.m)view.getLayoutParams();
        return this.a.D(view) + m2.topMargin + m2.bottomMargin;
    }

    public int e(View view) {
        RecyclerView.m m2 = (RecyclerView.m)view.getLayoutParams();
        return this.a.C(view) - m2.leftMargin;
    }

    public int f() {
        return this.a.q;
    }

    public int g() {
        RecyclerView.l l2 = this.a;
        return l2.q - l2.N();
    }

    public int h() {
        return this.a.N();
    }

    public int i() {
        return this.a.o;
    }

    public int j() {
        return this.a.p;
    }

    public int k() {
        return this.a.M();
    }

    public int l() {
        RecyclerView.l l2 = this.a;
        return l2.q - l2.M() - this.a.N();
    }

    public int n(View view) {
        this.a.T(view, true, this.c);
        return this.c.right;
    }

    public int o(View view) {
        this.a.T(view, true, this.c);
        return this.c.left;
    }

    public void p(int n2) {
        this.a.Z(n2);
    }
}

