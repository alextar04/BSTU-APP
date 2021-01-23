/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.AutoCompleteTextView
 *  c.e.a.a.i0.h
 *  java.lang.Object
 */
package c.e.a.a.i0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import c.e.a.a.i0.h;

public class j
implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView e;
    public final /* synthetic */ h f;

    public j(h h2, AutoCompleteTextView autoCompleteTextView) {
        this.f = h2;
        this.e = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f.i()) {
                this.f.i = false;
            }
            h.g((h)this.f, (AutoCompleteTextView)this.e);
        }
        return false;
    }
}

