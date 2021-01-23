/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$p
 *  c.e.a.a.v.g
 *  com.google.android.material.button.MaterialButton
 *  java.lang.CharSequence
 *  java.lang.String
 */
package c.e.a.a.v;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.v.a;
import c.e.a.a.v.g;
import c.e.a.a.v.s;
import c.e.a.a.v.v;
import com.google.android.material.button.MaterialButton;

public class j
extends RecyclerView.p {
    public final /* synthetic */ v a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ g c;

    public j(g g2, v v2, MaterialButton materialButton) {
        this.c = g2;
        this.a = v2;
        this.b = materialButton;
    }

    public void a(RecyclerView recyclerView, int n2) {
        if (n2 == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    public void b(RecyclerView recyclerView, int n2, int n3) {
        LinearLayoutManager linearLayoutManager = this.c.x0();
        int n4 = n2 < 0 ? linearLayoutManager.i1() : linearLayoutManager.k1();
        this.c.d0 = this.a.f(n4);
        this.b.setText((CharSequence)this.a.c.e.i((int)n4).f);
    }
}

