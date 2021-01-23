/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$z
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.a.a.a.a.k;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.a.k.c;
import b.a.a.b.d;
import b.a.a.b.f;
import h.m.b.j;

public abstract class c
extends RecyclerView.z {
    public final AppCompatImageView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final b.a.a.a.a.k.b x;

    public c(View view, b.a.a.a.a.k.b b2, h.m.b.f f2) {
        super(view);
        this.x = b2;
        View view2 = view.findViewById(2131231011);
        j.d((Object)view2, "view.findViewById(R.id.room_image)");
        this.t = (AppCompatImageView)view2;
        View view3 = view.findViewById(2131231021);
        j.d((Object)view3, "view.findViewById(R.id.room_title)");
        this.u = (TextView)view3;
        View view4 = view.findViewById(2131230934);
        j.d((Object)view4, "view.findViewById(R.id.marker_text)");
        this.v = (TextView)view4;
        View view5 = view.findViewById(2131231010);
        j.d((Object)view5, "view.findViewById(R.id.room_floor)");
        this.w = (TextView)view5;
    }

    public void v(d d2) {
        j.e(d2, "marker");
        this.a.setOnClickListener(new View.OnClickListener(this, d2){
            public final /* synthetic */ c e;
            public final /* synthetic */ d f;
            {
                this.e = c2;
                this.f = d2;
            }

            public final void onClick(View view) {
                this.e.x.d(this.f);
            }
        });
    }

}

