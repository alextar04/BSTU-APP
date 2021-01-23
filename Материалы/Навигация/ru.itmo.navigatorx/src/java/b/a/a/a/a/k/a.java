/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$z
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package b.a.a.a.a.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.a.k.b;
import b.a.a.a.a.k.c;
import b.a.a.b.d;
import h.m.b.j;
import java.util.List;

public final class a
extends RecyclerView.d<c> {
    public List<? extends d> c;
    public final b d;

    public a(List<? extends d> list, b b2) {
        j.e(list, "markers");
        j.e(b2, "callbacks");
        this.d = b2;
        this.c = list;
    }

    public int a() {
        return this.c.size();
    }

    public int c(int n2) {
        d d2 = (d)this.c.get(n2);
        if (d2 instanceof d.c) {
            return 0;
        }
        if (d2 instanceof d.a) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported marker: ");
        stringBuilder.append((Object)d2);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void d(RecyclerView.z z2, int n2) {
        c c2 = (c)z2;
        j.e((Object)c2, "holder");
        c2.v((d)this.c.get(n2));
    }

    public RecyclerView.z e(ViewGroup viewGroup, int n2) {
        j.e((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131427377, viewGroup, false);
        if (n2 != 0) {
            if (n2 == 1) {
                j.d((Object)view, "view");
                return new c(view, this.d){
                    {
                        j.e((Object)view, "view");
                        j.e(b2, "callbacks");
                        super(view, b2, null);
                    }

                    public void v(d d2) {
                        d.a a2;
                        j.e(d2, "marker");
                        super.v(d2);
                        if (!(d2 instanceof d.a)) {
                            d2 = null;
                        }
                        if ((a2 = d2) != null) {
                            this.u.setText((java.lang.CharSequence)a2.h);
                            this.v.setText((java.lang.CharSequence)a2.h);
                            this.t.setImageResource(2131165299);
                            android.widget.TextView textView = this.w;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(a2.e);
                            stringBuilder.append(" \u042d\u0422\u0410\u0416");
                            textView.setText((java.lang.CharSequence)stringBuilder.toString());
                        }
                    }
                };
            }
            throw new IllegalStateException(c.b.a.a.a.b("Unknown marker type: ", n2));
        }
        j.d((Object)view, "view");
        return new c(view, this.d){
            {
                j.e((Object)view, "view");
                j.e(b2, "callbacks");
                super(view, b2, null);
            }

            public void v(d d2) {
                d.c c2;
                j.e(d2, "marker");
                super.v(d2);
                if (!(d2 instanceof d.c)) {
                    d2 = null;
                }
                if ((c2 = d2) != null) {
                    if (c2.h.b != null) {
                        this.u.setVisibility(0);
                        this.u.setText((java.lang.CharSequence)c2.h.b);
                    } else {
                        this.u.setVisibility(8);
                    }
                    android.widget.TextView textView = this.w;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(c2.e);
                    stringBuilder.append(" \u042d\u0422\u0410\u0416");
                    textView.setText((java.lang.CharSequence)stringBuilder.toString());
                    android.widget.TextView textView2 = this.v;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(c2.g);
                    stringBuilder2.append(' ');
                    String string = c2.h.d;
                    if (string == null) {
                        string = "";
                    }
                    stringBuilder2.append(string);
                    textView2.setText((java.lang.CharSequence)stringBuilder2.toString());
                    this.t.setImageResource(2131165308);
                }
            }
        };
    }
}

