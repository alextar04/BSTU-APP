/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  java.lang.Object
 */
package c.e.a.a.w;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class a
implements View.OnTouchListener {
    public final Dialog e;
    public final int f;
    public final int g;
    public final int h;

    public a(Dialog dialog, Rect rect) {
        this.e = dialog;
        this.f = rect.left;
        this.g = rect.top;
        this.h = ViewConfiguration.get((Context)dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n2;
        View view2 = view.findViewById(16908290);
        int n3 = this.f + view2.getLeft();
        int n4 = n3 + view2.getWidth();
        int n5 = this.g + view2.getTop();
        if (new RectF((float)n3, (float)n5, (float)n4, (float)(n2 = n5 + view2.getHeight())).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEvent2 = MotionEvent.obtain((MotionEvent)motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEvent2.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEvent2.setAction(0);
            int n6 = this.h;
            motionEvent2.setLocation((float)(-n6 - 1), (float)(-n6 - 1));
        }
        view.performClick();
        return this.e.onTouchEvent(motionEvent2);
    }
}

