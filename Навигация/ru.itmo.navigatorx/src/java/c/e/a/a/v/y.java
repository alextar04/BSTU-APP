/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$v
 *  androidx.recyclerview.widget.RecyclerView$w
 *  f.p.d.q
 */
package c.e.a.a.v;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f.p.d.q;

public class y
extends LinearLayoutManager {
    public y(Context context, int n2, boolean bl) {
        super(n2, bl);
    }

    public void U0(RecyclerView recyclerView, RecyclerView.w w2, int n2) {
        q q2 = new q(this, recyclerView.getContext()){

            public float g(DisplayMetrics displayMetrics) {
                return 100.0f / (float)displayMetrics.densityDpi;
            }
        };
        q2.a = n2;
        this.V0((RecyclerView.v)q2);
    }

}

