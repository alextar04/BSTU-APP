/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$e
 *  c.e.a.a.v.g
 *  c.e.a.a.v.g$d
 *  c.e.a.a.v.v
 *  c.e.a.a.v.x
 *  com.google.android.material.datepicker.MaterialCalendarGridView
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 */
package c.e.a.a.v;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.v.a;
import c.e.a.a.v.d;
import c.e.a.a.v.g;
import c.e.a.a.v.t;
import c.e.a.a.v.v;
import c.e.a.a.v.w;
import c.e.a.a.v.x;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class u
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView e;
    public final /* synthetic */ v f;

    public u(v v2, MaterialCalendarGridView materialCalendarGridView) {
        this.f = v2;
        this.e = materialCalendarGridView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        t t2 = this.e.a();
        boolean bl = n2 >= t2.a() && n2 <= t2.c();
        if (bl) {
            g.f f2 = this.f.e;
            long l3 = this.e.a().b(n2);
            g.d d2 = (g.d)f2;
            if (d2.a.c0.h.m(l3)) {
                d2.a.b0.s(l3);
                Iterator iterator = d2.a.Z.iterator();
                while (iterator.hasNext()) {
                    ((w)iterator.next()).a(d2.a.b0.c());
                }
                d2.a.h0.getAdapter().a.b();
                RecyclerView recyclerView = d2.a.g0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().a.b();
                }
            }
        }
    }
}

