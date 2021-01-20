/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.widget.Barrier
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$a
 *  f.f.c.e$a
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.HashMap
 */
package f.f.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.c.b;
import f.f.c.d;
import f.f.c.e;
import java.util.HashMap;

/*
 * Exception performing whole class analysis.
 */
public class e
extends ViewGroup {
    public d e;

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public d getConstraintSet() {
        d d2;
        if (this.e == null) {
            this.e = new d();
        }
        if ((d2 = this.e) != null) {
            int n2 = this.getChildCount();
            d2.c.clear();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = this.getChildAt(i2);
                a a2 = view.getLayoutParams();
                int n3 = view.getId();
                if (d2.b && n3 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!d2.c.containsKey((Object)n3)) {
                    d2.c.put((Object)n3, (Object)new d.a());
                }
                d.a a3 = (d.a)d2.c.get((Object)n3);
                if (view instanceof b) {
                    b b2 = (b)view;
                    a3.c(n3, a2);
                    if (b2 instanceof Barrier) {
                        d.b b3 = a3.d;
                        b3.d0 = 1;
                        Barrier barrier = (Barrier)b2;
                        b3.b0 = barrier.getType();
                        a3.d.e0 = barrier.getReferencedIds();
                        a3.d.c0 = barrier.getMargin();
                    }
                }
                a3.c(n3, a2);
            }
            return this.e;
        }
        throw null;
    }

    public void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
    }
}

