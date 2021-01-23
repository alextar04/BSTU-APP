/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 *  f.b.k.h
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import f.b.k.h;
import f.b.l.a.a;
import f.b.p.r0;
import f.b.p.t0;
import f.b.p.w0;
import f.b.p.x;

public class h
extends CheckedTextView {
    public static final int[] f = new int[]{16843016};
    public final x e;

    public h(Context context, AttributeSet attributeSet) {
        x x2;
        t0.a(context);
        super(context, attributeSet, 16843720);
        r0.a((View)this, this.getContext());
        this.e = x2 = new x((TextView)this);
        x2.e(attributeSet, 16843720);
        this.e.b();
        w0 w02 = w0.q(this.getContext(), attributeSet, f, 16843720, 0);
        this.setCheckMarkDrawable(w02.g(0));
        w02.b.recycle();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        x x2 = this.e;
        if (x2 != null) {
            x2.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        h.i.f1(inputConnection, editorInfo, (View)this);
        return inputConnection;
    }

    public void setCheckMarkDrawable(int n2) {
        this.setCheckMarkDrawable(a.b(this.getContext(), n2));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(h.i.U1((TextView)this, callback));
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        x x2 = this.e;
        if (x2 != null) {
            x2.f(context, n2);
        }
    }
}

