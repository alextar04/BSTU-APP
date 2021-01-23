/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$e
 *  androidx.recyclerview.widget.RecyclerView$m
 *  androidx.recyclerview.widget.RecyclerView$z
 *  c.e.a.a.v.g
 *  c.e.a.a.v.o
 *  com.google.android.material.datepicker.MaterialCalendarGridView
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 */
package c.e.a.a.v;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.f;
import c.e.a.a.h;
import c.e.a.a.v.d;
import c.e.a.a.v.g;
import c.e.a.a.v.o;
import c.e.a.a.v.s;
import c.e.a.a.v.t;
import c.e.a.a.v.u;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import f.h.l.l;
import java.util.Calendar;

public class v
extends RecyclerView.d<a> {
    public final c.e.a.a.v.a c;
    public final d<?> d;
    public final g.f e;
    public final int f;

    public v(Context context, d<?> d2, c.e.a.a.v.a a2, g.f f2) {
        s s2 = a2.e;
        s s3 = a2.f;
        s s4 = a2.g;
        if (s2.a(s4) <= 0) {
            if (s4.a(s3) <= 0) {
                int n2 = t.i * g.w0((Context)context);
                int n3 = o.D0((Context)context) ? context.getResources().getDimensionPixelSize(c.e.a.a.d.mtrl_calendar_day_height) : 0;
                this.f = n2 + n3;
                this.c = a2;
                this.d = d2;
                this.e = f2;
                if (!this.a.a()) {
                    this.b = true;
                    return;
                }
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    public int a() {
        return this.c.j;
    }

    public long b(int n2) {
        return this.c.e.i((int)n2).e.getTimeInMillis();
    }

    public void d(RecyclerView.z z2, int n2) {
        a a2 = (a)z2;
        s s2 = this.c.e.i(n2);
        a2.t.setText((CharSequence)s2.f);
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView)a2.u.findViewById(f.month_grid);
        if (materialCalendarGridView.a() != null && s2.equals(materialCalendarGridView.a().e)) {
            materialCalendarGridView.a().notifyDataSetChanged();
        } else {
            t t2 = new t(s2, this.d, this.c);
            materialCalendarGridView.setNumColumns(s2.i);
            materialCalendarGridView.setAdapter((ListAdapter)t2);
        }
        materialCalendarGridView.setOnItemClickListener((AdapterView.OnItemClickListener)new u(this, materialCalendarGridView));
    }

    public RecyclerView.z e(ViewGroup viewGroup, int n2) {
        LinearLayout linearLayout = (LinearLayout)LayoutInflater.from((Context)viewGroup.getContext()).inflate(h.mtrl_calendar_month_labeled, viewGroup, false);
        if (o.D0((Context)viewGroup.getContext())) {
            linearLayout.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.m(-1, this.f));
            return new a(linearLayout, true);
        }
        return new a(linearLayout, false);
    }

    public s f(int n2) {
        return this.c.e.i(n2);
    }

    public int g(s s2) {
        return this.c.e.k(s2);
    }

    public static class a
    extends RecyclerView.z {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public a(LinearLayout linearLayout, boolean bl) {
            TextView textView;
            super((View)linearLayout);
            this.t = textView = (TextView)linearLayout.findViewById(f.month_title);
            l.T((View)textView, (boolean)true);
            this.u = (MaterialCalendarGridView)linearLayout.findViewById(f.month_grid);
            if (!bl) {
                this.t.setVisibility(8);
            }
        }
    }

}

