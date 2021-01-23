/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$z
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.a.a.a.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.b.b;
import b.a.a.a.b.c;
import h.m.b.j;
import java.util.List;

public final class a
extends RecyclerView.d<a> {
    public List<? extends b.a.a.b.b> c;
    public final c d;

    public a(List<? extends b.a.a.b.b> list, c c2) {
        j.e(list, "buildings");
        j.e(c2, "callbacks");
        this.d = c2;
        this.c = list;
    }

    public int a() {
        return this.c.size();
    }

    public void d(RecyclerView.z z2, int n2) {
        a a2 = (a)z2;
        j.e((Object)a2, "holder");
        b.a.a.b.b b2 = (b.a.a.b.b)((Object)this.c.get(n2));
        b b3 = new b(this, b2);
        j.e((Object)b2, "building");
        j.e(b3, "onClickListener");
        a2.u.setText((CharSequence)b2.f);
        a2.v.setText((CharSequence)b2.g);
        a2.t.setImageResource(b2.j);
        a2.a.setOnClickListener((View.OnClickListener)b3);
    }

    public RecyclerView.z e(ViewGroup viewGroup, int n2) {
        j.e((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427373, viewGroup, false);
        j.d((Object)view, "view");
        return new a(view);
    }

    public static final class a
    extends RecyclerView.z {
        public final ImageView t;
        public final TextView u;
        public final TextView v;

        public a(View view) {
            j.e((Object)view, "view");
            super(view);
            View view2 = view.findViewById(2131230811);
            j.d((Object)view2, "view.findViewById<AppCom\u2026iew>(R.id.building_image)");
            this.t = (ImageView)view2;
            View view3 = view.findViewById(2131230812);
            j.d((Object)view3, "view.findViewById(R.id.building_title)");
            this.u = (TextView)view3;
            View view4 = view.findViewById(2131230810);
            j.d((Object)view4, "view.findViewById(R.id.building_description)");
            this.v = (TextView)view4;
        }
    }

}

