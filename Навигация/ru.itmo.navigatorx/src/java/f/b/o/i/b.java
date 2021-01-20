/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  androidx.appcompat.view.menu.ActionMenuItemView
 *  androidx.appcompat.view.menu.ActionMenuItemView$b
 *  androidx.appcompat.widget.ActionMenuView
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.b.o.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.m;
import f.b.o.i.n;
import f.b.o.i.r;
import f.b.p.c;
import java.util.ArrayList;

public abstract class b
implements m {
    public Context e;
    public Context f;
    public g g;
    public LayoutInflater h;
    public m.a i;
    public int j;
    public int k;
    public n l;

    public b(Context context, int n2, int n3) {
        this.e = context;
        this.h = LayoutInflater.from((Context)context);
        this.j = n2;
        this.k = n3;
    }

    public View b(i i2, View view, ViewGroup viewGroup) {
        n.a a2 = view instanceof n.a ? (n.a)view : (n.a)this.h.inflate(this.k, viewGroup, false);
        c c2 = (c)this;
        a2.e(i2, 0);
        ActionMenuView actionMenuView = (ActionMenuView)c2.l;
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView)a2;
        actionMenuItemView.setItemInvoker(actionMenuView);
        if (c2.A == null) {
            c2.A = new ActionMenuItemView.b(c2){
                public final /* synthetic */ c a;
                {
                    this.a = c2;
                }
            };
        }
        actionMenuItemView.setPopupCallback((ActionMenuItemView.b)c2.A);
        return (View)a2;
    }

    @Override
    public boolean e(g g2, i i2) {
        return false;
    }

    @Override
    public boolean g(g g2, i i2) {
        return false;
    }

    @Override
    public void h(m.a a2) {
        this.i = a2;
    }

    @Override
    public boolean i(r g2) {
        m.a a2 = this.i;
        if (a2 != null) {
            if (g2 == null) {
                g2 = this.g;
            }
            return a2.b(g2);
        }
        return false;
    }

    @Override
    public void j(boolean bl) {
        int n2;
        ViewGroup viewGroup = (ViewGroup)this.l;
        if (viewGroup == null) {
            return;
        }
        g g2 = this.g;
        if (g2 != null) {
            g2.i();
            ArrayList<i> arrayList = this.g.l();
            int n3 = arrayList.size();
            n2 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                i i3 = (i)arrayList.get(i2);
                if (!i3.g()) continue;
                View view = viewGroup.getChildAt(n2);
                i i4 = view instanceof n.a ? ((n.a)view).getItemData() : null;
                View view2 = this.b(i3, view, viewGroup);
                if (i3 != i4) {
                    view2.setPressed(false);
                    view2.jumpDrawablesToCurrentState();
                }
                if (view2 != view) {
                    ViewGroup viewGroup2 = (ViewGroup)view2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(view2);
                    }
                    ((ViewGroup)this.l).addView(view2, n2);
                }
                ++n2;
            }
        } else {
            n2 = 0;
        }
        while (n2 < viewGroup.getChildCount()) {
            boolean bl2;
            c c2 = (c)this;
            if (viewGroup.getChildAt(n2) == c2.m) {
                bl2 = false;
            } else {
                viewGroup.removeViewAt(n2);
                bl2 = true;
            }
            if (bl2) continue;
            ++n2;
        }
    }
}

