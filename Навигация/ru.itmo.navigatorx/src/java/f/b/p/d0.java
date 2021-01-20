/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.ScaleDrawable
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.p;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import f.b.m.a.c;
import f.h.f.k.a;

@SuppressLint(value={"RestrictedAPI"})
public class d0 {
    public static final int[] a = new int[]{16842912};
    public static final int[] b = new int[0];

    public static {
        new Rect();
        try {
            Class.forName((String)"android.graphics.Insets");
        }
        catch (ClassNotFoundException classNotFoundException) {}
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) return true;
            Drawable[] arrdrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
            int n2 = arrdrawable.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (d0.a(arrdrawable[i2])) continue;
                return false;
            }
            return true;
        } else {
            Drawable drawable2;
            if (drawable instanceof a) {
                drawable2 = ((a)drawable).a();
                do {
                    return d0.a(drawable2);
                    break;
                } while (true);
            }
            if (drawable instanceof c) {
                return d0.a(((c)drawable).e);
            }
            if (!(drawable instanceof ScaleDrawable)) return true;
            drawable2 = ((ScaleDrawable)drawable).getDrawable();
            return d0.a(drawable2);
        }
    }

    public static void b(Drawable drawable) {
    }

    public static PorterDuff.Mode c(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}

