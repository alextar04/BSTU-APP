/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.View
 *  c.e.a.a.f0.g
 */
package c.e.a.a.i0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.view.View;
import c.e.a.a.f0.j;

public class g
extends c.e.a.a.f0.g {
    public final Paint C;
    public final RectF D;
    public int E;

    public g() {
        this(null);
    }

    public g(j j2) {
        Paint paint;
        if (j2 == null) {
            j2 = new j();
        }
        super(j2);
        this.C = paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.C.setColor(-1);
        this.C.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.D = new RectF();
    }

    public void draw(Canvas canvas) {
        Drawable.Callback callback = this.getCallback();
        if (callback instanceof View) {
            View view = (View)callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.E = canvas.saveLayer(0.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.D, this.C);
        if (!(this.getCallback() instanceof View)) {
            canvas.restoreToCount(this.E);
        }
    }

    public void y(float f2, float f3, float f4, float f5) {
        RectF rectF = this.D;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            this.D.set(f2, f3, f4, f5);
            this.invalidateSelf();
        }
    }
}

