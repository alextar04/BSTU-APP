/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$a
 */
package f.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class g
extends View {
    public g(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void draw(Canvas canvas) {
    }

    public void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int n2) {
        ConstraintLayout.a a2 = (ConstraintLayout.a)this.getLayoutParams();
        a2.a = n2;
        this.setLayoutParams((ViewGroup.LayoutParams)a2);
    }

    public void setGuidelineEnd(int n2) {
        ConstraintLayout.a a2 = (ConstraintLayout.a)this.getLayoutParams();
        a2.b = n2;
        this.setLayoutParams((ViewGroup.LayoutParams)a2);
    }

    public void setGuidelinePercent(float f2) {
        ConstraintLayout.a a2 = (ConstraintLayout.a)this.getLayoutParams();
        a2.c = f2;
        this.setLayoutParams((ViewGroup.LayoutParams)a2);
    }

    public void setVisibility(int n2) {
    }
}

