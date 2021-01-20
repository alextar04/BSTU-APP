/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  java.lang.Object
 */
package f.b.o.i;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import f.b.o.i.f;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.m;
import f.b.o.i.p;

public abstract class k
implements p,
m,
AdapterView.OnItemClickListener {
    public Rect e;

    public static int n(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n5 = listAdapter.getCount();
        int n6 = 0;
        int n7 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n8 = listAdapter.getItemViewType(i2);
            if (n8 != n7) {
                view = null;
                n7 = n8;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, (ViewGroup)frameLayout);
            view.measure(n3, n4);
            int n9 = view.getMeasuredWidth();
            if (n9 >= n2) {
                return n2;
            }
            if (n9 <= n6) continue;
            n6 = n9;
        }
        return n6;
    }

    public static boolean v(g g2) {
        int n2 = g2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem = g2.getItem(i2);
            if (!menuItem.isVisible() || menuItem.getIcon() == null) continue;
            return true;
        }
        return false;
    }

    @Override
    public void d(Context context, g g2) {
    }

    @Override
    public boolean e(g g2, i i2) {
        return false;
    }

    @Override
    public boolean g(g g2, i i2) {
        return false;
    }

    public abstract void l(g var1);

    public boolean m() {
        return true;
    }

    public abstract void o(View var1);

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        ListAdapter listAdapter = (ListAdapter)adapterView.getAdapter();
        f f2 = listAdapter instanceof HeaderViewListAdapter ? (f)((HeaderViewListAdapter)listAdapter).getWrappedAdapter() : (f)listAdapter;
        g g2 = f2.e;
        MenuItem menuItem = (MenuItem)listAdapter.getItem(n2);
        int n3 = this.m() ? 0 : 4;
        g2.s(menuItem, this, n3);
    }

    public abstract void p(boolean var1);

    public abstract void q(int var1);

    public abstract void r(int var1);

    public abstract void s(PopupWindow.OnDismissListener var1);

    public abstract void t(boolean var1);

    public abstract void u(int var1);
}

