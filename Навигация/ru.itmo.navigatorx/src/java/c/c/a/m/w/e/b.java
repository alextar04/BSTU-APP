/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  java.lang.Object
 */
package c.c.a.m.w.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.c.a.m.u.s;
import c.c.a.m.u.w;
import c.c.a.m.w.g.c;
import f.b.k.h;

public abstract class b<T extends Drawable>
implements w<T>,
s {
    public final T e;

    public b(T t2) {
        h.i.p(t2, "Argument must not be null");
        this.e = t2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a() {
        Bitmap bitmap;
        T t2 = this.e;
        if (t2 instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable)t2).getBitmap();
        } else {
            if (!(t2 instanceof c)) {
                return;
            }
            bitmap = ((c)t2).b();
        }
        bitmap.prepareToDraw();
    }

    @Override
    public Object b() {
        Drawable.ConstantState constantState = this.e.getConstantState();
        if (constantState == null) {
            return this.e;
        }
        return constantState.newDrawable();
    }
}

