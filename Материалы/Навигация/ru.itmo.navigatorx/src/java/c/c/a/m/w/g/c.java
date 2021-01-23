/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.view.Gravity
 *  c.c.a.m.s
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.c.a.m.w.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import c.c.a.b;
import c.c.a.m.s;
import c.c.a.m.w.g.g;
import f.b.k.h;
import java.util.List;

public class c
extends Drawable
implements g.b,
Animatable {
    public final a e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public boolean l;
    public Paint m;
    public Rect n;

    public c(Context context, c.c.a.l.a a2, s<Bitmap> s2, int n2, int n3, Bitmap bitmap) {
        g g2 = new g(b.b(context), a2, n2, n3, s2, bitmap);
        Drawable.ConstantState constantState = new Drawable.ConstantState(g2){
            public final g a;
            {
                this.a = g2;
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return new c(this);
            }

            public Drawable newDrawable(Resources resources) {
                return new c(this);
            }
        };
        this.i = true;
        this.k = -1;
        h.i.p(constantState, "Argument must not be null");
        this.e = constantState;
    }

    public c(a a2) {
        this.i = true;
        this.k = -1;
        h.i.p(a2, "Argument must not be null");
        this.e = a2;
    }

    @Override
    public void a() {
        int n2;
        Drawable.Callback callback = this.getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable)callback).getCallback();
        }
        if (callback == null) {
            this.stop();
            this.invalidateSelf();
            return;
        }
        this.invalidateSelf();
        g.a a2 = this.e.a.j;
        int n3 = a2 != null ? a2.i : -1;
        if (n3 == -1 + this.e.a.a.e()) {
            this.j = 1 + this.j;
        }
        if ((n2 = this.k) != -1 && this.j >= n2) {
            this.stop();
        }
    }

    public Bitmap b() {
        return this.e.a.m;
    }

    public final Paint c() {
        if (this.m == null) {
            this.m = new Paint(2);
        }
        return this.m;
    }

    public final void d() {
        block5 : {
            block6 : {
                block7 : {
                    block4 : {
                        h.i.l(true ^ this.h, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
                        if (this.e.a.a.e() == 1) break block4;
                        if (this.f) break block5;
                        this.f = true;
                        g g2 = this.e.a;
                        if (g2.k) break block6;
                        if (g2.c.contains((Object)this)) break block7;
                        boolean bl = g2.c.isEmpty();
                        g2.c.add((Object)this);
                        if (bl && !g2.f) {
                            g2.f = true;
                            g2.k = false;
                            g2.a();
                        }
                    }
                    this.invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    public void draw(Canvas canvas) {
        if (this.h) {
            return;
        }
        if (this.l) {
            int n2 = this.getIntrinsicWidth();
            int n3 = this.getIntrinsicHeight();
            Rect rect = this.getBounds();
            if (this.n == null) {
                this.n = new Rect();
            }
            Gravity.apply((int)119, (int)n2, (int)n3, (Rect)rect, (Rect)this.n);
            this.l = false;
        }
        g g2 = this.e.a;
        g.a a2 = g2.j;
        Bitmap bitmap = a2 != null ? a2.k : g2.m;
        if (this.n == null) {
            this.n = new Rect();
        }
        canvas.drawBitmap(bitmap, null, this.n, this.c());
    }

    public final void e() {
        this.f = false;
        g g2 = this.e.a;
        g2.c.remove((Object)this);
        if (g2.c.isEmpty()) {
            g2.f = false;
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.e;
    }

    public int getIntrinsicHeight() {
        return this.e.a.q;
    }

    public int getIntrinsicWidth() {
        return this.e.a.p;
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    public void setAlpha(int n2) {
        this.c().setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        h.i.l(true ^ this.h, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.i = bl;
        if (!bl) {
            this.e();
        } else if (this.g) {
            this.d();
        }
        return super.setVisible(bl, bl2);
    }

    public void start() {
        this.g = true;
        this.j = 0;
        if (this.i) {
            this.d();
        }
    }

    public void stop() {
        this.g = false;
        this.e();
    }

}

