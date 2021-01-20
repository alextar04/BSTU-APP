/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$p
 */
package f.p.d;

import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class b0
extends RecyclerView.n {
    public RecyclerView a;
    public Scroller b;
    public final RecyclerView.p c = new RecyclerView.p(){
        public boolean a = false;

        public void a(RecyclerView recyclerView, int n2) {
            if (n2 == 0 && this.a) {
                this.a = false;
                b0.this.c();
            }
        }

        public void b(RecyclerView recyclerView, int n2, int n3) {
            if (n2 != 0 || n3 != 0) {
                this.a = true;
            }
        }
    };

    public abstract int[] a(RecyclerView.l var1, View var2);

    public abstract View b(RecyclerView.l var1);

    public void c() {
        RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.l l2 = recyclerView.getLayoutManager();
        if (l2 == null) {
            return;
        }
        View view = this.b(l2);
        if (view == null) {
            return;
        }
        int[] arrn = this.a(l2, view);
        if (arrn[0] != 0 || arrn[1] != 0) {
            this.a.l0(arrn[0], arrn[1], null, Integer.MIN_VALUE, false);
        }
    }

}

