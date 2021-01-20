/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.text.method.KeyListener
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AutoCompleteTextView
 *  android.widget.Filterable
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  com.google.android.material.internal.CheckableImageButton
 *  com.google.android.material.textfield.TextInputLayout
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package c.e.a.a.i0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import c.e.a.a.b;
import c.e.a.a.i0.o;
import c.e.a.a.j;
import c.e.a.a.j0.a.a;
import c.e.a.a.k;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import f.b.p.d;
import f.b.p.e0;
import f.b.p.j0;
import java.util.Locale;

public class p
extends d {
    public final j0 h;
    public final AccessibilityManager i;
    public final Rect j;

    public p(Context context, AttributeSet attributeSet) {
        j0 j02;
        int n2 = b.autoCompleteTextViewStyle;
        super(a.a(context, attributeSet, n2, 0), attributeSet, n2);
        this.j = new Rect();
        Context context2 = this.getContext();
        TypedArray typedArray = c.e.a.a.a0.j.d(context2, attributeSet, k.MaterialAutoCompleteTextView, n2, j.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArray.hasValue(k.MaterialAutoCompleteTextView_android_inputType) && typedArray.getInt(k.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            this.setKeyListener(null);
        }
        this.i = (AccessibilityManager)context2.getSystemService("accessibility");
        this.h = j02 = new j0(context2, null, f.b.a.listPopupWindowStyle, 0);
        j02.s(true);
        j0 j03 = this.h;
        j03.v = this;
        j03.F.setInputMethodMode(2);
        this.h.o(this.getAdapter());
        this.h.w = new o(this);
        typedArray.recycle();
    }

    public static void a(p p2, Object object) {
        p2.setText(p2.convertSelectionToString(object), false);
    }

    public final TextInputLayout b() {
        for (ViewParent viewParent = this.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
            if (!(viewParent instanceof TextInputLayout)) continue;
            return (TextInputLayout)viewParent;
        }
        return null;
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = this.b();
        if (textInputLayout != null && textInputLayout.E) {
            return textInputLayout.getHint();
        }
        return AutoCompleteTextView.super.getHint();
    }

    public void onAttachedToWindow() {
        AutoCompleteTextView.super.onAttachedToWindow();
        TextInputLayout textInputLayout = this.b();
        if (textInputLayout != null && textInputLayout.E && AutoCompleteTextView.super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals((Object)"meizu")) {
            this.setHint((CharSequence)"");
        }
    }

    public void onMeasure(int n2, int n3) {
        AutoCompleteTextView.super.onMeasure(n2, n3);
        if (View.MeasureSpec.getMode((int)n2) == Integer.MIN_VALUE) {
            int n4 = this.getMeasuredWidth();
            ListAdapter listAdapter = this.getAdapter();
            TextInputLayout textInputLayout = this.b();
            int n5 = 0;
            if (listAdapter != null) {
                if (textInputLayout == null) {
                    n5 = 0;
                } else {
                    int n6 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
                    int n7 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
                    j0 j02 = this.h;
                    int n8 = !j02.b() ? -1 : j02.g.getSelectedItemPosition();
                    int n9 = Math.max((int)0, (int)n8);
                    int n10 = Math.min((int)listAdapter.getCount(), (int)(n9 + 15));
                    View view = null;
                    int n11 = 0;
                    for (int i2 = Math.max((int)0, (int)(n10 - 15)); i2 < n10; ++i2) {
                        int n12 = listAdapter.getItemViewType(i2);
                        if (n12 != n5) {
                            view = null;
                            n5 = n12;
                        }
                        if ((view = listAdapter.getView(i2, view, (ViewGroup)textInputLayout)).getLayoutParams() == null) {
                            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        }
                        view.measure(n6, n7);
                        n11 = Math.max((int)n11, (int)view.getMeasuredWidth());
                    }
                    Drawable drawable = this.h.i();
                    if (drawable != null) {
                        drawable.getPadding(this.j);
                        Rect rect = this.j;
                        n11 += rect.left + rect.right;
                    }
                    n5 = n11 + textInputLayout.getEndIconView().getMeasuredWidth();
                }
            }
            this.setMeasuredDimension(Math.min((int)Math.max((int)n4, (int)n5), (int)View.MeasureSpec.getSize((int)n2)), this.getMeasuredHeight());
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t2) {
        AutoCompleteTextView.super.setAdapter(t2);
        this.h.o(this.getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (this.getInputType() == 0 && (accessibilityManager = this.i) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.h.f();
            return;
        }
        AutoCompleteTextView.super.showDropDown();
    }
}

