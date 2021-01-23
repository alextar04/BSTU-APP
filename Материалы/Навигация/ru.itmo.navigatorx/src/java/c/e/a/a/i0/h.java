/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.text.TextWatcher
 *  android.text.method.KeyListener
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.AutoCompleteTextView
 *  android.widget.AutoCompleteTextView$OnDismissListener
 *  android.widget.EditText
 *  com.google.android.material.internal.CheckableImageButton
 *  com.google.android.material.textfield.TextInputLayout
 *  com.google.android.material.textfield.TextInputLayout$e
 *  com.google.android.material.textfield.TextInputLayout$f
 *  com.google.android.material.textfield.TextInputLayout$g
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.util.LinkedHashSet
 */
package c.e.a.a.i0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.i0.h;
import c.e.a.a.i0.i;
import c.e.a.a.i0.j;
import c.e.a.a.i0.k;
import c.e.a.a.i0.l;
import c.e.a.a.i0.m;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import f.b.k.h;
import java.util.LinkedHashSet;

public class h
extends m {
    public final TextWatcher d = new TextWatcher(this){
        public final /* synthetic */ h e;
        {
            this.e = h2;
        }

        public void afterTextChanged(android.text.Editable editable) {
            h h2 = this.e;
            AutoCompleteTextView autoCompleteTextView = h.e(h2, h2.a.getEditText());
            autoCompleteTextView.post(new java.lang.Runnable(this, autoCompleteTextView){
                public final /* synthetic */ AutoCompleteTextView e;
                public final /* synthetic */ a f;
                {
                    this.f = a2;
                    this.e = autoCompleteTextView;
                }

                public void run() {
                    boolean bl = this.e.isPopupShowing();
                    h.f(this.f.e, bl);
                    this.f.e.i = bl;
                }
            });
        }

        public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }

        public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }
    };
    public final View.OnFocusChangeListener e = new View.OnFocusChangeListener(this){
        public final /* synthetic */ h e;
        {
            this.e = h2;
        }

        public void onFocusChange(View view, boolean bl) {
            this.e.a.setEndIconActivated(bl);
            if (!bl) {
                h.f(this.e, false);
                this.e.i = false;
            }
        }
    };
    public final TextInputLayout.e f = new TextInputLayout.e(this, this.a){
        public final /* synthetic */ h e;
        {
            this.e = h2;
            super(textInputLayout);
        }

        public void d(View view, f.h.l.v.b b2) {
            boolean bl;
            android.os.Bundle bundle;
            super.d(view, b2);
            if (this.e.a.getEditText().getKeyListener() == null) {
                String string = android.widget.Spinner.class.getName();
                b2.a.setClassName((CharSequence)string);
            }
            if (bl = android.os.Build$VERSION.SDK_INT >= 26 ? b2.a.isShowingHintText() : (bundle = b2.f()) != null && (4 & bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0)) == 4) {
                b2.k(null);
            }
        }

        public void e(View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            ((f.h.l.a)this).a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            h h2 = this.e;
            AutoCompleteTextView autoCompleteTextView = h.e(h2, h2.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && this.e.n.isTouchExplorationEnabled()) {
                h.g(this.e, autoCompleteTextView);
            }
        }
    };
    public final TextInputLayout.f g = new TextInputLayout.f(){

        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextView;
            h h2;
            block11 : {
                g g2;
                block10 : {
                    int n2;
                    h h3;
                    block9 : {
                        autoCompleteTextView = h.e(h.this, textInputLayout.getEditText());
                        h3 = h.this;
                        n2 = h3.a.getBoxBackgroundMode();
                        if (n2 != 2) break block9;
                        g2 = h3.m;
                        break block10;
                    }
                    if (n2 != 1) break block11;
                    g2 = h3.l;
                }
                autoCompleteTextView.setDropDownBackgroundDrawable((Drawable)g2);
            }
            if ((h2 = h.this) != null) {
                if (autoCompleteTextView.getKeyListener() == null) {
                    int n3 = h2.a.getBoxBackgroundMode();
                    g g3 = h2.a.getBoxBackground();
                    int n4 = h.i.c0((View)autoCompleteTextView, c.e.a.a.b.colorControlHighlight);
                    int[][] arrarrn = new int[][]{{16842919}, new int[0]};
                    if (n3 == 2) {
                        int n5 = h.i.c0((View)autoCompleteTextView, c.e.a.a.b.colorSurface);
                        g g4 = new g(g3.e.a);
                        int n6 = h.i.P0(n4, n5, 0.1f);
                        g4.q(new ColorStateList((int[][])arrarrn, new int[]{n6, 0}));
                        g4.setTint(n5);
                        ColorStateList colorStateList = new ColorStateList((int[][])arrarrn, new int[]{n6, n5});
                        g g5 = new g(g3.e.a);
                        g5.setTint(-1);
                        f.h.l.l.V((View)autoCompleteTextView, (Drawable)new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, (Drawable)g4, (Drawable)g5), g3}));
                    } else if (n3 == 1) {
                        int n7 = h2.a.getBoxBackgroundColor();
                        f.h.l.l.V((View)autoCompleteTextView, (Drawable)new RippleDrawable(new ColorStateList((int[][])arrarrn, new int[]{h.i.P0(n4, n7, 0.1f), n7}), (Drawable)g3, (Drawable)g3));
                    }
                }
                h h4 = h.this;
                if (h4 != null) {
                    autoCompleteTextView.setOnTouchListener((View.OnTouchListener)new j(h4, autoCompleteTextView));
                    autoCompleteTextView.setOnFocusChangeListener(h4.e);
                    autoCompleteTextView.setOnDismissListener((AutoCompleteTextView.OnDismissListener)new k(h4));
                    autoCompleteTextView.setThreshold(0);
                    autoCompleteTextView.removeTextChangedListener(h.this.d);
                    autoCompleteTextView.addTextChangedListener(h.this.d);
                    textInputLayout.setEndIconCheckable(true);
                    textInputLayout.setErrorIconDrawable(null);
                    textInputLayout.setTextInputAccessibilityDelegate(h.this.f);
                    textInputLayout.setEndIconVisible(true);
                    return;
                }
                throw null;
            }
            throw null;
        }
    };
    @SuppressLint(value={"ClickableViewAccessibility"})
    public final TextInputLayout.g h = new TextInputLayout.g(){

        public void a(TextInputLayout textInputLayout, int n2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)textInputLayout.getEditText();
            if (autoCompleteTextView != null && n2 == 3) {
                autoCompleteTextView.removeTextChangedListener(h.this.d);
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    };
    public boolean i = false;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public StateListDrawable l;
    public g m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView e(h h2, EditText editText) {
        if (h2 != null) {
            if (editText instanceof AutoCompleteTextView) {
                return (AutoCompleteTextView)editText;
            }
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        throw null;
    }

    public static void f(h h2, boolean bl) {
        if (h2.j != bl) {
            h2.j = bl;
            h2.p.cancel();
            h2.o.start();
        }
    }

    public static void g(h h2, AutoCompleteTextView autoCompleteTextView) {
        if (h2 != null) {
            if (autoCompleteTextView == null) {
                return;
            }
            if (h2.i()) {
                h2.i = false;
            }
            if (!h2.i) {
                boolean bl = h2.j;
                boolean bl2 = bl ^ true;
                if (bl != bl2) {
                    h2.j = bl2;
                    h2.p.cancel();
                    h2.o.start();
                }
                if (h2.j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            h2.i = false;
            return;
        }
        throw null;
    }

    @Override
    public void a() {
        StateListDrawable stateListDrawable;
        float f2 = this.b.getResources().getDimensionPixelOffset(c.e.a.a.d.mtrl_shape_corner_size_small_component);
        float f3 = this.b.getResources().getDimensionPixelOffset(c.e.a.a.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int n2 = this.b.getResources().getDimensionPixelOffset(c.e.a.a.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g g2 = this.h(f2, f2, f3, n2);
        g g3 = this.h(0.0f, f2, f3, n2);
        this.m = g2;
        this.l = stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842922}, (Drawable)g2);
        this.l.addState(new int[0], (Drawable)g3);
        int n3 = c.e.a.a.e.mtrl_dropdown_arrow;
        this.a.setEndIconDrawable(f.b.l.a.a.b(this.b, n3));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.e.a.a.i.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ h e;
            {
                this.e = h2;
            }

            public void onClick(View view) {
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)this.e.a.getEditText();
                h.g(this.e, autoCompleteTextView);
            }
        });
        this.a.a(this.g);
        TextInputLayout textInputLayout2 = this.a;
        TextInputLayout.g g4 = this.h;
        textInputLayout2.j0.add((Object)g4);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.setInterpolator(c.e.a.a.l.a.a);
        valueAnimator.setDuration((long)67);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(this));
        this.p = valueAnimator;
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat((float[])new float[]{1.0f, 0.0f});
        valueAnimator2.setInterpolator(c.e.a.a.l.a.a);
        valueAnimator2.setDuration((long)50);
        valueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(this));
        this.o = valueAnimator2;
        valueAnimator2.addListener((Animator.AnimatorListener)new l(this));
        f.h.l.l.Z((View)this.c, (int)2);
        this.n = (AccessibilityManager)this.b.getSystemService("accessibility");
    }

    @Override
    public boolean b(int n2) {
        return n2 != 0;
    }

    @Override
    public boolean d() {
        return true;
    }

    public final g h(float f2, float f3, float f4, int n2) {
        j.b b2 = new j.b();
        b2.e = new c.e.a.a.f0.a(f2);
        b2.f = new c.e.a.a.f0.a(f2);
        b2.h = new c.e.a.a.f0.a(f3);
        b2.g = new c.e.a.a.f0.a(f3);
        c.e.a.a.f0.j j2 = b2.a();
        g g2 = g.f(this.b, f4);
        g2.e.a = j2;
        g2.invalidateSelf();
        g.b b3 = g2.e;
        if (b3.i == null) {
            b3.i = new Rect();
        }
        g2.e.i.set(0, n2, 0, n2);
        g2.invalidateSelf();
        return g2;
    }

    public final boolean i() {
        long l2 = System.currentTimeMillis() - this.k;
        return l2 < 0L || l2 > 300L;
        {
        }
    }

}

