/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Rect
 *  java.lang.Object
 */
package f.r;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class g
implements TypeEvaluator<Rect> {
    public Object evaluate(float f2, Object object, Object object2) {
        Rect rect = (Rect)object;
        Rect rect2 = (Rect)object2;
        int n2 = rect.left;
        int n3 = n2 + (int)(f2 * (float)(rect2.left - n2));
        int n4 = rect.top;
        int n5 = n4 + (int)(f2 * (float)(rect2.top - n4));
        int n6 = rect.right;
        int n7 = n6 + (int)(f2 * (float)(rect2.right - n6));
        int n8 = rect.bottom;
        return new Rect(n3, n5, n7, n8 + (int)(f2 * (float)(rect2.bottom - n8)));
    }
}

