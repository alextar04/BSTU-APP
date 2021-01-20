/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.Drawable
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.ListAdapter
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$b
 *  androidx.appcompat.view.menu.ExpandedMenuView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.b.o.i;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import f.b.g;
import f.b.k.d;
import f.b.o.i.h;
import f.b.o.i.i;
import f.b.o.i.m;
import f.b.o.i.n;
import f.b.o.i.r;
import java.util.ArrayList;

public class e
implements m,
AdapterView.OnItemClickListener {
    public Context e;
    public LayoutInflater f;
    public f.b.o.i.g g;
    public ExpandedMenuView h;
    public int i;
    public int j;
    public int k;
    public m.a l;
    public a m;

    public e(Context context, int n2) {
        this.k = n2;
        this.j = 0;
        this.e = context;
        this.f = LayoutInflater.from((Context)context);
    }

    @Override
    public void a(f.b.o.i.g g2, boolean bl) {
        m.a a2 = this.l;
        if (a2 != null) {
            a2.a(g2, bl);
        }
    }

    public ListAdapter b() {
        if (this.m == null) {
            this.m = new BaseAdapter(){
                public int e = -1;
                {
                    this.a();
                }

                public void a() {
                    f.b.o.i.g g2 = e.this.g;
                    i i2 = g2.w;
                    if (i2 != null) {
                        g2.i();
                        ArrayList<i> arrayList = g2.j;
                        int n2 = arrayList.size();
                        for (int i3 = 0; i3 < n2; ++i3) {
                            if ((i)arrayList.get(i3) != i2) continue;
                            this.e = i3;
                            return;
                        }
                    }
                    this.e = -1;
                }

                public i b(int n2) {
                    f.b.o.i.g g2 = e.this.g;
                    g2.i();
                    ArrayList<i> arrayList = g2.j;
                    int n3 = n2 + e.this.i;
                    int n4 = this.e;
                    if (n4 >= 0 && n3 >= n4) {
                        ++n3;
                    }
                    return (i)arrayList.get(n3);
                }

                public int getCount() {
                    f.b.o.i.g g2 = e.this.g;
                    g2.i();
                    int n2 = g2.j.size() - e.this.i;
                    if (this.e < 0) {
                        return n2;
                    }
                    return n2 - 1;
                }

                public long getItemId(int n2) {
                    return n2;
                }

                public View getView(int n2, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        e e2 = e.this;
                        view = e2.f.inflate(e2.k, viewGroup, false);
                    }
                    ((n.a)view).e(this.b(n2), 0);
                    return view;
                }

                public void notifyDataSetChanged() {
                    this.a();
                    super.notifyDataSetChanged();
                }
            };
        }
        return this.m;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public void d(Context context, f.b.o.i.g g2) {
        block6 : {
            LayoutInflater layoutInflater;
            block5 : {
                block4 : {
                    if (this.j == 0) break block4;
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.j);
                    this.e = contextThemeWrapper;
                    layoutInflater = LayoutInflater.from((Context)contextThemeWrapper);
                    break block5;
                }
                if (this.e == null) break block6;
                this.e = context;
                if (this.f != null) break block6;
                layoutInflater = LayoutInflater.from((Context)context);
            }
            this.f = layoutInflater;
        }
        this.g = g2;
        a a2 = this.m;
        if (a2 != null) {
            a2.notifyDataSetChanged();
        }
    }

    @Override
    public boolean e(f.b.o.i.g g2, i i2) {
        return false;
    }

    @Override
    public boolean g(f.b.o.i.g g2, i i2) {
        return false;
    }

    @Override
    public void h(m.a a2) {
        this.l = a2;
    }

    @Override
    public boolean i(r r2) {
        d d2;
        e e2;
        if (!r2.hasVisibleItems()) {
            return false;
        }
        h h2 = new h(r2);
        f.b.o.i.g g2 = h2.e;
        d.a a2 = new d.a(g2.a);
        h2.g = e2 = new e(a2.a.a, g.abc_list_menu_item_layout);
        e2.l = h2;
        f.b.o.i.g g3 = h2.e;
        g3.b(e2, g3.a);
        ListAdapter listAdapter = h2.g.b();
        AlertController.b b2 = a2.a;
        b2.l = listAdapter;
        b2.m = h2;
        View view = g2.o;
        if (view != null) {
            b2.g = view;
        } else {
            b2.d = g2.n;
            b2.f = g2.m;
        }
        a2.a.k = h2;
        h2.f = d2 = a2.a();
        d2.setOnDismissListener((DialogInterface.OnDismissListener)h2);
        WindowManager.LayoutParams layoutParams = h2.f.getWindow().getAttributes();
        layoutParams.type = 1003;
        layoutParams.flags = 131072 | layoutParams.flags;
        h2.f.show();
        m.a a3 = this.l;
        if (a3 != null) {
            a3.b(r2);
        }
        return true;
    }

    @Override
    public void j(boolean bl) {
        a a2 = this.m;
        if (a2 != null) {
            a2.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        this.g.s(this.m.b(n2), this, 0);
    }

}

