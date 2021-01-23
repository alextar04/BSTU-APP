/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$a
 *  java.lang.String
 */
package f.f.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.b.i.d;

public class h
extends View {
    public int e;
    public View f;
    public int g;

    public void a() {
        d.a a2 = d.a.e;
        if (this.f == null) {
            return;
        }
        ConstraintLayout.a a3 = (ConstraintLayout.a)this.getLayoutParams();
        ConstraintLayout.a a4 = (ConstraintLayout.a)this.f.getLayoutParams();
        a4.m0.X = 0;
        if (a3.m0.j() != a2) {
            a3.m0.B(a4.m0.o());
        }
        if (a3.m0.n() != a2) {
            a3.m0.w(a4.m0.i());
        }
        a4.m0.X = 8;
    }

    public View getContent() {
        return this.f;
    }

    public int getEmptyVisibility() {
        return this.g;
    }

    public void onDraw(Canvas canvas) {
        if (this.isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float)rect.height());
            int n2 = rect.height();
            int n3 = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", (float)n3 / 2.0f - (float)rect.width() / 2.0f - (float)rect.left, (float)n2 / 2.0f + (float)rect.height() / 2.0f - (float)rect.bottom, paint);
        }
    }

    public void setContentId(int n2) {
        View view;
        if (this.e == n2) {
            return;
        }
        View view2 = this.f;
        if (view2 != null) {
            view2.setVisibility(0);
            ((ConstraintLayout.a)this.f.getLayoutParams()).a0 = false;
            this.f = null;
        }
        this.e = n2;
        if (n2 != -1 && (view = ((View)this.getParent()).findViewById(n2)) != null) {
            view.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int n2) {
        this.g = n2;
    }
}

