/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  c.e.a.a.v.g
 *  c.e.a.a.v.v
 *  java.lang.Object
 */
package c.e.a.a.v;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.e.a.a.v.g;
import c.e.a.a.v.s;
import c.e.a.a.v.v;

public class m
implements View.OnClickListener {
    public final /* synthetic */ v e;
    public final /* synthetic */ g f;

    public m(g g2, v v2) {
        this.f = g2;
        this.e = v2;
    }

    public void onClick(View view) {
        int n2 = -1 + this.f.x0().k1();
        if (n2 >= 0) {
            this.f.z0(this.e.f(n2));
        }
    }
}

