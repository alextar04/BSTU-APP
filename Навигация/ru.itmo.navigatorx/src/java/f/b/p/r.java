/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.RatingBar
 */
package f.b.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import f.b.a;
import f.b.p.p;
import f.b.p.r0;

public class r
extends RatingBar {
    public final p e;

    public r(Context context, AttributeSet attributeSet) {
        p p2;
        int n2 = a.ratingBarStyle;
        super(context, attributeSet, n2);
        r0.a((View)this, this.getContext());
        this.e = p2 = new p((ProgressBar)this);
        p2.a(attributeSet, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onMeasure(int n2, int n3) {
        r r2 = this;
        synchronized (r2) {
            super.onMeasure(n2, n3);
            Bitmap bitmap = this.e.b;
            if (bitmap != null) {
                this.setMeasuredDimension(View.resolveSizeAndState((int)(bitmap.getWidth() * this.getNumStars()), (int)n2, (int)0), this.getMeasuredHeight());
            }
            return;
        }
    }
}

