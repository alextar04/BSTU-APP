/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$z
 *  c.e.a.a.v.g
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Locale
 */
package c.e.a.a.v;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.h;
import c.e.a.a.i;
import c.e.a.a.v.a0;
import c.e.a.a.v.b;
import c.e.a.a.v.b0;
import c.e.a.a.v.c;
import c.e.a.a.v.d;
import c.e.a.a.v.g;
import c.e.a.a.v.s;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

public class c0
extends RecyclerView.d<a> {
    public final g<?> c;

    public c0(g<?> g2) {
        this.c = g2;
    }

    public int a() {
        return this.c.c0.i;
    }

    public void d(RecyclerView.z z2, int n2) {
        a a2 = (a)z2;
        int n3 = n2 + this.c.c0.e.h;
        String string = a2.t.getContext().getString(i.mtrl_picker_navigate_to_year_description);
        TextView textView = a2.t;
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{n3};
        textView.setText((CharSequence)String.format((Locale)locale, (String)"%d", (Object[])arrobject));
        TextView textView2 = a2.t;
        Object[] arrobject2 = new Object[]{n3};
        textView2.setContentDescription((CharSequence)String.format((String)string, (Object[])arrobject2));
        c c2 = this.c.f0;
        Calendar calendar = a0.f();
        b b2 = calendar.get(1) == n3 ? c2.f : c2.d;
        Iterator iterator = this.c.b0.v().iterator();
        while (iterator.hasNext()) {
            calendar.setTimeInMillis(((Long)iterator.next()).longValue());
            if (calendar.get(1) != n3) continue;
            b2 = c2.e;
        }
        b2.b(a2.t);
        a2.t.setOnClickListener((View.OnClickListener)new b0(this, n3));
    }

    public RecyclerView.z e(ViewGroup viewGroup, int n2) {
        return new a((TextView)LayoutInflater.from((Context)viewGroup.getContext()).inflate(h.mtrl_calendar_year, viewGroup, false));
    }

    public int f(int n2) {
        return n2 - this.c.c0.e.h;
    }

    public static class a
    extends RecyclerView.z {
        public final TextView t;

        public a(TextView textView) {
            super((View)textView);
            this.t = textView;
        }
    }

}

