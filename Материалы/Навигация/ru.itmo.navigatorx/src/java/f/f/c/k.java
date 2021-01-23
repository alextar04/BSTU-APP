/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.constraintlayout.widget.ConstraintLayout
 */
package f.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.c.b;
import f.f.c.j;

public abstract class k
extends b {
    public boolean l;
    public boolean m;

    @Override
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, j.ConstraintLayout_Layout);
            int n2 = typedArray.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = typedArray.getIndex(i2);
                if (n3 == j.ConstraintLayout_Layout_android_visibility) {
                    this.l = true;
                    continue;
                }
                if (n3 != j.ConstraintLayout_Layout_android_elevation) continue;
                this.m = true;
            }
        }
    }

    public void k() {
    }

    @Override
    public void onAttachedToWindow() {
        ViewParent viewParent;
        super.onAttachedToWindow();
        if ((this.l || this.m) && (viewParent = this.getParent()) != null && viewParent instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout)viewParent;
            int n2 = this.getVisibility();
            float f2 = this.getElevation();
            for (int i2 = 0; i2 < this.f; ++i2) {
                View view = constraintLayout.d(this.e[i2]);
                if (view == null) continue;
                if (this.l) {
                    view.setVisibility(n2);
                }
                if (!this.m || !(f2 > 0.0f)) continue;
                view.setTranslationZ(f2 + view.getTranslationZ());
            }
        }
    }

    public void setElevation(float f2) {
        View.super.setElevation(f2);
        this.c();
    }

    public void setVisibility(int n2) {
        View.super.setVisibility(n2);
        this.c();
    }
}

