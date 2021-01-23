/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  androidx.appcompat.view.menu.ListMenuItemView
 *  f.b.o.i.g
 *  f.b.o.i.i
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.b.o.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.n;
import java.util.ArrayList;

public class f
extends BaseAdapter {
    public g e;
    public int f = -1;
    public boolean g;
    public final boolean h;
    public final LayoutInflater i;
    public final int j;

    public f(g g2, LayoutInflater layoutInflater, boolean bl, int n2) {
        this.h = bl;
        this.i = layoutInflater;
        this.e = g2;
        this.j = n2;
        this.a();
    }

    public void a() {
        g g2 = this.e;
        i i2 = g2.w;
        if (i2 != null) {
            g2.i();
            ArrayList arrayList = g2.j;
            int n2 = arrayList.size();
            for (int i3 = 0; i3 < n2; ++i3) {
                if ((i)arrayList.get(i3) != i2) continue;
                this.f = i3;
                return;
            }
        }
        this.f = -1;
    }

    public i b(int n2) {
        ArrayList arrayList;
        if (this.h) {
            g g2 = this.e;
            g2.i();
            arrayList = g2.j;
        } else {
            arrayList = this.e.l();
        }
        int n3 = this.f;
        if (n3 >= 0 && n2 >= n3) {
            ++n2;
        }
        return (i)arrayList.get(n2);
    }

    public int getCount() {
        ArrayList arrayList;
        if (this.h) {
            g g2 = this.e;
            g2.i();
            arrayList = g2.j;
        } else {
            arrayList = this.e.l();
        }
        int n2 = this.f;
        int n3 = arrayList.size();
        if (n2 < 0) {
            return n3;
        }
        return n3 - 1;
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.i.inflate(this.j, viewGroup, false);
        }
        int n3 = this.b((int)n2).b;
        int n4 = n2 - 1;
        int n5 = n4 >= 0 ? this.b((int)n4).b : n3;
        ListMenuItemView listMenuItemView = (ListMenuItemView)view;
        boolean bl = this.e.m() && n3 != n5;
        listMenuItemView.setGroupDividerEnabled(bl);
        n.a a2 = (n.a)view;
        if (this.g) {
            listMenuItemView.setForceShowIcon(true);
        }
        a2.e(this.b(n2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}

