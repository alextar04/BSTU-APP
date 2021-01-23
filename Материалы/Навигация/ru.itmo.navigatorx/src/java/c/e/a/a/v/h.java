/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$k
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$w
 *  c.e.a.a.v.g
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Calendar
 *  java.util.Collection
 */
package c.e.a.a.v;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.v.a0;
import c.e.a.a.v.b;
import c.e.a.a.v.c;
import c.e.a.a.v.c0;
import c.e.a.a.v.d;
import c.e.a.a.v.g;
import java.util.Calendar;
import java.util.Collection;

public class h
extends RecyclerView.k {
    public final Calendar a = a0.g();
    public final Calendar b = a0.g();
    public final /* synthetic */ g c;

    public h(g g2) {
        this.c = g2;
    }

    public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.w w2) {
        if (recyclerView.getAdapter() instanceof c0) {
            if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                return;
            }
            c0 c02 = (c0)recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager)recyclerView.getLayoutManager();
            for (f.h.k.b b2 : this.c.b0.j()) {
                Object f2 = b2.a;
                if (f2 == null || b2.b == null) continue;
                this.a.setTimeInMillis(((Long)f2).longValue());
                this.b.setTimeInMillis(((Long)b2.b).longValue());
                int n2 = c02.f(this.a.get(1));
                int n3 = c02.f(this.b.get(1));
                View view = gridLayoutManager.t(n2);
                View view2 = gridLayoutManager.t(n3);
                int n4 = gridLayoutManager.I;
                int n5 = n2 / n4;
                int n6 = n3 / n4;
                for (int i2 = n5; i2 <= n6; ++i2) {
                    View view3 = gridLayoutManager.t(i2 * gridLayoutManager.I);
                    if (view3 == null) continue;
                    int n7 = view3.getTop() + this.c.f0.d.a.top;
                    int n8 = view3.getBottom() - this.c.f0.d.a.bottom;
                    int n9 = i2 == n5 ? view.getLeft() + view.getWidth() / 2 : 0;
                    int n10 = i2 == n6 ? view2.getLeft() + view2.getWidth() / 2 : recyclerView.getWidth();
                    canvas.drawRect((float)n9, (float)n7, (float)n10, (float)n8, this.c.f0.h);
                }
            }
        }
    }
}

