/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.widget.EditText
 *  com.google.android.material.textfield.TextInputLayout
 *  com.google.android.material.textfield.TextInputLayout$f
 *  com.google.android.material.textfield.TextInputLayout$g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.LinkedHashSet
 */
package c.e.a.a.i0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import c.e.a.a.i;
import c.e.a.a.i0.a;
import c.e.a.a.i0.m;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashSet;

public class a
extends m {
    public final TextWatcher d = new TextWatcher(this){
        public final /* synthetic */ a e;
        {
            this.e = a2;
        }

        public void afterTextChanged(Editable editable) {
            if (this.e.a.getSuffixText() != null) {
                return;
            }
            a a2 = this.e;
            boolean bl = editable.length() > 0;
            a2.e(bl);
        }

        public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }

        public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }
    };
    public final View.OnFocusChangeListener e = new View.OnFocusChangeListener(this){
        public final /* synthetic */ a e;
        {
            this.e = a2;
        }

        public void onFocusChange(View view, boolean bl) {
            boolean bl2 = android.text.TextUtils.isEmpty((CharSequence)((EditText)view).getText());
            boolean bl3 = true;
            boolean bl4 = bl2 ^ bl3;
            a a2 = this.e;
            if (!bl4 || !bl) {
                bl3 = false;
            }
            a2.e(bl3);
        }
    };
    public final TextInputLayout.f f = new TextInputLayout.f(){

        public void a(TextInputLayout textInputLayout) {
            boolean bl;
            EditText editText = textInputLayout.getEditText();
            boolean bl2 = editText.hasFocus();
            boolean bl3 = true;
            if (!bl2 || !(bl = editText.getText().length() > 0 ? bl3 : false)) {
                bl3 = false;
            }
            textInputLayout.setEndIconVisible(bl3);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.e);
            editText.removeTextChangedListener(a.this.d);
            editText.addTextChangedListener(a.this.d);
        }
    };
    public final TextInputLayout.g g = new TextInputLayout.g(){

        public void a(TextInputLayout textInputLayout, int n2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && n2 == 2) {
                editText.removeTextChangedListener(a.this.d);
                if (editText.getOnFocusChangeListener() == a.this.e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    };
    public AnimatorSet h;
    public ValueAnimator i;

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override
    public void a() {
        AnimatorSet animatorSet;
        this.a.setEndIconDrawable(f.b.l.a.a.b(this.b, c.e.a.a.e.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new View.OnClickListener(this){
            public final /* synthetic */ a e;
            {
                this.e = a2;
            }

            public void onClick(View view) {
                Editable editable = this.e.a.getEditText().getText();
                if (editable != null) {
                    editable.clear();
                }
            }
        });
        this.a.a(this.f);
        TextInputLayout textInputLayout2 = this.a;
        TextInputLayout.g g2 = this.g;
        textInputLayout2.j0.add((Object)g2);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.8f, 1.0f});
        valueAnimator.setInterpolator(c.e.a.a.l.a.d);
        valueAnimator.setDuration(150L);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c.e.a.a.i0.e(this));
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator2.setInterpolator(c.e.a.a.l.a.a);
        valueAnimator2.setDuration(100L);
        valueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c.e.a.a.i0.d(this));
        this.h = animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2});
        this.h.addListener((Animator.AnimatorListener)new c.e.a.a.i0.b(this));
        ValueAnimator valueAnimator3 = ValueAnimator.ofFloat((float[])new float[]{1.0f, 0.0f});
        valueAnimator3.setInterpolator(c.e.a.a.l.a.a);
        valueAnimator3.setDuration(100L);
        valueAnimator3.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c.e.a.a.i0.d(this));
        this.i = valueAnimator3;
        valueAnimator3.addListener((Animator.AnimatorListener)new c.e.a.a.i0.c(this));
    }

    @Override
    public void c(boolean bl) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        this.e(bl);
    }

    public final void e(boolean bl) {
        boolean bl2 = this.a.l() == bl;
        if (bl) {
            this.i.cancel();
            this.h.start();
            if (bl2) {
                this.h.end();
                return;
            }
        } else {
            this.h.cancel();
            this.i.start();
            if (bl2) {
                this.i.end();
            }
        }
    }

}

