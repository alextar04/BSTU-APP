/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  java.lang.Object
 *  java.lang.ThreadLocal
 */
package c.e.a.a.a0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class d {
    public static final ThreadLocal<Matrix> a = new ThreadLocal();
    public static final ThreadLocal<RectF> b = new ThreadLocal();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = (Matrix)a.get();
        if (matrix == null) {
            matrix = new Matrix();
            a.set((Object)matrix);
        } else {
            matrix.reset();
        }
        d.b((ViewParent)viewGroup, view, matrix);
        RectF rectF = (RectF)b.get();
        if (rectF == null) {
            rectF = new RectF();
            b.set((Object)rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int)(0.5f + rectF.left), (int)(0.5f + rectF.top), (int)(0.5f + rectF.right), (int)(0.5f + rectF.bottom));
    }

    public static void b(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent viewParent2 = view.getParent();
        if (viewParent2 instanceof View && viewParent2 != viewParent) {
            View view2 = (View)viewParent2;
            d.b(viewParent, view2, matrix);
            matrix.preTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}

