/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$c
 */
package c.e.a.a.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.e.a.a.m.h;

public class g<V extends View>
extends CoordinatorLayout.c<V> {
    public h a;
    public int b = 0;
    public int c = 0;

    public g() {
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int B() {
        h h2 = this.a;
        if (h2 != null) {
            return h2.d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        coordinatorLayout.q(v2, n2);
    }

    public boolean D(int n2) {
        h h2 = this.a;
        if (h2 != null) {
            boolean bl = h2.f;
            boolean bl2 = false;
            if (bl) {
                int n3 = h2.d;
                bl2 = false;
                if (n3 != n2) {
                    h2.d = n2;
                    h2.a();
                    bl2 = true;
                }
            }
            return bl2;
        }
        this.b = n2;
        return false;
    }

    public boolean k(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        int n3;
        this.C(coordinatorLayout, v2, n2);
        if (this.a == null) {
            this.a = new h((View)v2);
        }
        h h2 = this.a;
        h2.b = h2.a.getTop();
        h2.c = h2.a.getLeft();
        this.a.a();
        int n4 = this.b;
        if (n4 != 0) {
            h h3 = this.a;
            if (h3.f && h3.d != n4) {
                h3.d = n4;
                h3.a();
            }
            this.b = 0;
        }
        if ((n3 = this.c) != 0) {
            h h4 = this.a;
            if (h4.g && h4.e != n3) {
                h4.e = n3;
                h4.a();
            }
            this.c = 0;
        }
        return true;
    }
}

