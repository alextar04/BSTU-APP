/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.PopupWindow
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import f.b.j;
import f.b.l.a.a;

public class o
extends PopupWindow {
    public o(Context context, AttributeSet attributeSet, int n2, int n3) {
        int n4;
        int n5;
        super(context, attributeSet, n2, n3);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.PopupWindow, n2, n3);
        if (typedArray.hasValue(j.PopupWindow_overlapAnchor)) {
            this.setOverlapAnchor(typedArray.getBoolean(j.PopupWindow_overlapAnchor, false));
        }
        Drawable drawable = typedArray.hasValue(n4 = j.PopupWindow_android_popupBackground) && (n5 = typedArray.getResourceId(n4, 0)) != 0 ? a.b(context, n5) : typedArray.getDrawable(n4);
        this.setBackgroundDrawable(drawable);
        typedArray.recycle();
    }

    public void showAsDropDown(View view, int n2, int n3) {
        super.showAsDropDown(view, n2, n3);
    }

    public void showAsDropDown(View view, int n2, int n3, int n4) {
        super.showAsDropDown(view, n2, n3, n4);
    }

    public void update(View view, int n2, int n3, int n4, int n5) {
        super.update(view, n2, n3, n4, n5);
    }
}

