/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package f.p.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import f.p.d.u;
import f.p.d.v;

public abstract class w {
    public final RecyclerView.l a;
    public int b = Integer.MIN_VALUE;
    public final Rect c = new Rect();

    public w(RecyclerView.l l2, u u2) {
        this.a = l2;
    }

    public static w a(RecyclerView.l l2, int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                return new v(l2);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new u(l2);
    }

    public abstract int b(View var1);

    public abstract int c(View var1);

    public abstract int d(View var1);

    public abstract int e(View var1);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return this.l() - this.b;
    }

    public abstract int n(View var1);

    public abstract int o(View var1);

    public abstract void p(int var1);
}

