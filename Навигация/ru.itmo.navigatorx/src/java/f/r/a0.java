/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 */
package f.r;

import android.graphics.Matrix;
import android.view.View;
import f.r.z;

public class a0
extends z {
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    public void d(View view, int n2, int n3, int n4, int n5) {
        view.setLeftTopRightBottom(n2, n3, n4, n5);
    }

    public void e(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override
    public void f(View view, int n2) {
        view.setTransitionVisibility(n2);
    }

    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}

